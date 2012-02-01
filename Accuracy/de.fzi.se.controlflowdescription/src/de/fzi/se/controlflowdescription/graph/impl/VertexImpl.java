/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph.impl;

import de.fzi.se.controlflowdescription.graph.Graph;
import de.fzi.se.controlflowdescription.graph.GraphPackage;
import de.fzi.se.controlflowdescription.graph.TransitionProbability;
import de.fzi.se.controlflowdescription.graph.Vertex;

import de.fzi.se.controlflowdescription.graph.util.GraphValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl#getTo <em>To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl#getIterations <em>Iterations</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl#getTransitionProbability <em>Transition Probability</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.VertexImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VertexImpl extends EObjectImpl implements Vertex {
	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> to;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> from;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected static final double ITERATIONS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected double iterations = ITERATIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransitionProbability() <em>Transition Probability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionProbability()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionProbability> transitionProbability;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.VERTEX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vertex> getTo() {
		if (to == null) {
			to = new EObjectWithInverseResolvingEList.ManyInverse<Vertex>(Vertex.class, this, GraphPackage.VERTEX__TO, GraphPackage.VERTEX__FROM);
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vertex> getFrom() {
		if (from == null) {
			from = new EObjectWithInverseResolvingEList.ManyInverse<Vertex>(Vertex.class, this, GraphPackage.VERTEX__FROM, GraphPackage.VERTEX__TO);
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.VERTEX__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransitionProbability> getTransitionProbability() {
		if (transitionProbability == null) {
			transitionProbability = new EObjectContainmentWithInverseEList<TransitionProbability>(TransitionProbability.class, this, GraphPackage.VERTEX__TRANSITION_PROBABILITY, GraphPackage.TRANSITION_PROBABILITY__VERTEX);
		}
		return transitionProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIterations() {
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations(double newIterations) {
		double oldIterations = iterations;
		iterations = newIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.VERTEX__ITERATIONS, oldIterations, iterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != GraphPackage.VERTEX__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, GraphPackage.VERTEX__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphPackage.VERTEX__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__VERTICES, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.VERTEX__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NumberMustBeUniqueForGraph(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 GraphValidator.DIAGNOSTIC_SOURCE,
						 GraphValidator.VERTEX__NUMBER_MUST_BE_UNIQUE_FOR_GRAPH,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NumberMustBeUniqueForGraph", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SourceVertexMustHaveNumber1(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 GraphValidator.DIAGNOSTIC_SOURCE,
						 GraphValidator.VERTEX__SOURCE_VERTEX_MUST_HAVE_NUMBER1,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SourceVertexMustHaveNumber1", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 GraphValidator.DIAGNOSTIC_SOURCE,
						 GraphValidator.VERTEX__SINK_VERTEX_MUST_HAVE_THE_NUMBER_OF_OVERALL_VERTICES_IN_THE_GRAPH_AS_NUMBER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 GraphValidator.DIAGNOSTIC_SOURCE,
						 GraphValidator.VERTEX__TRANSITION_PROBABILITIES_MUST_BE_DEFINED_FOR_ALL_TARGET_VERTICES_OR_FOR_NONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.VERTEX__TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTo()).basicAdd(otherEnd, msgs);
			case GraphPackage.VERTEX__FROM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFrom()).basicAdd(otherEnd, msgs);
			case GraphPackage.VERTEX__TRANSITION_PROBABILITY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransitionProbability()).basicAdd(otherEnd, msgs);
			case GraphPackage.VERTEX__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.VERTEX__TO:
				return ((InternalEList<?>)getTo()).basicRemove(otherEnd, msgs);
			case GraphPackage.VERTEX__FROM:
				return ((InternalEList<?>)getFrom()).basicRemove(otherEnd, msgs);
			case GraphPackage.VERTEX__TRANSITION_PROBABILITY:
				return ((InternalEList<?>)getTransitionProbability()).basicRemove(otherEnd, msgs);
			case GraphPackage.VERTEX__GRAPH:
				return basicSetGraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GraphPackage.VERTEX__GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__VERTICES, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.VERTEX__TO:
				return getTo();
			case GraphPackage.VERTEX__FROM:
				return getFrom();
			case GraphPackage.VERTEX__NUMBER:
				return getNumber();
			case GraphPackage.VERTEX__ITERATIONS:
				return getIterations();
			case GraphPackage.VERTEX__TRANSITION_PROBABILITY:
				return getTransitionProbability();
			case GraphPackage.VERTEX__GRAPH:
				return getGraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.VERTEX__TO:
				getTo().clear();
				getTo().addAll((Collection<? extends Vertex>)newValue);
				return;
			case GraphPackage.VERTEX__FROM:
				getFrom().clear();
				getFrom().addAll((Collection<? extends Vertex>)newValue);
				return;
			case GraphPackage.VERTEX__NUMBER:
				setNumber((Integer)newValue);
				return;
			case GraphPackage.VERTEX__ITERATIONS:
				setIterations((Double)newValue);
				return;
			case GraphPackage.VERTEX__TRANSITION_PROBABILITY:
				getTransitionProbability().clear();
				getTransitionProbability().addAll((Collection<? extends TransitionProbability>)newValue);
				return;
			case GraphPackage.VERTEX__GRAPH:
				setGraph((Graph)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.VERTEX__TO:
				getTo().clear();
				return;
			case GraphPackage.VERTEX__FROM:
				getFrom().clear();
				return;
			case GraphPackage.VERTEX__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case GraphPackage.VERTEX__ITERATIONS:
				setIterations(ITERATIONS_EDEFAULT);
				return;
			case GraphPackage.VERTEX__TRANSITION_PROBABILITY:
				getTransitionProbability().clear();
				return;
			case GraphPackage.VERTEX__GRAPH:
				setGraph((Graph)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.VERTEX__TO:
				return to != null && !to.isEmpty();
			case GraphPackage.VERTEX__FROM:
				return from != null && !from.isEmpty();
			case GraphPackage.VERTEX__NUMBER:
				return number != NUMBER_EDEFAULT;
			case GraphPackage.VERTEX__ITERATIONS:
				return iterations != ITERATIONS_EDEFAULT;
			case GraphPackage.VERTEX__TRANSITION_PROBABILITY:
				return transitionProbability != null && !transitionProbability.isEmpty();
			case GraphPackage.VERTEX__GRAPH:
				return getGraph() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (number: ");
		result.append(number);
		result.append(", iterations: ");
		result.append(iterations);
		result.append(')');
		return result.toString();
	}

} //VertexImpl
