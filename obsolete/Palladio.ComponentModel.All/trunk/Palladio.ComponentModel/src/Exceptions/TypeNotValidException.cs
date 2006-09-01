namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Thrown, if a type not a valid subtype of e. g. an exception.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// </pre>
	/// </remarks>
	public class TypeNotValidException : ComponentModelException
	{
		/// <summary>
		/// Thrown, if a type not a valid subtype of e. g. an exception.
		/// </summary>
		/// <param name="type">The given type name</param>
		public TypeNotValidException(string type) : 
			base ("No valid type: " + type)
		{
		}	
	}
}
