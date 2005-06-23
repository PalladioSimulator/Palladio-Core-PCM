using System;
using System.Reflection;
using System.Reflection.Emit;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ILBenchmark.
	/// </summary>
	public class BenchmarkSuiteInit
	{
		private BenchmarkSuite _suite;
		private System.Collections.ArrayList _ar;

		public BenchmarkSuiteInit()
		{

		}

		public BenchmarkSuite getAllInMSCoreLib()
		{
			Assembly assembly = Assembly.Load("mscorlib.dll");
			Type[] ExistingTypes = assembly.GetTypes();
			
			//Ausnahmen festlegen, z.B. Klassen die zum Abbruch führen wie z.B. Application.Exit
			_ar = new System.Collections.ArrayList();
			_ar.Add("d8a53cda-44d1-3d57-8eef-2c0c562d7aaa"); //_HandleProtector
			_ar.Add("874345a9-2bf9-316e-b1c2-10a0b1ab3ef6"); //WaitHandle
			/*
			_ar.Add("e35af4dd-eb37-39fc-9071-4ce39b1a54be"); //AutoResetEvent
			_ar.Add("f3ce7312-70ae-37ff-98f6-cf1dcb22b9e4");
			_ar.Add("6afbf244-9ab3-37d7-b4d4-357a72b76de1");
			_ar.Add("17a355c3-c65e-3f26-8a80-236890ebc997");
			_ar.Add("9e97213a-0b49-3c05-a0bf-d203c4fc8487");
			_ar.Add("d74d613d-f27f-311b-a9a3-27ebc63a1a5d");
			_ar.Add("7fe87a55-1321-3d9f-8fef-cd2f5e8ab2e9");
			_ar.Add("9173d971-b142-38a5-8488-d10a9dcf71b0");
			_ar.Add("48a75519-cb7a-3d18-b91e-be62ee842a3e");
			_ar.Add("ea1cf67d-7904-36a3-bd5b-dd028985861c");
			_ar.Add("50f8ae2b-69f0-37ef-954b-d2618e3e8267");
			_ar.Add("d8e04cc2-f4f5-367d-a23f-f71aff4f14f3");
			*/
			_suite = new BenchmarkSuite();

			TXTFileOutput txtout = new TXTFileOutput();
			//txtout.Init();
			foreach(Type type in ExistingTypes)
			{
				if (type.IsClass)
				{
					if (!type.IsArray && !type.Equals(typeof(System.Console)) && !type.Equals(typeof(System.Environment)) && !type.Equals(typeof(System.Threading.Thread)) && !type.Equals(typeof(System.Diagnostics.Debugger)))
					{
						//txtout.WriteResult(type.FullName + "-" + type.GUID,0);
						if (IsOK(type))
						{	
							AddType(type);
						}
					}
				}
			}
			//txtout.Save();
			//Console.ReadLine();
			return _suite;

		}
		private bool IsOK(Type t)
		{
			#region GuidTest
			/*
			if (_ar.BinarySearch(g.ToString()) >= 0)
			{
				System.Diagnostics.Debug.WriteLine (g.ToString());
				return false;
			}
			if (g.ToString().Equals("874345a9-2bf9-316e-b1c2-10a0b1ab3ef6"))
				return false;		
			if (g.ToString().Equals("d8a53cda-44d1-3d57-8eef-2c0c562d7aaa"))
				return false;										
			if (g.ToString().Equals("e35af4dd-eb37-39fc-9071-4ce39b1a54be"))
				return false;										
			if (g.ToString().Equals("f3ce7312-70ae-37ff-98f6-cf1dcb22b9e4"))
				return false;										
			if (g.ToString().Equals("6afbf244-9ab3-37d7-b4d4-357a72b76de1"))
				return false;										
			if (g.ToString().Equals("17a355c3-c65e-3f26-8a80-236890ebc997"))
				return false;										
			if (g.ToString().Equals("9e97213a-0b49-3c05-a0bf-d203c4fc8487"))
				return false;										
			if (g.ToString().Equals("d74d613d-f27f-311b-a9a3-27ebc63a1a5d"))
				return false;										
			if (g.ToString().Equals("7fe87a55-1321-3d9f-8fef-cd2f5e8ab2e9"))
				return false;										
			if (g.ToString().Equals("9173d971-b142-38a5-8488-d10a9dcf71b0"))
				return false;										
			if (g.ToString().Equals("48a75519-cb7a-3d18-b91e-be62ee842a3e"))
				return false;										
			if (g.ToString().Equals("ea1cf67d-7904-36a3-bd5b-dd028985861c"))
				return false;										
			if (g.ToString().Equals("50f8ae2b-69f0-37ef-954b-d2618e3e8267"))
				return false;										
			if (g.ToString().Equals("d8e04cc2-f4f5-367d-a23f-f71aff4f14f3"))
				return false;										
*/
			#endregion
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
				if (t.Namespace.Equals("System.Runtime.Remoting"))
					return false;
				if (t.Namespace.Equals("System.Runtime.InteropServices"))
					return false;
				
			}
			return true;
		}
		public BenchmarkSuite getStandart()
		{
			_suite = new BenchmarkSuite();

			/* Funtkionstest der IL Befehle */
		
				RechenBefehle();
				ConvertBefehle();
				BitBefehle();
				LoadBefehle();
			
			/* Benchmarken von ausgesuchten Klassen der BCL */
			#region BCL Funktionen
			
			//AddType (typeof(System.Random));
			//AddType (typeof(System.Object));
			//AddType (typeof(System.NullReferenceException));
			AddType (typeof(System.String));
			AddType(typeof(System.CLSCompliantAttribute));
			#endregion

			return _suite;
		}
		private void LoadBefehle()
		{
			#region Init
			ILFunktion f;
			StandartBenchmark sb;
			int wert1 = 64;
			Int64 wert2 = 32;
			double wert3 = 20;

			#endregion

			#region Load
			//Ldc_I4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4",f);
			_suite.Add (sb);
			//Ldc_I4_0
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_0,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_0",f);
			_suite.Add (sb);
			//Ldc_I4_1
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_1,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_1",f);
			_suite.Add (sb);
			//Ldc_I4_2
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_2,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_2",f);
			_suite.Add (sb);
			//Ldc_I4_3
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_3,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_3",f);
			_suite.Add (sb);
			//Ldc_I4_4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_4,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_4",f);
			_suite.Add (sb);
			//Ldc_I4_5
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_5,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_5",f);
			_suite.Add (sb);
			//Ldc_I4_6
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_6,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_6",f);
			_suite.Add (sb);
			//Ldc_I4_7
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_7,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_7",f);
			_suite.Add (sb);
			//Ldc_I4_8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_8,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_8",f);
			_suite.Add (sb);
			//Ldc_I4_M1
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_M1,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_M1",f);
			_suite.Add (sb);
			//Ldc_I8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I8,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I8",f);
			_suite.Add (sb);
			//Ldc_I4_S
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4_S,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_I4_S",f);
			_suite.Add (sb);
			//Ldc_R4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_R4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_R4",f);
			_suite.Add (sb);
			//Ldc_R8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_R8,wert3));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Ldc_R8",f);
			_suite.Add (sb);
			#endregion
		}

		private void VergleichsBefehle()
		{
		}
		private void SonstigeBefehle()
		{
		}
		private void BranchBefehle()
		{
		}
		private void StoreBefehle()
		{
			#region Init
			ILFunktion f;
			StandartBenchmark sb;
			int wert1 = 64;
			Int64 wert2 = 32;
			double wert3 = 20;

			#endregion

			#region Store
			//Shl
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Shl,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Shl",f);
			_suite.Add (sb);
			#endregion
		}
		private void BitBefehle()
		{
			#region Init
			ILFunktion f;
			StandartBenchmark sb;
			int wert1 = 4;
			int wert2 = 2;
			#endregion

			#region Rechenoperationen
			//And
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.And,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("And",f);
			_suite.Add (sb);
			//Or
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Or,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Or",f);
			_suite.Add (sb);
			//XOR
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Xor,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("XOR",f);
			_suite.Add (sb);
			//NOT
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Not,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("NOT",f);
			_suite.Add (sb);
			//Shl
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Shl,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Shl",f);
			_suite.Add (sb);
			//Shr
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Shr,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Shr",f);
			_suite.Add (sb);
			//Shr_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Shr_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Shr_Un",f);
			_suite.Add (sb);

			#endregion
		}


		private void ConvertBefehle()
		{
			#region Init
			ILFunktion f;
			StandartBenchmark sb;
			int wert1 = 64;
			int wert2 = 32;
			#endregion

			#region Convert
			//Conv_R4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_R4,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_R4",f);
			_suite.Add (sb);
			//Conv_R4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_R8,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_R8",f);
			_suite.Add (sb);
			//Conv_R_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_R_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_R_Un",f);
			_suite.Add (sb);
			//Conv_U
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_U,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_U",f);
			_suite.Add (sb);
			//Conv_U1
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_U1,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_U1",f);
			_suite.Add (sb);
			//Conv_U2
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_U2,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_U2",f);
			_suite.Add (sb);
			//Conv_U4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_U4,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_U4",f);
			_suite.Add (sb);
			//Conv_U8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_U8,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_U8",f);
			_suite.Add (sb);
			//Conv_I
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_I,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_I",f);
			_suite.Add (sb);
			//Conv_I1
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_I1,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_I1",f);
			_suite.Add (sb);
			//Conv_I2
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_I2,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_I2",f);
			_suite.Add (sb);
			//Conv_I4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_I4,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_I4",f);
			_suite.Add (sb);
			//Conv_I8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_I8,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_I8",f);
			_suite.Add (sb);
			//Conv_Ovf_I
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I",f);
			_suite.Add (sb);
			//Conv_Ovf_I1
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I1,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I1",f);
			_suite.Add (sb);
			//Conv_Ovf_I1_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I1_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I1_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_I2
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I2,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I2",f);
			_suite.Add (sb);
			//Conv_Ovf_I2_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I2_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I2_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_I4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I4,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I4",f);
			_suite.Add (sb);
			//Conv_Ovf_I4_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I4_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I4_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_I8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I8,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I8",f);
			_suite.Add (sb);
			//Conv_Ovf_I8_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I8_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I8_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_I_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_I_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_I_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_U
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U",f);
			_suite.Add (sb);
			//Conv_Ovf_U1
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U1,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U1",f);
			_suite.Add (sb);
			//Conv_Ovf_U1_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U1_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U1_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_U2
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U2,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U2",f);
			_suite.Add (sb);
			//Conv_Ovf_U2_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U2_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U2_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_U4
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U4,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U4",f);
			_suite.Add (sb);
			//Conv_Ovf_U4_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U4_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U4_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_U8
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U8,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U8",f);
			_suite.Add (sb);
			//Conv_Ovf_U8_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U8_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U8_Un",f);
			_suite.Add (sb);
			//Conv_Ovf_U_Un
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Conv_Ovf_U_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Conv_Ovf_U_Un",f);
			_suite.Add (sb);
#endregion
		}

		private void RechenBefehle()
		{
			#region Init
			ILFunktion f;
			StandartBenchmark sb;
			int wert1 = 64;
			int wert2 = 32;
			#endregion

			#region Rechenoperationen
			//Add
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Add,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Add",f);
			_suite.Add (sb);
			//Add mit Überlaufprüfung
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Add_Ovf,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Add_Ovf",f);
			_suite.Add (sb);
			//Add mit Überlaufprüfung ohne Vorzeichen
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Add_Ovf_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Add_Ovf_Un",f);
			_suite.Add (sb);
			//Sub
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Sub,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Sub",f);
			_suite.Add (sb);
			//Sub mit Überlaufprüfung
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Sub_Ovf,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Sub_Ovf",f);
			_suite.Add (sb);
			//Sub mit Überlaufprüfung ohne Vorzeichen
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Sub_Ovf_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Sub_Ovf_Un",f);
			_suite.Add (sb);
			//Mul
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Mul,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Mul",f);
			_suite.Add (sb);
			//Mul mit Überlaufprüfung
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Mul_Ovf,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Mul_Ovf",f);
			_suite.Add (sb);
			//Mul mit Überlaufprüfung ohne Vorzeichen
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Mul_Ovf_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Mul_Ovf_Un",f);
			_suite.Add (sb);
			//Div
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Div,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Div",f);
			_suite.Add (sb);
			//Div ohne Vorzeichen
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Div_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Div_Un",f);
			_suite.Add (sb);
			//Rem
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Rem,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Rem",f);
			_suite.Add (sb);
			//Rem ohne Vorzeichen
			f = new ILFunktion();
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert1));
			f.Add(new OpCodeAndValue(OpCodes.Ldc_I4,wert2));
			f.Add(new OpCodeAndValue(OpCodes.Rem_Un,null));
			f.Add(new OpCodeAndValue(OpCodes.Pop,null));
			f.Add(new OpCodeAndValue(OpCodes.Ret,null));
			sb = new StandartBenchmark("Rem_Un",f);
			_suite.Add (sb);

			#endregion
		}


/// <summary>
/// Erstellt für die einzelnen Methoden des angegebenen Typs Benchmark Objekte und fügt diese
/// zum internen _suite Objekt hinzu.
/// </summary>
/// <param name="t">Der Typ dessen Methoden als Benchmark hinzugefügt werden sollen.</param>
		private void AddType(Type t)
		{
			CLSCompliantAttribute kompatibel; //Nur CLS Kompatible Methoden testen

		try 
		{

			foreach (MethodInfo methodInfo in t.GetMethods()) 
			{
				object[] ob = methodInfo.GetCustomAttributes(typeof(CLSCompliantAttribute),true);
				if (ob.Length>0)
				{
					kompatibel = (CLSCompliantAttribute)ob[0];
				} 
				else 
				{
					kompatibel = new CLSCompliantAttribute(true);
				}
				if (kompatibel.IsCompliant)
				{
					if (methodInfo.IsStatic) 
					{	
						BenchStaticBaseClassFunction bclf = new BenchStaticBaseClassFunction();
						bclf.Funktion = methodInfo;
						_suite.Add(bclf);
					} 
					else
					{
						BenchBaseClassFunction bclf = new BenchBaseClassFunction();
						bclf.Funktion = methodInfo;
						_suite.Add(bclf);
					}
				}
			}
		} 
		catch (Exception ex)
		{
			Console.WriteLine (ex.Message);
			Console.WriteLine(ex.StackTrace);
			Console.ReadLine();		
		}
		}
	}
}
