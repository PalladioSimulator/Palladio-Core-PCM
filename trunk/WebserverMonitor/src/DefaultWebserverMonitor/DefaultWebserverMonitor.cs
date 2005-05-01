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
	/// Revision 1.11  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.10  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.9  2004/12/08 16:07:12  kelsaka
	/// - added: the webserver halts if the config-file can not be found. To make the webserver
	///  use easier the error-message describes how to set the paths (commandline and VS.NET)
	///
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
			// debug-file:
			// reduced to one access to the webserverConfiguration to keep the Seff simple
			string debugFile = webserverConfiguration.DebugFile;
			try 
			{
				this.debugStreamWriter =  File.AppendText(debugFile);
			}
			catch (SecurityException e)
			{
				Console.WriteLine("ERROR: Not allowed to access the specified file: " + debugFile + ". " + e + ". " + e.StackTrace);
			}
			catch (FileNotFoundException e)
			{
				Console.WriteLine("ERROR: The specified debug-file could not be found. " + 
					"Possible Reasons: The debug-file does not exist OR the configuration-file is not available.\n" + e + e.StackTrace);
			}
			catch (Exception e)
			{
				Console.WriteLine("ERROR: Error on accessing File " + debugFile + ". " + e + ". " + e.StackTrace);
			}


			//log-file:
			string logFile = webserverConfiguration.LogFile;
			try 
			{
				this.logStreamWriter =  File.AppendText(logFile);
			}
			catch (SecurityException e)
			{
				Console.WriteLine("ERROR: Not allowed to access the specified file: " + logFile + ". " + e + ". " + e.StackTrace);
			}
			catch (Exception e)
			{
				Console.WriteLine("ERROR: Error on accessing File " + logFile + ". " + e + ". " + e.StackTrace);
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
			try 
			{
				debugMessage = "Level: " + debugLevel + " | " + debugMessage;

				debugStreamWriter.WriteLine(DateTime.Now.Ticks + " | " + debugMessage);
				debugStreamWriter.Flush();
				Debug.WriteLine("! DEBUG: " + debugMessage);
				Console.WriteLine("! DEBUG: " + debugMessage);
			}
			catch (Exception e)
			{
				Console.WriteLine("ERROR: Could not write to the debugfile: " + debugMessage + " (More information: " + e.Message + "\n" + e.StackTrace + ")");
			}
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
