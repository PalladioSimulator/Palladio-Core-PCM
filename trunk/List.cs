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

namespace cdrnet.Lib.MathLib.Scalar.List
{
	/// <summary>
	/// Math.NET type: a list of scalar expressions
	/// </summary>
	[ParsingType(ParsingExpressionType.List,0)]
	public interface IListExpression: IExpression
	{
		/// <summary>
		/// calculate the components as real doubles
		/// </summary>
		ValueList Calculate();
		IScalarExpression this[int index] {get;set;}
		void Add(IScalarExpression sub);
		void Remove(IScalarExpression sub);
		void RemoveAt(int index);
		/// <summary>
		/// the count of scalars
		/// </summary>
		int Length {get;}
		/// <summary>
		/// simplifies the list expressions
		/// </summary>
		/// <returns>the simplified list expression</returns>
		IListExpression Simplify();
		/// <summary>
		/// expands the list expressions
		/// </summary>
		/// <returns>the expanded list expression</returns>
		ScalarList Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IListExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IListExpression Substitute(IExpression original, IExpression replacement);
	}
	public class ValueList: CollectionBase
	{
		public void Add(double item)
		{
			InnerList.Add(item);
		}
		public void Remove(double item)
		{
			InnerList.Remove(item);
		}
		public double this[int index]
		{
			get {return((double)InnerList[index]);}
			set {InnerList[index] = value;}
		}
		public double ToSum()
		{
			double sum = 0;
			foreach(double d in InnerList)
				sum += d;
			return(sum);
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
	[ParsingObject(ParsingObjectType.List,50)]
	public class ScalarList: MathExpression, IListExpression
	{
		ArrayList data;
		public ScalarList(Context context, IScalarExpression[] subs): base(context)
		{
			data = new ArrayList(subs);
			Init(new EmptyParameters());
		}
		public ValueList Calculate()
		{
			ValueList rsp = new ValueList();
			for(int i=0;i<data.Count;i++)
				rsp.Add(this[i].Calculate());
			return(rsp);
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public ScalarList Expand()
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].Expand();
			return new ScalarList(context,tmp);
		}
		public IListExpression SafeExpand()
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].SafeExpand();
			return new ScalarList(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IListExpression Simplify()
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].Simplify();
			return new ScalarList(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IListExpression Substitute(IExpression original, IExpression replacement)
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Count];
			for(int i=0;i<data.Count;i++)
				tmp[i] = this[i].Substitute(original, replacement);
			return new ScalarList(context,tmp);
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
		public IScalarExpression this[int index]
		{
			get {return((IScalarExpression)data[index]);}
			set	{data[index] = value;}
		}
		public void Add(IScalarExpression sub)
		{
			data.Add(sub);
		}
		public void Remove(IScalarExpression sub)
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
			return sb.ToString();
		}
		public override void ConvertChilds(string conversionType)
		{
			for(int i=0;i<Length;i++)
			{
				IScalarExpression s = this[i];
				ScalarConversionMap.Convert(ref s,conversionType);
				this[i] = s;
			}
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int i=0;i<Length;i++)
				this[i].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(ScalarList))
			{
				ScalarList x = exp as ScalarList;
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