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

		private TcpClient tcpClient;
		private TcpListener tcpListener;
		private Socket socket;


		public DefaultRequest()
		{
		
		}


		/// <summary>
		/// The client-identification at the tcp-level.
		/// </summary>
		public TcpClient TcpClient
		{
			get { return tcpClient; }
			set { this.tcpClient = value; }
		}

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
	}
}
