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
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	/// <summary>
	/// Math.NET type: a list of (scalar) matrix expressions
	/// </summary>
	[ParsingType(ParsingExpressionType.List,0)]
	public interface IMatrixListExpression: IExpression
	{
		/// <summary>
		/// calculate the components as real doubles
		/// </summary>
		ValueMatrixList Calculate();
		/// <summary>
		/// the count of matrices
		/// </summary>
		int Length {get;}
		/// <summary>
		/// simplifies the list expressions
		/// </summary>
		/// <returns>the simplified list expression</returns>
		IMatrixListExpression Simplify();
		/// <summary>
		/// expands the list expressions
		/// </summary>
		/// <returns>the expanded list expression</returns>
		MatrixList Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IMatrixListExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IMatrixListExpression Substitute(IExpression original, IExpression replacement);
	}
	public class ValueMatrixList: CollectionBase
	{
		public void Add(ValueMatrix item)
		{
			InnerList.Add(item);
		}
		public void Remove(ValueMatrix item)
		{
			InnerList.Remove(item);
		}
		public ValueMatrix this[int index]
		{
			get {return((ValueMatrix)InnerList[index]);}
			set {InnerList[index] = value;}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append('{');
			for(int i=0;i<InnerList.Count;i++)
			{
				if(i>0)
					sb.Append(',');
				sb.Append(InnerList[i].ToString());
			}
			sb.Append('}');
			return(sb.ToString());
		}
	}
	#region Specific Math Objects
	[ParsingObject(ParsingObjectType.List,11)]
	public class MatrixList: MathExpression, IMatrixListExpression
	{
		ArrayList data;
		public MatrixList(Context context, IMatrixExpression[] subs): base(context)
		{
			data = new ArrayList(subs);
			Init(new EmptyParameters());
		}
		public ValueMatrixList Calculate()
		{
			ValueMatrixList rsp = new ValueMatrixList();
			for(int i=0;i<data.Count;i++)
				rsp.Add(this[i].Calculate());
			return rsp;
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public MatrixList Expand()
		{
			IMatrixExpression[] tmp = new IMatrixExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].Expand();
			return new MatrixList(context,tmp);
		}
		public IMatrixListExpression SafeExpand()
		{
			IMatrixExpression[] tmp = new IMatrixExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].SafeExpand();
			return new MatrixList(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IMatrixListExpression Simplify()
		{
			IMatrixExpression[] tmp = new IMatrixExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].Simplify();
			return new MatrixList(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IMatrixListExpression Substitute(IExpression original, IExpression replacement)
		{
			IMatrixExpression[] tmp = new IMatrixExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].Substitute(original, replacement);
			return new MatrixList(context,tmp);
		}
		public override bool IsEntity
		{
			get {return(false);}
		}
		public override bool IsConstant
		{
			get
			{
				bool isc = true;
				for(int i=0;i<data.Count;i++)
					isc &= this[i].IsConstant;
				return isc;
			}
		}
		public int Length
		{
			get {return data.Count;}
		}
		public IMatrixExpression this[int index]
		{
			get {return((IMatrixExpression)data[index]);}
			set	{data[index] = value;}
		}
		public void Add(IMatrixExpression sub)
		{
			data.Add(sub);
		}
		public void Remove(IMatrixExpression sub)
		{
			data.Remove(sub);
		}
		public void RemoveAt(int index)
		{
			data.RemoveAt(index);
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append('{');
			for(int i=0;i<data.Count;i++)
			{
				if(i>0)
					sb.Append(',');
				sb.Append(this[i].ToString());
			}
			sb.Append('}');
			return(sb.ToString());
		}
		public override void ConvertChilds(string conversionType)
		{
			for(int i=0;i<Length;i++)
			{
				IMatrixExpression m = this[i];
				MatrixConversionMap.Convert(ref m,conversionType);
				this[i] = m;
			}
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int i=0;i<Length;i++)
				this[i].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(MatrixList))
			{
				MatrixList x = exp as MatrixList;
				if(x.Length != this.Length)
					return(false);
				bool eq = true;
				for(int y=0;y<data.Count;y++)
				{
					eq &= this[y].Equals(x[y]);
				}
				if(eq)
					return true;
			}
			return false;
		}
	}
	#endregion
}