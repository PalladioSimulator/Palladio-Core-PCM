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
	/// DefaultDispatcher. This component starts threads with TCP-listeners that listen on the specified ports. The ports are configured
	/// in the WebserverXML.xml. The webserver may even listen on multiple ports.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.13  2004/11/14 10:35:32  kelsaka
	/// fixed bad aborting of tcpListening-Threads, now for each thread the abort-method is called first.
	///
	/// Revision 1.12  2004/11/08 20:42:44  kelsaka
	/// The webserver is now listening on all specified ports
	///
	/// Revision 1.11  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
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
		/// The local IP-address the server is listening on. As the server (at least the dispatcher) usually runs on a
		/// single machine, first 127.0.0.1 is used. 
		/// </summary>
		private const string LOCAL_IP_ADDRESS = "10.10.20.12"; //"127.0.0.1";


		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;
		/// <summary>
		/// References on the started threads should be kept in this array to be able to shut down all threads using
		/// the abort()-method.
		/// </summary>
		private Thread[] serverThread;

		TcpListener tcpListener;

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

			IPAddress adress = IPAddress.Parse(LOCAL_IP_ADDRESS);
			int portsCount = webserverConfiguration.ListeningPorts.Length;
			serverThread = new Thread[portsCount];

			try
			{
				//start listing on the given port; listen on all specified ports.
				for(int x = 0; x < portsCount; x++)
				{
					int port = webserverConfiguration.ListeningPorts[x];					
					
					tcpListener = new TcpListener(adress, port);
					tcpListener.Start();
					webserverMonitor.WriteLogEntry("Listening (" + LOCAL_IP_ADDRESS + "; TCP) on port: " + port);
					
					ListeningThread listeningThread = new ListeningThread(requestParser, webserverMonitor,
						webserverConfiguration, port, tcpListener);

					//start the thread which calls the method 'StartListen'
					serverThread[x] = new Thread(new ThreadStart(listeningThread.StartListen));			
					serverThread[x].Start();
				}

			}
			catch(Exception e)
			{
				webserverMonitor.WriteDebugMessage("An exception occurred while listening: " + e.ToString(), 1);
			}
			

			// make the webserver shutdown explicitly.
			webserverMonitor.WriteLogEntry("/=========================================\\");
			webserverMonitor.WriteLogEntry("|  Press ENTER to shutdown the webserver. |");
			webserverMonitor.WriteLogEntry("\\=========================================/");
			Console.ReadLine();
			Stop();

		}


		

		/// <summary>
		/// Stops the dispatcher. This includes the service of the webserver.
		/// Stops the write-access of the WebserverMonitor. Stops the Main-Thread.
		/// </summary>
		public void Stop()
		{
			// Send the abort-signale to all threads running:
			for(int x = 0; x < serverThread.Length; x++)
			{
				if (serverThread[x] != null)
				{
					try
					{
						serverThread[x].Abort();
					}
					finally
					{
						serverThread[x] = null;
					}
				}
			}
			webserverMonitor.WriteLogEntry("Shutting down webserver.");
			webserverMonitor.FinishWriteAccess();

			// abort main-thread:
			Thread.CurrentThread.Abort();
		}


	}
}
