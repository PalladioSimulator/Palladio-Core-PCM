using System;
using System.IO;
using System.Collections;
using MySmallWebServer.ExternalApplication;

namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	/// Zusammenfassung für PDFGenerator.
	/// </summary>
	public class PDFGenerator  : IFormApplication
	{
		Hashtable userInput;
		string baseDoc;
		string generatedFile;
		public PDFGenerator(Hashtable input)
		{
			this.userInput = input;
			//openfile
			OpenFile();
			Replace();
		}

		private void Replace()
		{
			StreamWriter wr = new StreamWriter("keys.txt");
			foreach(DictionaryEntry d in this.userInput)
				wr.WriteLine(d.Key.ToString());
			wr.Close();
			Console.WriteLine("das soll rein: "+this.userInput["Titel"].ToString());
			string replace = this.userInput["Titel"].ToString();
			replace = replace.Replace("+"," ");
			this.baseDoc = this.baseDoc.Replace("##Titel##",replace);
			/*betroffene Klassen */
			replace = this.userInput["BetroffeneKlassen"].ToString();
			replace = replace.Replace("+"," ");
			this.baseDoc = this.baseDoc.Replace("##BetroffeneKlassen##",replace);
			/*Beschreibung*/
			replace = this.userInput["Beschreibung"].ToString();
			replace = replace.Replace("+"," ");
			this.baseDoc = this.baseDoc.Replace("##Beschreibung##",replace);
			/*Erlduterung*/
			replace = this.userInput["Erlduterung"].ToString();
			replace = replace.Replace("+"," ");
			this.baseDoc = this.baseDoc.Replace("##Erluterung##",replace);

			ReplaceSpecials();
			
			StreamWriter latexWriter = new StreamWriter(this.userInput["Titel"].ToString()+".tex");
			latexWriter.WriteLine(this.baseDoc);
			latexWriter.Close();

			this.generatedFile =this.userInput["Titel"].ToString()+".tex";
			//generate Tex
			MakeTex();
		
			
		}

		private void MakeTex()
		{
//			string location = new string("\Dokumente und Einstellungen\Yvette\Desktop\Neu Aktenkoffer\MySmallWebServer\DATA\LatexConverter\generatedDocs\");
//			System.Diagnostics.Process.GetProcessesByName(

			System.Diagnostics.Process.Start("cmd.exe","/klatex "+this.generatedFile).WaitForExit(3000);
			System.Diagnostics.Process.GetProcessesByName("devenv.exe");

			System.Diagnostics.Process.Start("cmd.exe","/kyap.exe "+this.generatedFile.Replace("tex","dvi"));
			
		}
		private void ReplaceSpecials()
		{
			//convert to Latex
			/*Zeilenumbruch*/
			this.baseDoc = this.baseDoc.Replace("%0D%0A"," ");
			this.baseDoc = this.baseDoc.Replace("%2C",",");
			this.baseDoc = this.baseDoc.Replace("%E4","ä");
			this.baseDoc = this.baseDoc.Replace("%FC","ü");
			this.baseDoc = this.baseDoc.Replace("%F6 ","ö");
			this.baseDoc = this.baseDoc.Replace("%DF","ß");
			this.baseDoc = this.baseDoc.Replace("%C4","Ä");
			this.baseDoc = this.baseDoc.Replace("%DC","Ü");
			this.baseDoc = this.baseDoc.Replace("%D6","Ö");
			
			Console.WriteLine(this.baseDoc);
		}

	
		private void OpenFile()
		{
			Console.WriteLine("versuche Datei zu öffnen");
			StreamReader baseFile = new StreamReader("../../DATA/LatexConverter/default.txt");
			this.baseDoc = baseFile.ReadToEnd();
			baseFile.Close();
			
			
		}

		public string GenerateText()
		{
			return "Generierung war Erfolgreich!";
		}
	}
}
