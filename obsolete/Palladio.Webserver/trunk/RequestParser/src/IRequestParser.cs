using System;
using Palladio.Webserver.Request;

namespace Palladio.Webserver.RequestParser
{
	/// <summary>
	/// IRequestParser. Interface that has to be implemented by all links of the parser
	/// chain of responsibility (COR). If a link cannot handle a request this interface is used to
	/// call the COR-Successor.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.3  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.2  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IRequestParser
	{

		/// <summary>
		/// Starts the Parsing-Process of the given request.
		/// </summary>
		/// <param name="request">The request that is going to be parsed.</param>
		void HandleRequest(IRequest request);

	}
}
