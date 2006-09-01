using System;

namespace Palladio.Attributes
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
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
		IAttributeHash Attributes { get; }
	}
}
