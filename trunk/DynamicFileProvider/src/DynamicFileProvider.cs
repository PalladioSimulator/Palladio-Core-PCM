using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.DynamicFileProvider
{
	/// <summary>
	/// DynamicFileProvider.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/10/30 11:42:08  kelsaka
	/// Added full support for static websites using the get-method; added several test-documents; changed CoR for HTTP-Processing: dynamic files are delivered first
	///
	/// Revision 1.4  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.3  2004/10/27 05:52:48  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.2  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class DynamicFileProvider : IHTTPRequestProcessor
	{

		private IHTTPRequestProcessor corSuccessor;

		public DynamicFileProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfigurationr)
		{
			this.corSuccessor = corSuccessor;
		}


		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void handleRequest (IHTTPRequest httpRequest)
		{
			
			// as no implementation is available no request can be handled and has to be forwarded to successor:
			corSuccessor.handleRequest(httpRequest);

		}
	}
}
