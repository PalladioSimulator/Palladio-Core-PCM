using System;
using System.Collections;
using System.Data;
using System.Data.SqlClient;

namespace Palldio.Interceptor.Data
{
	/// <summary>
	/// Zusammenfassung für DBAnalysis.
	/// </summary>
	public class DBAnalyser
	{
		private SqlConnection connection;

		public DBAnalyser(SqlConnection connection)
		{
			this.connection = connection;
		}

		public void Analyse()
		{
			UpdateAssemblyInfo();
			RestructureCallInfo();
			DetermineTotalExecutionTimes();
		}

		private void DetermineTotalExecutionTimes()
		{
			SqlCommand selectCmd = new SqlCommand();
			selectCmd.CommandText = "SELECT ID FROM MethodTable";
			selectCmd.Connection = connection;
			SqlDataReader reader = selectCmd.ExecuteReader();

			SqlCommand innerCmd = new SqlCommand();
			innerCmd.Connection = new SqlConnection(connection.ConnectionString);

			try
			{
				innerCmd.Connection.Open();

				while (reader.Read())
				{
					long methodID = reader.GetInt64(0);
					innerCmd.CommandText = "SELECT SUM(ExecutionTime), AVG(ExecutionTime), COUNT(ExecutionTime) FROM CallInfoTable WHERE MethodID =" + methodID;
					SqlDataReader innerReader = innerCmd.ExecuteReader();
					long total = 0;
					long avg = 0;
					long cnt = 0;
					if (innerReader.Read())
					{
						total = innerReader.GetInt64(0);
						avg = innerReader.GetInt64(1);
						cnt = innerReader.GetInt32(2);
					}
					innerReader.Close();

					innerCmd.CommandText = "DELETE FROM ExecutionTimeTable WHERE MethodID =" + methodID;
					innerCmd.ExecuteNonQuery();

					innerCmd.CommandText = "INSERT INTO ExecutionTimeTable VALUES ("+methodID+", "+ total+ ", " + cnt + ", " + avg +")";
					innerCmd.ExecuteNonQuery();
				}

				reader.Close();
			}
			finally
			{
				innerCmd.Connection.Close();
			}
		}

		private void RestructureCallInfo()
		{
			SqlCommand selectCommand = new SqlCommand();
			selectCommand.CommandText = " SELECT ClassTable.ID, ClassTable.ClassName, MethodTable.ID, MethodTable.MethodName AS MethodName FROM  ClassTable INNER JOIN MethodTable ON ClassTable.ID = MethodTable.ClassID";
			selectCommand.Connection = connection;
			SqlDataReader reader = selectCommand.ExecuteReader();
			
			SqlCommand innerSelectCmd = new SqlCommand();
			innerSelectCmd.Connection = new SqlConnection(connection.ConnectionString);
			innerSelectCmd.CommandText = "SELECT CallTime, ReturnTime FROM  CallTable WHERE (ClassName = @ClassName) AND (MethodName = @MethodName) ORDER BY ID";
			innerSelectCmd.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);
			innerSelectCmd.Parameters.Add("@MethodName", SqlDbType.VarChar, 256);

			SqlCommand saveCmd = new SqlCommand();
			saveCmd.Connection = new SqlConnection(connection.ConnectionString);
			saveCmd.CommandText = "INSERT INTO CallInfoTable VALUES (@MethodID, @CallTime, @ReturnTime)";
			saveCmd.Parameters.Add("@MethodID", SqlDbType.BigInt);
			saveCmd.Parameters.Add("@CallTime", SqlDbType.BigInt);
			saveCmd.Parameters.Add("@ReturnTime", SqlDbType.BigInt);

			try 
			{

				innerSelectCmd.Connection.Open();
				saveCmd.Connection.Open();
			
				while(reader.Read()) 
				{
					long classID = reader.GetInt64(0);
					string className = reader.GetString(1);
					long methodID = reader.GetInt64(2);
					string methodName = reader.GetString(3);

					innerSelectCmd.Parameters["@ClassName"].Value = className;
					innerSelectCmd.Parameters["@MethodName"].Value = methodName;
					SqlDataReader innerReader = innerSelectCmd.ExecuteReader();
					while (innerReader.Read())
					{
						saveCmd.Parameters["@MethodID"].Value = methodID;
						saveCmd.Parameters["@CallTime"].Value = innerReader.GetInt64(0);
						saveCmd.Parameters["@ReturnTime"].Value = innerReader.GetInt64(1);
						saveCmd.ExecuteNonQuery();
					}
					innerReader.Close();
				}
				reader.Close();
			}
			finally
			{
				innerSelectCmd.Connection.Close();
				saveCmd.Connection.Close();
			}
		}

		private void UpdateAssemblyInfo()
		{
			string[] classNames = GetClassNames();
			InsertClassNames(classNames);
			foreach (string className in classNames)
			{
				string[] methodNames = GetMethodsNamesForClass(className);
				InsertMethodNames(className, methodNames);
			}
		}

		public string[] GetMethodsNamesForClass(string className)
		{
			SqlCommand selectMethods = new SqlCommand();
			selectMethods.CommandText = "SELECT DISTINCT MethodName FROM CallTable WHERE ClassName = @ClassName";
			selectMethods.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);
			selectMethods.Parameters["@ClassName"].Value = className;

			selectMethods.Connection = connection;
			SqlDataReader reader = selectMethods.ExecuteReader();

			ArrayList methodList = new ArrayList();

			while (reader.Read())
			{
				methodList.Add(reader.GetString(0));
			}
			reader.Close();
			return (string[]) methodList.ToArray(typeof(string));
		}

		public string[] GetClassNames()
		{
			SqlCommand selectCommand = new SqlCommand("SELECT DISTINCT ClassName FROM CallTable", connection);
			SqlDataReader reader = selectCommand.ExecuteReader();
			ArrayList classList = new ArrayList();
			while(reader.Read()) 
			{
				classList.Add(reader.GetString(0));
			}
			reader.Close();
			return (string[])classList.ToArray(typeof(string));
		}

		public long GetClassID(string className)
		{
			SqlCommand selectCommand = new SqlCommand("SELECT ID FROM ClassTable WHERE ClassName = @ClassName", connection);
			selectCommand.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);
			selectCommand.Parameters["@ClassName"].Value = className;
			SqlDataReader reader = selectCommand.ExecuteReader();
			if(reader.Read())
			{
				long val = reader.GetInt64(0);
				reader.Close();
				return val;
			}
			reader.Close();
			throw new ApplicationException("Class '"+className+"' not found!");
		}

		private void InsertClassNames(string[] classNames)
		{
			SqlCommand insertClass = new SqlCommand();
			insertClass.Connection = connection;
			insertClass.CommandText = "IF (SELECT COUNT(*) AS NUM_ELEMENTS FROM ClassTable WHERE ClassName = @ClassName) = 0 BEGIN INSERT INTO ClassTable VALUES (@ClassName); END";
			insertClass.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);

			foreach (string className in classNames)
			{
				insertClass.Parameters["@ClassName"].Value = className;
				insertClass.ExecuteNonQuery();
			}
		}

		private void InsertMethodNames(string className, string[] methodNames)
		{
			long classID = GetClassID(className);

			SqlCommand insertMethod = new SqlCommand();
			insertMethod.Connection = connection;
			insertMethod.CommandText = "IF (SELECT COUNT(*) AS NUM_ELEMENTS FROM MethodTable WHERE (ClassID = @ClassID) AND (MethodName = @MethodName)) = 0 BEGIN INSERT INTO MethodTable VALUES (@ClassID, @MethodName); END";
			insertMethod.Parameters.Add("@MethodName", SqlDbType.VarChar, 256);
			insertMethod.Parameters.Add("@ClassID", SqlDbType.BigInt, 8);

			foreach (string methodName in methodNames)
			{
				insertMethod.Parameters["@ClassID"].Value = classID;
				insertMethod.Parameters["@MethodName"].Value = methodName;
				insertMethod.ExecuteNonQuery();
			}
		}


	}
}
