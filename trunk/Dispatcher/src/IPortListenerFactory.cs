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
	/// Revision 1.2  2004/12/18 10:06:48  kelsaka
	/// Added CVS-logs and some comments.
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IPortListenerFactory
	{
		IPortListener CreatePortListener(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
		                                       IWebserverConfiguration webserverConfiguration, int port, IPAddress address, IRequestFactory requestFactory);
	}
}
