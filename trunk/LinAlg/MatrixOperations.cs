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

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	#region BiMatrix Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class MatrixMatrixMultiplication: MatrixOperator
	{
		protected Matrix2Parameters parameters;
		public Matrix2Parameters Parameters {get {return parameters;}}
		public MatrixMatrixMultiplication(Context context, Matrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixMatrixMultiplication(Context context, IMatrixExpression first, IMatrixExpression last): base(context)
		{
			this.parameters = new Matrix2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smfirst = parameters.Matrix1.Expand();
			ScalarMatrix smlast = parameters.Matrix2.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new VectorVectorDotMultiplication(context,smfirst.GetRowVector(y),smlast.GetColumnVector(x));
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix2.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class MatrixMatrixAddition: MatrixOperator
	{
		protected Matrix2Parameters parameters;
		public Matrix2Parameters Parameters {get {return parameters;}}
		public MatrixMatrixAddition(Context context, Matrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixMatrixAddition(Context context, IMatrixExpression first, IMatrixExpression last): base(context)
		{
			this.parameters = new Matrix2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smfirst = parameters.Matrix1.Expand();
			ScalarMatrix smlast = parameters.Matrix2.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ScalarAddition(context,smfirst[x,y],smlast[x,y]);
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix2.LengthX);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.Matrix1.LengthY,parameters.Matrix2.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class MatrixMatrixSubtraction: MatrixOperator
	{
		protected Matrix2Parameters parameters;
		public Matrix2Parameters Parameters {get {return parameters;}}
		public MatrixMatrixSubtraction(Context context, Matrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixMatrixSubtraction(Context context, IMatrixExpression first, IMatrixExpression last): base(context)
		{
			this.parameters = new Matrix2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smfirst = parameters.Matrix1.Expand();
			ScalarMatrix smlast = parameters.Matrix2.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ScalarSubtraction(context,smfirst[x,y],smlast[x,y]);
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix2.LengthX);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.Matrix1.LengthY,parameters.Matrix2.LengthY);}
		}
	}
	#endregion

	#region SingleMatrix Operators
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class MatrixNegative: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixNegative(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixNegative(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ScalarNegative(context,smin[x,y]);
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="trans")]
	public class MatrixTranspose: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixTranspose(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixTranspose(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = smin[y,x];
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthY;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthX;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixRight")]
	public class MatrixRightTriangle: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixRightTriangle(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixRightTriangle(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IScalarExpression[,] se = new IScalarExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(x<y)
						se[x,y] = ScalarExpressionValue.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixXRight")]
	public class MatrixRightExclusiveTriangle: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixRightExclusiveTriangle(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixRightExclusiveTriangle(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IScalarExpression[,] se = new IScalarExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(x<=y)
						se[x,y] = ScalarExpressionValue.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixLeft")]
	public class MatrixLeftTriangle: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixLeftTriangle(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixLeftTriangle(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IScalarExpression[,] se = new IScalarExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(y<x)
						se[x,y] = ScalarExpressionValue.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixXLeft")]
	public class MatrixLeftExclusiveTriangle: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixLeftExclusiveTriangle(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixLeftExclusiveTriangle(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IScalarExpression[,] se = new IScalarExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(y<=x)
						se[x,y] = ScalarExpressionValue.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixGauss")]
	public class MatrixGaussian: MatrixOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixGaussian(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixGaussian(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix sm = (ScalarMatrix)parameters.Matrix1.Expand().Clone();
			int m = sm.LengthY, n = sm.LengthX;
			int x=0, y=0;
			int p;
			while(y<m-1 && x<n-1)
			{
				p=-1;
				for(int i=y;i<m;i++)
				{
					//look for nonzero pivot
					if(!sm[x,i].IsConstant || sm[x,i].Calculate() != 0)
					{
						p=i;
						break;
					}
				}
				if(p==-1)
				{
					//no nonzero pivot found
					x++;
					continue;
				}
				if(p != y)
				{
					//first pivot zero: switch row with nonzero pivot row
					IVectorExpression vp = sm.GetRowVector(p);
					IVectorExpression vy = sm.GetRowVector(y);
					sm.SetRowVector(y,vp);
					sm.SetRowVector(p,vy);
				}
				for(int k=y+1;k<m;k++)
				{
					IScalarExpression l = new ScalarDivision(context,sm[x,k],sm[x,y]);
					IVectorExpression vk = new VectorVectorSubtraction(context,sm.GetRowVector(k),new VectorScalarMultiplication(context,sm.GetRowVector(y),l));
					sm.SetRowVector(k,vk);
					sm[y,k] = ScalarExpressionValue.Zero(context);
				}
				x++;
				y++;
			}
			return sm;
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixLR")]
	public class MatrixLRSplit: MatrixListOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixLRSplit(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixLRSplit(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override MatrixList Expand()
		{
			ScalarMatrix sm = (ScalarMatrix)parameters.Matrix1.Expand().Clone();
			//int m = sm.LengthY, n = sm.LengthX;
			int m = Math.Min(sm.LengthX,sm.LengthY);
			int n = m;
			int x=0, y=0;
			int p;
			IScalarExpression[,] lcp = new IScalarExpression[n,m];
			ScalarMatrix sp = new MatrixIdentity(context,new ScalarExpressionValue(context,m)).Expand(); 
			for(int x1=0;x1<n;x1++)
				for(int y1=0;y1<m;y1++)
					lcp[x1,y1] = ScalarExpressionValue.Zero(context);
			while(y<m-1 && x<n-1)
			{
				p=-1;
				for(int i=y;i<m;i++)
				{
					//look for nonzero pivot
					if(!sm[x,i].IsConstant || sm[x,i].Calculate() != 0)
					{
						p=i;
						break;
					}
				}
				if(p==-1)
				{
					//no nonzero pivot found
					x++;
					continue;
				}
				if(p != y)
				{
					//first pivot zero: switch row with nonzero pivot row
					IVectorExpression vp = sm.GetRowVector(p);
					IVectorExpression vy = sm.GetRowVector(y);
					sm.SetRowVector(y,vp);
					sm.SetRowVector(p,vy);
					IVectorExpression spp = sp.GetRowVector(p);
					IVectorExpression spy = sp.GetRowVector(y);
					sp.SetRowVector(y,spp);
					sp.SetRowVector(p,spy);
				}
				for(int k=y+1;k<m;k++)
				{
					IScalarExpression l = new ScalarDivision(context,sm[x,k],sm[x,y]);
					IVectorExpression vk = new VectorVectorSubtraction(context,sm.GetRowVector(k),new VectorScalarMultiplication(context,sm.GetRowVector(y),l));
					sm.SetRowVector(k,vk);
					sm[y,k] = ScalarExpressionValue.Zero(context);
					lcp[y,k] = l;
				}
				x++;
				y++;
			}
			ScalarMatrix mcp = new MatrixMatrixMultiplication(context,sp,new ScalarMatrix(context,lcp)).Simplify().Expand();
			for(int x1=0;x1<n;x1++)
				for(int y1=0;y1<m;y1++)
					if(x1==y1)
						mcp[x1,y1] = ScalarExpressionValue.One(context);
			return new MatrixList(context,new IMatrixExpression[] {sm,mcp,sp});
		}
		public override int Length
		{
			get {return 3;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixDet")]
	public class MatrixDeterminant: ScalarOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixDeterminant(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixDeterminant(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			ScalarMatrix smsub = parameters.Matrix1.Expand();
			if(smsub.LengthX != smsub.LengthY)
				throw(new RankException("determinant only defined for square matrices"));
			return RecursiveDet(smsub.RawData,0);
		}
		private IScalarExpression RecursiveDet(IScalarExpression[,] data, int level)
		{
			int len = data.GetLength(0);
			switch(len)
			{
				case 0: return ScalarExpressionValue.Zero(context);
				case 1: return data[0,0];
				case 2: return new ScalarSubtraction(context,new ScalarMultiplication(context,data[0,0],data[1,1]),new ScalarMultiplication(context,data[0,1],data[1,0]));
				case 3:
					IScalarExpression se = ScalarExpressionValue.Zero(context);
					for(int i=0;i<3;i++)
						se = new ScalarAddition(context,se,new ScalarMultiplication(context,new ScalarMultiplication(context,data[i,0],data[(i+1)%3,1]),data[(i+2)%3,2]));
					for(int i=0;i<3;i++)
						se = new ScalarSubtraction(context,se,new ScalarMultiplication(context,new ScalarMultiplication(context,data[i,0],data[(i+2)%3,1]),data[(i+1)%3,2]));
					return se;
			}
			IScalarExpression sx = ScalarExpressionValue.Zero(context);
			for(int x0=0;x0<len;x0++)
			{
				IScalarExpression[,] subdata = new IScalarExpression[len-1,len-1];
				for(int x=0;x<len-1;x++)
					for(int y=0;y<len-1;y++)
						subdata[x,y] = data[x<x0?x:x+1,y+1];
				sx = new ScalarAddition(context,sx,new ScalarMultiplication(context,new ScalarMultiplication(context,data[x0,0],new ScalarRaiseToPower(context,ScalarExpressionValue.MinusOne(context),new ScalarExpressionValue(context,level+x0))),RecursiveDet(subdata,level+1)));
			}
			return sx;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="rowlength")]
	public class MatrixRowLength: ScalarOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixRowLength(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixRowLength(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			return new ScalarExpressionValue(context,parameters.Matrix1.LengthX);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="collength")]
	public class MatrixColumnLength: ScalarOperator
	{
		protected Matrix1Parameters parameters;
		public Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixColumnLength(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixColumnLength(Context context, IMatrixExpression sub): base(context)
		{
			this.parameters = new Matrix1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			return new ScalarExpressionValue(context,parameters.Matrix1.LengthY);
		}
	}
	#endregion

	#region ScalarMatrix Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class MatrixScalarMultiplication: MatrixOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixScalarMultiplication(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixScalarMultiplication(Context context, IMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public MatrixScalarMultiplication(Context context, IScalarExpression scalar, IMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ScalarMultiplication(context,parameters.Scalar1,smin[x,y]);
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="/")]
	public class MatrixScalarDivision: MatrixOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixScalarDivision(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixScalarDivision(Context context, IMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			IScalarExpression[,] se = new IScalarExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ScalarDivision(context,smin[x,y],parameters.Scalar1);
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
		public override string ToString()
		{
			return "("+parameters.Matrix1.ToString()+"/"+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class MatrixScalarAddition: MatrixOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixScalarAddition(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixScalarAddition(Context context, IMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public MatrixScalarAddition(Context context, IScalarExpression scalar, IMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			int len = Math.Max(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);
			return new MatrixMatrixAddition(context,parameters.Matrix1,new MatrixScalarMultiplication(context,new MatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Scalar1)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class MatrixScalarSubtractionA: MatrixOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixScalarSubtractionA(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixScalarSubtractionA(Context context, IMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			int len = Math.Max(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);
			return new MatrixMatrixSubtraction(context,parameters.Matrix1,new MatrixScalarMultiplication(context,new MatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Scalar1)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
		public override string ToString()
		{
			return "("+parameters.Matrix1.ToString()+"-"+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class MatrixScalarSubtractionB: MatrixOperator
	{
		protected Scalar1Matrix1Parameters parameters;
		public Scalar1Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixScalarSubtractionB(Context context, Scalar1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixScalarSubtractionB(Context context, IScalarExpression scalar,IMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1Matrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			int len = Math.Max(parameters.Matrix1.LengthX,parameters.Matrix1.LengthY);
			return new MatrixMatrixSubtraction(context,new MatrixScalarMultiplication(context,new MatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Scalar1),parameters.Matrix1).Expand();
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	#endregion

	#region Other Operators
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixIdentity")]
	public class MatrixIdentity: MatrixOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public MatrixIdentity(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixIdentity(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			int len = (int)parameters.Scalar1.Calculate();
			IScalarExpression[,] se = new IScalarExpression[len,len];
			for(int x=0;x<len;x++)
			{
				for(int y=0;y<len;y++)
				{
					if(x==y)
						se[x,y] = ScalarExpressionValue.One(context);
					else
						se[x,y] = ScalarExpressionValue.Zero(context);
				}
			}
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return (int)parameters.Scalar1.Calculate();}
		}
		public override int LengthY
		{
			get {return (int)parameters.Scalar1.Calculate();}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="get")]
	public class MatrixGet: ScalarOperator
	{
		protected Scalar2Matrix1Parameters parameters;
		public Scalar2Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixGet(Context context, Scalar2Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixGet(Context context, IMatrixExpression matrix, IScalarExpression x, IScalarExpression y): base(context)
		{
			this.parameters = new Scalar2Matrix1Parameters(x,y,matrix);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			int xx = Convert.ToInt32(parameters.Scalar1.Calculate());
			int yy = Convert.ToInt32(parameters.Scalar2.Calculate());
			return parameters.Matrix1.Expand()[xx,yy];
		}
		public override string ToString()
		{
			return "get("+parameters.Matrix1.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Scalar2.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="set")]
	public class MatrixSet: StdProcedure, IProcExpression
	{
		protected Scalar3Matrix1Parameters parameters;
		public Scalar3Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixSet(Context context, Scalar3Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixSet(Context context, IMatrixExpression matrix, IScalarExpression x, IScalarExpression y, IScalarExpression val): base(context)
		{
			this.parameters = new Scalar3Matrix1Parameters(x,y,val,matrix);
			Init(parameters);
		}
		public override bool Execute()
		{
			int xx = Convert.ToInt32(parameters.Scalar1.Calculate());
			int yy = Convert.ToInt32(parameters.Scalar2.Calculate());
			MatrixExpressionVariable v1 = parameters.Matrix1 as MatrixExpressionVariable;
			if(v1 != null)
			{
				ScalarMatrix m = v1.Value.Expand();
				m[xx,yy] = parameters.Scalar3;
				v1.Value = m;
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = parameters.Matrix1 as Variable;
			if(v == null)
				return "set(" + parameters.Matrix1.ToString() + "," + parameters.Scalar1.ToString() + "," + parameters.Scalar2.ToString() + "," + parameters.Scalar3.ToString() + ")";
			else
				return "set(" + v.VariableName + "," + parameters.Scalar1.ToString() + "," + parameters.Scalar2.ToString() + "," + parameters.Scalar3.ToString() + ")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="slice")]
	public class MatrixSlice: MatrixOperator
	{
		protected Scalar4Matrix1Parameters parameters;
		public Scalar4Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixSlice(Context context, Scalar4Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixSlice(Context context, IMatrixExpression sub, IScalarExpression tlcol, IScalarExpression tlrow, IScalarExpression brcol, IScalarExpression brrow): base(context)
		{
			this.parameters = new Scalar4Matrix1Parameters(tlcol,tlrow,brcol,brrow,sub);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix smin = parameters.Matrix1.Expand();
			int tlcol = (int)Math.Floor(parameters.Scalar1.Calculate());
			int tlrow = (int)Math.Floor(parameters.Scalar2.Calculate());
			int brcol = (int)Math.Floor(parameters.Scalar3.Calculate());
			int brrow = (int)Math.Floor(parameters.Scalar4.Calculate());
			MathHelper.NormalizeMinMaxSpan(ref tlcol, ref brcol, smin.LengthX);
			MathHelper.NormalizeMinMaxSpan(ref tlrow, ref brrow, smin.LengthY);
			int lenx = brcol-tlcol+1;
			int leny = brrow-tlrow+1;
			IScalarExpression[,] se = new IScalarExpression[lenx,leny];
			for(int x=0;x<lenx;x++)
				for(int y=0;y<leny;y++)
					se[x,y] = smin[x+tlcol,y+tlrow];
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get
			{
				int tlcol = (int)Math.Floor(parameters.Scalar1.Calculate());
				int brcol = (int)Math.Floor(parameters.Scalar3.Calculate());
				MathHelper.NormalizeMinMaxSpan(ref tlcol, ref brcol, parameters.Matrix1.LengthX);
				return brcol-tlcol+1;
			}
		}
		public override int LengthY
		{
			get
			{
				int tlrow = (int)Math.Floor(parameters.Scalar2.Calculate());
				int brrow = (int)Math.Floor(parameters.Scalar4.Calculate());
				MathHelper.NormalizeMinMaxSpan(ref tlrow, ref brrow, parameters.Matrix1.LengthY);
				return brrow-tlrow+1;
			}
		}
		public override string ToString()
		{
			return "get("+parameters.Matrix1.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Scalar2.ToString()+","+parameters.Scalar3.ToString()+","+parameters.Scalar4.ToString()+")";
		}
	}
	#endregion
}
