using System;
using Request;

namespace RequestProssor.MonitorWebServer
{
	public delegate void RequestServedHandler (Monitor sender, RequestServedEventArgs e);
	public delegate void ServerShutdown(Monitor monitor);
	/// <summary>
	/// Zusammenfassung für Monitor.
	/// </summary>
	public class Monitor
	{
		
		
		public event RequestServedHandler requestHandelt;

		public event ServerShutdown shutdown;

		public Monitor()
		{

		}

		internal void ServerShutdown()
		{
			this.shutdown(this);
		}
		internal void RequestServed(HttpRequest req, HttPResponse res)
		{
			this.requestHandelt(this,new RequestServedEventArgs(req,res));
		}

//		protected virtual void OnProgressChange(RequestServedEventArgs e)
//		{
//			//Notify everybody in the receiver list about the new percentage 		
//			if (requestHandelt != null)
//			{
//				//Iterate manually through the receiver list
//				foreach (RequestServedHandler prog in requestHandelt.GetInvocationList())
//				{
//					Console.WriteLine(prog.ToString());
//				}
//			}
//			else
//			{
//				Console.WriteLine("it was null");
//			}
//		}
	}
}
