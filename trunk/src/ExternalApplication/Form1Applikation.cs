using System;
using System.Collections;
using System.IO;
using System.Text;

namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	/// Form1Applikation generates a dynamic webpage for the form.htm
	/// </summary>
	public class Form1Applikation 
	{
		ExternalClientResponse r = new ExternalClientResponse();
		Hashtable input;

		/// <summary>
		/// The external application is initated with the sorted user
		/// input
		/// </summary>
		/// <param name="input"></param>
		public Form1Applikation(Hashtable input)
		{
			this.input = input;
		}


		/// <summary>
		/// This is the most importeant method. Here the <code>ExternalApplication</code>
		/// </summary>
		/// <returns>´Returns the generated page in a <code>string</code></returns>
		public string generateText(){

//			string[] dad = new string[1];
//			int c =0;
//			Console.WriteLine(this.input["textfield0"]);
//			Console.WriteLine(this.input["textfield1"]);
//			Console.Read();
//			foreach(DictionaryEntry w in this.input)
//			{
//				dad[c] =w.Value.ToString();
//				Console.WriteLine(w.Value.ToString());
//				c++;
//			}

			string gaga="<html><head><title>My Replay</title></head><body> \n\r";
			gaga = gaga +"<H1> Hallo "+this.input["textfield0"].ToString()+"! Dein Passwort war: "+this.input["textfield1"].ToString()+"</H1> \n\r";
			gaga = gaga +"</body></html>";
			return gaga;
		}
	}
}
