using System;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// DefaultRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/10/21 15:03:09  kelsaka
	/// new project: request
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultRequest : IRequest
	{
		public DefaultRequest()
		{
		
		}


		public string Request
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}

		public TcpClient TcpClient
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
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
	}
}
