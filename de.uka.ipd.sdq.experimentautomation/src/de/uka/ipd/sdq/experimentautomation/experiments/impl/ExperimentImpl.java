/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentDesign;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.Modification;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.Variation;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getModifications <em>Modifications</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getInitialModel <em>Initial Model</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getToolConfiguration <em>Tool Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getStopConditions <em>Stop Conditions</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getExperimentDesign <em>Experiment Design</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentImpl#getResponseMeasurement <em>Response Measurement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentImpl extends EObjectImpl implements Experiment {
	/**
	 * The cached value of the '{@link #getVariations() <em>Variations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<Variation> variations;

	/**
	 * The cached value of the '{@link #getModifications() <em>Modifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifications()
	 * @generated
	 * @ordered
	 */
	protected EList<Modification> modifications;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitialModel() <em>Initial Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialModel()
	 * @generated
	 * @ordered
	 */
	protected PCMModelFiles initialModel;

	/**
	 * The cached value of the '{@link #getToolConfiguration() <em>Tool Configuration</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<ToolConfiguration> toolConfiguration;

	/**
	 * The cached value of the '{@link #getStopConditions() <em>Stop Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<StopCondition> stopConditions;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExperimentDesign() <em>Experiment Design</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentDesign()
	 * @generated
	 * @ordered
	 */
	protected ExperimentDesign experimentDesign;

	/**
	 * The cached value of the '{@link #getResponseMeasurement() <em>Response Measurement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseMeasurement()
	 * @generated
	 * @ordered
	 */
	protected ResponseMeasurement responseMeasurement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentsPackage.Literals.EXPERIMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variation> getVariations() {
		if (variations == null) {
			variations = new EObjectContainmentEList<Variation>(Variation.class, this, ExperimentsPackage.EXPERIMENT__VARIATIONS);
		}
		return variations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Modification> getModifications() {
		if (modifications == null) {
			modifications = new EObjectContainmentEList<Modification>(Modification.class, this, ExperimentsPackage.EXPERIMENT__MODIFICATIONS);
		}
		return modifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMModelFiles getInitialModel() {
		return initialModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialModel(PCMModelFiles newInitialModel, NotificationChain msgs) {
		PCMModelFiles oldInitialModel = initialModel;
		initialModel = newInitialModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, oldInitialModel, newInitialModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialModel(PCMModelFiles newInitialModel) {
		if (newInitialModel != initialModel) {
			NotificationChain msgs = null;
			if (initialModel != null)
				msgs = ((InternalEObject)initialModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, null, msgs);
			if (newInitialModel != null)
				msgs = ((InternalEObject)newInitialModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, null, msgs);
			msgs = basicSetInitialModel(newInitialModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__INITIAL_MODEL, newInitialModel, newInitialModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ToolConfiguration> getToolConfiguration() {
		if (toolConfiguration == null) {
			toolConfiguration = new EObjectResolvingEList<ToolConfiguration>(ToolConfiguration.class, this, ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION);
		}
		return toolConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StopCondition> getStopConditions() {
		if (stopConditions == null) {
			stopConditions = new EObjectContainmentEList<StopCondition>(StopCondition.class, this, ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS);
		}
		return stopConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDesign getExperimentDesign() {
		return experimentDesign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentDesign(ExperimentDesign newExperimentDesign, NotificationChain msgs) {
		ExperimentDesign oldExperimentDesign = experimentDesign;
		experimentDesign = newExperimentDesign;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, oldExperimentDesign, newExperimentDesign);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentDesign(ExperimentDesign newExperimentDesign) {
		if (newExperimentDesign != experimentDesign) {
			NotificationChain msgs = null;
			if (experimentDesign != null)
				msgs = ((InternalEObject)experimentDesign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, null, msgs);
			if (newExperimentDesign != null)
				msgs = ((InternalEObject)newExperimentDesign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, null, msgs);
			msgs = basicSetExperimentDesign(newExperimentDesign, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN, newExperimentDesign, newExperimentDesign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseMeasurement getResponseMeasurement() {
		return responseMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResponseMeasurement(ResponseMeasurement newResponseMeasurement, NotificationChain msgs) {
		ResponseMeasurement oldResponseMeasurement = responseMeasurement;
		responseMeasurement = newResponseMeasurement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, oldResponseMeasurement, newResponseMeasurement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseMeasurement(ResponseMeasurement newResponseMeasurement) {
		if (newResponseMeasurement != responseMeasurement) {
			NotificationChain msgs = null;
			if (responseMeasurement != null)
				msgs = ((InternalEObject)responseMeasurement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, null, msgs);
			if (newResponseMeasurement != null)
				msgs = ((InternalEObject)newResponseMeasurement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, null, msgs);
			msgs = basicSetResponseMeasurement(newResponseMeasurement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT, newResponseMeasurement, newResponseMeasurement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExperimentsPackage.EXPERIMENT__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
			case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
				return ((InternalEList<?>)getModifications()).basicRemove(otherEnd, msgs);
			case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
				return basicSetInitialModel(null, msgs);
			case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
				return ((InternalEList<?>)getStopConditions()).basicRemove(otherEnd, msgs);
			case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
				return basicSetExperimentDesign(null, msgs);
			case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
				return basicSetResponseMeasurement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExperimentsPackage.EXPERIMENT__VARIATIONS:
				return getVariations();
			case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
				return getModifications();
			case ExperimentsPackage.EXPERIMENT__ID:
				return getId();
			case ExperimentsPackage.EXPERIMENT__NAME:
				return getName();
			case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
				return getInitialModel();
			case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
				return getToolConfiguration();
			case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
				return getStopConditions();
			case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
				return getDescription();
			case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
				return getExperimentDesign();
			case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
				return getResponseMeasurement();
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
			case ExperimentsPackage.EXPERIMENT__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends Variation>)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
				getModifications().clear();
				getModifications().addAll((Collection<? extends Modification>)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__ID:
				setId((String)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__NAME:
				setName((String)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
				setInitialModel((PCMModelFiles)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
				getToolConfiguration().clear();
				getToolConfiguration().addAll((Collection<? extends ToolConfiguration>)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
				getStopConditions().clear();
				getStopConditions().addAll((Collection<? extends StopCondition>)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
				setExperimentDesign((ExperimentDesign)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
				setResponseMeasurement((ResponseMeasurement)newValue);
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
			case ExperimentsPackage.EXPERIMENT__VARIATIONS:
				getVariations().clear();
				return;
			case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
				getModifications().clear();
				return;
			case ExperimentsPackage.EXPERIMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case ExperimentsPackage.EXPERIMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
				setInitialModel((PCMModelFiles)null);
				return;
			case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
				getToolConfiguration().clear();
				return;
			case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
				getStopConditions().clear();
				return;
			case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
				setExperimentDesign((ExperimentDesign)null);
				return;
			case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
				setResponseMeasurement((ResponseMeasurement)null);
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
			case ExperimentsPackage.EXPERIMENT__VARIATIONS:
				return variations != null && !variations.isEmpty();
			case ExperimentsPackage.EXPERIMENT__MODIFICATIONS:
				return modifications != null && !modifications.isEmpty();
			case ExperimentsPackage.EXPERIMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ExperimentsPackage.EXPERIMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExperimentsPackage.EXPERIMENT__INITIAL_MODEL:
				return initialModel != null;
			case ExperimentsPackage.EXPERIMENT__TOOL_CONFIGURATION:
				return toolConfiguration != null && !toolConfiguration.isEmpty();
			case ExperimentsPackage.EXPERIMENT__STOP_CONDITIONS:
				return stopConditions != null && !stopConditions.isEmpty();
			case ExperimentsPackage.EXPERIMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ExperimentsPackage.EXPERIMENT__EXPERIMENT_DESIGN:
				return experimentDesign != null;
			case ExperimentsPackage.EXPERIMENT__RESPONSE_MEASUREMENT:
				return responseMeasurement != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ExperimentImpl
