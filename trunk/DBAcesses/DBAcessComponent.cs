using System;
using System.Collections;
using System.Data.SqlClient;
using System.Text;
using System.IO;
using System.Data;

namespace DBAcesses
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class DBAcessComponent
	{
		DatabaseProperties proberties;
		ValidateDBComands sqlValidator;
		public DBAcessComponent()
		{
			this.proberties =new DatabaseProperties();
			this.sqlValidator = new ValidateDBComands(this.proberties);
		}

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
					Console.WriteLine("Noch nicht in der Datenbank ");
					string inseryString = this.sqlValidator.OrderEntries(fieldsToModify,currentTable);
					inseryString ="insert into "+tablename+" values ("+inseryString+")";
					SqlCommand insert2 = new SqlCommand(inseryString,conn);
					insert2.ExecuteNonQuery();
					conn.Close();
				}
				else
				{
					conn.Close();
					Console.WriteLine("EIntrag schon in Datenbank ");
				}
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
		}

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
				// SELECT * FROM t_kunden WHERE ( vorname LIKE "M%" ) OR ( vorname LIKE "N%")
				string likeStatement = BuildLikeStatement(entriesAndSearchpattern);
				string sqlLike = "SELECT * FROM "+tablename+" WHERE "+likeStatement;
				StreamWriter da = new StreamWriter("test.txt");
				da.WriteLine(sqlLike);
				da.Close();
				Console.WriteLine(sqlLike);
				DataSet test =new DataSet();
				//				SqlCommand comand = new SqlCommand(sqlLike,conn);
				SqlDataAdapter adapter = new SqlDataAdapter();
				adapter.SelectCommand = new SqlCommand(sqlLike, conn);
//				adapter.SelectCommand =
				adapter.Fill(test);
				//				DataTableCollection tablle = test.Tables;
				//				foreach(DataTable myTable in test.Tables)
				//				{
				//					foreach(DataRow myRow in myTable.Rows)
				//					{
				//						foreach (DataColumn myColumn in myTable.Columns)
				//						{
				//							if(myRow[myColumn].ToString() !="")
				//							Console.WriteLine(myRow[myColumn].ToString().TrimEnd());
				//						}
				//					}
				//				}
	
				//				while(tablle.
				//				return dataset;
				//
				//				SqlDataReader reader = comand.ExecuteReader();
				//				ArrayList result = new ArrayList();
				//				while(reader.Read())
				//				{
				////					result.Add(reader.);
				////					DataSet ds = new DataSet();
				////					ds.f
				//					Console.WriteLine("Ist was drin");
				//					//reader.Read();
				////					for(int i=0; i< reader.FieldCount ; i++)
				//					Console.WriteLine(reader.GetString(11).Trim());
				//					Console.WriteLine(reader.GetString(12).Trim());
				//
				//				}
				conn.Close();
				return test;
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
			throw new Exception("searxh in Database was not successful ");
		}

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
				//				DataTableCollection tablle = test.Tables;
				//				foreach(DataTable myTable in test.Tables)
				//				{
				//					foreach(DataRow myRow in myTable.Rows)
				//					{
				//						foreach (DataColumn myColumn in myTable.Columns)
				//						{
				//							if(myRow[myColumn].ToString() !="")
				//							Console.WriteLine(myRow[myColumn].ToString().TrimEnd());
				//						}
				//					}
				//				}
	
				//				while(tablle.
				//				return dataset;
				//
				//				SqlDataReader reader = comand.ExecuteReader();
				//				ArrayList result = new ArrayList();
				//				while(reader.Read())
				//				{
				////					result.Add(reader.);
				////					DataSet ds = new DataSet();
				////					ds.f
				//					Console.WriteLine("Ist was drin");
				//					//reader.Read();
				////					for(int i=0; i< reader.FieldCount ; i++)
				//					Console.WriteLine(reader.GetString(11).Trim());
				//					Console.WriteLine(reader.GetString(12).Trim());
				//
				//				}
				conn.Close();
				return test;
			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
			}
			throw new Exception("searxh in Database was not successful ");
		}

		public void DeleteRow()
		{
//			DatabaseTable currentTable = this.proberties.GetAssociatedTable(tablename);
			SqlConnection conn = new SqlConnection(@"Data Source="+this.proberties.Database+"; Integrated Security=SSPI;" 	+
				"Initial Catalog=Webserver");
			conn.Open();
			string sqlStatment = "DELETE FROM Bibtex WHERE title='Das neue Leben' AND author='Max Müller'";
			SqlCommand cmd = new SqlCommand(sqlStatment,conn);
			cmd.ExecuteNonQuery();
			conn.Close();


		}
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
