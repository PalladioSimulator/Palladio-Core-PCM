using System;
using Request;
using System.IO;
using System.Text;
using BibTeX.Parser;
using BibTeX.Formater;
using BibTeX.Parser.Types;
using BibTeX.Parser.Exceptions;
using BibTeX.Parser.Modifier;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;
using ReflectionBasedVisitor;
using System.Collections;
using DBAcesses;

namespace addBibTexDatabase
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class addFile
	{
		public addFile()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public string ComputeResponse(HttpPostRequest aRequest)
		{

			int counter =0;
			IEntry[] test = null;
			try
			{
				string content = aRequest.Content;
				IBibTeXFactory bibtexFactory = FactoryBuilder.CreateBibTeXFactory();
				IBibTeXFile bibFile;
				Stream stream = new MemoryStream(System.Text.ASCIIEncoding.ASCII.GetBytes(aRequest.Content));
				bibFile = bibtexFactory.CreateBibTeXFileFromStream(new StreamReader(stream));
				IBibTeXFormater ASCIIFormater;
				ASCIIFormater = FormaterFactory.GetASCIIFormater();
				//			ASCIIFormater.FormatToString(bibFile.
			    test = bibFile.Entries;
				Console.WriteLine("Anzahl der Einträge: "+test.Length);
			}
			catch(Exception e)
			{
				Console.WriteLine(e.GetType().ToString());
				Console.WriteLine(e.Message);
			}
			StringWriter writer = new StringWriter();
		
			foreach(IEntry e in test)
			{
				try
				{
					if (e.Type == EntryType.REGULAR)
					{
					
						IRegularEntry toFormat = (IRegularEntry) e;
						Hashtable newDBEntry = new Hashtable();

						
						newDBEntry.Add("title",toFormat.Fields["title"].FlatValue);
						newDBEntry.Add("author",toFormat.Fields["author"].FlatValue);
						if(toFormat.Fields.HasField("note"))
						{
							newDBEntry.Add("note",toFormat.Fields["note"].FlatValue);
						}
						if(toFormat.Fields.HasField("abstract"))
						{
							newDBEntry.Add("abstract",toFormat.Fields["abstract"].FlatValue);
						}
						if(toFormat.Fields.HasField("annote"))
						{
							newDBEntry.Add("annote",toFormat.Fields["annote"].FlatValue);
						}
						
						if(toFormat.Fields.HasField("number"))
						{
							newDBEntry.Add("number",toFormat.Fields["number"].FlatValue);
						}
						if(toFormat.Fields.HasField("volume"))
						{
							newDBEntry.Add("volume",toFormat.Fields["volume"].FlatValue);
						}
						if(toFormat.Fields.HasField("journal"))
						{
							newDBEntry.Add("journal",toFormat.Fields["journal"].FlatValue);
						}
						if(toFormat.Fields.HasField("pages"))
						{
							newDBEntry.Add("pages",toFormat.Fields["pages"].FlatValue);
						}
						if(toFormat.Fields.HasField("editor"))
						{
							newDBEntry.Add("editor",toFormat.Fields["editor"].FlatValue);
						}
						if(toFormat.Fields.HasField("publisher"))
						{
							newDBEntry.Add("publisher",toFormat.Fields["publisher"].FlatValue);
						}
						if(toFormat.Fields.HasField("booktitle"))
						{
							newDBEntry.Add("booktitle",toFormat.Fields["booktitle"].FlatValue);
						}
						if(toFormat.Fields.HasField("year"))
						{
							newDBEntry.Add("year",toFormat.Fields["year"].FlatValue);
						}

						newDBEntry.Add("label",toFormat.Label);
						newDBEntry.Add("type",toFormat.TypeDescriptor);

						DBAcessComponent dba = new DBAcessComponent();
						dba.InsertRow("Bibtex",newDBEntry,"nichts","nichts");
						counter++;

						
					
					}
				}
				catch(Exception ex)
				{
					Console.WriteLine(ex.Message);
					throw new Exception("The BibtexFile you ve uploaded is not valid Error Message: "+ex.Message);
					
				}


				
			}

			string result = "Eintrag in Datenbank erfolgreich. Es wurden "+counter+" Datensätze eingefügt";
			return result;
		}
	}
}

