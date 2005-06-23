using System;
using System.Threading;
using System.Reflection;
using System.Reflection.Emit;
using ILBenchmark.Interfaces;
using System.Configuration.Assemblies;
using System.Runtime.Remoting;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für BenchmarkContainer.
	/// </summary>
	public class BenchmarkContainer
	{
		private long _BenchCount;
		private ITimer _timer;
		private IOutput _out;

		public BenchmarkContainer(long BenchCount )
		{
			_BenchCount = BenchCount;
		}

		/// <summary>
		/// Das Objekt das für die Ausgabe benutzt werden soll.
		/// </summary>
		public IOutput Output
		{
			get { return _out; }
			set { _out = value; }
		}

		/// <summary>
		/// Der Timer der für den Benchmark verwendet wird.
		/// </summary>
		public ITimer Timer
		{
			get { return _timer; }
			set { _timer = value; }
		}

		/// <summary>
		/// Führt den Benchmark für die angegebene BenchmarkSuite aus.
		/// </summary>
		/// <param name="suite">Die Benchmarksuite die ausgeführt werden soll.</param>
		public void Execute( BenchmarkSuite suite)
		{
			object[] paras;
			bool weiter = true;
			string letzterTyp ="";
			long gesamtZeit =0;
			int gesamtAnz=0;
			int skipAnz=0;
			int errorAnz=0;
			int i=0;
			
			try 
			{
				_out.Init();
				for (i=0; i< suite.Count;i++)
				{
					//AppDomain.CurrentDomain.CreateInstance(
					//AppDomain d = AppDomain.CreateDomain("Benchmark");
					AppDomain neueDomain = AppDomain.CreateDomain("Bla");

					if (suite[i].AssembleCode()) 
					{
						Type myType = suite[i].getTypeForExecuting();
						suite[i].Save(); //Assembly auf Platte schreiben, nur für Debug Zwecke
						
						//object myInstance =  neueDomain.CreateInstance(Environment.CurrentDirectory + @"\" +  suite[i].Name,"Bench");
						object myInstance =  neueDomain.CreateInstanceFrom(Environment.CurrentDirectory + @"\" +  suite[i].Name,"Bench");
						//Object myInstance = Activator.CreateInstance(myType);
						MethodInfo m = myType.GetMethod("Execute");
						//Parameter auslesen
						ParameterInfo[] para = m.GetParameters();
						paras = new object[para.Length]; //Array für spätere Parameterübergabe

						for (int x=0;x<para.Length;x++)
						{
							//Typ eines jeden Parameters auslesen 
							if (para[x].ParameterType.IsArray) //bisher nur char[]
								paras[x] = getArrayValue(para[x].ParameterType);
							else 
								paras[x] = getValue(para[x].ParameterType); 
							//und einen entsprechenden Typ in ein object[] schreiben
							if (paras[x] == null) //Wenn es noch keinen Wert für den Parameter gibt dann Abbrechen
							{
								letzterTyp = para[x].ParameterType.ToString();
								weiter = false;
								break;
							}
						}
						if (weiter)
						{
							try 
							{
								_timer.Start();
							
								for (int b=0;b< this._BenchCount;b++)
								{	
									if (paras.Length == 0)
										m.Invoke(myInstance,null);
									else
										m.Invoke(myInstance,paras);
								}
								
								_timer.Stop();
								_out.WriteResult(suite[i].FullName,_timer.getElapsedTime);
								gesamtZeit += _timer.getElapsedTime;
								gesamtAnz +=1;
								//GC.WaitForPendingFinalizers();
								
								//Console.WriteLine(suite[i].Name  + " Dauer: " + _timer.getElapsedTime.ToString());
							} 
							catch (Exception exp)
							{
								System.Text.StringBuilder sb = new System.Text.StringBuilder(paras.Length);
								for (int x=0;x<paras.Length;x++)
								{
									sb.Append(paras[x].ToString());
									sb.Append(", ");
								}
								errorAnz +=1;
								_out.WriteSkip(suite[i].Name + " " + sb.ToString() );
							}
						} 
						else 
						{
							skipAnz +=1;
							//Console.WriteLine (suite[i].Name + " übersprungen");
							_out.WriteMissingParameter(letzterTyp );
							weiter = true;
						}
						m = null;
						myType =null;
						myInstance =null;
						para=null;
						paras =null;
						//GC.Collect();
					}
					else 
					{
						//Console.WriteLine("Übersprungen - Konstruktor mit Parameter");
						_out.WriteSkip("Übersprungen: " + suite[i].FullName);
					}
					AppDomain.Unload(neueDomain);
					//d = null;
				} 
				_out.WriteResult("Gesamt Dauer: ",gesamtZeit);
				_out.WriteResult("Gesamt Anzahl: ",gesamtAnz);
				_out.WriteResult("Error Anzahl: ",errorAnz);
				_out.WriteResult("Parameter Skip Anzahl: ",skipAnz);
				_out.Save();
			
			}
			catch (System.Reflection.TargetInvocationException ex)
			{
				Console.WriteLine(ex.Message);
				Console.WriteLine(ex.StackTrace);
				//suite[i].Save();
				Console.ReadLine();
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine(e.StackTrace);
				//suite[i].Save();
				Console.ReadLine();
			}
		}
	
		public void ExecuteAlt( BenchmarkSuite suite)
		{
			object[] paras;
			bool weiter = true;
			string letzterTyp ="";
			long gesamtZeit =0;
			int gesamtAnz=0;
			int skipAnz=0;
			int errorAnz=0;
			int i=0;
			
			try 
			{
				_out.Init();
				for (i=0; i< suite.Count;i++)
				{
					//AppDomain.CurrentDomain.CreateInstance(
					//AppDomain d = AppDomain.CreateDomain("Benchmark");
					
					AppDomainSetup info = new AppDomainSetup();
					info.ApplicationBase = System.Environment.CurrentDirectory;
					// Create an application domain with null evidence
					AppDomain dom = AppDomain.CreateDomain("RemoteDomain", null,info);

					if (suite[i].AssembleCode()) 
					{
						//Type myType = suite[i].getTypeForExecuting();
						suite[i].Save(); //Assembly auf Platte schreiben, nur für Debug Zwecke
					
						//Set up information regarding the application domain
						
						//BindingFlags flags = (BindingFlags.Public | BindingFlags.Static);
						string n = suite[i].Name.Replace(".dll","");
						n = n.Replace(".exe","");
		
							ObjectHandle objh = dom.CreateInstance( n, "Bench"); //, false, flags, null, null, null, null, null);
					
							Object obj = objh.Unwrap();

							MethodInfo m=null;
							//MethodInfo mi;
							//object result = null;
							//object[] args = new object[] {"ABC123"};
							object myInstance=obj;
							Type t= myInstance.GetType();
							m = t.GetMethod("Execute");

							/*
							Assembly assemblyInstance = Assembly.LoadFrom(Environment.CurrentDirectory + @"\" +  suite[i].Name);
							Type[] types = assemblyInstance.GetTypes();
							
							foreach (Type t in types)
							{
								mi = t.GetMethod("Execute");
								if (mi != null)
								{
									string typeName = t.FullName;
									myInstance = assemblyInstance.CreateInstance(typeName);
									m = mi;
									//result = t.InvokeMember (MethodName, BindingFlags.Public | BindingFlags.InvokeMethod | BindingFlags.Instance, null, lateBoundObj, args);
									break;
								}
							}
							*/
							//Parameter auslesen
							ParameterInfo[] para = m.GetParameters();
							paras = new object[para.Length]; //Array für spätere Parameterübergabe
							GC.GetTotalMemory(true);
							for (int x=0;x<para.Length;x++)
							{
								//Typ eines jeden Parameters auslesen 
								if (para[x].ParameterType.IsArray) //bisher nur char[]
									paras[x] = getArrayValue(para[x].ParameterType);
								else 
									paras[x] = getValue(para[x].ParameterType); 
								//und einen entsprechenden Typ in ein object[] schreiben
								if (paras[x] == null) //Wenn es noch keinen Wert für den Parameter gibt dann Abbrechen
								{
									letzterTyp = para[x].ParameterType.ToString();
									weiter = false;
									break;
								}
							}
							if (weiter)
							{
								try 
								{
									_timer.Start();
								
									for (int b=0;b< this._BenchCount;b++)
									{	
										if (paras.Length == 0)
											m.Invoke(myInstance,null);
										else
											m.Invoke(myInstance,paras);
									}
									
									_timer.Stop();
									_out.WriteResult(suite[i].FullName,_timer.getElapsedTime);
									gesamtZeit += _timer.getElapsedTime;
									gesamtAnz +=1;
									//GC.WaitForPendingFinalizers();
									
									//Console.WriteLine(suite[i].Name  + " Dauer: " + _timer.getElapsedTime.ToString());
								} 
								catch (Exception exp)
								{
									System.Text.StringBuilder sb = new System.Text.StringBuilder(paras.Length);
									for (int x=0;x<paras.Length;x++)
									{
										sb.Append(paras[x].ToString());
										sb.Append(", ");
									}
									errorAnz +=1;
									_out.WriteSkip(suite[i].Name + " " + sb.ToString() );
								}
							} 
							else 
							{
								skipAnz +=1;
								//Console.WriteLine (suite[i].Name + " übersprungen");
								_out.WriteMissingParameter(letzterTyp );
								weiter = true;
							}
							m = null;
							//myType =null;
							//myInstance =null;
							para=null;
							paras =null;
							//GC.Collect();
						}
						else 
						{
							//Console.WriteLine("Übersprungen - Konstruktor mit Parameter");
							_out.WriteSkip("Übersprungen: " + suite[i].FullName);
						}
					
					AppDomain.Unload(dom);
					//d = null;
				} 
				_out.WriteResult("Gesamt Dauer: ",gesamtZeit);
				_out.WriteResult("Gesamt Anzahl: ",gesamtAnz);
				_out.WriteResult("Error Anzahl: ",errorAnz);
				_out.WriteResult("Parameter Skip Anzahl: ",skipAnz);
				_out.Save();
			
			}
			catch (System.Reflection.TargetInvocationException ex)
			{
				Console.WriteLine(ex.Message);
				Console.WriteLine(ex.StackTrace);
				//suite[i].Save();
				Console.ReadLine();
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine(e.StackTrace);
				//suite[i].Save();
				Console.ReadLine();
			}
		}
		
		private object getArrayValue(Type t)
		{
			if (t.Equals(typeof(char[])))
			{
				char[] myArray = new char[2] { Char.Parse("a"), Char.Parse("b")};
				return  myArray;
			}
			if (t.Equals(typeof(int[])))
			{
				int[] myArray = new int[2] { 1, 2};
				return  myArray;
			}
			if (t.Equals(typeof(string[])))
			{
				string[] myArray = new string[2] { "a", "b"};
				return  myArray;
			}
			if (t.Equals(typeof(byte[])))
			{
				byte[] myArray = new byte[16];
				return  myArray;
			}
			if (t.Equals(typeof(object[])))
			{
				object[] myArray = new object[2] { "a", "b"};
				return  myArray;
			}
			//Console.WriteLine(t.FullName);
			return null;

		}
		private object getValue(Type t)
		{
			//Hashtable am Anfang mit Daten füllen oder so
			System.Collections.Hashtable ht = new System.Collections.Hashtable();
			ht.Add(typeof(int),int.MinValue);

			
			if (t.Equals(typeof(int)))
			{
				return 1;
			}
			if (t.Equals(typeof(Decimal)))
			{
				return Decimal.MinValue;
			}
			if (t.Equals(typeof(string)))
			{
				return "Dies ist ein Benchmark!";
			}
			if (t.Equals(typeof(Single)))
			{
				return Single.MinValue;
			}
			if (t.Equals(typeof(UInt32)))
			{
				return UInt32.MinValue;
			}
			if (t.Equals(typeof(UInt64)))
			{
				return UInt64.MinValue;
			}
			if (t.Equals(typeof(Int16)))
			{
				return Int16.MinValue;
			}
			if (t.Equals(typeof(Int32)))
			{
				return Int32.MinValue;
			}
			if (t.Equals(typeof(object)))
			{
				return new Object();
			}
			if (t.Equals(typeof(long)))
			{
				return 1;
			}
			if (t.Equals(typeof(double)))
			{
				return 0.1;
			}
			if (t.Equals(typeof(char)))
			{
				return Char.Parse("a");
			}
			if (t.Equals(typeof(bool)))
			{
				return false;
			}
			if (t.Equals(typeof(System.IO.TextReader)))
			{
				return System.IO.TextReader.Null;
			}
			if (t.Equals(typeof(System.IO.TextWriter)))
			{
				return System.IO.TextWriter.Null;
			}
			if (t.Equals(typeof(System.IFormatProvider)))
			{
				return new System.Globalization.NumberFormatInfo();
			}
			if (t.Equals(typeof(System.Version)))
			{
				return new System.Version();
			}
			if (t.Equals(typeof(System.Runtime.Serialization.StreamingContext)))
			{
				return new System.Runtime.Serialization.StreamingContext(System.Runtime.Serialization.StreamingContextStates.All);
			}
			//Console.WriteLine(t.FullName);
			return null;
		}

	}

	
}
