using System;
using System.Collections;

namespace QmlParser.Semantic
{
	public class AspectConstr : DimConstraint
	{

		private ArrayList _statConstraints = null;

		public AspectConstr()  : base (String.Empty)
		{
		}

		public AspectConstr(string name) : base (name)
		{
			this._statConstraints = new ArrayList();
		}

		public ArrayList StatConstraints
		{
			get
			{
				return this._statConstraints;
			}
			set
			{
				this._statConstraints = value;
			}
		}
	}
}
