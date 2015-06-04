/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Collection Iterator Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.CollectionIteratorActionImpl#getParameter_CollectionIteratorAction
 * <em>Parameter Collection Iterator Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionIteratorActionImpl extends AbstractLoopActionImpl implements CollectionIteratorAction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getParameter_CollectionIteratorAction()
     * <em>Parameter Collection Iterator Action</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getParameter_CollectionIteratorAction()
     * @generated
     * @ordered
     */
    protected Parameter parameter_CollectionIteratorAction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CollectionIteratorActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.COLLECTION_ITERATOR_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Parameter getParameter_CollectionIteratorAction() {
        if (this.parameter_CollectionIteratorAction != null && this.parameter_CollectionIteratorAction.eIsProxy()) {
            final InternalEObject oldParameter_CollectionIteratorAction = (InternalEObject) this.parameter_CollectionIteratorAction;
            this.parameter_CollectionIteratorAction = (Parameter) this
                    .eResolveProxy(oldParameter_CollectionIteratorAction);
            if (this.parameter_CollectionIteratorAction != oldParameter_CollectionIteratorAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION,
                            oldParameter_CollectionIteratorAction, this.parameter_CollectionIteratorAction));
                }
            }
        }
        return this.parameter_CollectionIteratorAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Parameter basicGetParameter_CollectionIteratorAction() {
        return this.parameter_CollectionIteratorAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParameter_CollectionIteratorAction(final Parameter newParameter_CollectionIteratorAction) {
        final Parameter oldParameter_CollectionIteratorAction = this.parameter_CollectionIteratorAction;
        this.parameter_CollectionIteratorAction = newParameter_CollectionIteratorAction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION,
                    oldParameter_CollectionIteratorAction, this.parameter_CollectionIteratorAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION:
            if (resolve) {
                return this.getParameter_CollectionIteratorAction();
            }
            return this.basicGetParameter_CollectionIteratorAction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SeffPackage.COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION:
            this.setParameter_CollectionIteratorAction((Parameter) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case SeffPackage.COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION:
            this.setParameter_CollectionIteratorAction((Parameter) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SeffPackage.COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION:
            return this.parameter_CollectionIteratorAction != null;
        }
        return super.eIsSet(featureID);
    }

} // CollectionIteratorActionImpl
