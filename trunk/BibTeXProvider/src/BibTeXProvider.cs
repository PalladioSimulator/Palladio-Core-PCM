using System;
using System.Collections;
using System.Data;
using System.Data.SqlClient;
using System.IO;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Web;
using Altova.Xml;
using BibTeX.Formater.Interfaces;
using BibTeXProviderXML;
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
	/// The BibTeXProvider produces XHTML-tables to represent the search results, that fit to the specified search-terms.
	/// Search-expression have to be sent using the http-post-method. Only BibTeX-FieldNames that are specified in the
	/// xml-configuration-files are considered. For further configuration options refer to the BibTeXProviderXML.xml-file.
	/// </summary>
	/// 
	/// <remarks>
	/// Please pay attention that there may occur problems concering the sockets used to handle the
	/// http-request. If you use a lot of string-concatenation (like string += "abc";) the socket-connection might be
	/// closed. As the error can be reproduced this seems to be a bug of the .NET-Framework (Version 1.1, November 2004).
	/// The error could be identified to be indepentend from any kinds of time-outs. Even putting the thread sleeping for 
	/// 5 seconds doesn't produce the same error.
	/// Currently this behaviour does not seem to be deterministically.
	/// 
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/12/15 00:32:33  sliver
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
	/// Revision 1.4  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.3  2004/12/03 11:09:32  kelsaka
	/// The BibTeXProvider now reads its configuration from a xml-file; fixed sql-search-error in the BibTeXProvider; added documentation especially about a strange behaviour of the socket-connection  in the BibTeXProvider;
	///
	/// Revision 1.2  2004/11/28 19:01:32  kelsaka
	/// Added simple support for searching on a database, that contains BibTeX-Entries, added test-documents, added DB-test-content, added comments
	///
	/// Revision 1.1  2004/11/21 17:10:04  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	///
	/// </pre>
	/// </remarks>
	public class BibTeXProvider : IHTTPRequestProcessor
	{
		/// <summary>
		/// Xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "BibTeXProviderXML.xml";

		private IWebserverConfiguration webserverConfiguration;
		private IWebserverMonitor webserverMonitor;
		private IHTTPRequestProcessor corSuccessor;
		private IHTTPRequestProcessorTools requestProcessorTools;
		private BibTeXProviderConfiguration bibTeXProviderConfiguration;
		private IBibTexDB bibTexDB;

		public BibTeXProvider(IBibTexDB bibTexDB, IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools )
		{
			this.corSuccessor = corSuccessor;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.requestProcessorTools = requestProcessorTools;
			this.bibTexDB = bibTexDB;

			this.bibTeXProviderConfiguration = readConfiguration();
		}


		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void HandleRequest (IHTTPRequest httpRequest)
		{
			ArrayList HandledFileExtensionsList = new ArrayList(bibTeXProviderConfiguration.HandledFileExtensions);
			
			//decide whether the actual request is of interest for BibTeX-Component.
			if(!HandledFileExtensionsList.Contains(httpRequest.RequestedFileType)) //from config-file
			{
				// the actual request can not be handled by the bibtex-parser, so forward request to corsuccessor.
				corSuccessor.HandleRequest(httpRequest);
				return;
			}


			// Necessary use of the StringBuilder, as the simple string causes the Socket to abort the connection.
			// Probably this behaviour is not caused by a timeout, but by the frequent use of string-concatenation (=+).
			StringBuilder responseString = new StringBuilder();

			try{
				bibTexDB.ConnectionString = 
					"integrated security=SSPI;data source=" + bibTeXProviderConfiguration.DataSource + ";" + 
					"persist security info=False;initial catalog=" + bibTeXProviderConfiguration.DatabaseName;
				if(httpRequest.GetPOSTVariableValue("showEntry") == "all")
				{
					// Case: display all entries
					responseString = bibTexDB.AllEntries(bibTeXProviderConfiguration.DatabaseTableName);
				}
				else
				{	
					// Case: only return the entries that match to the search
					responseString = bibTexDB.Search(bibTeXProviderConfiguration.DatabaseTableName, httpRequest, bibTeXProviderConfiguration.SearchedBibTeXFieldNames);
				}

				requestProcessorTools.SendHTTPHeader(httpRequest.HttpVersion, requestProcessorTools.GetFileMimeTypeFor(httpRequest.RequestedFileType), responseString.Length, "200 OK", httpRequest.Socket);
				requestProcessorTools.SendContentToClient(responseString.ToString(), httpRequest.Socket);
				webserverMonitor.WriteLogEntry("Successfully sent response to client.");
			}
			catch (Exception ex)
			{
				webserverMonitor.WriteDebugMessage("Failed to connect to data source " + ex.ToString() + "\n" + ex.StackTrace, 1);
				
				// Send error message to client: server not avaiable:
				responseString.Append(bibTeXProviderConfiguration.ErrorMessageOnConnectionProblems);
				responseString.Append(" (Servername: " + bibTeXProviderConfiguration.DataSource + ")");
				requestProcessorTools.SendHTTPHeader(httpRequest.HttpVersion, requestProcessorTools.GetFileMimeTypeFor(httpRequest.RequestedFileType), responseString.Length, "200 OK", httpRequest.Socket);
				requestProcessorTools.SendContentToClient(responseString.ToString(), httpRequest.Socket);
			}
		}


		/// <summary>
		/// Creates a partial WHERE-statement, if the given key has a value != "" in the httpRequest (POST).
		/// </summary>
		/// <param name="httpRequest">Request that contains the variables to consider.</param>
		/// <param name="keys">The key to search for in the request.</param>
		/// <returns>A pair like "author = 'Shakespeare'".</returns>
		private StringBuilder BuildWhereClause (IHTTPRequest httpRequest, string[] keys)
		{
			StringBuilder sqlRequest = new StringBuilder();
			bool first = true;
			foreach(string key in keys)
			{
				string value = httpRequest.GetPOSTVariableValue(key);
				// unescape value-chars from URI-Encoding using the default representation.
				// e. g. a whitespace is encoded by "+" or a linebreak by "%0A".
				Encoding encoding = Encoding.Default;
				value = HttpUtility.UrlDecode(value, encoding);

				// convert SQL-Escape-Characters:
				value = value.Replace("\"", "\\\""); //  " to \"
				value = value.Replace("\'", "\\\'"); //  ' to \'


				if(value != "")
				{
					if(first)
					{
						// only create where clause if value are != "" and only at the beginning.
						sqlRequest.Append("WHERE ");
					}
					if(!first)
					{
						sqlRequest.Append(" AND ");
					}
					sqlRequest.Append(key + " LIKE '" + value + "'");
					first = false;
				}
			}
			return sqlRequest;
		}


		/// <summary>
		/// Reads the configuration at the specified path and creates a BibTeXProviderConfiguration out of the
		/// information read.
		/// </summary>
		/// <returns></returns>
		private BibTeXProviderConfiguration readConfiguration ()
		{
			BibTeXProviderXMLDoc doc = new BibTeXProviderXMLDoc();
			doc.SetRootElementName("", "Config");

			ConfigType root = new ConfigType();

			try 
			{
				root = new ConfigType(doc.Load(webserverConfiguration.ConfigFilesPath + DEFAULT_XML_CONFIGURATION_FILE));
			}
			catch (FileNotFoundException e)
			{
				webserverMonitor.WriteDebugMessage(e.ToString(), 1);
			}
			catch (XmlException e)
			{
				webserverMonitor.WriteDebugMessage(e.ToString(), 1);
			}

			return new BibTeXProviderConfiguration(root);
		}


	}
}
