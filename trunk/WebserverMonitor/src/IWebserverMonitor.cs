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
	/// Revision 1.5  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.4  2004/10/23 14:08:36  kelsaka
	/// first steps on reading xml-config-files
	///
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
		/// Prepares the write access (e. g. file handles) for further access.
		/// </summary>
		void InitializeWriteAccess();

		/// <summary>
		/// Closes e. g. file handles and commits changes. Execute finally.
		/// </summary>
		void FinishWriteAccess();

		/// <summary>
		/// Writes debugMessage to defined (see xml-config-file) log-file.
		/// </summary>
		/// <param name="debugMessage">The message.</param>
		/// <param name="debugLevel">How critical is the message. Use "0" for important and "5" for less
		/// important messages.</param>
		void WriteDebugMessage(string debugMessage, int debugLevel);

		/// <summary>
		/// Writes general loginformations to the specified file.
		/// </summary>
		/// <param name="logMessage">The message to write</param>
		void WriteLogEntry(string logMessage);

	}
}
 