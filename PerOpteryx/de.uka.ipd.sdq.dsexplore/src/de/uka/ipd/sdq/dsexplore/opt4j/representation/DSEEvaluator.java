package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsage;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.ObjectiveAndEvaluator;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * The Evaluator is responsible for determining the objective functions values 
 * for an individual based on the phenotype (i.e. the PCM instance). Thus, 
 * it calls the simulation or LQN solver for performance and also a cost 
 * evaluator. 
 * 
 * It is a singleton  
 * 
 * @author Anne
 * 
 */
public class DSEEvaluator implements Evaluator<PCMPhenotype>{
	
	protected List<ObjectiveAndEvaluator> objectives;
	
	private List<Exception> exceptionList = new ArrayList<Exception>();
	
	private boolean firstRunSuccessful = false;

	//@SuppressWarnings("unused")
	//private Map<Objective,DSEConstraint> constraints;
	
	private Map<String, DSEObjectives> phenotypeResultsCache = new HashMap<String, DSEObjectives>();

	private List<IAnalysis> evaluators;

	private IProgressMonitor monitor;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator");
	
	public DSEEvaluator(){}
	
	public void init(List<IAnalysis> evaluators, IProgressMonitor monitor, MDSDBlackboard blackboard){
		
		//Give the evaluators the blackboard, because they cannot determine the objectives before that.
		for (IAnalysis iAnalysis : evaluators) {
			iAnalysis.setBlackboard(blackboard);
		}
		
		//TODO: insert evaluators properly, e.g. with Guice. 
		this.objectives = initObjectives(evaluators);
		this.monitor = monitor;		
		this.evaluators = evaluators;
		
		
	}


	/**
	 * Creates a new list of Objective and fills it according to the passed evaluators. 
	 * @param evaluators
	 * @return a new list.
	 */
	private static List<ObjectiveAndEvaluator> initObjectives(List<IAnalysis> evaluators) {
		List<ObjectiveAndEvaluator> objectives = new ArrayList<ObjectiveAndEvaluator>();
		for (IAnalysis analysis : evaluators) {
			try {
				//Objective quality = new Objective(analysis.getQualityAttribute(), Objective.Sign.MIN);
				//objectives.add(new ObjectiveAndEvaluator(quality, analysis));
				List<Objective> objectiveList = analysis.getObjectives();
				for (Objective objective : objectiveList) {
					objectives.add(new ObjectiveAndEvaluator(objective, analysis));
				}
			} catch (CoreException e){
				logger.error("Could not load quality attribute evaluator "+analysis.getClass());
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return objectives;
	}
	

	public void reset(){
		this.firstRunSuccessful = false;
		this.exceptionList = new ArrayList<Exception>();
	}

	/**
	 * The current implicit assumption is that each candidate is evaluated right after 
	 * it has been decoded, or never.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public DSEObjectives evaluate(PCMPhenotype pheno) {
		
		DSEObjectives cachedObjective = this.phenotypeResultsCache.get(pheno.getGenotypeID());
		if (cachedObjective != null){
			return cachedObjective;
		} else {

			DSEObjectives obj = new DSEObjectives();
			try{
				
				for (IAnalysis evaluator : this.evaluators) {
					evaluator.analyse(this.monitor);
				}
				
				for (int i = 0; i < objectives.size() ; i++) {
					retrieveQuality(pheno, obj, this.objectives.get(i));
				}

				//retrieveCost(pheno, obj, this.objectives.get(objectives.size() -1));

				firstRunSuccessful = true;
				
				this.phenotypeResultsCache.put(pheno.getGenotypeID(), obj);
				return obj;

			} catch (UserCanceledException e){
				Opt4JStarter.terminate();
				fillObjectivesWithInfeasible(obj);
				return obj;

			} catch (Exception e){

				//If this is the first evaluation, then something severe seems to be wrong, throw an exception 
				if (!firstRunSuccessful){
					e.printStackTrace();
					throw new RuntimeException("An exception was raised at the beginning, I assume it makes no sense to continue. See stacktrace for details.",e);
				} else {
					//if this is just a failure during the course of the run, ignore it and output it later
					this.exceptionList.add(new Exception("Evaluation of a candidate failed. Filling objectves with NaN.",e));

					fillObjectivesWithInfeasible(obj);
					return obj;
				}
			}
			
		}
	}


	private void fillObjectivesWithInfeasible(Objectives obj) {
		for (int i = 0; i < objectives.size(); i++) {
			//Check if the given quality is there. If not, add a value at that index.
			if (obj.size() == i){
				addInfeasibleValue(obj,i);
			}
		}
	}

	private void retrieveQuality(PCMPhenotype pheno, DSEObjectives obj, ObjectiveAndEvaluator o) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException {
		//retrieve response time
		IAnalysisResult result = o.getEvaluator().retrieveLastResultsForObjective(o.getObjective());
		obj.add(o.getObjective(),result.getMeanValue());
		obj.addResult(o.getObjective(), result);
		
		//Maybe handle a demand too large exception in the simulation separately by setting the objective to infinity. 
		
	}
	
	@Override
	public Collection<Objective> getObjectives() {
		return new ObjectiveAndEvaluatorListDecorator(this.objectives);
	}
	
	public List<ObjectiveAndEvaluator> getObjectiveAndEvaluatorList() {
		return this.objectives;
	}
	
	//TODO: Add an interface ExceptionTracker to unify exception handling. 
	public List<Exception> getExceptionList(){
		return this.exceptionList;
	}
	
	private Double getInfeasibleValue(ObjectiveAndEvaluator objectiveAndEvaluator){
		if (objectiveAndEvaluator.getObjective().getSign().equals(Objective.Sign.MAX)){
			return Double.NEGATIVE_INFINITY;
		} else {
			return Double.POSITIVE_INFINITY;
		}
			
	}
	
	private void addInfeasibleValue(Objectives obj, int objectiveIndex){
		obj.add(this.objectives.get(objectiveIndex).getObjective(), getInfeasibleValue(this.objectives.get(objectiveIndex)));
	}

	public void retainOnlyEvaluatorsFor(List<ObjectiveAndEvaluator> orderedObjectives) {
		
		this.objectives.retainAll(orderedObjectives);
				
	}
	
	public void addToPhenotypeCache(String genotypeID, DSEObjectives oc){
		this.phenotypeResultsCache.put(genotypeID, oc);
	}
	
}

/**
 * This decorator list is quite inefficient for any access operations, 
 * but it saves the effort to create a new Collection<Objective> for our
 * getObjectives methods each time a candidate is evaluated. 
 *   
 * @author martens
 *
 */
class ObjectiveAndEvaluatorListDecorator implements Collection<Objective> {
	
	private static final String NOT_MODIFIABLE_MSG = "Collection ObjectiveAndEvaluatorListDecorator is not modifiable.";
	
	private Collection<ObjectiveAndEvaluator> decoratedCollection;

	public ObjectiveAndEvaluatorListDecorator(final Collection<ObjectiveAndEvaluator> decoratedCollection){
		this.decoratedCollection = decoratedCollection;
	}
	
	public int size(){
		return decoratedCollection.size();
	}

	@Override
	public boolean add(Objective e) {
		throw new UnsupportedOperationException(NOT_MODIFIABLE_MSG);
	}

	@Override
	public boolean addAll(Collection<? extends Objective> c) {
		throw new UnsupportedOperationException(NOT_MODIFIABLE_MSG);
	}

	@Override
	public void clear() {
		this.decoratedCollection.clear();
	}
	
	private ObjectiveAndEvaluator findObjective(Object o){
		if (!(o instanceof Objective))
			return null;
		for (ObjectiveAndEvaluator oe : this.decoratedCollection) {
			if (oe.getObjective().equals(o))
				return oe;
		}
		return null;
	}

	@Override
	public boolean contains(Object o) {
		if (findObjective(o) != null)
			return true;
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object object : c) {
			if (!contains(object)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return decoratedCollection.isEmpty();
	}

	@Override
	public Iterator<Objective> iterator() {
		return new ObjectiveAndEvaluatorListIterator(this.decoratedCollection.iterator());
	}

	@Override
	public boolean remove(Object o) {
		ObjectiveAndEvaluator foundOE = findObjective(o);
		if (foundOE == null){
			return false;
		} else {
			return decoratedCollection.remove(foundOE);
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean removedAll = false;
		for (Object object : c) {
			removedAll = removedAll || this.remove(object);
		}
		return removedAll;
	}

	/**
	 * Retains all elements in this collection that are contained in c or whose Objective is contained in c. 
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		Iterator<ObjectiveAndEvaluator> it = this.decoratedCollection.iterator();
		while (it.hasNext()){
			ObjectiveAndEvaluator oe = it.next();
			if (!c.contains(oe) && !c.contains(oe.getObjective())){
				modified = true;
				it.remove();
			}
		}
		return modified;
	}

	@Override
	public Object[] toArray() {
		Objective[] array = new Objective[this.decoratedCollection.size()];
		int i = 0;
		for (ObjectiveAndEvaluator oe : this.decoratedCollection) {
			array[i++] = oe.getObjective();
		}
		
		return array;
	}

	/**
	 * Copied from LinkedList and modified. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < decoratedCollection.size())
			a = (T[])java.lang.reflect.Array.newInstance(
					a.getClass().getComponentType(), decoratedCollection.size());
		
		int i = 0;
		Object[] result = a;
		
		for (ObjectiveAndEvaluator oe : decoratedCollection) {
			result[i++] = oe.getObjective();
		}
		
		
		if (a.length > decoratedCollection.size()){
			for(int j = i; j < a.length; j++){
				result[j] = null;
			}
		}

		return a;

	}
	
}

class ObjectiveAndEvaluatorListIterator implements Iterator<Objective>{
	
	private Iterator<ObjectiveAndEvaluator> decoratedIterator;

	public ObjectiveAndEvaluatorListIterator(Iterator<ObjectiveAndEvaluator> it){
		this.decoratedIterator = it;
	}

	@Override
	public boolean hasNext() {
		return decoratedIterator.hasNext();
	}

	@Override
	public Objective next() {
		return decoratedIterator.next().getObjective();
	}

	@Override
	public void remove() {
		decoratedIterator.remove();
	}
	
}


