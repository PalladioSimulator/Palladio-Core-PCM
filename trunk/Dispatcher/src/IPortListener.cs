using System.Net;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// </summary>
	public interface IPortListener
	{
		/// <summary>
		/// Unfortunately, there is no way to terminate
		/// a blocked thread using the <c>Thread.Abort</c> or
		/// <c>Thread.Interrupt</c> methods. To ensure the clean
		/// exit of the tread, we introduce the 'isRunning'
		/// flag. The main thread sets this value to false and
		/// causes the thread to terminate as soon as	it is
		/// unblocked and tries to start a new iteration. The 
		/// main thread has to unblock this thread by opening
		/// a new connection.
		/// </summary>
		bool IsRunning { get; set; }

		/// <summary>
		/// The thread listens on this port.
		/// </summary>
		int Port { get; }

		/// <summary>
		/// The thread accepts only requests to this IP.
		/// </summary>
		IPAddress Address { get; }

		/// <summary>
		/// Use this method as a delegate to start a thread listening on the specified port, using the specified tcplistener.
		/// </summary>
		void StartListen();
	}
}