using System;
using System.Net;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// </summary>
	public interface IPortListenerFactory
	{
		IPortListener CreatePortListener(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
		                                       IWebserverConfiguration webserverConfiguration, int port, IPAddress address, IRequestFactory requestFactory);
	}
}
