using System;
using System.IO;

namespace Palladio.Performance.Math.Functions.Discrete
{
	/// <summary>
	/// A Class for discrete value function. The discrete values are hold in an arrayand are
	/// equidistant with the  distance between two values in the array is given
	/// by the sampling rate. So the x-value for index data[i] is xmin + i*samplingrate.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: DiscreteFunction.cs,v $
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
	internal class DiscreteFunction : IDiscreteFunction
	{

		#region Data

		/// <summary>
		/// Array of function values.
		/// </summary>
		private double[] data;

		/// <summary>
		/// Distance between two function values.
		/// </summary>
		private long samplingRate;

		/// <summary>
		/// Minimal x value for which a value is listed in the value array.
		/// </summary>
		private long xmin;

		#endregion

		#region Poperties

		/// <summary>
		/// Smallest x value for which an entry in the value array exists.
		/// </summary>
		public long XMin
		{
			get { return xmin; }
			set { this.xmin = value; }
		}

		/// <summary>
		/// Greatest x value for which an entry in the value array exists.
		/// </summary>
		public long XMax
		{
			get { return XMin + (data.Length -1)*SamplingRate; }
		}

		/// <summary>
		/// Array of discrete function values.
		/// </summary>
		public double[] Data
		{
			get { return data; }
		}

		/// <summary>
		/// Number of function values.
		/// </summary>
		public int Count
		{
			get { return data.Length; }
		}

		/// <summary>
		/// Distance (x-axis) between two entries in the value array. If the samplingrate is set to a new 
		/// value, the function values will be adjusted.
		/// </summary>
		public long SamplingRate
		{
			get { return samplingRate; }
			set{ AdjustSamplingRate(value); }
		}

		#endregion

		#region Methods
		public override string ToString()
		{
			string ret = "Discrete Function: ";
			ret += "\nMinimum value: " + this.XMin;
			ret += "\nMaximum value: " + this.XMax;
			ret += "\nSamplingRate: " + this.SamplingRate;
			ret += "\nExecution Time: \t Probabilities:";

			for(int i=0;i<this.Count;i++)
			{
				ret += "(" +this.ValueAt(i) +")(" + this.Data[i] + ") \n ";
			}
			return ret;
		}


		/// <summary>
		/// Returns a number that is the nearest power of two to <c>min</c>min.
		/// </summary>
		/// <param name="min">Lower bound of the returned number.</param>
		/// <returns>A number that is the nearest power of two to <c>min</c>.</returns>
		private long NextPowerOfTwo(long min)
		{
			int i = 2;
			while(true)
			{
				if (min<=i) return i;
				i *=2;
			}
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates new function.
		/// </summary>
		/// <param name="values">Array of function values.</param>
		/// <param name="samplingRate">x distance of the values in the array.</param>
		/// <param name="xmin">x value for the first entry in the value array.</param>
		internal DiscreteFunction(double[] values, long samplingRate, long xmin)
		{
			this.data = values;
			this.samplingRate = samplingRate;
			this.xmin = xmin;
		}

		/// <summary>
		/// Copy Constructor.
		/// </summary>
		/// <param name="df"></param>
		internal DiscreteFunction(DiscreteFunction df)
		{
			this.samplingRate = df.samplingRate;
			this.xmin = df.xmin;
			samplingRate = df.samplingRate;
			data = new double[df.data.Length];
			df.data.CopyTo(data, 0);
		}
		#endregion

		#region IDiscreteFunction
		/// <summary>
		/// Values that are smaller than n are set to zero.
		/// </summary>
		/// <param name="n"></param>
		public void DismissValuesSmalerThanN(double n)
		{
			int length = this.data.Length;
			for (int i=0;i<length;i++)
			{
				if(this.data[i]<n) this.data[i]=0;
			}
		}


		/// <summary>
		/// Expands the domain of the function to the new value of xMax. If xMax is not a multiple of the
		/// samplingrate, it is set to the next multiple.
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax">New maximum x-value. If the value is smaller than the old xMax 
		/// a ApplicationException is thrown.</param>
		public void ExpandDomain(long xMax)
		{
			ExpandDomain(this.XMin,xMax);
		}
	
		/// <summary>
		/// Expands the domain of the function to the new value of xMax and xMin. If xMax or xMin are not a multiple
		/// of the samplingrate, they are set to the next multiple. 
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax">New maximum x-value. If the value is smaller than the old xMax 
		/// an ApplicationException is thrown.</param>
		/// <param name="xMin">New minimum x-value. If the value is bigger than the old xMin
		///  anApplicationException is thrown.</param>
		public void ExpandDomain(long xMin,long xMax)
		{
			if(xMax < this.XMax)
				throw new ApplicationException("New value for xMax must be greater or equal than "+this.XMax+"!");
			if(xMin > this.XMin)
				throw new ApplicationException("New value for xMin must be lower or equal than "+this.XMin+"!");
			long length = (xMax - xMin) / samplingRate + 1;
			double[] newData = new double[length];
			// fill lower values with 0s
			for (int i=0;i<(this.XMin - xMin)/this.SamplingRate;i++)
			{
				newData[i]=0;
			}
			data.CopyTo(newData,(this.XMin - xMin)/this.SamplingRate);
			for (int i=data.Length + (int)((this.XMin - xMin)/this.SamplingRate); i<newData.Length; i++)
			{
				newData[i] = 0;
			}
			data = newData;
			this.XMin=xMin;
		}

		/// <summary>
		/// Expands the domain of the function to the new value of xMax and xMin. If xMax or xMin are not a multiple
		/// of the samplingrate, they are set to the next multiple. 
		/// Furthermore additional values are added, so the size of the function becomes a power of 2.
		/// All new values are set to zero.
		/// </summary>
		/// <param name="xMax">New maximum x-value. If the value is smaller than the old xMax 
		/// an ApplicationException is thrown.</param>
		/// <param name="xMin">New minimum x-value. If the value is bigger than the old xMin
		///  an ApplicationException is thrown.</param>
		public void ExpandDomainPo2(long xMin,long xMax)
		{
			long size = NextPowerOfTwo((xMax-xMin)/samplingRate +1);
			long newXmax= xMin + (size-1)*this.samplingRate;
			ExpandDomain(xMin,newXmax);
		}


		/// <summary>
		/// Returns the number of values which probability is 0.
		/// </summary>
		/// <returns>Number of values which probability is 0.</returns>
		public int NumberOfNullValues()
		{
			int length = this.data.Length;
			int number = 0;
			for (int i=0; i<length;i++)
			{
				if(data[i]==0) number++;
			}
			return number;
		}

		/// <summary>
		/// Returns the sum of all function values.
		/// </summary>
		/// <returns>Sum of all function values.</returns>
		public double Sum()
		{
			double sum = 0;

			int length = this.data.Length;
			for(int i=0;i<length;i++)
			{
				sum += this.data[i]	;
			}
			return sum;
		}

		/// <summary>
		/// Returns the x-value of data[index].
		/// </summary>
		/// <param name="index">Index for which the x-value is requested.</param>
		/// <returns>X-value or -1 if index is out of range.</returns>
		public long ValueAt(int index) 
		{
			if (index < 0 || index > this.Data.Length-1) return -1;
			return this.xmin +(this.samplingRate * index);
		}


		/// <summary>
		/// Scales the data of the function with the given factor.
		/// </summary>
		/// <param name="factor">Factor with which the data is scaled.</param>
		public void Scale(double factor)
		{
			for (int i = 0; i < data.Length; i++)
				data[i] *= factor;
		}

		/// <summary>
		/// Returns a copy of the function scaled by the given factor.
		/// </summary>
		/// <param name="factor">Factor with which the data is scaled.</param>
		/// <returns>Copy of the function scaled by factor.</returns>
		public IDiscreteFunction GetScaled(double factor)
		{
			DiscreteFunction df = new DiscreteFunction(this);
			df.Scale(factor);
			return df;
		}

		/// <summary>
	    /// Convolution for discrete Functions. The two functions must have the same SamplingRate. 
	    /// </summary>
	    /// <param name="dg">IDiscreteFunction dg for the convolution with the object.</param>
	    /// <returns>A new function with the result of the convolution.</returns>
		public IDiscreteFunction Convolution(IDiscreteFunction dg)
		{
			if(this.SamplingRate != dg.SamplingRate)
				throw new ApplicationException("Both functions must have the same sampling rate!");

			long min = this.XMin + dg.XMin;
			long max = this.XMax + dg.XMax;
			long samplingrate = this.SamplingRate;
			long values = (max/samplingrate - min/samplingrate) +1; 
			double[] convolutionValues = new double[values];

			for (int i = 0; i < convolutionValues.Length; i++)
			{
				double convValue = 0;
				// if i is larger than the length of the array dg.Values,
				// the largest position (i-pos) in the array dg.Values is
				// dg.Values.Length - 1. Therfore:
				// (i - pos) = dg.Values.Length - 1
				//		 - pos = - i + dg.Values.Length - 1
				//		   pos =   i - dg.Values.Length + 1
				int pos = System.Math.Max(0, i - dg.Data.Length + 1);

				// pos <= i : left border for dg.Values
				// pos < Values.Length : right border for Values
				while ((pos <= i) && (pos < Data.Length))
				{
					try
					{
						convValue += checked(Data[pos]*dg.Data[i - pos]);
					} 
					catch (OverflowException) 
					{
						Console.WriteLine("An System.OverflowException occurd at Convolution. Omitting value.");
					}
					pos++;
				}
				convolutionValues[i] = convValue;
			}
			return new DiscreteFunction(convolutionValues, SamplingRate, XMin + dg.XMin);
		}

		/// <summary>
		/// Adds a function g scaled by a to the existing function.
		/// </summary>
		/// <param name="a">Sclaing factor.</param>
		/// <param name="g">Function to add.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		public IDiscreteFunction AddScaled(double a, IDiscreteFunction g)
		{
			IDiscreteFunction dg = g.GetScaled(a);
			IDiscreteFunction result = this.Add(dg);
			return result;
		}

		/// <summary>
		/// Adds a function to this.
		/// </summary>
		/// <param name="dg">Function to be added.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		public IDiscreteFunction Add(IDiscreteFunction dg)
		{
			if(this.SamplingRate != dg.SamplingRate)
				throw new ApplicationException("Both functions must have the same sampling rate!");
			
			long min = System.Math.Min(this.XMin,dg.XMin);
			long max = System.Math.Max(this.XMax,dg.XMax);

			IDiscreteFunction df = (IDiscreteFunction) this.Clone();

			df.ExpandDomain(min, max);

			int length = df.Data.Length;
			for (int i=0;i<length;i++) 
			{
				df.Data[i] += dg.ValueOf(min+(i*this.samplingRate));
			}
			return df;
		}

		/// <summary>
		/// Removes 0-Values at beginning and end.
		/// </summary>
		public void Crop()
		{
			int min =0;
			int max = this.Data.Length-1;
			while(min<this.Data.Length) 
			{
				if (this.Data[min]>0) break;
				min++;
			}
			while(max>=0)
			{
				if (this.Data[max]>0) break;
				max--;
			}
			if(min!=0 || max != this.Data.Length-1) 
			{
				double[] newData = new double[max - min + 1];
				for (int i=0;i<newData.Length;i++) 
				{
					newData[i] = data[min+i];
				}
				this.data=newData;
			}
			this.xmin += (min*this.samplingRate);
		}

		/// <summary>
		/// Multiplies this function with another function.
		/// </summary>
		/// <param name="dg">Function to be multiplied with this.</param>
		/// <returns>A new Function containing the result of the operation.</returns>
		public IDiscreteFunction Multiply(IDiscreteFunction dg)
		{
			if(this.SamplingRate != dg.SamplingRate)
				throw new ApplicationException("Both functions must have the same sampling rate!");

			IDiscreteFunction df = (IDiscreteFunction) this.Clone();
			long x = df.XMin;
			long length = df.Data.Length;
			for (long i=0;i<length;i++)
			{
				df.Data[i] *= dg.ValueOf(x);
				x += df.SamplingRate;
			}
			return df;
		}


		/// <summary>
		/// Returns the function value of x, that is f(x). 
		/// </summary>
		/// <param name="x">Value on the x-axis. x must be a multiple of the sampling rate.</param>
		/// <returns>f(x) if x is a multiple of the samplingrate. Otherwise an ApplicationException
		///  is thown.</returns>
		public double ValueOf(long x)
		{
			if((x-this.XMin)%this.SamplingRate !=0) 
				throw new ApplicationException("x must be a multiple of the sampling rate!");
			if(x<this.xmin || x >this.XMax) 
			{
				return 0;
			} 
			else 
			{
				return this.data[(x-this.xmin)/this.samplingRate];
			}
		}

		/// <summary>
		/// Returns the maximum value of the function.
		/// </summary>
		/// <returns>The maximum value of the function.</returns>
		public double MaximunDataValue()
		{
			double max=0;
			long length = this.data.LongLength;
			for (int i=0;i<length;i++)
			{
				max=System.Math.Max(max,this.data[i]);
			}
			return max;
		}

		/// <summary>
		/// Adjust the function to a new SamplingRate. 
		/// The new Sampling rate must be a multiple or a divisor of the old one. The size of the data
		/// array is adjusted to hold the values.
		/// </summary>
		/// <param name="newSR">The new sampling rate.</param>
		public void AdjustSamplingRate(long newSR)
		{
			if(this.samplingRate==0) this.samplingRate=newSR;
			if (newSR>this.samplingRate) AdjustSamplingRateUp(newSR);
			if(newSR<this.samplingRate) AdjustSamplingRateDown(newSR);
		}


		/// <summary>
		/// Adjust the function to a new SamplingRate. 
		/// The new SamplingRate must be a divisor of the old one.
		/// </summary>
		/// <param name="newSR">New sampling rate.</param>
		public void AdjustSamplingRateDown(long newSR) 
		{
			if (this.SamplingRate % newSR != 0) 
				throw new NotImplementedException("AdjustSamplingRate is only implemented for Common Divisors!"
					+ "samplingrate of the function: "+ this.samplingRate + " tried to adjust to " + newSR);
			long oldSR = this.SamplingRate;
			double scaling = ((double)newSR)/((double)oldSR);
			long factor = oldSR / newSR;

			double[] newValues;
			if(this.xmin==0) 
			{
				newValues = new double[this.Data.Length*factor - 1];
			} else
			{
				newValues = new double[this.Data.Length*factor];
			}

			int counter = 0;
			for(int i=0; i<this.Data.Length;i++)
			{
				if(i==0 && this.xmin==0)
				{
					newValues[counter++] = this.Data[0];
					continue;
				}
				for(int j=0;j<factor;j++)
				{
					try 
					{
						newValues[counter++]=checked(this.Data[i]*scaling);
					} 
					catch (OverflowException)
					{
						Console.WriteLine("A System.OverflowException occured. Value is set to 0.");
						newValues[counter++]=0;
					}
				}
			}
			this.data = newValues;
			if(this.xmin!=0) this.xmin = (xmin-oldSR) + newSR;
			this.samplingRate=newSR;
		}

		/// <summary>
		/// Adjust the function to a new SamplingRate. 
		/// The new SamplingRate must be multiple of the old one.
		/// </summary>
		/// <param name="newSR">The new sampling rate.</param>
		public void AdjustSamplingRateUp(long newSR) 
		{

			if (newSR % this.SamplingRate !=0) 
				throw new ApplicationException("AdjustSamplingRateUp: new sampling rate should be multiple of the old one."
					+ "samplingrate of the function: "+ this.samplingRate + " tried to adjust to " + newSR);

			long newXMin = (this.XMin / newSR) * newSR;
			long newXMax = ((this.XMax / newSR) + 1) * newSR;
			long newLength = (newXMax - newXMin) / newSR; // es sollte hier keinen rest geben.
			double[] newData = new double[newLength];

			// Das neue Minimum ist kleiner oder gleich dem alten. Die Frage ist jetzt,
			// welche Werte ich bei der Zusammenfassung welcher Seite zuordne. 
			// Vorschlag: Halbieren des Intervals 
			// newData[n] = SUM_{k=n*newSR-newSR/2}^{n*newSR+newSR/2} oldData[k]

			int pos = 0;
			double midXnew = (double)newXMin + ((double)newSR / 2d);
			for(int i=0; i<newData.Length; i++) 
			{
				double prob = 0;
				while ((XMin + pos*SamplingRate < midXnew) && (pos<data.Length))
				{
					prob += data[pos];
					pos++;
				}
				newData[i] = prob;
				midXnew += newSR;
			}
			this.samplingRate = newSR;
			this.xmin = newXMin;
			this.data= newData;

//			if (newSR % this.SamplingRate !=0) 
//				throw new ApplicationException("AdjustSamplingRateUp: new sampling rate should be multiple of the old one."
//					+ "samplingrate of the function: "+ this.samplingRate + " tried to adjust to " + newSR);
//
//			long newXmin = GetNextMultipleBiggerThanN(newSR, this.XMin); // JENS: min der neuen Funktion muss kleiner als bei der alten sein. Grenzen außerhalb!
//			long newXmax = GetNextMultipleBiggerThanN(newSR,this.XMax);
//
//			long newValuesLength = (newXmax-newXmin)/newSR +1;
//			double[] newValues = new double[newValuesLength];
//
//			int functionIndex = 0;
//			int functionLength = this.data.Length;
//			for(int i= 0; i< newValuesLength; i++)
//			{
//				double newProbability = 0;
//				long newFunctionValue = newXmin + (i*newSR);
//				while(functionIndex <functionLength && this.ValueAt(functionIndex) <= newFunctionValue)
//				{
//					newProbability += this.Data[functionIndex];
//					functionIndex++;
//				}
//				newValues[i] = newProbability;
//			}
//			this.samplingRate = newSR;
//			this.xmin = newXmin;
//			this.data=newValues;
		}

		/// <summary>
		/// Returns the next multiple of <c>val</c> which is bigger or equal to n.
		/// </summary>
		/// <param name="val">Value for which the multiple is requested.</param>
		/// <param name="n">Minimum value for the multiple.</param>
		/// <returns></returns>
		private long GetNextMultipleBiggerThanN(long val, long n)
		{
			long multiple = 0;
			while (multiple < n)
			{
				multiple += val;
			}
			return multiple;
		}


		/// <summary>
		/// Create a Function with n values. The sampling rate will be adjusted
		/// </summary>
		/// <param name="n">Number of values for the new function.</param>
		public IDiscreteFunction FunctionWithNValues(int n)
		{
			IDiscreteFunction result = (IDiscreteFunction) this.Clone();
			if( !(this.data.Length<=n)) 
			{
				long newSR = this.SamplingRate * (this.data.Length / n); // newSR is a multiple of the oldSR
				result.AdjustSamplingRate(newSR);
			} 
			else 
			{
				Console.WriteLine("The resulting function has less than " + (n+1) + " values.");
			}
			return result;
		}

		/// <summary>
		/// Writes the function to a stream.
		/// </summary>
		/// <param name="sw"></param>
		public void ToFile(StreamWriter sw)
		{
			sw.WriteLine("Minimum value: " + this.XMin);
			sw.WriteLine("Maximum value: " + this.XMax);
			sw.WriteLine("SamplingRate: " + this.SamplingRate);
			sw.WriteLine("Execution Time: \t Probabilities:");
			for (int i = 0; i<this.Data.Length;i++)
			{
				sw.WriteLine((this.xmin+i*this.SamplingRate)+"\t"+this.Data[i]);
			}
		}

		/// <summary>
		/// Returns a flat copy of the function.
		/// </summary>
		/// <returns></returns>
		public object Clone()
		{
			return new DiscreteFunction(this);
		}

		/// <summary>
		/// Compares both objects of equality. The values of the function are compared to the 
		/// 10th decimal place.
		/// </summary>
		/// <param name="obj">Object which is compared with this.</param>
		/// <returns>True if both objects are equal. False else.</returns>
		public override bool Equals(Object obj)
		{
			int numberOfDigits = 10; // precision of comparison

			if (obj == null || GetType() != obj.GetType()) return false;
			DiscreteFunction other = (DiscreteFunction) obj;

			if (!samplingRate.Equals(other.samplingRate))
				return false;

			if(System.Math.Round(this.Sum(),numberOfDigits)!=
				System.Math.Round(other.Sum(),numberOfDigits)) return false;

			// compare data array
			long length = this.Data.LongLength;
			for (int i=0;i<length;i++)
			{
				if (System.Math.Round(this.data[i], numberOfDigits) != 
					System.Math.Round(other.ValueOf(this.ValueAt(i)), numberOfDigits)) return false;
			}
			return true;
		}

		/// <summary>
		/// Hash function.
		/// </summary>
		/// <returns>Hashcode</returns>
		public override int GetHashCode() 
		{
			return base.GetHashCode();
		}

		#endregion
	}
}
