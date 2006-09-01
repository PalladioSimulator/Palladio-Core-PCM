using System;
using System.Xml;

namespace Palladio.Performance.Math.Functions.Discrete
{
	/// <summary>
	/// A Class for a probability density function of a random variable.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: DiscretePDFunction.cs,v $
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
	internal class DiscretePDFunction : DiscreteFunction, IDiscretePDFunction
	{
		#region Poperties

		/// <summary>
		/// Median of the function.
		/// </summary>
		public double Median
		{
			get 
			{
				return GetTimeValueOfPercentile(0.5);		
			}
		}
		/// <summary>
		/// Returns the time value of the upper quartil(75%).
		/// </summary>
		public double UpperQuartil
		{
			get 
			{
				return GetTimeValueOfPercentile(0.75);		
			}
		}

		/// <summary>
		/// Expectancy of the function.
		/// </summary>
		public double Expectancy
		{
			get
			{
				if(TotalProb <=0) return 0;
				double e = 0;
				int length = this.Data.Length;
				for (int i=0;i<length;i++) 
				{
					e += this.Data[i] * ValueAt(i);
				}
				return e;
			}
		}

		/// <summary>
		/// Variance of the function. This is s^2=(1/n) * sum_1_n[(x_i - expectancy)^2]
		/// </summary>
		public double Variance
		{
			get
			{
				if(TotalProb <=0) return 0;
				double variance =0;
				double expectancy = this.Expectancy;
				int length = base.Data.Length;
				for (int i=0;i<length;i++) 
				{
					variance += 
						System.Math.Pow(ValueAt(i) - expectancy,2);
				}
				return variance;}
		}

		/// <summary>
		/// Deviation of a function. This is SQRT(Variance)
		/// </summary>
		public double Deviation
		{
			get
			{
				if(TotalProb <=0) return 0;
				return System.Math.Sqrt(this.Variance);
			}
		}

		/// <summary>
		/// Total probability of all values.
		/// </summary>
		public double TotalProb 
		{
			get 
			{
				return Sum();
			}
		}
		#endregion

		#region Methods

		/// <summary>
		/// Create a Function with n values. The sampling rate will be adjusted
		/// </summary>
		/// <param name="n">Number of values for the new function.</param>
		new public IDiscretePDFunction FunctionWithNValues(int n)
		{
			return MathTools.DiscreteFunctions.DiscreteValuePDFunction(base.FunctionWithNValues(n));
		}


		/// <summary>
		/// Returns the time value of a percentile.
		/// </summary>
		/// <param name="percentile">Percentile for which the time value is requested.</param>
		/// <returns>Time value of a percentile.</returns>
		private long GetTimeValueOfPercentile(double percentile)
		{
			double e=0;
			int i=0;
			int length = this.Data.Length;
			while(e<percentile || i >= length) 
			{
				if(i>=length) return -1;
				e += this.Data[i++];
			}
			return ValueAt(i-1);
		}

		public override string ToString()
		{
			string s = "Probability density function:";
			s += "\nSum of all probabilities: " + this.TotalProb;
			s += "\nMedian: " + this.Median;
			s += "\nUpperQuartil: " + this.UpperQuartil;
			s += "\nExpectancy: " + this.Expectancy;
			s += "\nVariance: " + this.Variance;
			s += "\nDeviation: " + this.Deviation;
			s += "\nExecution Time: \t Probabilities:";

			s += base.ToString();
			
			return s;
		}

		/// <summary>
		/// Stores the probability density function as file.
		/// </summary>
		/// <param name="file">Name of the file.</param>
		public void SaveAsXml(string file)
		{
			XmlDocument doc = new XmlDocument();
			XmlElement rootElem=doc.CreateElement("ProbabilityDensityFunction");

			AddPropertiesToXML(doc, rootElem);
			AddFunctionValuestoXML(doc, rootElem);

			doc.AppendChild(rootElem);
			doc.Save(file);
		}

		private void AddPropertiesToXML(XmlDocument doc, XmlElement rootElem)
		{
			AddXmlElement(doc,rootElem,"TotalProbability", this.TotalProb);
			AddXmlElement(doc,rootElem,"Median", this.Median);
			AddXmlElement(doc,rootElem,"UpperQuartil", this.UpperQuartil);
			AddXmlElement(doc,rootElem,"Expectancy", this.Expectancy);
			AddXmlElement(doc,rootElem,"Variance", this.Variance);
			AddXmlElement(doc,rootElem,"Deviation", this.Deviation);
		}

		private void AddXmlElement(XmlDocument doc,XmlElement root, string name, object val)
		{
			XmlElement element = doc.CreateElement(name);
			element.InnerText = Convert.ToString(val);
			root.AppendChild(element);
		}
		private void AddFunctionValuestoXML(XmlDocument doc, XmlElement rootElem)
		{
			int length = this.Data.Length;
			for (int i=0;i<length;i++) 
			{
				XmlElement element = doc.CreateElement("time_consumption");
				XmlAttribute timeValue = doc.CreateAttribute("timeValue");
				timeValue.Value=Convert.ToString(this.ValueAt(i));
				XmlAttribute probability = doc.CreateAttribute("probability");
				probability.Value =Convert.ToString(this.Data[i]);
				element.Attributes.Append(timeValue);
				element.Attributes.Append(probability);
				rootElem.AppendChild(element);
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
		internal DiscretePDFunction(double[] values, long samplingRate, long xmin) : base(values,samplingRate,xmin)
		{
		}

		/// <summary>
		/// Copy Constructor.
		/// </summary>
		/// <param name="df"></param>
		internal DiscretePDFunction(DiscreteFunction df) : base(df)
		{
		}

		#endregion

		#region IFunction

		/// <summary>
		/// Returns a copy of the DiscretePDFunction.
		/// </summary>
		/// <returns></returns>
		new public object Clone()
		{
			return new DiscretePDFunction(this);
		}

		#endregion
	}
}
