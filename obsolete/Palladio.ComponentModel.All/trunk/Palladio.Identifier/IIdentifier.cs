using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// Interface for Identifier types. If you want to create a new ID type implement this
	/// interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/03/15 12:35:15  joemal
	/// the refactoring of the componentmodel
	///
	/// Revision 1.1  2005/02/21 12:15:57  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IIdentifier : ICloneable
	{
		/// <summary>
		/// returns a string that represents the id.
		/// </summary>
		string Key
		{
			get;			
		}

		/// <summary>
		/// determ whether the given string matchs to this id.
		/// </summary>
		/// <param name="key">the key that represents an id</param>
		/// <returns>true, if the given key matchs to this id</returns>
		bool Match(string key);
	}
}
