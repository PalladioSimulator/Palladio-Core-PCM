using System;

namespace Palladio.Webserver.WebserverFactory
{
	/// <summary>
	/// IWebserverFactory.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IWebserverFactory
	{

		/// <summary>
		/// Returns whether a type can be used as a provides-component for the given component
		/// </summary>
		/// <param name="type">The type to check for compatiblity.</param>
		/// <returns>True, if the type can be used as a provides-component.</returns>
		//bool isAttachable (Type type);




	}
}
