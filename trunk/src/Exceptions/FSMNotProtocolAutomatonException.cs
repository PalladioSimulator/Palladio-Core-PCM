using System;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Zusammenfassung für FSMNotProtocolAutomatonException.
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
	public class FSMNotProtocolAutomatonException : ComponentModelException
	{
		public FSMNotProtocolAutomatonException(string message) : base (message) {}
		public FSMNotProtocolAutomatonException(string message, Exception innerException) : base (message,innerException) {}
	}
}
