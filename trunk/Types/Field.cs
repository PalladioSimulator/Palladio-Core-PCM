using System;
using BibTeX.Parser.Interfaces;
using System.Collections;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{
	/// <summary>
	/// Zusammenfassung für Field.
	/// </summary>
	internal class Field : IField
	{
		protected string name;
		protected IStringValue[] stringValues = null;

		public string ID
		{
			get
			{
				return name;
			}
			set
			{
				name = value;
			}
		}

		public string[] StringValues
		{
			get
			{
				string[] result = new string[stringValues.Length];
				for (int i = 0; i < stringValues.Length; i++)
				{
					result[i] = stringValues[i].ToString();
				}
				return result;
			}
		}

		public IStringValue[] Value
		{
			get
			{
				return stringValues;
			}
			set
			{
				stringValues = value;
			}
		}

		public string FlatValue
		{
			get
			{
				string result = "";
				foreach (IStringValue s in stringValues)
				{
					result += s.ToString() + " # ";
				}
				if (result.Length > 0)
				{
					return result.Substring(0,result.Length-3);
				}
				return result;
			}
			set
			{
				// TODO: Parse Input!!!
				stringValues = new IStringValue[1];
				stringValues[0] = new Stringvalue(value,StringValueType.QUOTED);
			}
		}

		public Field(string name, IStringValue[] val)
		{
			this.name = name;
			this.stringValues = val;
		}

		public void AcceptVisitor(IVisitor visitor)
		{
			foreach (IStringValue s in stringValues)
			{
				visitor.Visit(s);
			}
		}
	}
}
