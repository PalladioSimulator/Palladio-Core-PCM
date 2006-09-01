/*
 *
 * Revision 1.1  2004/12/15 00:05:12  sliver
 * initial checkin after some major refactorings
 *
 * Revision 1.1  2004/11/18 06:53:17  sliver
 * *** empty log message ***
 *
 * Revision 1.1  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.3  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.2  2004/07/30 01:25:51  sliver
 * Some changes...
 *
 * Revision 1.1  2004/07/19 04:37:48  sliver
 * extracted attributes
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 *
 * Revision 1.1  2004/07/06 00:30:44  sliver
 * + added Markov Probability for transitions
 * + CCVisitor propagates the reliability now
 * 
 */

using System;
using System.Xml;
using Palladio.Attributes;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Attribute containig the probability of a transition. Each transition in a 
	/// service-effect-automaton should have an ProbabilityAttribute
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/10/11 22:05:13  helgeh
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
	public class ProbabilityAttribute : IAttribute
	{
		#region Data

		private double probability;
		private static IAttributeType attributeType = 
			AttributesFactory.Default.CreateAttributeType(new Guid(), "ProbabilityAttribute", 
			typeof (ProbabilityAttribute));

		#endregion

		#region Properties

		/// <summary>
		/// The value of the ProbabilityAttribute.
		/// </summary>
		public double Probability
		{
			get { return probability; }
			set { ValidateProbability(value); probability = value; }
		}
		/// <summary>
		/// Type of the ProbabilityAttribute.
		/// </summary>
		/// 
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		#endregion

		#region Methods


		private void ValidateProbability(double probability)
		{
			if(probability < 0)
				throw new ApplicationException("The probability mus be a positive value.");
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return probability.ToString();
		}

		/// <summary>
		/// Returns the ProbabilityAttribute of the object. If it
		/// has no Probability null is returned.
		/// </summary>
		/// <param name="obj"><c>IAttributable</c> for which a <c>ProbabilityAttribute</c> is requested.</param>
		/// <returns><c>ProbabilityAttribute</c> of the <c>IAttributable</c> or null if it has none.</returns>
		public static ProbabilityAttribute GetAttribute(IAttributable obj)
		{
			if(obj.Attributes.Contains(ProbabilityAttribute.AttributeType)) 
			{
				return (ProbabilityAttribute) obj.Attributes[ProbabilityAttribute.AttributeType];
			} else {
				return null;
			}
		}

		/// <summary>
		/// Attaches a ProbabilityAttribute to an object.
		/// </summary>
		/// <param name="obj">Object where the Attribute shall be attached.</param>
		/// <param name="aValue">Probability.</param>
		public static void SetAttribute(IAttributable obj, double aValue)
		{
			ProbabilityAttribute attr = GetAttribute(obj);
			if (attr == null)
			{
				obj.Attributes.Add(ProbabilityAttribute.AttributeType, new ProbabilityAttribute(aValue));
			}
			else
			{
				attr.Probability = aValue;
			}
		}

		/// <summary>
		/// Compares both objects of equality.
		/// </summary>
		/// <param name="obj">Object which is compared with this.</param>
		/// <returns>True if both objects are equal. False else.</returns>
		public override bool Equals(object obj)
		{
			if (obj == null || GetType() != obj.GetType()) return false;
			ProbabilityAttribute other = (ProbabilityAttribute) obj;
			return this.Probability.Equals(other.Probability);
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

		#region Constructors

		/// <summary>
		/// Create a new ProbabilityAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Probability value. It can only be inbetween 0 and 1.</param>
		public ProbabilityAttribute(double aValue)
		{
			ValidateProbability(aValue);
			probability = aValue;
		}

		/// <summary>
		/// Default Constructor with a probability of 1.
		/// </summary>
		public ProbabilityAttribute()
		{
			probability = 1.0;
		}
		

		#endregion

		#region IAttribute Member

		/// <summary>
		/// 
		/// </summary>
		/// <param name="writer"></param>
		public void Serialize(XmlTextWriter writer)
		{
			// TODO:  Implementierung von ProbabilityAttribute.Serialize hinzufügen
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="element"></param>
		public void Deserialize(XmlNode element)
		{
			// TODO:  Implementierung von ProbabilityAttribute.Deserialize hinzufügen
		}

		/// <summary>
		/// Returns a copy of the ProbabilityAttribute.
		/// </summary>
		/// <returns></returns>
		public object Clone(){
			return new ProbabilityAttribute(this.probability);
		}

		#endregion
	}
}