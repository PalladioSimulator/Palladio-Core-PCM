/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * <p>
 *     Model&nbsp;for a generic&nbsp;control-flow graph.
 * </p>
 * <!-- end-model-doc -->
 * @see de.fzi.se.controlflowdescription.graph.GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.fzi.de/ControlFlowDescription/Graph/0.6";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphPackage eINSTANCE = de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.graph.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.graph.impl.GraphImpl
	 * @see de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__VERTICES = 0;

	/**
	 * The feature id for the '<em><b>Controlflowdescription</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__CONTROLFLOWDESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.graph.impl.VertexImpl
	 * @see de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__TO = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__FROM = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__ITERATIONS = 3;

	/**
	 * The feature id for the '<em><b>Transition Probability</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__TRANSITION_PROBABILITY = 4;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__GRAPH = 5;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.graph.impl.TransitionProbabilityImpl <em>Transition Probability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.graph.impl.TransitionProbabilityImpl
	 * @see de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl#getTransitionProbability()
	 * @generated
	 */
	int TRANSITION_PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_PROBABILITY__PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Vertex</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_PROBABILITY__VERTEX = 1;

	/**
	 * The number of structural features of the '<em>Transition Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_PROBABILITY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.graph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.graph.Graph#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Graph#getVertices()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Vertices();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.graph.Graph#getControlflowdescription <em>Controlflowdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Controlflowdescription</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Graph#getControlflowdescription()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Controlflowdescription();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.graph.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.se.controlflowdescription.graph.Vertex#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getTo()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_To();

	/**
	 * Returns the meta object for the reference list '{@link de.fzi.se.controlflowdescription.graph.Vertex#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getFrom()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_From();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.graph.Vertex#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getNumber()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Number();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.graph.Vertex#getTransitionProbability <em>Transition Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition Probability</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getTransitionProbability()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_TransitionProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.graph.Vertex#getIterations <em>Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterations</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getIterations()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Iterations();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.graph.Vertex#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getGraph()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_Graph();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.graph.TransitionProbability <em>Transition Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Probability</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.TransitionProbability
	 * @generated
	 */
	EClass getTransitionProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.TransitionProbability#getProbability()
	 * @see #getTransitionProbability()
	 * @generated
	 */
	EAttribute getTransitionProbability_Probability();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getVertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Vertex</em>'.
	 * @see de.fzi.se.controlflowdescription.graph.TransitionProbability#getVertex()
	 * @see #getTransitionProbability()
	 * @generated
	 */
	EReference getTransitionProbability_Vertex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphFactory getGraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.graph.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.graph.impl.GraphImpl
		 * @see de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__VERTICES = eINSTANCE.getGraph_Vertices();

		/**
		 * The meta object literal for the '<em><b>Controlflowdescription</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__CONTROLFLOWDESCRIPTION = eINSTANCE.getGraph_Controlflowdescription();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.graph.impl.VertexImpl
		 * @see de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__TO = eINSTANCE.getVertex_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__FROM = eINSTANCE.getVertex_From();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX__NUMBER = eINSTANCE.getVertex_Number();

		/**
		 * The meta object literal for the '<em><b>Transition Probability</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__TRANSITION_PROBABILITY = eINSTANCE.getVertex_TransitionProbability();

		/**
		 * The meta object literal for the '<em><b>Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX__ITERATIONS = eINSTANCE.getVertex_Iterations();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__GRAPH = eINSTANCE.getVertex_Graph();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.graph.impl.TransitionProbabilityImpl <em>Transition Probability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.graph.impl.TransitionProbabilityImpl
		 * @see de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl#getTransitionProbability()
		 * @generated
		 */
		EClass TRANSITION_PROBABILITY = eINSTANCE.getTransitionProbability();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_PROBABILITY__PROBABILITY = eINSTANCE.getTransitionProbability_Probability();

		/**
		 * The meta object literal for the '<em><b>Vertex</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_PROBABILITY__VERTEX = eINSTANCE.getTransitionProbability_Vertex();

	}

} //GraphPackage
