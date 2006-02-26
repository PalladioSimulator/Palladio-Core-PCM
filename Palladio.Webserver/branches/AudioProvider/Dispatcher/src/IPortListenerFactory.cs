using System;
using System.Net;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// Offers methods to create IPortListeners. Encapsulates creational process.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/02/02 17:34:57  kelsaka
	/// Added multi-threading to handle requests.
	/// Added short architectural description.
	///
	/// Revision 1.2  2004/12/18 10:06:48  kelsaka
	/// Added CVS-logs and some comments.
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IPortListenerFactory
	{

		/// <summary>
		/// Offers methods to create IPortListeners.
		/// </summary>
		/// <param name="requestParser">CoR-link. Let this parser parse the request.</param>
		/// <param name="webserverMonitor">For debbugging an logging.</param>
		/// <param name="webserverConfiguration">WebserverConfiguration.</param>
		/// <param name="port">Port to listen on.</param>
		/// <param name="address">Webserver-adress the threads listen on.</param>
		/// <param name="requestFactory">Create requests with this factory.</param>
		/// <returns>IPortListener.</returns>
		IPortListener CreatePortListener(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
		                                       IWebserverConfiguration webserverConfiguration, int port, IPAddress address, IRequestFactory requestFactory);
	}
}
