using System;
using BibTeX.Parser.Types;
using BibTeX.Parser.Interfaces;
using System.Collections;
using System.Text.RegularExpressions;

namespace BibTeX.Parser.Modifier
{
	/// <summary>
	/// Zusammenfassung für EntryModifier.
	/// </summary>
	public class EntryModifier
	{
		public static void RemoveDuplicateWhiteSpaceInFieldValues(IEntry entry)
		{
			if (entry.Type == EntryType.REGULAR)
			{
				IRegularEntry regularEntry = (IRegularEntry)entry;
				foreach (IField f in regularEntry.Fields)
				{
					FieldModifier.RemoveDuplicateWhiteSpace(f);
				}
			}
			if (entry.Type == EntryType.MACRO)
			{
				IMacroEntry macroEntry = (IMacroEntry)entry;
				foreach (IField f in macroEntry.Fields)
				{
					FieldModifier.RemoveDuplicateWhiteSpace(f);
				}
			}
		}

		public static void GenerateLabel(IRegularEntry regularEntry)
		{
			try
			{
				string newLabel = null;
				if (regularEntry.TypeDescriptor.ToLower() == "proceedings")
				{
					if (!regularEntry.Fields.HasField("editor"))
						throw new ModifierException("No editor found!",null);
					newLabel = GetFirstPersonLastName(regularEntry.Fields["editor"].FlatValue);
				}
				else
				{
					if (!regularEntry.Fields.HasField("author"))
						throw new ModifierException("No author found!",null);
					newLabel = GetFirstPersonLastName(regularEntry.Fields["author"].FlatValue);
				}
				newLabel = ValueModifier.ReplaceSpecialChars(newLabel,ValueModifier.UmlautePlain);
				newLabel = CleanSpecialChars(newLabel.ToLower());
				if (!regularEntry.Fields.HasField("year"))
					throw new ModifierException("Can't find year tag",null);
				newLabel += CleanSpecialChars(regularEntry.Fields["year"].FlatValue);
				regularEntry.Label = newLabel;
			}
			catch (ModifierException ex)
			{
				throw new EntryModifierException("Unable to generate label for entry: "+regularEntry.Label,ex);
			}
		}

		public static void CheckAuthorField(IRegularEntry regularEntry, LogEventHandler logger)
		{
			string newAuthorValue = "";
			if (regularEntry.Fields.HasField("author"))
			{
				string authorField = regularEntry.Fields["author"].FlatValue;
				string[] authors = GetPersons(authorField);
				foreach (string author in authors)
				{
					newAuthorValue += FixAuthor(author) + " and ";
				}
				newAuthorValue = newAuthorValue.Substring(0,newAuthorValue.Length-5);
				if (newAuthorValue != authorField)
				{
					logger(null, new LogEventArgs(LogType.WARNING,"Found colon in author field. Trying to fix it."+Environment.NewLine+
						"Replaced " + authorField + " by " + newAuthorValue));
					regularEntry.Fields["author"].FlatValue = newAuthorValue;
				}
			}
		}

		private static string FixAuthor(string author)
		{
			int authorPartIndex = author.IndexOf(',');
			if (authorPartIndex == -1) // No comma
				return author;
			else // Found comma
			{
				int i = authorPartIndex; int level = 0;
				while (level >= 0 && i >= 0)
				{
					while ( i >= 0 && author[i] != '{' && author[i] != '}') 
						i--;
					if ( i >= 0)
					{
						if ( author[i] == '}')
							level++;
						if ( author[i] == '{')
							level--;
						i--;
					}
				}
				if (level < 0)
					return author;
				else
				{
					string[] authorParts = author.Split(',');
					return authorParts[1] + " " + authorParts[0];
				}
			}
		}

		private static string GetFirstPerson(string personString)
		{
			return GetPersons(personString)[0];
		}

		private static string[] GetPersons(string personString)
		{
			return Regex.Split(personString," and ");
		}

		private static string GetFirstPersonLastName(string personString)
		{
			string person = GetFirstPerson(personString);
			int index = person.LastIndexOf(" ");
			if (index == -1) index = 0;
			return person.Substring(index);
		}

		private static string CleanSpecialChars(string label)
		{
			string newLabel = Regex.Replace(label,@"[^\w]","");
			newLabel = newLabel.Replace("ä","ae");
			newLabel = newLabel.Replace("ö","oe");
			newLabel = newLabel.Replace("ü","ue");
			newLabel = newLabel.Replace("Ä","Ae");
			newLabel = newLabel.Replace("Ö","Oe");
			newLabel = newLabel.Replace("Ü","Ue");
			newLabel = newLabel.Replace("ß","ss");
			return newLabel;
		}
	}
}
