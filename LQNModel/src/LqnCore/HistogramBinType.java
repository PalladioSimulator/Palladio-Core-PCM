/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Histogram Bin Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.HistogramBinType#getBegin <em>Begin</em>}</li>
 *   <li>{@link LqnCore.HistogramBinType#getConf95 <em>Conf95</em>}</li>
 *   <li>{@link LqnCore.HistogramBinType#getConf99 <em>Conf99</em>}</li>
 *   <li>{@link LqnCore.HistogramBinType#getEnd <em>End</em>}</li>
 *   <li>{@link LqnCore.HistogramBinType#getProb <em>Prob</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getHistogramBinType()
 * @model extendedMetaData="name='HistogramBinType' kind='empty'"
 * @generated
 */
public interface HistogramBinType extends EObject {
	/**
	 * Returns the value of the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin</em>' attribute.
	 * @see #setBegin(Object)
	 * @see LqnCore.LqnCorePackage#getHistogramBinType_Begin()
	 * @model dataType="LqnCore.SrvnFloat" required="true"
	 *        extendedMetaData="kind='attribute' name='begin' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getBegin();

	/**
	 * Sets the value of the '{@link LqnCore.HistogramBinType#getBegin <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin</em>' attribute.
	 * @see #getBegin()
	 * @generated
	 */
	void setBegin(Object value);

	/**
	 * Returns the value of the '<em><b>Conf95</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conf95</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conf95</em>' attribute.
	 * @see #setConf95(Object)
	 * @see LqnCore.LqnCorePackage#getHistogramBinType_Conf95()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='conf-95' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getConf95();

	/**
	 * Sets the value of the '{@link LqnCore.HistogramBinType#getConf95 <em>Conf95</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conf95</em>' attribute.
	 * @see #getConf95()
	 * @generated
	 */
	void setConf95(Object value);

	/**
	 * Returns the value of the '<em><b>Conf99</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conf99</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conf99</em>' attribute.
	 * @see #setConf99(Object)
	 * @see LqnCore.LqnCorePackage#getHistogramBinType_Conf99()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='conf-99' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getConf99();

	/**
	 * Sets the value of the '{@link LqnCore.HistogramBinType#getConf99 <em>Conf99</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conf99</em>' attribute.
	 * @see #getConf99()
	 * @generated
	 */
	void setConf99(Object value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(Object)
	 * @see LqnCore.LqnCorePackage#getHistogramBinType_End()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='end' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getEnd();

	/**
	 * Sets the value of the '{@link LqnCore.HistogramBinType#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Object value);

	/**
	 * Returns the value of the '<em><b>Prob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prob</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prob</em>' attribute.
	 * @see #setProb(Object)
	 * @see LqnCore.LqnCorePackage#getHistogramBinType_Prob()
	 * @model dataType="LqnCore.SrvnFloat" required="true"
	 *        extendedMetaData="kind='attribute' name='prob' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getProb();

	/**
	 * Sets the value of the '{@link LqnCore.HistogramBinType#getProb <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prob</em>' attribute.
	 * @see #getProb()
	 * @generated
	 */
	void setProb(Object value);

} // HistogramBinType
