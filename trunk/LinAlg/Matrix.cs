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
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Complex.LinearAlgebra;

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	#region Vector Type
	/// <summary>
	/// Math.NET type: a vector (of scalars) expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Vector,0)]
	public interface IVectorExpression: IExpression
	{
		/// <summary>
		/// calculate the axis components as real doubles
		/// </summary>
		ValueVector Calculate();
		/// <summary>
		/// the dimension of the vector
		/// </summary>
		int Length {get;}
		/// <summary>
		/// simplifies the vector expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IVectorExpression Simplify();
		/// <summary>
		/// expands the vector expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ScalarVector Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IVectorExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IVectorExpression Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// generates a matrix containing the vertical vector
		/// </summary>
		/// <returns>a matrix representing the vector</returns>
		IMatrixExpression ToMatrix();
	}
	public class ValueVector
	{
		protected double[] data;
		public ValueVector(int dim)
		{
			data = new Double[dim];
		}
		public int Length
		{
			get {return(data.Length);}
		}
		public double this[int y]
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
				sb.Append(data[y]);
			}
			sb.Append("]");
			return(sb.ToString());
		}
	}
	#endregion

	#region Matrix Type
	/// <summary>
	/// Math.NET type: a matrix (of scalars) expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Vector,0)]
	public interface IMatrixExpression: IExpression
	{
		/// <summary>
		/// calculate the components as real doubles
		/// </summary>
		ValueMatrix Calculate();
		/// <summary>
		/// the dimension of the x-axis
		/// </summary>
		int LengthX {get;}
		/// <summary>
		/// the dimension of the y-axis
		/// </summary>
		int LengthY {get;}
		/// <summary>
		/// simplifies the matrix expression
		/// </summary>
		/// <returns>the simplfied expression</returns>
		IMatrixExpression Simplify();
		/// <summary>
		/// expands the matrix expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ScalarMatrix Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IMatrixExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IMatrixExpression Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// generates a vector containing the specified row
		/// </summary>
		/// <param name="y">the row index to build the vector of</param>
		/// <returns>the selected row as a vector</returns>
		IVectorExpression GetRowVector(int y);
		/// <summary>
		/// generates a vector containing the specified column
		/// </summary>
		/// <param name="x">the column index to build the vector of</param>
		/// <returns>the selected column as a vector</returns>
		IVectorExpression GetColumnVector(int x);
	}
	public class ValueMatrix
	{
		protected double[,] data;
		public ValueMatrix(int x, int y)
		{
			data = new Double[x,y];
		}
		
		public ValueMatrix(double[,] doubleMatrix)
		{
			data = doubleMatrix;
		}

		public int LengthX
		{
			get {return(data.GetLength(0));}
		}
		public int LengthY
		{
			get {return(data.GetLength(1));}
		}
		public double this[int x, int y]
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

		public double[,] Data
		{
			get { return data; }
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
					sb.Append(data[x,y]);
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
	public class ScalarVector: MathExpression, IVectorExpression
	{
		protected IScalarExpression[] data;
		public ScalarVector(Context context, IScalarExpression[] subs): base(context)
		{
			data = new IScalarExpression[subs.Length];
			for(int y=0;y<subs.Length;y++)
				data[y] = subs[y];
			Init(new EmptyParameters());
		}
		public ValueVector Calculate()
		{
			ValueVector rsp = new ValueVector(data.Length);
			for(int y=0;y<data.Length;y++)
			{
				rsp[y] = data[y].Calculate();
			}
			return rsp;
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public ScalarVector Expand()
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].Expand();
			return new ScalarVector(context,tmp);
		}
		public IVectorExpression SafeExpand()
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].SafeExpand();
			return new ScalarVector(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IVectorExpression Simplify()
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].Simplify();
			return new ScalarVector(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IVectorExpression Substitute(IExpression original, IExpression replacement)
		{
			IScalarExpression[] tmp = new IScalarExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = data[i].Substitute(original, replacement);
			return new ScalarVector(context,tmp);
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
				foreach(IScalarExpression exp in data)
					isc &= exp.IsConstant;
				return isc;
			}
		}
		public int Length
		{
			get {return data.Length;}
		}
		public IMatrixExpression ToMatrix()
		{
			return new ScalarMatrix(context,new IVectorExpression[] {this});
		}
		public IScalarExpression this[int y]
		{
			get {return(data[y]);}
			set	{data[y] = value;}
		}
		internal IScalarExpression[] RawData
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
				ScalarConversionMap.Convert(ref data[y],conversionType);
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int i=0;i<data.Length;i++)
				data[i].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(ScalarVector))
			{
				ScalarVector x = exp as ScalarVector;
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
	public class ScalarMatrix: MathExpression, IMatrixExpression, ICloneable
	{
		protected IScalarExpression[,] data;
		public ScalarMatrix(Context context, IVectorExpression[] subs): base(context)
		{
			try
			{
				int leny = subs[0].Length;
				data = new IScalarExpression[subs.Length,leny];
				for(int x=0;x<subs.Length;x++)
				{
					ScalarVector v = subs[x].Expand();
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
		public ScalarMatrix(Context context, cdrnet.Lib.MathLib.Scalar.Geometry.ITripleExpression[] subs): base(context)
		{
			data = new IScalarExpression[subs.Length,3];
			for(int x=0;x<subs.Length;x++)
			{
				data[x,0] = subs[x].ExpandX();
				data[x,1] = subs[x].ExpandY();
				data[x,2] = subs[x].ExpandZ();
			}
			Init(new EmptyParameters());
		}
		public ScalarMatrix(Context context, IScalarExpression[,] subs): base(context)
		{
			data = subs;
			Init(new EmptyParameters());
		}
		public ValueMatrix Calculate()
		{
			ValueMatrix rsp = new ValueMatrix(data.GetLength(0),data.GetLength(1));
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					rsp[x,y] = data[x,y].Calculate();
			return rsp;
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public ScalarMatrix Expand()
		{
			IScalarExpression[,] tmp = new IScalarExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].Expand();
			return new ScalarMatrix(context,tmp);
		}
		public IMatrixExpression SafeExpand()
		{
			IScalarExpression[,] tmp = new IScalarExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].SafeExpand();
			return new ScalarMatrix(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IMatrixExpression Simplify()
		{
			IScalarExpression[,] tmp = new IScalarExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].Simplify();
			return new ScalarMatrix(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IMatrixExpression Substitute(IExpression original, IExpression replacement)
		{
			IScalarExpression[,] tmp = new IScalarExpression[data.GetLength(0),data.GetLength(1)];
			for(int x=0;x<data.GetLength(0);x++)
				for(int y=0;y<data.GetLength(1);y++)
					tmp[x,y] = data[x,y].Substitute(original, replacement);
			return new ScalarMatrix(context,tmp);
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
				foreach(IScalarExpression exp in data)
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
		public IScalarExpression this[int x, int y]
		{
			get {return(data[x,y]);}
			set	{data[x,y] = value;}
		}
		internal IScalarExpression[,] RawData
		{
			get {return data ;}
		}
		public object Clone()
		{
			IScalarExpression[,] shallowCopy = (IScalarExpression[,])data.Clone();
			return new ScalarMatrix(context,shallowCopy);
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
					ScalarConversionMap.Convert(ref data[x,y],conversionType);
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					data[x,y].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(ScalarMatrix))
			{
				ScalarMatrix x = exp as ScalarMatrix;
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
		public IVectorExpression GetRowVector(int y)
		{
			IScalarExpression[] se = new IScalarExpression[data.GetLength(0)];
			for(int x=0;x<data.GetLength(0);x++)
			{
				se[x] = data[x,y];
			}
			return new ScalarVector(context,se);
		}
		public void SetRowVector(int y, IVectorExpression vector)
		{
			ScalarVector ve = vector.Expand();
			for(int x=0;x<vector.Length;x++)
			{
				data[x,y] = ve[x];
			}
		}
		public IVectorExpression GetColumnVector(int x)
		{
			IScalarExpression[] se = new IScalarExpression[data.GetLength(1)];
			for(int y=0;y<data.GetLength(1);y++)
			{
				se[y] = data[x,y];
			}
			return new ScalarVector(context,se);
		}
		public void SetColumnVector(int x, IVectorExpression vector)
		{
			ScalarVector ve = vector.Expand();
			for(int y=0;y<vector.Length;y++)
			{
				data[x,y] = ve[y];
			}
		}
	}
	#endregion

	#region Operator Base (deactive)
	/*
	public abstract class BiMatrixOperator
	{
		protected IMatrixExpression first, last;
		private int priority;
		protected BiMatrixOperator(IMatrixExpression first, IMatrixExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IMatrixExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IMatrixExpression AfterExpression
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
			MatrixConversionMap.Convert(ref first,conversionType);
			MatrixConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiMatrixOperator x = exp as BiMatrixOperator;
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
	public abstract class SingleMatrixOperator
	{
		protected IMatrixExpression sub;
		private int priority;
		protected SingleMatrixOperator(IMatrixExpression sub)
		{
			this.sub = sub;
		}
		public IMatrixExpression SubExpression
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
			MatrixConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleMatrixOperator x = exp as SingleMatrixOperator;
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
	public abstract class ScalarMatrixOperator
	{
		protected IMatrixExpression matrix;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarMatrixOperator(IMatrixExpression matrix, IScalarExpression scalar)
		{
			this.matrix = matrix;
			this.scalar = scalar;
		}
		public IMatrixExpression MatrixExpression
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
			MatrixConversionMap.Convert(ref matrix,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarMatrixOperator x = exp as ScalarMatrixOperator;
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
	public abstract class ScalarBiMatrixOperator
	{
		protected IMatrixExpression first, last;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarBiMatrixOperator(IMatrixExpression first, IMatrixExpression last, IScalarExpression scalar)
		{
			this.first = first;
			this.last = last;
			this.scalar = scalar;
		}
		public IMatrixExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IMatrixExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
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
			get {return(first.IsConstant && last.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref first,conversionType);
			MatrixConversionMap.Convert(ref last,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarBiMatrixOperator x = exp as ScalarBiMatrixOperator;
				if(x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	public abstract class BiScalarBiMatrixOperator
	{
		protected IMatrixExpression firstmatrix, lastmatrix;
		protected IScalarExpression firstscalar, lastscalar;
		private int priority;
		protected BiScalarBiMatrixOperator(IMatrixExpression firstmatrix, IMatrixExpression lastmatrix, IScalarExpression firstscalar, IScalarExpression lastscalar)
		{
			this.firstmatrix = firstmatrix;
			this.lastmatrix = lastmatrix;
			this.firstscalar = firstscalar;
			this.lastscalar = lastscalar;
		}
		public IMatrixExpression PreMatrixExpression
		{
			set {firstmatrix = value;}
			get {return(firstmatrix);}
		}
		public IMatrixExpression AfterMatrixExpression
		{
			set {lastmatrix = value;}
			get {return(lastmatrix);}
		}
		public IScalarExpression PreScalarExpression
		{
			set {firstscalar = value;}
			get {return(firstscalar);}
		}
		public IScalarExpression AfterScalarExpression
		{
			set {lastscalar = value;}
			get {return(lastscalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(firstmatrix.IsConstant && lastmatrix.IsConstant && firstscalar.IsConstant && lastscalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref firstmatrix,conversionType);
			MatrixConversionMap.Convert(ref lastmatrix,conversionType);
			ScalarConversionMap.Convert(ref firstscalar,conversionType);
			ScalarConversionMap.Convert(ref lastscalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiScalarBiMatrixOperator x = exp as BiScalarBiMatrixOperator;
				if(x.firstmatrix.IsEqualTo(this.firstmatrix) && x.lastmatrix.IsEqualTo(this.lastmatrix) && x.firstscalar.IsEqualTo(this.firstscalar) && x.lastscalar.IsEqualTo(this.lastscalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			firstmatrix.CollectVariables(vars,deep);
			lastmatrix.CollectVariables(vars,deep);
			firstscalar.CollectVariables(vars,deep);
			lastscalar.CollectVariables(vars,deep);
		}
	}
	public abstract class BiScalarMatrixOperator
	{
		protected IMatrixExpression matrix;
		protected IScalarExpression first, last;
		private int priority;
		protected BiScalarMatrixOperator(IMatrixExpression matrix, IScalarExpression first, IScalarExpression last)
		{
			this.matrix = matrix;
			this.first = first;
			this.last = last;
		}
		public IMatrixExpression MatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IScalarExpression PreScalarExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression AfterScalarExpression
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
			MatrixConversionMap.Convert(ref matrix,conversionType);
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiScalarMatrixOperator x = exp as BiScalarMatrixOperator;
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
	public abstract class FourScalarMatrixOperator
	{
		protected IMatrixExpression matrix;
		protected IScalarExpression first, second, third, fourth;
		private int priority;
		protected FourScalarMatrixOperator(IMatrixExpression matrix, IScalarExpression first, IScalarExpression second, IScalarExpression third, IScalarExpression fourth)
		{
			this.matrix = matrix;
			this.first = first;
			this.second = second;
			this.third = third;
			this.fourth = fourth;
		}
		public IMatrixExpression MatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IScalarExpression FirstScalarExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression SecondScalarExpression
		{
			set {second = value;}
			get {return(second);}
		}
		public IScalarExpression ThirdScalarExpression
		{
			set {third = value;}
			get {return(third);}
		}
		public IScalarExpression FourthScalarExpression
		{
			set {fourth = value;}
			get {return(fourth);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(matrix.IsConstant && first.IsConstant && second.IsConstant && third.IsConstant && fourth.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref matrix,conversionType);
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref second,conversionType);
			ScalarConversionMap.Convert(ref third,conversionType);
			ScalarConversionMap.Convert(ref fourth,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				FourScalarMatrixOperator x = exp as FourScalarMatrixOperator;
				if(x.matrix.IsEqualTo(this.matrix) && x.first.IsEqualTo(this.first) && x.second.IsEqualTo(this.second) && x.third.IsEqualTo(this.third) && fourth.IsEqualTo(this.fourth))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			first.CollectVariables(vars,deep);
			second.CollectVariables(vars,deep);
			third.CollectVariables(vars,deep);
			fourth.CollectVariables(vars,deep);
		}
	}
	public abstract class ComplexScalarMatrixOperator
	{
		protected IMatrixExpression matrix;
		protected IScalarExpression scalar;
		protected IComplexExpression complex;
		private int priority;
		protected ComplexScalarMatrixOperator(IMatrixExpression matrix, IComplexExpression complex, IScalarExpression scalar)
		{
			this.matrix = matrix;
			this.scalar = scalar;
			this.complex = complex;
		}
		public IMatrixExpression MatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
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
			get {return(matrix.IsConstant && complex.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref matrix,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
			ComplexConversionMap.Convert(ref complex,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ComplexScalarMatrixOperator x = exp as ComplexScalarMatrixOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.complex.IsEqualTo(this.complex) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
		}
	}
	public abstract class MatrixVectorOperator
	{
		protected IMatrixExpression matrix;
		protected IVectorExpression vector;
		private int priority;
		protected MatrixVectorOperator(IMatrixExpression matrix, IVectorExpression vector)
		{
			this.matrix = matrix;
			this.vector = vector;
		}
		public IMatrixExpression MatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IVectorExpression VectorExpression
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
			MatrixConversionMap.Convert(ref matrix,conversionType);
			VectorConversionMap.Convert(ref vector,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				MatrixVectorOperator x = exp as MatrixVectorOperator;
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
	public abstract class ScalarMatrixVectorOperator
	{
		protected IMatrixExpression matrix;
		protected IVectorExpression vector;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarMatrixVectorOperator(IMatrixExpression matrix, IVectorExpression vector, IScalarExpression scalar)
		{
			this.matrix = matrix;
			this.vector = vector;
			this.scalar = scalar;
		}
		public IMatrixExpression MatrixExpression
		{
			set {matrix = value;}
			get {return(matrix);}
		}
		public IVectorExpression VectorExpression
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
			get {return(vector.IsConstant && matrix.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref matrix,conversionType);
			VectorConversionMap.Convert(ref vector,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarMatrixVectorOperator x = exp as ScalarMatrixVectorOperator;
				//override this method if not true!!
				if(x.matrix.IsEqualTo(this.matrix) && x.vector.IsEqualTo(this.vector) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			matrix.CollectVariables(vars,deep);
			vector.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	public abstract class BiVectorOperator
	{
		protected IVectorExpression first, last;
		private int priority;
		protected BiVectorOperator(IVectorExpression first, IVectorExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IVectorExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IVectorExpression AfterExpression
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
			VectorConversionMap.Convert(ref first,conversionType);
			VectorConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiVectorOperator x = exp as BiVectorOperator;
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
	public abstract class SingleVectorOperator
	{
		protected IVectorExpression sub;
		private int priority;
		protected SingleVectorOperator(IVectorExpression sub)
		{
			this.sub = sub;
		}
		public IVectorExpression SubExpression
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
			VectorConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleVectorOperator x = exp as SingleVectorOperator;
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
	public abstract class ScalarVectorOperator
	{
		protected IVectorExpression vector;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarVectorOperator(IVectorExpression vector, IScalarExpression scalar)
		{
			this.vector = vector;
			this.scalar = scalar;
		}
		public IVectorExpression VectorExpression
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
			VectorConversionMap.Convert(ref vector,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarVectorOperator x = exp as ScalarVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			vector.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	public abstract class BiScalarVectorOperator
	{
		protected IVectorExpression vector;
		protected IScalarExpression first, last;
		private int priority;
		protected BiScalarVectorOperator(IVectorExpression vector, IScalarExpression first, IScalarExpression last)
		{
			this.vector = vector;
			this.first = first;
			this.last = last;
		}
		public IVectorExpression VectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IScalarExpression PreScalarExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression AfterScalarExpression
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
			VectorConversionMap.Convert(ref vector,conversionType);
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiScalarVectorOperator x = exp as BiScalarVectorOperator;
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
	public abstract class BiScalarBiVectorOperator
	{
		protected IVectorExpression firstvector, lastvector;
		protected IScalarExpression firstscalar, lastscalar;
		private int priority;
		protected BiScalarBiVectorOperator(IVectorExpression firstvector, IVectorExpression lastvector, IScalarExpression firstscalar, IScalarExpression lastscalar)
		{
			this.firstvector = firstvector;
			this.lastvector = lastvector;
			this.firstscalar = firstscalar;
			this.lastscalar = lastscalar;
		}
		public IVectorExpression PreVectorExpression
		{
			set {firstvector = value;}
			get {return(firstvector);}
		}
		public IVectorExpression AfterVectorExpression
		{
			set {lastvector = value;}
			get {return(lastvector);}
		}
		public IScalarExpression PreScalarExpression
		{
			set {firstscalar = value;}
			get {return(firstscalar);}
		}
		public IScalarExpression AfterScalarExpression
		{
			set {lastscalar = value;}
			get {return(lastscalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(firstvector.IsConstant && lastvector.IsConstant && firstscalar.IsConstant && lastscalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			VectorConversionMap.Convert(ref firstvector,conversionType);
			VectorConversionMap.Convert(ref lastvector,conversionType);
			ScalarConversionMap.Convert(ref firstscalar,conversionType);
			ScalarConversionMap.Convert(ref lastscalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiScalarBiVectorOperator x = exp as BiScalarBiVectorOperator;
				if(x.firstvector.IsEqualTo(this.firstvector) && x.lastvector.IsEqualTo(this.lastvector) && x.firstscalar.IsEqualTo(this.firstscalar) && x.lastscalar.IsEqualTo(this.lastscalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			firstvector.CollectVariables(vars,deep);
			lastvector.CollectVariables(vars,deep);
			firstscalar.CollectVariables(vars,deep);
			lastscalar.CollectVariables(vars,deep);
		}
	}
	public abstract class TriScalarVectorOperator
	{
		protected IVectorExpression vector;
		protected IScalarExpression first, middle, last;
		private int priority;
		protected TriScalarVectorOperator(IVectorExpression vector, IScalarExpression first, IScalarExpression middle, IScalarExpression last)
		{
			this.vector = vector;
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public IVectorExpression VectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IScalarExpression PreScalarExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression MiddleScalarExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public IScalarExpression AfterScalarExpression
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
			VectorConversionMap.Convert(ref vector,conversionType);
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref middle,conversionType);
			ScalarConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriScalarVectorOperator x = exp as TriScalarVectorOperator;
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
	public abstract class ComplexScalarVectorOperator
	{
		protected IVectorExpression vector;
		protected IScalarExpression scalar;
		protected IComplexExpression complex;
		private int priority;
		protected ComplexScalarVectorOperator(IVectorExpression vector, IComplexExpression complex, IScalarExpression scalar)
		{
			this.vector = vector;
			this.scalar = scalar;
			this.complex = complex;
		}
		public IVectorExpression VectorExpression
		{
			set {vector = value;}
			get {return(vector);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
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
			get {return(vector.IsConstant && complex.IsConstant && scalar.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			VectorConversionMap.Convert(ref vector,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
			ComplexConversionMap.Convert(ref complex,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ComplexScalarVectorOperator x = exp as ComplexScalarVectorOperator;
				//override this method if not true!!
				if(x.vector.IsEqualTo(this.vector) && x.complex.IsEqualTo(this.complex) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			vector.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
		}
	}
	*/
	#endregion

	#region Typed Operator Base -> To Matrix (deactive)
	/*
	public abstract class BiMatrixToMatrixOperator: BiMatrixOperator
	{
		protected BiMatrixToMatrixOperator(IMatrixExpression first, IMatrixExpression last): base(first, last) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class BiVectorToMatrixOperator: BiVectorOperator
	{
		protected BiVectorToMatrixOperator(IVectorExpression first, IVectorExpression last): base(first, last) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class SingleMatrixToMatrixOperator: SingleMatrixOperator
	{
		protected SingleMatrixToMatrixOperator(IMatrixExpression sub): base(sub) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class ScalarMatrixToMatrixOperator: ScalarMatrixOperator
	{
		protected ScalarMatrixToMatrixOperator(IMatrixExpression matrix, IScalarExpression scalar): base(matrix, scalar) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class ScalarBiMatrixToMatrixOperator: ScalarBiMatrixOperator
	{
		protected ScalarBiMatrixToMatrixOperator(IMatrixExpression first, IMatrixExpression last, IScalarExpression scalar): base(first, last, scalar) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class BiScalarBiMatrixToMatrixOperator: BiScalarBiMatrixOperator
	{
		protected BiScalarBiMatrixToMatrixOperator(IMatrixExpression firstmatrix, IMatrixExpression lastmatrix, IScalarExpression firstscalar, IScalarExpression lastscalar): base(firstmatrix, lastmatrix, firstscalar, lastscalar) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class BiScalarMatrixToMatrixOperator: BiScalarMatrixOperator
	{
		protected BiScalarMatrixToMatrixOperator(IMatrixExpression matrix, IScalarExpression first, IScalarExpression last): base(matrix, first, last) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class FourScalarMatrixToMatrixOperator: FourScalarMatrixOperator
	{
		protected FourScalarMatrixToMatrixOperator(IMatrixExpression matrix, IScalarExpression first, IScalarExpression second, IScalarExpression third, IScalarExpression fourth): base(matrix, first, second, third, fourth) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class ScalarComplexComplexMatrixToMatrixOperator: ScalarComplexComplexMatrixOperator
	{
		protected ScalarComplexComplexMatrixToMatrixOperator(IComplexMatrixExpression matrix, IScalarExpression scalar, IComplexExpression complex): base(matrix, scalar, complex) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class MatrixVectorToMatrixOperator: MatrixVectorOperator
	{
		protected MatrixVectorToMatrixOperator(IMatrixExpression matrix, IVectorExpression vector): base(matrix, vector) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	public abstract class ScalarMatrixVectorToMatrixOperator: ScalarMatrixVectorOperator
	{
		protected ScalarMatrixVectorToMatrixOperator(IMatrixExpression matrix, IVectorExpression vector, IScalarExpression scalar): base(matrix, vector, scalar) {}
		public abstract int LengthX
		{
			get;
		}
		public abstract int LengthY
		{
			get;
		}
		public abstract ScalarMatrix ExpressionMatrix
		{
			get;
		}
		public virtual IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
			{
				se[x] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
			{
				se[y] = me[x,y];
			}
			return(new ScalarVector(se));
		}
		public virtual ValueMatrix Calculate()
		{
			return(this.ExpressionMatrix.Calculate());
		}
		public IMatrixExpression Simplify()
		{
			ScalarMatrix me = ExpressionMatrix;
			IScalarExpression[,] tmp = new IScalarExpression[me.LengthX,me.LengthY];
			for(int x=0;x<me.LengthX;x++)
				for(int y=0;y<me.LengthY;y++)
					tmp[x,y] = me[x,y].Simplify();
			return(new ScalarMatrix(tmp));
		}
	}
	*/
	#endregion
	#region Typed Operator Base -> To Vector (deactive)
	/*
	public abstract class MatrixVectorToVectorOperator: MatrixVectorOperator
	{
		protected MatrixVectorToVectorOperator(IMatrixExpression matrix, IVectorExpression vector): base(matrix, vector) {}
		public abstract int Length
		{
			get;
		}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class ScalarMatrixToVectorOperator: ScalarMatrixOperator
	{
		protected ScalarMatrixToVectorOperator(IMatrixExpression matrix, IScalarExpression scalar): base(matrix, scalar) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class BiVectorToVectorOperator: BiVectorOperator
	{
		protected BiVectorToVectorOperator(IVectorExpression first, IVectorExpression last): base(first, last) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class SingleVectorToVectorOperator: SingleVectorOperator
	{
		protected SingleVectorToVectorOperator(IVectorExpression sub): base(sub) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class ScalarVectorToVectorOperator: ScalarVectorOperator
	{
		protected ScalarVectorToVectorOperator(IVectorExpression vector, IScalarExpression scalar): base(vector, scalar) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class BiScalarVectorToVectorOperator: BiScalarVectorOperator
	{
		protected BiScalarVectorToVectorOperator(IVectorExpression vector, IScalarExpression first, IScalarExpression last): base(vector, first, last) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class TriScalarVectorToVectorOperator: TriScalarVectorOperator
	{
		protected TriScalarVectorToVectorOperator(IVectorExpression vector, IScalarExpression first, IScalarExpression middle, IScalarExpression last): base(vector, first, middle, last) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	public abstract class ScalarComplexComplexVectorToVectorOperator: ScalarComplexComplexVectorOperator
	{
		protected ScalarComplexComplexVectorToVectorOperator(IComplexVectorExpression vector, IScalarExpression scalar, IComplexExpression complex): base(vector, scalar, complex) {}
		public abstract ScalarVector ExpressionVector
		{
			get;
		}
		public abstract int Length
		{
			get;
		}
		public virtual IMatrixExpression ToMatrix()
		{
			return(new ScalarMatrix(new IVectorExpression[] {ExpressionVector}));
		}
		public virtual ValueVector Calculate()
		{
			return(this.ExpressionVector.Calculate());
		}
		public virtual IVectorExpression Simplify()
		{
			ScalarVector ve = ExpressionVector;
			IScalarExpression[] tmp = new IScalarExpression[ve.Length];
			for(int i=0;i<ve.Length;i++)
				tmp[i] = ve[i].Simplify();
			return(new ScalarVector(tmp));
		}
	}
	*/
	#endregion

	#region Matrix Conversion Maps
	public abstract class MatrixMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IMatrixExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IMatrixExpression ex = exp as IMatrixExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class MatrixConversionMap
	{
		public static void Convert(ref IMatrixExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(MatrixMapEntry entry in al)
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
	public abstract class VectorMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IVectorExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IVectorExpression ex = exp as IVectorExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class VectorConversionMap
	{
		public static void Convert(ref IVectorExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(VectorMapEntry entry in al)
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
