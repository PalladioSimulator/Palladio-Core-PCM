package de.uka.ipd.sdq.tcfmoop.tcmanager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Optimizer;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.TerminationCriteriaNames;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ElapsedTimeCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.GivenParetoFrontIsReachedCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ITerminationCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.InsignificantParetoFrontChangeCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.InsignificantSetQualityImprovementCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.MaxGenerationNumber;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.MinimalQualityCriteriaValueCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.NoNewParetoOptimalCandidatesFoundCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ParetoOptimalSetStabilityCriterion;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import bsh.EvalError;
import bsh.Interpreter;

/**
 * The main goal of the Termination Criteria Manager is to create termination
 * criteria, call them so that they can evaluate the current optimization state
 * and then evaluate their decisions, on which it must base its own decision
 * whether to stop the optimization or not.
 * 
 * @author Atanas Dimitrov
 */
@Singleton
public class TerminationCriteriaManager implements ITerminationCriteriaManager {

	/**
	 *  List of all currently configured Termination Criteria
	 */
	private List<ITerminationCriterion> terminationCriteria = new LinkedList<ITerminationCriterion>();

	/**
	 *  Defines the Termination Criteria manager has been initialized
	 */
	private boolean isInitialized = false;

	/**
	 *  So that all termination criteria can work with the same time.
	 */
	private long currentTime;

	// Required resources
	private Control control;
	private Optimizer optimizer;
	private Population population;
	private Archive archive;
	private int iteration;

	/**
	 * if true - the manager will evaluate the termination criteria and report
	 * their output but this will not influence the evaluation in any way
	 */
	private boolean isInComparisionMode = false;

	/**
	 * if true - Composed Criterion are on. If false a standard || Criterion is
	 * used
	 */
	private boolean isComposedCriterionActive = false;

	/**
	 *  if true, the optimization will be stopped the next time the manager runs.
	 */
	private boolean performManualStop = false;

	/**
	 *  Composed Criterion Expression
	 */
	private String composedCriterionExpression = "";

	// Event Listeners
	private List<IOutputChangedListener> outputChangedListeners;
	private static List<ITerminationCriteriaManagerInitializedListener> terminationCriteriaManagerInitializedListeners = new ArrayList<ITerminationCriteriaManagerInitializedListener>();
	private List<IOptimizationTerminatedListener> optimizationTerminatedListener;

	// Output
	private Tree outputTree = new Tree("Termination Criteria Manager",
			NodeType.MANAGER);
	private Tree managerTree = new Tree("Manager", NodeType.MANAGER);
	private Tree tCriteriaTree = new Tree("Termination Criteria",
			NodeType.PARAMETER_GROUP);
	private Tree warningsTree = new Tree("Warnings", NodeType.WARNING);

	// Output Nodes:
	private Node iterationNummberNode;
	private Node candidatesInPopulationNode;
	private Node candidatesInArchiveNode;
	private Node useComposedCriterionNode;
	private Node ComposedCriterionExpressionNode;
	private Node isRunningInComparisionModeNode;
	private Node manualTerminationRequestedNode;
	private Node optimizationStoppedNode;

	/**
	 *  Warning flags to prevent more warning than are required
	 */
	private boolean substituteWarningShown = false;

	@Inject
	public TerminationCriteriaManager(Control control, Population population,
			Archive archive) {
		this.control = control;
		this.population = population;
		this.archive = archive;

		this.outputChangedListeners = new ArrayList<IOutputChangedListener>();
		this.optimizationTerminatedListener = new ArrayList<IOptimizationTerminatedListener>();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(List<IConfiguration> tcConfigurations) {
		for (IConfiguration conf : tcConfigurations) {
			if (!conf.validateConfiguration()) {
				this.warningsTree.addChild("The configuration for : "
						+ conf.getTerminationCriterionName()
						+ " cannot be veryfied successfully. "
						+ "The criterion will not be created.",
						NodeType.WARNING);
				continue;
			}

			ITerminationCriterion tc = null;

			switch (conf.getTerminationCriterionName()) {
			case MAXIMUM_NUMBER_OF_GENERATIONS:
				tc = new MaxGenerationNumber(conf, population, archive);
				break;
			case ELAPSED_TIME:
				tc = new ElapsedTimeCriterion(conf, population, archive);
				break;
			case PARETO_OPTIMAL_SET_STABILITY:
				tc = new ParetoOptimalSetStabilityCriterion(conf, population, archive);
				break;
			case NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND:
				tc = new NoNewParetoOptimalCandidatesFoundCriterion(conf, population, archive);
				break;
			case MINIMAL_QUALITY_CIRTERIA_VALUE:
				tc = new MinimalQualityCriteriaValueCriterion(conf, population, archive);
				break;
			case INSIGNIFICANT_SET_QUALITY_IMPROVEMENT:
				tc = new InsignificantSetQualityImprovementCriterion(conf, population, archive);
				break;
			case GIVEN_PARETO_FRONT_IS_REACHED:
				tc = new GivenParetoFrontIsReachedCriterion(conf, population, archive);
				break;
			case INSIGNIFICANT_PARETO_FRONT_CHANGE:
				tc = new InsignificantParetoFrontChangeCriterion(conf, population, archive);
				break;
			default:
				this.warningsTree.addChild("Unknown Termination Criterion: "
						+ conf.getTerminationCriterionName(), NodeType.WARNING);
			}
			if (tc != null) {
				terminationCriteria.add(tc);
			}

		}
		this.initializeOutputTree();
		this.isInitialized = true;

		this.fireTerminationCriteriaManagerInitializedEvent();
		this.fireOutputInformationChangedEvent();
	}

	/**
	 * Initializes the output tree
	 */
	private void initializeOutputTree() {
		this.outputTree.attachSubtree(managerTree);
		this.outputTree.attachSubtree(tCriteriaTree);
		this.outputTree.attachSubtree(warningsTree);

		this.iterationNummberNode = managerTree.addChild("Iteration Number: "
				+ this.iteration, NodeType.PARAMETER);
		this.candidatesInPopulationNode = managerTree.addChild(
				"Candidates in Population: " + this.population.size(),
				NodeType.PARAMETER);
		this.candidatesInArchiveNode = managerTree.addChild(
				"All Pareto Optimal Candidates: " + this.archive.size(),
				NodeType.PARAMETER);
		this.useComposedCriterionNode = managerTree.addChild(
				"Use Composed Criterion: " + this.isComposedCriterionActive,
				NodeType.PARAMETER);
		this.ComposedCriterionExpressionNode = managerTree
				.addChild("Composed Criterion Expression: "
						+ this.composedCriterionExpression, NodeType.EXPRESSION);
		this.isRunningInComparisionModeNode = managerTree.addChild(
				"Running in Comparision Mode: " + this.isInComparisionMode,
				NodeType.PARAMETER);
		this.manualTerminationRequestedNode = managerTree.addChild(
				"Manual Termination requested: " + this.performManualStop,
				NodeType.PARAMETER);
		this.optimizationStoppedNode = managerTree.addChild(
				"Optimization Stopped: " + control.isStopped(),
				NodeType.PARAMETER);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activateTCComparisionMode() {
		this.isInComparisionMode = true;
		this.fireOutputInformationChangedEvent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deactivateTCComparisionMode() {
		this.isInComparisionMode = false;
		this.fireOutputInformationChangedEvent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activateComposedCriterion() {
		this.isComposedCriterionActive = true;
		this.fireOutputInformationChangedEvent();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deactivateComposedCriterion() {
		this.isComposedCriterionActive = false;
		this.fireOutputInformationChangedEvent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setComposedCriterionExpression(
			String composedCriterionExpression) {
		if (isComposedCriterionActive && !composedCriterionExpression.isEmpty()) {

			/*
			 * Checks the supplied boolean expression for consistency before
			 * using it It will be checked whether the expression can be
			 * evaluated and whether it contains illegal symbol in order to
			 * prevent execution of unwanted Java code
			 */

			String exprTemp = composedCriterionExpression + "";
			exprTemp = exprTemp.replace(TerminationCriteriaNames.ELAPSED_TIME.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND.name(), "");
			exprTemp = exprTemp.replace(TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY.name(), "");

			exprTemp = exprTemp.replace("true", "");
			exprTemp = exprTemp.replace("false", "");

			exprTemp = exprTemp.replace("&&", "");
			exprTemp = exprTemp.replace("||", "");
			exprTemp = exprTemp.replace("!", "");

			exprTemp = exprTemp.replace("(", "");
			exprTemp = exprTemp.replace(")", "");

			exprTemp = exprTemp.replaceAll(" ", "");

			if (!exprTemp.isEmpty()) {
				isComposedCriterionActive = false;
				this.warningsTree
						.addChild(
								"Composed Criterion Expression cannot be set because of the following reason: "
										+ "1. The expression contains symbols that are not allowed. "
										+ "A Standard 'OR' Expression will be used instead.",
								NodeType.WARNING);

				return;
			}

			Interpreter i = new Interpreter(); // Construct an interpreter

			try {

				i.set(TerminationCriteriaNames.ELAPSED_TIME.name(), true);
				i.set(TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED.name(), true);
				i.set(TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE.name(), true);
				i.set(TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT.name(), true);
				i.set(TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS.name(), true);
				i.set(TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE.name(), true);
				i.set(TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND.name(), true);
				i.set(TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY.name(), true);

				/*
				 * If eval() and get() can be successfully executed at this
				 * point with this form of the composed criteria expression,
				 * then the expression is correct. If an exception is thrown
				 * now, then the expression is malformed and cannot be used.
				 */
				i.eval("boolean evalResult = " + composedCriterionExpression + ";");
				i.get("evalResult");

				this.composedCriterionExpression = composedCriterionExpression;

			} catch (EvalError e) {
				isComposedCriterionActive = false;
				this.warningsTree
						.addChild(
								"Composed Criterion Expression cannot be set because of the following reason: "
										+ "1. The Expression cannot be evaluated because it is malformed. "
										+ "A Standard 'OR' Expression will be used instead.",
								NodeType.WARNING);
			}
		} else {
			this.warningsTree
					.addChild(
							"Composed Criterion Expression cannot be set because of one of the following reasons: "
									+ "1. The Composed Criterion is deactivated. "
									+ "2. The Expression is empty. "
									+ "A Standard 'OR' Expression will be used instead.",
							NodeType.WARNING);
		}
		
		this.fireOutputInformationChangedEvent();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void evaluateTerminationCriteria() {
		if (this.isInitialized) {
			this.iteration = this.optimizer.getIteration();

			this.currentTime = System.currentTimeMillis();

			boolean doStop = false;

			if (!this.performManualStop) {
				for (ITerminationCriterion tc : this.terminationCriteria) {
					tc.evaluate(this.optimizer.getIteration(),this.currentTime);
				}

				if (this.isComposedCriterionActive) {

					doStop = this.evaluateExpression();

				} else {
					for (ITerminationCriterion tc : this.terminationCriteria) {
						if (tc.getEvaluationResult() && !doStop) {
							doStop = true;
						}
					}
				}
			}

			if (this.performManualStop || (doStop && !this.isInComparisionMode)) {
				control.doStop();
				this.fireOutputInformationChangedEvent();
				this.fireOptimizationTerminatedEvent();
			} else {
				this.fireOutputInformationChangedEvent();
			}
		}
	}

	/**
	 * Perform final Expression consistency check and evaluate it using
	 * BeanShell. If the check or the evaluation fail, then a simple OR
	 * Expression is used.
	 * 
	 * @return the result of the evaluation. True - the optimization must be
	 *         stopped. False - must not be stopped.
	 */
	private boolean evaluateExpression() {

		String expressionCopy = this.composedCriterionExpression.trim();

		for (ITerminationCriterion tc : this.terminationCriteria) {
			if (expressionCopy.contains(tc.getName().name())) {
				expressionCopy = expressionCopy.replace(tc.getName().name(),
						Boolean.toString(tc.getEvaluationResult()));
			}
		}

		if (expressionCopy.contains("_")) {
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.ELAPSED_TIME.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND.name(), Boolean.toString(false));
			expressionCopy = expressionCopy.replace(TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY.name(), Boolean.toString(false));
			if (!this.substituteWarningShown) {
				this.substituteWarningShown = true;
				this.warningsTree.addChild("There is an inactive Termination Criterion referensed in the Composed Criterion Expression. "
										+ "Its value has been substituted with false.", NodeType.WARNING);
			}
		}

		Interpreter i = new Interpreter(); // Construct an interpreter
		boolean evaluationResult = false;

		try {

			i.eval("boolean evalResult = " + expressionCopy + ";");
			evaluationResult = (Boolean) (i.get("evalResult"));

		} catch (EvalError e) {
			isComposedCriterionActive = false;

			for (ITerminationCriterion tc : this.terminationCriteria) {
				if (tc.getEvaluationResult() && !evaluationResult) {
					evaluationResult = true;
				}
			}

			this.warningsTree.addChild("Composed Criterion Expression cannot be set because of the following reason: "
									+ "1. The Expression cannot be evaluated because it is malformed. "
									+ "A Standard 'OR' Expression will be used instead.", NodeType.WARNING);
		}

		return evaluationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	private void fireOutputInformationChangedEvent() {
		if (this.isInitialized) {
			this.iterationNummberNode.updateValue("Iteration Number: " + this.iteration);
			this.candidatesInPopulationNode.updateValue("Candidates in Population: " + this.population.size());
			this.candidatesInArchiveNode.updateValue("All Pareto Optimal Candidates: " + this.archive.size());
			this.useComposedCriterionNode.updateValue("Use Composed Criterion: " + this.isComposedCriterionActive);
			this.ComposedCriterionExpressionNode.updateValue("Composed Criterion Expression: " + this.composedCriterionExpression);
			this.isRunningInComparisionModeNode.updateValue("Running in Comparision Mode: " + this.isInComparisionMode);
			this.manualTerminationRequestedNode.updateValue("Manual Termination requested: " + this.performManualStop);
			this.optimizationStoppedNode.updateValue("Optimization Stopped: " + control.isStopped());

			this.tCriteriaTree.clearChildren();
			for (ITerminationCriterion tc : terminationCriteria) {
				tCriteriaTree.attachSubtree(tc.getOutputInformation());
			}

		}

		for (IOutputChangedListener listener : outputChangedListeners) {
			listener.handleOutputChangedEvent(outputTree);
		}
	}

	/**
	 * Fires a Termination Criteria Manager Initialized event when the TCM is
	 * initialized.
	 */
	private void fireTerminationCriteriaManagerInitializedEvent() {
		for (ITerminationCriteriaManagerInitializedListener listener : terminationCriteriaManagerInitializedListeners) {
			listener.handleTerminationCriteriaManagerInitializedEvent(this);
		}
	}

	/**
	 * Fires a Optimization Terminated Event when the Termination Criteria
	 * Manager decides to stop the optimization.
	 */
	private void fireOptimizationTerminatedEvent() {
		List<IOptimizationTerminatedListener> tempList = new ArrayList<IOptimizationTerminatedListener>(
				this.optimizationTerminatedListener);
		for (IOptimizationTerminatedListener listener : tempList) {
			listener.handleOptimizationTerminatedListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * If the listener is also a IRequestManualTerminationProvider. the TCM will
	 * add itself as a listener to that event.
	 */
	@Override
	public void addOutputChangedListener(IOutputChangedListener listener) {
		this.outputChangedListeners.add(listener);
		if (listener instanceof IRequestManualTerminationProvider) {
			((IRequestManualTerminationProvider) (listener))
					.addRequestManualTerminationListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * If the listener is also a IRequestManualTerminationProvider. the TCM will
	 * remove itself as a listener from that event.
	 */
	@Override
	public void removeOutputChangedListener(IOutputChangedListener listener) {
		this.outputChangedListeners.remove(listener);
		if (listener instanceof IRequestManualTerminationProvider) {
			((IRequestManualTerminationProvider) (listener))
					.removeRequestManualTerminationListener(this);
		}
	}

	/**
	 * Adds a new listener for the static TerminationCriteriaManagerInitialized
	 * event.
	 * 
	 * @param listener
	 *            ITerminationCriteriaManagerInitializedListener listener
	 */
	public static void addTerminationCriteriaManagerInitializedListener(
			ITerminationCriteriaManagerInitializedListener listener) {
		terminationCriteriaManagerInitializedListeners.add(listener);
	}

	/**
	 * Removes a listener from the static TerminationCriteriaManagerInitialized
	 * event.
	 * 
	 * @param listener
	 *            ITerminationCriteriaManagerInitializedListener listener
	 */
	public static void removeTerminationCriteriaManagerInitializedListener(
			ITerminationCriteriaManagerInitializedListener listener) {
		terminationCriteriaManagerInitializedListeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		if (this.isInitialized) {
			this.optimizer = optimizer;
			this.evaluateTerminationCriteria();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addOptimizationTerminatedListener(
			IOptimizationTerminatedListener listener) {
		this.optimizationTerminatedListener.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeOptimizationTerminatedListener(
			IOptimizationTerminatedListener listener) {
		this.optimizationTerminatedListener.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleManualTerminationRequest() {
		this.performManualStop = true;
		this.fireOutputInformationChangedEvent();
	}

}