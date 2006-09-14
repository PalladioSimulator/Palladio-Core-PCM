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
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Scalar.Tensor
{
	/*
	[ParsingType(ParsingExpressionType.Vector,0)]
	public interface ITensorExpression: IExpression
	{
		/// <summary>
		/// calculate the components as real doubles
		/// </summary>
		ValueTensor Calculate();

		IScalarExpression this[int[] indexes] {get;set;}

		int[] Lengths {get;}

		/// <summary>
		/// Tensor representation using components as scalar expressions
		/// </summary>
		ITensorExpression ExpressionTensor {get;}
	}
	public class ValueTensor
	{
		Array data;
		public ValueTensor(int[] lengths)
		{
			data = Array.CreateInstance(typeof(double),lengths);
		}
		public double this[int[] indexes]
		{
			get
			{
				return((double)data.GetValue(indexes));
			}
			set
			{
				data.SetValue(value,indexes);
			}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			int[] indexes = new int[data.Rank];
			RecursiveStringFormatter(sb,0,indexes);
			return(sb.ToString());
		}
		private void RecursiveStringFormatter(StringBuilder sb, int currentDim, int[] indexes)
		{
			if(currentDim == indexes.Length)
			{
				sb.Append(data.GetValue(indexes).ToString());
			}
			else
			{
				sb.Append("[");
				for(int i=0;i<data.GetLength(currentDim);i++)
				{
					if(i>0)
						sb.Append(",");
					indexes[currentDim] = i;
					RecursiveStringFormatter(sb,currentDim+1,indexes);
				}
				sb.Append("]");
			}
		}
		
	}

	#region Specific Type
	[ParsingObject(ParsingObjectType.Vector,11)]
	public class ScalarTensor: MathExpression, ITensorExpression
	{
		private delegate IScalarExpression Action(IScalarExpression exp,IExpression a, IExpression b);
		private Array data;
		public ScalarTensor(Context context, ITensorExpression[] subs): base(context,new EmptyParameters())
		{
			try
			{
				int[] dim = new int[subs[0].Lengths.Length+1];
				subs[0].Lengths.CopyTo(dim,1);
				dim[0] = subs.Length;
				data = Array.CreateInstance(typeof(IScalarExpression),dim);
				for(int d=0;d<subs.Length;d++)
				{
					dim[0] = d;
					int[] indexes = new int[subs[0].Lengths.Length];
					RecursiveCopy(ref subs[d],0,indexes,dim);
				}
			}
			catch
			{
				throw(new ExpressionRankMismatchException());
			}
		}
		public ScalarTensor(Context context, IMatrixExpression[] subs): base(context,new EmptyParameters())
		{
			ScalarMatrix[] smsubs = new ScalarMatrix[subs.Length];
			for(int i=0;i<subs.Length;i++)
				smsubs[i] = subs[i].ExpressionMatrix;
			int[] dim = new Int32[] {smsubs[0].LengthX,smsubs[0].LengthY,smsubs.Length};
			data = Array.CreateInstance(typeof(IScalarExpression),dim);
			for(int x=0;x<dim[0];x++)
				for(int y=0;y<dim[1];y++)
					for(int z=0;z<dim[2];z++)
						data.SetValue(smsubs[z][x,y],new int[]{x,y,z});
		}
		private void RecursiveCopy(ref ITensorExpression source, int currentDim, int[] srcindexes, int[] tarindexes)
		{
			if(currentDim == srcindexes.Length)
			{
				data.SetValue(source[srcindexes],tarindexes);
			}
			else
			{
				for(int i=0;i<data.GetLength(currentDim+1);i++)
				{
					srcindexes[currentDim] = i;
					tarindexes[currentDim+1] = i;
					RecursiveCopy(ref source,currentDim+1,srcindexes,tarindexes);
				}
			}
		}
		private IScalarExpression ExpandAction(IScalarExpression exp,IExpression a, IExpression b)
		{
			return exp.Expand();
		}
		private IScalarExpression SafeExpandAction(IScalarExpression exp,IExpression a, IExpression b)
		{
			return exp.SafeExpand();
		}
		private IScalarExpression SimplifyAction(IScalarExpression exp,IExpression a, IExpression b)
		{
			return exp.Simplify();
		}
		public ValueTensor Calculate()
		{
			ValueTensor rsp = new ValueTensor(this.Lengths);
			int[] indexes = new int[data.Rank];
			RecursiveCalculate(ref rsp,0,indexes);
			return rsp;
		}
		private void RecursiveCalculate(ref ValueTensor calc, int currentDim, int[] indexes)
		{
			if(currentDim == indexes.Length)
			{
				calc[indexes] = ((IScalarExpression)data.GetValue(indexes)).Calculate();
			}
			else
			{
				for(int i=0;i<data.GetLength(currentDim);i++)
				{
					indexes[currentDim] = i;
					RecursiveCalculate(ref calc,currentDim+1,indexes);
				}
			}
		}
		public IScalarExpression this[int[] indexes]
		{
			get {return((IScalarExpression)data.GetValue(indexes));}
			set	{data.SetValue(value,indexes);}
		}
		public int[] Lengths
		{
			get
			{
				int[] lengths = new int[data.Rank];
				for(int i=0;i<lengths.Length;i++)
					lengths[i] = data.GetLength(i);
				return(lengths);
			}
		}
		public string ToString()
		{
			get
			{
				StringBuilder sb = new StringBuilder();
				int[] indexes = new int[data.Rank];
				RecursiveStringFormatter(sb,0,indexes);
				return(sb.ToString());
			}
		}
		private void RecursiveStringFormatter(StringBuilder sb, int currentDim, int[] indexes)
		{
			if(currentDim == indexes.Length)
			{
				sb.Append(((IScalarExpression)data.GetValue(indexes)).ToString());
			}
			else
			{
				sb.Append("[");
				for(int i=0;i<data.GetLength(currentDim);i++)
				{
					if(i>0)
						sb.Append(",");
					indexes[currentDim] = i;
					RecursiveStringFormatter(sb,currentDim+1,indexes);
				}
				sb.Append("]");
			}
		}
		public bool IsConstant
		{
			get
			{
				bool isc = true;
				foreach(IScalarExpression exp in data)
					isc &= exp.IsConstant;
				return(isc);
			}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
		}
		public bool IsEqualTo(IExpression exp)
		{
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			throw new NotImplementedException();
		}
	}
	#endregion

	#region Tensor Conversion Maps
	public abstract class TensorMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref ITensorExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			ITensorExpression ex = exp as ITensorExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class TensorConversionMap
	{
		public static void Convert(ref ITensorExpression exp, string conversionType)
		{
			exp.ConvertChilds(conversionType);
			//exp = exp.Simplify(); not defined for tensors yet
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(TensorMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	#endregion
	*/
}
