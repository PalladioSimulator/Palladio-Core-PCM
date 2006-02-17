using System;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Enumeration of string value delimiters
	/// </summary>
	public enum StringValueType
	{
		UNQUOTED,
		QUOTED,
		BRACED
	}

	/// <summary>
	/// Enumeration of log levels
	/// </summary>
	public enum LogType
	{
		INFO,
		WARNING,
		ERROR,
		FATAL
	}

	/// <summary>
	/// Enumeration of all possible entry types in a bib file. Currently supported are
	/// comment, preamble, string-macros and regular entries
	/// </summary>
	public enum EntryType
	{
		COMMENT,
		PREAMBLE,
		MACRO,
		REGULAR
	}
}
