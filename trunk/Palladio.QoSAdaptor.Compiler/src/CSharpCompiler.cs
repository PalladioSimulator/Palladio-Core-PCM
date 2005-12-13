#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.CodeDom.Compiler;
using System.Collections.Specialized;
using Microsoft.CSharp;

namespace Palladio.QoSAdaptor.Compiler
{
	/// <summary>
	/// CSharp compiler used to automatically compile the generated adaptor
	/// source files to an applicable assembly.
	/// 
	/// Most of the code of this compiler was taken from the VS.NET example
	/// at: http://www.codeproject.com/dotnet/CodeFromCode.asp
	/// </summary>
	public class CSharpCompiler : ICSharpCompiler
	{
		#region attributes
		// Files to compile
		protected StringCollection mFilesToCompile =  new 
			System.Collections.Specialized.StringCollection();

		// Referenced assemblies
		protected StringCollection mImportedDlls = new StringCollection();

		// Compiler output
		protected CompilerResults mCSharpCompilerResults;

		// Compiler errors
		protected CompilerErrorCollection mCSharpCompilerErrors;
		// Compiler parameters
		protected CompilerParameters mCSharpCompilerParameters = new 
			CompilerParameters();
		#endregion
	
		#region constructor
		/// <summary>
		/// Creates a new CSharpCompiler. Before the Compile() method is 
		/// called, FilesToCompile and, if needed, the other properties have to 
		/// be set. 
		/// </summary>
		public CSharpCompiler()
		{
			mFilesToCompile = new StringCollection();
		}
		#endregion

		#region properties
		/// <summary>
		/// The files that need to be compiled
		/// </summary>
		public StringCollection FilesToCompile
		{
			get
			{
				return mFilesToCompile;
			}
			set
			{
				mFilesToCompile = value;
			}
		}
		
		/// <summary>
		/// Parameters that shall be given to the compiler.
		/// </summary>
		public CompilerParameters CSharpCompilerParameters
		{
			get
			{
				return mCSharpCompilerParameters;
			}
			set
			{
				mCSharpCompilerParameters = value;
			}
		}
		
		/// <summary>
		/// Returns compiler errors
		/// </summary>						  
		public CompilerErrorCollection MCSharpCompilerErrors
		{
			get
			{
				return mCSharpCompilerErrors;
			}
		}

		/// <summary>
		/// Returns the results of the compiler
		/// </summary>
		public CompilerResults MCSharpCompilerResults
		{
			get
			{
				return mCSharpCompilerResults;
			}
		}

		/// <summary>
		/// Dlls that are needed to compile the source files.
		/// </summary>
		public StringCollection ImportedDlls
		{
			get
			{
				return mImportedDlls;
			}
			set
			{
				mImportedDlls = value;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Compiles the given source files. 
		/// </summary>
		/// <returns>The results of the compilation.</returns>
		public CompilerResults Compile()
		{
			CSharpCodeProvider oCSharpCodeProvider = new CSharpCodeProvider();
			ICodeCompiler oCSharpCodeCompiler;
			CompilerResults oCSharpCompilerResults;

			oCSharpCodeCompiler = oCSharpCodeProvider.CreateCompiler();

			foreach (string oDll in mImportedDlls)
				mCSharpCompilerParameters.ReferencedAssemblies.Add(oDll);

			string[] oFiles = new string[mFilesToCompile.Count];
			mFilesToCompile.CopyTo(oFiles, 0);
			oCSharpCompilerResults = oCSharpCodeCompiler.
				CompileAssemblyFromFileBatch(mCSharpCompilerParameters, oFiles);
			mCSharpCompilerResults = oCSharpCompilerResults;

			/*Console.WriteLine("---------------------------------");
			Console.WriteLine("COMPILER OUTPUT: ");
			Console.WriteLine("---------------------------------");
			foreach (string oOut in oCSharpCompilerResults.Output)
				Console.WriteLine(oOut);*/

			/*Console.WriteLine("---------------------------------");
			Console.WriteLine("COMPILER ERRORS: "+oCSharpCompilerResults.Errors.Count);
			Console.WriteLine("---------------------------------");*/
			mCSharpCompilerErrors = oCSharpCompilerResults.Errors;
			string ErrorLog = "";
			foreach (CompilerError oCSharpCompilerError in 
				oCSharpCompilerResults.Errors)
			{
				ErrorLog += oCSharpCompilerError.ToString() + "\n";
			}
			if (oCSharpCompilerResults.Errors.Count > 0)
				throw new Exception("The compiler has thrown the following errors:" +
                 "\n" + ErrorLog);

			return oCSharpCompilerResults;
		}
		#endregion
	}
}
