using System;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// ExtensionNotFoundException.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/10/26 16:07:16  kelsaka
	/// added initial version to cvs
	///
	///
	///
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


		public ExtensionNotFoundException()
		{
		}



		public override string Message
		{
			get{ return text; }
		}
	}
}
