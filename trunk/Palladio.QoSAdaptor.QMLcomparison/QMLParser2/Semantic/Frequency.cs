using System;
using System.Collections;

namespace QmlParser.Semantic
{
	public class Frequency
	{
		private DimConstraint.ValueLiteralTypes _valueLiteralType;
		private bool _includeLowerBound;
		private bool _includeHigherBound;
		private ArrayList _nameList;
		private string _literalName;
		private double _number;
		private double _secondNumber;
		private bool _hasRange;

		public Frequency()
		{
			this._hasRange = false;
			this._secondNumber = double.NaN;
		}

		#region Properties

		public bool HasRange
		{
			get
			{
				return this._hasRange;
			}
		}

		public DimConstraint.ValueLiteralTypes ValueLiteralType
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

		public bool IncludeLowerBound
		{
			get
			{
				return this._includeLowerBound;
			}
			set
			{
				this._includeLowerBound = value;
			}
		}
		public bool IncludeHigherBound
		{
			get
			{
				return this._includeHigherBound;
			}
			set
			{
				this._includeHigherBound = value;
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
					throw new SemanticException("All elements of used name lists must be unique.");
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

		public double SecondNumber
		{
			get
			{
				return this._secondNumber;
			}
			set
			{
				this._hasRange = true;
				this._secondNumber = value;
			}
		}


		#endregion
	}
}
