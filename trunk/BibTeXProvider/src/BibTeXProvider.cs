using System;
using System.IO;
using BibTeX.Formater.Interfaces;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using BibTeX.Parser;
using BibTeX.Parser.Interfaces;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.BibTeXProvider
{
	/// <summary>
	/// BibTeXProvider.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/11/21 17:10:04  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	///
	/// </pre>
	/// </remarks>
	public class BibTeXProvider : IHTTPRequestProcessor
	{

		private IWebserverConfiguration webserverConfiguration;
		private IWebserverMonitor webserverMonitor;
		private IHTTPRequestProcessor corSuccessor;
		private IHTTPRequestProcessorTools requestProcessorTools;

		public BibTeXProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.corSuccessor = corSuccessor;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.requestProcessorTools = new DefaultHTTPRequestProcessorTools(webserverMonitor, webserverConfiguration);

		}


		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void handleRequest (IHTTPRequest httpRequest)
		{
			//decide whether the actual request is of interest for BibTeX-Component.
			if(httpRequest.RequestedFileType != ".bibhtml" && httpRequest.RequestedFileType != ".bib") //TODO: read from config-file
			{
				// the actual request can not be handled by the bibtex-parser, so forward request to corsuccessor.
				corSuccessor.handleRequest(httpRequest);
				return;
			}

			// Path to the requestedFile:
			string completePath = requestProcessorTools.BuildCompletePath(httpRequest.RequestedDirectoryName);
			if(!Directory.Exists(completePath))
			{	
				corSuccessor.handleRequest(httpRequest);
				return;
			}

			// The filename effectively requested by the client.
			// E. g. if only a directoy is specified this is the default filename:
			if(!File.Exists(completePath + httpRequest.RequestedFileName))
			{	
				corSuccessor.handleRequest(httpRequest);
				return;
			}

			webserverMonitor.WriteLogEntry("Full filename and path effectively requested: " + completePath + httpRequest.RequestedFileName);





		
			IBibTeXFactory parserFactory = BibTeX.Parser.FactoryBuilder.CreateBibTeXFactory();	

			parserFactory.CreateBibTeXFileFromLocalFile(completePath + httpRequest.RequestedFileName);

			
			webserverMonitor.WriteDebugMessage(parserFactory.StreamID, 1);

			//BibTeX.

			//requestProcessorTools.

			IBibTeXFormater bibTeXformater = BibTeX.Formater.FormaterFactory.GetASCIIFormater();
			
			

			//bibTeXformater.Options







			string responseString = "HHAHAD";

			requestProcessorTools.SendHTTPHeader(httpRequest.HttpVersion, requestProcessorTools.GetFileMimeTypeFor(httpRequest.RequestedFileType), responseString.Length, "200 OK", httpRequest.Socket);
			requestProcessorTools.SendContentToClient(responseString, httpRequest.Socket);
			webserverMonitor.WriteLogEntry("Successfully sent response to client.");

		}
	}
}
