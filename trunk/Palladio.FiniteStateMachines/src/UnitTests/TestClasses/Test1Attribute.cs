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
	/// Revision 1.1  2005/08/15 09:53:20  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// </code>
	/// </remarks>
	public class Test1Attribute : IAttribute
	{
		/// <summary>
		/// Default.
		/// </summary>
		public Test1Attribute()
		{
			
		}

		/// <summary>
		/// Inherited from IAttribute.
		/// </summary>
		/// <returns></returns>
		public object Clone ()
		{
			return new Test1Attribute();
		}

		/// <summary>
		/// Test property - returns "Test1-Property".
		/// </summary>
		public string TestProperty
		{
			get
			{
				return "Test1-Property";
			}
		}
	}
}
