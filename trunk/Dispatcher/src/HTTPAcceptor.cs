using System;
using System.Data;
using System.Net;
using SimpleLogging;
using System.Net.Sockets;
using System.Collections;

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


		public ArrayList getIPs()
		{
			ArrayList localIPAdresses=new ArrayList();
			String strHostName = Dns.GetHostName();
			IPHostEntry iphostentry = Dns.GetHostByName(strHostName);
			foreach(IPAddress ipaddress in iphostentry.AddressList)
			{
				localIPAdresses.Add(ipaddress);
			}
			return localIPAdresses;
		}


		public HTTPAcceptor(int port, bool IpAutoRecognition)
		{

			this.port= port;
			
			Console.WriteLine("Starting Accepting client");
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput=true;
			this.logger.ErrorOutput=true;

			try
			{
				IPAddress local;
				if(IpAutoRecognition)
				{
					ArrayList localIP = getIPs();
					local = (IPAddress) localIP[0];
				}
				else
				{
					local = IPAddress.Parse("127.0.0.1");  //(134106144138);
				}

				this.logger.Debug("Local Ip is: "+local.Address.ToString());
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
