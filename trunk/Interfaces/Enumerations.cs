using System;

namespace BibTeX.Formater.Interfaces
{
	public enum FieldDelimiterChar
	{
		BRACES,
		QUOTES,
		ORIGINAL
	}

	public enum FieldTabPositions
	{
		NONE,
		BFORE,
		BETWEEN,
		BOTH
	}

	public enum FieldIDCasing
	{
		UPPER,
		LOWER,
		KEEP
	}
}
