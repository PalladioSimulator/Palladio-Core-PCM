using System;

namespace Palladio.Webserver.WebserverMonitor
{
	/// <summary>
	/// IWebserverMonitor.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 09:37:19  kelsaka
	/// minor changes
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IWebserverMonitor
	{


		/// <summary>
		/// Writes debugMessage to defined (see xml-config-file) log-file.
		/// </summary>
		/// <param name="debugMessage">The message.</param>
		/// <param name="debugLevel">How critical is the message. Use "0" for important and "5" for less
		/// important messages.</param>
		void writeDebugMessage(string debugMessage, int debugLevel);

		/// <summary>
		/// Writes general loginformations to the specified file.
		/// </summary>
		/// <param name="logMessage">The message to write</param>
		void writeLogEntry(string logMessage);

	}
}
 