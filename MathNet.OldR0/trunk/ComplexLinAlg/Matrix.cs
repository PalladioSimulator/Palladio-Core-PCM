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
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	#region Vector Type
	/// <summary>
	/// Math.NET type: a complex vector expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Vector,0)]
	public interface IComplexVectorExpression: IExpression
	{
		/// <summary>
		/// calculate the axis components as real doubles
		/// </summary>
		ValueComplexVector Calculate();
		/// <summary>
		/// the length (count of elements) of the vector
		/// </summary>
		int Length {get;}
		/// <summary>
		/// simplifies the vector expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IComplexVectorExpression Simplify();
		/// <summary>
		/// expands the vector expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ComplexVector Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IComplexVectorExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IComplexVectorExpression Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// creates a vertical matrix containing just this vector
		/// </summary>
		/// <returns>vertical matrix</returns>
		IComplexMatrixExpression ToMatrix();
	}
	/// <summary>
	/// the native data structure for discrete (numeric) complex vectors
	/// </summary>
	public class ValueComplexVector
	{
		protected ValueComplex[] data;
		public ValueComplexVector(int dim)
		{
			data = new ValueComplex[dim];
		}
		public int Length
		{
			get {return(data.Length);}
		}
		public ValueComplex this[int y]
		{
			get
			{
				return(data[y]);
			}
			set
			{
				data[y] = value;
			}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("[");
			for(int y=0;y<data.Length;y++)
			{
				if(y>0)
					sb.Append(",");
				sb.Append(data[y].ToString());
			}
			sb.Append("]");
			return(sb.ToString());
		}
	}
	#endregion

	#region Matrix Type
	/// <summary>
	/// Math.NET type: a complex matrix expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Vector,0)]
	public interface IComplexMatrixExpression: IExpression
	{
		/// <summary>
		/// calculate the axis components as real doubles
		/// </summary>
		ValueComplexMatrix Calculate();
		/// <summary>
		/// the lenght of the x-axis (count of columns) of the matrix
		/// </summary>
		int LengthX {get;}
		/// <summary>
		/// the lenght of the y-axis (count of rows) of the matrix
		/// </summary>
		int LengthY {get;}
		/// <summary>
		/// simplifies the matrix expression
		/// </summary>
		/// <returns>the simplfied expression</returns>
		IComplexMatrixExpression Simplify();
		/// <summary>
		/// expands the matrix expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ComplexMatrix Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IComplexMatrixExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IComplexMatrixExpression Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// Isolates a row with the given index
		/// </summary>
		/// <param name="y">the index of the row (first row = 0)</param>
		/// <returns>the row as a vector</returns>
		IComplexVectorExpression GetRowVector(int y);
		/// <summary>
		/// Isolates a column with the given index
		/// </summary>
		/// <param name="x">the index of the column (first column = 0)</param>
		/// <returns>the column as a vector</returns>
		IComplexVectorExpression GetColumnVector(int x);
	}
	/// <summary>
	/// the native data structure for discrete (numeric) complex matrices
	/// </summary>
	public class ValueComplexMatrix
	{
		protected ValueComplex[,] data;
		public ValueComplexMatrix(int x, int y)
		{
			data = new ValueComplex[x,y];
		}
		public int LengthX
		{
			get {return(data.GetLength(0));}
		}
		public int LengthY
		{
			get {return(data.GetLength(1));}
		}
		public ValueComplex this[int x, int y]
		{
			get
			{
				return(data[x,y]);
			}
			set
			{
				data[x,y] = value;
			}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("[");
			for(int x=0;x<data.GetLength(0);x++)
			{
				if(x>0)
					sb.Append(",");
				sb.Append("[");
				for(int y=0;y<data.GetLength(1);y++)
				{
					if(y>0)
						sb.Append(",");
					sb.Append(data[x,y].ToString());
				}
				sb.Append("]");
			}
			sb.Append("]");
			return(sb.ToString());
		}
	}
	#endregion

	#region Specific Math Objects
	[ParsingObject(ParsingObjectType.Vector,11)]
	public class ComplexVector: MathExpression, IComplexVectorExpression
	{
		protected IComplexExpression[] data;
		public ComplexVector(Context context, IComplexExpression[] subs): base(context)
		{
			data = new IComplexExpression[subs.Length];
			for(int y=0;y<subs.Length;y++)
			{
				data[y] = subs[y];
			}
			Init(new EmptyParameters());
		}
		public ValueComplexVector Calculate()
		{
			ValueComplexVector rsp = new ValueComplexVector(data.Length);
			for(int y=0;y<data.Length;y++)
			{
				rsp[y] = data[y].Calculate();
			}
			return(rsp);
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public ComplexVector Expand()
		{
			IComplexExpression[] tmp = new IComplexExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].Expand();
			return new ComplexVector(context,tmp);
		}
		public IComplexVectorExpression SafeExpand()
		{
			IComplexExpression[] tmp = new IComplexExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].SafeExpand();
			return new ComplexVector(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IComplexVectorExpression Simplify()
		{
			IComplexExpression[] tmp = new IComplexExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].Simplify();
			return new ComplexVector(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IComplexVectorExpression Substitute(IExpression original, IExpression replacement)
		{
			IComplexExpression[] tmp = new IComplexExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].Substitute(original, replacement);
			return new ComplexVector(context,tmp);
		}
		public override bool IsEntity
		{
			get {return true;}
		}
		public override bool IsConstant
		{
			get
			{
				bool isc = true;
				foreach(IComplexExpression exp in data)
					isc &= exp.IsConstant;
				return(isc);
			}
		}
		public int Length
		{
			get {return(data.Length);}
		}
		public IComplexMatrixExpression ToMatrix()
		{
			return new ComplexMatrix(context,new IComplexVectorExpression[] {this});
		}
		public IComplexExpression this[int y]
		{
			get {return(data[y]);}
			set	{data[y] = value;}
		}
		internal IComplexExpression[] RawData
		{
			get {return data;}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("[");
			for(int y=0;y<data.Length;y++)
			{
				if(y>0)
					sb.Append(",");
				sb.Append(data[y].ToString());
			}
			sb.Append("]");
			return sb.ToString();
		}
		public override void ConvertChilds(string conversionType)
		{
			for(int y=0;y<data.Length;y++)
				ComplexConversionMap.Convert(ref data[y],conversionType);
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int i=0;i<data.Length;i++)
				data[i].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(ComplexVector))
			{
				ComplexVector x = exp as ComplexVector;
				if(x.Length != this.Length)
					return(false);
				bool eq = true;
				for(int y=0;y<data.Length;y++)
				{
					eq &= data[y].Equals(x[y]);
				}
				if(eq)
					return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Vector,11)]
	public class ComplexMatrix: MathExpression, IComplexMatrixExpression, ICloneable
	{
		protected IComplexExpression[,] data;
		public ComplexMatrix(Context context, IComplexVectorExpression[] subs): base(context)
		{
			try
			{
				int leny = subs[0].Length;
				data = new IComplexExpression[subs.Length,leny];
				for(int x=0;x<subs.Length;x++)
				{
					ComplexVector v = subs[x].Expand();
					for(int y=0;y<leny;y++)
					{
						data[x,y] = v[y];
					}
				}
				Init(new EmptyParameters());
			}
			catch
			{
				throw(new ExpressionRankMismatchException());
			}
		}
		public ComplexMatrix(Context context, IComplexExpression[,] subs): base(context)
		{
			data = subs;
			Init(new EmptyParameters());
		}
		public ValueComplexMatrix Calculate()
		{
			ValueComplexMatrix rsp = new ValueComplexMatrix(data.GetLength(0),data.GetLength(1));
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					rsp[x,y] = data[x,y].Calculate();
			return rsp;
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public ComplexMatrix Expand()
		{
			IComplexExpression[,] tmp = new IComplexExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].Expand();
			return new ComplexMatrix(context,tmp);
		}
		public IComplexMatrixExpression SafeExpand()
		{
			IComplexExpression[,] tmp = new IComplexExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].SafeExpand();
			return new ComplexMatrix(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IComplexMatrixExpression Simplify()
		{
			IComplexExpression[,] tmp = new IComplexExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].Simplify();
			return new ComplexMatrix(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IComplexMatrixExpression Substitute(IExpression original, IExpression replacement)
		{
			IComplexExpression[,] tmp = new IComplexExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].Substitute(original, replacement);
			return new ComplexMatrix(context,tmp);
		}
		public override bool IsEntity
		{
			get {return true;}
		}
		public override bool IsConstant
		{
			get
			{
				bool isc = true;
				foreach(IComplexExpression exp in data)
					isc &= exp.IsConstant;
				return(isc);
			}
		}
		public int LengthX
		{
			get {return data.GetLength(0);}
		}
		public int LengthY
		{
			get {return data.GetLength(1);}
		}
		public IComplexExpression this[int x, int y]
		{
			get {return(data[x,y]);}
			set	{data[x,y] = value;}
		}
		internal IComplexExpression[,] RawData
		{
			get {return data;}
		}
		public object Clone()
		{
			IComplexExpression[,] shallowCopy = (IComplexExpression[,])data.Clone();
			return new ComplexMatrix(context,shallowCopy);
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("[");
			for(int x=0;x<data.GetLength(0);x++)
			{
				if(x>0)
					sb.Append(",");
				sb.Append("[");
				for(int y=0;y<data.GetLength(1);y++)
				{
					if(y>0)
						sb.Append(",");
					sb.Append(data[x,y].ToString());
				}
				sb.Append("]");
			}
			sb.Append("]");
			return sb.ToString();
		}
		public override void ConvertChilds(string conversionType)
		{
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					ComplexConversionMap.Convert(ref data[x,y],conversionType);
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					data[x,y].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(ComplexMatrix))
			{
				ComplexMatrix x = exp as ComplexMatrix;
				if(x.LengthX != this.LengthX || x.LengthY != this.LengthY)
					return(false);
				bool eq = true;
				for(int x1=0;x1<data.GetLength(0);x1++)
					for(int y1=0;y1<data.Length;y1++)
					{
						eq &= data[x1,y1].Equals(x[x1,y1]);
					}
				if(eq)
					return true;
			}
			return false;
		}
		public IComplexVectorExpression GetRowVector(int y)
		{
			IComplexExpression[] se = new IComplexExpression[data.GetLength(0)];
			for(int x=0;x<data.GetLength(0);x++)
			{
				se[x] = data[x,y];
			}
			return(new ComplexVector(context,se));
		}
		public void SetRowVector(int y, IComplexVectorExpression vector)
		{
			ComplexVector ve = vector.Expand();
			for(int x=0;x<vector.Length;x++)
			{
				data[x,y] = ve[x];
			}
		}
		public IComplexVectorExpression GetColumnVector(int x)
		{
			IComplexExpression[] se = new IComplexExpression[data.GetLength(1)];
			for(int y=0;y<data.GetLength(1);y++)
			{
				se[y] = data[x,y];
			}
			return(new ComplexVector(context,se));
		}
		public void SetColumnVector(int x, IComplexVectorExpression vector)
		{
			ComplexVector ve = vector.Expand();
			for(int y=0;y<vector.Length;y++)
			{
				data[x,y] = ve[y];
			}
		}	
	}
	#endregion

	#region Operator Base (deactive)
	/*
	public abstract class BiComplexMatrixOperator
	{
		protected IComplexMatrixExpression first, last;
		private int priority;
		protected BiComplexMatrixOperator(IComplexMatrixExpression first, IComplexMatrixExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IComplexMatrixExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IComplexMatrixExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref first,conversionType);
			ComplexMatrixConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiComplexMatrixOperator x = exp as BiComplexMatrixOperator;
				//override this method if not true!!
				if(x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last) || x.first.IsEqualTo(this.last) && x.last.IsEqualTo(this.first))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class SingleComplexMatrixOperator
	{
		protected IComplexMatrixExpression sub;
		private int priority;
		protected SingleComplexMatrixOperator(IComplexMatrixExpression sub)
		{
			this.sub = sub;
		}
		public IComplexMatrixExpression SubExpression
		{
			set {sub = value;}
			get {return(sub);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(sub.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleComplexMatrixOperator x = exp as SingleComplexMatrixOperator;
				//override this method if not true!!
				if(x.sub.IsEqualTo(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class ScalarComplexMatrixOperator
	{
		protected IComplexMatrixExpression matrix;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarComplexMatrixOperator(IComplexMatrixExpression matrix, IScalarExpression scalar)
		{
			this.matrix = matrix;
			this.scalar = scalar;
		}
		public IComplexMatrixExpression ComplexMatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(matrix.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref matrix,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarComplexMatrixOperator x = exp as ScalarComplexMatrixOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	public abstract class ComplexComplexMatrixOperator
	{
		protected IComplexMatrixExpression matrix;
		protected IComplexExpression complex;
		private int priority;
		protected ComplexComplexMatrixOperator(IComplexMatrixExpression matrix, IComplexExpression complex)
		{
			this.matrix = matrix;
			this.complex = complex;
		}
		public IComplexMatrixExpression ComplexMatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IComplexExpression ComplexExpression
		{
			set {complex = value;}
			get {return(complex);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(matrix.IsConstant && complex.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref matrix,conversionType);
			ComplexConversionMap.Convert(ref complex,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ComplexComplexMatrixOperator x = exp as ComplexComplexMatrixOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.complex.IsEqualTo(this.complex))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
		}
	}
	public abstract class BiComplexComplexMatrixOperator
	{
		protected IComplexMatrixExpression matrix;
		protected IComplexExpression first, last;
		private int priority;
		protected BiComplexComplexMatrixOperator(IComplexMatrixExpression matrix, IComplexExpression first, IComplexExpression last)
		{
			this.matrix = matrix;
			this.first = first;
			this.last = last;
		}
		public IComplexMatrixExpression ComplexMatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IComplexExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IComplexExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(matrix.IsConstant && first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref matrix,conversionType);
			ComplexConversionMap.Convert(ref first,conversionType);
			ComplexConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiComplexComplexMatrixOperator x = exp as BiComplexComplexMatrixOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class ScalarComplexComplexMatrixOperator
	{
		protected IComplexMatrixExpression matrix;
		protected IComplexExpression complex;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarComplexComplexMatrixOperator(IComplexMatrixExpression matrix, IScalarExpression scalar, IComplexExpression complex)
		{
			this.matrix = matrix;
			this.complex = complex;
			this.scalar = scalar;
		}
		public IComplexMatrixExpression ComplexMatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IComplexExpression ComplexExpression
		{
			set {complex = value;}
			get {return(complex);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(matrix.IsConstant && scalar.IsConstant && complex.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref matrix,conversionType);
			ComplexConversionMap.Convert(ref complex,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarComplexComplexMatrixOperator x = exp as ScalarComplexComplexMatrixOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.scalar.IsEqualTo(this.scalar) && x.complex.IsEqualTo(this.complex))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	public abstract class ComplexMatrixComplexVectorOperator
	{
		protected IComplexMatrixExpression matrix;
		protected IComplexVectorExpression vector;
		private int priority;
		protected ComplexMatrixComplexVectorOperator(IComplexMatrixExpression matrix, IComplexVectorExpression vector)
		{
			this.matrix = matrix;
			this.vector = vector;
		}
		public IComplexMatrixExpression ComplexMatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IComplexVectorExpression ComplexVectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(vector.IsConstant && matrix.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref matrix,conversionType);
			ComplexVectorConversionMap.Convert(ref vector,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ComplexMatrixComplexVectorOperator x = exp as ComplexMatrixComplexVectorOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.vector.IsEqualTo(this.vector))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			vector.CollectVariables(vars,deep);
		}
	}
	public abstract class BiComplexVectorOperator
	{
		protected IComplexVectorExpression first, last;
		private int priority;
		protected BiComplexVectorOperator(IComplexVectorExpression first, IComplexVectorExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IComplexVectorExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IComplexVectorExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref first,conversionType);
			ComplexVectorConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiComplexVectorOperator x = exp as BiComplexVectorOperator;
				//override this method if not true!!
				if(x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last) || x.first.IsEqualTo(this.last) && x.last.IsEqualTo(this.first))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class SingleComplexVectorOperator
	{
		protected IComplexVectorExpression sub;
		private int priority;
		protected SingleComplexVectorOperator(IComplexVectorExpression sub)
		{
			this.sub = sub;
		}
		public IComplexVectorExpression SubExpression
		{
			set {sub = value;}
			get {return(sub);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(sub.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleComplexVectorOperator x = exp as SingleComplexVectorOperator;
				//override this method if not true!!
				if(x.sub.IsEqualTo(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class ScalarComplexVectorOperator
	{
		protected IComplexVectorExpression vector;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarComplexVectorOperator(IComplexVectorExpression vector, IScalarExpression scalar)
		{
			this.vector = vector;
			this.scalar = scalar;
		}
		public IComplexVectorExpression ComplexVectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(vector.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref vector,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarComplexVectorOperator x = exp as ScalarComplexVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			scalar.CollectVariables(vars,deep);
			vector.CollectVariables(vars,deep);
		}
	}
	public abstract class ComplexComplexVectorOperator
	{
		protected IComplexVectorExpression vector;
		protected IComplexExpression complex;
		private int priority;
		protected ComplexComplexVectorOperator(IComplexVectorExpression vector, IComplexExpression complex)
		{
			this.vector = vector;
			this.complex = complex;
		}
		public IComplexVectorExpression ComplexVectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IComplexExpression ComplexExpression
		{
			set {complex = value;}
			get {return(complex);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(vector.IsConstant && complex.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref vector,conversionType);
			ComplexConversionMap.Convert(ref complex,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ComplexComplexVectorOperator x = exp as ComplexComplexVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.complex.IsEqualTo(this.complex))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			vector.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
		}
	}
	public abstract class BiComplexComplexVectorOperator
	{
		protected IComplexVectorExpression vector;
		protected IComplexExpression first, last;
		private int priority;
		protected BiComplexComplexVectorOperator(IComplexVectorExpression vector, IComplexExpression first, IComplexExpression last)
		{
			this.vector = vector;
			this.first = first;
			this.last = last;
		}
		public IComplexVectorExpression ComplexVectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IComplexExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IComplexExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(vector.IsConstant && first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref vector,conversionType);
			ComplexConversionMap.Convert(ref first,conversionType);
			ComplexConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiComplexComplexVectorOperator x = exp as BiComplexComplexVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			vector.CollectVariables(vars,deep);
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class TriComplexComplexVectorOperator
	{
		protected IComplexVectorExpression vector;
		protected IComplexExpression first, middle, last;
		private int priority;
		protected TriComplexComplexVectorOperator(IComplexVectorExpression vector, IComplexExpression first, IComplexExpression middle, IComplexExpression last)
		{
			this.vector = vector;
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public IComplexVectorExpression ComplexVectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IComplexExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IComplexExpression MiddleExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public IComplexExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(vector.IsConstant && first.IsConstant && middle.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref vector,conversionType);
			ComplexConversionMap.Convert(ref first,conversionType);
			ComplexConversionMap.Convert(ref middle,conversionType);
			ComplexConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriComplexComplexVectorOperator x = exp as TriComplexComplexVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.first.IsEqualTo(this.first) && x.middle.IsEqualTo(this.middle) && x.last.IsEqualTo(this.last))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			vector.CollectVariables(vars,deep);
			first.CollectVariables(vars,deep);
			middle.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class ScalarComplexComplexVectorOperator
	{
		protected IComplexVectorExpression vector;
		protected IComplexExpression complex;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarComplexComplexVectorOperator(IComplexVectorExpression vector, IScalarExpression scalar, IComplexExpression complex)
		{
			this.vector = vector;
			this.complex = complex;
			this.scalar = scalar;
		}
		public IComplexVectorExpression ComplexVectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IComplexExpression ComplexExpression
		{
			set {complex = value;}
			get {return(complex);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(vector.IsConstant && scalar.IsConstant && complex.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref vector,conversionType);
			ComplexConversionMap.Convert(ref complex,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarComplexComplexVectorOperator x = exp as ScalarComplexComplexVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.scalar.IsEqualTo(this.scalar) && x.complex.IsEqualTo(this.complex))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			vector.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	*/
	#endregion

	#region Typed Operator Base -> To Complex (deactive)
	/*
	public abstract class BiComplexMatrixToComplexOperator: BiComplexMatrixOperator
	{
		protected BiComplexMatrixToComplexOperator(IComplexMatrixExpression first, IComplexMatrixExpression last): base(first, last) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	public abstract class SingleComplexMatrixToComplexOperator: SingleComplexMatrixOperator
	{
		protected SingleComplexMatrixToComplexOperator(IComplexMatrixExpression sub): base(sub) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	public abstract class BiComplexVectorToComplexOperator: BiComplexVectorOperator
	{
		protected BiComplexVectorToComplexOperator(IComplexVectorExpression first, IComplexVectorExpression last): base(first, last) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	public abstract class SingleComplexVectorToComplexOperator: SingleComplexVectorOperator
	{
		protected SingleComplexVectorToComplexOperator(IComplexVectorExpression sub): base(sub) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	public abstract class TriComplexComplexVectorToComplexOperator: TriComplexComplexVectorOperator
	{
		protected TriComplexComplexVectorToComplexOperator(IComplexVectorExpression vector, IComplexExpression first, IComplexExpression middle, IComplexExpression last): base(vector,first,middle,last) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	*/
	#endregion
	#region Typed Operator Base -> To ComplexMatrix (deactive)
	/*
	public abstract class ComplexMatrixComplexVectorToComplexMatrixOperator: ComplexMatrixComplexVectorOperator
	{
		protected ComplexMatrixComplexVectorToComplexMatrixOperator(IComplexMatrixExpression matrix, IComplexVectorExpression vector): base(matrix, vector) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	public abstract class BiComplexMatrixToComplexMatrixOperator: BiComplexMatrixOperator
	{
		protected BiComplexMatrixToComplexMatrixOperator(IComplexMatrixExpression first, IComplexMatrixExpression last): base(first, last) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	public abstract class SingleComplexMatrixToComplexMatrixOperator: SingleComplexMatrixOperator
	{
		protected SingleComplexMatrixToComplexMatrixOperator(IComplexMatrixExpression sub): base(sub) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	public abstract class ScalarComplexMatrixToComplexMatrixOperator: ScalarComplexMatrixOperator
	{
		protected ScalarComplexMatrixToComplexMatrixOperator(IComplexMatrixExpression matrix, IScalarExpression scalar): base(matrix, scalar) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	public abstract class ComplexComplexMatrixToComplexMatrixOperator: ComplexComplexMatrixOperator
	{
		protected ComplexComplexMatrixToComplexMatrixOperator(IComplexMatrixExpression matrix, IComplexExpression complex): base(matrix, complex) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	public abstract class BiComplexComplexMatrixToComplexMatrixOperator: BiComplexComplexMatrixOperator
	{
		protected BiComplexComplexMatrixToComplexMatrixOperator(IComplexMatrixExpression matrix, IComplexExpression first, IComplexExpression last): base(matrix, first, last) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	public abstract class ComplexScalarMatrixToComplexMatrixOperator: ComplexScalarMatrixOperator
	{
		protected ComplexScalarMatrixToComplexMatrixOperator(IMatrixExpression matrix, IComplexExpression complex, IScalarExpression scalar): base(matrix, complex, scalar) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ComplexMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[] se = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ComplexVector(se));
		}
		public virtual ValueComplexMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IComplexMatrixExpression Simplify()
		{
			ComplexMatrix me = ExpressionMatrix;
			IComplexExpression[,] tmp = new IComplexExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ComplexMatrix(tmp));
		}
	}
	*/
	#endregion
	#region Typed Operator Base -> To ComplexVector (deactive)
	/*
	public abstract class ComplexMatrixComplexVectorToComplexVectorOperator: ComplexMatrixComplexVectorOperator
	{
		protected ComplexMatrixComplexVectorToComplexVectorOperator(IComplexMatrixExpression matrix, IComplexVectorExpression vector): base(matrix, vector) {}
		public abstract int Length
		{
			get;
		}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	public abstract class BiComplexVectorToComplexVectorOperator: BiComplexVectorOperator
	{
		protected BiComplexVectorToComplexVectorOperator(IComplexVectorExpression first, IComplexVectorExpression last): base(first, last) {}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	public abstract class SingleComplexVectorToComplexVectorOperator: SingleComplexVectorOperator
	{
		protected SingleComplexVectorToComplexVectorOperator(IComplexVectorExpression sub): base(sub) {}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	public abstract class ScalarComplexVectorToComplexVectorOperator: ScalarComplexVectorOperator
	{
		protected ScalarComplexVectorToComplexVectorOperator(IComplexVectorExpression vector, IScalarExpression scalar): base(vector, scalar) {}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	public abstract class ComplexComplexVectorToComplexVectorOperator: ComplexComplexVectorOperator
	{
		protected ComplexComplexVectorToComplexVectorOperator(IComplexVectorExpression vector, IComplexExpression complex): base(vector, complex) {}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	public abstract class BiComplexComplexVectorToComplexVectorOperator: BiComplexComplexVectorOperator
	{
		protected BiComplexComplexVectorToComplexVectorOperator(IComplexVectorExpression vector, IComplexExpression first, IComplexExpression last): base(vector, first, last) {}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	public abstract class ComplexScalarVectorToComplexVectorOperator: ComplexScalarVectorOperator
	{
		protected ComplexScalarVectorToComplexVectorOperator(IVectorExpression vector, IComplexExpression complex, IScalarExpression scalar): base(vector, complex, scalar) {}
		public abstract ComplexVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IComplexMatrixExpression ToMatrix()
		{
			return(new ComplexMatrix(new IComplexVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueComplexVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IComplexVectorExpression Simplify()
		{
			ComplexVector ve = ExpressionVector;
			IComplexExpression[] tmp = new IComplexExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ComplexVector(tmp));
		}
	}
	*/
	#endregion

	#region Matrix Conversion Maps
	public abstract class ComplexMatrixMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IComplexMatrixExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IComplexMatrixExpression ex = exp as IComplexMatrixExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class ComplexMatrixConversionMap
	{
		public static void Convert(ref IComplexMatrixExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(ComplexMatrixMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	#endregion

	#region Vector Conversion Maps
	public abstract class ComplexVectorMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IComplexVectorExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IComplexVectorExpression ex = exp as IComplexVectorExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class ComplexVectorConversionMap
	{
		public static void Convert(ref IComplexVectorExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(ComplexVectorMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	#endregion
}
