using System;
using System.Collections;
using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{
	/// <summary>
	/// Zusammenfassung für 
	/// </summary>
	internal class EntryRegular : Entry, IRegularEntry
	{
		protected string type;
		protected string label;
		protected IFieldArray fields = null;

		public string Label
		{
			get
			{
				return label;
			}
			set
			{
				label = value;
				isModified = true;
			}
		}
		
		public string TypeDescriptor
		{
			get
			{
				return type;
			}
			set
			{
				type = value;
				isModified = true;
			}
		}

		public IFieldArray Fields
		{
			get
			{
				return fields;
			}
		}

		public EntryRegular(string type, string label, IFieldArray fields)
		{
			this.type = type;
			this.label = label;
			this.fields = fields;
			myType = EntryType.REGULAR;
		}
		
		public override void AcceptVisitor(IVisitor visitor)
		{
			foreach (IField f in fields)
			{
				visitor.Visit(f);
			}
		}
	}
}
