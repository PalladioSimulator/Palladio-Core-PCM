using System;
using System.Net.Sockets;
using RequestParser;
using RequestProssor;
using Request;
using System.Collections;
using System.Threading;
using XMLConfigReader;

namespace SinglethreadedDispatcher
{
	/// <summary>
	/// Zusammenfassung für DispatcherComponent.
	/// </summary>
	public class SinglethreadedDispatcherComponent
	{
		HTTPAcceptor acceptor;
		Dispatcher current;

		protected RequestProzessorComponent sendsResponse;
		protected RequestParserComponent parsesRequest;
		protected bool shutdownRequested;
		protected int serverPort;
		protected bool dectecIP;

		//for handling requests
//		protected bool init =false;
//		protected Queue waiting;

		public SinglethreadedDispatcherComponent(string configFilePath)
		{
			//Load Config File
			//ConfigurationSettings config = ConfigurationSettings.AppSettings;			
			XMLConfigFileReader configReader = new XMLConfigFileReader(configFilePath);
			ConfigTable config = configReader.GetConfigTable("DispatcherSettings");
			this.serverPort = int.Parse(config["serverPort"].ToString());
			if(config["IpAutoRecognition"].ToString()=="false")
				this.dectecIP=false;
			else
				this.dectecIP=true;
		}


		public void StartServer(ref RequestParserComponent parserComp, ref RequestProzessorComponent sender )
		{
			this.shutdownRequested = false;
			this.sendsResponse = sender;
			this.parsesRequest = parserComp;
//			this.sendsResponse.testMoni.requestHandelt += new RequestProssor.MonitorWebServer.RequestServedHandler(this.RequestServed);
			this.acceptor = new HTTPAcceptor(this.serverPort,this.dectecIP);
//			this.waiting = new Queue();
			Running();
		}

		public void Running()
		{
			TcpClient dada =null;
			try
			{

				
				while(!this.shutdownRequested)
				{
					Console.WriteLine("ich warte");
					dada = acceptor.portListener.AcceptTcpClient();
					this.current = new Dispatcher(dada, DateTime.Now, ref this.parsesRequest, ref this.sendsResponse);
					
				}
				if(this.shutdownRequested)
				{
					Console.WriteLine("Shutdown requested");
					this.sendsResponse.ShutDown();
				}
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine("Beende Verbindung");
				dada.Close();
				
			}
		}


//		internal void RequestServed(RequestProssor.MonitorWebServer.Monitor sender, RequestProssor.MonitorWebServer.RequestServedEventArgs e)
//		{
//			Console.WriteLine("REquest wurde gehandelt kann uas queue genommen werden");
//		}

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
			get{ return this.current.ClientSocket;}
		}

		public string Request
		{
			get{return this.current.Request;}
		}

		public DateTime TimeConnected
		{
			get{return this.current.ArrivalTime;}
		}

	}
}
