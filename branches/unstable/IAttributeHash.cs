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
	/// Revision 1.2.2.1  2004/12/02 23:37:39  uffi
	/// major changes in Palladio.Attributes,
	/// IAttribute added for implementations of attribute values,
	/// AttributeHash is now a typed Hashtable,
	/// IAttributeHash and Factories are currently obsolete, still in repository though.
	///
	/// Revision 1.2  2004/05/18 13:19:58  sliver
	/// Added Clone method for AttributeHash
	///
	/// Revision 1.1  2004/05/13 15:17:31  sbecker
	/// Initial import
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
