using System.Net.Sockets;
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
	/// Revision 1.7  2005/01/29 21:47:44  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
	///
	/// Revision 1.6  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
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
	internal class DefaultRequest : IRequest
	{

		private IWebserverMonitor webserverMonitor;
		private NetworkStream networkStream;
		private int port;



		/// <summary>
		/// The general request passed to the parsers by the dispatcher.
		/// </summary>
		public DefaultRequest(IWebserverMonitor webserverMonitor)
		{
			this.webserverMonitor = webserverMonitor;
		}



		/// <summary>
		/// The NetworkStream contains the socket and all necessary method to communicate with the client.
		/// </summary>
		public NetworkStream NetworkStream
		{
			get { return networkStream; }
			set { networkStream = value; }
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
