using System;
using System.Reflection;
using System.Reflection.Emit;
using System.Threading;
using System.Configuration.Assemblies;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für Helper.
	/// </summary>
	public class Helper
	{
		private AppDomain _dom;
		//private AssemblyBuilder _myAsmBuilder;

		public Helper(ref AppDomain dom)
		{
			_dom = dom;
			//_myAsmBuilder = myAsmBuilder;
		}

		public TypeUndIL getTIL(string name)
		{
			//AppDomain myDomain = Thread.GetDomain();
			//AppDomain myDomain = _dom;
			
			AssemblyName myAsmName = new AssemblyName();
			myAsmName.Name =  name;
			myAsmName.Version = new Version("1.0.0.0");
			myAsmName.HashAlgorithm =  AssemblyHashAlgorithm.SHA1;

			AssemblyBuilder myAsmBuilder = _dom.DefineDynamicAssembly(
				myAsmName,AssemblyBuilderAccess.RunAndSave); 
				
			ModuleBuilder myModBuilder = myAsmBuilder.DefineDynamicModule(
				name,name + ".exe");

			TypeBuilder myTypeBuilder = myModBuilder.DefineType("Bench",
				TypeAttributes.Public);
			MethodBuilder myMthdBuilder = myTypeBuilder.DefineMethod("Execute", 
				MethodAttributes.Public |
				MethodAttributes.Static,typeof(void),null);
				
			ILGenerator myIL = myMthdBuilder.GetILGenerator();
			TypeUndIL t = new TypeUndIL();
			t.Builder = myTypeBuilder;
			t.Generator = myIL;
			t.AsmBuilder = myAsmBuilder;
			return t;

		}
	}
	/// <summary>
	/// Hilfsstruktur die einen ILGenerator und einen TypeBuilder speichert
	/// </summary>
	public struct TypeUndIL
	{
		private ILGenerator gen;
		private TypeBuilder tb;
		private AssemblyBuilder asb;

		public ILGenerator Generator
		{
			get { return gen; }
			set { gen = value; }
		}
		public TypeBuilder Builder
		{
			get { return tb; }
			set { tb = value; }
		}
		public AssemblyBuilder AsmBuilder
		{
			get { return asb; }
			set { asb = value; }
		}
	}
}
