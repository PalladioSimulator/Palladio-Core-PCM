using System;
using System.Net.Sockets;
using RequestProssor;

namespace RequestParser
{
	/// <summary>
	/// </summary>
	public class RequestErrorHandler : IRequestHandler
	{
		private IRequestHandler successor;

		public void HandleRequest(DateTime arrival, ref RequestProcessorComponent pro, TcpClient d)
		{
			Console.WriteLine(" An error occurred!");
		}

		public IRequestHandler Successor
		{
			set { this.successor = value; }
			get { return this.successor; }
		}
	}
}