using System.Data.SqlClient;
using Palladio.ComponentModel;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.WebserverComponentModel;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// Zusammenfassung für DBSeffAnalyser.
	/// </summary>
	public class DBExecutionTimeAnalyser : WebserverModelHelper
	{
		private ConnectionPool pool;

		public DBExecutionTimeAnalyser(ConnectionPool pool)
		{
			this.pool = pool;
		}

		public void Analyse()
		{
			SqlCommand selectInterfacesCmd = new SqlCommand();
			selectInterfacesCmd.Connection = pool.BorrowConnection();

			SqlCommand selectTimesCmd = new SqlCommand();
			selectTimesCmd.Connection = pool.BorrowConnection();

			foreach (string className in Class2Component.GetClassNames())
			{
				IComponent component = Class2Component.GetBasicComponent(className);
				CompTimesAttribute compTimeAttribute = CompTimesAttribute.GetAttribute(component);

				selectInterfacesCmd.CommandText = "SELECT DISTINCT InterfaceName FROM CallTable WHERE ClassName = '" + className + "'";
				SqlDataReader interfaceReader = selectInterfacesCmd.ExecuteReader();

				// for each interface implemented by the class
				while (interfaceReader.Read())
				{
					string interfaceName = interfaceReader.GetString(0);

					IInterfaceModel iModel = GetInterfaceModel(interfaceName);
					foreach (ISignature signature in iModel.SignatureList.GetSignatures())
					{
						MeasuredTimeAttribute timeAttribute = compTimeAttribute.GetTime(iModel.Name, signature.Name);
						selectTimesCmd.CommandText = "SELECT ExecutionTime FROM CallTable WHERE " +
							"(ClassName = '" + className + "') AND " +
							"(InterfaceName = '" + interfaceName + "') AND " +
							"(MethodName = '" + signature.Name + "')";
						SqlDataReader timesReader = selectTimesCmd.ExecuteReader();
						while (timesReader.Read())
						{
							timeAttribute.AddTime(timesReader.GetInt64(0));
						}
						timesReader.Close();
					}
				}
				interfaceReader.Close();
			}

			pool.ReturnConnection(selectInterfacesCmd.Connection);
			pool.ReturnConnection(selectTimesCmd.Connection);
		}
	}
}