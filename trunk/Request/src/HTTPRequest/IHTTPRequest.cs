using System;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// IHTTPRequest.
	/// </summary>
	public interface IHTTPRequest
	{


		/// <summary>
		/// The URI requested by the client.
		/// </summary>
		string URI {get; set;}

		/// <summary>
		/// The request-method used by the client, e.g. post, get.
		/// </summary>
		string RequestMethod {get; set;}

		/// <summary>
		/// The client-identification at the tcp-level.
		/// </summary>
		TcpClient TcpClient {get; set;}



	}
}
