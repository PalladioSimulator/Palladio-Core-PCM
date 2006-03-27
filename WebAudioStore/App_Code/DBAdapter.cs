using System;
using System.Data;
using System.IO;
using System.Text;
using System.Threading;
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

			String insertAudioFiles="INSERT INTO AudioFiles VALUES(1, ?File)";
			MySqlCommand cmd1 = new MySqlCommand(insertAudioFiles);
			cmd1.Parameters.Add("?File", fileContent); // add BLOB to INSERT statement
			cmd1.Connection = connection;

			// The primary-key of table 'AudioFiles' is generated via auto-increment by MySQL.
			// Thus we have to get this key, before we can insert a row into table
			// 'AudioFileInfo' which has 'AudioFiles's primary-key as a foreign key:
			String selectMaxId="SELECT MAX(audioFileID) FROM AudioFiles";
			MySqlCommand cmd2 = new MySqlCommand(selectMaxId);
			cmd2.Connection = connection;

            MySqlCommand cmd3 = new MySqlCommand("delete from AudioFiles where audioFileID=1");
            cmd3.Connection = connection;

			try
			{
				CallLogger.OnCall("IConnection", connection.GetType().GetMethod("Open"));
				connection.Open();
				CallLogger.OnReturn();
				
				CallLogger.OnCall("ICommand", cmd1.GetType().GetMethod("ExecuteNonQuery"));
                cmd3.ExecuteNonQuery(); // DELETE old audioFile
				cmd1.ExecuteNonQuery(); // INSERT into AudioFiles
				CallLogger.OnReturn(BusyWaiting(fileContent.LongLength));

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

				CallLogger.OnReturn();
			}
			return fileID;
		}

		public static ulong BusyWaiting(long fileSize)
		{
//			HiResTimer timer = new HiResTimer();
//			timer.Start();
			ulong sleepTime = (ulong)fileSize / 125  * 1000; // zeit die auf einer 1Mbit leitung in µs benötigt wird.
			sleepTime *= 2; // 512KBit
//			do // busy waiting, thread.sleep ist zu ungenau.
//			{
//				timer.Stop();
//			} while (timer.ElapsedMicroseconds < sleepTime);
			return sleepTime;
			//Thread.Sleep((int)sleepTime);
		}

		public void InsertAudioInfo(int fileID, string fileName, int fileSize)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioInfo"));

			MySqlConnection connection = new MySqlConnection(this.connectionString);			
			StringBuilder insertAudioFileInfo = new StringBuilder();
			insertAudioFileInfo.Append("INSERT INTO AudioFileInfo VALUES(");
			insertAudioFileInfo.Append("?AudioFileId, '"+Path.GetFileName(fileName)+"', "+fileSize+")");
			MySqlCommand cmd3 = new MySqlCommand(insertAudioFileInfo.ToString());
			cmd3.Parameters.Add("?AudioFileId", fileID);				
			cmd3.Connection = connection;			
			try
			{
				CallLogger.OnCall("IConnection", connection.GetType().GetMethod("Open"));
				connection.Open();
				CallLogger.OnReturn();

				CallLogger.OnCall("ICommand", cmd3.GetType().GetMethod("ExecuteNonQuery"));
				cmd3.ExecuteNonQuery(); // INSERT into AudioFileInfo				
				CallLogger.OnReturn();
			}
			catch(Exception e)
			{
				string info = e.Message;
				Console.WriteLine(e);
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
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("FinalizeUpload"));
			//do nothing; this method is just for the BufferingDBAdapter
			CallLogger.OnReturn();
		}

	}
}
