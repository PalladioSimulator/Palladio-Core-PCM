using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.HTTPRequestProcessor
{
	/// <summary>
	/// DefaultHTTPRequestProcessor.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 12:55:56  kelsaka
	/// Actualised the UML-componentview; defined the webserverfactory-interface, therefore added some new interfaces
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultHTTPRequestProcessor : IHTTPRequestProcessor
	{
		public DefaultHTTPRequestProcessor(IWebserverMonitor webserverMonitor, IConfigReader configReader)
		{

		}
	}
}
