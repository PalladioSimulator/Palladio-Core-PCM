using System;
using Palladio.Webserver.ConfigReader;

namespace Palladio.Webserver.WebserverMonitor
{
	/// <summary>
	/// DefaultWebserverMonitor.
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
	public class DefaultWebserverMonitor : IWebserverMonitor
	{

		private IConfigReader configReader;

		public DefaultWebserverMonitor(IConfigReader configReader)
		{
			this.configReader = configReader;
		}

		public void writeDebugMessage (string debugMessage, int debugLevel)
		{
			throw new NotImplementedException ();
		}

		public void writeLogEntry (string logMessage)
		{
			throw new NotImplementedException ();
		}
	}
}
