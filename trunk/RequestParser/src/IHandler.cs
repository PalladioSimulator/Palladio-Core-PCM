using System;
using Request;
using System.Net.Sockets;

namespace RequestParser
{
	/// <summary>
	/// Zusammenfassung für RequestHandler.
	/// </summary>
	public interface IHandler
	{
		
	void HandleRequest(string request,NetworkStream client,DateTime arrival,ref RequestProssor.RequestProzessorComponent pro,TcpClient tcp);
	IHandler Successor{set;get;}
	}
}
