using System;
using System.Net.Sockets;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.ZipHTTPRequestProcessorTools
{
	/// <summary>
	/// This component compresses the content data before sending it to its successor.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/04/30 12:38:24  kelsaka
	/// - extended cvs ignore lists
	/// - added first version of zip compressing request processor tools
	///
	/// </pre>
	/// </remarks>
	public class ZipHTTPRequestProcessorTools : Palladio.Webserver.HTTPRequestProcessor.IHTTPRequestProcessorTools
	{
		private IHTTPRequestProcessorTools successor;
		private IWebserverMonitor webserverMonitor;

		public ZipHTTPRequestProcessorTools(IHTTPRequestProcessorTools successor, IWebserverMonitor webserverMonitor)
		{
			this.successor = successor;
			this.webserverMonitor = webserverMonitor;
		}

		/// <summary>
		/// This method sends the header information to the client.
		/// </summary>
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="totalBytes">Total Bytes to be sent in the body</param>
		/// <param name="httpStatusCode">Status Code of the HTTP-Answer.</param>
		/// <param name="networkStream">NetworkStream reference</param>
		public void SendHTTPHeader (string httpVersion, string mimeType, int totalBytes, string httpStatusCode, NetworkStream networkStream)
		{
			successor.SendHTTPHeader(httpVersion, mimeType, totalBytes, httpStatusCode, networkStream);
		}

		/// <summary>
		/// Generates a standard HTTP-Error and sends it to the client.
		/// </summary>
		/// <param name="httpRequest">From the Client-Request.</param>
		/// <param name="errorMessage">The error Message to display to the client.</param>
		/// <param name="errorCode">The HTTP-Error-Code</param>
		public void SendHTTPError (IHTTPRequest httpRequest, string errorMessage, string errorCode)
		{
			successor.SendHTTPError(httpRequest, errorMessage, errorCode);
		}

		/// <summary>
		/// Sends the data to the client.
		/// </summary>
		/// <param name="contentData">String that contains the answer to the client request.</param>
		/// <param name="networkStream">NetworkStream reference</param>
		public void SendContentToClient (string contentData, NetworkStream networkStream)
		{
			successor.SendContentToClient(contentData, networkStream);
		}

		/// <summary>
		/// Sends the data to the client. The byte-array might be used for binary data.
		/// </summary>
		/// <param name="contentDataBytes">Byte-array that contains the answer to the client request.</param>
		/// <param name="networkStream">NetworkStream reference</param>
		public void SendContentDataToClient (byte[] contentDataBytes, NetworkStream networkStream)
		{
			successor.SendContentDataToClient(contentDataBytes, networkStream);
		}

		/// <summary>
		/// Build the path to the actually requested file, either relative or absoulte path.
		/// (Uses the documentRoot from the webserver-configuration to build the complete path.)
		/// </summary>
		/// <param name="requestedPath">Build the complete path for this part of the request.</param>
		/// <returns>Path to file / directory requested.</returns>
		public string BuildCompletePath (string requestedPath)
		{
			return successor.BuildCompletePath(requestedPath);
		}

		/// <summary>
		/// Returns the the MimeType for the specified file-type.
		/// </summary>
		/// <param name="requestedFileType">For this filetype you get the mimetype.</param>
		/// <returns>The mimetype. If no fitting mimetype was found the default type is returned.</returns>
		public string GetFileMimeTypeFor (string requestedFileType)
		{
			return successor.GetFileMimeTypeFor(requestedFileType);
		}

		/// <summary>
		/// Opens the file given by the path and the filename.
		/// </summary>
		/// <param name="completePath">The complete path directing to the specified filename.</param>
		/// <param name="fileName">The Filename that shall be opened.</param>
		/// <returns>The file's content a byte-array.</returns>
		public byte[] OpenFile (string completePath, string fileName)
		{
			return successor.OpenFile(completePath, fileName);
		}
	}
}
