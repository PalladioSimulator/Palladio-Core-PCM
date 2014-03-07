/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textual Mass Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualMassDistributionImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualMassDistributionImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualMassDistributionImpl#getTextualNominalStatistics <em>Textual Nominal Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualMassDistributionImpl extends EObjectImpl implements TextualMassDistribution {
	/**
     * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFrequency()
     * @generated
     * @ordered
     */
	protected static final long FREQUENCY_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFrequency()
     * @generated
     * @ordered
     */
	protected long frequency = FREQUENCY_EDEFAULT;

	/**
     * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIdentifier()
     * @generated
     * @ordered
     */
	protected Identifier identifier;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TextualMassDistributionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.TEXTUAL_MASS_DISTRIBUTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getFrequency() {
        return frequency;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFrequency(long newFrequency) {
        long oldFrequency = frequency;
        frequency = newFrequency;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__FREQUENCY, oldFrequency, frequency));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier getIdentifier() {
        if (identifier != null && identifier.eIsProxy()) {
            InternalEObject oldIdentifier = (InternalEObject)identifier;
            identifier = (Identifier)eResolveProxy(oldIdentifier);
            if (identifier != oldIdentifier) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER, oldIdentifier, identifier));
            }
        }
        return identifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier basicGetIdentifier() {
        return identifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIdentifier(Identifier newIdentifier) {
        Identifier oldIdentifier = identifier;
        identifier = newIdentifier;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER, oldIdentifier, identifier));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextualNominalStatistics getTextualNominalStatistics() {
        if (eContainerFeatureID() != ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS) return null;
        return (TextualNominalStatistics)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTextualNominalStatistics(TextualNominalStatistics newTextualNominalStatistics, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTextualNominalStatistics, ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTextualNominalStatistics(TextualNominalStatistics newTextualNominalStatistics) {
        if (newTextualNominalStatistics != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS && newTextualNominalStatistics != null)) {
            if (EcoreUtil.isAncestor(this, newTextualNominalStatistics))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTextualNominalStatistics != null)
                msgs = ((InternalEObject)newTextualNominalStatistics).eInverseAdd(this, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION, TextualNominalStatistics.class, msgs);
            msgs = basicSetTextualNominalStatistics(newTextualNominalStatistics, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS, newTextualNominalStatistics, newTextualNominalStatistics));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTextualNominalStatistics((TextualNominalStatistics)otherEnd, msgs);
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
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                return basicSetTextualNominalStatistics(null, msgs);
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
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION, TextualNominalStatistics.class, msgs);
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
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__FREQUENCY:
                return getFrequency();
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER:
                if (resolve) return getIdentifier();
                return basicGetIdentifier();
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                return getTextualNominalStatistics();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__FREQUENCY:
                setFrequency((Long)newValue);
                return;
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER:
                setIdentifier((Identifier)newValue);
                return;
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                setTextualNominalStatistics((TextualNominalStatistics)newValue);
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
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__FREQUENCY:
                setFrequency(FREQUENCY_EDEFAULT);
                return;
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER:
                setIdentifier((Identifier)null);
                return;
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                setTextualNominalStatistics((TextualNominalStatistics)null);
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
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__FREQUENCY:
                return frequency != FREQUENCY_EDEFAULT;
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__IDENTIFIER:
                return identifier != null;
            case ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS:
                return getTextualNominalStatistics() != null;
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
        result.append(" (frequency: ");
        result.append(frequency);
        result.append(')');
        return result.toString();
    }

} //TextualMassDistributionImpl
