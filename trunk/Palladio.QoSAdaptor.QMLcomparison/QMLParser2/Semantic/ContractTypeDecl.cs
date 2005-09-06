using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class ContractTypeDecl
	{
		private string _name;
		private DimensionDecl _current;
		private bool _isValid;
		private HybridDictionary _dimensionDecls;		// holds the dimensionDecl objects

		#region constructors

		public ContractTypeDecl() : this (String.Empty)
		{
		}

		public ContractTypeDecl(String name)
		{
			this._name = name;
			this._current = null;
			this._isValid = true;
			this._dimensionDecls = new HybridDictionary();
		}

		#endregion

		public override string ToString()
		{
			string toString = String.Empty;

			toString = "ContractTypeDecl: ";
			toString += this._name;
			toString += "\r\n";

			foreach (DictionaryEntry entry in this._dimensionDecls)
			{
				toString += entry.Value.ToString();
				toString += "\r\n";
			}

			return toString;
		}

		public object Insert(string name, DimensionDecl dimensionDecl)
		{
			if (this._dimensionDecls[name] != null)
			{
				this._isValid = false;
				throw new SemanticException("A dimension declaration with name '" + name + "' already exists.");
			}

			this._dimensionDecls.Add(name, dimensionDecl);
			this._current = dimensionDecl;
			return dimensionDecl;
		}

		public DimensionDecl Current
		{
			get
			{
				return this._current;
			}
		}

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

		public HybridDictionary DimensionDecls
		{
			get
			{
				return this._dimensionDecls;
			}
			set
			{
				this._dimensionDecls = value;
			}
		}

		public bool IsValid
		{
			get
			{
				if (!this._isValid)
					return this._isValid;

				bool isValid  = true;
				foreach (DictionaryEntry entry in this._dimensionDecls)
				{
					isValid = ((DimensionDecl)entry.Value).IsValid;
					if (!this._isValid)
					{
						this._isValid = false;
						break;
					}
				}
				return this._isValid;
			}
		}

		#endregion

	}
}
