using System;
using System.Collections;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

namespace Palladio.Webserver.RequestClient
{
	/// <summary>
	/// HTTPRequestGenerator. Provides methods to send http-get-requests the specified server. The requests can be sent
	/// multi-threaded, delayed and repeated.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/03/03 07:54:10  kelsaka
	/// use of a constant set of threads; performance enhancements
	///
	/// Revision 1.4  2005/02/27 22:45:33  kelsaka
	/// fixed logging-bug: log-messages were written mixed by multiple threads.
	///
	/// Revision 1.3  2005/02/27 22:13:07  kelsaka
	/// Optimized multi-threading-behaviour: GUI is still responsive on creating requests;
	/// requests are created looped.
	///
	/// Revision 1.2  2005/02/27 16:37:58  kelsaka
	/// Added some comments
	///
	/// Revision 1.1  2005/02/27 16:09:11  kelsaka
	/// - Added the "simultaneous http request client"
	///  (folder: SimulataneousRequestClient) for testing  the webserver with multiple
	///  parallel requests. This tools provides a simple gui to create http-requests.
	///
	/// </pre>
	/// </remarks>
	public class HTTPRequestGenerator
	{
		private struct ThreadInfo
		{
			public ClientRequest clientRequest;
			public Thread ExecutingThread;
		}

		private ArrayList requestThreads;
		private bool active;
		private Uri uri;
		private int numberOfThreads;
		private int loopDelay;
		private int initDelayInMilliseconds;
		private IPAddress ipAddress;
		private int port;
		
		/// <summary>
		/// Message to be sent to the server.
		/// </summary>
		private string requestString;


		/// <summary>
		/// Default Constructor.
		/// </summary>
		public HTTPRequestGenerator()
		{
			this.requestThreads = new ArrayList();
		}


		/// <summary>
		/// Delegate to handle <see cref="HandleRequestEvent"/>. Used for logging-information.
		/// </summary>
		public delegate void HandleRequestEvent(string message);

		/// <summary>
		/// Event is send for logging-purposes.
		/// </summary>
		public event HandleRequestEvent ClientMessage;


		/// <summary>
		/// Sets up the parameters that are used to send the http-request.
		/// </summary>
		/// <param name="requestUri">Client uri. The site to request (e. g. http://127.0.0.1:81/index.html).</param>
		/// <param name="numberOfThreads">The number of threads to use parallel.</param>
		/// <param name="loopDelay">Delay before a client starts a re-requesting. (<see cref="Thread.Sleep"/>)</param>
		/// <param name="initDelayInMilliseconds">Time in milliseconds between the starting of threads at initiation. (<see cref="Thread.Sleep"/>)</param>
		/// <remarks>
		/// Execute before executing <see cref="GenerateRequests"/>.
		/// </remarks>
		public void Setup(string requestUri, int numberOfThreads, int loopDelay, int initDelayInMilliseconds)
		{
			this.numberOfThreads = numberOfThreads;
			this.loopDelay = loopDelay;
			this.initDelayInMilliseconds = initDelayInMilliseconds;

			// Parse input data.
			this.uri = new Uri(requestUri);
			this.ipAddress = IPAddress.Parse(uri.Host);
			this.port = uri.Port;
			requestString = "GET " + uri.PathAndQuery + " HTTP/1.1\nHost:" + uri.Host + "\n\n";
			ClientMessage("Details. URI: " + uri  + ", ip: " + ipAddress + ", port: " + port + ", request: \"" + requestString + "\".");
		}



		/// <summary>
		/// Sends HTTP-Requests to the specified client. Execute <see cref="Setup"/> first.
		/// </summary>
		public void GenerateRequests()
		{
			this.active = true;
			ClientMessage("Starting Requests. Address: " + uri + ", Number of simultaneous Requests: " + numberOfThreads + ", Loop-Delay: " + loopDelay + ", Thread-Init-Delay: " + initDelayInMilliseconds + ".");
			ClientMessage("NOTE: According to the init delay of threads it takes about " + (numberOfThreads * initDelayInMilliseconds) + " ms of time until all threads have been started.");			

			InitiateRequestThreads();
		}



		/// <summary>
		/// Sets up the ArrayList containing all ThreadInfos.
		/// </summary>
		private void InitiateRequestThreads()
		{
			for (int y = 0; y < numberOfThreads && active; y++)
			{
				ThreadInfo threadInfo = new ThreadInfo();
				threadInfo.clientRequest = new ClientRequest(ipAddress, port, new HandleRequestEvent(FireClientMessage), Encoding.ASCII.GetBytes(requestString), loopDelay);				
				threadInfo.ExecutingThread = new Thread(new ThreadStart(threadInfo.clientRequest.SendRequest));
				threadInfo.ExecutingThread.Name = "Request-Thread number " + (y+1);
				requestThreads.Add(threadInfo);

				threadInfo.ExecutingThread.Start();
				ClientMessage("Started Thread: " + threadInfo.ExecutingThread.Name + ".");
				if(y == (numberOfThreads - 1))
				{
					ClientMessage("NOTE: All " + numberOfThreads + " Threads have been started.");
				}
				Thread.Sleep(initDelayInMilliseconds);
			}			
		}



		/// <summary>
		/// Fires the <see cref="ClientMessage"/> event.
		/// </summary>
		/// <param name="message">The client message.</param>
		/// <remarks>
		/// Implements HandleRequestEvent.
		/// </remarks>
		public void FireClientMessage(string message)
		{
			ClientMessage(message);
		}


		/// <summary>
		/// Calls the Terminate-method of each thread, that has been started. Prevents further threads to get started.
		/// </summary>
		/// <remarks>
		/// Note the problems of .NET according the termination of threads using the Abort-method.
		/// </remarks>
		public void Terminate()
		{
			ClientMessage("Stopping Requests. Terminating - please wait until all RequestClients have returned...");
			active = false;

			// terminate all subordinates threads:
			lock(requestThreads)
			{
				try 
				{
					foreach(ThreadInfo threadInfo in requestThreads)
					{
						threadInfo.clientRequest.Terminate();	
						
						// uncommenting this line causes infinit waiting of the clients if the
						// server does not return any answer or abort signale:
						//threadInfo.ExecutingThread.Abort(); 
					}	
				}
				catch (ThreadAbortException)
				{					
				}
				catch (Exception e)
				{
					ClientMessage("Error: " + e.Message);
				}				
			}

			requestThreads.Clear();
		}
	}
}
