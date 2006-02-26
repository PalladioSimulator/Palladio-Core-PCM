using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace Palladio.Webserver.RequestClient
{
	/// <summary>
	/// ClientRequest. Provides Methods to send HTTP requests to a server.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/03/03 07:54:10  kelsaka
	/// use of a constant set of threads; performance enhancements
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
	public class ClientRequest
	{
		private IPAddress ipAddress;
		private int port;
		private HTTPRequestGenerator.HandleRequestEvent requestEventHandler;
		private byte[] request;
		private int loopDelay;

		/// <summary>
		/// Indicates, that the client is still active.
		/// </summary>
		private bool active;


		/// <summary>
		/// Standard constructor. Sets up the request options.
		/// </summary>
		/// <param name="ipAddress">Sends requests to this IPAdresse.</param>
		/// <param name="port">Sends requests to this Port.</param>
		/// <param name="requestEventHandler">Handler to send messages.</param>
		/// <param name="request">Content send to the server.</param>
		/// <param name="loopDelay">Delay of looping in ms.</param>
		public ClientRequest(IPAddress ipAddress, int port, HTTPRequestGenerator.HandleRequestEvent requestEventHandler, byte[] request, int loopDelay)
		{
			this.ipAddress = ipAddress;
			this.port = port;
			this.requestEventHandler = requestEventHandler;
			this.request = request;
			this.loopDelay = loopDelay;
		}


		/// <summary>
		/// Sends requests (looped) to the specified server until set to Terminate. Afterwards reads the full answer of the server.
		/// </summary>
		public void SendRequest()
		{
			this.active = true;
			TcpClient tcpClient;
			NetworkStream networkStream;
			
			//loop until set to inactive:
			while(active)
			{
				tcpClient = new TcpClient();
				try 
				{
					tcpClient.Connect(ipAddress, port);
					networkStream = tcpClient.GetStream();
					try 
					{
						// send data/request to the server:
						networkStream.Write(request, 0, request.Length);
						//requestEventHandler(Thread.CurrentThread.Name + ": Successfully send request to server.");
					

						//read full answer:
						while(active)
						{
							if (networkStream.ReadByte() == -1)
							{
								break;
							}
						}
					
						requestEventHandler(Thread.CurrentThread.Name + ": Successfully read answer from the server.");
					}
					catch(Exception e)
					{
						requestEventHandler("Error in " + Thread.CurrentThread.Name + ": " + e);
					}
					finally 
					{
						networkStream.Close();
					}
				}
				catch(Exception e)
				{
					requestEventHandler("Error in " + Thread.CurrentThread.Name + ": " + e);
				}
				finally 
				{
					tcpClient.Close();
				}	
	
				// sleep to produce a delay until the next request.
				Thread.Sleep(loopDelay);
			}
		}



		/// <summary>
		/// Terminates the current instance.
		/// </summary>
		/// <remarks>
		/// Might not work properly if the webserver hangs up while writing the request. 
		/// </remarks>
		public void Terminate()
		{
			this.active = false;
		}

	}
}
