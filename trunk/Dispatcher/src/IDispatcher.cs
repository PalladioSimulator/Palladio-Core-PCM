using System;

namespace Palladio.Webserver.Dispatcher
{
	/// <summary>
	/// IDispatcher.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IDispatcher
	{

		/// <summary>
		/// Starts the dispatcher which is using threads to handle requests. This means that the webserver starts
		/// listening at the defined ports.
		/// </summary>
		void Run();


		/// <summary>
		/// Stops the dispatcher. This includes the service of the webserver.
		/// </summary>
		void Stop();



	}
}
