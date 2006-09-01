using System;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using log4net;
using log4net.Config;
using log4net.Appender;

using MySmallWebServer.ExternalApplication;
[assembly: log4net.Config.DOMConfigurator(ConfigFileExtension="log4net", Watch=true)]
namespace MySmallWebServer

{
	/// <summary>
	/// This is initated when a client is conntected. It's starts a thread
	/// in which the request of the connected client will be answered
	/// </summary>
	public class ConnectedClient
	{
		/// <summary>
		/// The <code>Socket</code> on which the client is conntected
		/// </summary>
		protected Socket mySocket;

		private static readonly log4net.ILog log = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);
		


		/// <summary>
		/// Teh settings of the Server
		/// </summary>
		private ServerSettings serverIo;


		/// <summary>
		/// The constructor of a connected CLient, iniates an new thread
		/// </summary>
		/// <param name="aSocket">The <code>Socket</code>on which the client is connected</param>
		/// <param name="io">The serversettings as reference</param>
		public ConnectedClient(Socket aSocket,ServerSettings io)
		{
			
			this.mySocket= aSocket;
			Thread clientThread = new Thread(new ThreadStart(StartListen));
			this.serverIo = io;
			clientThread.Start();
		}


		/// <summary>
		///This method accepts new connection and
		///first it serves the welcome massage from the client, This
		///method is calles when a new client has connected.
		/// </summary>
		public void StartListen()
		{
	
			//Console.WriteLine("in Start Listen");
			Console.WriteLine ("Socket Type " + mySocket.SocketType ); 
			if(mySocket.Connected)
			{
				log.Info("\nClient Connected!!\n==================\nCLient IP" +mySocket.RemoteEndPoint) ;

				//make a byte array and receive data from the client 
				Byte[] receiveStream = new Byte[1024] ;
				int i = mySocket.Receive(receiveStream,receiveStream.Length,0) ;

				//Convert Byte to String
				string responseAsString = Encoding.ASCII.GetString(receiveStream);
				
				log.Debug("The Request: "+responseAsString);
				AbstractResponse response =null;

				try
				{
					RequestParser parser = new RequestParser(ref mySocket,serverIo, responseAsString);
					ClientRequest request = parser.GeneratedClientRequest;
					SendToClient sender  =null;

					if(request.RequestedMethod is GetMethod)
					{
						response = new ClientResponse(request);
						sender = new SendToClient(response);
					}
					if(request.RequestedMethod is PostMethod)
					{
						response = new ExternalClientResponse(request);
						sender = new SendToClient(response.GeneratedResponse);
					}
					if(request.RequestedMethod is HeadMethod)
					{
						response = new ClientResponse(request);
						sender = new SendToClient(response);
					}
					sender.SendResponse();
					response.ClientRequest.ClientSocket.Close();
					

				}
				catch(Exception e)
				{
					log.Error(" Not able to answer request"+e.Message);
				}
				

			}
		}		
	}
}
