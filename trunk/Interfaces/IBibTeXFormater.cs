using System;
using System.IO;
using BibTeX.Parser.Interfaces;
using Options.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Formater.Interfaces
{
	/// <summary>
	/// Zusammenfassung für ILogLevelFormater.
	/// </summary>
	public interface IBibTeXFormater
	{
		IOptions Options
		{
			get;
		}

		string FormatToString (IVisitable node);
		void FormatToStream (TextWriter streamWriter, IVisitable node);
	}
}
