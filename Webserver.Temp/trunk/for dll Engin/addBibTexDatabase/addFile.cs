using System;
using System.Collections;
using System.IO;
using System.Text;
using BibTeX.Formater;
using BibTeX.Formater.Interfaces;
using BibTeX.Parser;
using BibTeX.Parser.Interfaces;
using DBAcesses;
using Request;

namespace addBibTexDatabase
{
	/// <summary>
	/// This add a BibtexFile into the database. Only regular BibTex Entries will be
	/// accepted. When the adding is successful a success message will be provided. 
	/// This message contains the number of added entries in the database. It also 
	/// provides a sucess message if the Entrie is already in the database. But the entry
	/// will not be added into the database. If the entry is not valid an erroy message
	/// will be provided. This class uses the Bibtex Parser implemented by Steffen Becker.
	/// </summary>
	public class AddFile
	{
		protected DBAcessComponent db;

		/// <summary>
		/// Initates a new AddFile.
		/// </summary>
		/// <param name="db">A reference on a DBAcessComponent to get aceess to the database.</param>
		public AddFile(ref DBAcessComponent db)
		{
			this.db = db;
		}

		/// <summary>
		/// Computes the response message.  This message contains the number of added entries in the database. It also 
		/// provides a sucess message if the Entrie is already in the database. But the entry
		/// will not be added into the database. If the entry is not valid an erroy message
		/// will be provided.
		/// </summary>
		/// <param name="aRequest">The request which content should be added to the database</param>
		/// <returns>The result of the computation, It contains information for the user.</returns>
		public string ComputeResponse(HttpPostRequest aRequest)
		{
			int counter = 0;
			IEntry[] test = null;
			try
			{
				string content = aRequest.Content;
				IBibTeXFactory bibtexFactory = FactoryBuilder.CreateBibTeXFactory();
				IBibTeXFile bibFile;
				Stream stream = new MemoryStream(ASCIIEncoding.ASCII.GetBytes(aRequest.Content));
				bibFile = bibtexFactory.CreateBibTeXFileFromStream(new StreamReader(stream));
				IBibTeXFormater ASCIIFormater;
				ASCIIFormater = FormaterFactory.GetASCIIFormater();
				//			ASCIIFormater.FormatToString(bibFile.
				test = bibFile.Entries;
				Console.WriteLine("Anzahl der Einträge: " + test.Length);
			}
			catch (Exception e)
			{
				Console.WriteLine(e.GetType().ToString());
				Console.WriteLine(e.Message);
			}
			StringWriter writer = new StringWriter();

			foreach (IEntry e in test)
			{
				try
				{
					if (e.Type == EntryType.REGULAR)
					{
						IRegularEntry toFormat = (IRegularEntry) e;
						Hashtable newDBEntry = new Hashtable();
						newDBEntry.Add("title", toFormat.Fields["title"].FlatValue);
						newDBEntry.Add("author", toFormat.Fields["author"].FlatValue);
						if (toFormat.Fields.HasField("note"))
						{
							newDBEntry.Add("note", toFormat.Fields["note"].FlatValue);
						}
						if (toFormat.Fields.HasField("abstract"))
						{
							newDBEntry.Add("abstract", toFormat.Fields["abstract"].FlatValue);
						}
						if (toFormat.Fields.HasField("annote"))
						{
							newDBEntry.Add("annote", toFormat.Fields["annote"].FlatValue);
						}

						if (toFormat.Fields.HasField("number"))
						{
							newDBEntry.Add("number", toFormat.Fields["number"].FlatValue);
						}
						if (toFormat.Fields.HasField("volume"))
						{
							newDBEntry.Add("volume", toFormat.Fields["volume"].FlatValue);
						}
						if (toFormat.Fields.HasField("journal"))
						{
							newDBEntry.Add("journal", toFormat.Fields["journal"].FlatValue);
						}
						if (toFormat.Fields.HasField("pages"))
						{
							newDBEntry.Add("pages", toFormat.Fields["pages"].FlatValue);
						}
						if (toFormat.Fields.HasField("editor"))
						{
							newDBEntry.Add("editor", toFormat.Fields["editor"].FlatValue);
						}
						if (toFormat.Fields.HasField("publisher"))
						{
							newDBEntry.Add("publisher", toFormat.Fields["publisher"].FlatValue);
						}
						if (toFormat.Fields.HasField("booktitle"))
						{
							newDBEntry.Add("booktitle", toFormat.Fields["booktitle"].FlatValue);
						}
						if (toFormat.Fields.HasField("year"))
						{
							newDBEntry.Add("year", toFormat.Fields["year"].FlatValue);
						}

						newDBEntry.Add("label", toFormat.Label);
						newDBEntry.Add("type", toFormat.TypeDescriptor);
						///DBAcessComponent dba = new DBAcessComponent();
						this.db.InsertRow("Bibtex", newDBEntry, "nichts", "nichts");
						counter++;
					}
				}
				catch (Exception ex)
				{
					Console.WriteLine(ex.Message);
					throw new Exception("The BibtexFile you ve uploaded is not valid Error Message: " + ex.Message);

				}
			}
			string result = "Eintrag in Datenbank erfolgreich. Es wurden " + counter + " Datens&auml;tze eingef&uuml;gt";
			return result;
		}
	}
}