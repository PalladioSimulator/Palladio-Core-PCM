using System;
using System.IO;
using System.Security;
using Palladio.Webserver.ConfigReader;
using WebserverXML;

namespace Palladio.Webserver.WebserverMonitor
{
	/// <summary>
	/// DefaultWebserverMonitor.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.5  2004/10/24 06:17:11  kelsaka
	/// -
	///
	/// Revision 1.4  2004/10/23 14:08:36  kelsaka
	/// first steps on reading xml-config-files
	///
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 09:37:19  kelsaka
	/// minor changes
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultWebserverMonitor : IWebserverMonitor
	{

		private IWebserverConfiguration webserverConfiguration;
		private FileStream debugFileStream;
		private FileStream logFileStream;

		public DefaultWebserverMonitor(IWebserverConfiguration webserverConfiguration)
		{
			this.webserverConfiguration = webserverConfiguration;


		}


		/// <summary>
		/// Prepares the write access (e. g. file handles) for further access.
		/// </summary>
		public void InitializeWriteAccess ()
		{
			//debug-file:
			try 
			{
				this.debugFileStream =  new FileStream(webserverConfiguration.DebugFile,
					FileMode.Open, FileAccess.Write, FileShare.Write);
			}
			catch (SecurityException e)
			{
				Console.WriteLine("ERROR: Not allowed to access the specified file: " + webserverConfiguration.DebugFile + ". " + e + ". " + e.StackTrace);
			}
			catch (Exception e)
			{
				Console.WriteLine("ERROR: Error on accessing File " + webserverConfiguration.DebugFile + ". " + e + ". " + e.StackTrace);
			}


			//log-file:
			try 
			{
				this.logFileStream =  new FileStream(webserverConfiguration.DebugFile,
					FileMode.Open, FileAccess.Write, FileShare.Write);
			}
			catch (SecurityException e)
			{
				Console.WriteLine("ERROR: Not allowed to access the specified file: " + webserverConfiguration.DebugFile + ". " + e + ". " + e.StackTrace);
			}
			catch (Exception e)
			{
				Console.WriteLine("ERROR: Error on accessing File " + webserverConfiguration.DebugFile + ". " + e + ". " + e.StackTrace);
			}

			
		}

		/// <summary>
		/// Closes e. g. file handles and commits changes. Execute finally.
		/// </summary>
		public void FinishWriteAccess ()
		{
			debugFileStream.Close();
			logFileStream.Close();
		}

		public void WriteDebugMessage (string debugMessage, int debugLevel)
		{
			if(debugFileStream.CanWrite)
			{
				//debugFileStream.		
			}
			else
			{
				Console.WriteLine("ERROR: Can not write Debug-Logfile.");
			}
//TODO:

		}

		public void WriteLogEntry (string logMessage)
		{
			if(debugFileStream.CanWrite)
			{
				
			}
			else
			{
				Console.WriteLine("ERROR: Can not write Logfile.");
			}


		}
	}
}
