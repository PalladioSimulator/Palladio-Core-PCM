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
import org.opt4j.core.Constraint;
import org.opt4j.core.Constraints;
import org.opt4j.core.Criterion;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.ConstraintAndEvaluator;
import de.uka.ipd.sdq.dsexplore.helper.ObjectiveAndEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
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
	protected List<ConstraintAndEvaluator> constraints;
	
	private List<Exception> exceptionList = new ArrayList<Exception>();
	
	private boolean firstRunSuccessful = false;

	//@SuppressWarnings("unused")
	//private Map<Objective,DSEConstraint> constraints;
	
	private Map<String, DSEObjectives> phenotypeResultsCache = new HashMap<String, DSEObjectives>();

	private List<IAnalysis> evaluators;

	private IProgressMonitor monitor;
	private Provider<DSEObjectives> objectivesProvider;
	
	
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator");
	
	@Inject
	public DSEEvaluator(Provider<DSEObjectives> provider) {		
		this.objectivesProvider = provider;	
	}
	
	public void init(List<IAnalysis> evaluators, IProgressMonitor monitor, MDSDBlackboard blackboard){
		
		//Give the evaluators the blackboard, because they cannot determine the objectives before that.
		for (IAnalysis iAnalysis : evaluators) {
			iAnalysis.setBlackboard(blackboard);
		}
		
		//TODO: insert evaluators properly, e.g. with Guice. 
		initCriterions(evaluators);
		this.monitor = monitor;		
		this.evaluators = evaluators;
		
		
	}

	/**
	 * Fills the Criterions according to the passed evaluators. 
	 * @param evaluators
	 * @return a new list.
	 */
	private void initCriterions(List<IAnalysis> evaluators) {
		this.objectives = new ArrayList<ObjectiveAndEvaluator>();
		this.constraints = new ArrayList<ConstraintAndEvaluator>();
		for (IAnalysis analysis : evaluators) {
			try {
				//Objective quality = new Objective(analysis.getQualityAttribute(), Objective.Sign.MIN);
				//objectives.add(new ObjectiveAndEvaluator(quality, analysis));
				List<Criterion> criterionList = analysis.getCriterions();
				for (Criterion criterion : criterionList) {
					if (criterion instanceof Objective) {
						this.objectives.add(new ObjectiveAndEvaluator((Objective)criterion, analysis));
					} else if (criterion instanceof Constraint) {
						this.constraints.add(new ConstraintAndEvaluator((Constraint)criterion, analysis));
					}
				}
			} catch (CoreException e){
				logger.error("Could not load quality attribute evaluator "+analysis.getClass());
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		//return objectives;
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
		if (cachedObjective != null){ // check if constraints are evaluated --> retrieveConstraint...
			return cachedObjective;
		} else {

			//DSEObjectives obj = new DSEObjectives();
			DSEObjectives obj = objectivesProvider.get();
			try{
				
				for (IAnalysis evaluator : this.evaluators) {
					evaluator.analyse(this.monitor);
				}
				
				for (int i = 0; i < objectives.size() ; i++) {
					retrieveQuality(pheno, obj, this.objectives.get(i));
				}
				
				for (int i = 0; i < constraints.size(); i++) {
					retrieveConstraint(pheno, obj, this.constraints.get(i));
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
					//noorshams: Why not discard the individual?
					this.exceptionList.add(new Exception("Evaluation of a candidate failed. Filling objectves with NaN.",e));
					
					fillObjectivesWithInfeasible(obj);
					fillConstraintsWithInfeasible(obj);
					return obj;
				}
			}
			
		}
	}

	private void fillConstraintsWithInfeasible(Objectives obj) {
		
		//Just fill with NaN
		Constraints con = obj.getConstraints();
		for (int i = 0; i < constraints.size(); i++) {
			con.add(this.constraints.get(i).getConstraint(),new DoubleValue(Double.NaN));
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
		IAnalysisResult result = o.getEvaluator().retrieveLastResultsForCriterion(o.getObjective());
		obj.add(o.getObjective(),result.getValue());
		obj.addResult(o.getObjective(), result);
		
		//Maybe handle a demand too large exception in the simulation separately by setting the objective to infinity. 
		
	}
	
	private void retrieveConstraint(PCMPhenotype pheno, DSEObjectives obj, ConstraintAndEvaluator o) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException {
		IAnalysisResult result = o.getEvaluator().retrieveLastResultsForCriterion(o.getConstraint());
		Constraints con = obj.getConstraints();
		con.add(o.getConstraint(),result.getValue());
		//con.addResult(o.getConstraint(), result); 
		
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


