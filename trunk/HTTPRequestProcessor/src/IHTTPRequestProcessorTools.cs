using System;
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
	/// Revision 1.2  2004/10/30 11:42:08  kelsaka
	/// Added full support for static websites using the get-method; added several test-documents; changed CoR for HTTP-Processing: dynamic files are delivered first
	///
	/// </pre>
	/// </remarks>
	public interface IHTTPRequestProcessorTools
	{


		/// <summary>
		/// This method sends the header information to the client.
		/// </summary>
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="totalBytes">Total Bytes to be sent in the body</param>
		/// <param name="httpStatusCode">Status Code of the HTTP-Answer.</param>
		/// <param name="socket">Socket reference</param>
		void SendHTTPHeader(string httpVersion, string mimeType, int totalBytes, string httpStatusCode, Socket socket);



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
		/// <param name="socket">Socket reference</param>
		void SendContentToClient(string contentData, Socket socket);


		/// <summary>
		/// Sends the data to the client. The byte-array might be used for binary data.
		/// </summary>
		/// <param name="contentDataBytes">Byte-array that contains the answer to the client request.</param>
		/// <param name="socket">Socket reference</param>
		void SendContentToClient(byte[] contentDataBytes, Socket socket);



	}
}
