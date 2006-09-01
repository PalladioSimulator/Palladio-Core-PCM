using System;
using System.Net.Sockets;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// IHandlerThread. Each request of the webserver is put into a individual thread. This interface has to be
	/// implemented by these threads to handle the request. 
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/02 17:34:57  kelsaka
	/// Added multi-threading to handle requests.
	/// Added short architectural description.
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IRequestHandler
	{

		/// <summary>
		/// Starts for the given request the HandleRequest-method from the first link of the CoR.
		/// </summary>
		void HandleRequest();


		/// <summary>
		/// The socket-connection to the client.
		/// </summary>
		Socket ClientSocket { get; set; }
		

		/// <summary>
		/// Stops the current IHandlerThread.
		/// </summary>
		void Stop();
		
	}
}
