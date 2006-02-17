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
		private IRequestHandler requestHandler;

		public RequestParserComponent()
		{
			this.requestHandler = new RequestErrorHandler();
		}

		public void HandleRequest(string request, NetworkStream client, DateTime arravial,
		                                      ref RequestProcessorComponent pro, TcpClient tcpCl)
		{
			Console.WriteLine("Start handling request");
			this.requestHandler.HandleRequest(arravial, ref pro, tcpCl);
		}

		public void AddHandler(IRequestHandler requestHandler)
		{
			requestHandler.Successor = this.requestHandler;
			this.requestHandler = requestHandler;
		}


	}
}