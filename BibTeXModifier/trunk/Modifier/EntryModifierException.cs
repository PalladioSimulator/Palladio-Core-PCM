using System;

namespace BibTeX.Parser.Modifier
{
	/// <summary>
	/// Zusammenfassung für EntryModifierException.
	/// </summary>
	public class EntryModifierException : ModifierException
	{
		public EntryModifierException(String text, Exception ex) : base (text,ex)
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}
	}
}
