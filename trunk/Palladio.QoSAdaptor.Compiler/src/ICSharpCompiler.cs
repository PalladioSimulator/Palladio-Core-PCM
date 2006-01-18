
using System.CodeDom.Compiler;
using System.Collections.Specialized;

namespace Palladio.QoSAdaptor.Compiler
{
	/// <summary>
	/// The C# compiler interfaces provided by the Palladio.QoSAdaptor.Compiler
	/// component. 
	/// </summary>
	public interface ICSharpCompiler
	{
		/// <summary>
		/// Property to get and set the source files of the compiler. 
		/// </summary>
		StringCollection FilesToCompile{get; set;}

		/// <summary>
		/// Property to get and set the parameters of the compiler.
		/// </summary>
		CompilerParameters CSharpCompilerParameters{get; set;}

		/// <summary>
		/// Property to get compiler errors.
		/// </summary>
		CompilerErrorCollection MCSharpCompilerErrors{get;}

		/// <summary>
		/// Property to get the results of the compiler.
		/// </summary>
		CompilerResults MCSharpCompilerResults{get;}

		/// <summary>
		/// Property to get and set the DLLs needed to compile the given 
		/// source files.
		/// </summary>
		StringCollection ImportedDlls {get; set;}

		/// <summary>
		/// Starts the compilation process. Before this method is called, 
		/// the files to compile have to be set and the needed dll and other
		/// needed compiler parameters have to be set.
		/// </summary>
		/// <returns>The results of the compilation.</returns>
		CompilerResults Compile();
	}
}
