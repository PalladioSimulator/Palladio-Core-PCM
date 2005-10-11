namespace Palladio.Performance.Measurement
{
	/// <summary>
	/// This class makes available some high resolution timers with a precision of 1 microsecons.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/10/11 22:05:14  helgeh
	/// - Added NUnit project and NDoc documentation.
	/// - fixed a bug in AdjustSamplingRate
	///
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
	public class Measure
	{
		#region Data

		private static HiResTimer hrt = new HiResTimer();
		private static HiResTimer hrt2 = new HiResTimer();
		private static HiResTimer hrt3 = new HiResTimer();


		/// <summary>
		/// High resolution timer.
		/// </summary>
		public static HiResTimer Hrt
		{
			get { return hrt; }
		}

		/// <summary>
		/// High resolution timer.
		/// </summary>
		public static HiResTimer Hrt2
		{
			get { return hrt2; }
		}

		/// <summary>
		/// High resolution timer.
		/// </summary>
		public static HiResTimer Hrt3
		{
			get { return hrt3; }
		}

		#endregion

		/// <summary>
		/// Returns a string of the elapsed time formated in minutes and seconds.
		/// </summary>
		/// <returns></returns>
		public static string GetTimeHrt()
		{
			long microseconds = (long) hrt.ElapsedMicroseconds;
			long miliseconds = microseconds/1000;
			long seconds = microseconds/1000000;
			long minutes = seconds/60;
			string s = "Computation took " + minutes + " minutes and " + seconds%60 +" seconds  and "
				+ miliseconds%1000 +  " Millisecons.";
			return s;
		}
	}
}
