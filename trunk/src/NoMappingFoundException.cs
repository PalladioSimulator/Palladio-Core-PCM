using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für NoMappingFoundException.
	/// </summary>
	public class NoMappingFoundException : Exception
	{
		public NoMappingFoundException(AbstractComponentInterface aCompIface) : 
			base ("No binding found for: "+aCompIface.Name)
		{
		}	
	}
}
