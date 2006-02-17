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
	/// Analies an Bibtex File an returns the entries formated in HTML.
	/// This a handler Implemtaion of the Chain of Resonseabilty hosted by the request
	/// prozessor component.This class uses the Bibtex Parser implemented by Steffen Becker.
	/// </summary>
	public class BibTexAnalyzerComponent :IDeliverResponse
	{
		protected IDeliverResponse sucessor;
		protected byte[] response;
		protected int fileSize;
	

		/// <summary>
		/// Initates an empty BibTexAnalyzer
		/// </summary>
		public BibTexAnalyzerComponent() 
		{
		}

		/// <summary>
		/// Delivers the response of the BibTex Analyzer as HTML. It is stored in a
		/// byte Array.
		/// </summary>
		public byte[] GetResponse
		{
			get
			{
				return this.response;
			}
		}

		/// <summary>
		/// This is the implementation of the <c>IDeliverResponse</c> Interface. This one
		/// successor for the chain of responsability. This method decides if this class
		/// is responsable for the request. If not the request is handelt to the successor.
		/// </summary>
		/// <param name="request">The request which should be answered</param>
		/// <param name="path">The absolute path to the requested file. This file is located
		/// on the HD of the server. For this class this can be an empty to string. Please notice, that a
		/// successor will perhaps need this information. </param>
		/// <returns>this if it is responsable</returns>
		public IDeliverResponse DeliverResonse(HttpRequest request, string path)
		{
			if(isResonsible(request,path))
			{
				ComputeResponse((HttpPostRequest)request);
				return this;
			}
			else return this.sucessor.DeliverResonse(request,path);
		}


		/// <summary>
		/// Cbecks if this class is responsable for the request. This class btz. handler is
		/// responsable if the uri is format.htm and the request is not a <c>HTTPPostRequest</c>
		/// </summary>
		/// <param name="request">The request which should be answered</param>
		/// <param name="path">The absolute path to the requested file. This file is located
		/// on the HD of the server. For this class this can be an empty to string. Please notice, that a
		/// successor will perhaps need this information. </param>
		/// <returns>True if this class is responsale.</returns>
		internal bool isResonsible(HttpRequest request, string path)
		{
			if(!(request is HttpPostRequest))
				return false;
			if(!(request.URI.IndexOf("format.htm")>=0))
				return false;
			return true;
		}

		/// <summary>
		/// Generates the HTML side from the given BibTexFile. The HTML side contains an
		///a normal HTML header and a heading. The BibTex entries are represented in a 
		///HTML table. If the BibTex file ist not valid an error message will be generated.
		///This methods uses the <c>BibTex Parser</c>. This class manipulates the responseByte
		///and the fileSize variables.
		/// </summary>
		/// <param name="aRequest"The request which should be answered.></param>
		internal void ComputeResponse(HttpPostRequest aRequest)
		{
			string worth= new StreamReader("head.txt").ReadToEnd();
			try
			{
				IBibTeXFactory bibtexFactory = FactoryBuilder.CreateBibTeXFactory();
				IBibTeXFile bibFile;
				Stream stream = new MemoryStream(System.Text.ASCIIEncoding.ASCII.GetBytes(aRequest.Content));
				bibFile = bibtexFactory.CreateBibTeXFileFromStream(new StreamReader(stream));
				IBibTeXFormater ASCIIFormater;
				ASCIIFormater = FormaterFactory.GetASCIIFormater();
				IEntry[] test = bibFile.Entries;
				Console.WriteLine("Anzahl der Einträge: "+test.Length);
				StringWriter writer = new StringWriter();
				
				foreach(IEntry e in test)
				{
					if (e.Type == EntryType.REGULAR)
					{
						worth = worth +FormatEntry(e)+"<br><p>";
					}
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

		/// <summary>
		/// This internal method formates a single BibTex entry and returns them as a row
		/// of the result table.
		/// </summary>
		/// <param name="entry">The BibTrx Ntry whixh should be formated.</param>
		/// <returns>AThe foramted BibTex Entry</returns>
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

		/// <summary>
		/// Sets and delivers the sucessor of the Responsability Chain.
		/// </summary>
		public IDeliverResponse Sucessor
		{
			set{this.sucessor = value;}
			get{return this.sucessor;}
		}

		/// <summary>
		/// The size of the generated reponse
		/// </summary>
		public int GetFileSize
		{
			get{return this.fileSize;}
		}


		/// <summary>
		/// The Date of the last modofication of the response. For the dynamic genration of
		/// thr response this is alway noe.
		/// </summary>
		/// <returns></returns>
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
