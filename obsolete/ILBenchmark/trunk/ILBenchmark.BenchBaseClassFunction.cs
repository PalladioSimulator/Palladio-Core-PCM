using System;
using System.Reflection;
using System.Reflection.Emit;
using System.Threading;
using System.Configuration.Assemblies;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für BenchAssembly.
	/// </summary>
	public class BenchBaseClassFunction : Benchmark
	{
		private MethodInfo _mi;

		public BenchBaseClassFunction()
		{
			this._name = "BenchBaseClassFunction";
		}

		override public bool AssembleCode()
		{
			int cI;
			int x;
			int constructorIndex=0;


			//AppDomainSetup info = new AppDomainSetup();
			//info.ApplicationBase = System.Environment.CurrentDirectory;
			//AppDomain dom = (AppDomain)AppDomain.CurrentDomain.DoCallBack(
			AppDomain dom = AppDomain.CurrentDomain;

			ParameterInfo[] p = _mi.GetParameters();
			Type rt = _mi.ReflectedType;
			ConstructorInfo[] cInf = rt.GetConstructors();
			if (cInf.Length ==0)
				return false;
			CLSCompliantAttribute kompatibel;

			for (int i=0;i<cInf.Length;i++) //Gucken ob der Konstruktor CLS kompatibel ist
			{
				object[] ob = cInf[i].GetCustomAttributes(typeof(CLSCompliantAttribute),true);
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
					constructorIndex = i;
					break;
				}
			}
			ParameterInfo[] cp = cInf[constructorIndex].GetParameters();
			Type[] pa = new Type[p.Length + cp.Length];
			for (x=0;x<cp.Length;x++)
			{
				pa[x] = cp[x].ParameterType;
			}
			for (int i=0; i<p.Length;i++)
			{
				pa[x+i] = p[i].ParameterType ;
			}

			//AppDomain myDomain = AppDomain.CurrentDomain; //Thread.GetDomain();
			//AppDomain myDomain = dom;
			//myDomain.CreateInstance("Benchmark","Benchmark.Bench");	
			
			AssemblyName myAsmName = new AssemblyName();
			myAsmName.Name =  _mi.Name;
			myAsmName.Version = new Version("1.0.0.0");
			myAsmName.HashAlgorithm =  AssemblyHashAlgorithm.SHA1;

			AssemblyBuilder myAsmBuilder = dom.DefineDynamicAssembly(
				myAsmName,AssemblyBuilderAccess.RunAndSave); 
			
				//AssemblyBuilderAccess.RunAndSave);
			//myAsmBuilder.DefineVersionInfoResource();
			ModuleBuilder myModBuilder = myAsmBuilder.DefineDynamicModule(_mi.Name + ".dll");

			TypeBuilder myTypeBuilder = myModBuilder.DefineType("Bench",
				TypeAttributes.Public,typeof(MarshalByRefObject));
			MethodBuilder myMthdBuilder = myTypeBuilder.DefineMethod("Execute", 
				MethodAttributes.Public | MethodAttributes.Static,_mi.ReturnType,pa);  //typeof(_mi.ReturnType),para);
				
			ILGenerator myIL = myMthdBuilder.GetILGenerator();
			TypeUndIL t = new TypeUndIL();
			t.Builder = myTypeBuilder;
			t.Generator = myIL;
			t.AsmBuilder = myAsmBuilder;
			_til = t;

			myIL.DeclareLocal(_mi.DeclaringType);
			//Typen des rt Constructors rausfinden
			//Diese als lokale Variablen deklariern und mit werten laden
			//for (int b=0;b<cInf.Length;b++)
			{
				ParameterInfo[] cPara = cInf[constructorIndex].GetParameters(); //Parameter des Constructors holen
				for (cI=0;cI<cPara.Length;cI++) //Soviele Parameter wie der Constructor hat auf den Stack legen
				{
					myIL.Emit(OpCodes.Ldarg,cI);
				}
			}
			try 
			{
				myIL.Emit(OpCodes.Newobj,cInf[constructorIndex]);
				//myIL.Emit(OpCodes.Newobj,rt.GetConstructor(new Type[0]));
			} 
			catch (Exception ex)
			{
				//System.Diagnostics.Debug.WriteLine(ex);
				return false;
			}
			myIL.Emit(OpCodes.Stloc_0);
			myIL.Emit(OpCodes.Ldloc_0);
			for (int i=cI;i<pa.Length;i++)
			{
				myIL.Emit(OpCodes.Ldarg,i);
			}
			myIL.EmitCall(OpCodes.Call,_mi,null); 
			//			else
			//				myIL.EmitCall(OpCodes.Callvirt,_mi,null);

			myIL.Emit(OpCodes.Ret);
			this._type = myTypeBuilder.CreateType();
			cInf = null;
			rt=null;
			cp=null;
			pa=null;
			p=null;
			myIL = null;
			myMthdBuilder = null;
			//myAsmBuilder = null;
			//myAsmName=null;
			//myDomain=null;
			myModBuilder = null;
			myTypeBuilder=null;
			_mi=null;
			//Console.WriteLine(_mi.Name);
			return true;
		}

		public MethodInfo Funktion
		{
			get { return _mi; }
			set 
			{
				_mi = value;
				this._name = _mi.Name + ".dll"; 
				this._fullname= _mi.DeclaringType.FullName + "." + _mi.Name;
			}
		}
	}
}
