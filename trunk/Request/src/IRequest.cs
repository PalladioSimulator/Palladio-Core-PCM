using System;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// IRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/10/30 15:24:39  kelsaka
	/// webserverMonitor-Output on console; documentation (doc) update
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
	public interface IRequest
	{


		/// <summary>
		/// Observes the connections of TCP-networkclients.
		/// </summary>
		TcpListener TcpListener {get; set;}

		/// <summary>
		/// The socket-interface / connection.
		/// </summary>
		Socket Socket {get; set;}



	}
}
