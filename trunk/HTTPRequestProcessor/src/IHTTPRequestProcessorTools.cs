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
