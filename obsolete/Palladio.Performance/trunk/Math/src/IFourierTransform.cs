using MathNet.Numerics;

namespace Palladio.Performance.Math
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
	public interface IFourierTransform
	{
		/// <summary>
		/// Transforms a set of complex values from the time space into
		/// the frequency space.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		Complex[] Forward(Complex[] data);

		/// <summary>
		/// Transforms a set of real values from the time space into 
		/// the (complex) frequency space.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		Complex[] ForwardFromReal(double[] data);

		/// <summary>
		/// Transforms a set of complex values from the frequency 
		/// space to the time space.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		Complex[] Backward(Complex[] data);

		/// <summary>
		/// Transforms a set of complex values from the frequency 
		/// space to the time space and converts the result to real
		/// values by neglecting the imaginary part.
		/// </summary>
		/// <param name="data"></param>
		/// <returns></returns>
		double[] BackwardToReal(Complex[] data);

//		/// <summary>
//		/// Returns a number that is a power of two. The number is the next power of two from the parameter
//		/// value.
//		/// </summary>
//		/// <param name="value">Number which is smaller or equal than the searched power of two.</param>
//		/// <returns></returns>
//		int NextPowerOfTwo(int value);
	}
}
