using System;
using System.Collections;
using MySmallWebServer.MyServerException;
using dictionary;


namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	/// Zusammenfassung für DictionaryApplication.
	/// </summary>
	public class DictionaryApplication : IFormApplication
	{
		string word;
		dictionarySearcher search;
		IList result;

		public DictionaryApplication(Hashtable input)
		{
			this.search = new dictionary.dictionarySearcher();
			this.word = input["textfield"].ToString();
			try
			{
				this.result= this.search.searchForWord(this.word);

			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
				throw new ApplicationException("Dictionary did not work");
			}
			if(this.result.Count == 0)
				Console.WriteLine("nichst drin");
		}


		public string GenerateText()
		{
			string replayString="<html><head><title>My Replay</title></head><body bgcolor =#ca1102> \n\r";
			replayString = replayString +"<H2>gefundene Entsprechungen zum Wort: "+ this.word +"</H2> \n\r";
			replayString = replayString +this.resultTable();
			replayString = replayString +"<a href=\"dic.html\"> neue Suche </a>";
			replayString = replayString +"</body></html>";
			return replayString;
		}

		protected string resultTable()
		{
			string result ="";
			foreach(string s in this.result)
				result = result+" "+s+"<br>";
			return result;
		}
	}
}
