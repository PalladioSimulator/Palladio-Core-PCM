using System;
using System.Collections;

namespace QmlParser.Semantic
{
	// Decision for a flat structure, because setDecl, enumDecl and numericDecl are nearly the same.
	public class DimensionDecl
	{
		#region Public Enums

		public enum DeclarationTypes { Unknown, EnumType, SetType, NumericType };
		public enum DimensionDeclOrder { None, Increasing, Decreasing };

		#endregion

		#region Private Variables

		private string _name;
		private DeclarationTypes _type;
		private string[] _unit;
		private DimensionDeclOrder _order;
		private bool _isValid;
		// only created if required ;)
		private ArrayList _elements;			// used only for setDecl and enumDecl
		private OrderTable _orderTable;			// used only for setDecl and enumDecl
		
		#endregion

		#region Constructors

		public DimensionDecl() : this (String.Empty, DeclarationTypes.Unknown) 
		{
		} 

		public DimensionDecl(string name) : this (name, DeclarationTypes.Unknown) 
		{
		} 

		public DimensionDecl(string name, DeclarationTypes type)
		{
			this._name = name;
			this._type = type;

			this._isValid = true;
			this._unit = new string[2] {String.Empty, String.Empty};
			this._order = DimensionDeclOrder.None;
		}

		#endregion

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

		public DeclarationTypes Type
		{
			get
			{
				return this._type;
			}
			set
			{
				this._type = value;
			}
		}

		public DimensionDeclOrder Order
		{
			get
			{
				return this._order;
			}
			set
			{
				this._order = value;
			}
		}

		public bool IsValid
		{
			get
			{
				return this._isValid;
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

		public ArrayList Elements
		{
			// if element already exists
			get
			{
				return this._elements;
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
					this._isValid = false;
					throw new SemanticException("All elements of the name list must be unique.");
				}

				this._elements = value;
			}
		}

		public OrderTable Orders
		{
			get
			{
				return this._orderTable;
			}
			set
			{
				try
				{
					this._orderTable = value;
				}
				catch(Exception e)
				{
					this._isValid = false;
					throw;
				}
			}
		}


		public override string ToString()
		{
			string toString = String.Empty;

			toString += "Name: " + this._name;
			toString += "\r\n";
			toString += "Type: " + this._type;
			toString += "\r\n";
			toString += "Order: " + this._order;
			toString += "\r\n";
			toString += "Elements: ";
			if (this._elements != null)
				foreach (string element in this._elements)
					toString += element + " ";
			toString += "\r\n";
			toString += "Orders: ";
			if (this._orderTable != null)
				toString += this._orderTable.ToString();
			toString += "\r\n";
			toString += "Unit: " + this._unit[0];
			if (this._unit[1] != String.Empty)
				toString += " / " + this._unit[1];
			toString += "\r\n";

			return toString;
		}



	}
}
