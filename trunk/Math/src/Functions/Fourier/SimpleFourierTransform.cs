using MathNet.Numerics;

namespace Palladio.Performance.Math.Fourier
{
	/// <summary>
	/// Class for the simple fourier transformation.
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
	internal class SimpleFourierTransform : IFourierTransform
	{

		public SimpleFourierTransform()
		{
		}

		public Complex[] Forward(Complex[] data)
		{
			// a negative exponent for the fourier transform 
			// indicates the forward direction
			return Transform(data, -1);
		}

		public Complex[] ForwardFromReal(double[] data)
		{
			Complex[] cdata = new Complex[data.Length];
			for (int i=0; i<data.Length; i++)
				cdata[i] = data[i];
			return Forward(cdata);
		}

		public Complex[] Backward(Complex[] data)
		{
			// a positive exponent for the fourier transform 
			// indicates the forward direction
			Complex[] cresult = Transform(data,1);

			// normalisation of the result after the backward transformation.
			double f = 1/ (double) cresult.Length; // normalisation factor 
			for( int i=0; i<cresult.Length; i++)
				cresult[i] *= f;
			return cresult;
		}

		public double[] BackwardToReal(Complex[] data)
		{
			Complex[] cresult = Backward(data);
			double[] result = new double[cresult.Length];
			for (int i = 0; i < cresult.Length; i++)
			{
				result[i] = cresult[i].Real;
			}
			return result;
		}

		/// <summary>
		/// if direction is true -> forward
		/// if direction is false -> backward
		/// </summary>
		/// <param name="X"></param>
		/// <param name="direction"></param>
		/// <returns></returns>
		private static Complex[] Transform(Complex[] X, double direction)
		{
			Complex[] F = new Complex[X.Length];
			double n = X.Length;
			Complex w = (direction*(2*PI*I)/n).Exp(); // nth complex root of unity

			for (int j = 0; j < F.Length; j++)
			{
				F[j] = 0;
				for (int k = 0; k < X.Length; k++)
				{
					F[j] += X[k]*w.Pow(j*k);
				}
			}
			return F;
		}

		private static Complex PI = System.Math.PI;
		private static Complex I = Complex.I;
	}
}