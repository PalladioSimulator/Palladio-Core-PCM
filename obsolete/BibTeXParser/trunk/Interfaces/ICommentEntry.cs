using System;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Zusammenfassung für ICommentEntry.
	/// </summary>
	public interface ICommentEntry : IEntry, IVisitable
	{
		string Comment
		{
			get; set;
		}
	}
}
