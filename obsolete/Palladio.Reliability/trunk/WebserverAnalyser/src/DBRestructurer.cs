using System;
using System.Collections;
using System.Data;
using System.Data.SqlClient;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// </summary>
	public class DBRestructurer
	{
		private ConnectionPool pool;

		/// <summary>
		/// Creates a new analyser. Note that the connections in the pool must be open.
		/// </summary>
		/// <param name="pool">Pool managing the connections used by the analyser.</param>
		public DBRestructurer(ConnectionPool pool)
		{
			if (!pool.IsOpen)
				throw new ApplicationException("Connections in the pool must be open!");
			this.pool = pool;
		}

		public void Run()
		{
			UpdateAssemblyInfo();
			RestructureCallInfo();
			DetermineTotalExecutionTimes();
		}

		private void DetermineTotalExecutionTimes()
		{
			SqlCommand selectCmd = new SqlCommand();
			selectCmd.CommandText = "SELECT ID FROM MethodTable";
			selectCmd.Connection = pool.BorrowConnection();
			SqlDataReader reader = selectCmd.ExecuteReader();

			SqlCommand innerCmd = new SqlCommand();
			innerCmd.Connection = pool.BorrowConnection();

			try
			{
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

					innerCmd.CommandText = "INSERT INTO ExecutionTimeTable VALUES (" + methodID + ", " + total + ", " + cnt + ", " + avg + ")";
					innerCmd.ExecuteNonQuery();
				}
			}
			finally
			{
				reader.Close();
				pool.ReturnConnection(innerCmd.Connection);
				pool.ReturnConnection(selectCmd.Connection);
			}
		}

		private void RestructureCallInfo()
		{
			SqlCommand selectCommand = new SqlCommand();
			selectCommand.CommandText = " SELECT ClassTable.ID, ClassTable.ClassName, MethodTable.ID, MethodTable.MethodName AS MethodName FROM  ClassTable INNER JOIN MethodTable ON ClassTable.ID = MethodTable.ClassID";
			selectCommand.Connection = pool.BorrowConnection();
			SqlDataReader reader = selectCommand.ExecuteReader();

			SqlCommand innerSelectCmd = new SqlCommand();
			innerSelectCmd.Connection = pool.BorrowConnection();
			innerSelectCmd.CommandText = "SELECT CallTime, ReturnTime FROM  CallTable WHERE (ClassName = @ClassName) AND (MethodName = @MethodName) ORDER BY ID";
			innerSelectCmd.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);
			innerSelectCmd.Parameters.Add("@MethodName", SqlDbType.VarChar, 256);

			SqlCommand saveCmd = new SqlCommand();
			saveCmd.Connection = pool.BorrowConnection();
			saveCmd.CommandText = "INSERT INTO CallInfoTable VALUES (@MethodID, @CallTime, @ReturnTime)";
			saveCmd.Parameters.Add("@MethodID", SqlDbType.BigInt);
			saveCmd.Parameters.Add("@CallTime", SqlDbType.BigInt);
			saveCmd.Parameters.Add("@ReturnTime", SqlDbType.BigInt);

			SqlDataReader innerReader = null;

			try
			{
				while (reader.Read())
				{
					long classID = reader.GetInt64(0);
					string className = reader.GetString(1);
					long methodID = reader.GetInt64(2);
					string methodName = reader.GetString(3);

					innerSelectCmd.Parameters["@ClassName"].Value = className;
					innerSelectCmd.Parameters["@MethodName"].Value = methodName;
					innerReader = innerSelectCmd.ExecuteReader();
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
				if (innerReader != null)
					innerReader.Close();
				reader.Close();
				pool.ReturnConnection(innerSelectCmd.Connection);
				pool.ReturnConnection(saveCmd.Connection);
				pool.ReturnConnection(selectCommand.Connection);
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

			selectMethods.Connection = pool.BorrowConnection();
			SqlDataReader reader = selectMethods.ExecuteReader();

			ArrayList methodList = new ArrayList();
			while (reader.Read())
			{
				methodList.Add(reader.GetString(0));
			}
			reader.Close();
			pool.ReturnConnection(selectMethods.Connection);
			return (string[]) methodList.ToArray(typeof (string));
		}

		public string[] GetClassNames()
		{
			SqlCommand selectCommand = new SqlCommand("SELECT DISTINCT ClassName FROM CallTable");
			selectCommand.Connection = pool.BorrowConnection();
			SqlDataReader reader = selectCommand.ExecuteReader();
			ArrayList classList = new ArrayList();
			while (reader.Read())
			{
				classList.Add(reader.GetString(0));
			}
			reader.Close();
			pool.ReturnConnection(selectCommand.Connection);
			return (string[]) classList.ToArray(typeof (string));
		}

		public string GetInterface(string className)
		{
			string result = "";
			SqlCommand cmd = new SqlCommand();
			cmd.Connection = pool.BorrowConnection();
			cmd.CommandText = "SELECT InterfaceName FROM CallTable WHERE ClassName = '"+ className +"';";
			
			SqlDataReader reader = cmd.ExecuteReader();
			if (reader.Read())
			{
				result = reader.GetString(0);
			}

			reader.Close();
			pool.ReturnConnection(cmd.Connection);
			return result;
		}

		public long GetClassID(string className)
		{
			SqlCommand selectCommand = new SqlCommand("SELECT ID FROM ClassTable WHERE ClassName = @ClassName");
			selectCommand.Connection = pool.BorrowConnection();
			selectCommand.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);
			selectCommand.Parameters["@ClassName"].Value = className;
			SqlDataReader reader = selectCommand.ExecuteReader();
			if (reader.Read())
			{
				long val = reader.GetInt64(0);
				reader.Close();
				return val;
			}
			reader.Close();
			pool.ReturnConnection(selectCommand.Connection);
			throw new ApplicationException("Class '" + className + "' not found!");
		}

		private void InsertClassNames(string[] classNames)
		{
			SqlCommand insertClass = new SqlCommand();
			insertClass.Connection = pool.BorrowConnection();
			insertClass.CommandText = "IF (SELECT COUNT(*) AS NUM_ELEMENTS FROM ClassTable WHERE ClassName = @ClassName) = 0 BEGIN INSERT INTO ClassTable VALUES (@ClassName, @InterfaceName); END";
			insertClass.Parameters.Add("@ClassName", SqlDbType.VarChar, 256);
			insertClass.Parameters.Add("@InterfaceName", SqlDbType.VarChar, 256);

			foreach (string className in classNames)
			{
				string interfaceName = GetInterface(className);
				insertClass.Parameters["@ClassName"].Value = className;
				insertClass.Parameters["@InterfaceName"].Value = interfaceName;
				insertClass.ExecuteNonQuery();
			}
			pool.ReturnConnection(insertClass.Connection);
		}

		private void InsertMethodNames(string className, string[] methodNames)
		{
			long classID = GetClassID(className);

			SqlCommand insertMethod = new SqlCommand();
			insertMethod.Connection = pool.BorrowConnection();
			insertMethod.CommandText = "IF (SELECT COUNT(*) AS NUM_ELEMENTS FROM MethodTable WHERE (ClassID = @ClassID) AND (MethodName = @MethodName)) = 0 BEGIN INSERT INTO MethodTable VALUES (@ClassID, @MethodName); END";
			insertMethod.Parameters.Add("@MethodName", SqlDbType.VarChar, 256);
			insertMethod.Parameters.Add("@ClassID", SqlDbType.BigInt, 8);

			foreach (string methodName in methodNames)
			{
				insertMethod.Parameters["@ClassID"].Value = classID;
				insertMethod.Parameters["@MethodName"].Value = methodName;
				insertMethod.ExecuteNonQuery();
			}
			pool.ReturnConnection(insertMethod.Connection);
		}


	}
}