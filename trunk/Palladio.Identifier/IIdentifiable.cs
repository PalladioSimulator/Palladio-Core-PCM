using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// Data objects implementing this interface can be identified by a 
	/// probably unique Identifier
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 12:15:57  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IIdentifiable
	{
		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		IIdentifier ID
		{
			get;
		}
	}
}
