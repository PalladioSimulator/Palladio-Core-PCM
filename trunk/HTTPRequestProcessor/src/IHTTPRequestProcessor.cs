using System;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestProcessor;

namespace Palladio.Webserver.HTTPRequestProcessor
{
	/// <summary>
	/// IHTTPRequestProcessor. This interface has to be implemented for each processing component of
	/// the Chain-Of-Responsibility (CoR). If a processor can not handle a IHTTPRequest it should be
	/// passed to the CoR-Successor.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.5  2005/01/22 16:42:56  kelsaka
	/// added configureable (XML) connection-string for the database;
	/// added thread-name for the main thread;
	/// fixed socket-error (updated documentation)
	///
	/// Revision 1.4  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.3  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.2  2004/10/22 12:55:56  kelsaka
	/// Actualised the UML-componentview; defined the webserverfactory-interface, therefore added some new interfaces
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IHTTPRequestProcessor : IRequestProcessor
	{
		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		void HandleRequest(IHTTPRequest httpRequest);
	}
}
