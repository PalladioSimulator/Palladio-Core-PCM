using System;
using System.Runtime.Remoting;
using ILBenchmark.Common.Interfaces;
using ILBenchmark.Common.Benchmarks;
using ILBenchmark.Common;
using System.Collections;
using System.Reflection;
using System.Reflection.Emit;
using Nini.Config;
using System.IO;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	class Programm
	{
		static long _standartBenchCount;
		static long _bclBenchCount;
		static bool _mono =true; //Nur ausgewählte Benchmarks laufen lassen
		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			Nini.Config.IniConfigSource conf = new IniConfigSource("config.ini");
			
			_standartBenchCount = conf.Configs["Benchmark"].GetLong("StandartBenchCount",1000000);
			_bclBenchCount = conf.Configs["Benchmark"].GetLong("BCLBenchCount",10);

			ITimer timer = getTimer(conf.Configs["Timer"].GetString("Class","StandartTimer")); 
			IOutput output = getOutput(conf.Configs["Output"].GetString("Class","ConsoleOutput"));

			//Hier Auswertung der Kommandozeileneingabe
			ProcessCommandLineArgs( args);
			{

				try 
				{
					output.Init(_standartBenchCount,_bclBenchCount);
					int i =-1;
					bool abbruch = false;
					BenchmarkSuiteResults erg = new BenchmarkSuiteResults();
					BenchmarkSuite bench;

					ArrayList ar = getTypesFromMsCorLib();
					//ArrayList ar = getSingleType();
					if (ar != null)
					{
						while (!abbruch)
						{
							AppDomain neueDomain = AppDomain.CreateDomain("BenchDomain");
							ObjectHandle obj = neueDomain.CreateInstanceFrom("ILBenchmark.Common.dll","ILBenchmark.Common.BenchmarkSuiteInit");
							BenchmarkSuiteInit init = (BenchmarkSuiteInit)obj.Unwrap();
							ObjectHandle obj2 = neueDomain.CreateInstanceFrom("ILBenchmark.Common.dll","ILBenchmark.Common.BenchmarkContainer");
							BenchmarkContainer b = (BenchmarkContainer)obj2.Unwrap();
					
							if (i==-1)
							{
								bench = init.getStandart();
								b.BenchCount = _standartBenchCount;
							} 
							else 
							{
								if (_mono)
									init.Mono = true;
								bench = init.getNext((Type)ar[i]);
								b.BenchCount = _bclBenchCount;
								
							}
							if (bench == null)
								break;

							

							b.Output = output;
							b.Timer = timer;
							BenchmarkSuiteResults r = b.Execute(bench);
							erg.ErrorAnzahl += r.ErrorAnzahl; 
							erg.GesamtAnzahl += r.GesamtAnzahl;
							erg.GesamtDauer += r.GesamtDauer;
							erg.SkippedAnzahl += r.SkippedAnzahl;
							i +=1;
							try 
							{
								AppDomain.Unload(neueDomain);
							} 
							catch (CannotUnloadAppDomainException ade)
							{
								
							}
							//Debug: Nur Standart ausführen
							//if (i==0)
							//	break;
							if(i >= ar.Count) 
								break;
						}
						SysInfo inf = new SysInfo();
						output.WriteSysInformation(inf);
						output.WriteLine("Gesamt Dauer: " + erg.GesamtDauer);
						output.WriteLine("Gesamt Anzahl: " + erg.GesamtAnzahl);
						output.WriteLine("Error Anzahl: " + erg.ErrorAnzahl);
						output.WriteLine("Parameter Skip Anzahl: " + erg.SkippedAnzahl);

						output.Save();
						if (!_mono)
							output.WriteSuccessList("benchmarks.con");
						Console.WriteLine("Fertig!");
					}
				} 
				catch (TypeLoadException tle)
				{
					Console.WriteLine(tle.Source);
					Console.WriteLine(tle.TypeName);
					Console.WriteLine(tle.Message);
				}
				catch (Exception e)
				{
					Console.WriteLine(e.Message);
				} 
				finally 
				{
					Console.ReadLine();
				}
			}
		}

		private static ITimer getTimer(string ClassName)
		{
			if (ClassName.Equals("StandartTimer"))
				return new StandartTimer();
			if (ClassName.Equals("HiResTimer"))
				return new HiResTimer();
			return new StandartTimer();
		}
		private static IOutput getOutput(string ClassName)
		{
			if (ClassName.Equals("ConsoleOutput"))
				return new ConsoleOutput();
			if (ClassName.Equals("TXTFileOutput"))
				return new TXTFileOutput();
			return new ConsoleOutput();
		}

		private static bool ProcessCommandLineArgs(string[] args)
		{
			// /? einbauen
			// filname der config
			if (args.Length > 0)
			{
				if (args[0].Equals(@"/?"))
				{
					string s= "ILBenchmark Version " + Assembly.GetExecutingAssembly().GetName().Version + Environment.NewLine
					+ Environment.NewLine + "Argumente:" + Environment.NewLine 
					+ "/f:file  Legt den Dateinamen der Parameter Datei fest. Beispiel: /f:para.xml" + Environment.NewLine
					+ "/s:count Legt die Anzahl der Ausführungen für Standart Benchmarks fest." + Environment.NewLine
					+ "/b:count Legt die Anzahl der Ausführungen für BaseClassLibrary Benchmarks fest." + Environment.NewLine
					+ " ";
					Console.Write(s);
					return true;
				}
				if (args[0].Equals(@"/mono"))
				{
					_mono = true;
				}
				if (args[0].Equals(@"/nomono"))
				{
					_mono = false;
				}
			}
			return false;
		}
		private static ArrayList getTypesFromMsCorLib()
		{
			ArrayList ar = new ArrayList();
			Assembly assembly = Assembly.Load("mscorlib.dll");
			Type[] ExistingTypes = assembly.GetTypes();
			//StreamWriter sw = new StreamWriter("testTypen.con");
			
			foreach(Type type in ExistingTypes)
			{
				if (type.IsClass && !type.IsInterface && !type.IsAbstract)
				{
					if (!type.IsArray && !type.Equals(typeof(System.Console)) && !type.Equals(typeof(System.Environment)) && !type.Equals(typeof(System.Threading.Thread)) && !type.Equals(typeof(System.Diagnostics.Debugger)))
					{
						//Ausnahmen festlegen, z.B. Klassen die zum Abbruch führen wie z.B. Application.Exit
						if (IsOK(type))
						{	
							//sw.WriteLine(type.FullName);
							ar.Add(type);
						}
					}
				}
			}
			//sw.Close();
			return ar;
		}
		private static ArrayList getTypesFromFile()
		{
			ArrayList ar = new ArrayList();
			try 
			{
				using (StreamReader sr = new StreamReader("testTypen.con")) 
				{
					while (sr.Peek() >= 0) 
					{
						string strZeile = sr.ReadLine();
						if (strZeile != null && strZeile != "" )
						{	
							Type t = Type.GetType(strZeile);
							if (t != null)
								ar.Add(t);
						}
					}
				}
				return ar;
			} 
			catch (FileNotFoundException e)
			{
				Console.WriteLine("Die Typeninformationsdatei testTypen.con konnte nicht gefunden werden.\n"
					+ "Bitte erstellen Sie sie indem sie ILBenchmark.exe /t aufrufen.");
				Console.ReadLine();
				return null;
			} 
		}
		private static ArrayList getSingleType()
		{
			ArrayList ar = new ArrayList();
			Assembly assembly = Assembly.Load("mscorlib.dll");
			Type ExistingType = assembly.GetType("System.Runtime.Remoting.Channels.ChannelServices");
			
			ar.Add(ExistingType);
			return ar;			
		}
		private static bool IsOK(Type t)
		{
			if (t.Namespace != null)
			{
				if (t.Namespace.Equals("System.Threading"))
					return false;
				if (t.Namespace.Equals("System.Reflection"))
					return false;
				if (t.Namespace.Equals("System.Reflection.Emit"))
					return false;
				if (t.Namespace.Equals("System.Security.Cryptography"))
					return false;
				/*
				if (t.Namespace.Equals("System.Runtime.Remoting"))
					return false;
				if (t.Namespace.Equals("System.Runtime.Remoting.Channels"))
					return false;
				if (t.Namespace.Equals("System.Runtime.Remoting.Messaging"))
					return false;
				if (t.Namespace.Equals("System.Runtime.Remoting.Contexts"))
					return false;
				*/
				if (t.Namespace.Equals("System.Runtime.InteropServices"))
					return false;
				if (t.Namespace.Equals("System.Diagnostics"))
					return false;
				if (t.Namespace.IndexOf("Mono") > 0)
					return false;
				if (t.FullName.Equals("System.AppDomain"))
					return false;
				if (t.Equals(typeof(System.LoaderOptimizationAttribute)))
					return false;
				if (t.Equals(typeof(System.Globalization.CultureInfo)))
					return false;
			}
			return true;
		}
	}
}
