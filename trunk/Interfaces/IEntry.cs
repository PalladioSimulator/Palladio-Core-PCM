using System;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Abstraction of a bibtex entry.
	/// </summary>
	public interface IEntry : IVisitable
	{
		EntryType Type
		{
			get;
		}
		long SortOrder
		{
			get; set;
		}
		bool IsModified
		{
			get;
		}
	}
}
