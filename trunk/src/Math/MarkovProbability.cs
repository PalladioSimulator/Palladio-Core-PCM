/*
 * $Id$
 * 
 * $Log$
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
using Palladio.Utils.Collections;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// Description of MarkovProbabilityAttribute.	
	/// </summary>
	public class MarkovProbabilityAttribute : VariableExpression
	{
		#region Properties
		
		/// <summary>
		/// Type of the MarkovProbabilityAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get 
			{
				if (attributeType != null)
					return attributeType;
				
				AttributesFactory factory = new AttributesFactory();
				attributeType = factory.Default.CreateAttributeType(new Guid("d3b77ea3-be07-4ee1-959f-a90cf75ca5c8") ,"MarkovProbabilityAttribute", typeof(MarkovProbabilityAttribute));
				return attributeType;
			}
		}
		#endregion
		
		#region Methods
		
		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return expression.ToString();
		}
		#endregion
		
		#region Constructors
		
		/// <summary>
		/// Create a new MarkovProbabilityAttribute and assigns aValue to it. 
		/// </summary>
		/// <param name="aValue">Probability value. It can only be inbetween 0 and 1.</param>
		public MarkovProbabilityAttribute(double aValue) : base(aValue)
		{
			Trace.Assert( aValue >= 0 );
			Trace.Assert( aValue <= 1 );
		}
		
		#endregion
		
		#region Data
		
		private static IAttributeType attributeType = null;
		#endregion
		
	}
}
