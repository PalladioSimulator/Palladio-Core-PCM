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

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	#region BiMatrix Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexMatrixComplexMatrixMultiplication: ComplexMatrixOperator
	{
		protected ComplexMatrix2Parameters parameters;
		public ComplexMatrix2Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexMatrixMultiplication(Context context, ComplexMatrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexMatrixMultiplication(Context context, IComplexMatrixExpression first, IComplexMatrixExpression last): base(context)
		{
			this.parameters = new ComplexMatrix2Parameters(first,last);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smfirst = parameters.ComplexMatrix1.Expand();
			ComplexMatrix smlast = parameters.ComplexMatrix2.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexVectorComplexVectorDotMultiplication(context,smfirst.GetRowVector(y),smlast.GetColumnVector(x));
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix2.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class ComplexMatrixComplexMatrixAddition: ComplexMatrixOperator
	{
		protected ComplexMatrix2Parameters parameters;
		public ComplexMatrix2Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexMatrixAddition(Context context, ComplexMatrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexMatrixAddition(Context context, IComplexMatrixExpression first, IComplexMatrixExpression last): base(context)
		{
			this.parameters = new ComplexMatrix2Parameters(first,last);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smfirst = parameters.ComplexMatrix1.Expand();
			ComplexMatrix smlast = parameters.ComplexMatrix2.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexAddition(context,smfirst[x,y],smlast[x,y]);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix2.LengthX);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthY,parameters.ComplexMatrix2.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexMatrixComplexMatrixSubtraction: ComplexMatrixOperator
	{
		protected ComplexMatrix2Parameters parameters;
		public ComplexMatrix2Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexMatrixSubtraction(Context context, ComplexMatrix2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexMatrixSubtraction(Context context, IComplexMatrixExpression first, IComplexMatrixExpression last): base(context)
		{
			this.parameters = new ComplexMatrix2Parameters(first,last);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smfirst = parameters.ComplexMatrix1.Expand();
			ComplexMatrix smlast = parameters.ComplexMatrix2.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexSubtraction(context,smfirst[x,y],smlast[x,y]);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix2.LengthX);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthY,parameters.ComplexMatrix2.LengthY);}
		}
	}
	#endregion

	#region SingleMatrix Operators
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class ComplexMatrixNegative: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixNegative(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixNegative(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexNegative(context,smin[x,y]);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="trans")]
	public class ComplexMatrixTranspose: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixTranspose(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixTranspose(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = smin[y,x];
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthY;} //yes, x/y have to be switched!
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="conj")]
	public class ComplexMatrixConjugate: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixConjugate(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixConjugate(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexConjugate(context,smin[x,y]);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixRight")]
	public class ComplexMatrixRightTriangle: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixRightTriangle(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixRightTriangle(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IComplexExpression[,] se = new IComplexExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(x<y)
						se[x,y] = ScalarComplex.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixXRight")]
	public class ComplexMatrixRightExclusiveTriangle: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixRightExclusiveTriangle(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixRightExclusiveTriangle(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IComplexExpression[,] se = new IComplexExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(x<=y)
						se[x,y] = ScalarComplex.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixLeft")]
	public class ComplexMatrixLeftTriangle: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixLeftTriangle(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixLeftTriangle(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IComplexExpression[,] se = new IComplexExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(y<x)
						se[x,y] = ScalarComplex.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixXLeft")]
	public class ComplexMatrixLeftExclusiveTriangle: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixLeftExclusiveTriangle(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixLeftExclusiveTriangle(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			int len = Math.Min(smin.LengthX,smin.LengthY);
			IComplexExpression[,] se = new IComplexExpression[len,len];
			for(int x=0;x<len;x++)
				for(int y=0;y<len;y++)
				{
					if(y<=x)
						se[x,y] = ScalarComplex.Zero(context);
					else
						se[x,y] = smin[x,y];
				}
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
		public override int LengthY
		{
			get {return Math.Min(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixGauss")]
	public class ComplexMatrixGaussian: ComplexMatrixOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixGaussian(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixGaussian(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix sm = (ComplexMatrix)parameters.ComplexMatrix1.Expand().Clone();
			int m = sm.LengthY, n = sm.LengthX;
			int x=0, y=0;
			int p;
			while(y<m-1 && x<n-1)
			{
				p=-1;
				for(int i=y;i<m;i++)
				{
					//look for nonzero pivot
					if(!sm[x,i].IsConstant || (sm[x,i].Calculate().Imag != 0 || sm[x,i].Calculate().Real != 0 ))
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
					IComplexVectorExpression vp = sm.GetRowVector(p);
					IComplexVectorExpression vy = sm.GetRowVector(y);
					sm.SetRowVector(y,vp);
					sm.SetRowVector(p,vy);
				}
				for(int k=y+1;k<m;k++)
				{
					IComplexExpression l = new ComplexDivision(context,sm[x,k],sm[x,y]);
					IComplexVectorExpression vk = new ComplexVectorComplexVectorSubtraction(context,sm.GetRowVector(k),new ComplexVectorComplexMultiplication(context,sm.GetRowVector(y),l));
					sm.SetRowVector(k,vk);
					sm[y,k] = ScalarComplex.Zero(context);
				}
				x++;
				y++;
			}
			return sm;
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="MatrixDet")]
	public class ComplexMatrixDeterminant: ComplexOperator
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixDeterminant(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixDeterminant(Context context, IComplexMatrixExpression sub): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(sub);
			Init(parameters);
		}
		public override ScalarComplex Expand()
		{
			ComplexMatrix smsub = parameters.ComplexMatrix1.Expand();
			if(smsub.LengthX != smsub.LengthY)
				throw(new RankException("determinant only defined for square matrix"));
			return RecursiveDet(smsub.RawData,0).Expand();
		}
		private IComplexExpression RecursiveDet(IComplexExpression[,] data, int level)
		{
			int len = data.GetLength(0);
			switch(len)
			{
				case 0: return(ScalarComplex.Zero(context));
				case 1: return(data[0,0]);
				case 2: return(new ComplexSubtraction(context,new ComplexMultiplication(context,data[0,0],data[1,1]),new ComplexMultiplication(context,data[0,1],data[1,0])));
				case 3:
					IComplexExpression se = ScalarComplex.Zero(context);
					for(int i=0;i<3;i++)
						se = new ComplexAddition(context,se,new ComplexMultiplication(context,new ComplexMultiplication(context,data[i,0],data[(i+1)%3,1]),data[(i+2)%3,2]));
					for(int i=0;i<3;i++)
						se = new ComplexSubtraction(context,se,new ComplexMultiplication(context,new ComplexMultiplication(context,data[i,0],data[(i+2)%3,1]),data[(i+1)%3,2]));
					return(se);
			}
			IComplexExpression sx = ScalarComplex.Zero(context);
			for(int x0=0;x0<len;x0++)
			{
				IComplexExpression[,] subdata = new IComplexExpression[len-1,len-1];
				for(int x=0;x<len-1;x++)
					for(int y=0;y<len-1;y++)
						subdata[x,y] = data[x<x0?x:x+1,y+1];
				sx = new ComplexAddition(context,sx,new ComplexMultiplication(context,new ComplexMultiplication(context,data[x0,0],new ScalarComplex(context,new ScalarRaiseToPower(context,ScalarExpressionValue.MinusOne(context),new ScalarExpressionValue(context,level+x0)),ScalarExpressionValue.Zero(context))),RecursiveDet(subdata,level+1)));
			}
			return(sx);
		}
	}
	#endregion

	#region ScalarMatrix Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexMatrixScalarMultiplication: ComplexMatrixOperator
	{
		protected Scalar1ComplexMatrix1Parameters parameters;
		public Scalar1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixScalarMultiplication(Context context, Scalar1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixScalarMultiplication(Context context, IComplexMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public ComplexMatrixScalarMultiplication(Context context, IScalarExpression scalar, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexMultiplication(context,parameters.Scalar1,smin[x,y]);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="/")]
	public class ComplexMatrixScalarDivision: ComplexMatrixOperator
	{
		protected Scalar1ComplexMatrix1Parameters parameters;
		public Scalar1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixScalarDivision(Context context, Scalar1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixScalarDivision(Context context, IComplexMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexDivision(context,smin[x,y],parameters.Scalar1);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
		public override string ToString()
		{
			return "("+parameters.ComplexMatrix1.ToString()+"/"+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class ComplexMatrixScalarAddition: ComplexMatrixOperator
	{
		protected Scalar1ComplexMatrix1Parameters parameters;
		public Scalar1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixScalarAddition(Context context, Scalar1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixScalarAddition(Context context, IComplexMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public ComplexMatrixScalarAddition(Context context, IScalarExpression scalar, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = Math.Max(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);
			return new ComplexMatrixComplexMatrixAddition(context,parameters.ComplexMatrix1,new ComplexMatrixScalarMultiplication(context,new ComplexMatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Scalar1)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexMatrixScalarSubtractionA: ComplexMatrixOperator
	{
		protected Scalar1ComplexMatrix1Parameters parameters;
		public Scalar1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixScalarSubtractionA(Context context, Scalar1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixScalarSubtractionA(Context context, IComplexMatrixExpression matrix, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = Math.Max(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);
			return new ComplexMatrixComplexMatrixSubtraction(context,parameters.ComplexMatrix1,new ComplexMatrixScalarMultiplication(context,new ComplexMatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Scalar1)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
		public override string ToString()
		{
			return "("+parameters.ComplexMatrix1.ToString()+"-"+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexMatrixScalarSubtractionB: ComplexMatrixOperator
	{
		protected Scalar1ComplexMatrix1Parameters parameters;
		public Scalar1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixScalarSubtractionB(Context context, Scalar1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixScalarSubtractionB(Context context, IScalarExpression scalar, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1ComplexMatrix1Parameters(scalar,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = Math.Max(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);
			return new ComplexMatrixComplexMatrixSubtraction(context,new ComplexMatrixScalarMultiplication(context,new ComplexMatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Scalar1),parameters.ComplexMatrix1).Expand();
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	#endregion

	#region ComplexMatrix Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexMatrixComplexMultiplication: ComplexMatrixOperator
	{
		protected Complex1ComplexMatrix1Parameters parameters;
		public Complex1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexMultiplication(Context context, Complex1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexMultiplication(Context context, IComplexMatrixExpression matrix, IComplexExpression complex): base(context)
		{
			this.parameters = new Complex1ComplexMatrix1Parameters(complex,matrix);
			Init(parameters);
		}
		public ComplexMatrixComplexMultiplication(Context context, IComplexExpression complex, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Complex1ComplexMatrix1Parameters(complex,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix smin = parameters.ComplexMatrix1.Expand();
			IComplexExpression[,] se = new IComplexExpression[LengthX,LengthY];
			for(int x=0;x<LengthX;x++)
				for(int y=0;y<LengthY;y++)
					se[x,y] = new ComplexMultiplication(context,parameters.Complex1,smin[x,y]);
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class ComplexMatrixComplexAddition: ComplexMatrixOperator
	{
		protected Complex1ComplexMatrix1Parameters parameters;
		public Complex1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexAddition(Context context, Complex1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexAddition(Context context, IComplexMatrixExpression matrix, IComplexExpression complex): base(context)
		{
			this.parameters = new Complex1ComplexMatrix1Parameters(complex,matrix);
			Init(parameters);
		}
		public ComplexMatrixComplexAddition(Context context, IComplexExpression complex, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Complex1ComplexMatrix1Parameters(complex,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = Math.Max(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);
			return new ComplexMatrixComplexMatrixAddition(context,parameters.ComplexMatrix1,new ComplexMatrixComplexMultiplication(context,new ComplexMatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Complex1)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexMatrixComplexSubtractionA: ComplexMatrixOperator
	{
		protected Complex1ComplexMatrix1Parameters parameters;
		public Complex1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexSubtractionA(Context context, Complex1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexSubtractionA(Context context, IComplexMatrixExpression matrix, IComplexExpression complex): base(context)
		{
			this.parameters = new Complex1ComplexMatrix1Parameters(complex,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = Math.Max(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);
			return new ComplexMatrixComplexMatrixSubtraction(context,parameters.ComplexMatrix1,new ComplexMatrixComplexMultiplication(context,new ComplexMatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Complex1)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
		public override string ToString()
		{
			return "("+parameters.ComplexMatrix1.ToString()+"-"+parameters.Complex1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexMatrixComplexSubtractionB: ComplexMatrixOperator
	{
		protected Complex1ComplexMatrix1Parameters parameters;
		public Complex1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexSubtractionB(Context context, Complex1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixComplexSubtractionB(Context context, IComplexExpression complex, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Complex1ComplexMatrix1Parameters(complex,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = Math.Max(parameters.ComplexMatrix1.LengthX,parameters.ComplexMatrix1.LengthY);
			return new ComplexMatrixComplexMatrixSubtraction(context,new ComplexMatrixComplexMultiplication(context,new ComplexMatrixIdentity(context,new ScalarExpressionValue(context,len)),parameters.Complex1),parameters.ComplexMatrix1).Expand();
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	#endregion

	#region Other Operators
	[ParsingObject(ParsingObjectType.Function,250,Character="ComplexMatrixIdentity")]
	public class ComplexMatrixIdentity: ComplexMatrixOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixIdentity(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixIdentity(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			int len = (int)parameters.Scalar1.Calculate();
			IComplexExpression[,] se = new IComplexExpression[len,len];
			for(int x=0;x<len;x++)
			{
				for(int y=0;y<len;y++)
				{
					if(x==y)
						se[x,y] = ScalarComplex.One(context);
					else
						se[x,y] = ScalarComplex.Zero(context);
				}
			}
			return new ComplexMatrix(context,se);
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
	#endregion
}
