using System;
using System.Collections;

namespace Palladio.Attributes
{
	/// <summary>
	/// A default implementation of an IAttributeHash.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/05/13 15:17:31  sbecker
	/// Initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class AttributeHash : IAttributeHash
	{
		/// <summary>
		/// The hashtable used to store the values
		/// </summary>
		protected Hashtable hash = new Hashtable();

		/// <summary>
		/// Add the value of an attribute with the given type to this 
		/// hashtable
		/// </summary>
		/// <param name="type">The type of the attribute to add</param>
		/// <param name="val">The value of the attribute to add</param>
		public void Add (IAttributeType type, object val)
		{
			if (hash.Contains(type.GUID))
				hash.Remove(type.GUID);
			hash.Add(type.GUID,val);
		}

		/// <summary>
		/// Get the value of the attribute with the specified type
		/// </summary>
		public object this[IAttributeType type]
		{
			get
			{
				return hash[type.GUID];
			}
		}
	}
}
