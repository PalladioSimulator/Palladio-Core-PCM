using System;

namespace MySmallWebServer
{
	/// <summary>
	/// The Http_1_0 protocol.
	/// </summary>
	public class Http_1_0 : AbstractHttpProtocol
	{
		/// <summary>
		/// The empty constructor for this class
		/// </summary>
		public Http_1_0()
		{
		}


		/// <summary>
		/// Retruns the protocoltype as <code>string</code>
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			return "HTTP/1.0";
		}

	}
}
