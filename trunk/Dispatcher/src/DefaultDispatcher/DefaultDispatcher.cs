using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;
using Palladio.Webserver.RequestParser;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// DefaultDispatcher.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.10  2004/11/03 18:52:48  kelsaka
	/// Added ability to get the full content-data of post-requests
	///
	/// Revision 1.9  2004/10/30 15:24:39  kelsaka
	/// webserverMonitor-Output on console; documentation (doc) update
	///
	/// Revision 1.8  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.7  2004/10/28 07:54:43  kelsaka
	/// -
	///
	/// Revision 1.6  2004/10/27 15:05:06  kelsaka
	/// added more request handling-abilities
	///
	/// Revision 1.5  2004/10/27 13:40:43  kelsaka
	/// added component-interconnections; added tcp-listening
	///
	/// Revision 1.4  2004/10/27 05:52:48  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.3  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.2  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultDispatcher : IDispatcher
	{
		/// <summary>
		/// The local IP-address the server is listening on. As the server usually runs on single machine,
		/// first 127.0.0.1 is used. 
		/// </summary>
		string localAddress = "127.0.0.1"; //TODO: maybe change to be able to listen to multiple addresses.
		
		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;
		private Thread serverThread;

		private TcpListener tcpListener;


		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="requestParser">The delegate that is used as the proceeding component (RequestParser)
		/// on processing the client-request.</param>
		public DefaultDispatcher(IRequestParser requestParser, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.requestParser = requestParser;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
		}


		
		/// <summary>
		/// Starts the dispatcher which is using threads to handle requests. This means that the webserver starts
		/// listening at the defined ports.
		/// Initializes the write-access of the WebserverMonitor.
		/// </summary>
		public void Run ()
		{
			webserverMonitor.InitializeWriteAccess();

			webserverMonitor.WriteLogEntry("----------------------------");
			webserverMonitor.WriteLogEntry("Webserver-Dispatcher started.");

			try
			{

				//start listing on the given port //TODO: make listen on *all* specified ports later on.
				//TODO: currently running without IP listening on: "new IPAddress(Encoding.ASCII.GetBytes(localAddress))"
				tcpListener = new TcpListener(webserverConfiguration.ListeningPorts[0]);
				tcpListener.Start();
				webserverMonitor.WriteLogEntry("Listening (TCP) on port: " + webserverConfiguration.ListeningPorts[0]);

				//start the thread which calls the method 'StartListen'
				serverThread = new Thread(new ThreadStart(StartListen));
				serverThread.Start();

			}
			catch(Exception e)
			{
				webserverMonitor.WriteDebugMessage("An exception occurred while listening: " + e.ToString(), 1);
			}
			

			//TODO: make the webserver shutdown explicitly.
			//webserverMonitor.WriteLogEntry("Press ENTER to stop the webserver.");
			//Console.ReadLine();
			//Stop();

		}





		/// <summary>
		/// Stops the dispatcher. This includes the service of the webserver.
		/// Stops the write-access of the WebserverMonitor.
		/// </summary>
		public void Stop()
		{
			if (serverThread != null)
			{
				try
				{
					serverThread.Abort();
				}
				finally
				{
					serverThread = null;
				}
			}
			webserverMonitor.WriteLogEntry("Shutting down webserver.");
			webserverMonitor.FinishWriteAccess();

		}




		
		//This method Accepts new connection and
		//First it receives the welcome massage from the client,
		//Then it sends the Current date time to the Client.
		private void StartListen()
		{
			webserverMonitor.WriteLogEntry("Dispatcher-Thread started. Waiting for client-requests...");
						
			while(true)
			{
				//Accept a new connection
				Socket clientSocket = tcpListener.AcceptSocket() ;

				webserverMonitor.WriteLogEntry("### Getting new client-request: ###"); 
				webserverMonitor.WriteLogEntry("Socket Type: " + clientSocket.SocketType); 
				
				if(clientSocket.Connected)
				{
					webserverMonitor.WriteLogEntry("Client connected on IP: " + clientSocket.RemoteEndPoint) ;

					// set up request:
					IRequest request = new DefaultRequest(webserverMonitor);
					request.Socket = clientSocket;
					request.TcpListener = tcpListener;
					request.Port = webserverConfiguration.ListeningPorts[0]; //TODO: on using all defined ports change this.
					

					// let the parser handle the request:
					requestParser.HandleRequest(request);

					
					clientSocket.Close();						
				}
			}
		}
	

	}
}
