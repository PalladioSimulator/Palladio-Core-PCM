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
	/// ListeningThread. This class' delegate StartListen() can be used as a thread-start-point to listen to
	/// a specified tcp-port.
	/// </summary>
	public class PortListener : IPortListener
	{
		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;
		private TcpListener tcpListener;
		private int port;	
		private IRequestFactory requestFactory;
		private IPAddress address;
		private bool isRunning;


		public PortListener(IRequestParser requestParser, IWebserverMonitor webserverMonitor,
		                       IWebserverConfiguration webserverConfiguration, int port, IPAddress address, IRequestFactory requestFactory)
		{
			this.tcpListener = tcpListener;
			this.port = port;
			this.requestParser = requestParser;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.requestFactory = requestFactory;
			this.address = address;
			this.isRunning = true;
		}

		/// <summary>
		/// Unfortunately, there is no way to terminate
		/// a blocked thread using the <c>Thread.Abort</c> or
		/// <c>Thread.Interrupt</c> methods. To ensure the clean
		/// exit of the tread, we introduce the 'isRunning'
		/// flag. The main thread sets this value to false and
		/// causes the thread to terminate as soon as	it is
		/// unblocked and tries to start a new iteration. The 
		/// main thread has to unblock this thread by opening
		/// a new connection.
		/// </summary>
		public bool IsRunning
		{
			get { return isRunning; }
			set { isRunning = value; }
		}

		/// <summary>
		/// The thread listens on this port.
		/// </summary>
		public int Port
		{
			get { return port; }
		}

		/// <summary>
		/// The thread accepts only requests to this IP.
		/// </summary>
		public IPAddress Address
		{
			get { return address; }
		}

		/// <summary>
		/// Use this method as a delegate to start a thread listening on the specified port, using the specified tcplistener.
		/// </summary>
		public void StartListen()
		{
			tcpListener = new TcpListener(address, port);
			tcpListener.Start();
			webserverMonitor.WriteLogEntry("Listening (" + webserverConfiguration.ListenIP + "; TCP) on port: " + port);

			webserverMonitor.WriteLogEntry("Dispatcher-Thread started. Waiting for client-requests...");

			Socket clientSocket = null;
			try
			{

				// Thread handling changed:
				//  Instead of calling the Thread.Abort() method, each
				//  thread instance contains a variable IsRunning which is
				//  checked after each iteration through the loop.
				//  If it is set to false, the tread terminates. This has been introduced to
				//  establish a clean thread exit. The call of the Abort () method causes
				//  an exeption in the aborted thread. This execption is forwarded through
				//  the whole call stack, even if it is catched. So, every method on the stack
				//  is informed about the thread exit. However, this causes some trouble
				//  for the logging of the Webserver behaviour. Furthermore, the
				//  Thread.Abort() and Thread.Interrupt() methods do not terminate
				//  threads that are blocked. The call of the method TcpListener.AcceptSocket()
				//  blocks the thread until a new connection is opened. So, the running
				//  threads are not aborted until a new connection is opened.
				//
				//  Now, we proceed as follows to terminate the Webserver. For all
				//  listening treads, we set the IsRunning variable to false. Next, we need
				//  to unblock the threads. Therfore, we open a dummy connection to the
				//  IP and port the tread is listening on. When re-iterating the the loop, the
				//  check of the IsRunning variable causes the thread to terminate.

				while (IsRunning)
				{
					// Blocked waiting for a connection
					clientSocket = tcpListener.AcceptSocket();

					webserverMonitor.WriteLogEntry("___________________________________");
					webserverMonitor.WriteLogEntry("### Getting new client-request (port " + port + "): ###");
					webserverMonitor.WriteLogEntry("Socket Type: " + clientSocket.SocketType);

					if (clientSocket.Connected)
					{
						webserverMonitor.WriteLogEntry("Client connected on IP: " + clientSocket.RemoteEndPoint);

						// set up request:
						IRequest request = requestFactory.CreateRequest(webserverMonitor);
						request.Socket = clientSocket;
						request.TcpListener = tcpListener;
						request.Port = port;


						// let the parser handle the request:
						requestParser.HandleRequest(request);


						clientSocket.Close();
					}
				}
			}
			// use finally here to ensure that the connection is closed 
			// and the listener is stopped.
			finally
			{
				if (clientSocket != null)
					clientSocket.Close();
				tcpListener.Stop();
			}
		}
	}
}