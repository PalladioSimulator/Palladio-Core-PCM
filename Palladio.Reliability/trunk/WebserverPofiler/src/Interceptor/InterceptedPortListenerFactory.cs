using System;
using System.Net;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;
using Palladio.Reliability.WebserverProfiler.Interceptor;

namespace Palladio.Reliability.WebserverProfiler.Interceptor
{
	/// <summary>
	/// Zusammenfassung für InterceptedListeningThreadFactory.
	/// </summary>
	public class InterceptedPortListenerFactory : IPortListenerFactory
	{
		IPortListenerFactory factory;

		public InterceptedPortListenerFactory(IPortListenerFactory factory)
		{
			this.factory = factory;
		}

		public IPortListener CreatePortListener(IRequestParser requestParser, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, int port, IPAddress address, IRequestFactory requestFactory)
		{
			IPortListener listener = factory.CreatePortListener(requestParser, webserverMonitor, webserverConfiguration, port, address, requestFactory);
			return new PortListenerInterceptor(listener);
		}
	}
}
