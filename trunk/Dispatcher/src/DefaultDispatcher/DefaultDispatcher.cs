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
	/// DefaultDispatcher. This component starts threads with TCP-listeners that listen on the specified ports. The ports are configured
	/// in the WebserverXML.xml. The webserver may even listen on multiple ports.
	/// Offers methods to start and stop the dispatched threads.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.18  2005/01/22 16:42:56  kelsaka
	/// added configureable (XML) connection-string for the database;
	/// added thread-name for the main thread;
	/// fixed socket-error (updated documentation)
	///
	/// Revision 1.17  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.16  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.15  2004/11/28 19:01:32  kelsaka
	/// Added simple support for searching on a database, that contains BibTeX-Entries, added test-documents, added DB-test-content, added comments
	///
	/// Revision 1.14  2004/11/14 10:55:51  kelsaka
	/// Completed listening on IP-Addresses. Now the IP the server is listening on defineable in the WebserverXML.xml. Pay attention that there might be some problems with the project-name of WebserverXML as XMLSpy sometimes produces lower-case-versions that cause problems on windows-systems.
	///
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
		/// Stores the information about a running Thread.
		/// This concerns the used listener and the thread
		/// executing the listener.
		/// </summary>
		private struct ThreadInfo
		{
			public IPortListener Listener;
			public Thread ExecutingThread;
		}

		private IRequestFactory requestFactory;
		private IPortListenerFactory portListenerFactory;

		private IRequestParser requestParser;
		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;


		/// <summary>
		/// References on the started threads should be kept in this array to be able to shut down all threads using
		/// the abort()-method.
		/// </summary>
		private ThreadInfo[] listenerThreads;

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="requestParser">The delegate that is used as the proceeding component (RequestParser)
		/// on processing the client-request.</param>
		public DefaultDispatcher(IRequestParser requestParser, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory, IPortListenerFactory portListenerFactory)
		{
			this.requestParser = requestParser;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.requestFactory = requestFactory;
			this.portListenerFactory = portListenerFactory;
		}


		
		/// <summary>
		/// Starts the dispatcher which is using threads to handle requests. This means that the webserver starts
		/// listening at the defined ports.
		/// Initializes the write-access of the WebserverMonitor.
		/// </summary>
		public void Start ()
		{
			
			webserverMonitor.WriteLogEntry("----------------------------");
			webserverMonitor.WriteLogEntry("Webserver-Dispatcher started.");

			IPAddress address = IPAddress.Parse(webserverConfiguration.ListenIP);
			int portsCount = webserverConfiguration.ListeningPorts.Length;
			listenerThreads = new ThreadInfo[portsCount];

			try
			{
				//start listing on the given port; listen on all specified ports.
				for(int i = 0; i < portsCount; i++)
				{
					int port = webserverConfiguration.ListeningPorts[i];	
				
					ThreadInfo threadInfo = new ThreadInfo();
					threadInfo.Listener = portListenerFactory.CreatePortListener(
						requestParser, webserverMonitor, webserverConfiguration, 
						port, address, requestFactory);
					threadInfo.ExecutingThread = new Thread(new ThreadStart(threadInfo.Listener.StartListen));	
					threadInfo.ExecutingThread.Name = "ListeningThread, port "+ port;
					threadInfo.ExecutingThread.Start();

					listenerThreads[i] = threadInfo;
				}

			}
			catch(Exception e)
			{
				webserverMonitor.WriteDebugMessage("An exception occurred while listening: " + e.ToString(), 1);
			}
		}


		

		/// <summary>
		/// Stops the dispatcher. This includes the service of the webserver.
		/// Stops the write-access of the WebserverMonitor. Stops the Main-Thread.
		/// </summary>
		public void Stop()
		{
			for(int i = 0; i < listenerThreads.Length; i++)
			{
				if (listenerThreads[i].ExecutingThread != null)
				{
					listenerThreads[i].Listener.IsRunning = false;
					
					// unblock listening Thread
					TcpClient tcpClient = new TcpClient();
					tcpClient.Connect(listenerThreads[i].Listener.Address, listenerThreads[i].Listener.Port);
					tcpClient.Close();

					// wait for thread to terminate
					listenerThreads[i].ExecutingThread.Join();
				}
			}
			webserverMonitor.WriteLogEntry("Shutting down webserver.");
		}
	}
}
