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

		public BibTeXProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.corSuccessor = corSuccessor;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.requestProcessorTools = new DefaultHTTPRequestProcessorTools(webserverMonitor, webserverConfiguration);

			this.bibTeXProviderConfiguration = readConfiguration();
		}


		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void handleRequest (IHTTPRequest httpRequest)
		{
			ArrayList HandledFileExtensionsList = new ArrayList(bibTeXProviderConfiguration.HandledFileExtensions);
			
			//decide whether the actual request is of interest for BibTeX-Component.
			if(!HandledFileExtensionsList.Contains(httpRequest.RequestedFileType)) //from config-file
			{
				// the actual request can not be handled by the bibtex-parser, so forward request to corsuccessor.
				corSuccessor.handleRequest(httpRequest);
				return;
			}


			// Necessary use of the StringBuilder, as the simple string causes the Socket to abort the connection.
			// Probably this behaviour is not caused by a timeout, but by the frequent use of string-concatenation (=+).
			StringBuilder responseString = new StringBuilder();

			System.Data.SqlClient.SqlConnection sqlConnection = new System.Data.SqlClient.SqlConnection ();
			sqlConnection.ConnectionString = 
				"integrated security=SSPI;data source=" + bibTeXProviderConfiguration.DataSource + ";" + 
				"persist security info=False;initial catalog=" + bibTeXProviderConfiguration.DatabaseName;
			try
			{	
				sqlConnection.Open();

				if(httpRequest.GetPOSTVariableValue("showEntry") == "all")
				{
					// Case: display all entries
					responseString = SearchAllEntries(sqlConnection, bibTeXProviderConfiguration.DatabaseTableName);
				}
				else
				{	
					// Case: only return the entries that match to the search
					responseString = SearchEntries(sqlConnection, bibTeXProviderConfiguration.DatabaseTableName, httpRequest, bibTeXProviderConfiguration.SearchedBibTeXFieldNames);
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
			finally
			{
				sqlConnection.Close();
			}
		}


		/// <summary>
		/// All bibTeXFieldNames that occur in the post-request and have values != "" are taken into consideration for
		/// creating the resultset. The values are matched using the SQL-"LIKE"-Operator.
		/// </summary>
		/// <param name="sqlConnection">Connection to execute the sqlCommands on.</param>
		/// <param name="bibTeXTableName">The name of the sql-table where the results are searched in.</param>
		/// <param name="httpRequest">The incoming httpRequest.</param>
		/// <param name="bibTeXFieldNames">The Field-Names, that are searched to match the post-values.</param>
		/// <returns>String that contains the result: html-table.</returns>
		private StringBuilder SearchEntries (SqlConnection sqlConnection, string bibTeXTableName, IHTTPRequest httpRequest, string[] bibTeXFieldNames)
		{
			StringBuilder responseString = new StringBuilder();
			StringBuilder sqlRequest = new StringBuilder();
			sqlRequest.Append("SELECT * FROM " + bibTeXTableName + " ");

			sqlRequest.Append(BuildWhereClause (httpRequest, bibTeXFieldNames)); 

			sqlRequest.Append(";");


			SqlCommand sqlCommand = new SqlCommand(sqlRequest.ToString(), sqlConnection);		
			SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();

			responseString.Append(CreateHTMLDataTableFromResult(sqlDataReader));

			sqlDataReader.Close();
			return responseString;
		}


		/// <summary>
		/// Returns all Entries from the Database.
		/// </summary>
		/// <param name="sqlConnection">SQL-Connections to use for the request.</param>
		/// <param name="bibTeXTableName">Table-name of the sql-table.</param>
		/// <returns>String that contains the result: html-table.</returns>
		private StringBuilder SearchAllEntries (SqlConnection sqlConnection, string bibTeXTableName)
		{
			StringBuilder responseString = new StringBuilder();

			SqlCommand sqlCommand = new SqlCommand("SELECT * FROM " + bibTeXTableName + ";", sqlConnection);		
			SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
	
			responseString.Append(CreateHTMLDataTableFromResult(sqlDataReader));
			
			sqlDataReader.Close();
			return responseString;
		}

		/// <summary>
		/// Print a html-table to the responseString that contains all available values from the bibTeXTableName (including
		/// the column-names as table-headings). Use CSS to format the table.
		/// </summary>
		/// <param name="sqlDataReader">The DataReaders values are put into the table.</param>
		/// <returns>HTML-Table, that contains the available values. The table isrepresented in valid XHTML 1.0.</returns>
		private StringBuilder CreateHTMLDataTableFromResult (SqlDataReader sqlDataReader)
		{
			StringBuilder responseString = new StringBuilder();

			responseString.Append("<table>\n");
	
			// write Table-headings:
			responseString.Append("<tr>\n");
			for(int x = 0; x < sqlDataReader.FieldCount; x++)
			{
				responseString.Append("<td><strong>");
				responseString.Append(sqlDataReader.GetName(x));
				responseString.Append("</strong></td>");
			}
			responseString.Append("</tr>\n");
	
	
			// write content:
			while (sqlDataReader.Read()) 
			{
				responseString.Append("<tr>\n");
				for(int x = 0; x < sqlDataReader.FieldCount; x++)
				{	
					responseString.Append("<td>");
					responseString.Append(sqlDataReader.GetString(x));
					responseString.Append("</td>");
				}
				responseString.Append("</tr>\n");
			} 
	
			responseString.Append("</table>\n");
			
			return responseString;
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
