using System;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// DefaultHTTPRequest.
	/// </summary>
	public class DefaultHTTPRequest : IHTTPRequest
	{
		public DefaultHTTPRequest()
		{

		}

		public string URI
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}

		public string RequestMethod
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}

		public TcpClient TcpClient
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}

	}
}
