using System;
using System.Net.Sockets;
using System.Threading;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// ListeningThread. This class' delegate StartListen() can be used as a thread-start-point to listen to
	/// a specified tcp-port.
	/// </summary>
	public class ListeningThread
	{

		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;
		private TcpListener tcpListener;
		private int port;


		public ListeningThread(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
			IWebserverConfiguration webserverConfiguration, int port, TcpListener tcpListener)
		{
			this.tcpListener = tcpListener;
			this.port = port;
			this.requestParser = requestParser;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			
		}


		
		/// <summary>
		/// Use this method as a delegate to start a thread listening on the specified port, using the specified tcplistener.
		/// </summary>
		public void StartListen()
		{
			webserverMonitor.WriteLogEntry("Dispatcher-Thread started. Waiting for client-requests...");

			
			while(true)
			{
				//Accept a new connection
				Socket clientSocket = tcpListener.AcceptSocket() ;

				webserverMonitor.WriteLogEntry("___________________________________"); 
				webserverMonitor.WriteLogEntry("### Getting new client-request (port " + port + "): ###"); 
				webserverMonitor.WriteLogEntry("Socket Type: " + clientSocket.SocketType); 
				
				if(clientSocket.Connected)
				{
					webserverMonitor.WriteLogEntry("Client connected on IP: " + clientSocket.RemoteEndPoint) ;

					// set up request:
					IRequest request = new DefaultRequest(webserverMonitor);
					request.Socket = clientSocket;
					request.TcpListener = tcpListener;
					request.Port = port; 
					

					// let the parser handle the request:
					requestParser.HandleRequest(request);

					
					clientSocket.Close();						
				}
			}
		}
	}
}
