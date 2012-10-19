/**
 */
package probfunction.util;

import de.uka.ipd.sdq.units.UnitCarryingElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import probfunction.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see probfunction.ProbfunctionPackage
 * @generated
 */
public class ProbfunctionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProbfunctionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbfunctionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProbfunctionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProbfunctionSwitch<Adapter> modelSwitch =
		new ProbfunctionSwitch<Adapter>() {
			@Override
			public Adapter caseBoxedPDF(BoxedPDF object) {
				return createBoxedPDFAdapter();
			}
			@Override
			public Adapter caseProbabilityDensityFunction(ProbabilityDensityFunction object) {
				return createProbabilityDensityFunctionAdapter();
			}
			@Override
			public Adapter caseContinuousSample(ContinuousSample object) {
				return createContinuousSampleAdapter();
			}
			@Override
			public Adapter caseProbabilityMassFunction(ProbabilityMassFunction object) {
				return createProbabilityMassFunctionAdapter();
			}
			@Override
			public <T> Adapter caseSample(Sample<T> object) {
				return createSampleAdapter();
			}
			@Override
			public Adapter caseSamplePDF(SamplePDF object) {
				return createSamplePDFAdapter();
			}
			@Override
			public Adapter caseComplex(Complex object) {
				return createComplexAdapter();
			}
			@Override
			public Adapter caseContinuousPDF(ContinuousPDF object) {
				return createContinuousPDFAdapter();
			}
			@Override
			public Adapter caseExponentialDistribution(ExponentialDistribution object) {
				return createExponentialDistributionAdapter();
			}
			@Override
			public Adapter caseNormalDistribution(NormalDistribution object) {
				return createNormalDistributionAdapter();
			}
			@Override
			public Adapter caseLognormalDistribution(LognormalDistribution object) {
				return createLognormalDistributionAdapter();
			}
			@Override
			public Adapter caseGammaDistribution(GammaDistribution object) {
				return createGammaDistributionAdapter();
			}
			@Override
			public Adapter caseProbabilityFunction(ProbabilityFunction object) {
				return createProbabilityFunctionAdapter();
			}
			@Override
			public Adapter caseUnitCarryingElement(UnitCarryingElement object) {
				return createUnitCarryingElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link probfunction.BoxedPDF <em>Boxed PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.BoxedPDF
	 * @generated
	 */
	public Adapter createBoxedPDFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.ProbabilityDensityFunction <em>Probability Density Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.ProbabilityDensityFunction
	 * @generated
	 */
	public Adapter createProbabilityDensityFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.ContinuousSample <em>Continuous Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.ContinuousSample
	 * @generated
	 */
	public Adapter createContinuousSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.ProbabilityMassFunction <em>Probability Mass Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.ProbabilityMassFunction
	 * @generated
	 */
	public Adapter createProbabilityMassFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.Sample
	 * @generated
	 */
	public Adapter createSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.SamplePDF <em>Sample PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.SamplePDF
	 * @generated
	 */
	public Adapter createSamplePDFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.Complex <em>Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.Complex
	 * @generated
	 */
	public Adapter createComplexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.ContinuousPDF <em>Continuous PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.ContinuousPDF
	 * @generated
	 */
	public Adapter createContinuousPDFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.ExponentialDistribution <em>Exponential Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.ExponentialDistribution
	 * @generated
	 */
	public Adapter createExponentialDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.NormalDistribution <em>Normal Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.NormalDistribution
	 * @generated
	 */
	public Adapter createNormalDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.LognormalDistribution <em>Lognormal Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.LognormalDistribution
	 * @generated
	 */
	public Adapter createLognormalDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.GammaDistribution <em>Gamma Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.GammaDistribution
	 * @generated
	 */
	public Adapter createGammaDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link probfunction.ProbabilityFunction <em>Probability Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see probfunction.ProbabilityFunction
	 * @generated
	 */
	public Adapter createProbabilityFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.units.UnitCarryingElement <em>Unit Carrying Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.units.UnitCarryingElement
	 * @generated
	 */
	public Adapter createUnitCarryingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ProbfunctionAdapterFactory
