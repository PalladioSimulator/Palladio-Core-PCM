using System;
using System.Collections;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

namespace RequestClient
{
	/// <summary>
	/// HTTPRequestGenerator.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
		
		/// <summary>
		/// Message to be sent to the server.
		/// </summary>
		private string requestString;


		public HTTPRequestGenerator()
		{
			this.requestThreads = new ArrayList();			
		}


		public delegate void HandleRequestEvent(string message);
		public event HandleRequestEvent ClientMessage;


		/// <summary>
		/// Sends HTTP-Requests to the specified client.
		/// </summary>
		/// <param name="requestUri">Client uri. The site to request (e. g. http://127.0.0.1:81/index.html).</param>
		/// <param name="numberOfThreads">The number of threads to use parallel.</param>
		/// <param name="numberOfLoops">How many loops.</param>
		public void StartRequest(string requestUri, int numberOfThreads, int numberOfLoops, int sendDelayInMilliseconds)
		{
			ClientMessage("Starting Requests. Address: " + requestUri + ", Number of simultaneous Requests: " + numberOfThreads + ", Number Of Loops: " + numberOfLoops);
			ClientMessage("NOTE: according to the simultaneous access to the log-field without any mutex currently some messages from the threads might be lost.");

			// Parse input data.
			Uri uri = new Uri(requestUri);
			IPAddress ipAddress = IPAddress.Parse(uri.Host);
			int port = uri.Port;
			requestString = "GET " + uri.PathAndQuery + " HTTP/1.1\nHost:" + uri.Host + "\n\n";
			ClientMessage("Details. URI: " + uri  + ", ip: " + ipAddress + ", port: " + port + ", request: \"" + requestString + "\".");
			

			for (int x = 0; x < numberOfLoops; x++)
			{
				ClientMessage("Starting loop number " + (x+1) + ".");
			
				for (int y = 0; y < numberOfThreads; y++)
				{
					ThreadInfo threadInfo = new ThreadInfo();
					threadInfo.clientRequest = new ClientRequest(ipAddress, port, new HandleRequestEvent(FireClientMessage), Encoding.ASCII.GetBytes(requestString));				
					threadInfo.ExecutingThread = new Thread(new ThreadStart(threadInfo.clientRequest.SendRequest));
					threadInfo.ExecutingThread.Start();
					threadInfo.ExecutingThread.Name = "Request-Thread number " + (y+1);
					requestThreads.Add(threadInfo);
					ClientMessage("Started Thread: " + threadInfo.ExecutingThread.Name + ".");
					
					Thread.Sleep(sendDelayInMilliseconds);
				}

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


		public void TerminateThreads()
		{
			/*bool outstandingThreads = true;
			while(outstandingThreads)
			{
				outstandingThreads = false;*/
				foreach(ThreadInfo threadInfo in requestThreads)
				{
			
					threadInfo.ExecutingThread.Abort();
					/*if(threadInfo.clientRequest.IsActive)
					{
						//outstandingThreads = true;
					}*/
				}
			//}*/
		}
	}
}
