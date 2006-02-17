using System;
using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{
	/// <summary>
	/// Zusammenfassung für Stringvalue.
	/// </summary>
	internal class Stringvalue : IStringValue
	{
		protected StringValueType type;
		protected string val;

		public StringValueType Type
		{
			get
			{
				return type;
			}
			set
			{
				type = value;
			}
		}

		public string InnerValue
		{
			get
			{
				return val;
			}
			set
			{
				val = value;
			}
		}

		public Stringvalue(string val, StringValueType type)
		{
			this.type = type;
			this.val = val;
		}

		public override string ToString()
		{
			return ToString(false);
		}

		public string ToString(bool generateDelimiters)
		{
			if (generateDelimiters)
			{
				switch(type)
				{
					case StringValueType.BRACED:
						return "{" + val + "}";
					case StringValueType.QUOTED:
						return "\"" + val + "\"";
					case StringValueType.UNQUOTED:
						return val;
				}
				return "";
			}
			else
				return val;
		}

		public void AcceptVisitor(IVisitor visitor)
		{
		}
	}
}
