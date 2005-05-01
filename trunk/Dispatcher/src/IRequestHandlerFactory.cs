using System;
using System.Net;
using System.Net.Sockets;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// IRequestHandlerFactory. Offers methods to create IRequestHandlers.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.1  2005/02/02 17:34:57  kelsaka
	/// Added multi-threading to handle requests.
	/// Added short architectural description.
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IRequestHandlerFactory
	{
		/// <summary>
		/// Offers methods to create IPortListeners.
		/// </summary>
		/// <param name="requestParser">CoR-link. Let this parser parse the request.</param>
		/// <param name="webserverMonitor">For debbugging an logging.</param>
		/// <param name="webserverConfiguration">WebserverConfiguration.</param>
		/// <param name="port">Port to listen on. Might be used to identify the kind of request.</param>
		/// <param name="clientSocket">The socket-connection to the client.</param>
		/// <param name="requestFactory">Create requests with this factory.</param>
		/// <returns>IRequestHandler.</returns>
		IRequestHandler CreateRequestHandler(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration, int port, Socket clientSocket, IRequestFactory requestFactory);

	}
}
