using System;
using System.Net.Sockets;

namespace SingleThreadedDispatcherForLateThread
{
	/// <summary>
	/// Zusammenfassung für IParseRequest.
	/// </summary>
	public interface IParseRequest
	{
		void ParseRequest(string request, DateTime now, Socket clientSocket);
	}
}
