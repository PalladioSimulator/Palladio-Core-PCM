using System;
using System.Collections;

namespace BibTeX.Parser.Types
{
	/// <summary>
	/// Zusammenfassung für Fieldvalue.
	/// </summary>
	internal class Fieldvalue
	{
		private ArrayList singleValues = new ArrayList();

		public ArrayList Strings
		{
			get
			{
				return singleValues;
			}
		}

		public Fieldvalue(Stringvalue firstValue)
		{
			singleValues.Add(firstValue);
		}

		public Fieldvalue(Stringvalue[] firstValues)
		{
			foreach(Stringvalue s in firstValues)
			{
				singleValues.Add(s);
			}
		}

		public void AddAdditionalValue(Stringvalue nextValue)
		{
			singleValues.Add(nextValue);
		}

		public override string ToString()
		{
			return ToString(false);
		}
		
		public string ToString(bool generateDelimiters)
		{
			string result = "";

			foreach (Stringvalue s in singleValues)
			{
				result += s.ToString(generateDelimiters) + " # ";
			}
			if (result.Length == 0) 
				return "";
			else
				return result.Substring(0,result.Length-3);
		}

	}
}
