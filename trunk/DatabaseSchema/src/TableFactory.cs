using System.Data.SqlClient;

namespace Palladio.Reliability.DatabaseSchema
{
	/// <summary>
	/// Zusammenfassung für TableFactory.
	/// </summary>
	public class TableFactory
	{
		private string creationCommand;
		private string tableName;


		public TableFactory(string tableName, string creationCommand)
		{
			this.creationCommand = creationCommand;
			this.tableName = tableName;
		}

		/// <summary>
		/// If the table does not exist, it is created.
		/// </summary>
		/// <param name="connectionString"></param>
		public void CreateTable(string connectionString)
		{
			SqlCommand cmd = new SqlCommand();
			cmd.Connection = new SqlConnection(connectionString);
			cmd.CommandText = "IF NOT EXISTS (SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '" + tableName + "') " + creationCommand;
			try
			{
				cmd.Connection.Open();
				cmd.ExecuteNonQuery();
			}
			finally
			{
				cmd.Connection.Close();
			}
		}

		/// <summary>
		/// If the table exists, it is dropped. A new table 
		/// is created afterwards.
		/// </summary>
		/// <param name="connectionString"></param>
		public void DropTable(string connectionString)
		{
			SqlCommand cmd = new SqlCommand();
			cmd.Connection = new SqlConnection(connectionString);
			cmd.CommandText = "IF EXISTS (SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '" + tableName + "') DROP TABLE " + tableName + ";";
			try
			{
				cmd.Connection.Open();
				cmd.ExecuteNonQuery();
			}
			finally
			{
				cmd.Connection.Close();
			}
		}

		private TableFactory()
		{
		}
	}
}