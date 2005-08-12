using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Class holding a measure value.
	/// </summary>
	internal class Measure
	{
		/// <summary>
		/// Execution time of the measure.
		/// </summary>
		public long executionTime;

		/// <summary>
		/// Constructor. Creates a new Measure object.
		/// </summary>
		/// <param name="executionTime">Execution time of the measure.</param>
		public Measure(long executionTime)
		{
			this.executionTime=executionTime;
		}
	}

	/// <summary>
	/// Attribute containing measured execution times.
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
	public class MeasureAttribute : IAttribute
	{
		#region Data

		/// <summary>
		/// A list of measures.
		/// </summary>
		public ArrayList measures;

		/// <summary>
		/// Attribute type.
		/// </summary>
		private static IAttributeType attributeType =
			AttributesFactory.Default.CreateAttributeType
			(Guid.NewGuid(), "MeasureAttribute",
			typeof (MeasureAttribute));

		#endregion Data

		#region constructor
		/// <summary>
		/// Constructor. Creates a new MeasureAttribute.
		/// </summary>
		public MeasureAttribute()
		{
			measures = new ArrayList();
		}

		#endregion constructor

		#region properties

		/// <summary>
		/// Returns the AttributeType.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		/// <summary>
		/// Returns the minimal execution time of all measures.
		/// </summary>
		public long MinMeasure 
		{
			get
			{
				if(measures.Count<1) return -1;
				long min = ((Measure)measures[0]).executionTime;
				for (int i=1;i<measures.Count;i++) 
				{
					min = System.Math.Min(min,((Measure)measures[i]).executionTime);
				}
				return min;
			}
		}

		/// <summary>
		/// Returns the maximum execution time of all measures.
		/// </summary>
		public long MaxMeasure 
		{
			get
			{
				if(measures.Count<1) return -1;
				long max = ((Measure)measures[0]).executionTime;
				for (int i=1;i<measures.Count;i++) 
				{
					max = System.Math.Max(max,((Measure)measures[i]).executionTime);
				}
				return max;
			}
		}

		/// <summary>
		/// Measures.
		/// </summary>
		public long this[int index]
		{
			get
			{
				return((Measure) this.measures[index]).executionTime;
			}
		}

		#endregion properties

		#region methods

		/// <summary>
		/// Adds a new measure to the MeasureAttribute.
		/// </summary>
		/// <param name="executionTime">Execution time of the measure.</param>
		public void AddMesaure(long executionTime)
		{
			measures.Add(new Measure(executionTime));
		}

		/// <summary>
		/// Adds a new measure to the MeasureAttribute.
		/// </summary>
		/// <param name="executionTime">Execution time of the measure.</param>
		/// <param name="number">Call number of the measure.</param>
		public void AddMeasure(long executionTime, string number)
		{
			measures.Add(new Measure(executionTime));
		}

		#endregion methods

		#region static methods

		/// <summary>
		/// Returns the MeasureAttribute of a given object.
		/// </summary>
		/// <param name="obj">Object which contains a MeasureAttribute.</param>
		/// <returns></returns>
		public static MeasureAttribute GetAttribute(IAttributable obj)
		{
			if(obj.Attributes.Contains(MeasureAttribute.AttributeType)) 
			{
				MeasureAttribute q = obj.Attributes[MeasureAttribute.AttributeType] as MeasureAttribute;
				return q;
			} 
			else 
			{
				return null;
			}
		}

		/// <summary>
		/// Adds a new measure to the MeasureAttribute of the <c>IAttributable</c>
		/// </summary>
		/// <param name="attributable">An <c>IAttributable</c> that contains a MeasureAttribute.</param>
		/// <param name="executionTime">Execution time of the measure.</param>
		public static void AddMeasure(IAttributable attributable, long executionTime)
		{
			MeasureAttribute ma = MeasureAttribute.GetAttribute(attributable);
			if(ma==null) throw new ApplicationException("The IAttributable "
							+ attributable + "does not contain a MeasureAttribute.");
			ma.AddMesaure(executionTime);
			attributable.Attributes.Remove(MeasureAttribute.AttributeType);
			attributable.Attributes.Add(MeasureAttribute.AttributeType,ma);
		}

		#endregion static methods

		#region IAttribute Member

		/// <summary>
		/// 
		/// </summary>
		/// <param name="writer"></param>
		public void Serialize(System.Xml.XmlTextWriter writer)
		{
			// TODO:  Implementierung von ProbabilityAttribute.Serialize hinzufügen
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="element"></param>
		public void Deserialize(System.Xml.XmlNode element)
		{
			// TODO:  Implementierung von ProbabilityAttribute.Deserialize hinzufügen
		}

		/// <summary>
		/// Creates a flat copy of the MeasureAttribute.
		/// </summary>
		/// <returns></returns>
		public object Clone()
		{
			MeasureAttribute measure = new MeasureAttribute();
			measure.measures = (ArrayList) this.measures.Clone();
			return measure;
		}

		#endregion
	}
}
