using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if the name of the expectedType cannot be 
	/// resolved by the reflection API.
	/// </summary>
	public class TypeNotFoundException : Exception
	{
		/// <summary>
		/// Thrown, if the name of the expectedType cannot be 
		/// resolved by the reflection API.
		/// </summary>
		/// <param name="expectedType">Name of the type which should be resolved.</param>
		public TypeNotFoundException(string expectedType) : 
			base ("No type found for: "+expectedType)
		{
		}	
	}
}
