using System;
using ReflectionBasedVisitor;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.CM.Example;

namespace Palladio.Reliability
{
	/// <summary>
	/// Description of MyClass.
	/// </summary>
	public class ReliabilityValue
	{
		public double Value
		{
			get { return val; }
			set { val = value; }
		} 
		
		public ReliabilityValue(double v)
		{
			val = v;
		}
		
		public static ReliabilityValue operator+(ReliabilityValue a, ReliabilityValue b)
		{
			return new ReliabilityValue( a.Value + b.Value );
		}
		
		public static ReliabilityValue operator-(ReliabilityValue a, ReliabilityValue b)
		{
			return new ReliabilityValue( a.Value - b.Value );
		}

		public static ReliabilityValue operator*(ReliabilityValue a, ReliabilityValue b)
		{
			return new ReliabilityValue( a.Value * b.Value );
		}
		
		public static ReliabilityValue operator/(ReliabilityValue a, ReliabilityValue b)
		{
			return new ReliabilityValue( a.Value / b.Value );
		}	
		
		public override string ToString()
		{
			return val.ToString();
		}
		
		private double val;
	}
}
