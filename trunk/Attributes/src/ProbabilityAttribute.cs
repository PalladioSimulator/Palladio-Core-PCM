/*
 * $Id$
 * 
 * $Log$
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
using System.Diagnostics;
using Palladio.Attributes;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Attribute containig the Markov Probability of a transition.	
	/// </summary>
	public class ProbabilityAttribute
	{
		#region Properties

		/// <summary>
		/// The value of the MarkovProbabilityAttribute.
		/// </summary>
		public double Probability
		{
			get { return markovProbability; }
			set { markovProbability = value; }
		}


		/// <summary>
		/// Type of the MarkovProbabilityAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return markovProbability.ToString();
		}

		/// <summary>
		/// Returns the MarkovAttribute of the object. If it
		/// has no MarkovAttribute null is returned.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public static ProbabilityAttribute GetAttribute(IAttributable obj)
		{
			return obj.Attributes[ProbabilityAttribute.AttributeType] as ProbabilityAttribute;
		}

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

		#endregion

		#region Constructors

		/// <summary>
		/// Create a new MarkovProbabilityAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Probability value. It can only be inbetween 0 and 1.</param>
		public ProbabilityAttribute(double aValue)
		{
			markovProbability = aValue;
		}

		#endregion

		#region Data

		private double markovProbability;
		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("96B433EC-D17C-480c-A35F-AE45D98A0619"), "MarkovProbabilityAttribute", typeof (ProbabilityAttribute));

		#endregion
	}
}