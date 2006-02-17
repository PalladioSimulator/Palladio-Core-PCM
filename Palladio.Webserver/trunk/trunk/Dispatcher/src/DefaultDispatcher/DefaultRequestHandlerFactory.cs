using System;
using System.Net.Sockets;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// DefaultRequestHandlerFactory. Offers methods to create IRequestHandlers.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/02 17:34:57  kelsaka
	/// Added multi-threading to handle requests.
	/// Added short architectural description.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultRequestHandlerFactory : IRequestHandlerFactory
	{

		/// <summary>
		/// Offers methods to create IRequestHandlers. Encapsulates the creation process.
		/// </summary>
		/// <param name="requestParser">CoR-link. Let this parser parse the request.</param>
		/// <param name="webserverMonitor">For debbugging an logging.</param>
		/// <param name="webserverConfiguration">WebserverConfiguration.</param>
		/// <param name="port">Port to listen on. Might be used to identify the kind of request.</param>
		/// <param name="clientSocket">The socket-connection to the client.</param>
		/// <param name="requestFactory">Create requests with this factory.</param>
		/// <returns>IRequestHandler.</returns>
		public IRequestHandler CreateRequestHandler (IRequestParser requestParser, IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration, int port, Socket clientSocket, IRequestFactory requestFactory)
		{
			return new RequestHandler(requestParser, webserverMonitor, webserverConfiguration, port, clientSocket, requestFactory);
		}
	}
}
