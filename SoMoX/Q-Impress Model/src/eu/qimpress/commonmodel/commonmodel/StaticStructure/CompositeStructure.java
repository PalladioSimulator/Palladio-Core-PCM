/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract entity CompositeStructure is defining an architecture composed of the subcomponents.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure#getSubcomponents <em>Subcomponents</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getCompositeStructure()
 * @model abstract="true"
 * @generated
 */
public interface CompositeStructure extends ComponentType {
	/**
	 * Returns the value of the '<em><b>Subcomponents</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CompositeStructure is build with help ofsubcomponents, that are composed to architecture.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subcomponents</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getCompositeStructure_Subcomponents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubcomponentInstance> getSubcomponents();

	/**
	 * Returns the value of the '<em><b>Connector</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CompositeStructure is build with help of connectors, that could be of a type assembly or delegation connetor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connector</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getCompositeStructure_Connector()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Connector> getConnector();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.subcomponents->forAll(e|not e.realizedBy.oclIsTypeOf(Allocation::Service))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CompositeStructure
