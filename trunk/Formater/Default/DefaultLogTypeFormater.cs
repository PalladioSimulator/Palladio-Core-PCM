using System;
using System.IO;
using BibTeX.Formater.Interfaces;
using BibTeX.Parser.Interfaces;

namespace BibTeX.Formater.Formater.Default
{
	/// <summary>
	/// Zusammenfassung für LogLevelF.
	/// </summary>
	internal class DefaultLogTypeFormater : IFormatable
	{
		protected LogType type;

		public DefaultLogTypeFormater (LogType type)
		{
			this.type = type;
		}

		public void FormatToStream(TextWriter TextWriter)
		{
			switch (type)
			{
				case LogType.ERROR:
					TextWriter.Write("ERROR");
					break;
				case LogType.FATAL:
					TextWriter.Write("FATAL");
					break;
				case LogType.INFO:
					TextWriter.Write("INFO");
					break;
				case LogType.WARNING:
					TextWriter.Write("WARNING");
					break;
			}
		}
	}
}
