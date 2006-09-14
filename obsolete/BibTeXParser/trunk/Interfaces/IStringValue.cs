using System;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IStringValue.
	/// </summary>
	public interface IStringValue : IVisitable
	{
		StringValueType Type
		{
			get; set;
		}

		string InnerValue
		{
			get; set;
		}
	}
}
