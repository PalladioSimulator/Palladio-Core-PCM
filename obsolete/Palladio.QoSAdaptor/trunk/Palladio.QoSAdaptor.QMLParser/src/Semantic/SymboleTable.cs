using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class SymboleTable
	{

		private object _current = null;
		private HybridDictionary _declarations = null;		// holds all declarations

		public SymboleTable()
		{
			this._declarations = new HybridDictionary();
		}

		public object Insert(string name, object declaration)
		{
			if (this._declarations[name] != null)
				throw new SemanticException("A declaration with name '" + name + "' already exists.");

			this._declarations.Add(name, declaration);
			this._current = declaration;
			return declaration;
		}

		public object Find(string name)
		{			
			return Find(name, null);
		}

		public object Find(string name, Type type) 
		{
			
			if (!this._declarations.Contains(name))
				throw new SemanticException("A declaration with name '" + name + "' doesn't exist.");

			// TODO better error message type ;)
			if (!type.Equals(this._declarations[name].GetType()))
				throw new SemanticException("A declaration with name '" + name + "' and type '" + type.ToString() + "' doesn't exist.");
			
			return this._declarations[name];
		}

		public ContractTypeDecl CurrentAsContractTypeDecl
		{
			get
			{
				if (this._current is QmlParser.Semantic.ContractTypeDecl)
					return (ContractTypeDecl)this._current;
				else
					return null;
			}
		}
		
		public ContrDecl CurrentAsContrDecl
		{
			get
			{
				if (this._current is QmlParser.Semantic.ContrDecl)
					return (ContrDecl)this._current;
				else
					return null;
			}
		}

		public ProfileDecl CurrentProfileDecl
		{
			get
			{
				if (this._current is QmlParser.Semantic.ProfileDecl)
					return (ProfileDecl)this._current;
				else
					return null;
			}
		}
				
		public override string ToString()
		{
			string toString = String.Empty;

			foreach (DictionaryEntry entry in this._declarations)
			{
				toString += entry.Value.ToString();
			}

			return toString;
		}
	}
}
