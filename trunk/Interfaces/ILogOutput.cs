using System;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Zusammenfassung für ILogOutput.
	/// </summary>
	public interface ILogOutput
	{
		void LogMessage(LogType type, string message);
	}
}
