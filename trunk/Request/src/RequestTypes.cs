namespace Palladio.Webserver
{
	/// <summary>
	/// RequestTypes.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.2  2004/11/21 17:10:03  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.1  2004/11/01 07:42:16  kelsaka
	/// *** empty log message ***
	///
	/// </pre>
	/// </remarks>
	public class RequestTypes
	{
		/// <summary>
		/// Enumeration of HTTP-Method-Type
		/// </summary>
		public enum HTTPMethodType
		{
			GET_METHOD,
			POST_METHOD
		}

	}
}
