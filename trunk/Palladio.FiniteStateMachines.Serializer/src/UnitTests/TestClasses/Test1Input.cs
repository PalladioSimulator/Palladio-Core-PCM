using System;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.UnitTests.TestClasses
{
	/// <summary>
	/// Input for testing purposes
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/25 18:43:47  kelsaka
	/// - support for default input serialization.
	///
	/// </code>
	/// </remarks>
	public class Test1Input : IInput
	{
		/// <summary>
		/// Default.
		/// </summary>
		public Test1Input()
		{
			
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

		/// <summary>
		/// The ID of the input symbol used for a certain transition
		/// </summary>
		public IMatchable ID
		{
			get
			{ 
				throw new NotImplementedException();
			}
		}

		/// <summary>
		/// Defines the type of the actual input symbol. A set of input
		/// symbol can belong to one type.
		/// </summary>
		public Guid TypeID
		{
			get
			{
				return new Guid("12345678-1111-0815-4711-123458009010");
			}
		}
	}
}
