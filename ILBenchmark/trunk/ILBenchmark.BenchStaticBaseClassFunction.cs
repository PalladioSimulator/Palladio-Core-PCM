using System;
using System.Reflection;
using System.Reflection.Emit;
using System.Threading;


namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für BenchAssembly.
	/// </summary>
	public class BenchStaticBaseClassFunction : Benchmark
	{
		private MethodInfo _mi;

		public BenchStaticBaseClassFunction()
		{
			this._name = "BenchBaseClassFunction";
		}

		override public bool AssembleCode()
		{

			
			//AppDomainSetup info = new AppDomainSetup();
			//info.ApplicationBase = System.Environment.CurrentDirectory;
			//AppDomain dom = AppDomain.CreateDomain("RemoteDomain", null,info);
			AppDomain dom = AppDomain.CurrentDomain;

			ParameterInfo[] p = _mi.GetParameters();
			Type[] pa = new Type[p.Length];
			for (int i=0; i<p.Length;i++)
			{
				pa[i] = p[i].ParameterType ;
			}
			//AppDomain myDomain = dom;
			//AppDomain myDomain = Thread.GetDomain();
			
			AssemblyName myAsmName = new AssemblyName();
			myAsmName.Name = _mi.Name;
		
			AssemblyBuilder myAsmBuilder = dom.DefineDynamicAssembly(
				myAsmName,
				AssemblyBuilderAccess.RunAndSave);
			
			ModuleBuilder myModBuilder = myAsmBuilder.DefineDynamicModule(
				_mi.Name,_mi.Name + ".exe");

			TypeBuilder myTypeBuilder = myModBuilder.DefineType("Bench",
				TypeAttributes.Public,typeof(MarshalByRefObject));
			MethodBuilder myMthdBuilder = myTypeBuilder.DefineMethod("Execute", 
				MethodAttributes.Public |
				MethodAttributes.Static,_mi.ReturnType,pa);  //typeof(_mi.ReturnType),para);
				
			ILGenerator myIL = myMthdBuilder.GetILGenerator();
			TypeUndIL t = new TypeUndIL();
			t.Builder = myTypeBuilder;
			t.Generator = myIL;
			t.AsmBuilder = myAsmBuilder;
			_til = t;


			for (int i=0;i<pa.Length;i++)
			{
				myIL.Emit(OpCodes.Ldarg,i);
			}
			myIL.EmitCall(OpCodes.Call,_mi,null); 
			//myIL.Emit(OpCodes.Pop);
			myIL.Emit(OpCodes.Ret);
			this._type = myTypeBuilder.CreateType();
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
				this._name = _mi.Name + ".exe";
				this._fullname= _mi.DeclaringType.FullName + "." + _mi.Name;
			}
		}
	}
}
