using System;
using Palladio.Webserver.Request;

namespace Palladio.Webserver.HTTPRequestProcessor
{
	/// <summary>
	/// IHTTPRequestProcessor.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.2  2004/10/22 12:55:56  kelsaka
	/// Actualised the UML-componentview; defined the webserverfactory-interface, therefore added some new interfaces
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IHTTPRequestProcessor
	{
		

		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		void handleRequest(IHTTPRequest httpRequest);
	}
}
