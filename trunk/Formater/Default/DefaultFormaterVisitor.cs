using System;
using BibTeX.Formater.Exceptions;
using BibTeX.Formater.Interfaces;
using BibTeX.Parser.Interfaces;
using System.IO;
using Options.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Formater.Formater.Default
{
	/// <summary>
	/// Zusammenfassung für DefaultFormaterVisitor.
	/// </summary>
	internal class DefaultFormaterVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		protected TextWriter streamWriter = null;
		protected IOptions options = null;

		public DefaultFormaterVisitor(TextWriter streamWriter, IOptions options) : base (false)
		{
			this.streamWriter = streamWriter;
			this.options = options;
		}

		public override void VisitObject(object o)
		{
			throw new FormaterException ("Unknown BibTeX element to format found: "+o.GetType());
		}
		
		public void VisitIBibTeXFile(IBibTeXFile file)
		{
			foreach (IEntry e in file.Entries)
			{
				Visit(e);
			}
		}

		public void VisitIRegularEntry(IRegularEntry regularEntry)
		{
			streamWriter.WriteLine();
			streamWriter.WriteLine("@{0}{{{1},",regularEntry.TypeDescriptor.ToLower(),regularEntry.Label);
			foreach (IField f in regularEntry.Fields)
			{
				VisitIField(f);
				streamWriter.WriteLine(",");
			}
			streamWriter.WriteLine("}");
		}

		public void VisitIMacroEntry(IMacroEntry macroEntry)
		{
			streamWriter.Write("@string{");
			foreach (IField f in macroEntry.Fields)
			{
				FormatIField(f,
					FieldTabPositions.BETWEEN,
					FieldIDCasing.UPPER,
					(FieldDelimiterChar)options["DelimiterChar"]);
			}
			streamWriter.WriteLine("}");
		}

		public void VisitIPreambleEntry(IPreambleEntry preambleEntry)
		{
			streamWriter.WriteLine("@preamble {");
			for (int i = 0; i < preambleEntry.Value.Length; i++)
			{
				streamWriter.Write("\t");
				VisitIStringValue(preambleEntry.Value[i]);
				if (i < preambleEntry.Value.Length-1)
				{
					streamWriter.WriteLine(" #");
				}
			}
			streamWriter.WriteLine(" }");
			streamWriter.WriteLine();
		}

		public void VisitICommentEntry(ICommentEntry comment)
		{
			streamWriter.WriteLine("@comment {0}",comment.Comment);		
		}

		public void VisitIField(IField field)
		{
			FormatIField(field,
				(FieldTabPositions)options["TabPositions"],
				(FieldIDCasing)options["IDCasing"],
				(FieldDelimiterChar)options["DelimiterChar"]);
		}

		public void VisitIStringValue(IStringValue stringValue)
		{
			FormatIStringValue(stringValue);
		}

		#region Helper functions
		private void FormatIField(IField field,FieldTabPositions tabPositions,
			FieldIDCasing idCasing, FieldDelimiterChar delimiterChar)
		{
			string temp = "";

			if (tabPositions == FieldTabPositions.BFORE || tabPositions == FieldTabPositions.BOTH)
			{
				streamWriter.Write("    ");
			}
			switch(idCasing)
			{
				case FieldIDCasing.KEEP:
					temp = field.ID;
					break;
				case FieldIDCasing.LOWER:
					temp = field.ID.ToLower();
					break;
				case FieldIDCasing.UPPER:
					temp = field.ID.ToUpper();
					break;
			}
			if (tabPositions == FieldTabPositions.BETWEEN || tabPositions == FieldTabPositions.BOTH)
			{
				streamWriter.Write(temp.PadRight(15,' '));
			}
			else
			{
				streamWriter.Write(temp);
			}
			streamWriter.Write(" = ");
			switch (delimiterChar)		
			{
				case FieldDelimiterChar.BRACES:
					streamWriter.Write("{");
					break;
				case FieldDelimiterChar.QUOTES:
					streamWriter.Write("\"");
					break;
			}
			for (int i = 0; i < field.StringValues.Length; i++)
			{
				VisitIStringValue(field.Value[i]);
				if ( i != field.StringValues.Length - 1)
				{
					streamWriter.Write (" # ");
				}
			}
			switch (delimiterChar)		
			{
				case FieldDelimiterChar.BRACES:
					streamWriter.Write("}");
					break;
				case FieldDelimiterChar.QUOTES:
					streamWriter.Write("\"");
					break;
			}
		}

		private void FormatIStringValue(IStringValue stringValue)
		{
			switch (stringValue.Type)
			{
				case StringValueType.QUOTED:
					streamWriter.Write("\"");
					break;
				case StringValueType.BRACED:
					streamWriter.Write("{");
					break;
			}
			string[] subvalues = stringValue.InnerValue.Split(' ');
			int pos = 0; int linepos = 0; bool lastWasLineFeed = true;
			while (pos < subvalues.Length)
			{
				if (linepos + subvalues[pos].Length <= 70 || lastWasLineFeed)
				{
					streamWriter.Write(subvalues[pos]);
					linepos += subvalues[pos].Length;
					pos++;
					if (pos < subvalues.Length)
					{
						streamWriter.Write(" ");
						linepos++;
					}
					lastWasLineFeed = false;
				}
				else
				{
					if (linepos > 0)
					{
						streamWriter.WriteLine();
						streamWriter.Write("".PadLeft(22,' '));
						linepos = 0;
					}
					lastWasLineFeed = true;
				}
			}
			switch (stringValue.Type)
			{
				case StringValueType.QUOTED:
					streamWriter.Write("\"");
					break;
				case StringValueType.BRACED:
					streamWriter.Write("}");
					break;
			}
		}
		#endregion
	}
}
