using System;	
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using MySmallWebServer.ExternalApplication;


namespace MySmallWebServer
{
	/// <summary>
	/// This is initated when a client is conntected. It's starts a thread
	/// in which the request of the connected client will be answered
	/// </summary>
	public class connectedClient
	{
		/// <summary>
		/// The <code>Socket</code> on which the client is conntected
		/// </summary>
		protected Socket mySocket;


		/// <summary>
		/// Teh settings of the Server
		/// </summary>
		private ServerSettings serverIo;


		/// <summary>
		/// The constructor of a connected CLient, iniates an new thread
		/// </summary>
		/// <param name="aSocket">The <code>Socket</code>on which the client is connected</param>
		/// <param name="io">The serversettings as reference</param>
		public connectedClient(Socket aSocket,ref ServerSettings io)
		{
			this.mySocket= aSocket;
			Thread th = new Thread(new ThreadStart(StartListen));
			this.serverIo = io;
			th.Start();
		}

		/// <summary>
		///This method Accepts new connection and
		///First it receives the welcome massage from the client, This
		///method is calles when a new client has connected.
		/// </summary>
		public void StartListen()
		{
	
			//Console.WriteLine("in Start Listen");
			Console.WriteLine ("Socket Type " + mySocket.SocketType ); 
			if(mySocket.Connected)
			{
				Console.WriteLine("\nClient Connected!!\n==================\nCLient IP {0}\n", 
					mySocket.RemoteEndPoint) ;

				//make a byte array and receive data from the client 
				Byte[] bReceive = new Byte[1024] ;
				int i = mySocket.Receive(bReceive,bReceive.Length,0) ;

				//Convert Byte to String
				string sBuffer = Encoding.ASCII.GetString(bReceive);
				Console.WriteLine("The Request: "+sBuffer);
//
			try
				{
				RequestParser parser = new RequestParser(ref mySocket,ref serverIo, sBuffer);
				ClientRequest request = parser.GeneratedClientRequest;
				if(request.RequestedMethod is GetMethod)
				{
					ClientResponse response = new ClientResponse(request);
					SendToClient sender = new SendToClient(response);
					sender.SendResponse();
					response.ClientRequest.ClientSocket.Close();
				}
				if(request.RequestedMethod is PostMethod)
				{
					ExternalClientResponse exr = new ExternalClientResponse(request);
					ClientResponse res = exr.GeneratedResponse;
					Console.WriteLine(res.ToString());
					SendToClient sender1 = new SendToClient(res);
					sender1.SendResponse();
					res.ClientRequest.ClientSocket.Close();

				}


				}
				catch(Exception e)
				{
						Console.WriteLine(" Not able to answer request"+e.Message);
				}

			}
		}
		
			
	}
	
}
