using System;
using System.Collections;
using System.Data.SqlClient;
using System.Text;
using System.IO;
using System.Data;

namespace DBAcesses
{
	/// <summary>
	///This class controls the acess to the databse. It build the comands. And validate
	///rhe comands. It also interacts with the database. And proviedes the results of the database
	///querries.
	/// </summary>
	public class DBAcessComponent
	{
		DatabaseProperties proberties;
		ValidateDBComands sqlValidator;


		/// <summary>
		/// Initiates a new DBAcessComponents.
		/// </summary>
		public DBAcessComponent()
		{
			this.proberties =new DatabaseProperties();
			this.sqlValidator = new ValidateDBComands(this.proberties);
		}

		

		/// <summary>
		/// Inserts a row to the database.
		/// </summary>
		/// <param name="tablename">The name of the table, in which this row should be added</param>
		/// <param name="fieldsToModify">A Hashtable which contains as key the colum name, and as key
		/// the values which should be stroted under this colum name,</param>
		/// <param name="username">The name of the user, which would like to manipulate the database. 
		/// This features has not been implemented yet.</param>
		/// <param name="passwort">The password for the database connection. This ferature has not been implemented yet.</param>
		public void InsertRow(string tablename, Hashtable fieldsToModify, string username, string passwort)
		{
			try
			{
				if(!this.sqlValidator.ValidateTable(tablename,fieldsToModify))
				{
					throw new Exception("Tablename or a Field is not valid");
				}
				DatabaseTable currentTable = this.proberties.GetAssociatedTable(tablename);
				SqlConnection conn = new SqlConnection(@"Data Source="+this.proberties.Database+"; Integrated Security=SSPI;" 	+
					"Initial Catalog=Webserver");
				conn.Open();
				if(NotInDatabase(tablename,conn,fieldsToModify))
				{
					Console.WriteLine("Not in database yet.");
					string inseryString = this.sqlValidator.OrderEntries(fieldsToModify,currentTable);
					inseryString ="insert into "+tablename+" values ("+inseryString+")";
					SqlCommand insert2 = new SqlCommand(inseryString,conn);
					insert2.ExecuteNonQuery();
					conn.Close();
				}
				else
				{
					conn.Close();
					Console.WriteLine("Already in database. ");
				}
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
		}

		/// <summary>
		/// Implements a Select Statement for the search in the database.
		/// </summary>
		/// <param name="tablename">The name of the to sarch in</param>
		/// <param name="entriesAndSearchpattern">A Hashtable contains as key: the colum
		/// names to be searched in. Key the valu to search for.</param>
		/// <returns>The result stored in a <c>DataSet</c></returns>
		public DataSet SearchForRows(string tablename, Hashtable entriesAndSearchpattern)
		{
			try
			{
				if(!this.sqlValidator.ValidateTable(tablename,entriesAndSearchpattern))
				{
					throw new Exception("Tablename or a Field is not valid");
				}
				DatabaseTable currentTable = this.proberties.GetAssociatedTable(tablename);
				SqlConnection conn = new SqlConnection(@"Data Source="+this.proberties.Database+"; Integrated Security=SSPI;" 	+
					"Initial Catalog=Webserver");
				conn.Open();
				string likeStatement = BuildLikeStatement(entriesAndSearchpattern);
				string sqlLike = "SELECT * FROM "+tablename+" WHERE "+likeStatement;
				StreamWriter da = new StreamWriter("test.txt");
				da.WriteLine(sqlLike);
				da.Close();
				Console.WriteLine(sqlLike);
				DataSet test =new DataSet();
				SqlDataAdapter adapter = new SqlDataAdapter();
				adapter.SelectCommand = new SqlCommand(sqlLike, conn);
				adapter.Fill(test);
				conn.Close();
				return test;
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
			throw new Exception("search in Database was not successful ");
		}

		/// <summary>
		/// Implements a LIKE Statement for the search in the database.
		/// </summary>
		/// <param name="tablename">The name of the to sarch in</param>
		/// <param name="entriesAndSearchpattern">A Hashtable contains as key: the colum
		/// names to be searched in. Key the valu to search for.</param>
		/// <returns>The result stored in a <c>DataSet</c></returns>
		public DataSet SearchDirektForRows(string tablename, Hashtable entriesAndSearchpattern)
		{
			try
			{
				if(!this.sqlValidator.ValidateTable(tablename,entriesAndSearchpattern))
				{
					throw new Exception("Tablename or a Field is not valid");
				}
				DatabaseTable currentTable = this.proberties.GetAssociatedTable(tablename);
				SqlConnection conn = new SqlConnection(@"Data Source="+this.proberties.Database+"; Integrated Security=SSPI;" 	+
					"Initial Catalog=Webserver");
				conn.Open();
				// SELECT * FROM t_kunden WHERE ( vorname LIKE "M%" ) OR ( vorname LIKE "N%")
				string equalsStatement = BuildEqualsStatement(entriesAndSearchpattern);
				string sqlEqual = "SELECT * FROM "+tablename+" WHERE "+equalsStatement;
				Console.WriteLine(sqlEqual);
				DataSet test =new DataSet();
				//				SqlCommand comand = new SqlCommand(sqlLike,conn);
				SqlDataAdapter adapter = new SqlDataAdapter();
				adapter.SelectCommand = new SqlCommand(sqlEqual, conn);
				//				adapter.SelectCommand =
				adapter.Fill(test);
			
				conn.Close();
				return test;
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
			throw new Exception("search in Database was not successful ");
		}

		/// <summary>
		/// Delates a Row in the Database. It was only iplemented for debugging.
		/// </summary>
		public void DeleteRow()
		{
			SqlConnection conn = new SqlConnection(@"Data Source="+this.proberties.Database+"; Integrated Security=SSPI;" 	+
				"Initial Catalog=Webserver");
			conn.Open();
			string sqlStatment = "DELETE FROM Bibtex WHERE title='Das neue Leben' AND author='Max Müller'";
			SqlCommand cmd = new SqlCommand(sqlStatment,conn);
			cmd.ExecuteNonQuery();
			conn.Close();
		}


		/// <summary>
		/// Builds a SQL Like Statement.
		/// </summary>
		/// <param name="dada">The Hashtable which contains the searchdata</param>
		/// <returns>The Hashtable formated as an SQL Like Statement.</returns>
		internal string BuildLikeStatement(Hashtable dada)
		{
			string result="";
			foreach(DictionaryEntry de in dada)
			{
				result += "( "+de.Key.ToString()+" LIKE '%"+de.Value.ToString()+"%') AND ";
			}
			result = result.Remove(result.Length-4,3);
			Console.WriteLine("Like Querry: "+result);
			return result;
		}


		/// <summary>
		/// Builds a SQL EQUALS Statement.
		/// </summary>
		/// <param name="dada">The Hashtable which contains the searchdata</param>
		/// <returns>The Hashtable formated as an SQL EQUALS Statement.</returns>
		internal string BuildEqualsStatement(Hashtable dada)
		{
			string result="";
			foreach(DictionaryEntry de in dada)
			{
				result += "( "+de.Key.ToString()+" = '"+de.Value.ToString()+"') AND ";
			}
			result = result.Remove(result.Length-4,3);
			Console.WriteLine("Like Querry: "+result);

			return result;
		}

		/// <summary>
		/// Checks if an Entry is already in the database.
		/// </summary>
		/// <param name="tablename">The name of the table to be checked.</param>
		/// <param name="conn">The SQL connection to use</param>
		/// <param name="fieldsToModify">The fields to be checked.</param>
		/// <returns>True if is entry is already in the database, false if not.</returns>
		internal bool NotInDatabase(string tablename, SqlConnection conn,Hashtable fieldsToModify)
		{
			string compareString = "SELECT * FROM "+tablename+" WHERE "+BuildConacatination(fieldsToModify);
			SqlCommand compare = new SqlCommand(compareString,conn);
			SqlDataReader test = compare.ExecuteReader();
			if(!test.HasRows)
			{
				test.Close();
				return true;
			}
			return false;
		}



		/// <summary>
		/// Bulid an SQL COMPARE Statement.
		/// </summary>
		/// <param name="con">The Hashable to be checked.</param>
		/// <returns>The generated statement.</returns>
		internal string BuildConacatination(Hashtable con)
		{
			string result="";
			foreach(DictionaryEntry de in con)
			{
				result += " "+de.Key.ToString()+"='"+de.Value.ToString()+"'AND";
			}
			result += result.TrimEnd();
			result = result.Remove(result.Length-3,3);
			Console.WriteLine("Compare Statement: "+result+"+++++");
			return result;
		}


		/// <summary>
		/// Performs an SQL UPDATE Statement.
		/// </summary>
		/// <param name="tablename">The name of the database.</param>
		/// <param name="fieldsToModify">Contains the colums to update.</param>
		/// <param name="conditions">The Conciton under which a row should be manipulates.</param>
		public void UpdateTable(string tablename, Hashtable fieldsToModify, string conditions)
		{
			try
			{
				if(!this.sqlValidator.ValidateTable(tablename,fieldsToModify))
				{
					throw new Exception("Tablename or a Field is not valid");
				}
				DatabaseTable currentTable = this.proberties.GetAssociatedTable(tablename);
				SqlConnection conn = new SqlConnection(@"Data Source="+this.proberties.Database+"; Integrated Security=SSPI;" 	+
					"Initial Catalog=Webserver");
				
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
		}
	}
}
