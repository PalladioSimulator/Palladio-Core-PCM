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
		private int LoopDelay;
		private int sendDelayInMilliseconds;
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
		/// <param name="LoopDelay">Delay before starting new threads. (Used, if the first amount of threads has been
		/// started, before starting the next threads.)</param>
		/// <param name="sendDelayInMilliseconds">Time in milliseconds between the starting of threads. (Thread.Sleep)</param>
		public void Setup(string requestUri, int numberOfThreads, int LoopDelay, int sendDelayInMilliseconds)
		{
			this.numberOfThreads = numberOfThreads;
			this.LoopDelay = LoopDelay;
			this.sendDelayInMilliseconds = sendDelayInMilliseconds;

			// Parse input data.
			this.uri = new Uri(requestUri);
			this.ipAddress = IPAddress.Parse(uri.Host);
			this.port = uri.Port;
			requestString = "GET " + uri.PathAndQuery + " HTTP/1.1\nHost:" + uri.Host + "\n\n";
			ClientMessage("Details. URI: " + uri  + ", ip: " + ipAddress + ", port: " + port + ", request: \"" + requestString + "\".");
		}



		/// <summary>
		/// Sends HTTP-Requests to the specified client. Execute Setup() first.
		/// </summary>
		public void GenerateRequests()
		{
			this.active = true;
			ClientMessage("Starting Requests. Address: " + uri + ", Number of simultaneous Requests: " + numberOfThreads + ", Number Of Loops: " + LoopDelay);
			ClientMessage("NOTE: according to the simultaneous access to the log-field without any mutex currently some messages from the threads might be lost.");			

			StartNewThreads();
		}


		private void StartNewThreads()
		{
			// calculated number of non-started threads:
			int numberOfThreadsToStart = numberOfThreads - requestThreads.Count;

			for (int y = 0; y < numberOfThreadsToStart && active; y++)
			{
				ThreadInfo threadInfo = new ThreadInfo();
				threadInfo.clientRequest = new ClientRequest(ipAddress, port, new HandleRequestEvent(FireClientMessage), Encoding.ASCII.GetBytes(requestString), this);				
				threadInfo.ExecutingThread = new Thread(new ThreadStart(threadInfo.clientRequest.SendRequest));
				threadInfo.ExecutingThread.Start();
				threadInfo.ExecutingThread.Name = "Request-Thread number " + (y+1);
				requestThreads.Add(threadInfo);
				ClientMessage("Started Thread: " + threadInfo.ExecutingThread.Name + ".");
					
				Thread.Sleep(sendDelayInMilliseconds);
			}
		}


		/// <summary>
		/// Removes unused threads from the list of threads. Callback function used by the <see cref="ClientRequest"/>.
		/// </summary>
		/// <param name="clientRequest">Reference to the clientRequest that has to be removed (caller of this method).</param>
		public void RemoveFinishedClientRequestThread(ClientRequest clientRequest)
		{
			for (int x = 0; x < requestThreads.Count; x++)
			{
				if( ((ThreadInfo)requestThreads[x]).clientRequest.Equals(clientRequest) )
				{
					requestThreads.Remove(requestThreads[x]);
				}
			}
			Thread.Sleep(LoopDelay);
			StartNewThreads();
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
		/// Calls the Abort-method of each thread, that has been started. Prevents further threads to get started.
		/// </summary>
		/// <remarks>
		/// Note the problems of .NET according the termination of threads using the Abort-method.
		/// </remarks>
		public void Terminate()
		{
			active = false;

			// terminate all subordinates threads:
			lock(requestThreads)
			{
				try 
				{
					
					//for (int x = 0; x < requestThreads.Count; x++)
					///{
					//	ThreadInfo threadInfo = (ThreadInfo)requestThreads[x];

					foreach(ThreadInfo threadInfo in requestThreads)
					{
						threadInfo.clientRequest.Terminate();				
						threadInfo.ExecutingThread.Abort();
					}	
				}
				catch (Exception)
				{
					Console.WriteLine("ERROR!");
					//TODO: make locking work.
				}
			}
		}
	}
}
