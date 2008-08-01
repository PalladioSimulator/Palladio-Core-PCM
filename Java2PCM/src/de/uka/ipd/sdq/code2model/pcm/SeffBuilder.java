package de.uka.ipd.sdq.code2model.pcm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.dom.IfStatement;

import de.uka.ipd.sdq.code2model.analysis.AST2SeffTranslator;
import de.uka.ipd.sdq.code2model.pcm.resourcedemands.DefaultResourceDemandFactory;
import de.uka.ipd.sdq.code2model.pcm.resourcedemands.ResourceDemandFactory;
import de.uka.ipd.sdq.code2model.ui.UserMessage;
import de.uka.ipd.sdq.code2model.wrappers.Method;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * SeffBuilder builds a {@link ResourceDemandingSEFF}.
 * <p>
 * The visitor notifies the {@link AST2SeffTranslator} about each AST part it
 * considers relevant for the RDSEFF. The translator extracts the relevant info
 * out of the JDT classes, traces input parameters, etc., then calls the
 * SeffBuilder. The builder creates the PCM objects corresponding to the AST
 * elements and adds them to the RDSEFF at the right places. It can decide to
 * not add an element, or to add it at a later time to abstract from the actual
 * source code.
 * </p>
 * <p>
 * The SeffBuilder is stateful.
 * </p>
 * 
 * @author thomas
 */
public class SeffBuilder {
	private ResourceDemandFactory rdFactory;
	private Code2ModelRepository repository;
	private SeffFactory seffFactory;
	private ParameterFactory parameterFactory;

	/**
	 * Records the behaviours we are working with, so that new actions are
	 * always added to the correct one.
	 */
	private Stack<ResourceDemandingBehaviour> behaviours;
	/**
	 * Records the active branch actions, so that new branch transitions are
	 * always added to the correct one.
	 */
	private Stack<BranchAction> branchActions;
	/**
	 * Records the active branch transitions, to enable checks concerning the
	 * branch conditions, merging branches, etc.
	 */
	private Stack<GuardedBranchTransition> transitions;
	/**
	 * Records all branch conditions leading up to the current point in the
	 * code, so branch transitions can get the full conditional.
	 */
	private Stack<String> transitionConditions;
	/**
	 * Records for each request for a new transition whether it has really been
	 * created or if it has been merged with a previous one. The information is
	 * needed when a notification to end a transition comes.
	 */
	private Stack<Boolean> transitionMergeRecord;
	/**
	 * Records for each request for a new branch whether it has really been
	 * created or if it has been merged with a previous one. The information is
	 * needed when a notification to end a branch comes.
	 */
	private Stack<Boolean> branchCreationRecord;
	private Logger logger;
	private StoexFactory stoexFactory;
	private CoreFactory coreFactory;

	public SeffBuilder() {
		this.seffFactory = SeffFactory.eINSTANCE;
		this.behaviours = new Stack<ResourceDemandingBehaviour>();
		this.branchActions = new Stack<BranchAction>();
		this.transitions = new Stack<GuardedBranchTransition>();
		this.transitionConditions = new Stack<String>();
		this.transitionMergeRecord = new Stack<Boolean>();
		this.branchCreationRecord = new Stack<Boolean>();

		this.repository = new Code2ModelRepository();
		this.rdFactory = decideOnResourceDemandFactory();
		this.parameterFactory = ParameterFactory.eINSTANCE;
		this.stoexFactory = StoexFactory.eINSTANCE;		
		this.coreFactory = CoreFactory.eINSTANCE;
		
		List foo = new ArrayList();
		
		this.logger = Logger.getLogger(this.getClass());
	}

	/**
	 * Decide from the user preferences how to handle resource demands: use the
	 * default or use the preferences.
	 * <p>
	 * User preferences for resource demands are not implemented so far, you
	 * always get a {@link DefaultResourceDemandFactory}.
	 * </p>
	 * 
	 * @return the correct factory
	 */
	private ResourceDemandFactory decideOnResourceDemandFactory() {
		return new DefaultResourceDemandFactory();
	}

	/**
	 * Create a new {@link ResourceDemandingBehaviour}, including
	 * {@link StartAction} and {@link StopAction}.
	 * 
	 * @return the new behaviour
	 */
	private ResourceDemandingBehaviour createRDBehaviour() {
		ResourceDemandingBehaviour rdBehaviour = seffFactory
				.createResourceDemandingBehaviour();
		StartAction startAction = this.seffFactory.createStartAction();
		rdBehaviour.getSteps_Behaviour().add(startAction);

		/* We create the stop action here already */
		StopAction stopAction = this.seffFactory.createStopAction();
		rdBehaviour.getSteps_Behaviour().add(stopAction);
		startAction.setSuccessor_AbstractAction(stopAction);

		return rdBehaviour;
	}

	/**
	 * Closes the current {@link ResourceDemandingBehaviour} (can be the
	 * {@link ResourceDemandingSEFF} itself).
	 */
	public void endBehaviour() {
		ResourceDemandingBehaviour rdBehav = this.behaviours.pop();
		int stopActionIndex = rdBehav.getSteps_Behaviour().size() - 1;
		StopAction stopAction = (StopAction) rdBehav.getSteps_Behaviour().get(
				stopActionIndex);
		AbstractAction lastAction = rdBehav.getSteps_Behaviour().get(
				stopActionIndex - 1);
		stopAction.setPredecessor_AbstractAction(lastAction);
	}

	/**
	 * Determine if the given {@link ResourceDemandingBehaviour} has any actions
	 * beside Start and Stop.
	 * 
	 * @param behaviour
	 *            the behaviour to check
	 * @return if the behaviour is empty
	 */
	private boolean behaviourIsEmpty(ResourceDemandingBehaviour behaviour) {
		// 3 = StartAction + StopAction + at least one other action
		if (behaviour.getSteps_Behaviour().size() < 3) {
			return true;
		}
		return false;
	}

	/**
	 * Add a branch to the current behaviour.
	 * 
	 * @param description a description for human readers of the SEFF
	 */
	private void branch(String description) {
		BranchAction branchAction = this.seffFactory.createBranchAction();
		branchAction.setEntityName(description);
		addActionToBehaviour(branchAction);
		this.branchActions.push(branchAction);
	}

	/**
	 * End the current branch.
	 */
	private void endBranch() {
		this.branchActions.pop();
	}

	/**
	 * Add a new transition to the given {@link BranchAction}.
	 * 
	 * @param branchAction
	 *            the action to add the transition to
	 * @param condStr
	 *            the transition's condition
	 */
	private void addBranchTransition(BranchAction branchAction, String condStr) {
		GuardedBranchTransition transition = this.seffFactory
				.createGuardedBranchTransition();
		//GuardedBranchTransition condition = this.seffFactory.createGuardedBranchTransition();
		
		PCMRandomVariable randomVariable = coreFactory.createPCMRandomVariable();
		randomVariable.setSpecification(condStr);		
		//condition.setBranchCondition_GuardedBranchTransition(randomVariable);
		//transition.setBranchCondition_BranchTransition(condition);
		transition.setBranchCondition_GuardedBranchTransition(randomVariable);

		ResourceDemandingBehaviour branchBehaviour = this.createRDBehaviour();
		transition.setBranchBehaviour_BranchTransition(branchBehaviour);
		branchAction.getBranches_Branch().add(transition);

		this.behaviours.push(branchBehaviour);
		this.transitions.push(transition);
	}

	/**
	 * Add an action to the current behaviour.
	 * 
	 * @param action
	 *            the action to be added
	 */
	private void addActionToBehaviour(AbstractAction action) {
		ResourceDemandingBehaviour behaviour = this.behaviours.peek();

		// -2 because the behaviour already has the stop action, we want to
		// insert before that.
		int previousActionIndex = behaviour.getSteps_Behaviour().size() - 2;
		AbstractAction previousAction = behaviour.getSteps_Behaviour().get(
				previousActionIndex);

		// Special case for forks: if several threads are started consecutively
		// ("a.start(); b.start(); ..."), we want their behaviours in one
		// ForkAction to abstract from the code. But we cannot recognize this in
		// the ASTVisitor, so we check if we are requested to add a ForkAction
		// here and if the last action was also a ForkAction. In this case we
		// don't create a new ForkAction but reuse the previous one.
		if ((previousAction instanceof ForkAction)
				&& (action instanceof ForkAction)) {
			return;
		}

		previousAction.setSuccessor_AbstractAction(action);
		behaviour.getSteps_Behaviour().add(previousActionIndex + 1, action);
	}

	/**
	 * A method declaration yields a new {@link ResourceDemandingSEFF}.
	 * <p>
	 * The corresponding signature in the provided interface must already be
	 * present!
	 * </p>
	 * 
	 * @param declaredMethod
	 *            the wrapped method
	 * @param declaringOrOverwritingClass
	 *            the class that declares or overwrites this method
	 */
	public void methodDeclaration(Method declaredMethod) {
		ResourceDemandingSEFF rdSeff = seffFactory
				.createResourceDemandingSEFF();
		rdSeff.setSeffTypeID("0");

		String declaringOrOverwritingClass = declaredMethod.getQualifiedDeclaringClassName();
		Signature sig = this.repository.getSignature(declaredMethod);
		if (sig == null) {
			logger.error("No signature found for class " + 
						 declaringOrOverwritingClass + 
						 ", method " + declaredMethod);
			return;
		}
		rdSeff.setDescribedService__SEFF(sig);

		StartAction startAction = this.seffFactory.createStartAction();
		rdSeff.getSteps_Behaviour().add(startAction);
		StopAction stopAction = this.seffFactory.createStopAction();
		rdSeff.getSteps_Behaviour().add(stopAction);

		BasicComponent component = this.repository.getComponent(declaringOrOverwritingClass);
		if (component == null) {
			UserMessage.displayErrorMessage("No component with name " + 
					declaringOrOverwritingClass + " found, for method " + declaredMethod);
			return;
		}
		component.getServiceEffectSpecifications__BasicComponent().add(rdSeff);

		this.behaviours.push(rdSeff);
	}

	/**
	 * Determine if a requested branch transition can be merged with a previous
	 * one.
	 * <p>
	 * This is the case when
	 * <ul>
	 * <li>there is a previous transition, and</li>
	 * <li>its behaviour is empty, i.e., there were no actions in between the
	 * two transitions.</li>
	 * </ul>
	 * </p>
	 * 
	 * @return whether they can be merged
	 */
	private boolean transitionCanBeMerged() {
		if (this.transitions.size() != 0) {
			// Modify this one instead of creating a new one, if there haven't
			// been any actions in between.
			ResourceDemandingBehaviour branchBehaviour = this.transitions
					.peek().getBranchBehaviour_BranchTransition();
			if (behaviourIsEmpty(branchBehaviour)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates a new {@link BranchTransition} for if/else statements.
	 * <p>
	 * The new transition is added to the last {@link BranchAction}. However,
	 * if the last action added to the current
	 * {@link ResourceDemandingBehaviour} was a {@link BranchAction}, and this
	 * one already has at least one transition, the last transition is reused
	 * because we want to abstract from the source code in the
	 * {@link ResourceDemandingSEFF}.
	 * </p>
	 * 
	 * @param conditional
	 *            the condition
	 * @param isElseBranch
	 *            is it an else branch? - the condition has to be negated then
	 */
	public void branchTransition(String conditional, boolean isElseBranch) {
		String cond = conditional;
		if (isElseBranch) {
			cond = "NOT (" + cond + ")";
		}
		this.transitionConditions.push(cond);

		// For nested conditionals, we abstract from the code and merge the
		// branches into one.
		if (transitionCanBeMerged()) {
			PCMRandomVariable prevCondition = this.transitions.peek().getBranchCondition_GuardedBranchTransition();
			//BranchCondition prevCondition = this.transitions.peek()
			//		.getBranchCondition_BranchTransition();
			prevCondition.setSpecification(getCurrentTransitionCondition());
			this.transitions.peek().setBranchCondition_GuardedBranchTransition(prevCondition);
			this.transitionMergeRecord.push(true);
		// The last action was something different, so we create a new
		// BranchTransition.
		} else {
			addBranchTransition(this.branchActions.peek(),
					getCurrentTransitionCondition());
			this.transitionMergeRecord.push(false);
		}
	}

	private String getCurrentTransitionCondition() {
		String condition = "";
		for (String curCond : this.transitionConditions) {
			condition += "(" + curCond + ")" + " AND ";
		}
		condition = condition.substring(0, condition.length() - 4);
		return condition;
	}

	/**
	 * End a {@link BranchTransition}.
	 */
	public void endBranchTransition() {
		this.transitionConditions.pop();
		if (this.transitionMergeRecord.pop() == false) {
			endBehaviour();
			this.transitions.pop();
		}
	}

	/**
	 * Open a general loop in the current behaviour.
	 * 
	 * @param loopExp
	 *            the loop expression (condition)
	 */
	public void loopStatement(String loopExp) {
		LoopAction loopAction = this.seffFactory.createLoopAction();
		
		PCMRandomVariable randomVariable = this.coreFactory.createPCMRandomVariable();
		randomVariable.setSpecification(loopExp);
		loopAction.setIterationCount_LoopAction(randomVariable);

		addLoop(loopAction);
	}
	
	/**
	 * Open an iterating loop in the current behaviour.
	 * 
	 * @param collectionExpression
	 */
	public void collectionIterator(String collectionExpression) {
		CollectionIteratorAction itAction = this.seffFactory
				.createCollectionIteratorAction();

		List<Parameter> matchingParams = 
				findMatchingServiceParams(collectionExpression);

		if (matchingParams.size() > 1) {
			logger.warn("More than one parameter matches for collection iteration: "
							+ matchingParams.toString()
							+ " in expression "
							+ collectionExpression);
		}

		try {
			itAction.setParameter_CollectionIteratorAction(matchingParams
					.get(0));
		} catch (IndexOutOfBoundsException e) {
			logger.warn("No parameter found for the collection iteration over "
					+ collectionExpression);
		}
		
		itAction.setEntityName(collectionExpression);
		addLoop(itAction);
	}

	/**
	 * In an expression given as String, find occurences of parameters of the
	 * current service.
	 * 
	 * @param collectionExpression
	 *            the expression to check for parameters
	 * @return the list of matching parameters
	 */
	private List<Parameter> findMatchingServiceParams(String collectionExpression) {
		List<Parameter> matchingParams = new ArrayList<Parameter>();

		ResourceDemandingSEFF rdseff = (ResourceDemandingSEFF) this.behaviours
				.get(0);
		Signature providedSig = rdseff.getDescribedService__SEFF();
		List<Parameter> params = providedSig.getParameters__Signature();
		for (Parameter param : params) {
			if (collectionExpression.matches(".*" + param.getParameterName() + ".*")) {
				matchingParams.add(param);
			}
		}
		return matchingParams;
	}

	/**
	 * Add an {@link AbstractLoopAction} to the current behaviour.
	 * 
	 * @param loopAction the action to add
	 */
	private void addLoop(AbstractLoopAction loopAction) {
		addActionToBehaviour(loopAction);

		ResourceDemandingBehaviour loopBehaviour = this.createRDBehaviour();
		loopAction.setBodyBehaviour_Loop(loopBehaviour);
		this.behaviours.push(loopBehaviour);
	}
	
	/**
	 * Create a new {@link InternalAction}, usually for relevant Java API
	 * calls.
	 * 
	 * @param args
	 *            a list of the method parameters
	 * @param packageName
	 *            the name of the invoked method's package
	 * @param methodName
	 *            the name of the invoked method
	 */
	public void internalAction(List<String> args, String packageName,
			String methodName) {
		InternalAction intAction = this.seffFactory.createInternalAction();
		String name = methodName + "(" + args.toString() + ")";
		intAction.setEntityName(name);
		ParametricResourceDemand demand = this.rdFactory.createResourceDemand(
				args, packageName, methodName);
		intAction.getResourceDemand_Action().add(demand);
		addActionToBehaviour(intAction);
	}

	/**
	 * Create a new {@link InternalAction} in the current RDSEFF.
	 * <p>
	 * This one, where only the description is given, is for "placeholder" or
	 * "informative" actions, e.g., for indicating recursive method calls. For
	 * resource demanding internal actions such as Java API calls, use
	 * {@link #internalAction(List, String, String)} where you can give the
	 * package and method name for classifying the invoked method.
	 * </p>
	 * 
	 * @param description
	 *            the textual description, i.e., the entity name
	 */
	public void internalAction(String description) {
		InternalAction intAction = this.seffFactory.createInternalAction();
		intAction.setEntityName(description);
		ParametricResourceDemand demand = this.rdFactory.getNewCPUDemand();
		intAction.getResourceDemand_Action().add(demand);
		addActionToBehaviour(intAction);
	}

	/**
	 * Create a new {@link ExternalCallAction} for method invocations outside
	 * our package.
	 * 
	 * @param calledMethod
	 *            the wrapped invoked method
	 * @param influencingParams
	 *            the service parameters being used in the call
	 * @param callingClassName 
	 */
	public void externalCall(Method calledMethod, Set<String> influencingParams, 
							 String callingClassName) {
		Signature sig = this.repository.getSignature(calledMethod);
		
		ExternalCallAction extAction = this.seffFactory
				.createExternalCallAction();
		extAction.setCalledService_ExternalService(sig);
		extAction.setEntityName(sig.getServiceName());

		for (String param : influencingParams) {
			addVariableUsage(extAction, param);
		}

		addActionToBehaviour(extAction);
		
		this.repository.createRequiredRoleForExternalCall(calledMethod, callingClassName);
	}

	private void addVariableUsage(ExternalCallAction extAction, String paramName) {
		VariableUsage v = this.parameterFactory.createVariableUsage();
		AbstractNamedReference ref = stoexFactory.createVariableReference();
		ref.setReferenceName(paramName);
		v.setNamedReference_VariableUsage(ref);
		//extAction.getParameterUsage_ExternalCallAction() // PCM 3.x has distinction between in and out
		extAction.getInputParameterUsages_ExternalCallAction().add(v);
	}

	/**
	 * Open a switch/case block in the current behaviour.
	 */
	public void switchStatement(String description) {
		this.branchCreationRecord.push(true);
		branch(description);
	}

	/**
	 * Add a new case to the current switch-case statement.
	 * 
	 * @param condition
	 *            the case condition (previous conditions can be included if
	 *            there was no break statement)
	 */
	public void switchCase(String condition) {
		addBranchTransition(this.branchActions.peek(), condition);
	}

	/**
	 * End the current switch case.
	 */
	public void endSwitchCase() {
		endBehaviour();
		this.transitions.pop();
	}

	/**
	 * Ends the current switch-case statement.
	 */
	public void endSwitchStatement() {
		// Check for empty cases. These cannot be recognized at parsing time by
		// the BlockRelevancyClassifier because switch cases are not nested in
		// the AST, but appear after one another.
		BranchAction switchAction = this.branchActions.peek();
		List<AbstractBranchTransition> transitions = new ArrayList<AbstractBranchTransition>(
				switchAction.getBranches_Branch());
		for (AbstractBranchTransition curTrans : transitions) {
			ResourceDemandingBehaviour behav = curTrans
					.getBranchBehaviour_BranchTransition();
			if (behaviourIsEmpty(behav)) {
				switchAction.getBranches_Branch().remove(curTrans);
			}
		}

		this.branchCreationRecord.pop();
		endBranch();
		endBehaviour();
	}

	/**
	 * Find the last action of a {@link ResourceDemandingBehaviour}, before the
	 * StopAction.
	 * 
	 * @param behaviour
	 *            the behaviour of which to get the last action
	 * @return the last action
	 */
	private AbstractAction getLastAction(ResourceDemandingBehaviour behaviour) {
		int numSteps = behaviour.getSteps_Behaviour().size();
		// -2 because the StopAction is already present
		return behaviour.getSteps_Behaviour().get(numSteps - 2);
	}

	/**
	 * Open a new {@link IfStatement} in the current behaviour.
	 */
	public void ifStatement(String description) {
		if (previousBranchCanBeReused()) {
			this.branchCreationRecord.push(false);
		} else {
			this.branchCreationRecord.push(true);
			branch(description);
		}
	}

	/**
	 * Decide if, when a new branch is requested, an existing one should be
	 * reused to abstract from the source code.
	 * 
	 * We can merge with a previous branch if the following condition holds: the
	 * current behaviour is empty and the last action of the previous behaviour
	 * is a BranchAction. This is the case when a branch has been opened, but
	 * has no relevant actions itself, only in branches contained therein.
	 * 
	 * @return whether an existing branch can be reused (if not, a new has to be
	 *         created)
	 */
	private boolean previousBranchCanBeReused() {
		int numBehavs = this.behaviours.size();
		if (numBehavs < 2) {
			// We are at the beginning of the analysis (the first behaviour is
			// the RDSEFF itself).
			return false;
		}
		ResourceDemandingBehaviour superBehaviour = this.behaviours
				.get(numBehavs - 2);
		AbstractAction lastAction = getLastAction(superBehaviour);

		return (behaviourIsEmpty(this.behaviours.peek()) && 
				lastAction instanceof BranchAction);
	}

	/**
	 * Close the current {@link IfStatement}.
	 */
	public void endIfStatement() {
		if (this.branchCreationRecord.pop() == true) {
			endBranch();
		}
	}

	/**
	 * Open a {@link ForkAction} in the current behaviour.
	 */
	public void fork() {
		ForkAction forkAction = this.seffFactory.createForkAction();
		addActionToBehaviour(forkAction);

		// we know that ForkedBehaviour is ResourceDemandingBehaviour FIXME: make new createRDBehaviour() method
		ForkedBehaviour threadBehaviour = (ForkedBehaviour) this.createRDBehaviour();
		
		forkAction.getAsynchronousForkedBehaviours_ForkAction().add(threadBehaviour);
		this.behaviours.push(threadBehaviour);
	}

	/**
	 * Save the repository in serialized XMI form at the given location.
	 * 
	 * @param location
	 *            the path, including file name, where to save
	 * @param repositoryName 
	 * @throws IOException
	 */
	public void saveRDSEFF(URI location, String repositoryName) throws IOException {
		this.repository.save(location, repositoryName);
	}

	/**
	 * Create a new component. Just a pass-through to the repository to preserve
	 * the pipeline architecture.
	 * 
	 * @param name
	 *            the name to give to the component
	 */
	public void newComponent(String name) {
		this.repository.createComponent(name);	
	}

	/**
	 * Add a signature to the given interface.  Just a pass-through to
	 * the repository to preserve the pipeline architecture.
	 * 
	 * @param method the {@link Method} wrapping the method to be represented
	 * @param ifaceName the name of the interface
	 */
	public void addSignature(Method method) {
		this.repository.addSignature(method);
	}

}
