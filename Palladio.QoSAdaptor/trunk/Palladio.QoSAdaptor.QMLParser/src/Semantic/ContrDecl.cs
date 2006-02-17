using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class ContrDecl
	{
		#region Private Variables

		private string _name;
		private ContrExp _contrExp;
    
		#endregion

		#region Constructors

		public ContrDecl() : this (String.Empty)
		{
		}

		public ContrDecl(String name)
		{
			this._name = name;
			this._contrExp = null;
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

		public ContrExp ContrExp
		{
			get
			{
				return this._contrExp;
			}
			set
			{
				this._contrExp = value;
			}
		}

		public bool IsValid
		{
			get
			{
				return this._contrExp.IsValid;
			}
		}

		#endregion
	}
}
