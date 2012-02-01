/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;
import de.fzi.se.controlflowdescription.ControlFlowDescriptions;

import de.fzi.se.controlflowdescription.graph.Graph;
import de.fzi.se.controlflowdescription.graph.GraphPackage;

import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import de.fzi.se.controlflowdescription.util.ControlFlowDescriptionValidator;

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
 * An implementation of the model object '<em><b>Control Flow Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl#getJjnpathsets <em>Jjnpathsets</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl#getJjpaths <em>Jjpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl#getControlflowdescriptions <em>Controlflowdescriptions</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlFlowDescriptionImpl extends EObjectImpl implements ControlFlowDescription {
	/**
	 * The cached value of the '{@link #getJjnpathsets() <em>Jjnpathsets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjnpathsets()
	 * @generated
	 * @ordered
	 */
	protected EList<JJnPathSet> jjnpathsets;

	/**
	 * The cached value of the '{@link #getJjpaths() <em>Jjpaths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjpaths()
	 * @generated
	 * @ordered
	 */
	protected EList<JJPath> jjpaths;

	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlFlowDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ControlFlowDescriptionPackage.Literals.CONTROL_FLOW_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJnPathSet> getJjnpathsets() {
		if (jjnpathsets == null) {
			jjnpathsets = new EObjectContainmentWithInverseEList<JJnPathSet>(JJnPathSet.class, this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS, JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION);
		}
		return jjnpathsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJPath> getJjpaths() {
		if (jjpaths == null) {
			jjpaths = new EObjectContainmentWithInverseEList<JJPath>(JJPath.class, this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS, JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION);
		}
		return jjpaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescriptions getControlflowdescriptions() {
		if (eContainerFeatureID() != ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS) return null;
		return (ControlFlowDescriptions)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControlflowdescriptions(ControlFlowDescriptions newControlflowdescriptions, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newControlflowdescriptions, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlflowdescriptions(ControlFlowDescriptions newControlflowdescriptions) {
		if (newControlflowdescriptions != eInternalContainer() || (eContainerFeatureID() != ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS && newControlflowdescriptions != null)) {
			if (EcoreUtil.isAncestor(this, newControlflowdescriptions))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newControlflowdescriptions != null)
				msgs = ((InternalEObject)newControlflowdescriptions).eInverseAdd(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION, ControlFlowDescriptions.class, msgs);
			msgs = basicSetControlflowdescriptions(newControlflowdescriptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS, newControlflowdescriptions, newControlflowdescriptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH, oldGraph, newGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != graph) {
			NotificationChain msgs = null;
			if (graph != null)
				msgs = ((InternalEObject)graph).eInverseRemove(this, GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION, Graph.class, msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__CONTROLFLOWDESCRIPTION, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean GraphMustBeDefinedIfJJnPathsPresent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ControlFlowDescriptionValidator.DIAGNOSTIC_SOURCE,
						 ControlFlowDescriptionValidator.CONTROL_FLOW_DESCRIPTION__GRAPH_MUST_BE_DEFINED_IF_JJN_PATHS_PRESENT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "GraphMustBeDefinedIfJJnPathsPresent", EObjectValidator.getObjectLabel(this, context) }),
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJjnpathsets()).basicAdd(otherEnd, msgs);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJjpaths()).basicAdd(otherEnd, msgs);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetControlflowdescriptions((ControlFlowDescriptions)otherEnd, msgs);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH:
				if (graph != null)
					msgs = ((InternalEObject)graph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH, null, msgs);
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS:
				return ((InternalEList<?>)getJjnpathsets()).basicRemove(otherEnd, msgs);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS:
				return ((InternalEList<?>)getJjpaths()).basicRemove(otherEnd, msgs);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				return basicSetControlflowdescriptions(null, msgs);
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH:
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				return eInternalContainer().eInverseRemove(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION, ControlFlowDescriptions.class, msgs);
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS:
				return getJjnpathsets();
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS:
				return getJjpaths();
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				return getControlflowdescriptions();
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH:
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS:
				getJjnpathsets().clear();
				getJjnpathsets().addAll((Collection<? extends JJnPathSet>)newValue);
				return;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS:
				getJjpaths().clear();
				getJjpaths().addAll((Collection<? extends JJPath>)newValue);
				return;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				setControlflowdescriptions((ControlFlowDescriptions)newValue);
				return;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH:
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS:
				getJjnpathsets().clear();
				return;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS:
				getJjpaths().clear();
				return;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				setControlflowdescriptions((ControlFlowDescriptions)null);
				return;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH:
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
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS:
				return jjnpathsets != null && !jjnpathsets.isEmpty();
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS:
				return jjpaths != null && !jjpaths.isEmpty();
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS:
				return getControlflowdescriptions() != null;
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__GRAPH:
				return graph != null;
		}
		return super.eIsSet(featureID);
	}

} //ControlFlowDescriptionImpl
