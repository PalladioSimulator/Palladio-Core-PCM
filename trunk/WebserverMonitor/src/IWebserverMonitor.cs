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


		void writeDebugMessage(string debugMessage);

		void writeLogEntry(string logMessage);

	}
}
