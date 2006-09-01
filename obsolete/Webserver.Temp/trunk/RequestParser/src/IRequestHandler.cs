using System;
using System.Net.Sockets;
using RequestProssor;

namespace RequestParser
{
	/// <summary>
	/// Zusammenfassung für RequestHandler.
	/// </summary>
	public interface IRequestHandler 
	{
		void HandleRequest(DateTime arrival, ref RequestProcessorComponent pro, TcpClient tcp);

		IRequestHandler Successor { set; get; }
	}
}