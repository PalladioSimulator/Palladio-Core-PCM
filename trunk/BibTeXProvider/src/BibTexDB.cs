using System;
using System.Data.SqlClient;
using System.Text;
using System.Web;
using Palladio.Webserver.Request;

namespace Palladio.Webserver.BibTeXProvider
{
	/// <summary>
	/// BibTexDB. Executes SQL-Queries on a database to search for BibTeX-Entries. This includes the ability to 
	/// create a html-table that contains the results.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/12/18 10:06:48  kelsaka
	/// Added CVS-logs and some comments.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class BibTexDB : IBibTexDB
	{
		private string connectionString;

		public BibTexDB(string connectionString)
		{
			this.connectionString = connectionString;
		}

		public string ConnectionString
		{
			set { connectionString = value; }
			get { return connectionString; }
		}

		/// <summary>
		/// All bibTeXFieldNames that occur in the post-request and have values != "" are taken into consideration for
		/// creating the resultset. The values are matched using the SQL-"LIKE"-Operator.
		/// </summary>
		/// <param name="bibTeXTableName">The name of the sql-table where the results are searched in.</param>
		/// <param name="httpRequest">The incoming httpRequest.</param>
		/// <param name="bibTeXFieldNames">The Field-Names, that are searched to match the post-values.</param>
		/// <returns>String that contains the result: html-table.</returns>
		public StringBuilder Search(string bibTeXTableName, IHTTPRequest httpRequest, string[] bibTeXFieldNames)
		{
			SqlConnection connection = new SqlConnection(connectionString);
			StringBuilder responseString = new StringBuilder();
			SqlDataReader sqlDataReader = null;

			try
			{
				connection.Open();

				StringBuilder sqlRequest = new StringBuilder();
				sqlRequest.Append("SELECT * FROM " + bibTeXTableName + " ");

				sqlRequest.Append(BuildWhereClause (httpRequest, bibTeXFieldNames)); 

				sqlRequest.Append(";");


				SqlCommand sqlCommand = new SqlCommand(sqlRequest.ToString(), connection);		
				sqlDataReader = sqlCommand.ExecuteReader();

				responseString.Append(CreateHTMLDataTableFromResult(sqlDataReader));

				sqlDataReader.Close();
			}
			finally 
			{
				sqlDataReader.Close();
				connection.Close();
			}
			return responseString;
		}

		/// <summary>
		/// Returns all Entries from the Database.
		/// </summary>
		/// <param name="bibTeXTableName">Table-name of the sql-table.</param>
		/// <returns>String that contains the result: html-table.</returns>
		public StringBuilder SearchAllEntries(string bibTeXTableName)
		{
			SqlConnection connection = new SqlConnection(connectionString);
			StringBuilder responseString = new StringBuilder();
			SqlDataReader sqlDataReader = null;

			try
			{
				connection.Open();				
				SqlCommand sqlCommand = new SqlCommand("SELECT * FROM " + bibTeXTableName + ";", connection);		
				sqlDataReader = sqlCommand.ExecuteReader();
	
				responseString.Append(CreateHTMLDataTableFromResult(sqlDataReader));
			}
			finally
			{
				sqlDataReader.Close();
				connection.Close();
			}
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

	}
}
