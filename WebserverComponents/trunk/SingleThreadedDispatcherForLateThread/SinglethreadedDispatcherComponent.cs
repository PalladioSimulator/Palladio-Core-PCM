using System;
using System.Net.Sockets;
using RequestParserForLateThread;
using ThreadedRequestProzessor;
using Request;
using System.Collections;
using System.Threading;

namespace SingleThreadedDispatcherForLateThread
{
	/// <summary>
	/// Zusammenfassung für DispatcherComponent.
	/// </summary>
	public class SinglethreadedDispatcherComponent
	{
		HTTPAcceptor acceptor;
		Dispatcher current;

		protected ThreadedRequestProzessorComponent sendsResponse;
		protected RequestParserComponent parsesRequest;
		protected bool shutdownRequested;

		//for handling requests
//		protected bool init =false;
//		protected Queue waiting;

		public SinglethreadedDispatcherComponent()
		{
	
			
		}

		public void StartServer(int port,ref RequestParserComponent parserComp, ref ThreadedRequestProzessorComponent sender )
		{
			this.shutdownRequested = false;
			this.sendsResponse = sender;
			this.parsesRequest = parserComp;
//			this.sendsResponse.testMoni.requestHandelt += new RequestProssor.MonitorWebServer.RequestServedHandler(this.RequestServed);
			this.acceptor = new HTTPAcceptor(port);
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
