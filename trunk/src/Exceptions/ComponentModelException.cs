using System;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Zusammenfassung für ComponentModelException.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/05/19 07:48:39  sbecker
	/// Added more exceptions
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentModelException : Exception
	{
		public ComponentModelException(string message) : base(message) {}
		public ComponentModelException(string message, Exception innerException) : base(message,innerException) {}
	}
}
