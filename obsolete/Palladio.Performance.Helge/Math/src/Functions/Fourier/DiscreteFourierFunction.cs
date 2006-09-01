using System;
using System.Diagnostics;
using MathNet.Numerics;

namespace Palladio.Performance.Math.Fourier
{
	/// <summary>
	/// Class for a fourier transformed discrete function.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: DiscreteFourierFunction.cs,v $
	/// Revision 1.2  2005/12/04 18:41:21  helgeh
	/// - Simplified DiscreteFourierFunction.Calculate LoopLimit
	/// - added new attribute MaximumExecutionTimeAttribute
	/// - replaced AbstractRegExASTVisitor.DetermineMaxTime by  a new visitor RegExASTVisitorDetermineMaxTime
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
	public class DiscreteFourierFunction : IFourierFunction
	{
		#region Data

		private Complex[] data;
		private long xmin;
		private long samplingRate;

		#endregion Data

		#region Properties

		/// <summary>
		/// Sum of all function values.
		/// </summary>
		public double Sum
		{
			get
			{
				Complex sum = new Complex();
				for (int i=0;i<this.data.Length;i++)
				{
					sum += this.data[i];
				}
				return sum.Real;
			}
		}

		#endregion Properties

		#region Constructor
		/// <summary>
		/// Constructor. Creates a new discrete fourier function. The minimum value is set to 0.
		/// </summary>
		/// <param name="data">Fourier values for the function. The values must be already transformed.</param>
		/// <param name="samplingRate">Distance between two values.</param>
		public DiscreteFourierFunction(Complex[] data, long samplingRate)
		{
			this.data=data;
			this.samplingRate=samplingRate;
			this.xmin=0;
		}

		/// <summary>
		/// Copy constructor.
		/// </summary>
		/// <param name="dff"><c>DiscreteFourierFunction</c> which shall be copied.</param>
		public DiscreteFourierFunction(DiscreteFourierFunction dff)
		{
			this.samplingRate=dff.samplingRate;
			this.xmin=dff.xmin;
			this.data=new Complex[dff.Data.Length];
			dff.Data.CopyTo(this.data,0);
		}

		#endregion Constructor

		#region IFourierFunction Member

		/// <summary>
		/// Fourier values.
		/// </summary>
		public Complex[] Data
		{
			get
			{
				return this.data;
			}
		}

		/// <summary>
		/// Distance between two values.
		/// </summary>
		public long SamplingRate
		{
			get { return this.samplingRate; }
		}

		/// <summary>
		/// Minimum value on the x-axis.
		/// </summary>
		public long xMin
		{
			get { return this.xmin; }
		}

		/// <summary>
		/// Multiplication of each pair of elements. Both functions must have the same length.
		/// </summary>
		/// <param name="ff">IFourierFunction to be multiplied with this.</param>
		/// <returns>New IFourierFunction holding the result of the multiplication.</returns>
		public IFourierFunction Multiply(IFourierFunction ff)
		{
			if(this.Data.Length != ff.Data.Length) 
				throw new ApplicationException("Both functions must have the same length!");
			Complex[] result = new Complex[this.data.Length];
			int length = result.Length;
			for (int i=0; i< length;i++)
			{
				result[i] = this.Data[i] * ff.Data[i];
				if(result[i].IsNaN) Debugger.Break();
			}
			return new DiscreteFourierFunction(result, this.samplingRate);
		}

		/// <summary>
		/// Addition of each pair of elements. Both functions must have the same length.
		/// </summary>
		/// <param name="ff">IFourierFunction to be added with this.</param>
		/// <returns>New IFourierFunction holding the result of the addition.</returns>
		public IFourierFunction Add(IFourierFunction ff)
		{
			if(this.Data.Length != ff.Data.Length) 
				throw new ApplicationException("Both functions must have the same length!");
			Complex[] result = new Complex[this.data.Length];
			int length = result.Length;
			for (int i=0; i< length;i++)
			{
				result[i] = this.Data[i] + ff.Data[i];
				if(result[i].IsNaN) Debugger.Break();
			}
			return new DiscreteFourierFunction(result,this.samplingRate);
		}


		/// <summary>
		/// Returns a copy of the function sclaed by <c>factor</c>
		/// </summary>
		/// <param name="factor">Scaling factor.</param>
		/// <returns>New scaled IFourierFunction.</returns>
		public IFourierFunction GetScaled(double factor)
		{
			int length = this.Data.Length;
			Complex[] result = new Complex[length];
			for(int i=0;i<length;i++)
			{
				result[i]=this.Data[i]*factor;
				if(result[i].IsNaN) Debugger.Break();
			}
			return new DiscreteFourierFunction(result,this.samplingRate);
		}

//		/// <summary>
//		/// Computes the execution time of a loop. This is an approximation which depends on the size 
//		/// of the data array.
//		/// </summary>
//		/// <param name="p">Probability of re-iterating through the loop.</param>
//		/// <returns>The fourier function of the loop limit.</returns>
//		public IFourierFunction ComputeLoopLimit(double p)
//		{
//			double alpha = 1;
//			double alphaInv = 1/alpha;
//			int length = this.Data.Length;
//			Complex[] result = new Complex[length];
//			for (int i= 0; i<length;i++)
//			{
//				result[i] = alphaInv + ((p*data[i])/(1-p*alpha*data[i]));
//				if(result[i].IsNaN) Debugger.Break();
//			}
//			IFourierFunction resultFunction = new DiscreteFourierFunction(result,this.samplingRate);
//			return resultFunction.GetScaled(1-p);
//		}

		/// <summary>
		/// Computes the execution time of a loop. This is an approximation which depends on the size 
		/// of the data array.
		/// </summary>
		/// <param name="p">Probability of re-iterating through the loop.</param>
		/// <returns>The fourier function of the loop limit.</returns>
		public IFourierFunction ComputeLoopLimit(double p)
		{
			int length = this.Data.Length;
			Complex[] result = new Complex[length];
			for (int i= 0; i<length;i++)
			{
				result[i] = 1/(1-p*data[i]);
				if(result[i].IsNaN) Debugger.Break();
			}
			IFourierFunction resultFunction = new DiscreteFourierFunction(result,this.samplingRate);
			return resultFunction.GetScaled(1-p);
		}

		#endregion IFourierFunction Member

		#region Methods

		/// <summary>
		/// Creates a copy of the object.
		/// </summary>
		/// <returns>A copy of the object.</returns>
		public object Clone()
		{
			return new DiscreteFourierFunction(this);
		}
		#endregion
	}
}
