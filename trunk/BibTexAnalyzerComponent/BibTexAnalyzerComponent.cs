using System;
using Delivery;
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

namespace BibTexAnalyzer
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class BibTexAnalyzerComponent :IDeliverResponse
	{
		IDeliverResponse sucessor;
		HttpRequest request;
		string path;
		byte[] response;
		int fileSize;
	
		public BibTexAnalyzerComponent() 
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public byte[] GetResponse
		{
			get
			{
				return this.response;
			}
		}

		public IDeliverResponse DeliverResonse(HttpRequest request, string path)
		{
			if(isResonsible(request,path))
			{
				ComputeResponse((HttpPostRequest)request);
				return this;
			}
			else return this.sucessor.DeliverResonse(request,path);
		}

		internal bool isResonsible(HttpRequest request, string path)
		{
			if(!(request is HttpPostRequest))
				return false;
//			if(!(request.URI.IndexOf("bibtex.htm")>=0))
//				return false;
			return true;
		}

		internal void ComputeResponse(HttpPostRequest aRequest)
		{

			string worth= new StreamReader("head.txt").ReadToEnd();
			try
			{
//			StreamWriter file = new StreamWriter("test.bwl");
//			file.WriteLine(aRequest.Content);
//			file.Flush();
//			file.Close();
			IBibTeXFactory bibtexFactory = FactoryBuilder.CreateBibTeXFactory();
			IBibTeXFile bibFile;
			Stream stream = new MemoryStream(System.Text.ASCIIEncoding.ASCII.GetBytes(aRequest.Content));
			bibFile = bibtexFactory.CreateBibTeXFileFromStream(new StreamReader(stream));
//			bibFile = bibtexFactory.CreateBibTeXFileFromLocalFile("test.bwl");

			//			FixEntries(bibFile.Entries);
			IBibTeXFormater ASCIIFormater;
			ASCIIFormater = FormaterFactory.GetASCIIFormater();
			//			ASCIIFormater.FormatToString(bibFile.
			IEntry[] test = bibFile.Entries;
			Console.WriteLine("Anzahl der Einträge: "+test.Length);

			StringWriter writer = new StringWriter();
			
				foreach(IEntry e in test)
				{
					if (e.Type == EntryType.REGULAR)
					{
						worth = worth +FormatEntry(e)+"<br><p>";
					
					
					}
					//				response = response+ ASCIIFormater.FormatToString(e);
				}
			}
			catch(Exception e)
			{
				worth = worth+"<h2> BIbtex File not Valid </h2>";
				worth = worth+e.Message;
			}
			worth = worth + new StreamReader("feet.txt").ReadToEnd();
			Console.WriteLine(worth);
			this.fileSize = worth.Length;
			this.response = Encoding.ASCII.GetBytes(worth);
		}

		internal string FormatEntry(IEntry entry)
		{
			IRegularEntry toFormat = (IRegularEntry)entry;
		
			string result = "<table width=\"75 % \" border=\"1\">";
			result  =result + "<tr><td>Label: </td><td>"+toFormat.Label +"</td></tr>";
			result = result+"<tr><td>Autor: </td><td>"+toFormat.Fields["author"].FlatValue+"</td></tr>";
			result = result+"<tr><td>Titel: </td><td>"+toFormat.Fields["title"].FlatValue+"</td></tr>";
			result = result+"</table>";
			Console.WriteLine(result);
			return result;
		}
		public IDeliverResponse Sucessor
		{
			set{this.sucessor = value;}
			get{return this.sucessor;}
		}

		public int GetFileSize
		{
			get{return this.fileSize;}
		}

		public DateTime  LastModified()
		{
			return DateTime.Now;
		}
		
		public Stream DeliverResponseStream()
		{
			return null;
		}
	}
}
