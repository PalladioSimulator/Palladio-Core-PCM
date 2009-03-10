/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

import eu.qimpress.commonmodel.commonmodel.Allocation.Service;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Architecture Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity specifies a service-orieted architecture model. We distinguish ServiceArchitectureModel  and  CompositeComponent to model service-oriented abstraction level and component-based abstraction level. ServiceArchitectureModel  allows to model pure service-oriented applications separately on different model levels. The service level builds higher coordination level for modelled applications. At the highest level there is a composite structure ServiceArchitectureModel build by composition of services. All subcomponents of ServiceArchitectureModel need to be of a type Service. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel#getDeclaredInterfaces <em>Declared Interfaces</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getServiceArchitectureModel()
 * @model
 * @generated
 */
public interface ServiceArchitectureModel extends CompositeStructure {
	/**
	 * Returns the value of the '<em><b>Declared Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property associates interfaces provided and required by service architecture model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declared Interfaces</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getServiceArchitectureModel_DeclaredInterfaces()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Interface> getDeclaredInterfaces();

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.Allocation.Service}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines the services that build the service architecture model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getServiceArchitectureModel_Service()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Service> getService();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.subcomponents->forAll(e|e.realizedBy.oclIsTypeOf(Allocation::Service))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean OnlyServicesOnTopLevel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ServiceArchitectureModel
