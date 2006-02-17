using System;
using System.Collections;
using System.Net.Sockets;
using RequestParser;
using RequestProssor;
using Palladio.XMLConfigReader;

namespace Dispatcher
{
	/// <summary>
	/// Zusammenfassung für DispatcherComponent.
	/// </summary>
	public class DispatcherComponent
	{
		private HTTPAcceptor acceptor;
		private DispatcherThread current;

		private RequestProcessorComponent sendsResponse;
		private RequestParserComponent parsesRequest;
		protected bool shutdownRequested;
		protected bool dectecIP;
		protected int serverPort;

		public DispatcherComponent(string configFilePath)
		{
			//Load Config File
			XMLConfigFileReader configReader = new XMLConfigFileReader(configFilePath);
			ConfigTable config = configReader.GetConfigTable("DispatcherSettings");
			this.serverPort = int.Parse(config["serverPort"].ToString());
			if (config["IpAutoRecognition"].ToString() == "false")
				this.dectecIP = false;
			else
				this.dectecIP = true;
		}

		public void StartServer(ref RequestParserComponent parserComp, ref RequestProcessorComponent sender)
		{
			this.shutdownRequested = false;
			this.sendsResponse = sender;
			this.parsesRequest = parserComp;
			this.acceptor = new HTTPAcceptor(this.serverPort, this.dectecIP);
			Run();
		}

		public void Run()
		{
			TcpClient dada = null; //=null;
			try
			{
				while (!this.shutdownRequested)
				{
					Console.WriteLine("ich warte");
					dada = acceptor.portListener.AcceptTcpClient();
					this.current = new DispatcherThread(dada, DateTime.Now, ref this.parsesRequest, ref this.sendsResponse);
				}
				if (this.shutdownRequested)
				{
					Console.WriteLine("Jetzt geht es zu ende");
					this.sendsResponse.ShutDown();
				}
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine("Beende Verbindung");
				dada.Close();

			}


		}

		public void Shutdown()
		{
			this.shutdownRequested = true;
			Console.WriteLine("Tue alles was möglich ist");

		}

		public bool RequestRead()
		{
			return this.current.RequestRead;
		}

		public TcpClient Socket
		{
			get { return this.current.ClientSocket; }
		}

		public string Request
		{
			get { return this.current.Request; }
		}

		public DateTime TimeConnected
		{
			get { return this.current.ArrivalTime; }
		}

	}
}