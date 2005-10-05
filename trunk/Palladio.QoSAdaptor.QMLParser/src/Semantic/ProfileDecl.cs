using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class ProfileDecl
	{
		#region Private Variables

		private string _name;
		private string _interfaceName;
		private bool _isValid;
		private ProfileDecl _parentProfileDecl;
		private ArrayList _reqClauses;
		private ReqClause _currentReqClause;
		private ArrayList _interfaceContracts;
		private SymboleTable _symboleTable;			// back reference
	
		#endregion

		#region Constructors

		public ProfileDecl(SymboleTable symboleTable) : this(String.Empty, symboleTable)
		{
		}

		public ProfileDecl(string name, SymboleTable symboleTable)
		{
			this._name = name;
			this._symboleTable = symboleTable;
			this._interfaceName = String.Empty;
			this._isValid = true;
			this._reqClauses = new ArrayList();
			this._currentReqClause = null;
			this._interfaceContracts = new ArrayList();
		}

		#endregion

		#region Public Methods

		public object InsertReqClause(ReqClause reqClause)
		{
			this._reqClauses.Add(reqClause);
			this._currentReqClause = reqClause;
			return reqClause;
		}
		public void InsertInterfaceContract(string name)
		{
			if (this._interfaceContracts.Contains(name))
				throw new SemanticException("The profile '" + this._name + "' already requires the contract '" + name + "'.");
			if (this._symboleTable.Find(name, Type.GetType("QmlParser.Semantic.ContrDecl")) != null)
				this._interfaceContracts.Add(name);
		}

		public object InsertContrExp(string name, ContrExp contrExp)
		{
			return this._currentReqClause.InsertContrExp(name, contrExp);
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

		public string InterfaceName
		{
			get
			{
				return this._interfaceName;
			}
			set
			{
				this._interfaceName = value;
			}
		}

		public ProfileDecl ParentProfileDecl
		{
			get
			{
				return this._parentProfileDecl;
			}
			set
			{
				this._parentProfileDecl = value;
			}
		}

		public ReqClause CurrentReqClause
		{
			get
			{
				return this._currentReqClause;
			}
			set
			{
				this._currentReqClause = value;
			}
		}







/*
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
*/
		#endregion
	}
}
