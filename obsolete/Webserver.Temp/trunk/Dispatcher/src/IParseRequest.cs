using System;
using System.Net.Sockets;

namespace Dispatcher
{
	/// <summary>
	/// Zusammenfassung für IParseRequest.
	/// </summary>
	public interface IParseRequest
	{
		void ParseRequest(string request, DateTime now, Socket clientSocket);
	}
}
