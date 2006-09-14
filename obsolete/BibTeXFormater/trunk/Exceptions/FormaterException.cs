using System;

namespace BibTeX.Formater.Exceptions
{
	/// <summary>
	/// Zusammenfassung für FormaterException.
	/// </summary>
	public class FormaterException : Exception
	{
		public FormaterException(string message) : base (message) {}
	}
}
