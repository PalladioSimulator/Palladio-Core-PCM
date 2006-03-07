using MathNet.Numerics;
using Palladio.Performance.Math.Fourier;

namespace Palladio.Performance.Math.Functions.Discrete
{
	/// <summary>
	/// Class for creating discrete functions. The functions created have the same properties as the
	/// DiscreteFactory-Class.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: DiscreteFactory.cs,v $
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
	internal class DiscreteFactory : IDiscreteFunctionFactory
	{
		#region Data

		/// <summary>
		/// Distance between two values.
		/// </summary>
		private int samplingRate;

		/// <summary>
		/// Maximum x-value
		/// </summary>
		private int xmax;

		/// <summary>
		/// Minimum x-value.
		/// </summary>
		private int xmin;

		/// <summary>
		/// xmax - xmin.
		/// </summary>
		private double width;

		/// <summary>
		/// Default length of the value array: width / precision
		/// </summary>
		private int defaultLength;

		#endregion

		#region Properties

		/// <summary>
		/// Precision for the created functions.
		/// </summary>
		public int SamplingRate
		{
			get { return samplingRate; }
			set 
			{
				samplingRate = value;
				SetValues();
			}
		}

		/// <summary>
		/// Default maximum for the greatest x value that has an associated function value.
		/// </summary>
		public int XMax
		{
			get { return xmax; }
			set 
			{
				xmax = value; 
				SetValues();
			}
		}

		/// <summary>
		/// Default minimum for the smallest x value that has an associated function value.
		/// </summary>
		public int XMin
		{
			get { return xmin; }
			set
			{
				xmin = value;
				SetValues();
			}
		}

		#endregion Properties

		#region Constructor

		/// <summary>
		/// Creates discrete function factory with default values. The sampling rate is set to 1, xmin is set to 0
		/// and xmax is set to 10.
		/// </summary>
		public DiscreteFactory()
		{
			this.samplingRate = 1;
			this.xmax = 10;
			this.xmin = 0;
			SetValues();
		}
		#endregion

		#region IFunctionFactory
		/// <summary>
		/// Creates a new function using a set of values. The sampling rate
		/// for those values must correspond to the sampling rate of the factory.
		/// Also the start value must be a multiple of the sampling rate.
		/// All values other than the given ones are set to zero.
		/// </summary>
		/// <param name="xStart">Position on the x axis for the first value in the value array.</param>
		/// <param name="samplingRate">Distance between two values.</param>
		/// <param name="values">Ordered set of values describing the function.</param>
		/// <returns></returns>
		public IDiscreteFunction DiscreteValueFunction(long xStart, long samplingRate, double[] values)
		{
			return new DiscreteFunction(values, samplingRate, xStart);
		}

		/// <summary>
		/// Creates a new probability density function using a set of values. 
		/// </summary>
		/// <param name="xStart">Position on the x axis for the first value in the value array.</param>
		/// <param name="samplingRate">Distance of two values.</param>
		/// <param name="values">Ordered set of values describing the function.</param>
		/// <returns></returns>
		public IDiscretePDFunction DiscreteValuePDFunction(long xStart, long samplingRate, double[] values)
		{
			return new DiscretePDFunction(values, samplingRate, xStart);
		}

		/// <summary>
		/// Creates a new probability density function. The fourier function is transformed back to the
		/// time domain.
		/// </summary>
		/// <param name="ff">Function in frequency domain.</param>
		/// <returns>Function in time domain.</returns>
		public IDiscretePDFunction DiscreteValuePDFunction(IFourierFunction ff)
		{
			IFourierTransform ft = new FastFourierTransformation();
			double[] timeValues = ft.BackwardToReal(ff.Data);
			IDiscretePDFunction df = new DiscretePDFunction(timeValues,ff.SamplingRate,ff.xMin);
			return df;
		}

		/// <summary>
		/// Creates a new probability density function using a set of values. 
		/// </summary>
		/// <param name="df"></param>
		/// <returns></returns>
		public IDiscretePDFunction DiscreteValuePDFunction(IDiscreteFunction df)
		{
			return new DiscretePDFunction((DiscreteFunction) df);
		}

		/// <summary>
		/// Creates a new fourier function. It is assumed, that the complex values are the fourier 
		/// transformed values.
		/// </summary>
		/// <param name="values">Already fourier transformed values</param>
		/// <param name="samplingrate">Sampling rate of the function.</param>
		/// <returns></returns>
		public IFourierFunction DiscreteFourierFunction(Complex[] values, long samplingrate)
		{
			return new DiscreteFourierFunction(values,samplingrate);
		}

		/// <summary>
		/// Creates a new fourier function. The values are transformed to the frquency space.
		/// </summary>
		/// <param name="function">Values in time space.</param>
		/// <returns></returns>
		public IFourierFunction DiscreteFourierFunction(IDiscreteFunction function)
		{
			IFourierTransform ft = new FastFourierTransformation();
			IDiscreteFunction dg = function.Clone() as IDiscreteFunction;
			dg.ExpandDomainPo2(0,dg.XMax);
			Complex[] fourierValues = ft.ForwardFromReal(dg.Data);
			IFourierFunction ff = new DiscreteFourierFunction(fourierValues,function.SamplingRate);
			return ff;
		}


		/// <summary>
		/// Returns the exponential distribution with a rate.
		/// This is: f(x) = (1 / rate) * exp(- x (1 / rate)).
		/// </summary>
		/// <param name="rate">Rate of the exponential distribution.</param>
		/// <returns>Exponential distribution with the specified rate and properties of the 
		/// FunctionFactory.</returns>
		public IDiscreteFunction ExponentialDistribution(double rate)
		{
			return ExponentialDistribution(this.xmin,this.samplingRate,rate, this.defaultLength);
		}


		/// <summary>
		/// Returns the exponential distribution with a rate.
		/// This is: f(x) = (1 / rate) * exp(- x (1 / rate)).
		/// </summary>
		/// <param name="xMin">Minimum value of the function.</param>
		/// <param name="samplingrate">Samplingrate of the function.</param>
		/// <param name="rate">Rate of the exponential distribution.</param>
		/// <param name="length">Number of function values.</param>
		/// <returns>Exponential distribution with the specified rate and properties of the 
		/// FunctionFactory.</returns>
		public IDiscreteFunction ExponentialDistribution(int xMin, int samplingrate, double rate, int length)
		{
			double[] values = new double[length];
			int x = xMin;

			double lambda = 1/rate;
			for (int i = 0; i < length; i++)
			{
				values[i] = lambda*System.Math.Exp(-x*lambda);
				x += samplingRate;
			}
			return new DiscreteFunction(values,samplingrate,xMin);
		}

		/// <summary>
		/// Returns the constant  function.
		/// This is: f(x) = c.
		/// </summary>
		/// <param name="c">Constant value for the function.</param>
		/// <returns>Function with a constant value.</returns>
		public IDiscreteFunction ConstantFunction(double c)
		{
			double[] values = new double[1];
			values[0] = c;
			return new DiscreteFunction(values, samplingRate, 0);
		}

		/// <summary>
		/// Returns the dirac function which is the neutral element
		/// of the convolution. This is:
		/// f(0) = infty and f(x) = 0 for x != 0.
		/// </summary>
		/// <returns>Dirac function of length one. Function value is 1.</returns>
		public IDiscreteFunction DiracDeltaFunction()
		{
			double[] values = new double[1];
			values[0] = 1.0;
			return new DiscreteFunction(values, samplingRate, 0);
		}


		/// <summary>
		/// Creates a copy of a IDiscreteFunction with the parameters given by the factory.
		/// </summary>
		/// <param name="df">IDiscreteFunction wich shall be copied.</param>
		/// <returns>Copied IDiscreteFunction.</returns>
		public IDiscreteFunction Copy(IDiscreteFunction df)
		{
			return  DiscreteValueFunction(df.XMin, df.SamplingRate,df.Data);
		}

		public object Clone()
		{
			DiscreteFactory copy = new DiscreteFactory();
			copy.XMax = this.XMax;
			copy.XMin = this.XMin;
			copy.SamplingRate = this.SamplingRate;
			return copy;
		}
		#endregion

		#region Helper

		/// <summary>
		/// Sets the class variables.
		/// </summary>
		private void SetValues()
		{
			this.width = xmax - xmin;
			this.defaultLength = (int) (width/samplingRate);
		}
		#endregion
	}
}
