using System;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.RequestParser
{
	/// <summary>
	/// ErrorRequestParser. Usually this class should be used at the end of the Chain Of Responsibility
	/// to catch errors on getting a fitting parser for the delivered stream.
	/// </summary>
	public class DefaultRequestParser : IRequestParser
	{
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;

		/// <summary>
		/// the default constructor.
		/// </summary>
		/// <param name="webserverMonitor"></param>
		/// <param name="webserverConfiguration"></param>
		public DefaultRequestParser(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
		}

		/// <summary>
		/// This method simply lets the request handling end.
		/// </summary>
		/// <param name="request">This request will not be handled.</param>
		public void HandleRequest (IRequest request)
		{
			webserverMonitor.WriteDebugMessage("DefaultRequestParser could not handle the request.", 1);
		}
	}
}
