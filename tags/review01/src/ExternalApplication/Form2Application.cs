using System;
using System.Collections;
using System.IO;
namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	///  Form2Applikation generates a dynamic webpage for the form1.htm
	/// </summary>
	public class Form2Application : IFormApplication
	{
		string eins, zwei, drei;
		Hashtable input;

		/// <summary>
		/// The external application is initated with the sorted user
		/// input
		/// </summary>
		/// <param name="anInput">The filterd input</param>
		public Form2Application(Hashtable anInput)
		{
			this.input = anInput;
			this.eins = "textfield";
			this.zwei = "textfield2";
			this.drei = this.input["Optionsschaltergruppe1"].ToString();
			Console.WriteLine("das ist drei: "+this.drei);
		}

		// <summary>
		/// This is the most importeant method. Here the <code>ExternalApplication</code>
		/// </summary>
		/// <returns>´Returns the generated page in a <code>string</code></returns>
		public string GenerateText()
		{
			string option="";
			if(this.drei=="ja")
				option =" Erstmal zu allen ja sagen, mach ich auch immer :-)";
			if(this.drei=="nein")
				option = " Gut, erstmal dagegen sein, auch ok";
			if(this.drei=="vielleicht")
				option =" Keine Meinung ist auch eine";
		
			string gaga="";
			gaga = gaga +" Das war die Eingabe ins erste Feld: "+this.input[this.eins].ToString()+"<br>";
			gaga = gaga +"Eingabe ins zweite Feld: "+this.input[this.zwei].ToString() +"<br>";
			gaga = gaga+ "Deine Meinung: "+option;
		
			
			Console.WriteLine("versuche Datei zu öffnen");
			StreamReader baseFile = new StreamReader("default-webPage.txt");
			string baseDoc = baseFile.ReadToEnd();
			
			baseDoc = baseDoc.Replace("#######################################",gaga);
			return baseDoc;
			
		}
	}
}
