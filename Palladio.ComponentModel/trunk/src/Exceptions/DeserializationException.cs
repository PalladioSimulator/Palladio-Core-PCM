using System;

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
	/// Revision 1.1  2004/09/02 12:50:06  uffi
	/// Added XML Serialization and Deserialization functionality
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
