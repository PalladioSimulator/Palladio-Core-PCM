using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if an interface cannot be mapped onto another
	/// interface by matching the names of the interfaces.
	/// </summary>
	public class NoMappingFoundException : Exception
	{
		/// <summary>
		/// Thrown, if an interface cannot be mapped onto another
		/// interface by matching the names of the interfaces.
		/// </summary>
		/// <param name="aCompIface">Interface, which cannot be mapped.</param>
		public NoMappingFoundException(AbstractComponentInterface aCompIface) : 
			base ("No binding found for: "+aCompIface.Name)
		{
		}	
	}
}
