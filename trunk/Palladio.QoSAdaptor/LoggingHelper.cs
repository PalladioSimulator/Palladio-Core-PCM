using System;
using log4net.Appender;
using log4net.Core;

namespace Palladio.QoSAdaptor
{
	/// <summary>
	/// Contains some static methods to make logging with log4net on the
	/// server or client side easier.
	/// 
	/// This class has been copied from the software developed by Rico Starke
	/// in the context of his diploma thesis "Untersuchung des Trade-Offs 
	/// zwischen Performanz und Wartbarkeit von Persistenz-Frameworks für .NET".
	/// 
	/// Small changes have been made due to the changes in the log4net 
	/// framework from version 1.2.0 to 1.2.9.
	/// </summary>
	public class LoggingHelper
	{

		/// <summary>
		/// Stores all events that have been written to the given <see cref="log4net.Appender.MemoryAppender"/>
		/// to a file. If the file already exists, it is overwritten.
		/// </summary>
		/// <param name="ma"><see cref="log4net.Appender.MemoryAppender"/> containing the desired log events</param>
		/// <param name="fileName">name of the file</param>
		public static void SaveLogAppenderDataToDisk(MemoryAppender ma, string fileName)
		{
			SaveLogAppenderDataToDisk(ma, fileName, false);
		}

		/// <summary>
		/// Stores all events that have been written to the given <see cref="log4net.Appender.MemoryAppender"/>
		/// to a file.
		/// </summary>
		/// <param name="ma"><see cref="log4net.Appender.MemoryAppender"/> containing the desired log events</param>
		/// <param name="fileName">name of the file</param>
		/// <param name="append">defines whether the log events should be appended to
		/// the file (<c>true</c>) or if a new file should be created (<c>false</c>)</param>
		public static void SaveLogAppenderDataToDisk(MemoryAppender ma, string fileName, bool append)
		{
			System.IO.StreamWriter sw = new System.IO.StreamWriter(fileName, append);
			foreach (LoggingEvent e in ma.GetEvents())
			{
				sw.WriteLine(e.RenderedMessage);
			}
			sw.Close();
		}

	}
}
