using System;
using System.Net.Sockets;
using Request;

namespace RequestParser
{
	/// <summary>
	/// Zusammenfassung für RequestHandler.
	/// </summary>
	public class ErrorHandler : IHandler
	{
		IHandler successor;
		public void HandleRequest(string request,NetworkStream client,DateTime arrival,ref RequestProssor.RequestProzessorComponent pro, TcpClient d)
		{
			Console.WriteLine(" An errror occured ");
		}

		public IHandler Successor
		{
			set{this.successor=value;}
			get{return this.successor;}
		}
	}
}