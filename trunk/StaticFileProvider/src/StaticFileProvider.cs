using System;
using System.IO;
using System.Net.Sockets;
using System.Text;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.StaticFileProvider
{
	/// <summary>
	/// StaticFileProvider. Returns by default all files that are placed in the document-root of the webserver. If a mime-type
	/// is specified for the request file-type (indentified by the file extension like .html), the mime-type is set in the 
	/// response, otherwise the default-mime-type is returned. The settings are done in the config-xml-file of the webserver.
	/// 
	/// If a file or directory is not found a error is returned. If for a directory a file is not explicitly set, the default
	/// file will be returned.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.13  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.12  2005/05/01 10:41:05  kelsaka
	/// - added gzip file compression
	///
	/// Revision 1.11  2005/01/29 21:47:45  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
	///
	/// Revision 1.10  2004/12/15 00:32:33  sliver
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
	/// Revision 1.9  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.8  2004/11/28 19:01:32  kelsaka
	/// Added simple support for searching on a database, that contains BibTeX-Entries, added test-documents, added DB-test-content, added comments
	///
	/// Revision 1.7  2004/11/21 17:10:04  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.6  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.5  2004/10/30 11:42:08  kelsaka
	/// Added full support for static websites using the get-method; added several test-documents; changed CoR for HTTP-Processing: dynamic files are delivered first
	///
	/// Revision 1.4  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.3  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.2  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class StaticFileProvider : IHTTPRequestProcessor
	{

		IWebserverMonitor webserverMonitor;
		IWebserverConfiguration webserverConfiguration;
		IHTTPRequestProcessor corSuccessor;
		IHTTPRequestProcessorTools requestProcessorTools;

		public StaticFileProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.corSuccessor = corSuccessor;

			this.requestProcessorTools = requestProcessorTools;
		}

		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void HandleRequest (IHTTPRequest httpRequest)
		{


			// Path to the requestedFile:
			string completePath = requestProcessorTools.BuildCompletePath(httpRequest.RequestedDirectoryName);
			if(!Directory.Exists(completePath))
			{
				requestProcessorTools.SendHTTPError(httpRequest,
					"<h1>Error! The requested directory does not exist.</h1>", "404 Not Found");
				return;
			}



			// The filename effectively requested by the client.
			// E. g. if only a directoy is specified this is the default filename:
			string requestedFileName = GetEffectivelyRequestedFilename(httpRequest.RequestedFileName, completePath);	
			if(!File.Exists(completePath +  requestedFileName))
			{
				requestProcessorTools.SendHTTPError(httpRequest,
					"<h1>Error!! The requested file does not exist or the default file for the requested directory does not exist.</h1>", "404 Not Found");
				return;
			}



			webserverMonitor.WriteLogEntry("Full filename and path effectively requested: " + completePath + requestedFileName);
			// The MimeType of the requested File.
			string fileMimeType = requestProcessorTools.GetFileMimeTypeFor(httpRequest.RequestedFileType);
			webserverMonitor.WriteLogEntry("Mime Type found: " + fileMimeType);




			DeliverStaticFile (completePath, requestedFileName, httpRequest, fileMimeType);			
		}




		/// <summary>
		/// Sends the specified file to the client.
		/// </summary>
		/// <param name="completePath">Path to the file</param>
		/// <param name="requestedFileName">File to send.</param>
		/// <param name="httpRequest"></param>
		/// <param name="fileMimeType"></param>
		private void DeliverStaticFile (string completePath, string requestedFileName, IHTTPRequest httpRequest, string fileMimeType)
		{			
			byte[] fileContent = requestProcessorTools.OpenFile (completePath, requestedFileName);
	
			requestProcessorTools.SendContentToClient(fileContent, httpRequest.HttpVersion, fileMimeType, httpRequest.NetworkStream);
			webserverMonitor.WriteLogEntry("Successfully sent response to client.");
		}








		/// <summary>
		/// Get the filename that will be delivered after all; using the default-filename-settings.
		/// </summary>
		/// <param name="requestedFileName">The filename the client requested.</param>
		/// <param name="completePath">The complete path to the file (not just the directory from the request!).</param>
		/// <returns>The Filename. In a case, that only a directory-name is specified
		/// (httpRequest-filename is empty) the default filename is used (see webserer-configuration (XML)).</returns>
		private string GetEffectivelyRequestedFilename (string requestedFileName, string completePath)
		{
			

			// get the filename and add it to the path:
			if(requestedFileName == "")
			{
				
				// Try for default Filenames as the requestedFileName is not specified:
				// JH: foreach is nicer, especially for the Seffs
				foreach (string defaultFileName in webserverConfiguration.DefaultFileNames)
				{
					webserverMonitor.WriteLogEntry("Check " + completePath + defaultFileName);
					// Check whether the defaultFileName does exist (in descendend order, as defined in the settings):
					if (File.Exists(completePath + defaultFileName))
					{
						requestedFileName = defaultFileName;
						break; // Valid-Filename found, so break searching.
					}				
				}
			}

			return requestedFileName;
		}



	}
}
