using System;
using System.Collections;
using System.IO;
using System.Text;

namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	/// Form1Applikation generates a dynamic webpage for the form.htm
	/// </summary>
	public class Form1Applikation : IFormApplication
	{
		ExternalClientResponse r = new ExternalClientResponse();
		Hashtable input;

		/// <summary>
		/// The external application is initated with the sorted user input
		/// </summary>
		/// <param name="input"></param>
		public Form1Applikation(Hashtable input)
		{
			this.input = input;
		}


		/// <summary>
		/// Implamentatin of the IFormApplication Interface
		/// </summary>
		/// <returns>Returns the generated page in a <code>string</code></returns>
		public string GenerateText(){
			string replayString="<html><head><title>My Replay</title></head><body> \n\r";
			replayString = replayString +"<H1> Hallo "+this.input["textfield0"].ToString()+"! Dein Passwort war: "+this.input["textfield1"].ToString()+"</H1> \n\r";
			replayString = replayString +"</body></html>";
			return replayString;
		}
	}
}
