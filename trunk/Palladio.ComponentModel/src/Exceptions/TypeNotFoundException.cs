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
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
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
