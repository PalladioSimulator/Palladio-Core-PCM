using System;
using System.Data;
using System.Net;
using SimpleLogging;
using System.Net.Sockets;

namespace Dispatcher
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	/// 

	public class HTTPAcceptor
	{
		public TcpListener portListener ;
		private SimpleLogger logger;
		
		int port;

		public HTTPAcceptor(int port)
		{

			this.port= port;

			Console.WriteLine("Starting Accepting client");
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput=true;
			this.logger.ErrorOutput=true;

			try
			{
				
				IPAddress local = IPAddress.Parse("192.168.0.3");  //(134106144138);
//				TcpListener test = new TcpListener(local,90);
				this.portListener = new TcpListener(local,port);
				portListener.Start();
				logger.Debug("Server Started....");
			}
			catch(Exception e)
			{
				this.logger.Error("An Exception Occurred while Listening :" +e.ToString());
				this.logger.Error(e.Message);
				this.logger.Error("Please press enter");
				Console.Read();
			}

		}


		public Socket Listen()
		{
			this.logger.Debug("Waiting for a call");
			//Accept a new connection
			Socket clinetSocket = portListener.AcceptSocket() ;
			this.logger.Debug("Client connected "+DateTime.Now );
			return clinetSocket;
			
		}
		
		
	}
}
