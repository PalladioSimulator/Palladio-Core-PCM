using System;
using System.Net.Sockets;


namespace RequestParserForLateThread
{
	/// <summary>
	/// Zusammenfassung für HTTPRequestParser.
	/// </summary>
	public class RequestParserComponent 
	{
		IHandler handler; 
		public RequestParserComponent() 
		{
			this.handler = new ErrorHandler();
		}

		public void IdentifiyAndHandleRequest(string request,NetworkStream client, DateTime arravial, 
			ref ThreadedRequestProzessor.ThreadedRequestProzessorComponent pro, TcpClient tcpCl)
		{
			Console.WriteLine("Start handling request");
			this.handler.HandleRequest(arravial,ref pro,tcpCl);
		}

		public void AddAdditionalHandler(IHandler handler)
		{
			handler.Successor = this.handler;
			this.handler = handler;
		}


	}
}
