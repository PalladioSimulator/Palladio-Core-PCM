/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.EStereotypableObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>User Data</b></em>'. <!--
 * end-user-doc -->
 * 
 * <!-- begin-model-doc --> UserData characterises data used in specific assembly contexts in the
 * system. This data is the same for all UsageScenarios, i.e., multiple users accessing the same
 * components access the same data. This UserData refers to component parameters of the system
 * publicized by the software architect (see pcm::parameters package). The domain expert
 * characterises the values of component parameters related to business concepts (e.g., user
 * specific data, data specific for a business domain), whereas the software architect characterises
 * the values of component parameters related to technical concepts (e.g., size of caches, size of a
 * thread pool, configuration data, etc.). One UserData instance includes all parameter
 * characterisation for the annotated entity. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getAssemblyContext_userData <em>Assembly
 * Context user Data</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getUsageModel_UserData <em>Usage Model User
 * Data</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getUserDataParameterUsages_UserData <em>User
 * Data Parameter Usages User Data</em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUserData()
 * @model
 * @extends EStereotypableObject
 * @generated
 */
public interface UserData extends EStereotypableObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Usage Model User Data</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.UsageModel#getUserData_UsageModel
     * <em>User Data Usage Model</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Usage Model User Data</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Usage Model User Data</em>' container reference.
     * @see #setUsageModel_UserData(UsageModel)
     * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUserData_UsageModel_UserData()
     * @see de.uka.ipd.sdq.pcm.usagemodel.UsageModel#getUserData_UsageModel
     * @model opposite="userData_UsageModel" required="true" transient="false" ordered="false"
     * @generated
     */
    UsageModel getUsageModel_UserData();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getUsageModel_UserData
     * <em>Usage Model User Data</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Usage Model User Data</em>' container reference.
     * @see #getUsageModel_UserData()
     * @generated
     */
    void setUsageModel_UserData(UsageModel value);

    /**
     * Returns the value of the '<em><b>Assembly Context user Data</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Assembly Context user Data</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Assembly Context user Data</em>' reference.
     * @see #setAssemblyContext_userData(AssemblyContext)
     * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUserData_AssemblyContext_userData()
     * @model required="true" ordered="false"
     * @generated
     */
    AssemblyContext getAssemblyContext_userData();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.UserData#getAssemblyContext_userData
     * <em>Assembly Context user Data</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Assembly Context user Data</em>' reference.
     * @see #getAssemblyContext_userData()
     * @generated
     */
    void setAssemblyContext_userData(AssemblyContext value);

    /**
     * Returns the value of the '<em><b>User Data Parameter Usages User Data</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getUserData_VariableUsage
     * <em>User Data Variable Usage</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Data Parameter Usages User Data</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>User Data Parameter Usages User Data</em>' containment
     *         reference list.
     * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getUserData_UserDataParameterUsages_UserData()
     * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getUserData_VariableUsage
     * @model opposite="userData_VariableUsage" containment="true" ordered="false"
     * @generated
     */
    EList<VariableUsage> getUserDataParameterUsages_UserData();

} // UserData
