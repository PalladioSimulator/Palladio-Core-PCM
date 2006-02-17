using System;
using System.Net;
using System.Xml;
using System.IO;
using System.Net.Sockets;
using System.Threading;
using System.Collections;
using log4net.Config;
using log4net;

namespace MySmallWebServer
{
	/// <summary>
	/// This is tthe main class, it opens a Port and waits for
	/// incomming requests an trys to answer them
	/// </summary>
	public class Server
	{
		
		/// <summary>
		/// A TcpListener witch listens to the Port 
		/// </summary>
		private TcpListener portListener ;

		/// <summary>
		/// All setting (like Server Root, Dir mapping,.. ) of a Server a
		///  stored in a Settings class. This is an instance of this.
		/// </summary>
		public ServerSettings io;

		private  readonly  ILog log = LogManager.GetLogger(typeof(Server));

		/// <summary>
		///The constructor which make the TcpListener start listening on the
		///given port. It also calls a Thread on the method StartListen(). 
		/// </summary>
		public Server()
		{
			try
			{

				log4net.Config.BasicConfigurator.Configure();
				//load ServerSettings
				this.io= new ServerSettings();
				portListener = new TcpListener(this.io.ServerPort);
				portListener.Start();
				this.log.Info(this.io.ToString());
				this.log.Info("Web Server Running...");
				
				
				//start the thread which calls the method 'StartListen'
				while(true)
				{
					//Accept a new connection
					Socket clinetSocket = portListener.AcceptSocket() ;
					ConnectedClient connectedClient = new ConnectedClient(clinetSocket, this.io);
				}

			}
			catch(Exception e)
			{
				this.log.Error("An Exception Occurred while Listening :" +e.ToString());
				this.log.Error(e.Message);
				this.log.Error("Please press enter");
				Console.Read();
			}
		}

		
		/// <summary>
		/// This is the Main Method of this Application, it starts here
		/// </summary>
		public static void Main() 
		{
			Server MSWS = new Server();
		}
	}
}