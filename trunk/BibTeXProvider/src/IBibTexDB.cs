using System;
using System.Text;
using Palladio.Webserver.Request;

namespace Palladio.Webserver.BibTeXProvider
{
	/// <summary>
	/// Wrapper for calls to the BibTex DB. This was introduced to be able 
	/// to intercept calls to the DB and measure their performance and realiability.
	/// </summary>
	public interface IBibTexDB
	{
		/// <summary>
		/// Connection string used for the retrieval of the BibTex Entries.
		/// </summary>
		string ConnectionString { set; get; }

		/// <summary>
		/// All bibTeXFieldNames that occur in the post-request and have values != "" are taken into consideration for
		/// creating the resultset. The values are matched using the SQL-"LIKE"-Operator.
		/// </summary>
		/// <param name="bibTeXTableName">The name of the sql-table where the results are searched in.</param>
		/// <param name="httpRequest">The incoming httpRequest.</param>
		/// <param name="bibTeXFieldNames">The Field-Names, that are searched to match the post-values.</param>
		/// <returns>String that contains the result: html-table.</returns>
		StringBuilder Search( string bibTeXTableName, IHTTPRequest httpRequest, string[] bibTeXFieldNames);

		/// <summary>
		/// Returns all Entries from the Database.
		/// </summary>
		/// <param name="bibTeXTableName">Table-name of the sql-table.</param>
		/// <returns>String that contains the result: html-table.</returns>
		StringBuilder SearchAllEntries(string bibTeXTableName);
	}
}
