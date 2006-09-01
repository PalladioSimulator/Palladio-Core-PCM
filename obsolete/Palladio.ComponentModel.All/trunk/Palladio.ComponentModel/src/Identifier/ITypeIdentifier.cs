using Palladio.Identifier;

namespace Palladio.ComponentModel.Identifier
{
	/// <summary>
	/// This Interface declares an identifier for the implementations of the interface <code>IType</code>.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/23 18:58:18  joemal
	/// initial creation
	///
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface ITypeIdentifier
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
