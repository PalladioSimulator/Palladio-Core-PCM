using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.FTPRequestParser
{
	/// <summary>
	/// FTPRequestParser.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/10/27 05:52:48  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.4  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.3  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.2  2004/10/20 15:38:01  kelsaka
	/// added HTTPRequestProcessor as designed in doc
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class FTPRequestParser : IRequestParser
	{
		public FTPRequestParser(IFTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, IWebserverMonitor webserverMonitor,  IWebserverConfiguration webserverConfiguration)
		{


		}

		public void HandleRequest (IRequest request)
		{
			throw new NotImplementedException ();
		}
	}
}
