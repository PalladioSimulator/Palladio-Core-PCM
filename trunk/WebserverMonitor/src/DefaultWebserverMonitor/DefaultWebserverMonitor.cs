using System;
using Palladio.Webserver.ConfigReader;
using WebserverXML;

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
	public class DefaultWebserverMonitor : IWebserverMonitor
	{

		private IConfigReader configReader;

		public DefaultWebserverMonitor(IConfigReader configReader)
		{
			this.configReader = configReader;

			ReadConfiguration();
		}

		private void ReadConfiguration()
		{
			ConfigType configRoot = configReader.GetRoot();
		}

		public void WriteDebugMessage (string debugMessage, int debugLevel)
		{
			throw new NotImplementedException ();
		}

		public void WriteLogEntry (string logMessage)
		{
			throw new NotImplementedException ();
		}
	}
}
