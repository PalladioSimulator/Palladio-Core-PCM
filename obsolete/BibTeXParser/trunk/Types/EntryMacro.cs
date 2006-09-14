using System.Collections;
using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;


namespace BibTeX.Parser.Types
{
	internal class EntryMacro : Entry, IMacroEntry
	{
		protected IFieldArray macros = null;

		public IFieldArray Fields
		{
			get
			{
				return macros;
			}
		}

		public EntryMacro(IFieldArray macros)
		{
			this.macros = macros;
			myType = EntryType.MACRO;
		}
		
		public override void AcceptVisitor(IVisitor visitor)
		{
			foreach (IField f in macros)
			{
				visitor.Visit(f);
			}
		}
	}
}
