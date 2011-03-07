/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package QVTTemplate;

import EssentialOCL.LiteralExp;
import EssentialOCL.OclExpression;
import EssentialOCL.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link QVTTemplate.TemplateExp#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link QVTTemplate.TemplateExp#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @see QVTTemplate.QVTTemplatePackage#getTemplateExp()
 * @model abstract="true"
 * @generated
 */
public interface TemplateExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference.
	 * @see #setBindsTo(Variable)
	 * @see QVTTemplate.QVTTemplatePackage#getTemplateExp_BindsTo()
	 * @model
	 * @generated
	 */
	Variable getBindsTo();

	/**
	 * Sets the value of the '{@link QVTTemplate.TemplateExp#getBindsTo <em>Binds To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binds To</em>' reference.
	 * @see #getBindsTo()
	 * @generated
	 */
	void setBindsTo(Variable value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(OclExpression)
	 * @see QVTTemplate.QVTTemplatePackage#getTemplateExp_Where()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	OclExpression getWhere();

	/**
	 * Sets the value of the '{@link QVTTemplate.TemplateExp#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(OclExpression value);

} // TemplateExp
