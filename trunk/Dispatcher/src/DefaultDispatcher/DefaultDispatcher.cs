using System;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using Palladio.Webserver.ConfigReader;
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

		
		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;

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
		/// </summary>
		public void Run ()
		{

			try
			{
				//start listing on the given port //TODO: make listen on all specified ports later on.
				tcpListener = new TcpListener(webserverConfiguration.ListeningPorts[0]);
				tcpListener.Start();

				//start the thread which calls the method 'StartListen'
				Thread thread = new Thread(new ThreadStart(StartListen));
				thread.Start() ;

			}
			catch(Exception e)
			{
				webserverMonitor.WriteDebugMessage("An exception occurred while listening :" + e.ToString(), 1);
			}
			
		}





		/// <summary>
		/// Stops the dispatcher. This includes the service of the webserver.
		/// </summary>
		public void Stop ()
		{
			throw new NotImplementedException ();
		}




		
		//This method Accepts new connection and
		//First it receives the welcome massage from the client,
		//Then it sends the Current date time to the Client.
		public void StartListen()
		{

						
			while(true)
			{
				//Accept a new connection
				Socket mySocket = tcpListener.AcceptSocket() ;

				webserverMonitor.WriteLogEntry("Socket Type " + mySocket.SocketType ); 
				
				if(mySocket.Connected)
				{
					webserverMonitor.WriteLogEntry("Client connected on IP:" + mySocket.RemoteEndPoint) ;

					mySocket.Close();						
				}
			}
		}
	

	}
}
