/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/07/06 00:30:44  sliver
 * + added Markov Probability for transitions
 * + CCVisitor propagates the reliability now
 * 
 */

using System;

using Palladio.Attributes;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of MarkovProbability.	
	/// </summary>
	public class MarkovProbability
	{
		public double Value
		{
			get { return val; }
			set { val = value; }
		} 
		
		public MarkovProbability(double v)
		{
			val = v;
		}
		
		
		public static IAttributeType AttributeType
		{
			get 
			{
				if (attributeType != null)
					return attributeType;
				
				AttributesFactory factory = new AttributesFactory();
				attributeType = factory.Default.CreateAttributeType(new Guid("d3b77ea3-be07-4ee1-959f-a90cf75ca5c8") ,"MarkovProbability", typeof(MarkovProbability));
				return attributeType;
			}
		}
		
		public static MarkovProbability operator+(MarkovProbability a, MarkovProbability b)
		{
			return new MarkovProbability( a.Value + b.Value );
		}
		
		public static MarkovProbability operator-(MarkovProbability a, MarkovProbability b)
		{
			return new MarkovProbability( a.Value - b.Value );
		}

		public static MarkovProbability operator*(MarkovProbability a, MarkovProbability b)
		{
			return new MarkovProbability( a.Value * b.Value );
		}
		
		public static MarkovProbability operator/(MarkovProbability a, MarkovProbability b)
		{
			return new MarkovProbability( a.Value / b.Value );
		}	
		
		public override string ToString()
		{
			return val.ToString();
		}
		
		
		
		private double val;
		
		private static IAttributeType attributeType = null;
	}
}
