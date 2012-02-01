/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;

import de.fzi.se.controlflowdescription.graph.Graph;
import de.fzi.se.controlflowdescription.graph.GraphPackage;
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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.GraphImpl#getVertices <em>Vertices</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.impl.GraphImpl#getControlflowdescription <em>Controlflowdescription</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends EObjectImpl implements Graph {
	/**
	 * The cached value of the '{@link #getVertices() <em>Vertices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertices()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> vertices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vertex> getVertices() {
		if (vertices == null) {
			vertices = new EObjectContainmentWithInverseEList<Vertex>(Vertex.class, this, GraphPackage.GRAPH__VERTICES, GraphPackage.VERTEX__GRAPH);
		}
		return vertices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescription getControlflowdescription() {
		if (eContainerFeatureID() != GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION) return null;
		return (ControlFlowDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControlflowdescription(ControlFlowDescription newControlflowdescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newControlflowdescription, GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlflowdescription(ControlFlowDescription newControlflowdescription) {
		if (newControlflowdescription != eInternalContainer() || (eContainerFeatureID() != GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION && newControlflowdescription != null)) {
			if (EcoreUtil.isAncestor(this, newControlflowdescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newControlflowdescription != null)
				msgs = ((InternalEObject)newControlflowdescription).eInverseAdd(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH, ControlFlowDescription.class, msgs);
			msgs = basicSetControlflowdescription(newControlflowdescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION, newControlflowdescription, newControlflowdescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean GraphMustHaveAUniqueSourceVertex(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 GraphValidator.GRAPH__GRAPH_MUST_HAVE_AUNIQUE_SOURCE_VERTEX,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "GraphMustHaveAUniqueSourceVertex", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean GraphMustHaveAUniqueSinkVertex(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 GraphValidator.GRAPH__GRAPH_MUST_HAVE_AUNIQUE_SINK_VERTEX,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "GraphMustHaveAUniqueSinkVertex", EObjectValidator.getObjectLabel(this, context) }),
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
			case GraphPackage.GRAPH__VERTICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVertices()).basicAdd(otherEnd, msgs);
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetControlflowdescription((ControlFlowDescription)otherEnd, msgs);
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
			case GraphPackage.GRAPH__VERTICES:
				return ((InternalEList<?>)getVertices()).basicRemove(otherEnd, msgs);
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				return basicSetControlflowdescription(null, msgs);
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
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				return eInternalContainer().eInverseRemove(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH, ControlFlowDescription.class, msgs);
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
			case GraphPackage.GRAPH__VERTICES:
				return getVertices();
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				return getControlflowdescription();
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
			case GraphPackage.GRAPH__VERTICES:
				getVertices().clear();
				getVertices().addAll((Collection<? extends Vertex>)newValue);
				return;
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				setControlflowdescription((ControlFlowDescription)newValue);
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
			case GraphPackage.GRAPH__VERTICES:
				getVertices().clear();
				return;
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				setControlflowdescription((ControlFlowDescription)null);
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
			case GraphPackage.GRAPH__VERTICES:
				return vertices != null && !vertices.isEmpty();
			case GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION:
				return getControlflowdescription() != null;
		}
		return super.eIsSet(featureID);
	}

} //GraphImpl
