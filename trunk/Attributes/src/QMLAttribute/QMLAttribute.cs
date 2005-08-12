using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.Performance.Math;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Describes the time behavior of a service by a list of percentile aspects of the
	/// Quality of Service Modeling Language. 
	/// Usage:   Percentile   |   Value
	///              20%          20ms
	///              40%          77ms
	///              100%         100ms
	/// 
	/// A percentile and a value together builds a qml aspect. The first line means that 20% of all execution
	/// of a service is below 20 ms.
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
	public class QMLAttribute : IAttribute
	{
		#region Data

		/// <summary>
		/// A list of percentile aspects.
		/// </summary>
		private PercentileAspect[] aspects;

		/// <summary>
		/// Define the AttributeType.
		/// </summary>
		private static IAttributeType attributeType =
			AttributesFactory.Default.CreateAttributeType
			(Guid.NewGuid(), "QMLAttribute",
			typeof (QMLAttribute));


		#endregion Data

		#region properties
		/// <summary>
		/// AttributeType of the QmlAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		/// <summary>
		/// Number of aspects.
		/// </summary>
		public int Length
		{
			get { return this.aspects.Length; }
		}

		/// <summary>
		/// A list of percentile aspects.
		/// </summary>
		public PercentileAspect[] Aspects
		{
			get { return aspects; }
		}

		#endregion

		#region constructor

		/// <summary>
		/// Constructor.
		/// </summary>
		/// <param name="percentile">Percentile.</param>
		/// <param name="values">Time Consumtion.</param>
		public QMLAttribute(double[] percentile, long[] values)
		{
			Validate(percentile, values);
			SetAspectValues(percentile, values);
		}

		private QMLAttribute(PercentileAspect[] aspects)
		{
			this.aspects = new PercentileAspect[aspects.Length];
			aspects.CopyTo(this.aspects,0);
		}

		/// <summary>
		/// Sets the aspect values-
		/// </summary>
		/// <param name="percentile">Percentile.</param>
		/// <param name="values">Time consumption.</param>
		private void SetAspectValues(double[] percentile, long[] values)
		{
			int length = percentile.Length;
			this.aspects = new PercentileAspect[length];
	
			for(int i=0;i<length;i++)
			{
				aspects[i]= new PercentileAspect(percentile[i], values[i]);
			}
		}

		/// <summary>
		/// Checks whether the aspects are in ascending order and the highest percentile is not bigger than
		/// 100%.
		/// </summary>
		/// <param name="percentile">Percentiles of the aspect.</param>
		/// <param name="values">values of the aspect.</param>
		private void Validate(double[] percentile, long[] values)
		{
			int length = values.Length;
			if (percentile.Length != length) 
				throw new ApplicationException("Both arrays must have the same length!");
			
			if (length<1) throw new ApplicationException ("Can´t create a QML-Attribute with 0 vaules.");

			if (percentile[length-1] <100) 
				Console.WriteLine("QMLAttribute Warning: The highest percentile is smaller than 100.");

			for (int i=0;i<length;i++)
			{
				if(i<length-1)
					if(percentile[i]>percentile[i+1] || values[i] >= values[i+1])
						throw new ApplicationException
							("QMLAttribute: percentile and times must be in ascending order.");

				if (percentile[i] <0 || System.Math.Round(percentile[i],5) > 100)
					throw new ApplicationException
						("A percentile must be a value bigger than 0 but not bigger than 100.");

				if (values[i] <0)
					throw new ApplicationException("The execution time must be positive.");
			}
		}

		#endregion constructor

		#region Methods

		/// <summary>
		/// Returns the maximum time value.
		/// </summary>
		/// <returns>Maximum time value.</returns>
		public long GetMaxTime()
		{
			return Aspects[Aspects.Length-1].TimeValue;
		}

		/// <summary>
		/// Returns the density function of the QMLAttribute.
		/// </summary>
		/// <returns>Density function of the QMLAttribute</returns>
		internal QmlDensityFunction GetQmlDensityFunction()
		{
			QmlDensityFunction densityFunction = new QmlDensityFunction(this.Length);
			
			densityFunction.QmlDensityFunctionValues[0] = new QmlDensityFunctionValue(Aspects[0].TimeValue,
				Aspects[0].Percentile/100);

			for(int i=1; i<this.Length;i++)
			{
				densityFunction.QmlDensityFunctionValues[i] = 
					new QmlDensityFunctionValue(Aspects[i].TimeValue,
					(Aspects[i].Percentile - Aspects[i-1].Percentile) / 100);
			}
			return densityFunction;
		}

		/// <summary>
		/// Returns the QMLAttribute of the object. If it
		/// has no QMLAttribute null is returned.
		/// </summary>
		/// <param name="obj">Object for which the <c>QMLAttribute</c> is requested.</param>
		/// <returns><c>QMLAttribute</c> of the object.</returns>
		public static QMLAttribute GetAttribute(IAttributable obj)
		{
			if(obj.Attributes.Contains(QMLAttribute.AttributeType)) 
			{
				return (QMLAttribute) obj.Attributes[QMLAttribute.AttributeType];
			} 
			else 
			{
				return null;
			}
		}


		/// <summary>
		/// Creates a string representation of thew object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			string ret = "QML aspects: ";
			for(int i=0;i<Aspects.Length;i++)
			{
				ret += Aspects[i] + ", ";
			}
			return ret;
		}


		/// <summary>
		/// Compares both objects of equality.
		/// </summary>
		/// <param name="obj">Object which is compared with this.</param>
		/// <returns>True if both objects are equal. False else.</returns>
		public override bool Equals(object obj)
		{
			if (obj == null || GetType() != obj.GetType()) return false;
			QMLAttribute other = (QMLAttribute) obj;
			if(other.Length!=this.Length) return false;

			int length = this.Length;
			for(int i=0;i<length;i++)
			{
				if(!Aspects[i].Percentile.Equals(other.Aspects[i].Percentile)) return false;
				if(!Aspects[i].TimeValue.Equals(other.Aspects[i].TimeValue)) return false;
			}
			return true;
		}

		/// <summary>
		/// Hash function.
		/// </summary>
		/// <returns>Hashcode.</returns>
		public override int GetHashCode() 
		{
			return base.GetHashCode();
		}

		/// <summary>
		/// Stores the <c>QMLAttribute</c> as file.
		/// </summary>
		/// <param name="file">Name of the file.</param>
		public void SaveAsXml(string file)
		{
			XmlDocument doc = new XmlDocument();
			XmlElement rootElem=doc.CreateElement("ComputedTimeConsumptionOfService");
			int length = this.Length;
			for (int i=0;i<length;i++) 
			{
				XmlElement element = doc.CreateElement("time_consumption");
				XmlAttribute percentile = doc.CreateAttribute("percentile");
				percentile.Value=Convert.ToString(Aspects[i].Percentile);
				XmlAttribute time = doc.CreateAttribute("time");
				time.Value =Convert.ToString(Aspects[i].TimeValue);
				element.Attributes.Append(percentile);
				element.Attributes.Append(time);
				rootElem.AppendChild(element);
			}
			doc.AppendChild(rootElem);
			doc.Save(file);
		}

		#endregion Methods

		#region ICloneable Member

		/// <summary>
		/// Returns a flat copy of the QMLAttribute.
		/// </summary>
		/// <returns>Copy of the <c>QMLAttribute</c>.</returns>
		public object Clone()
		{
			return new QMLAttribute(Aspects);
		}

		#endregion
	}
}
