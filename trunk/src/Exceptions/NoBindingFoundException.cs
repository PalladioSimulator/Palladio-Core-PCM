using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if an interface cannot be bound to another interface
	/// by matching their names.
	/// </summary>
	public class NoBindingFoundException : Exception
	{
		/// <summary>
		/// Thrown, if an interface cannot be bound to another interface
		/// by matching their names.
		/// </summary>
		/// <param name="aReqIface">Interface which cannot be bound</param>
		public NoBindingFoundException(RequiresInterface aReqIface) : 
			base ("No binding found for: "+aReqIface.Name)
		{
		}
	}
}
