using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// A hashtable containing attributes which are associated to certain
	/// objects in other data structures. Those attributes need to have
	/// a type. 
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
	public interface IAttributeHash	: ICloneable
	{
		/// <summary>
		/// Add the value of an attribute with the given type to this 
		/// hashtable
		/// </summary>
		/// <param name="type">The type of the attribute to add</param>
		/// <param name="val">The value of the attribute to add</param>
		void Add (IAttributeType type, IAttribute val);

		/// <summary>
		/// Get the value of the attribute with the specified type
		/// </summary>
		IAttribute this [IAttributeType type] { get; }
	}
}
