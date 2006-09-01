using System;
using Request;
using System.Net.Sockets;
using ThreadedRequestProzessor;

namespace RequestParserForLateThread
{
	/// <summary>
	/// Zusammenfassung für RequestHandler.
	/// </summary>
	public interface IHandler
	{
		
	void HandleRequest(DateTime arrival,ref ThreadedRequestProzessor.ThreadedRequestProzessorComponent pro,TcpClient tcp);
	IHandler Successor{set;get;}
	}
}
