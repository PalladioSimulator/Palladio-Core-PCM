using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// Creates a NetworkStream from the given socket to handle the rest of the request.
	/// Starts the first link of the CoR to handle the request.
	/// The RequestHandler should be started in a seperate thread.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/02 17:34:57  kelsaka
	/// Added multi-threading to handle requests.
	/// Added short architectural description.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class RequestHandler : Palladio.Webserver.Dispatcher.IRequestHandler
	{


		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;
		private TcpListener tcpListener;
		private int port;	
		private IRequestFactory requestFactory;
		private IRequest request;
		private Socket clientSocket;

		
		/// <summary>
		/// Default-Constructor. For use by the factory.
		/// </summary>
		/// <param name="requestParser">CoR-link. Let this parser parse the request.</param>
		/// <param name="webserverMonitor">For debbugging an logging.</param>
		/// <param name="webserverConfiguration">WebserverConfiguration.</param>
		/// <param name="port">Port to listen on. Might be used to identify the kind of request.</param>
		/// <param name="clientSocket">The socket-connection to the client.</param>
		/// <param name="requestFactory">Create requests with this factory.</param>
		/// <returns>RequestHandler.</returns>
		public RequestHandler (IRequestParser requestParser, IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration, int port, Socket clientSocket, IRequestFactory requestFactory)
		{
			this.tcpListener = tcpListener;
			this.port = port;
			this.requestParser = requestParser;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.requestFactory = requestFactory;
			this.clientSocket = clientSocket;
		}




		/// <summary>
		/// Starts for the given request the HandleRequest-method from the first link of the CoR.
		/// </summary>
		public void HandleRequest ()
		{			
			webserverMonitor.WriteLogEntry("___________________________________");
			webserverMonitor.WriteLogEntry("### Getting new client-request (port " + port + "). Thread-Name: "
				+ Thread.CurrentThread.Name + " ###");
			webserverMonitor.WriteLogEntry("Socket Type: " + clientSocket.SocketType);

			if (clientSocket.Connected)
			{
				webserverMonitor.WriteLogEntry("Client connected on IP: " + clientSocket.RemoteEndPoint);
				// set up request:
				request = requestFactory.CreateRequest(webserverMonitor);	
					

				// Create a NetworkStream from the socket, the whole connection can work on.
				// "true" indicates that the socket is under control of the NetworkStream: 
				request.NetworkStream = new NetworkStream(clientSocket, System.IO.FileAccess.ReadWrite, true);						
				request.Port = port;
						

				// let the parser handle the request:
				requestParser.HandleRequest(request);


				// close opened networkstream:
				Stop();
			}
		}

		/// <summary>
		/// Stops the current IHandlerThread.
		/// </summary>
		public void Stop()
		{			
			// the socket is handled by the networkstream and will be closed automatically:					
			request.NetworkStream.Flush();
			request.NetworkStream.Close();
		}

		/// <summary>
		/// The socket-connection to the client.
		/// </summary>
		public Socket ClientSocket
		{
			get { return this.clientSocket; }
			set { this.clientSocket = value; }
		}
	}
}
