using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// General representation of connection between two interfaces.
	/// </summary>
	public interface IConnection : ICloneable
	{

		/// <summary>
		/// Returns an IInterfaceModel representing the lowest common denominator
		/// of both IInterfaceModels involved in the connection.
		/// </summary>
		/// <returns>
		/// IInterfaceModel of highest possible level.
		/// </returns>
		IInterfaceModel GetIntersection ();
	}
}
