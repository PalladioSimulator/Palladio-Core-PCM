using System;

namespace BibTeX.Parser.Exceptions
{
	/// <summary>
	/// Exception thrown by the bibtex parser when finding non compliant bibtex
	/// </summary>
	public class BibTeXParserException : Exception
	{
		/// <summary>
		/// An bibtex parser exception
		/// </summary>
		/// <param name="text">A note for the type of the excpetion</param>
		public BibTeXParserException(string text):base(text)
		{}

		/// <summary>
		/// A bibtex parser exception
		/// </summary>
		/// <param name="text">A note for the type of the exception</param>
		/// <param name="chainedException">An inner excpetion</param>
		public BibTeXParserException(string text, Exception chainedException) : base(text, chainedException)
		{}
	}
}
