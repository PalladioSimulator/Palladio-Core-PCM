using System;
using System.Data;
using System.IO;
using System.Text;
using MySql.Data.MySqlClient;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für DBQueries.
	/// </summary>
	public class DBAdapter : IAudioDB
	{
		protected String connectionString;
		
		public DBAdapter()
		{
			this.connectionString = DBConfig.GetConnectionString();
		}

		public int InsertAudioFile(byte[] fileContent)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioFile"));

			MySqlConnection connection = new MySqlConnection(this.connectionString);			
			MySqlDataReader dataReader = null;
			int fileID = -42;

			String insertAudioFiles="INSERT INTO AudioFiles VALUES(null, ?File)";
			MySqlCommand cmd1 = new MySqlCommand(insertAudioFiles);
			cmd1.Parameters.Add("?File", fileContent); // add BLOB to INSERT statement
			cmd1.Connection = connection;

			// The primary-key of table 'AudioFiles' is generated via auto-increment by MySQL.
			// Thus we have to get this key, before we can insert a row into table
			// 'AudioFileInfo' which has 'AudioFiles's primary-key as a foreign key:
			String selectMaxId="SELECT MAX(audioFileID) FROM AudioFiles";
			MySqlCommand cmd2 = new MySqlCommand(selectMaxId);
			cmd2.Connection = connection;

			try
			{
				connection.Open();
				cmd1.ExecuteNonQuery(); // INSERT into AudioFiles
				
				dataReader = cmd2.ExecuteReader(); // SELECT maxID from AudioFiles
				dataReader.Read();
				
				fileID = dataReader.GetInt32(0);
				dataReader.Close();
			}
			catch(Exception e)
			{
				String blah = e.Message;
				// TODO
			}
			finally 
			{
				connection.Close();
			}
			
			CallLogger.OnReturn();
			
			return fileID;
		}

		public void InsertAudioInfo(int fileID, string fileName, int fileSize)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioInfo"));

			MySqlConnection connection = new MySqlConnection(this.connectionString);			
			StringBuilder insertAudioFileInfo = new StringBuilder();
			insertAudioFileInfo.Append("INSERT INTO AudioFileInfo VALUES(null, ");
			insertAudioFileInfo.Append("'"+Path.GetFileName(fileName)+"', "+fileSize+", ?AudioFileId)");
			MySqlCommand cmd3 = new MySqlCommand(insertAudioFileInfo.ToString());
			cmd3.Parameters.Add("?AudioFileId", fileID);				
			cmd3.Connection = connection;			
			try
			{
				connection.Open();
				cmd3.ExecuteNonQuery(); // INSERT into AudioFileInfo				
			}
			catch(Exception e)
			{
				string info = e.Message;
				Console.WriteLine(e);
				// TODO
			}
			finally 
			{
				connection.Close();
			}
			
			CallLogger.OnReturn();
		}


		public DataSet GetAudioFileInfo()
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("GetAudioFileInfo"));

			MySqlConnection connection = new MySqlConnection(this.connectionString);			
			MySqlDataReader dataReader = null;

			String selectAudioFileInfo = "SELECT * FROM AudioFileInfo;";
			MySqlCommand cmd1 = new MySqlCommand(selectAudioFileInfo);
			cmd1.Connection = connection;

			DataSet dataSet = new DataSet();
			DataTable t = new DataTable("ImageTable");
			t.Columns.Add("ID",typeof(int));
			t.Columns.Add("Name",typeof(string));
			t.Columns.Add("Size",typeof(int));
			dataSet.Tables.Add(t);
			object[] vals = new object[3];

			try
			{
				connection.Open();
				dataReader = cmd1.ExecuteReader();
				while (dataReader.Read()) 
				{
					vals[0] = dataReader.GetInt32(0);
					vals[1] = dataReader.GetString(1);
					vals[2] = dataReader.GetInt32(2);
					t.Rows.Add(vals);
				}
				dataReader.Close();
			}
			catch(Exception e)
			{
				// TODO
			}
			finally 
			{
				dataReader.Close();
				cmd1.Connection.Close();
			}
			CallLogger.OnReturn();
			return dataSet;
		}

	}
}
