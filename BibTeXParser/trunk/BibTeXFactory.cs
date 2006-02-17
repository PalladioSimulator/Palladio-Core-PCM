using System;
using System.IO;
using System.Collections;
using System.Text;
using BibTeX.Parser.Types;
using BibTeX.Parser.Grammar;
using BibTeX.Parser.Exceptions;
using BibTeX.Parser.Interfaces;
using antlr;

namespace BibTeX.Parser
{
	/// <summary>
	/// Zusammenfassung für Loader.
	/// </summary>
	internal class BibTeXFactory : IBibTeXFactory
	{
		protected string streamID = "<STREAM>";
		
		public string StreamID
		{
			get
			{
				return streamID;
			}
			set
			{
				streamID = value;
			}
		}

		public event LogEventHandler LogEvent;

		public IBibTeXFile CreateBibTeXFileFromStream(TextReader input)
		{
			try
			{
				MyParser parser = new MyParser();
				parser.MyInitialize(input,streamID);
				parser.setFilename(streamID);
				parser.ParserLogEvent += LogEvent;
				return parser.bibfile();
			}
			catch(TokenStreamException e) 
			{
				throw new BibTeXParserException("Token stream exception: "+e.Message);
			}
			catch(RecognitionException e) 
			{
				throw new BibTeXParserException("Recognition exception: "+e.Message);
			}
		}

		public IBibTeXFile CreateBibTeXFileFromLocalFile(string filename)
		{
			using (StreamReader sr = new StreamReader(filename,Encoding.Default))
			{
				StreamID = filename;
				return CreateBibTeXFileFromStream(sr);
			}
		}

		public static IBibTeXFactory GetBibTeXFactory()
		{
			return new BibTeXFactory();
		}
	}
}