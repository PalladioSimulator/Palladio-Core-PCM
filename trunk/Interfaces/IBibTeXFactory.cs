using System;
using System.IO;
using BibTeX.Parser.Exceptions;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Factory Pattern to build Elements of the BibTeX Type hierachy
	/// </summary>
	public interface IBibTeXFactory
	{
		/// <summary>
		/// Create a bibtex object tree hierarchy from a bibtex file in the given stream
		/// </summary>
		/// <param name="input">The text stream to read from</param>
		/// <returns>The bibtex file as object tree</returns>
		/// <exception cref="BibTeXParserException">In case the parser finds some unexpected input in the stream</exception>
		IBibTeXFile CreateBibTeXFileFromStream(TextReader input);
		
		/// <summary>
		/// Create a bibtex object tree hierarchy from a bibtex file in the given filename
		/// </summary>
		/// <param name="filename">The filename of the file to read the input from</param>
		/// <returns>The bibtex file as object tree</returns>
		/// <exception cref="BibTeXParserException">In case the parser finds some unexpected input in the stream</exception>
		IBibTeXFile CreateBibTeXFileFromLocalFile(string filename);

		/// <summary>
		/// An ID for the stream to be read. The stream ID is used in the parser events to
		/// identify the stream
		/// </summary>
		string StreamID
		{
			get; set;
		}

		/// <summary>
		/// An event handler for parser warnings or error messages
		/// </summary>
		event LogEventHandler LogEvent;
	}
}
