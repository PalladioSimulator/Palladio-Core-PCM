using System;
using BibTeX.Formater.Formater.Default;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;
using System.IO;
using Options.Interfaces;
using Options;
using ReflectionBasedVisitor;

namespace BibTeX.Formater
{
	/// <summary>
	/// Zusammenfassung für DefaultFormaterFactory.
	/// </summary>
	internal class ASCIIFormater : IBibTeXFormater
	{
		protected Options.Options options = new Options.Options();

		public IOptions Options
		{
			get
			{
				return options;
			}
		}

		public ASCIIFormater()
		{
			options.AddOption(new EnumOption("DelimiterChar","",Type.GetType("BibTeX.Formater.Interfaces.FieldDelimiterChar",true)));
			options["DelimiterChar"] = FieldDelimiterChar.ORIGINAL;
			options.AddOption(new EnumOption("TabPositions","",Type.GetType("BibTeX.Formater.Interfaces.FieldTabPositions",true)));
			options["TabPositions"] = FieldTabPositions.BOTH;
			options.AddOption(new EnumOption("IDCasing","",Type.GetType("BibTeX.Formater.Interfaces.FieldIDCasing",true)));
			options["IDCasing"] = FieldIDCasing.LOWER;
		}

		public string FormatToString (IVisitable node)
		{
			StringWriter sw = new StringWriter();
			FormatToStream(sw,node);
			return sw.ToString();
		}

		public void FormatToStream (TextWriter streamWriter, IVisitable node)
		{
			new DefaultFormaterVisitor(streamWriter,options).Visit(node);
		}
	}
}
