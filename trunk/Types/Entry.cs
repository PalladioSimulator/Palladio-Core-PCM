using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{
	internal abstract class Entry : IEntry
	{
		protected EntryType myType;
		protected long lineNo;
		protected bool isModified = false;

		public long SortOrder 
		{
			get
			{
				return lineNo;
			}
			set
			{
				lineNo = value;
			}
		}

		public EntryType Type
		{
			get
			{
				return myType;
			}
		}

		public virtual bool IsModified
		{
			get
			{
				return isModified;
			}
		}

		public abstract void AcceptVisitor(IVisitor visitor);
	}
}
