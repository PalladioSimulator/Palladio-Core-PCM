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
