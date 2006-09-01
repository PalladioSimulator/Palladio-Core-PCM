using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.FTPRequestParser
{
	/// <summary>
	/// FTPRequestParser. At the moment ftp request cannot be parsed using this parser. The ftp
	/// support is not implemented.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2005/05/01 18:27:43  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.6  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
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
		private IWebserverMonitor webserverMonitor;
		private IRequestParser corSuccessor;

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="requestProcessor">First chain link of the COR for request processors.</param>
		/// <param name="corSuccessor">The directly following chain link. Called if the
		/// request is not a ftp request.</param>
		/// <param name="webserverMonitor">The monitor to use.</param>
		/// <param name="webserverConfiguration">The configuration to use.</param>
		public FTPRequestParser(IFTPRequestProcessor requestProcessor, IRequestParser corSuccessor, IWebserverMonitor webserverMonitor,  IWebserverConfiguration webserverConfiguration)
		{
			corSuccessor = corSuccessor;
			this.webserverMonitor = webserverMonitor;
		}

		/// <summary>
		/// At the moment not implemented. The request is always forwarded to the CoR-Successor.
		/// </summary>
		/// <param name="request">The request to parse.</param>
		public void HandleRequest (IRequest request)
		{
			// forward the request to the corSuccessor as no implementation is avaiable.
			webserverMonitor.WriteLogEntry("FTPRequestParser forwards the request to COR-Successor.");
			corSuccessor.HandleRequest(request);
		}
	}
}
