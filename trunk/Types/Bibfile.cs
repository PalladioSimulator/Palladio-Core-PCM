using System;
using System.Collections;
using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{
	/// <summary>
	/// Zusammenfassung für Bibfile.
	/// </summary>
	internal class Bibfile : IBibTeXFile
	{
		protected ArrayList entries;

		public IEntry[] Entries
		{
			get
			{
				Entry[] entryArray = new Entry[entries.Count];
				entries.CopyTo(entryArray);
				return entryArray;
			}
		}

		public Bibfile(ArrayList entries)
		{
			this.entries = entries;
		}

		public void AppendEntry (IEntry e)
		{
			entries.Add(e);
		}
		
		public void DeleteEntry (IEntry e)
		{
			if (entries.IndexOf(e) != -1)
			{
				entries.Remove(e);
			}
		}

		public IEntry CreateEntry (EntryType type)
		{
			IEntry e = null;

			switch (type)
			{
				case EntryType.COMMENT:
					e = new EntryComment("");
					break;
				case EntryType.MACRO:
					e = new EntryMacro(new FieldArray());
					break;
				case EntryType.PREAMBLE:
					IStringValue[] preamble = new IStringValue[1];
					preamble[0] = new Stringvalue("",StringValueType.QUOTED);
					e = new EntryPreamble(preamble);
					break;
				case EntryType.REGULAR:
					e = new EntryRegular("new","new",new FieldArray());
					break;
			}
			entries.Add(e);
			return e;
		}

		public void AcceptVisitor(IVisitor visitor)
		{
			foreach (IEntry e in entries)
			{
				visitor.Visit(e);
			}
		}
	}
}
