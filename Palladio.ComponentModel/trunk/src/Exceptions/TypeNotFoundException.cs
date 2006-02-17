using System;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Thrown, if the name of the expectedType cannot be 
	/// resolved by the reflection API.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// </pre>
	/// </remarks>
	public class TypeNotFoundException : ComponentModelException
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
