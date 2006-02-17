using System;

namespace BibTeX.Parser.Modifier
{
	/// <summary>
	/// Zusammenfassung für ModifierException.
	/// </summary>
	public class ModifierException : Exception
	{
		public ModifierException(string text, Exception ex) : base (text,ex)
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}
	}
}
