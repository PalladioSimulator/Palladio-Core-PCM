using System;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Represents a complete BibTeX file / database
	/// </summary>
	public interface IBibTeXFile : IVisitable
	{
		/// <summary>
		/// Get an array of all the entries stored in the file
		/// </summary>
		IEntry[] Entries
		{
			get;
		}
		
		/// <summary>
		/// Append the entry e to the end of the bibtex file
		/// </summary>
		/// <param name="e">The entry to be added at the end of the file</param>
		void AppendEntry (IEntry e);

		/// <summary>
		/// Delete entry e from the file
		/// </summary>
		/// <param name="e">The entry to be deleted from the file</param>
		void DeleteEntry (IEntry e);

		/// <summary>
		/// Create a new entry at the end of the file and return its default object
		/// </summary>
		/// <param name="type">The type of the entry. See <see cref="EntryType"/>.</param>
		/// <returns>The created and appended entry.</returns>
		IEntry CreateEntry (EntryType type);
	}
}
