using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{

	internal class EntryPreamble : Entry, IPreambleEntry
	{
		protected IStringValue[] preamble;
	
		public IStringValue[] Value
		{
			get
			{
				return preamble;
			}
			set
			{
				preamble = value;
			}
		}

		public EntryPreamble(IStringValue[] preamble)
		{
			this.preamble = preamble;
			myType = EntryType.PREAMBLE;
		}
		
		public override void AcceptVisitor(IVisitor visitor)
		{
			foreach (IStringValue s in preamble)
			{
				visitor.Visit(s);
			}
		}
	}
}
	
