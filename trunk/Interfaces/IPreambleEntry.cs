using System;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IPreambleEntry.
	/// </summary>
	public interface IPreambleEntry : IEntry, IVisitable
	{
		IStringValue[] Value
		{
			get; set;
		}
	}
}
