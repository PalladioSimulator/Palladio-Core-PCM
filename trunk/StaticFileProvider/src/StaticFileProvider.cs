using System;
using System.IO;
using System.Net.Sockets;
using System.Text;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.StaticFileProvider
{
	/// <summary>
	/// StaticFileProvider.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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

		public StaticFileProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.corSuccessor = corSuccessor;

			this.requestProcessorTools = new DefaultHTTPRequestProcessorTools(webserverMonitor, webserverConfiguration);
		}

		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void handleRequest (IHTTPRequest httpRequest)
		{


			// Path to the requestedFile:
			string completePath = requestProcessorTools.BuildCompletePath(httpRequest.RequestedDirectoyName);
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
	
			requestProcessorTools.SendHTTPHeader(httpRequest.HttpVersion, fileMimeType, fileContent.Length, "200 OK", httpRequest.Socket);
			requestProcessorTools.SendContentToClient(fileContent, httpRequest.Socket);
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
				for(int x = 0; x < webserverConfiguration.DefaultFileNames.Length; x++)
				{
					webserverMonitor.WriteLogEntry("Check " + completePath + webserverConfiguration.DefaultFileNames[x]);
					// Check whether the defaultFileName does exist (in descendend order, as defined in the settings):
					if (File.Exists(completePath + webserverConfiguration.DefaultFileNames[x]))
					{
						requestedFileName = webserverConfiguration.DefaultFileNames[x];
						break; // Valid-Filename found, so break searching.
					}				
				}
			}

			return requestedFileName;
		}



	}
}
