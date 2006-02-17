#region Copyright 2001-2003 Christoph Daniel Rüegg [Modified BSD License]
/*
Math.NET, a symbolic math library
Copyright (c) 2001-2003, Christoph Daniel Rueegg, http://cdrnet.net/. All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice,
this list of conditions and the following disclaimer. 

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
THE POSSIBILITY OF SUCH DAMAGE.
*/
#endregion

using System;
using System.Collections;
using System.Text;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Parsing
{
	/// <summary>
	/// Public interface for PreParsers like builtin 'InfixTokenizer'
	/// </summary>
	public interface ITreeTokenProvider
	{
		TypeAnalyzer TypeAnalyzer {get;set;}
		TreeTokenNode ParseExpression(string expression);
	}
	/// <summary>
	/// A token that can be attached to any node of the token tree.
	/// </summary>
	public class TreeToken
	{
		protected ParsingObjectType objType;
		protected string stk;
		public TreeToken(string stk)
		{
			this.stk = stk;
		}
		public string Value
		{
			get {return(stk);}
			set {stk = value;}
		}
		public ParsingObjectType ObjectType
		{
			get {return(objType);}
			set {objType = value;}
		}
		public bool IsValue
		{
			get {return(objType == ParsingObjectType.Value);}
		}
		public bool IsVariable
		{
			get {return(objType == ParsingObjectType.Variable);}
		}
		public bool IsInner
		{
			get {return(objType == ParsingObjectType.InnerOperator);}
		}
		public bool IsOuter
		{
			get {return(objType == ParsingObjectType.OuterOperator);}
		}
		public bool IsPre
		{
			get {return(objType == ParsingObjectType.PreOperator);}
		}
		public bool IsParenthesis
		{
			get {return(objType == ParsingObjectType.Parenthesis);}
		}
		public bool IsVector
		{
			get {return(objType == ParsingObjectType.Vector);}
		}
		public bool IsList
		{
			get {return(objType == ParsingObjectType.List);}
		}
		public bool IsSeperator
		{
			get {return(objType == ParsingObjectType.Seperator);}
		}
		public bool IsRelation
		{
			get {return(objType == ParsingObjectType.Relation);}
		}
		public bool IsFunction
		{
			get {return(objType == ParsingObjectType.Function);}
		}
		public override string ToString()
		{
			return("TOKEN["+stk+"|"+objType.ToString()+"]");
		}
	}
	/// <summary>
	/// A node of the token tree. Each node references
	/// one token and is a container for as many subnodes
	/// as needed.
	/// </summary>
	public class TreeTokenNode: CollectionBase
	{
		bool[] flags;
		TreeToken token;
		TypeAnalyzerObjectItem objType;
		bool isCurrent = false;
		public TreeTokenNode()
		{
			flags = new bool[0];
		}
		public TreeTokenNode(int flagCount)
		{
			flags = new bool[flagCount];
		}
		public TreeToken Token
		{
			get {return(token);}
			set
			{
				token = value;
				isCurrent = false;
			}
		}
		public TypeAnalyzerObjectItem ObjectType
		{
			get {return(objType);}
			set
			{
				objType = value;
				isCurrent = true;
			}
		}
		public void EvaluateObjectType(TypeAnalyzer ta)
		{
			if(isCurrent)
				return;
			isCurrent = true;
			foreach(TreeTokenNode subnode in this)
			{
				subnode.EvaluateObjectType(ta);
			}
			TypeAnalyzerTypeItem[] tList = new TypeAnalyzerTypeItem[this.Count];
			for(int i=0;i<this.Count;i++)
				if(this[i].ObjectType != null)
					tList[i] = this[i].ObjectType.ReturnTypeItem;
			switch(token.ObjectType)
			{
				case ParsingObjectType.Value:
					objType = ta.ObjectList.FindItem(ParsingObjectType.Value);
					break;
				case ParsingObjectType.Variable:
					objType = ta.ObjectList.FindVariableItem(ta.Context,token.Value);
					break;
				case ParsingObjectType.Complex:
					objType = ta.ObjectList.FindItem(ParsingObjectType.Complex);
					break;
				case ParsingObjectType.Literal:
					objType = ta.ObjectList.FindItem(ParsingObjectType.Literal);
					break;
				case ParsingObjectType.Function:
					objType = ta.ObjectList.FindItem(ParsingObjectType.Function,token.Value,tList);
					break;
				case ParsingObjectType.PreOperator:
					objType = ta.ObjectList.FindItem(ParsingObjectType.PreOperator,token.Value,tList);
					break;
				case ParsingObjectType.OuterOperator:
					objType = ta.ObjectList.FindItem(ParsingObjectType.OuterOperator,token.Value,tList);
					break;
				case ParsingObjectType.InnerOperator:
					objType = ta.ObjectList.FindItem(ParsingObjectType.InnerOperator,token.Value,tList);
					break;
				case ParsingObjectType.Relation:
					objType = ta.ObjectList.FindItem(ParsingObjectType.Relation,token.Value,tList);
					break;
				case ParsingObjectType.Vector:
					objType = ta.ObjectList.FindItem(ParsingObjectType.Vector,tList);
					break;
				case ParsingObjectType.List:
					objType = ta.ObjectList.FindItem(ParsingObjectType.List,tList);
					break;
				case ParsingObjectType.Seperator:
					objType = null;
					break;
				case ParsingObjectType.Parenthesis:
					if(this.Count>0)
					{
						token = this[0].token;
						objType = this[0].objType;
					}
					else
						throw(new ParsingTokenLookupFailedException(token.ObjectType.ToString()));
					break;
				default:
					throw(new ParsingTokenLookupFailedException(token.Value));
			}
		}
		public bool GetFlag(int index)
		{
			if(flags.Length > index && index > -1)
				return(flags[index]);
			else
				return(false);
		}
		public void SetFlag(int index, bool flag)
		{
			if(flags.Length > index && index > -1)
				flags[index] = flag;
		}
		public int[] FindChilds(int flagindex, bool flag)
		{
			ArrayList al = new ArrayList();
			for(int i=0;i<InnerList.Count;i++)
				if(this[i].GetFlag(flagindex)==flag)
					al.Add(i);
			return((int[])al.ToArray(typeof(int)));
		}
		public int[] FindChilds(ParsingObjectType type)
		{
			ArrayList al = new ArrayList();
			for(int i=0;i<InnerList.Count;i++)
				if(this[i].Token.ObjectType==type)
					al.Add(i);
			return((int[])al.ToArray(typeof(int)));
		}
		public int[] FindChilds(int flagindex, bool flag,ParsingObjectType type)
		{
			ArrayList al = new ArrayList();
			for(int i=0;i<InnerList.Count;i++)
				if(this[i].GetFlag(flagindex)==flag && this[i].Token.ObjectType==type)
					al.Add(i);
			return((int[])al.ToArray(typeof(int)));
		}
		public void Add(TreeTokenNode token)
		{
			InnerList.Add(token);
		}
		public void Remove(TreeTokenNode token)
		{
			InnerList.Remove(token);
		}
		public TreeTokenNode this[int index]
		{
			get {return((TreeTokenNode)InnerList[index]);}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("TOKENNODE[ - ");
			sb.Append(token.ToString());
			sb.Append(" - ");
			sb.Append(objType.SubType.Name);
			sb.Append(" - ");
			sb.Append(objType.ReturnTypeItem.SubType.Name);
			sb.Append("\n");
			foreach(TreeTokenNode subnode in this)
			{
				sb.Append(subnode.ToString());
				sb.Append("\n");
			}
			sb.Append("]");
			return(sb.ToString());
		}
	}
}
