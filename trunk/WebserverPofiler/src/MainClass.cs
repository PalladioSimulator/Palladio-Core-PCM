using System;
using System.Data.SqlClient;
using System.Reflection;
using Palladio.Reliability.DatabaseSchema;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverFactory;
using Palladio.Reliability.WebserverProfiler.Interceptor;

namespace Palladio.Reliability.WebserverProfiler
{
	/// <summary>
	/// Zusammenfassung für MainClass.
	/// </summary>
	public class MainClass
	{
		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "WebserverXML.xml";

		private const string CONNECTION_STRING = "workstation id=nb-happe;packet size=4096;integrated security=SSPI;data source=jupiter;persist security info=False;initial catalog=ReliabilityDB; user id=jens";

		/// <summary>
		/// Main webserver-application start.
		/// </summary>
		/// <param name="args">
		/// First position: path to the config-files, including last backspace.</br>
		/// Second position: configuration-number</br>
		/// Example-usage: Webserver "..\..\..\Config\" 1</param>
		public static void Main(string[] args)
		{
			long startTime = DateTime.Now.Ticks;

			// ResetDB
			// DBFactory.DropReliabilityDB(CONNECTION_STRING);
			DBFactory.CreateReliabilityDB(CONNECTION_STRING);

			CallLogger logger = InitialiseLogger();
			string pathToConfigFile = GetPathToConfigFile(args);
			string configType = GetConfigType(args);
			Webserver.Webserver webserver = InitialiseWebserver(configType, pathToConfigFile);
			
			RunWebserver(webserver);

			long stopTime = DateTime.Now.Ticks;
			long runID = GetRunID(startTime, stopTime);
			SaveLoggedInformation(logger, runID);
		}

		private static void SaveLoggedInformation(CallLogger logger, long runID)
		{
			SqlConnection connection = new SqlConnection(CONNECTION_STRING);
			try
			{
				connection.Open();
				// store callinfo's
				SqlCommand cmd = new SqlCommand();
				cmd.Connection = connection;

				foreach (CallInfo callInfo in logger.Calls)
				{

					cmd.CommandText = String.Format("INSERT INTO CallTable (CallNumber, CallLevel, CallerID, ClassName, InterfaceName, MethodName, CallTime, ReturnTime, RunID, ThreadID) VALUES ({0}, {1}, {2}, '{3}', '{4}', '{5}', {6}, {7}, {8}, {9})",
					                                callInfo.CallNumber,
					                                callInfo.CallLevel,
					                                callInfo.CallerID,
					                                callInfo.MethodInfo.DeclaringType.ToString(),
																					callInfo.InterfaceName,
					                                MethodString(callInfo.MethodInfo),
					                                callInfo.StartTime,
					                                callInfo.StopTime,
					                                runID,
					                                callInfo.ThreadID);
					cmd.ExecuteNonQuery();
				}
			}
			finally
			{
				connection.Close();
			}
		}


		public static bool IsVoidMethod(MethodInfo methodInfo)
		{
			return methodInfo.ReturnType.Equals(typeof(void));
		}

		private static string MethodString(MethodInfo methodInfo)
		{
			return methodInfo.Name;
//			string methodStr = "";
//			if (!IsVoidMethod(methodInfo))
//			{
//				methodStr += methodInfo.ReturnType.ToString();
//			}
//			else
//			{
//				methodStr += "void";
//			}
//			methodStr += " " + methodInfo.Name +"(";
//		
//			ParameterInfo[] parameters = methodInfo.GetParameters();
//			for (int i=0; i<parameters.Length; i++ )
//			{
//				if (i!=0) 
//				{ 
//					methodStr += ", ";
//				}
//				methodStr += parameters[i].ParameterType.ToString() + " ";
//				methodStr += parameters[i].Name;
//			}
//			methodStr += ")";
//			return methodStr;
		}

		private static long GetRunID(long startTime, long stopTime)
		{
			// save Logged Information
			long runID;
			SqlConnection connection = new SqlConnection(CONNECTION_STRING);
			try
			{
				connection.Open();

				// store Run with ID
				SqlCommand cmd = new SqlCommand();
				cmd.Connection = connection;
				cmd.CommandText = "INSERT INTO RunTable VALUES (" + startTime + ", " + stopTime + ")";
				cmd.ExecuteNonQuery();

				cmd.CommandText = "SELECT ID FROM RunTable WHERE (StartTime = " + startTime + ") AND (StopTime =" + stopTime + ")";
				SqlDataReader reader = cmd.ExecuteReader();

				if (reader.Read())
				{
					runID = reader.GetInt64(0);
				}
				else
					throw new ApplicationException("RunEntry could not be retrieved from the database!");
				reader.Close();
			}
			finally
			{
				connection.Close();
			}
			return runID;
		}

		private static void RunWebserver(Webserver.Webserver webserver)
		{
			Console.WriteLine("# Main-Thread: Webserver.Run started...");
			webserver.Start();
			// make the webserver shutdown explicitly.
			webserver.WebserverMonitor.WriteLogEntry("/=========================================\\");
			webserver.WebserverMonitor.WriteLogEntry("|  Press ENTER to shutdown the webserver. |");
			webserver.WebserverMonitor.WriteLogEntry("\\=========================================/");
			Console.ReadLine();
			webserver.Stop();
			Console.WriteLine("# Main-Thread: Webserver exited...");
		}

		private static Webserver.Webserver InitialiseWebserver(string configType, string pathToConfigFile)
		{
			// Choose Factories
			IWebserverFactory webserverFactory = new InterceptedWebserverFactory(new DefaultWebserverFactory());
			// do not log the access to the request objects.
			IRequestFactory requestFactory = new DefaultRequestFactory();
			IPortListenerFactory portListenerFactory = new InterceptedPortListenerFactory( new DefaultPortListenerFactory());

			Webserver.Webserver webserver;
			// Check for the desired configuration type:
			switch (configType)
			{
					// default case; no special config-advices:
				case "":
					webserver = Webserver.Webserver.CreateDefaultConfiguration(webserverFactory, requestFactory, portListenerFactory, pathToConfigFile, DEFAULT_XML_CONFIGURATION_FILE);
					break;

				default:
					webserver = Webserver.Webserver.CreateDefaultConfiguration(webserverFactory, requestFactory, portListenerFactory, pathToConfigFile, DEFAULT_XML_CONFIGURATION_FILE);
					break;
			}
			return webserver;
		}

		private static CallLogger InitialiseLogger()
		{
			// initialise Logger
			CallLogger logger = new CallLogger();
			InterceptorActions.BeforeCall += new BeforeCallDelegate(logger.OnCall);
			InterceptorActions.AfterCall += new AfterCallDelegate(logger.OnReturn);
//			InterceptorActions.AfterCall += new AfterCallDelegate(OnAfterCall);
			return logger;
		}

		private static void OnAfterCall(long id, MethodInfo method)
		{
			Console.WriteLine(MethodString(method));
		}

		private static string GetConfigType(string[] args)
		{
			// The kind of component-configuration:
			string configType;

			try
			{
				configType = args[1];
			}
			catch (IndexOutOfRangeException)
			{
				configType = ""; //use default configuration
			}
			return configType;
		}

		private static string GetPathToConfigFile(string[] args)
		{
			// Get the config-path:
			string pathToConfigFile;

			try
			{
				pathToConfigFile = args[0];
			}
			catch (IndexOutOfRangeException)
			{
				pathToConfigFile = @"../../../Config/"; //use default path
			}
			return pathToConfigFile;
		}
	}
}