/*
 * $Id$
 * 
 * $Log$
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
using Palladio.Reliability.Math;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Attribute containig the Markov Probability of a transition.	
	/// </summary>
	public class MarkovProbabilityAttribute
	{
		#region Properties

		/// <summary>
		/// The value of the MarkovProbabilityAttribute.
		/// </summary>
		public IVariableExpression MarkovProbability
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

		#endregion

		#region Constructors

		/// <summary>
		/// Create a new MarkovProbabilityAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Probability value. It can only be inbetween 0 and 1.</param>
		public MarkovProbabilityAttribute(double aValue)
		{
			Trace.Assert(aValue >= 0);
			Trace.Assert(aValue <= 1);
			markovProbability = new VariableExpression(aValue);
		}

		#endregion

		#region Data

		private IVariableExpression markovProbability;
		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("d3b77ea3-be07-4ee1-959f-a90cf75ca5c8"), "MarkovProbabilityAttribute", typeof (MarkovProbabilityAttribute));

		#endregion
	}
}