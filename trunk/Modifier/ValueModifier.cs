using System;
using System.Text.RegularExpressions;
using System.Collections;

namespace BibTeX.Parser.Modifier
{
	/// <summary>
	/// Zusammenfassung für ValueModifier.
	/// </summary>
	public class ValueModifier
	{
		private static char[] WS = new char[] { ' ', '\r', '\t', '\n' };

		public static string[][] UmlautePlain = 
							{
								new string[] {"\\\\\"o","oe"},
								new string[] {"\\\\\"a","ae"},
								new string[] {"\\\\\"u","ue"},
								new string[] {"\\\\\"O","Oe"},
								new string[] {"\\\\\"A","Ae"},
								new string[] {"\\\\\"U","Ue"},
								new string[] {"\"a","ae"},
								new string[] {"\"o","oe"},
								new string[] {"\"u","ue"},
								new string[] {"\"A","ae"},
								new string[] {"\"O","oe"},
								new string[] {"\"U","ue"},
								new string[] {"\\\\ss","ss"}
		};
		
	    public static string RemoveDuplicateWhiteSpace(string s)
		{
			while (Regex.IsMatch(s,@"\s\s"))
			{
				s=Regex.Replace(s,@"\s\s"," ");
			}
			return s;
		}

		public static string ReplaceSpecialChars(string s, string[][] replacementTable)
		{
			foreach (string[] replacer in replacementTable)
			{
				s = Regex.Replace(s,replacer[0],replacer[1]);
			}
			return s;
		}
	}
}
