using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.Performance.Math;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Represents a random variable of a service-effect-transition or state. It
	/// defines the time behavior of a state or a transition in a service effect automaton.
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
	public class RandomVariable : IAttribute
	{
		#region Data
		/// <summary>
		/// Time behavior of the RandomVariable
		/// </summary>
		private IDiscretePDFunction probabilityDensityFunction;

		/// <summary>
		/// AttributeType.
		/// </summary>
		private static IAttributeType attributeType =
			AttributesFactory.Default.CreateAttributeType
			(Guid.NewGuid(), "RandomVariable",
			typeof (RandomVariable));

		#endregion data

		#region properties

		/// <summary>
		/// Returns the RandomVariable of an object. If the RandomVariable doesn´t have a RandomVariable
		/// an exception is thrown.
		/// </summary>
		/// <param name="obj">Object which contains a RandomVariable.</param>
		/// <returns>RandomVariable of the object.</returns>
		public static RandomVariable GetAttribute(IAttributable obj)
		{
			if(obj.Attributes.Contains(RandomVariable.AttributeType))
			{
				return obj.Attributes[RandomVariable.AttributeType] as RandomVariable;
			} 
			else 
			{
				throw new ApplicationException("Object " + obj +" does not contain a RandomVariable!");
			}
		}

		/// <summary>
		/// Attaches a RandomVariable to an object.
		/// </summary>
		/// <param name="obj">Object to which the RandomVariable shall be added.</param>
		/// <param name="attr">The RandomVariable which shall be added to the object.</param>
		public static void SetAttribute(IAttributable obj, RandomVariable attr)
		{
			obj.Attributes.Add(RandomVariable.AttributeType, attr);
		}

		/// <summary>
		/// Attribute type.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get 
			{
				return attributeType;
			}
		}

		/// <summary>
		/// Time consumption as a probability density function.
		/// </summary>
		public IDiscretePDFunction ProbabilityDensityFunction 
		{ 
			get 
			{
				return probabilityDensityFunction;
			}

			set 
			{
				this.probabilityDensityFunction = value;
			}
		} 


		#endregion properties
		
		#region constructors
		/// <summary>
		/// Deault Constructor. The pdf has the execution time of 0 and a samplingrate of 0. 
		/// </summary>
		public RandomVariable()
		{
			this.probabilityDensityFunction = 
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(0, 0 ,new double[]{1});
		}


		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="function">Probability density function.</param>
		public RandomVariable(IDiscreteFunction function)
		{
			this.probabilityDensityFunction = MathTools.DiscreteFunctions.DiscreteValuePDFunction(function);
		}

		/// <summary>
		/// Constructor for RandomVariable.
		/// </summary>
		/// <param name="samplingRate">New sampling rate for the function.</param>
		/// <param name="function">Probability density function for the <c>RandomVariable</c>.</param>
		public RandomVariable(long samplingRate, IDiscreteFunction function)
		{
			function.AdjustSamplingRate(samplingRate);
			this.probabilityDensityFunction = MathTools.DiscreteFunctions.DiscreteValuePDFunction(function);
		}

		/// <summary>
		/// Constructor for RandomVariable.
		/// </summary>
		/// <param name="minTime">Minimal execution time.</param>
		/// <param name="samplingRate">Distance between two values.</param>
		/// <param name="values">y-values of the probability density function.</param>
		public RandomVariable(long minTime, long samplingRate, double[] values)
		{
			this.probabilityDensityFunction = 
				MathTools.DiscreteFunctions.DiscreteValuePDFunction(minTime, samplingRate ,values);
		}

		/// <summary>
		/// Copy Constructor for RandomVariable.
		/// </summary>
		/// <param name="r"></param>
		public RandomVariable(RandomVariable r) 
		{
			this.probabilityDensityFunction = (IDiscretePDFunction) r.probabilityDensityFunction.Clone();
		}

		#endregion constructors

		#region methods

		/// <summary>
		/// Adjusts the samplingrate of both <c>RandomVariable</c> to the same value.
		/// </summary>
		/// <param name="r1"></param>
		/// <param name="r2"></param>
		public static void AdjustSamplingRate(ref RandomVariable r1, ref RandomVariable r2)
		{
			if (r1.ProbabilityDensityFunction.SamplingRate != r2.ProbabilityDensityFunction.SamplingRate)
			{
				if (r1.ProbabilityDensityFunction.SamplingRate == 0) // check for epsilon transition
				{
					r1.ProbabilityDensityFunction.SamplingRate = r2.ProbabilityDensityFunction.SamplingRate;
				}
				else if (r2.ProbabilityDensityFunction.SamplingRate == 0)
				{
					r2.ProbabilityDensityFunction.SamplingRate = r1.ProbabilityDensityFunction.SamplingRate;
				}
				else
				{
					long gcd = MathTools.GCD(r1.ProbabilityDensityFunction.SamplingRate,
						r2.ProbabilityDensityFunction.SamplingRate);
					r1.ProbabilityDensityFunction.SamplingRate = gcd;
					r2.ProbabilityDensityFunction.SamplingRate = gcd;
				}
			}
		}

		/// <summary>
		/// Returns a string representation of the PDF. Only values unlike 0 are listed.
		/// </summary>
		/// <returns>String representation of the RandomVariable.</returns>
		public override string ToString()
		{
			return this.probabilityDensityFunction.ToString();
		}


		/// <summary>
		/// Compares both objects of equality.
		/// </summary>
		/// <param name="obj">Object which is compared with this.</param>
		/// <returns>True if both objects are equal. False else.</returns>
		public override bool Equals(Object obj)
		{
			if (obj == null || GetType() != obj.GetType()) return false;
			RandomVariable other = (RandomVariable) obj;
			return this.ProbabilityDensityFunction.Equals(other.ProbabilityDensityFunction);
		}

		/// <summary>
		/// Hash function.
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode() 
		{
			return base.GetHashCode();
		}

		#endregion

		#region IAttribute Member

		/// <summary>
		/// 
		/// </summary>
		/// <param name="writer"></param>
		public void Serialize(XmlTextWriter writer)
		{
			// TODO:  Implementierung von RandomVariable.Serialize hinzufügen
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="element"></param>
		public void Deserialize(XmlNode element)
		{
			// TODO:  Implementierung von RandomVariable.Deserialize hinzufügen
		}

		/// <summary>
		/// Returns a copy of the RandomVariable.
		/// </summary>
		/// <returns></returns>
		public object Clone(){
			return new RandomVariable(this);
		}

		#endregion
	}
}
