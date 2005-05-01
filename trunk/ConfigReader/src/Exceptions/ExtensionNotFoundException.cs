using System;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// ExtensionNotFoundException. Thrown if a file extension was not found.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/01 17:23:25  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.1  2004/10/26 16:07:16  kelsaka
	/// added initial version to cvs
	/// </pre>
	/// </remarks>
	public class ExtensionNotFoundException : Exception
	{
		private static string text = "The requested extension could not be found. Information: ";
			 
		/// <summary>
		/// This exception is thrown if a requested exception is not found, e. g. on searching for it.
		/// </summary>
		/// <param name="message">Additional information.</param>
		public ExtensionNotFoundException(string message) : base(text + message)
		{
			
		}

		/// <summary>
		/// default constructor.
		/// </summary>
		public ExtensionNotFoundException()
		{
		}

		/// <summary>
		/// Sets the error message.
		/// </summary>
		public override string Message
		{
			get{ return text; }
		}
	}
}
