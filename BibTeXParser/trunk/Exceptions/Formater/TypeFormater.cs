using System;
using BibTeX.Parser.Interfaces;

namespace BibTeX.Parser.Formater
{
	/// <summary>
	/// Zusammenfassung für TypeFormater.
	/// </summary>
	public class TypeFormater
	{
		public TypeFormater()
		{
		}
		
		public static string FormatLogType (LogType type)
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

			return result;
		}
	}

}

