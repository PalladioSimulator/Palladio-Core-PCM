using Palladio.Performance.Math.Fourier;
using Palladio.Performance.Math.Functions.Discrete;

namespace Palladio.Performance.Math
{
	/// <summary>
	/// This class gives Acces to creation of functions. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: MathTools.cs,v $
	/// Revision 1.1  2005/08/12 07:59:19  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class MathTools
	{
		#region Properties

		/// <summary>
		/// A Factory for creation of discrete function.
		/// </summary>
		public static IDiscreteFunctionFactory DiscreteFunctions
		{
			get { return discreteFunctions; }
		}

		/// <summary>
		/// A Class for transforming discrete value functions from time domain to frequency domain
		/// or reverse.
		/// </summary>
		public static IFourierTransform FourierTransform
		{
			get { return fastFourierTransform; }
		}

		/// <summary>
		/// A Class for transforming discrete value functions from time domain to frequency domain
		/// or reverse. Transformation uses recursive FFT.
		/// </summary>
		public static IFourierTransform FastFourierTransform
		{
			get 
			{ return fastFourierTransform; }
		}

		/// <summary>
		/// Deprecated. A Class for transforming discrete value functions from time domain to frequency domain
		/// or reverse. Transformation uses simple transformation. Deprecated.
		/// </summary>
		public static IFourierTransform SimpleFourierTransform
		{
			get
			{ return simpleFourierTransform; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Greatest Common Divisor. If one of the values is 0, then the other value is returned.
		/// If both values are 0, then 0 is returned.
		/// </summary>
		/// <param name="u"></param>
		/// <param name="v"></param>
		/// <returns>GCD of both values.</returns>
		public static long GCD(long u, long v) 
		{
			if(u==0)return v;
			if(v==0)return u;
			long t;
			while(u>0)
			{
				if (u<v)
				{
					t=u;
					u=v;
					v=t;
				}
				u=u-v;
			}
			return v;
		}

		/// <summary>
		/// Greatest Common Divisor.
		/// </summary>
		/// <param name="values">Array of values for which the GCD is returned.</param>
		/// <returns>GCD of the values.</returns>
		public static long GCD(long[] values)
		{
			if(values.Length<1) return -1;
			long gcd = values[0];
			for (int i = 1; i<values.Length; i++) 
			{ 
				gcd = GCD(values[i],gcd);
			}
			if(gcd==0) return 1;
			return gcd;
		}

		#endregion Methods

		private static DiscreteFactory discreteFunctions = new DiscreteFactory();
		private static IFourierTransform simpleFourierTransform = new SimpleFourierTransform();
		private static IFourierTransform fastFourierTransform = new FastFourierTransformation();
	}
}
