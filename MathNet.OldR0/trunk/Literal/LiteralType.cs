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
using System.Collections.Specialized;
using cdrnet.Lib.MathLib.Core;

namespace cdrnet.Lib.MathLib.Literal
{
	/// <summary>
	/// Math.NET type: a string expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Literal,1)]
	public interface ILiteralExpression: IExpression
	{
		/// <summary>
		/// calculate the expression as a native string
		/// </summary>
		/// <returns>result as a System.String instance</returns>
		string Calculate();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ILiteralExpression Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		ILiteralExpression SafeExpand();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		ILiteralExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		ILiteralExpression Substitute(IExpression original, IExpression replacement);
	}

	#region Specific Math Objects
	[ParsingObject(ParsingObjectType.Literal,11)]
	public class LiteralExpressionValue: LeafExpression, ILiteralExpression
	{
		public LiteralExpressionValue(Context context, string init): base(context)
		{
			val = init;
		}
		#region Static LiteralValue Templates
		public static LiteralExpressionValue Empty(Context context)
		{
			return new LiteralExpressionValue(context,"");
		}
		public static LiteralExpressionValue Space(Context context)
		{
			return new LiteralExpressionValue(context," ");
		}
		public static LiteralExpressionValue Slash(Context context)
		{
			return new LiteralExpressionValue(context,"/");
		}
		public static LiteralExpressionValue BackSlash(Context context)
		{
			return new LiteralExpressionValue(context,"\\");
		}
		public static LiteralExpressionValue NewLine(Context context)
		{
			return new LiteralExpressionValue(context,"\n");
		}
		#endregion
		private string val;
		public string Value
		{
			set {val = value;}
			get {return(val);}
		}
		public string Calculate()
		{
			return val;
		}
		public override string ToString()
		{
			return '"' + val + '"';
		}
		public ILiteralExpression Simplify()
		{
			return this;
		}
		public ILiteralExpression Expand()
		{
			return this;
		}
		public ILiteralExpression SafeExpand()
		{
			return this;
		}
		public ILiteralExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ILiteralExpression) base.ExpressionSubstitute(original, replacement);
		}
		public override bool Equals(object obj)
		{
			LiteralExpressionValue x = obj as LiteralExpressionValue;
			if(x != null && x.val == val)
				return true;
			return false;
		}
		public override int GetHashCode()
		{
			return val.GetHashCode();
		}
	}
	#endregion
}
