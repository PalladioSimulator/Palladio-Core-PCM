using System;

namespace BibTeX.Parser.Interfaces
{
	public class LogEventArgs
	{
		private string message;
		private LogType type;

		public string Message
		{
			get 
			{
				return message;
			}
		}

		public LogType Type
		{
			get
			{
				return type;
			}
		}

		public LogEventArgs(LogType type, string message)
		{
			this.message = message;
			this.type = type;
		}

		public override string ToString()
		{
			string result = "";

			switch (type)
			{
				case LogType.ERROR:
					result = "ERROR";
					break;
				case LogType.FATAL:
					result = "FATAL";
					break;
				case LogType.INFO:
					result = "INFO";
					break;
				case LogType.WARNING:
					result = "WARNING";
					break;
			}
			return result + ": " + message + Environment.NewLine;
		}
	}

	public delegate void LogEventHandler (object sender, LogEventArgs ev);

}
