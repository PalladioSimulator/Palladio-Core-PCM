using System;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IMacroEntry.
	/// </summary>
	public interface IMacroEntry : IEntry, IVisitable
	{
		IFieldArray Fields
		{
			get;
		}
	}
}
