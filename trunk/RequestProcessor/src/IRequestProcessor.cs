using System;

namespace Palladio.Webserver.RequestProcessor
{
	/// <summary>
	/// IRequestProcessor. General request-processor-interface.
	/// Note: for HTTP-request-processing use the IHTTPRequestProcessor.
	/// </summary>
	/// <remarks>
	/// Currently this interface is not used. If ever e. g. FTP-support is going to be
	/// implemented this interface should be the basic interface of all request processors.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.2  2005/01/07 16:58:02  kelsaka
	/// Added TimeConsumingProcessor including its documentation and configuration.
	/// Integrated the new processor into the COR.
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IRequestProcessor
	{


	}
}
