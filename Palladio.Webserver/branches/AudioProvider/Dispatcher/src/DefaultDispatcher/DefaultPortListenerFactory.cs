using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// ListeningThread. This class' delegate StartListen() can be used as a thread-start-point to listen to
	/// a specified tcp-port.
	/// </summary>
	public class DefaultPortListenerFactory : IPortListenerFactory
	{
		/// <summary>
		/// Creates a new IPortListener.
		/// </summary>
		/// <param name="requestParser">The first request parser from the CoR.</param>
		/// <param name="webserverMonitor">The monitor to use.</param>
		/// <param name="webserverConfiguration">The configuration to use.</param>
		/// <param name="port">The port to listen on.</param>
		/// <param name="address">The ip-address to listen on.</param>
		/// <param name="requestFactory">The factory to create requests with.</param>
		/// <returns>A new port listener.</returns>
		public IPortListener CreatePortListener(IRequestParser requestParser, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, int port, IPAddress address, IRequestFactory requestFactory)
		{
			return new PortListener(requestParser, webserverMonitor, webserverConfiguration, port, address, requestFactory);
		}
	}
}