using BibTeX.Parser.Interfaces;
using ReflectionBasedVisitor;

namespace BibTeX.Parser.Types
{
	internal class EntryComment : Entry, ICommentEntry
	{
		protected string comment;

		public string Comment
		{
			get
			{
				return comment;
			}
			set
			{
				comment = value;
			}
		}

		public EntryComment(string comment)
		{
			this.comment = comment;
			myType = EntryType.COMMENT;
		}

		public override void AcceptVisitor(IVisitor visitor)
		{
		}
	}
}
