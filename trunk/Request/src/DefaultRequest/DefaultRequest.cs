using System;
using System.IO;
using System.Net.Sockets;
using System.Text;
using Palladio.Webserver.WebserverMonitor;

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
	/// Revision 1.5  2004/11/03 18:52:48  kelsaka
	/// Added ability to get the full content-data of post-requests
	///
	/// Revision 1.4  2004/10/30 15:24:39  kelsaka
	/// webserverMonitor-Output on console; documentation (doc) update
	///
	/// Revision 1.3  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.2  2004/10/27 15:05:06  kelsaka
	/// added more request handling-abilities
	///
	/// Revision 1.1  2004/10/21 15:03:09  kelsaka
	/// new project: request
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultRequest : IRequest
	{

		private IWebserverMonitor webserverMonitor;
		private TcpListener tcpListener;
		private Socket socket;
		private int port;
		private byte[] receivedData;



		/// <summary>
		/// The general request passed to the parsers by the dispatcher.
		/// </summary>
		public DefaultRequest(IWebserverMonitor webserverMonitor)
		{
			this.webserverMonitor = webserverMonitor;
		}






		//TODO: Currently unused - remove?
		/// <summary>
		/// Observes the connections of TCP-networkclients. 
		/// </summary>
		public TcpListener TcpListener
		{
			get { return tcpListener; }
			set { tcpListener = value; }
		}

		/// <summary>
		/// The socket-interface / connection.
		/// </summary>
		public Socket Socket
		{
			get { return socket; }
			set { socket = value; }
		}

		/// <summary>
		/// The Port on which the requested originally came in.
		/// </summary>
		public int Port
		{
			get { return port; }
			set { port = value; }
		}


	}
}
