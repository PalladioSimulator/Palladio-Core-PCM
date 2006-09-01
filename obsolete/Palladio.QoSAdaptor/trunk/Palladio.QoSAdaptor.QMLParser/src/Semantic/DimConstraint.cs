using System;

namespace QmlParser.Semantic
{
	public class DimConstraint
	{

		#region Public Enums

		public enum NumOps { Unknown, GTE, GTHAN, LTHAN, LTE, EUQAL };
		public enum ValueLiteralTypes { Unknown, Number, NameList, LiteralName };

		#endregion

		#region Private Variables

		private string _name;

		#endregion

		#region Constructors

		public DimConstraint() : this (String.Empty)
		{
		}

		public DimConstraint(string name)
		{
			this._name = name;
		}

		#endregion

		#region Properties

		public string Name
		{
			get
			{
				return this._name;
			}
			set
			{
				this._name = value;
			}
		}

		#endregion
	}
}
