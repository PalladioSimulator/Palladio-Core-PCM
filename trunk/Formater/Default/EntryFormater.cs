using System;
using System.IO;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;

namespace BibTeX.Formater.Formater.Default
{
	/// <summary>
	/// Zusammenfassung für BibTexFileFormater.
	/// </summary>
	internal class DefaultEntryFormater : IFormatable
	{
		protected IEntry entry;
		protected IFormaterFactory formaterFactory;

		public DefaultEntryFormater(IEntry entry, IFormaterFactory formaterFactory)
		{
			this.entry = entry;
			this.formaterFactory = formaterFactory;
		}

		public void FormatToStream(TextWriter streamWriter)
		{
			switch (entry.Type)
			{
				case EntryType.COMMENT:
					ICommentEntry commentEntry = (ICommentEntry)entry;
					streamWriter.WriteLine("@comment {0}",commentEntry.Comment);
					break;
				case EntryType.MACRO:
					IMacroEntry macroEntry = (IMacroEntry)entry;
					streamWriter.Write("@string{");
					foreach (IField f in macroEntry.Fields)
					{
						IFormatable formater = formaterFactory.GetFieldFormater(f);
						((IFormatingOptions)formater).SetOption("TabPositions",FieldTabPositions.BETWEEN);
						((IFormatingOptions)formater).SetOption("IDCasing",FieldIDCasing.UPPER);
						formater.FormatToStream(streamWriter);
					}
					streamWriter.WriteLine("}");
					break;
				case EntryType.PREAMBLE:
					IPreambleEntry preambleEntry = (IPreambleEntry)entry;
					streamWriter.WriteLine("@preamble {");
					for (int i = 0; i < preambleEntry.Value.Length; i++)
					{
						streamWriter.Write("\t");
						formaterFactory.GetStringValueFormater(preambleEntry.Value[i]).FormatToStream(streamWriter);
						if (i < preambleEntry.Value.Length-1)
						{
							streamWriter.WriteLine(" #");
						}
					}
					streamWriter.WriteLine(" }");
					streamWriter.WriteLine();
					break;
				case EntryType.REGULAR:
					IRegularEntry regularEntry = (IRegularEntry)entry;
					streamWriter.WriteLine();
					streamWriter.WriteLine("@{0}{{{1},",regularEntry.TypeDescriptor.ToLower(),regularEntry.Label);
					foreach (IField f in regularEntry.Fields)
					{
						formaterFactory.GetFieldFormater(f).FormatToStream(streamWriter);
						streamWriter.WriteLine(",");
					}
					streamWriter.WriteLine("}");
					break;
			}
		}
	}
}
