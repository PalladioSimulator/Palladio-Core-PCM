using System;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.UnitTests.TestClasses
{
	/// <summary>
	/// AttributeType for testing purposes
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/09/08 07:24:23  joemal
	/// to be continued ...
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
	public class Test1AttributeType : IAttributeType
	{
		//the type of this implementation 
		private static Guid TYPEID = new Guid("8FD98D90-3592-4080-B846-4F3CA860CBBC");

		/// <summary>
		/// Default.
		/// </summary>
		public Test1AttributeType()
		{
			
		}

		/// <summary>
		/// Get a name of the attribute, that is displayed in the property cell
		/// </summary>
		public string DisplayName
		{
			get
			{
				return "This is the display name of Test1AttributeType.";
			}
		}

		/// <summary>
		/// Get a description of the attribute
		/// </summary>
		public string Description
		{
			get
			{
				return "This is the description of Test1AttributeType.";
			}
		}

		/// <summary>
		/// Get a globally unique ID of the attribute used to identify 
		/// the attribute
		/// </summary>
		public Guid GUID
		{
			get
			{ 
				return Test1AttributeType.TYPEID;
			}
		}

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		public Type ValueType
		{
			get
			{ 
				return typeof(string);
			}
		}
	}
}
