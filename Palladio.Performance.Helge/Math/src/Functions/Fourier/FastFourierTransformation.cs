using System;
using MathNet.Numerics;

namespace Palladio.Performance.Math.Fourier
{
	/// <summary>
	/// Class for the fast fourier transformation. For further information have a look
	/// into "Introduction to Algorithms" by Cormen et al.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: FastFourierTransformation.cs,v $
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
	public class FastFourierTransformation : IFourierTransform 
	{
		/// <summary>
		/// Fast fourier transformation forward.
		/// </summary>
		/// <param name="data">Function values in time space.</param>
		/// <returns>Function values in frequency space.</returns>
		public Complex[] Forward(Complex[] data)
		{
			// a negative exponent for the fourier transform 
			// indicates the forward direction
			return TransformRecursive(data, -1);
		}

		/// <summary>
		/// Fast fourier transformation forward.
		/// </summary>
		/// <param name="data">Function values in time space.</param>
		/// <returns>Function values in frequency space.</returns>
		public  Complex[] ForwardFromReal(double[] data)
		{
			Complex[] cdata = new Complex[data.Length];
			for (int i=0; i<data.Length; i++)
				cdata[i] = data[i];
			return Forward(cdata);
		}

		/// <summary>
		/// Fast fourier transformation backward.
		/// </summary>
		/// <param name="data">Function values in frequency space.</param>
		/// <returns>Function values in time space.</returns>
		public Complex[] Backward(Complex[] data)
		{
			// a positive exponent for the fourier transform 
			// indicates the forward direction
			Complex[] cresult = TransformRecursive(data,1);

			// normalisation of the result after the backward transformation.
			double f = 1/ (double) cresult.Length; // normalisation factor 
			for( int i=0; i<cresult.Length; i++)
				cresult[i] *= f;
			return cresult;
		}

		/// <summary>
		/// Fast fourier transformation backward.
		/// </summary>
		/// <param name="data">Function values in frequency space.</param>
		/// <returns>Function values in time space.</returns>
		public  double[] BackwardToReal(Complex[] data)
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
		/// Fourier transformation. 
		/// if direction is true -> forward
		/// if direction is false -> backward
		/// </summary>
		/// <param name="X">Values to be transformed.</param>
		/// <param name="direction">true -> forward, false -> backward</param>
		/// <returns>Transformed values.</returns>
		private static Complex[] TransformRecursive(Complex[] X, double direction)
		{
			int n = X.Length;		// n has to be a power of 2
			if (n == 1) return X;
			if(!PowerOf2(n)) throw new ApplicationException("Size of Array must be a Power of 2.")   ;
			Complex omegaN = (direction*(2*PI*I)/n).Exp(); // complex n-th rute of unity
			Complex omega = 1;
			Complex[] a0 = new Complex[n/2];
			Complex[] a1 = new Complex[n/2];
			for (int i = 0; i<n; i+=2)
			{
				a0[i/2]=X[i];
			}
			for (int i = 1; i<n; i+=2)
			{
				a1[(i-1)/2]=X[i];
			}
			// Recursion
			Complex[] y0 = TransformRecursive(a0,direction);
			Complex[] y1 = TransformRecursive(a1,direction);
			Complex[] y = new Complex[n];
			for (int k=0; k<(n/2);k++) 
			{
				Complex temp = omega * y1[k];
				y[k]= y0[k] + temp;
				y[k+(n/2)]=y0[k]- temp;
				omega = omega * omegaN;
			}
			return y;
		}

		/// <summary>
		/// Checks whter a number is a power of two.
		/// </summary>
		/// <param name="n">Number to be checked.</param>
		/// <returns></returns>
		static bool PowerOf2 (int n)
		{
			while(true)
			{
				if(n==2) return true;
			    if(n%2 != 0) return false;
				n = n/2;
			}
		}

		private static  Complex PI = System.Math.PI;
		private static  Complex I = Complex.I;
	}
}
