using System;
using System.Collections;
using System.Data;
using MySql.Data.MySqlClient;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für Buffer.
	/// </summary>
	public class BufferingDBAdapter : IAudioDB
	{
		protected String connectionString;
		protected ArrayList audioFileInfoTableContent;
		protected ArrayList audioFileContents;
		
		public BufferingDBAdapter()
		{
			this.connectionString = DBConfig.GetConnectionString();
			this.audioFileInfoTableContent = new ArrayList();
			this.audioFileContents = new ArrayList();
		}
		#region IAudioDB Member
        
		public int InsertAudioFile(byte[] fileContent)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioFile"));

			// store file content locally
			this.audioFileContents.Add(fileContent);
			
			CallLogger.OnReturn();
			return 0;		
		}

		public void InsertAudioInfo(int fileID, string fileName, int fileSize)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioInfo"));
			AudioFileInfo item = new AudioFileInfo();
			item.fileID = fileID;
			item.fileName = fileName;
			item.fileSize = fileSize;
			this.audioFileInfoTableContent.Add(item);
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
				CallLogger.OnCall("IConnection", connection.GetType().GetMethod("Open"));
				connection.Open();
				CallLogger.OnReturn();

				CallLogger.OnCall("ICommand", cmd1.GetType().GetMethod("ExecuteReader",new Type[0]));
				dataReader = cmd1.ExecuteReader();
				CallLogger.OnReturn();
				
				CallLogger.OnCall("IDataReader", dataReader.GetType().GetMethod("Read"));
				while (dataReader.Read()) 
				{
					vals[0] = dataReader.GetInt32(0);
					vals[1] = dataReader.GetString(1);
					vals[2] = dataReader.GetInt32(2);
					t.Rows.Add(vals);
				}
				CallLogger.OnReturn();
			}
			catch(Exception e)
			{
				String blah = e.Message;
				// TODO
			}
			finally 
			{
				CallLogger.OnCall("IDataReader", dataReader.GetType().GetMethod("Close"));
				dataReader.Close();
				CallLogger.OnReturn();	
				
				CallLogger.OnCall("IConnection", connection.GetType().GetMethod("Close"));
				connection.Close();
				CallLogger.OnReturn();
			}
			CallLogger.OnReturn();
			return dataSet;
		}

		public void FinalizeUpload()
		{
			byte[] dummy = new byte[100];
			
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("FinalizeUpload"));
			MySqlConnection connection = new MySqlConnection(this.connectionString);			
			MySqlDataReader dataReader = null;
			int fileID = -42;
	
			String insertAudioFiles="INSERT INTO AudioFiles VALUES(null, ?File)";
			MySqlCommand cmd1 = new MySqlCommand(insertAudioFiles);
			cmd1.Connection = connection;
	
			// The primary-key of table 'AudioFiles' is generated via auto-increment by MySQL.
			// Thus we have to get this key, before we can insert a row into table
			// 'AudioFileInfo' which has 'AudioFiles's primary-key as a foreign key:
			String selectMaxId="SELECT MAX(audioFileID) FROM AudioFiles";
			MySqlCommand cmd2 = new MySqlCommand(selectMaxId);
			cmd2.Connection = connection;

			String insertAudioFileInfo="INSERT INTO AudioFileInfo VALUES(null, ?FileName, ?FileSize, ?AudioFileId)";
			MySqlCommand cmd3 = new MySqlCommand(insertAudioFileInfo);
			cmd3.Connection = connection;

			IEnumerator enumInfo = audioFileInfoTableContent.GetEnumerator();
			
			try
			{
				CallLogger.OnCall("IConnection", connection.GetType().GetMethod("Open"));
				connection.Open();
				CallLogger.OnReturn();

				CallLogger.OnCall("ICommand", cmd2.GetType().GetMethod("ExecuteReader",new Type[0]));
				dataReader = cmd2.ExecuteReader(); // SELECT maxID from AudioFiles
				CallLogger.OnReturn();
				
				CallLogger.OnCall("IDataReader", dataReader.GetType().GetMethod("Read"));
				dataReader.Read();
				CallLogger.OnReturn();


				fileID = dataReader.GetInt32(0);
				CallLogger.OnCall("IDataReader", dataReader.GetType().GetMethod("Close"));
				dataReader.Close();
				CallLogger.OnReturn();	

				foreach(byte[] fileContent in audioFileContents)
				{
					enumInfo.MoveNext(); // move to next audioFileInfo row
					


					cmd1.Parameters.Add("?File", dummy); // add BLOB to INSERT statement

					CallLogger.OnCall("ICommand", cmd1.GetType().GetMethod("ExecuteNonQuery"));
					cmd1.ExecuteNonQuery(); // INSERT into AudioFiles
					CallLogger.OnReturn(DBAdapter.BusyWaiting(fileContent.LongLength));

					AudioFileInfo afi = (AudioFileInfo)enumInfo.Current;
					cmd3.Parameters.Add("?FileName", afi.fileName);
					cmd3.Parameters.Add("?FileSize", afi.fileSize);
					// increment fileID manually (saves SQL-Query):
					cmd3.Parameters.Add("?AudioFileId", fileID++); 
					CallLogger.OnCall("ICommand", cmd3.GetType().GetMethod("ExecuteNonQuery"));
					cmd3.ExecuteNonQuery(); // INSERT into AudioFileInfo		
					CallLogger.OnReturn();
				}
			}
			catch(Exception e)
			{
				String blah = e.Message;
				// TODO
			}
			finally 
			{
				CallLogger.OnCall("IConnection", connection.GetType().GetMethod("Close"));
				connection.Close();
				CallLogger.OnReturn();
			}
			CallLogger.OnReturn();
		}

		#endregion
	}

	internal struct AudioFileInfo
	{
		public int fileID;
		public string fileName;
		public int fileSize;
	}	
}
