using System;
using System.IO;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;

namespace BibTeX.Formater.Formater.Default
{
	/// <summary>
	/// Zusammenfassung für BibTexFileFormater.
	/// </summary>
	internal class DefaultBibTexFileFormater : IFormatable
	{
		protected IBibTeXFile file;
		protected IFormaterFactory formaterFactory;

		public DefaultBibTexFileFormater(IBibTeXFile file, IFormaterFactory formaterFactory)
		{
			this.file = file;
			this.formaterFactory = formaterFactory;
		}

		public void FormatToStream(TextWriter TextWriter)
		{
			foreach (IEntry e in file.Entries)
			{
				formaterFactory.GetEntryFormater(e).FormatToStream(TextWriter);
				TextWriter.WriteLine();
			}
		}
	}
}
