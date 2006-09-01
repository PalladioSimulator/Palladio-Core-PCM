using antlr;
using antlr.collections;

namespace QmlParser
{
	public class QMLAST : CommonASTWithHiddenTokens
	{
		private int _line;
		private int _column;

		public QMLAST() : base()
		{
		}

		public QMLAST(Token tok) : base(tok)
		{
			this._line = tok.getLine();
			this._column = tok.getColumn();
		}

		public QMLAST(QMLAST another) : base (another)
		{
			this._line = another.Line;
			this._column = another.Column;
		}

		public void initialize(QMLAST t)
		{
			base.initialize(t);
			this._line = t.Line;
			this._column = t.Column;
		}

		public void initialize(Token tok)
		{
			base.initialize(tok);
			this._line = tok.getLine();
			this._column = tok.getColumn();
		}

		public void setHiddenTokenBefore(CommonHiddenStreamToken before)
		{
			this.hiddenBefore = before;
		}

		public void setHiddenTokenAfter(CommonHiddenStreamToken after)
		{
			this.hiddenAfter = after;
		}

		public int Line
		{
			get
			{
				return this._line;
			}
			set
			{
				this._line = value;
			}
		}

		public int Column
		{
			get
			{
				return this._column;
			}
			set
			{
				this._column = value;
			}
		}
	}
}
