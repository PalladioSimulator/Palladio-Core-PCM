using System;
using ReflectionBasedVisitor;

namespace Palladio.Attributes
{
	/// <summary>
	/// Stores information on the type of an attribute. The attribute
	/// type inherits IVisitable in order to e.g. allow specialised
	/// rendering of GUI elements to edit the value of the attribute.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IAttributeType : IVisitable
	{

		/// <summary>
		/// Get a name of the attribute, that is displayed in the property cell
		/// </summary>
		string DisplayName { get; }

		/// <summary>
		/// Get a description of the attribute
		/// </summary>
		string Description { get; }

		/// <summary>
		/// Get a globally unique ID of the attribute used to identify 
		/// the attribute
		/// </summary>
		Guid GUID  { get; }

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		Type ValueType { get; }
	}
}
