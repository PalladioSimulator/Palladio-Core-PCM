using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace Palladio.Webserver.RequestClient
{
	/// <summary>
	/// ClientRequest. Provides Methods to send requests to a server.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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

		/// <summary>
		/// Indicates, that the client is still active.
		/// </summary>
		private bool isActive;


		/// <summary>
		/// Standard constructor.
		/// </summary>
		/// <param name="ipAddress">Sends requests to this IPAdresse.</param>
		/// <param name="port">Sends requests to this Port.</param>
		/// <param name="requestEventHandler">Handler to send messages.</param>
		/// <param name="request">Content send to the server.</param>
		public ClientRequest(IPAddress ipAddress, int port, HTTPRequestGenerator.HandleRequestEvent requestEventHandler, byte[] request)
		{
			this.ipAddress = ipAddress;
			this.port = port;
			this.requestEventHandler = requestEventHandler;
			this.request = request;

			this.isActive = true;
		}


		/// <summary>
		/// Sends a requests to the specified server. Afterwards reads the full answer of the server.
		/// </summary>
		public void SendRequest()
		{
			TcpClient tcpClient = new TcpClient();
			
			try 
			{
				tcpClient.Connect(ipAddress, port);
				NetworkStream networkStream = tcpClient.GetStream();
				try 
				{
					// send data/request to the server:
					networkStream.Write(request, 0, request.Length);
					//requestEventHandler(Thread.CurrentThread.Name + ": Successfully send request to server.");
					

					//read full answer:
					while(true)
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
				this.isActive = false;
			}
			
		}


		/// <summary>
		/// Indicates, that the client is still active.
		/// </summary>
		public bool IsActive
		{
			get { return isActive; }
		}

	}
}
