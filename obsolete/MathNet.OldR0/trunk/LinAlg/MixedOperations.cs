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
using cdrnet.Lib.MathLib.Scalar.Trigonometry;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar.Geometry;

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	#region MatrixVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class MatrixVectorMultiplication: VectorOperator
	{
		protected Vector1Matrix1Parameters parameters;
		public Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixVectorMultiplication(Context context, Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixVectorMultiplication(Context context, IMatrixExpression matrix, IVectorExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public MatrixVectorMultiplication(Context context, IMatrixExpression matrix, ITripleExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}),matrix);
			Init(parameters);
		} 
		public override ScalarVector Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarVector v = parameters.Vector1.Expand();
			IScalarExpression[] se = new IScalarExpression[v.Length];
			for(int y=0;y<m.LengthY;y++)
				se[y] = new VectorVectorDotMultiplication(context,m.GetRowVector(y),v);
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public override string ToString()
		{
			return "("+parameters.Matrix1.ToString()+"*"+parameters.Vector1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class VectorMatrixMultiplication: VectorOperator
	{
		protected Vector1Matrix1Parameters parameters;
		public Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public VectorMatrixMultiplication(Context context, Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorMatrixMultiplication(Context context, IVectorExpression vector, IMatrixExpression matrix): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public VectorMatrixMultiplication(Context context, ITripleExpression vector, IMatrixExpression matrix): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}),matrix);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarVector v = parameters.Vector1.Expand();
			IScalarExpression[] se = new IScalarExpression[v.Length];
			for(int y=0;y<m.LengthY;y++)
				se[y] = new VectorVectorDotMultiplication(context,m.GetColumnVector(y),v);
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixFwd")]
	public class MatrixForwardSubstitute: VectorOperator
	{
		protected Vector1Matrix1Parameters parameters;
		public Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixForwardSubstitute(Context context, Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixForwardSubstitute(Context context, IMatrixExpression matrix, IVectorExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public MatrixForwardSubstitute(Context context, IMatrixExpression matrix, ITripleExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}),matrix);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			ScalarMatrix m = parameters.Matrix1.Expand();
			int len = v.Length;
			if(m.LengthY != len || m.LengthX != len)
				throw(new ExpressionRankMismatchException());
			IScalarExpression[] res = new IScalarExpression[len];
			res[0] = v[0];
			for(int i=1;i<len;i++)
			{
				IScalarExpression f = new ScalarMultiplication(context,m[0,i],res[0]);
				for(int j=1;j<i;j++)
				{
					f = new ScalarAddition(context,f,new ScalarMultiplication(context,m[j,i],res[j]));
				}
				res[i] = new ScalarSubtraction(context,v[i],f);
			}
			return new ScalarVector(context,res);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public override string ToString()
		{
			return "MatrixFwd("+parameters.Matrix1.ToString()+","+parameters.Vector1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixBwd")]
	public class MatrixBackwardSubstitute: VectorOperator
	{
		protected Vector1Matrix1Parameters parameters;
		public Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixBackwardSubstitute(Context context, Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixBackwardSubstitute(Context context, IMatrixExpression matrix, IVectorExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public MatrixBackwardSubstitute(Context context, IMatrixExpression matrix, ITripleExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}),matrix);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			ScalarMatrix m = parameters.Matrix1.Expand();

			int lenx = m.LengthX;
			int leny = m.LengthY;

			if(leny != v.Length || leny > lenx)
				throw(new ExpressionRankMismatchException());

			bool[] def = new bool[lenx];
			int[] refy = new int[lenx];
			IScalarExpression[] res = new IScalarExpression[lenx];
			int paramcnt = 0;

			//fill def array
			int x0 = lenx-1;
			int y0 = leny-1;
			//bool inSystem = false;
			for(;y0>=0;y0--)
			{
				if(IsNotNull(m[x0,y0]))
				{
					bool first = true;
					int x1 = x0;
					for(int x=0;x<=x0;x++)
					{
						if(IsNotNull(m[x,y0]))
						{
							if(first)
							{
								//inSystem = true;
								first = false;
								x1 = x-1;
								def[x] = true;
							}
							else
								def[x] = false;
						}
					}
					x0 = x1;
					//if(!first && inSystem)
					//	throw(new ExpressionInconsistentSystemException());
				}
			}

			// fill refy array
			x0 = 0;
			for(int x=0;x<lenx;x++)
			{
				if(def[x])
					refy[x] = x0++;
				else
					refy[x] = x0;
			}

			// solve
			x0 = lenx-1;
			for(;x0>=0;x0--)
			{
				if(def[x0])
				{
					IScalarExpression f = v[refy[x0]];
					for(int x=x0+1;x<lenx;x++)
						f = new ScalarSubtraction(context,f,new ScalarMultiplication(context,res[x],m[x,refy[x0]]));
					res[x0] = new ScalarDivision(context,f,m[x0,refy[x0]]);
				}
				else
				{
					res[x0] = context.ContextVariables.GetCreateVariable("t" + paramcnt.ToString()) as ScalarExpressionVariable;
					paramcnt++;
				}
			}
			return new ScalarVector(context,res);
		}
		private bool IsNotNull(IScalarExpression se)
		{
			if(!se.IsConstant || se.Calculate() != 0)
				return(true);
			else
				return(false);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public override string ToString()
		{
			return "MatrixBwd("+parameters.Matrix1.ToString()+","+parameters.Vector1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixSim")]
	public class MatrixSimulate: VectorOperator
	{
		protected Vector1Matrix1Parameters parameters;
		public Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixSimulate(Context context, Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixSimulate(Context context, IMatrixExpression matrix, IVectorExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public MatrixSimulate(Context context, IMatrixExpression matrix, ITripleExpression vector): base(context)
		{
			this.parameters = new Vector1Matrix1Parameters(new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}),matrix);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			ScalarMatrix m = parameters.Matrix1.Expand();
			MatrixList ml = new MatrixLRSplit(context,m).Expand();
			IVectorExpression ve = new MatrixForwardSubstitute(context,ml[1],new MatrixVectorMultiplication(context,ml[2],v));
			return new MatrixBackwardSubstitute(context,ml[0],ve).Expand();
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public override string ToString()
		{
			return "MatrixSim("+parameters.Matrix1.ToString()+","+parameters.Vector1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixSim")]
	public class MatrixMultiSimulate: MatrixOperator
	{
		protected Matrix2Parameters parameters;
		public Matrix2Parameters Parameters {get {return parameters;}}
		public MatrixMultiSimulate(Context context, Matrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixMultiSimulate(Context context, IMatrixExpression first, IMatrixExpression last): base(context)
		{
			this.parameters = new Matrix2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarMatrix n = parameters.Matrix2.Expand();
			MatrixList ml = new MatrixLRSplit(context,m).Expand();
			IVectorExpression[] res = new IVectorExpression[parameters.Matrix2.LengthX];
			for(int i=0;i<parameters.Matrix2.LengthX;i++)
			{
				IVectorExpression ve = new MatrixForwardSubstitute(context,ml[1],new MatrixVectorMultiplication(context,ml[2],n.GetColumnVector(i)));
				res[i] = new MatrixBackwardSubstitute(context,ml[0],ve).Expand();
			}
			return new ScalarMatrix(context,res);
		}
		public override int LengthX
		{
			get {return(parameters.Matrix2.LengthX);}
		}
		public override int LengthY
		{
			get {return(parameters.Matrix1.LengthX);}
		}
	}
	#endregion

	#region Manipulation
	[ParsingObject(ParsingObjectType.Function,250,Character="getrow")]
	public class MatrixGetRow: VectorOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixGetRow(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixGetRow(Context context, IMatrixExpression matrix, IScalarExpression y): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(y,matrix);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			return parameters.Matrix1.GetRowVector(Convert.ToInt32(parameters.Scalar1.Calculate())).Expand();
		}
		public override int Length
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override string ToString()
		{
			return "getrow("+parameters.Matrix1.ToString()+","+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="getcol")]
	public class MatrixGetColumn: VectorOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixGetColumn(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixGetColumn(Context context, IMatrixExpression matrix, IScalarExpression x): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(x,matrix);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			return parameters.Matrix1.GetColumnVector(Convert.ToInt32(parameters.Scalar1.Calculate())).Expand();
		}
		public override int Length
		{
			get {return parameters.Matrix1.LengthY;}
		}
		public override string ToString()
		{
			return "getcol("+parameters.Matrix1.ToString()+","+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="finsertrow")]
	public class MatrixInsertRowFunctional: MatrixOperator
	{
		protected Scalar1Vector1Matrix1Parameters parameters;
		public Scalar1Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixInsertRowFunctional(Context context, Scalar1Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixInsertRowFunctional(Context context, IMatrixExpression matrix, IVectorExpression row, IScalarExpression rowindex): base(context)
		{
			this.parameters = new Scalar1Vector1Matrix1Parameters(rowindex,row,matrix);
			Init(parameters);
		}
		public MatrixInsertRowFunctional(Context context, IMatrixExpression matrix, ITripleExpression row, IScalarExpression rowindex): base(context)
		{
			this.parameters = new Scalar1Vector1Matrix1Parameters(rowindex,new ScalarVector(context,new IScalarExpression[]{row.ExpandX(),row.ExpandY(),row.ExpandZ()}),matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarVector v = parameters.Vector1.Expand();
			int yin = Convert.ToInt32(parameters.Scalar1.Calculate());
			if(yin < 0)
				yin = 0;
			if(yin > m.LengthX)
				yin = m.LengthX;
			IScalarExpression[,] data = new IScalarExpression[m.LengthX,m.LengthY+1];
			for(int y=0;y<yin;y++)
				for(int x=0;x<m.LengthX;x++)
					data[x,y] = m[x,y];
			for(int x=0;x<m.LengthX;x++)
			{
				if(x < v.Length)
					data[x,yin] = v[x];
				else
					data[x,yin] = ScalarExpressionValue.Zero(context);
			}
			for(int y=yin+1;y<m.LengthY+1;y++)
				for(int x=0;x<m.LengthX;x++)
					data[x,y] = m[x,y-1];
			return new ScalarMatrix(context,data);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY+1;}
		}
		public override string ToString()
		{
			return "finsertrow("+parameters.Matrix1.ToString()+","+parameters.Vector1.ToString()+","+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="finsertrows")]
	public class MatrixInsertRowsFunctional: MatrixOperator
	{
		protected Scalar2Matrix2Parameters parameters;
		public Scalar2Matrix2Parameters Parameters {get {return parameters;}}
		public MatrixInsertRowsFunctional(Context context, Scalar2Matrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixInsertRowsFunctional(Context context, IMatrixExpression matrix, IMatrixExpression row, IScalarExpression x, IScalarExpression y): base(context)
		{
			this.parameters = new Scalar2Matrix2Parameters(x,y,matrix,row);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarMatrix v = parameters.Matrix2.Expand();
			int xin = Convert.ToInt32(parameters.Scalar1.Calculate());
			int yin = Convert.ToInt32(parameters.Scalar2.Calculate());
			if(xin < 0)
				xin = 0;
			if(yin < 0)
				yin = 0;
			int xlen = Math.Max(xin+v.LengthX,m.LengthX);
			int ylen = Math.Max(yin+v.LengthY,m.LengthY+v.LengthY);
			IScalarExpression[,] data = new IScalarExpression[xlen,ylen];
			for(int y=0;y<yin;y++)
			{
				if(y<m.LengthY)
				{
					for(int x=0;x<m.LengthX;x++)
						data[x,y] = m[x,y];
					for(int x=m.LengthX;x<xlen;x++)
						data[x,y] = ScalarExpressionValue.Zero(context);
				}
				else
					for(int x=0;x<xlen;x++)
						data[x,y] = ScalarExpressionValue.Zero(context);
			}
			for(int y=yin;y<yin+v.LengthY;y++)
			{
				for(int x=0;x<xin;x++)
					data[x,y] = ScalarExpressionValue.Zero(context);
				for(int x=xin;(x-xin)<v.LengthX;x++)
					data[x,y] = v[x-xin,y-yin];
				for(int x=xin+v.LengthX;x<xlen;x++)
					data[x,y] = ScalarExpressionValue.Zero(context);
			}
			for(int y=yin+v.LengthY;y<ylen;y++)
			{
				if(y-v.LengthY<m.LengthY)
				{
					for(int x=0;x<m.LengthX;x++)
						data[x,y] = m[x,y-v.LengthY];
					for(int x=m.LengthX;x<xlen;x++)
						data[x,y] = ScalarExpressionValue.Zero(context);
				}
				else
					for(int x=0;x<xlen;x++)
						data[x,y] = ScalarExpressionValue.Zero(context);
			}
			return new ScalarMatrix(context,data);
		}
		public override int LengthX
		{
			get {return Math.Max(Convert.ToInt32(parameters.Scalar1.Calculate())+parameters.Matrix2.LengthX,parameters.Matrix1.LengthX);}
		}
		public override int LengthY
		{
			get {return Math.Max(Convert.ToInt32(parameters.Scalar2.Calculate())+parameters.Matrix2.LengthY,parameters.Matrix1.LengthY+parameters.Matrix2.LengthY);}
		}
		public override string ToString()
		{
			return "finsertrows("+parameters.Matrix1.ToString()+","+parameters.Matrix2.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Scalar2.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="finsertcol")]
	public class MatrixInsertColumnFunctional: MatrixOperator
	{
		protected Scalar1Vector1Matrix1Parameters parameters;
		public Scalar1Vector1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixInsertColumnFunctional(Context context, Scalar1Vector1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixInsertColumnFunctional(Context context, IMatrixExpression matrix, IVectorExpression column, IScalarExpression columnindex): base(context)
		{
			this.parameters = new Scalar1Vector1Matrix1Parameters(columnindex,column,matrix);
			Init(parameters);
		}
		public MatrixInsertColumnFunctional(Context context, IMatrixExpression matrix, ITripleExpression column, IScalarExpression columnindex): base(context)
		{
			this.parameters = new Scalar1Vector1Matrix1Parameters(columnindex,new ScalarVector(context,new IScalarExpression[]{column.ExpandX(),column.ExpandY(),column.ExpandZ()}),matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarVector v = parameters.Vector1.Expand();
			int xin = Convert.ToInt32(parameters.Scalar1.Calculate());
			if(xin < 0)
				xin = 0;
			if(xin > m.LengthY)
				xin = m.LengthY;
			IScalarExpression[,] data = new IScalarExpression[m.LengthX+1,m.LengthY];
			for(int x=0;x<xin;x++)
				for(int y=0;y<m.LengthY;y++)
					data[x,y] = m[x,y];
			for(int y=0;y<m.LengthY;y++)
			{
				if(y < v.Length)
					data[xin,y] = v[y];
				else
					data[xin,y] = ScalarExpressionValue.Zero(context);
			}
			for(int x=xin+1;x<m.LengthX+1;x++)
				for(int y=0;y<m.LengthY;y++)
					data[x,y] = m[x-1,y];
			return new ScalarMatrix(context,data);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX+1;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
		public override string ToString()
		{
			return "finsertcol("+parameters.Matrix1.ToString()+","+parameters.Vector1.ToString()+","+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="finsertcols")]
	public class MatrixInsertColumnsFunctional: MatrixOperator
	{
		protected Scalar2Matrix2Parameters parameters;
		public Scalar2Matrix2Parameters Parameters {get {return parameters;}}
		public MatrixInsertColumnsFunctional(Context context, Scalar2Matrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixInsertColumnsFunctional(Context context, IMatrixExpression matrix, IMatrixExpression column, IScalarExpression x, IScalarExpression y): base(context)
		{
			this.parameters = new Scalar2Matrix2Parameters(x,y,matrix,column);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix m = parameters.Matrix1.Expand();
			ScalarMatrix v = parameters.Matrix2.Expand();
			int xin = Convert.ToInt32(parameters.Scalar1.Calculate());
			int yin = Convert.ToInt32(parameters.Scalar2.Calculate());
			if(xin < 0)
				xin = 0;
			if(yin < 0)
				yin = 0;
			int xlen = Math.Max(xin+v.LengthX,m.LengthX+v.LengthX);
			int ylen = Math.Max(yin+v.LengthY,m.LengthY);
			IScalarExpression[,] data = new IScalarExpression[xlen,ylen];
			for(int x=0;x<xin;x++)
			{
				if(x<m.LengthX)
				{
					for(int y=0;y<m.LengthY;y++)
						data[x,y] = m[x,y];
					for(int y=m.LengthY;y<ylen;y++)
						data[x,y] = ScalarExpressionValue.Zero(context);
				}
				else
					for(int y=0;y<ylen;y++)
						data[x,y] = ScalarExpressionValue.Zero(context);
			}
			for(int x=xin;x<xin+v.LengthX;x++)
			{
				for(int y=0;y<yin;y++)
					data[x,y] = ScalarExpressionValue.Zero(context);
				for(int y=yin;(y-yin)<v.LengthY;y++)
					data[x,y] = v[x-xin,y-yin];
				for(int y=yin+v.LengthY;y<ylen;y++)
					data[x,y] = ScalarExpressionValue.Zero(context);
			}
			for(int x=xin+v.LengthX;x<xlen;x++)
			{
				if(x-v.LengthX<m.LengthX)
				{
					for(int y=0;y<m.LengthY;y++)
						data[x,y] = m[x-v.LengthX,y];
					for(int y=m.LengthY;y<ylen;y++)
						data[x,y] = ScalarExpressionValue.Zero(context);
				}
				else
					for(int y=0;y<ylen;y++)
						data[x,y] = ScalarExpressionValue.Zero(context);
			}
			return new ScalarMatrix(context,data);
		}
		public override int LengthX
		{
			get {return Math.Max(Convert.ToInt32(parameters.Scalar1.Calculate())+parameters.Matrix2.LengthX,parameters.Matrix1.LengthX+parameters.Matrix2.LengthX);}
		}
		public override int LengthY
		{
			get {return Math.Max(Convert.ToInt32(parameters.Scalar2.Calculate())+parameters.Matrix2.LengthY,parameters.Matrix1.LengthY);}
		}
		public override string ToString()
		{
			return "finsertcols("+parameters.Matrix1.ToString()+","+parameters.Matrix2.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Scalar2.ToString()+")";
		}
	}
	#endregion
}