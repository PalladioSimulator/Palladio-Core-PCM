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
using System.Text;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Core
{
	/// <summary>
	/// parameter collection (base) for math operators.
	/// </summary>
	public abstract class Parameters
	{
		/// <summary>
		/// the count of parameters the collection stores
		/// </summary>
		protected int count;
		public Parameters(int count)
		{
			this.count = count;
		}
		/// <summary>
		/// access a specific parameter using its number.
		/// </summary>
		public abstract IExpression this[int index]
		{	
			get;
		}
		/// <summary>
		/// creates a new parameter collection with all parameters simplified
		/// </summary>
		/// <returns>the simplified collection</returns>
		public abstract Parameters Simplify();
		/// <summary>
		/// creates a new parameter collection with all parameters expanded
		/// </summary>
		/// <returns>the expanded collection</returns>
		public abstract Parameters Expand();
		/// <summary>
		/// creates a new parameter collection with all parameters substituted
		/// </summary>
		/// <param name="original">the term to look for</param>
		/// <param name="replacement">the replacement for the original term</param>
		/// <returns>the substituted collection</returns>
		public abstract Parameters Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// the count of parameters the collection stores
		/// </summary>
		public int Count
		{
			get {return count;}
		}
		/// <summary>
		/// indicates whether at least one of expressions contains unknown variables or not
		/// </summary>
		public bool IsConstant
		{
			get
			{
				bool b = true;
				for(int i=0;i<count;i++)
					b &= this[i].IsConstant;
				return b;
			}
		}
		/// <summary>
		/// indicates wether at least one of the expressions is not an entity leaf expression
		/// </summary>
		public bool IsEntity
		{
			get
			{
				bool b = true;
				for(int i=0;i<count;i++)
					b &= this[i].IsEntity;
				return b;
			}
		}
		/// <summary>
		/// converts all the expressions' childs to the given type, eg. "simple".
		/// </summary>
		/// <param name="conversionType">the type the childs shall be converted to</param>
		public abstract void ConvertChilds(string conversionType);
		public override bool Equals(object obj)
		{
			if(obj.GetType().Equals(GetType()))
			{
				Parameters p = obj as Parameters;
				if(p.Count != count)
					return false;
				for(int i=0;i<count;i++)
					if(!this[i].Equals(p[i]))
						return false;
				return true;
			}
			return false;
		}
		public bool Equals(object obj, bool reverse)
		{
			if(!reverse)
				return Equals(obj);
			if(obj.GetType().Equals(GetType()))
			{
				Parameters p = obj as Parameters;
				if(p.Count != count)
					return false;
				for(int i=0;i<count;i++)
					if(!this[i].Equals(p[i]))
					{
						for(int j=0;j<count;j++)
							if(!this[j].Equals(p[count-1-j]))
								return false;
						return true;
					}
				return true;
			}
			return false;
		}
		public override int GetHashCode()
		{
			int h = count;
			for(int i=0;i<count;i++)
				h ^= this[i].GetHashCode();
			return h;
		}
		/// <summary>
		/// add all variables the parameters refer to to the given manager
		/// </summary>
		/// <param name="vars">the variable manager to put the variables into</param>
		/// <param name="deep">if true, it also scans hidden subterms (e.g. in locked variables)</param>
		public void CollectVariables(VariableManager vars, bool deep)
		{
			for(int i=0;i<count;i++)
				this[i].CollectVariables(vars,deep);
		}
		/// <summary>
		/// generates a string representing the expression in Infix notation
		/// </summary>
		/// <returns>infix string expression</returns>
		public override string ToString()
		{
			if(count == 0)
				return string.Empty;
			string tmp = string.Empty;
			for(int i=0;i<count;i++)
			{
				if(i>0)
					tmp += ",";
				tmp += this[i].ToString();
			}
			return tmp;
		}
		/// <summary>
		/// generates a string representing the expression in Infix notation
		/// </summary>
		/// <param name="character">the character/name of the operator</param>
		/// <param name="type">the type of the operator</param>
		/// <returns>infix string expression</returns>
		public string ToString(string character, ParsingObjectType type)
		{
			if(count == 0)
				return string.Empty;
			string seperator = character;
			string open = "(";
			string close = ")";
			string tmp = string.Empty;
			if(type == ParsingObjectType.Function)
			{
				seperator = ",";
				tmp = character;
			}
			if(type == ParsingObjectType.PreOperator)
			{
				tmp = character;
			}
			if(type == ParsingObjectType.List)
			{
				open = "{";
				close = "}";
			}
			if(type == ParsingObjectType.Vector)
			{
				open = "[";
				close = "]";
			}
			if(type == ParsingObjectType.Literal)
			{
				open = "\"";
				close = "\"";
			}
			tmp += open;
			for(int i=0;i<count;i++)
			{
				if(i>0)
					tmp += seperator;
				tmp += this[i].ToString();
			}
			return tmp + close;
		}
	}
	/// <summary>
	/// a simplified parameter collection for parameterless operators
	/// </summary>
	public class EmptyParameters: Parameters
	{
		public EmptyParameters() : base(0) {}
		public override void ConvertChilds(string conversionType)
		{
		}
		public override Parameters Simplify()
		{
			return this;
		}
		public override Parameters Expand()
		{
			return this;
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return this;
		}
		public override IExpression this[int index]
		{
			get
			{
				throw new IndexOutOfRangeException();
			}
		}
	}
}
