using System;
using Palladio.Webserver.WebserverFactory;

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
	/// Revision 1.2  2004/10/22 09:52:43  kelsaka
	/// extended xml-config-files by logging-file-definitions
	///
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
			Webserver webserver = new Webserver();
			webserver.Run();
		}


		/// <summary>
		/// Builds and starts a running webserver using the webserver-factory.
		/// </summary>
		public void Run()
		{
			DefaultWebserverFactory webserverFactory = new DefaultWebserverFactory();

		}
	}
}
