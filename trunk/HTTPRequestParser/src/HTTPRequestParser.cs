using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.HTTPRequestParser
{
	/// <summary>
	/// HTTPRequestParser.
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
	/// Revision 1.2  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class HTTPRequestParser : IRequestParser
	{
		public HTTPRequestParser(IHTTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, IWebserverMonitor webserverMonitor, IConfigReader configReader)
		{
			
		}


		public void HandleRequest (IRequest request)
		{
			throw new NotImplementedException ();
		}
	}
}
