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
		public DefaultRequestParser(IWebserverMonitor webserverMonitor, IConfigReader configReader)
		{

		}

		public void HandleRequest (IRequest request)
		{
			throw new NotImplementedException ();
		}
	}
}
