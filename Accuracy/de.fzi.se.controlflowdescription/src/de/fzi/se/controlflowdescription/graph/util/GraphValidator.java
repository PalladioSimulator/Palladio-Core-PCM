/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph.util;

import de.fzi.se.controlflowdescription.graph.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.graph.GraphPackage
 * @generated
 */
public class GraphValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final GraphValidator INSTANCE = new GraphValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.fzi.se.controlflowdescription.graph";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Graph Must Have AUnique Source Vertex' of 'Graph'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GRAPH__GRAPH_MUST_HAVE_AUNIQUE_SOURCE_VERTEX = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Graph Must Have AUnique Sink Vertex' of 'Graph'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GRAPH__GRAPH_MUST_HAVE_AUNIQUE_SINK_VERTEX = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Number Must Be Unique For Graph' of 'Vertex'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VERTEX__NUMBER_MUST_BE_UNIQUE_FOR_GRAPH = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Source Vertex Must Have Number1' of 'Vertex'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VERTEX__SOURCE_VERTEX_MUST_HAVE_NUMBER1 = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sink Vertex Must Have The Number Of Overall Vertices In The Graph As Number' of 'Vertex'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VERTEX__SINK_VERTEX_MUST_HAVE_THE_NUMBER_OF_OVERALL_VERTICES_IN_THE_GRAPH_AS_NUMBER = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Transition Probabilities Must Be Defined For All Target Vertices Or For None' of 'Vertex'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VERTEX__TRANSITION_PROBABILITIES_MUST_BE_DEFINED_FOR_ALL_TARGET_VERTICES_OR_FOR_NONE = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return GraphPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case GraphPackage.GRAPH:
				return validateGraph((Graph)value, diagnostics, context);
			case GraphPackage.VERTEX:
				return validateVertex((Vertex)value, diagnostics, context);
			case GraphPackage.TRANSITION_PROBABILITY:
				return validateTransitionProbability((TransitionProbability)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraph(Graph graph, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validateGraph_GraphMustHaveAUniqueSourceVertex(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validateGraph_GraphMustHaveAUniqueSinkVertex(graph, diagnostics, context);
		return result;
	}

	/**
	 * Validates the GraphMustHaveAUniqueSourceVertex constraint of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraph_GraphMustHaveAUniqueSourceVertex(Graph graph, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return graph.GraphMustHaveAUniqueSourceVertex(diagnostics, context);
	}

	/**
	 * Validates the GraphMustHaveAUniqueSinkVertex constraint of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraph_GraphMustHaveAUniqueSinkVertex(Graph graph, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return graph.GraphMustHaveAUniqueSinkVertex(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_NumberMustBeUniqueForGraph(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_SourceVertexMustHaveNumber1(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone(vertex, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NumberMustBeUniqueForGraph constraint of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex_NumberMustBeUniqueForGraph(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return vertex.NumberMustBeUniqueForGraph(diagnostics, context);
	}

	/**
	 * Validates the SourceVertexMustHaveNumber1 constraint of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex_SourceVertexMustHaveNumber1(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return vertex.SourceVertexMustHaveNumber1(diagnostics, context);
	}

	/**
	 * Validates the SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber constraint of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex_SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return vertex.SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber(diagnostics, context);
	}

	/**
	 * Validates the TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone constraint of '<em>Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex_TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone(Vertex vertex, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return vertex.TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransitionProbability(TransitionProbability transitionProbability, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transitionProbability, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //GraphValidator
