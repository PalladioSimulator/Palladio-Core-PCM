namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Zusammenfassung für DeserializationException.
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
	public class DeserializationException : ComponentModelException
	{
		public DeserializationException(string reason) : base("Could not deserialize. "+reason)
		{
		}
	}
}
