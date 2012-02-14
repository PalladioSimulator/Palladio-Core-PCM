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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
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
import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.helper.ConstraintAndEvaluator;
import de.uka.ipd.sdq.dsexplore.helper.CriterionAndEvaluator;
import de.uka.ipd.sdq.dsexplore.helper.ObjectiveAndEvaluator;
import de.uka.ipd.sdq.dsexplore.launch.MoveInitialPCMModelPartitionJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

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
	private boolean stopOnInitialFailure;
	private MDSDBlackboard blackboard;
	
	
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator");
	
	@Inject
	public DSEEvaluator(Provider<DSEObjectives> provider) {		
		this.objectivesProvider = provider;	
	}
	
	public void init(List<IAnalysis> evaluators, IProgressMonitor monitor, MDSDBlackboard blackboard, boolean stopOnInitialFailure){
		
		this.blackboard = blackboard;
		copyPCMPartitionToAnalysisSlot(blackboard);
		
		//Give the evaluators the blackboard, because they cannot determine the objectives before that.
		for (IAnalysis iAnalysis : evaluators) {
			iAnalysis.setBlackboard(blackboard);
		}
		
		//TODO: insert evaluators properly, e.g. with Guice. 
		initCriterions(evaluators);
		this.monitor = monitor;		
		this.evaluators = evaluators;
		this.stopOnInitialFailure = stopOnInitialFailure;
		
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
		
		copyPCMPartitionToAnalysisSlot(this.blackboard);		
		
		DSEObjectives cachedObjective = this.phenotypeResultsCache.get(pheno.getGenotypeID());
		if (cachedObjective != null){ // check if constraints are evaluated --> retrieveConstraint...
			return cachedObjective;
		} else {

			//DSEObjectives obj = new DSEObjectives();
			DSEObjectives obj = objectivesProvider.get();
			try{
				
				for (IAnalysis evaluator : this.evaluators) {
					evaluator.analyse(pheno, this.monitor);
				}
				
			} catch (UserCanceledException e){
				fillObjectivesWithInfeasible(obj);
				return obj;

			} catch (Exception e){

				//If this is the first evaluation, then something severe seems to be wrong, throw an exception 
				if (!firstRunSuccessful &&  this.stopOnInitialFailure){
					e.printStackTrace();
					throw new RuntimeException("An exception was raised at the beginning, I assume it makes no sense to continue. See stacktrace for details.",e);
				} 
				// else try to retrieve the results anyway
				logger.error("Quality analysis threw exception, trying to ignoring it and retrieve results. Cause: "+e.getMessage());
				e.printStackTrace();
			}
			
			try {
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
				fillObjectivesWithInfeasible(obj);
				return obj;

			} catch (Exception e){

				return ignoreOrFailWithRuntimeException(obj, e);
			}
			
		}
	}

	private DSEObjectives ignoreOrFailWithRuntimeException(DSEObjectives obj,
			Exception e) {
		//If this is the first evaluation, then something severe seems to be wrong, throw an exception 
		if (!firstRunSuccessful &&  this.stopOnInitialFailure){
			e.printStackTrace();
			throw new RuntimeException("An exception was raised at the beginning, I assume it makes no sense to continue. See stacktrace for details.",e);
		} else {
			//if this is just a failure during the course of the run, ignore it and output it later
			//Do not discard the individual to allow a manual error tracing later
			this.exceptionList.add(new Exception("Evaluation of a candidate failed. Filling objectves with NaN.",e));
			
			fillObjectivesWithInfeasible(obj);
			fillConstraintsWithInfeasible(obj);
			return obj;
		}
	}

	private static void copyPCMPartitionToAnalysisSlot(MDSDBlackboard blackboard) {
		// copy already varied PCM instance from MoveInitialPCMModelPartitionJob.INITIAL_PCM_MODEL_PARTITION_ID
		// to analysis blackboard partition LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID
		// TODO: vary the PCM model in its own blackboard partition so that the above assumption that each 
		// candidate is evaluated right after decoding can be dropped, and even further, allow parallel 
		// blackboard partitions so that analyses can run in parallel. 
		PCMResourceSetPartition analysisPartition = (PCMResourceSetPartition)blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		ResourceSet analysisResourceSet = analysisPartition.getResourceSet();
		
		// clear any previous content.
		analysisResourceSet.getResources().clear();
		
		PCMResourceSetPartition originalModelPartition = (PCMResourceSetPartition)blackboard.getPartition(MoveInitialPCMModelPartitionJob.INITIAL_PCM_MODEL_PARTITION_ID);
		EList<Resource> resourceList = originalModelPartition.getResourceSet().getResources();
		
		Copier copier = new Copier();

		for (Resource resource : resourceList) {
			if (resource.getURI().toString().contains("pathmap")){
				//XXX: is it right that the model is not copied when a pathmap is present? hm...
				analysisPartition.loadModel(resource.getURI());
			} else {
				List<EObject> contentList = resource.getContents();
				Collection<EObject> copiedContent = copier.copyAll(contentList);
				Resource newResource = analysisResourceSet.createResource(URI.createURI(resource.getURI()+"cand."+resource.getURI().fileExtension()));
				newResource.getContents().addAll(copiedContent);
			}
		}
	    copier.copyReferences();
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
		IAnalysisResult result = o.getEvaluator().retrieveResultsFor(pheno, o.getObjective());
		obj.add(o.getObjective(),result.getValueFor(o.getCriterion()));
		obj.addResult(o.getObjective(), result);
		
		//Maybe handle a demand too large exception in the simulation separately by setting the objective to infinity. 
		
	}
	
	private void retrieveConstraint(PCMPhenotype pheno, DSEObjectives obj, ConstraintAndEvaluator o) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException {
		IAnalysisResult result = o.getEvaluator().retrieveResultsFor(pheno, o.getConstraint());
		Constraints con = obj.getConstraints();
		con.add(o.getConstraint(),result.getValueFor(o.getCriterion()));
		//con.addResult(o.getConstraint(), result); 
		
	}
	
	public void retrieveCriterion(PCMPhenotype pheno, DSEObjectives obj, CriterionAndEvaluator criterionAndEvaluator) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException {
		if (criterionAndEvaluator instanceof ObjectiveAndEvaluator){
			this.retrieveQuality(pheno, obj, (ObjectiveAndEvaluator) criterionAndEvaluator);
		} else if (criterionAndEvaluator instanceof ConstraintAndEvaluator){
			this.retrieveConstraint(pheno, obj, (ConstraintAndEvaluator) criterionAndEvaluator);
		} else {
			throw new RuntimeException("Unknown type of criterion and evaluator" + criterionAndEvaluator.getClass() +", adjust code in "+this.getClass());
		}
		
	}
	
	//@Override
	public Collection<Objective> getObjectives() {
		return new ObjectiveAndEvaluatorListDecorator(this.objectives);
	}
	
	public List<CriterionAndEvaluator> getCriterionAndEvaluatorList() {
		List<CriterionAndEvaluator> criterionAndEvaluatorList = new ArrayList<CriterionAndEvaluator>(this.objectives.size()+this.constraints.size());
		criterionAndEvaluatorList.addAll(this.objectives);
		criterionAndEvaluatorList.addAll(this.constraints);
		return criterionAndEvaluatorList;
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


	public void addToPhenotypeCache(String genotypeID, DSEObjectives oc){
		this.phenotypeResultsCache.put(genotypeID, oc);
	}

	public IProgressMonitor getMonitor() {
		return this.monitor;
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



