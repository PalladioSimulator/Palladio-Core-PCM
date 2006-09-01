using System;
using System.IO;
using System.Net.Sockets;
using System.Text;
using ICSharpCode.SharpZipLib.GZip;
using ICSharpCode.SharpZipLib.Zip;
using ICSharpCode.SharpZipLib.Zip.Compression;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.ZipHTTPRequestProcessorTools
{
	/// <summary>
	/// This component compresses the content data before sending it to its successor.
	/// Excluding the SendContentToClient-methods all requests are directly delegated to successor.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.3  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.2  2005/05/01 10:41:05  kelsaka
	/// - added gzip file compression
	///
	/// Revision 1.1  2005/04/30 12:38:24  kelsaka
	/// - extended cvs ignore lists
	/// - added first version of zip compressing request processor tools
	///
	/// </pre>
	/// </remarks>
	public class ZipHTTPRequestProcessorTools : Palladio.Webserver.HTTPRequestProcessorTools.IHTTPRequestProcessorTools
	{
		private IHTTPRequestProcessorTools successor;
		private IWebserverMonitor webserverMonitor;


		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="successor">The successor to call after compressing content</param>
		/// <param name="webserverMonitor">The monitor to use.</param>
		public ZipHTTPRequestProcessorTools(IHTTPRequestProcessorTools successor, IWebserverMonitor webserverMonitor)
		{
			this.successor = successor;
			this.webserverMonitor = webserverMonitor;
		}

		/// <summary>
		/// Append the given key value pair to the HTTP-header. Only extra information is allowed
		/// as a default header is already set. See <a href="http://www.faqs.org/rfcs/rfc2616.html">RFC</a>
		/// for more information.
		/// </summary>
		/// <param name="key">The key to use.</param>
		/// <param name="value">The value to set.</param>
		/// <remarks>Appends a line like "key: value".</remarks>
		public void AppendToHeader (string key, string value)
		{
			successor.AppendToHeader(key, value);
		}

		/// <summary>
		/// Removes a key value pair from the HTTP header.
		/// </summary>
		/// <param name="key">The key of the key value pair to remove.</param>
		public void RemoveFromHeader (string key)
		{
			successor.RemoveFromHeader(key);
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
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="networkStream">NetworkStream reference</param>
		public void SendContentToClient (string contentData, string httpVersion, string mimeType, Stream networkStream)
		{
			SendContentToClient(Encoding.ASCII.GetBytes(contentData), httpVersion, mimeType, networkStream);
		}

		/// <summary>
		/// Sends the data to the client. The byte-array might be used for binary data.
		/// </summary>
		/// <param name="contentDataBytes">Byte-array that contains the answer to the client request.</param>
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="networkStream">NetworkStream reference</param>
		public void SendContentToClient (byte[] contentDataBytes, string httpVersion, string mimeType, Stream networkStream)
		{		
			MemoryStream memoryStream = new MemoryStream();
			GZipOutputStream zipOutputStream = new GZipOutputStream(memoryStream);

			zipOutputStream.Write(contentDataBytes, 0, contentDataBytes.Length);
			zipOutputStream.Close();

			successor.AppendToHeader("Content-Encoding", "gzip");

			float compressionRatio = (float)contentDataBytes.Length / (float)memoryStream.ToArray().Length;
			webserverMonitor.WriteLogEntry("ZipHTTPRequestProcessorTools compression ratio: 1:"
				+ compressionRatio.ToString("N5"));
			// pass content to successor:
			successor.SendContentToClient(memoryStream.ToArray(), httpVersion, mimeType, networkStream);

			memoryStream.Close();
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
