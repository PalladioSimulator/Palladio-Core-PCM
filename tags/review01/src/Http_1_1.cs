using System;

namespace MySmallWebServer
{
	/// <summary>
	/// The Http_1_1 protocol
	/// </summary>
	public class Http_1_1 : AbstractHttpProtocol
	{
		/// <summary>
		/// Initaes an empty protocol
		/// </summary>
		public Http_1_1()
		{
		}


		/// <summary>
		/// The protocol as <code>string</code> representation
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			return "HTTP/1.1";
		}

	}
}
