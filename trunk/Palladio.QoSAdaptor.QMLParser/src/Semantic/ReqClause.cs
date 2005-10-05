using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class ReqClause
	{

		#region Private Variables

		private bool _isValid;
		private HybridDictionary _contrExps;
		private ContrExp _currentContrExp;
		private SymboleTable _symboleTable;			// back reference

		#endregion

		public ReqClause(SymboleTable symboleTable) : this(String.Empty, symboleTable)
		{
		}

		public ReqClause(string name, SymboleTable symboleTable)
		{
			this._contrExps = new HybridDictionary();
			this._currentContrExp = null;
			this._isValid = true;
			this._symboleTable = symboleTable;
		}

		#region Public Methods

		public object InsertContrExp(string name, ContrExp contrExp)
		{
			if (this._contrExps[name] != null)
			{
				this._isValid = false;
				throw new SemanticException("A contract expression with name '" + name + "' already exists.");
			}

			this._contrExps.Add(name, contrExp);
			this._currentContrExp = contrExp;
			return contrExp;
		}

		#endregion

		#region Properties

		public ContrExp CurrentContrExp
		{
			get
			{
				return this._currentContrExp;
			}
			set
			{
				this._currentContrExp = value;
			}
		}

		#endregion
	}
}
