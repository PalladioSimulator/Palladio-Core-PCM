using System;
using System.Runtime.Remoting;
using System.Collections;
using System.Reflection;
using Nini.Config;
using CilBenchmark.Container;

[assembly:CLSCompliant(true)]
namespace CilBenchmark
{
	/// <summary>
	/// The class is the entry point for the application. It starts the benchmark process
	/// </summary>
	class Program
	{
		private int[] benchmarkCountList;
		private int benchmarkCount;
		private ParameterProfile[] parameterProfileList; 
		private ParameterProfile parameterProfile; 
		private bool writeList; 
		private	BenchmarkSuiteResults results;
		private Output output;

		/// <summary>
		/// The function starts the bencharking process
		/// </summary>
		public void Start(string[] args)
		{
			if (ReadConfigSettings() == true)
			{
				if (!ProcessCommandLineArgs( args))
				{ //Batch execution of serveral config settings
					for (int bCount = 0;bCount<benchmarkCountList.Length;bCount++)
					{
						for (int paraCount =0;paraCount<parameterProfileList.Length;paraCount++)
						{
							benchmarkCount = benchmarkCountList[bCount];
							parameterProfile = parameterProfileList[paraCount];
							InitOutput();

							results = new BenchmarkSuiteResults();

							//Execute IL benchmarks 
							ExecuteSuite();
				
							ArrayList ar = getTypesFromMsCorLib();
							for (int i=0;i < ar.Count;i++)
							{
								BenchmarkSuiteResults suiteResults = ExecuteSuite((Type)ar[i]);
								results.Add(suiteResults);
							}

							WriteOutput();
						}
					}

				}
			}
		}
		/// <summary>
		/// Writes the output
		/// </summary>
		private void WriteOutput()
		{
			SysInfo inf = new SysInfo();
			output.WriteSysInformation(inf);
			output.WriteLine("Gesamt Dauer: " + results.TotalTime);
			output.WriteLine("Gesamt Anzahl: " + results.TotalCount);
			output.WriteLine("Error Anzahl: " + results.ErrorCount);
			output.WriteLine("Parameter Skip Anzahl: " + results.SkippedCount);
			output.Save();
	
			if (writeList) 
				output.WriteSuccessList("benchmarks.con");
		}
		/// <summary>
		/// Initialises the output
		/// </summary>
		private void InitOutput()
		{
			Nini.Config.IniConfigSource conf = new IniConfigSource("config.ini"); 
			conf.Alias.AddAlias("true",true); //define string "true" to be true
			conf.Alias.AddAlias("false",false);
			string filename ="";
			if (conf.Configs["System"].GetBoolean("GetSysInformation",true)) //check wheter to retrive the system information or read it from the config file
				filename = conf.Configs["Output"].GetString("File","erg-net-" + parameterProfile + "-" + benchmarkCount + "-" + DateTime.Now.Hour + "-" + DateTime.Now.Minute + "-" + DateTime.Now.Second  + ".txt");
			else
				filename = conf.Configs["Output"].GetString("File","erg-mono-" + parameterProfile + "-" + benchmarkCount + "-" + DateTime.Now.Hour + "-" + DateTime.Now.Minute + "-" + DateTime.Now.Second  + ".txt");
			System.IO.StreamWriter streamWriter = new System.IO.StreamWriter(filename,false);

			output = new Output(streamWriter,Console.Out);
			output.Init(benchmarkCount,(int)parameterProfile); //Init Output
		}

		/// <summary>
		/// Sets the benchmarkcount and the parameterprofile according the settings in the config file
		/// </summary>
		private bool ReadConfigSettings()
		{
			Nini.Config.IniConfigSource conf;

			try 
			{
				//Read config file
				conf = new IniConfigSource("config.ini"); 
			} catch (System.IO.FileNotFoundException)
			{
				Console.WriteLine("The configuration file 'config.ini' could not be loaded. Please make sure that it resides in the program's directory.");
				return false;
			}
			//read setting from config file
			string[] benchmarkCountStringList =conf.Configs["Benchmark"].Get("Count").Split('|');
			benchmarkCountList = new int[benchmarkCountStringList.Length];
			for (int i=0;i<benchmarkCountStringList.Length;i++)
			{
				benchmarkCountList[i] = int.Parse(benchmarkCountStringList[i]);
			}
			string[] parameterProfileStringList =conf.Configs["Benchmark"].Get("Parameter").Split('|');
			parameterProfileList = new ParameterProfile[parameterProfileStringList.Length];
			for (int i=0;i<parameterProfileStringList.Length;i++)
			{
				parameterProfileList[i] = (ParameterProfile)int.Parse(parameterProfileStringList[i]);
			}
			//parameterProfile = (ParameterProfile)conf.Configs["Benchmark"].GetInt("Parameter",0);
			return true;
		}

		/// <summary>
		/// The function generates a BenchmarkSuite Object for the given type and execute the suite
		/// </summary>
		/// <param name="type">The type for which the Benchmarksuite should be generated and executed</param>
		private BenchmarkSuiteResults ExecuteSuite(Type type)
		{
			BenchmarkSuiteResults suiteResults = new BenchmarkSuiteResults();

			AppDomain newDomain = AppDomain.CreateDomain("BenchDomain");
			ObjectHandle objHandle = newDomain.CreateInstanceFrom("CilBenchmark.Container.dll","CilBenchmark.Container.BenchmarkSuiteInit");
			BenchmarkSuiteInit init = (BenchmarkSuiteInit)objHandle.Unwrap();
			
			ObjectHandle objCon = newDomain.CreateInstanceFrom("CilBenchmark.Container.dll","CilBenchmark.Container.BenchmarkContainer");
			BenchmarkContainer bContainer = (BenchmarkContainer)objCon.Unwrap();

			init.ExecuteTestedOnly = !writeList;
			BenchmarkSuite suite = init.GetNext(type); 
			if (suite != null) 
			{
				bContainer.UsedParameterProfile = parameterProfile;
				bContainer.BenchCount = benchmarkCount;
				bContainer.Output = output;
				suiteResults = bContainer.Execute(suite); 				
			} 
			else 
			{
				Terminate(); 
			}
			AppDomain.Unload(newDomain);
			return suiteResults;
		}
		/// <summary>
		/// Terminates the program
		/// </summary>
		private void Terminate()
		{
			System.Threading.Thread.CurrentThread.Abort();
		}
		/// <summary>
		/// The function generates a BenchmarkSuite Object and executes the suite
		/// </summary>
		private BenchmarkSuiteResults ExecuteSuite()
		{
			BenchmarkSuiteResults suiteResults = new BenchmarkSuiteResults();

			AppDomain newDomain = AppDomain.CreateDomain("BenchDomain");
			ObjectHandle objHandle = newDomain.CreateInstanceFrom("CilBenchmark.Container.dll","CilBenchmark.Container.BenchmarkSuiteInit");
			BenchmarkSuiteInit init = (BenchmarkSuiteInit)objHandle.Unwrap();
			ObjectHandle objContainer = newDomain.CreateInstanceFrom("CilBenchmark.Container.dll","CilBenchmark.Container.BenchmarkContainer");
			BenchmarkContainer benchmarkContainer = (BenchmarkContainer)objContainer.Unwrap();

			init.ExecuteTestedOnly = !writeList;
			BenchmarkSuite suite = init.GetStandard(); 
			benchmarkContainer.Output = output;
			benchmarkContainer.UsedParameterProfile = parameterProfile;
			benchmarkContainer.BenchCount = benchmarkCount;
			suiteResults = benchmarkContainer.Execute(suite);

			AppDomain.Unload(newDomain);
			return suiteResults;
		}
		/// <summary>
		/// The Method proccesses the command line Arguments
		/// </summary>
		/// <param name="args">The arguments given by the user</param>
		/// <returns>True if the application is to be stopped, else false</returns>
		private bool ProcessCommandLineArgs(string[] args)
		{
			if (args.Length > 0) //arguments there?
			{
				if (args[0].Equals(@"/?")) //Help
				{
					string s= "ILBenchmark Version " + Assembly.GetExecutingAssembly().GetName().Version + Environment.NewLine
						+ Environment.NewLine + "arguments:" + Environment.NewLine 
						+ "/max\tUse maximum parameter values" + Environment.NewLine
						+ "/min\tUse minimum parameter values" + Environment.NewLine
						+ "/list\tGenerate new list of successfully executed benchmarks" + Environment.NewLine
						+ " ";
					Console.Write(s);
					return true;
				}
				if (args[0].Equals(@"/max")) 
				{
					parameterProfile = ParameterProfile.Max;
				}
				if (args[0].Equals(@"/min")) 
				{
					parameterProfile = ParameterProfile.Min;
				}
				if (args[0].Equals(@"/list")) 
				{
					writeList = true;
				}
			}
			return false;
		}
		/// <summary>
		/// The function takes all types from the MsCorLib.dll and adds them to an ArrayList,
		/// if they can be benchmarked
		/// </summary>
		/// <returns>The ArrayList, containing all types that can be benchmarked</returns>
		private  ArrayList getTypesFromMsCorLib()
		{
			ArrayList arrayList = new ArrayList();
			Assembly assembly = Assembly.Load("mscorlib.dll"); 
			Type[] ExistingTypes = assembly.GetTypes();

			foreach(Type type in ExistingTypes) 
			{	
				if (IsBenchmarkable(type))
				{	
					arrayList.Add(type);
				}	
			}
			return arrayList;
		}
		/// <summary>
		/// The function tests wheter the type can be benchmarked
		/// </summary>
		/// <param name="type">The type to be tested</param>
		/// <returns>True, if the type can be benchmarked, else false.</returns>
		private bool IsBenchmarkable(Type type)
		{
			if (type.IsClass && !type.IsInterface && !type.IsAbstract) //see if the type is a class and not abstract
			{
				//make Exceptions
				if (!type.IsArray && !type.Equals(typeof(System.Console)) && !type.Equals(typeof(System.Environment)) && !type.Equals(typeof(System.Threading.Thread)) && !type.Equals(typeof(System.Diagnostics.Debugger)))
				{
					if (type.Namespace != null)
					{
						//These namespaces are to be excluded
						if (type.Namespace.IndexOf("System") != -1)
						{
							if (type.Namespace.Equals("System.Threading")) 
								return false;
							if (type.Namespace.Equals("System.Diagnostics"))
								return false;				
							if (type.Namespace.Equals("System.Reflection"))
								return false;
							if (type.Namespace.Equals("System.Reflection.Emit"))
								return false;
							if (type.Namespace.Equals("System.Security.Cryptography"))
								return false;
							if (type.Namespace.Equals("System.Runtime.Remoting"))
								return false;
							if (type.Namespace.Equals("System.Runtime.InteropServices"))
								return false;
							if (type.FullName.Equals("System.AppDomain"))
								return false;
							if (type.Equals(typeof(System.GC)))
								return false;
							if (type.FullName.IndexOf("System.Array") == -1)
							{
								return true;
							}
							else
							{
								return false;
							}
						}
					}
				} 
			}
			return false;	
		}
	}
}