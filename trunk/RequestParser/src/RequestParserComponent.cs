using System;
using System.Net.Sockets;
using RequestProssor;


namespace RequestParser
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
			ref RequestProssor.RequestProzessorComponent pro, TcpClient tcpCl)
		{
			Console.WriteLine("Start handling request");
			this.handler.HandleRequest(request,client,arravial,ref pro,tcpCl);
		}

		public void AddAdditionalHandler(IHandler handler)
		{
			handler.Successor = this.handler;
			this.handler = handler;
		}


	}
}
