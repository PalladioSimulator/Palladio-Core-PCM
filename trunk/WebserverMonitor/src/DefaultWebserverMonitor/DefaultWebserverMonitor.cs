using System;
using System.Diagnostics;
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
	/// Revision 1.8  2004/10/30 15:24:39  kelsaka
	/// webserverMonitor-Output on console; documentation (doc) update
	///
	/// Revision 1.7  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
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
		private StreamWriter debugStreamWriter;
		private StreamWriter logStreamWriter;

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
				this.debugStreamWriter =  File.AppendText(webserverConfiguration.DebugFile);
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
				this.logStreamWriter =  File.AppendText(webserverConfiguration.LogFile);
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
			debugStreamWriter.Close();
			logStreamWriter.Close();
		}


		/// <summary>
		/// Method to write debug-messages to the debug-file (see xml-config-file). Another output is put to the debug-console.
		/// </summary>
		/// <param name="debugMessage">The message to display.</param>
		/// <param name="debugLevel">How critical is the message. Use "0" for important and "5" for less
		/// important messages.</param>
		public void WriteDebugMessage (string debugMessage, int debugLevel)
		{
			debugMessage = "Level: " + debugLevel + " | " + debugMessage;

			debugStreamWriter.WriteLine(DateTime.Now.Ticks + " | " + debugMessage);
			debugStreamWriter.Flush();
			Debug.WriteLine("! DEBUG: " + debugMessage);
			Console.WriteLine("! DEBUG: " + debugMessage);
		}


		/// <summary>
		/// Writes general loginformations to the specified file. Displays the output as well on the console.
		/// </summary>
		/// <param name="logMessage">The message to write.</param>
		public void WriteLogEntry (string logMessage)
		{
			logStreamWriter.WriteLine(DateTime.Now.Ticks + " | " + logMessage);
			logStreamWriter.Flush();
			Console.WriteLine(logMessage);
		}


	}
}
