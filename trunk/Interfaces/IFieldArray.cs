using System;
using System.Collections;
using BibTeX.Parser.Interfaces;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IFieldArray.
	/// </summary>
	public interface IFieldArray : IEnumerable, ICollection
	{
		bool HasField(string ID);

		/// <summary>
		/// Indexer to access the fields of an entry
		/// </summary>
		IField this[string index]
		{
			get;
		}
		
		IField[] Fields
		{
			get; set;
		}

		void AddField (IField field);
	}
}
