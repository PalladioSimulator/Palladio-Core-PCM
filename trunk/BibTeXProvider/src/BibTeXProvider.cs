using System;
using System.Data;
using System.Data.SqlClient;
using System.IO;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Web;
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
	/// BibTeXProvider. UNDER CONSTRUCTION!
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
			string dataSource = "KUSER_MOBILE";
			string databaseName = "BibTeX";
			string bibTeXTableName = "BibTeX";
			string[] bibTeXFieldNames = {"author", "title", "publisher", "year"};

			//decide whether the actual request is of interest for BibTeX-Component.
			if(httpRequest.RequestedFileType != ".bibhtml") //TODO: read from config-file
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
				"integrated security=SSPI;data source=" + dataSource + ";" + 
				"persist security info=False;initial catalog=" + databaseName;
			try
			{	
				sqlConnection.Open();

				if(httpRequest.GetPOSTVariableValue("showEntry") == "all")
				{
					responseString = SearchAllEntries(sqlConnection, bibTeXTableName);
				}
				else
				{
					responseString = SearchEntries(sqlConnection, bibTeXTableName, httpRequest, bibTeXFieldNames);
				}
			}
			catch (Exception ex)
			{
				webserverMonitor.WriteDebugMessage("Failed to connect to data source " + ex.ToString() + "\n" + ex.StackTrace, 1);
			}
			finally
			{
				sqlConnection.Close();
			}


			requestProcessorTools.SendHTTPHeader(httpRequest.HttpVersion, requestProcessorTools.GetFileMimeTypeFor(httpRequest.RequestedFileType), responseString.Length, "200 OK", httpRequest.Socket);
			requestProcessorTools.SendContentToClient(responseString.ToString(), httpRequest.Socket);
			webserverMonitor.WriteLogEntry("Successfully sent response to client.");
		}



		private StringBuilder SearchEntries (SqlConnection sqlConnection, string bibTeXTableName, IHTTPRequest httpRequest, string[] bibTeXFieldNames)
		{
			StringBuilder responseString = new StringBuilder();
			string sqlRequest = "SELECT * FROM " + bibTeXTableName + " WHERE";

			sqlRequest += BuildWhereClause (httpRequest, bibTeXFieldNames); 

			sqlRequest += ";";

			Console.WriteLine("sqlR" + sqlRequest);


			SqlCommand sqlCommand = new SqlCommand(sqlRequest, sqlConnection);		
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
		/// the column-names as table-headings).
		/// </summary>
		/// <param name="sqlDataReader"></param>
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
		private string BuildWhereClause (IHTTPRequest httpRequest, string[] keys)
		{
			string sqlRequest = " ";
			bool first = true;
			foreach(string key in keys)
			{

				string keyx = httpRequest.GetPOSTVariableValue(key);
				// unescape value-chars from URI-Encoding using the default representation.
				// e. g. a whitespace is encoded by "+" or a linebreak by "%0A".
				Encoding encoding = Encoding.Default;
				keyx = HttpUtility.UrlDecode(keyx, encoding);

				// convert SQL-Escape-Characters:
				keyx = keyx.Replace("\"", "\\\"");
				keyx = keyx.Replace("\'", "\\\'");



				if(keyx != "")
				{
					if(!first)
					{
						sqlRequest += " AND ";
					}
					sqlRequest += key + " LIKE '" + keyx + "'";
					first = false;
				}
			}
			return sqlRequest;
		}





	}
}
