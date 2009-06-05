/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Distribution Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.OutputDistributionType#getUnderflowBin <em>Underflow Bin</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getHistogramBin <em>Histogram Bin</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getOverflowBin <em>Overflow Bin</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getBinSize <em>Bin Size</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getKurtosis <em>Kurtosis</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getMax <em>Max</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getMean <em>Mean</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getMidPoint <em>Mid Point</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getMin <em>Min</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getNumberBins <em>Number Bins</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getSkew <em>Skew</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getStdDev <em>Std Dev</em>}</li>
 *   <li>{@link LqnCore.OutputDistributionType#getXSamples <em>XSamples</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getOutputDistributionType()
 * @model extendedMetaData="name='OutputDistributionType' kind='elementOnly'"
 * @generated
 */
public interface OutputDistributionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Underflow Bin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Underflow Bin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Underflow Bin</em>' containment reference.
	 * @see #setUnderflowBin(HistogramBinType)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_UnderflowBin()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='underflow-bin' namespace='##targetNamespace'"
	 * @generated
	 */
	HistogramBinType getUnderflowBin();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getUnderflowBin <em>Underflow Bin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Underflow Bin</em>' containment reference.
	 * @see #getUnderflowBin()
	 * @generated
	 */
	void setUnderflowBin(HistogramBinType value);

	/**
	 * Returns the value of the '<em><b>Histogram Bin</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.HistogramBinType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Histogram Bin</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Histogram Bin</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_HistogramBin()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='histogram-bin' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<HistogramBinType> getHistogramBin();

	/**
	 * Returns the value of the '<em><b>Overflow Bin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overflow Bin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overflow Bin</em>' containment reference.
	 * @see #setOverflowBin(HistogramBinType)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_OverflowBin()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='overflow-bin' namespace='##targetNamespace'"
	 * @generated
	 */
	HistogramBinType getOverflowBin();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getOverflowBin <em>Overflow Bin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overflow Bin</em>' containment reference.
	 * @see #getOverflowBin()
	 * @generated
	 */
	void setOverflowBin(HistogramBinType value);

	/**
	 * Returns the value of the '<em><b>Bin Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bin Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin Size</em>' attribute.
	 * @see #setBinSize(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_BinSize()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='bin-size' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getBinSize();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getBinSize <em>Bin Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin Size</em>' attribute.
	 * @see #getBinSize()
	 * @generated
	 */
	void setBinSize(Object value);

	/**
	 * Returns the value of the '<em><b>Kurtosis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kurtosis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kurtosis</em>' attribute.
	 * @see #setKurtosis(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_Kurtosis()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='kurtosis' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getKurtosis();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getKurtosis <em>Kurtosis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kurtosis</em>' attribute.
	 * @see #getKurtosis()
	 * @generated
	 */
	void setKurtosis(Object value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_Max()
	 * @model dataType="LqnCore.SrvnFloat" required="true"
	 *        extendedMetaData="kind='attribute' name='max' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getMax();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(Object value);

	/**
	 * Returns the value of the '<em><b>Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean</em>' attribute.
	 * @see #setMean(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_Mean()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='mean' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getMean();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getMean <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean</em>' attribute.
	 * @see #getMean()
	 * @generated
	 */
	void setMean(Object value);

	/**
	 * Returns the value of the '<em><b>Mid Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mid Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mid Point</em>' attribute.
	 * @see #setMidPoint(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_MidPoint()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='mid-point' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getMidPoint();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getMidPoint <em>Mid Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mid Point</em>' attribute.
	 * @see #getMidPoint()
	 * @generated
	 */
	void setMidPoint(Object value);

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_Min()
	 * @model dataType="LqnCore.SrvnFloat" required="true"
	 *        extendedMetaData="kind='attribute' name='min' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getMin();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(Object value);

	/**
	 * Returns the value of the '<em><b>Number Bins</b></em>' attribute.
	 * The default value is <code>"20"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Bins</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Bins</em>' attribute.
	 * @see #isSetNumberBins()
	 * @see #unsetNumberBins()
	 * @see #setNumberBins(BigInteger)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_NumberBins()
	 * @model default="20" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NonNegativeInteger"
	 *        extendedMetaData="kind='attribute' name='number-bins' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getNumberBins();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getNumberBins <em>Number Bins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Bins</em>' attribute.
	 * @see #isSetNumberBins()
	 * @see #unsetNumberBins()
	 * @see #getNumberBins()
	 * @generated
	 */
	void setNumberBins(BigInteger value);

	/**
	 * Unsets the value of the '{@link LqnCore.OutputDistributionType#getNumberBins <em>Number Bins</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberBins()
	 * @see #getNumberBins()
	 * @see #setNumberBins(BigInteger)
	 * @generated
	 */
	void unsetNumberBins();

	/**
	 * Returns whether the value of the '{@link LqnCore.OutputDistributionType#getNumberBins <em>Number Bins</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Bins</em>' attribute is set.
	 * @see #unsetNumberBins()
	 * @see #getNumberBins()
	 * @see #setNumberBins(BigInteger)
	 * @generated
	 */
	boolean isSetNumberBins();

	/**
	 * Returns the value of the '<em><b>Skew</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skew</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skew</em>' attribute.
	 * @see #setSkew(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_Skew()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='skew' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getSkew();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getSkew <em>Skew</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skew</em>' attribute.
	 * @see #getSkew()
	 * @generated
	 */
	void setSkew(Object value);

	/**
	 * Returns the value of the '<em><b>Std Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Std Dev</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Std Dev</em>' attribute.
	 * @see #setStdDev(Object)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_StdDev()
	 * @model dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='std-dev' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getStdDev();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getStdDev <em>Std Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Std Dev</em>' attribute.
	 * @see #getStdDev()
	 * @generated
	 */
	void setStdDev(Object value);

	/**
	 * Returns the value of the '<em><b>XSamples</b></em>' attribute.
	 * The default value is <code>"linear"</code>.
	 * The literals are from the enumeration {@link LqnCore.AxisType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSamples</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSamples</em>' attribute.
	 * @see LqnCore.AxisType
	 * @see #isSetXSamples()
	 * @see #unsetXSamples()
	 * @see #setXSamples(AxisType)
	 * @see LqnCore.LqnCorePackage#getOutputDistributionType_XSamples()
	 * @model default="linear" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='x-samples' namespace='##targetNamespace'"
	 * @generated
	 */
	AxisType getXSamples();

	/**
	 * Sets the value of the '{@link LqnCore.OutputDistributionType#getXSamples <em>XSamples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSamples</em>' attribute.
	 * @see LqnCore.AxisType
	 * @see #isSetXSamples()
	 * @see #unsetXSamples()
	 * @see #getXSamples()
	 * @generated
	 */
	void setXSamples(AxisType value);

	/**
	 * Unsets the value of the '{@link LqnCore.OutputDistributionType#getXSamples <em>XSamples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXSamples()
	 * @see #getXSamples()
	 * @see #setXSamples(AxisType)
	 * @generated
	 */
	void unsetXSamples();

	/**
	 * Returns whether the value of the '{@link LqnCore.OutputDistributionType#getXSamples <em>XSamples</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XSamples</em>' attribute is set.
	 * @see #unsetXSamples()
	 * @see #getXSamples()
	 * @see #setXSamples(AxisType)
	 * @generated
	 */
	boolean isSetXSamples();

} // OutputDistributionType
