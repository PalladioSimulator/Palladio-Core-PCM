using System;
using System.Net;
using System.Xml;
using System.IO;
using System.Net.Sockets;
using System.Threading;

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
		private TcpListener myListener ;

		/// <summary>
		/// All setting (like Server Root, Dir mapping,.. ) of a Server a
		///  stored in a Settings class. This is an instance of this.
		/// </summary>
		public ServerSettings io;


		/// <summary>
		///The constructor which make the TcpListener start listening on the
		///given port. It also calls a Thread on the method StartListen(). 
		/// </summary>
		public Server()
		{
			try
			{
				//load ServerSettings
				this.io= new ServerSettings();
				myListener = new TcpListener(this.io.ServerPort);
				myListener.Start();
				Console.WriteLine("Web Server Running...");

				//start the thread which calls the method 'StartListen'
				while(true)
				{
					//Accept a new connection
					Socket mySocket = myListener.AcceptSocket() ;
					connectedClient tt = new connectedClient(mySocket,ref this.io);
				}

			}
			catch(Exception e)
			{
				Console.WriteLine("An Exception Occurred while Listening :" +e.ToString());
				Console.WriteLine(e.Message);
				Console.WriteLine("Please press enter");
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