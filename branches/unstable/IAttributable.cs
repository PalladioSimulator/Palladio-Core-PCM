using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1.2.1  2004/12/02 23:37:39  uffi
	/// major changes in Palladio.Attributes,
	/// IAttribute added for implementations of attribute values,
	/// AttributeHash is now a typed Hashtable,
	/// IAttributeHash and Factories are currently obsolete, still in repository though.
	///
	/// Revision 1.1  2004/05/17 14:07:33  sliver
	/// added interface for attributable classes
	///
	/// </pre>
	/// </remarks>
	public interface IAttributable
	{
		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		AttributeHash Attributes { get; }
	}
}
