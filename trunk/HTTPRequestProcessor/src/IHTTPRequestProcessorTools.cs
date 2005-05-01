using System;
using System.IO;
using System.Net.Sockets;
using Palladio.Webserver.Request;

namespace Palladio.Webserver.HTTPRequestProcessor
{
	/// <summary>
	/// IHTTPRequestProcessorTools. Standard utilities used to process a IHTTPRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2005/05/01 10:41:05  kelsaka
	/// - added gzip file compression
	///
	/// Revision 1.5  2005/01/29 21:47:44  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
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
	/// Revision 1.3  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.2  2004/10/30 11:42:08  kelsaka
	/// Added full support for static websites using the get-method; added several test-documents; changed CoR for HTTP-Processing: dynamic files are delivered first
	///
	/// </pre>
	/// </remarks>
	public interface IHTTPRequestProcessorTools
	{

		/// <summary>
		/// Append the given key value pair to the HTTP-header. Only extra information is allowed
		/// as a default header is already set. See <a href="http://www.faqs.org/rfcs/rfc2616.html">RFC</a>
		/// for more information.
		/// </summary>
		/// <param name="key">The key to use.</param>
		/// <param name="value">The value to set.</param>
		/// <remarks>Appends a line like "key: value".</remarks>
		void AppendToHeader(string key, string value);

		/// <summary>
		/// Removes a key value pair from the HTTP header.
		/// </summary>
		/// <param name="key">The key of the key value pair to remove.</param>
		void RemoveFromHeader(string key);

		/// <summary>
		/// Generates a standard HTTP-Error and sends it to the client.
		/// </summary>
		/// <param name="httpRequest">From the Client-Request.</param>
		/// <param name="errorMessage">The error Message to display to the client.</param>
		/// <param name="errorCode">The HTTP-Error-Code</param>
		void SendHTTPError(IHTTPRequest httpRequest, string errorMessage, string errorCode);


		/// <summary>
		/// Sends the data to the client.
		/// </summary>
		/// <param name="contentData">String that contains the answer to the client request.</param>
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="networkStream">NetworkStream reference</param>
		void SendContentToClient(string contentData, string httpVersion, string mimeType, Stream networkStream);


		/// <summary>
		/// Sends the data to the client. The byte-array might be used for binary data.
		/// </summary>
		/// <param name="contentDataBytes">Byte-array that contains the answer to the client request.</param>
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="networkStream">NetworkStream reference</param>
		void SendContentToClient(byte[] contentDataBytes, string httpVersion, string mimeType, Stream networkStream);


		/// <summary>
		/// Build the path to the actually requested file, either relative or absoulte path.
		/// (Uses the documentRoot from the webserver-configuration to build the complete path.)
		/// </summary>
		/// <param name="requestedPath">Build the complete path for this part of the request.</param>
		/// <returns>Path to file / directory requested.</returns>
		string BuildCompletePath(string requestedPath);


		/// <summary>
		/// Returns the the MimeType for the specified file-type.
		/// </summary>
		/// <param name="requestedFileType">For this filetype you get the mimetype.</param>
		/// <returns>The mimetype. If no fitting mimetype was found the default type is returned.</returns>
		string GetFileMimeTypeFor (string requestedFileType);


		/// <summary>
		/// Opens the file given by the path and the filename.
		/// </summary>
		/// <param name="completePath">The complete path directing to the specified filename.</param>
		/// <param name="fileName">The Filename that shall be opened.</param>
		/// <returns>The file's content a byte-array.</returns>
		byte[] OpenFile (string completePath, string fileName);

	}
}
