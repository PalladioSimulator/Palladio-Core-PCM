using System;

namespace Palladio.Identifier
{
	/// <summary>
	/// Data objects implementing this interface can be identified by a 
	/// probably unique Identifier
	/// </summary>
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
