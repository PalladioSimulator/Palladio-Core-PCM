using System;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.UnitTests.TestClasses
{
	/// <summary>
	/// Attribute for testing purposes
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/09/12 19:02:42  joemal
	/// some changes in xml schema
	///
	/// Revision 1.1  2005/08/21 18:07:42  kelsaka
	/// - added further tests
	///
	/// Revision 1.1  2005/08/15 09:53:20  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// </code>
	/// </remarks>
	public class Test1Attribute : IAttribute
	{
		#region data

		//holds the value
		private double value;

		//holds the unit of the value
		private string unit;

		#endregion

		/// <summary>
		/// called to create a new Test Attribute with given value and unit
		/// </summary>
		/// <param name="value">the value</param>
		/// <param name="unit">the unit</param>
		public Test1Attribute(double value, string unit)
		{
			this.value = value;
			this.unit = unit;
		}

		/// <summary>
		/// Inherited from IAttribute.
		/// </summary>
		/// <returns></returns>
		public object Clone ()
		{
			return new Test1Attribute(this.value,this.unit);
		}

		/// <summary>
		/// called to return the value of this attribute
		/// </summary>
		public double Value
		{
			get { return this.value; }
		}

		/// <summary>
		/// called to return the unit of this attribute
		/// </summary>
		public string Unit
		{
			get { return unit; }
		}
	}
}
