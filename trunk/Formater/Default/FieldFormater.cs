using System;
using System.IO;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;

namespace BibTeX.Formater.Formater.Default
{
	/// <summary>
	/// Zusammenfassung für BibTexFileFormater.
	/// </summary>
	internal class DefaultFieldFormater : IFormatable, IFormatingOptions
	{
		protected IField field;
		protected IFormaterFactory formaterFactory;
		protected FieldDelimiterChar delimiterChar = FieldDelimiterChar.ORIGINAL;
		protected FieldTabPositions tabPositions = FieldTabPositions.BOTH;
		protected FieldIDCasing idCasing = FieldIDCasing.LOWER;

		public DefaultFieldFormater(IField field, IFormaterFactory formaterFactory)
		{
			this.field = field;
			this.formaterFactory = formaterFactory;
		}

		public void SetOption (string option, object val)
		{
			switch (option)
			{
				case "DelimiterChar":
					delimiterChar = (FieldDelimiterChar)val;
					break;
				case "TabPositions":
					tabPositions = (FieldTabPositions)val;
					break;
				case "IDCasing":
					idCasing = (FieldIDCasing)val;
					break;
			}
		}

		public void FormatToStream(TextWriter streamWriter)
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
				formaterFactory.GetStringValueFormater(field.Value[i]).FormatToStream(streamWriter);
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
	}
}
