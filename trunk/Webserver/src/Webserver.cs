using System;

namespace Palladio.Webserver
{
	/// <summary>
	/// Webserver.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/10/22 09:37:19  kelsaka
	/// minor changes
	///
	///
	/// </pre>
	/// </remarks>
	public class Webserver
	{
		public Webserver()
		{

		}

		/// <summary>
		/// Main webserver-application start.
		/// </summary>
		public static void Main() 
		{
			DefaultWebserver webserver = new DefaultWebserver();
			webserver.Run();
		}

	}
}
