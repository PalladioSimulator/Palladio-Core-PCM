using System;
using BibTeX.Parser.Interfaces;

namespace BibTeX.Parser.Modifier
{
	/// <summary>
	/// Zusammenfassung für FieldModifier.
	/// </summary>
	public class FieldModifier
	{
		public static void RemoveDuplicateWhiteSpace(IField f)
		{
			IStringValue[] values = f.Value;
			for (int i = 0; i < values.Length; i++)
			{
				values[i].InnerValue = ValueModifier.RemoveDuplicateWhiteSpace(values[i].InnerValue);
			}
			f.Value = values;
		}
	}
}
