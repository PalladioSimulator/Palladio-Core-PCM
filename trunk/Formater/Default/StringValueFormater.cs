using System;
using System.IO;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;

namespace BibTeX.Formater.Formater.Default
{
	/// <summary>
	/// Zusammenfassung für BibTexFileFormater.
	/// </summary>
	internal class DefaultStringValueFormater : IFormatable
	{
		protected IStringValue stringValue;
		protected IFormaterFactory formaterFactory;

		public DefaultStringValueFormater(IStringValue stringValue, IFormaterFactory formaterFactory)
		{
			this.stringValue = stringValue;
			this.formaterFactory = formaterFactory;
		}

		public void FormatToStream(TextWriter streamWriter)
		{
			string formatString = null;

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
	}
}
