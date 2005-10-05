using System;
using System.Collections;

namespace QmlParser.Semantic
{
	public class SimpleConstr : DimConstraint
	{
		private NumOps _numOp;
		private string[] _unit;
		// flat structure
		private ValueLiteralTypes _valueLiteralType;
		private double _number;
		private ArrayList _nameList;
		private string _literalName;

		public SimpleConstr() : base (String.Empty)
		{
		}

		public SimpleConstr(string name) : base (name)
		{
			this._unit = new string[2] {String.Empty, String.Empty};
		}

		#region Properties

		public ValueLiteralTypes ValueLiteralType
		{
			get
			{
				return this._valueLiteralType;
			}
			set
			{
				this._valueLiteralType = value;
			}
		}

		public double Number
		{
			get
			{
				return this._number;
			}
			set
			{
				this._number = value;
			}
		}

		public ArrayList NameList
		{
			get
			{
				return this._nameList;
			}
			set
			{
				try
				{
					ArrayList list = value;
					Hashtable table = new Hashtable();

					foreach (string element in list)
						table.Add(element, null);
				}
				catch(Exception e)
				{
					//this._isValid = false;
					throw new SemanticException("All elements of the name list must be unique.");
				}
				this._nameList = value;
			}
		}

		public string LiteralName
		{
			get
			{
				return this._literalName;
			}
			set
			{
				this._literalName = value;
			}
		}

		public NumOps NumOp
		{
			get
			{
				return this._numOp;
			}
			set
			{
				this._numOp = value;
			}
		}

		public string[] Unit
		{
			get
			{
				return this._unit;
			}
			set
			{
				this._unit = value;
				if (this._unit.GetLength(0) < 1)
					this._unit = new string[2] {String.Empty, String.Empty};
				else if (this._unit.GetLength(0) == 1)
					this._unit = new string[2] {this._unit[0], String.Empty};
				else if (this._unit.GetLength(0) > 2)
					this._unit = new string[2]  {this._unit[0], this._unit[1]};
			}
		}

		#endregion


	}
}
