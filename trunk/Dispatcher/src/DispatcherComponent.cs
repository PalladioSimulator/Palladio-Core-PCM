using System;
using System.Net.Sockets;
using RequestParser;
using RequestProssor;
using System.Configuration;
using XMLConfigReader;
using System.Collections;

namespace Dispatcher
{
	/// <summary>
	/// Zusammenfassung für DispatcherComponent.
	/// </summary>
	public class DispatcherComponent
	{
		HTTPAcceptor acceptor;
		DispatcherThread current;

		RequestProzessorComponent sendsResponse;
		RequestParserComponent parsesRequest;
		protected bool shutdownRequested;
		protected bool dectecIP;
		protected int serverPort;

		public DispatcherComponent()
		{
			//Load Config File
			//ConfigurationSettings config = ConfigurationSettings.AppSettings;			
			XMLConfigFileReader configReader = new XMLConfigFileReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\Config Files\ConfigDispatcher.xml");
			ConfigTable config = configReader.GetConfigTable("DispatcherSettings");
			this.serverPort = int.Parse(config["serverPort"].ToString());
			if(config["IpAutoRecognition"].ToString()=="false")
				this.dectecIP=false;
			else
				this.dectecIP=true;

			//for debugging XMLConfigReader --> ICh weiß, dass das böse ist
			ConfigList cf = configReader.GetConfigList("VDirs","RequestedDir","realDir");
			foreach(DictionaryEntry di in cf)
			{
				Console.WriteLine(di.Value.ToString());
			}
			
			
		}

		public void StartServer(ref RequestParserComponent parserComp, ref RequestProzessorComponent sender )
		{
			this.shutdownRequested = false;
			this.sendsResponse = sender;
			this.parsesRequest = parserComp;
			this.acceptor = new HTTPAcceptor(this.serverPort,this.dectecIP);
			Running();
		}

		public void Running()
		{
			TcpClient dada =null;//=null;
			try
			{

				
				while(!this.shutdownRequested)
				{
					Console.WriteLine("ich warte");
					dada = acceptor.portListener.AcceptTcpClient();
					this.current = new DispatcherThread(dada, DateTime.Now, ref this.parsesRequest, ref this.sendsResponse);
				}
				if(this.shutdownRequested)
				{
					Console.WriteLine("Jetzt geht es zu ende");
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
