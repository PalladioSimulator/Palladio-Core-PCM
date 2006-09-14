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

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	#region BiVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="x")]
	public class VectorCrossMultiplication: VectorOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public VectorCrossMultiplication(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorCrossMultiplication(Context context, IVectorExpression first, IVectorExpression last): base(context)
		{
			this.parameters = new Vector2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector va = parameters.Vector1.Expand();
			ScalarVector vb = parameters.Vector2.Expand();
			if(va.Length != 3 || vb.Length != 3)
				throw(new ExpressionRankMismatchException());
			IScalarExpression[] se = new IScalarExpression[3];
			se[0] = new ScalarSubtraction(context,new ScalarMultiplication(context,va[1],vb[2]),new ScalarMultiplication(context,va[2],vb[1]));
			se[1] = new ScalarSubtraction(context,new ScalarMultiplication(context,va[2],vb[0]),new ScalarMultiplication(context,va[0],vb[2]));
			se[2] = new ScalarSubtraction(context,new ScalarMultiplication(context,va[0],vb[1]),new ScalarMultiplication(context,va[1],vb[0]));
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return 3;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class VectorVectorDotMultiplication: ScalarOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public VectorVectorDotMultiplication(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorVectorDotMultiplication(Context context, IVectorExpression first, IVectorExpression last): base(context)
		{
			this.parameters = new Vector2Parameters(first,last);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			ScalarVector va = parameters.Vector1.Expand();
			ScalarVector vb = parameters.Vector2.Expand();
			IScalarExpression se = new ScalarMultiplication(context,va[0],vb[0]);
			for(int i=1;i<Math.Min(parameters.Vector1.Length,parameters.Vector2.Length);i++)
			{
				se = new ScalarAddition(context,se,new ScalarMultiplication(context,va[i],vb[i]));
			}
			return se;
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class VectorVectorAddition: VectorOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public VectorVectorAddition(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorVectorAddition(Context context, IVectorExpression first, IVectorExpression last): base(context)
		{
			this.parameters = new Vector2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector va = parameters.Vector1.Expand();
			ScalarVector vb = parameters.Vector2.Expand();
			int len = Math.Min(va.Length,vb.Length);
			IScalarExpression[] se = new IScalarExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ScalarAddition(context,va[i],vb[i]);
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return Math.Min(parameters.Vector1.Length,parameters.Vector2.Length);}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class VectorVectorSubtraction: VectorOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public VectorVectorSubtraction(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorVectorSubtraction(Context context, IVectorExpression first, IVectorExpression last): base(context)
		{
			this.parameters = new Vector2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector va = parameters.Vector1.Expand();
			ScalarVector vb = parameters.Vector2.Expand();
			int len = Math.Min(va.Length,vb.Length);
			IScalarExpression[] se = new IScalarExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ScalarSubtraction(context,va[i],vb[i]);
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return Math.Min(parameters.Vector1.Length,parameters.Vector2.Length);}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="VectorAngle")]
	public class VectorVectorAngle: ScalarOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public VectorVectorAngle(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorVectorAngle(Context context, IVectorExpression first, IVectorExpression last): base(context)
		{
			this.parameters = new Vector2Parameters(first,last);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			return new ScalarTrigArcCosinus(context,new ScalarDivision(context,new VectorVectorDotMultiplication(context,parameters.Vector1,parameters.Vector2),new ScalarMultiplication(context,new VectorEuclideanNorm(context,parameters.Vector1),new VectorEuclideanNorm(context,parameters.Vector2))));
		}
	}
	#endregion

	#region SingleVector Operator
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class VectorNegative: VectorOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorNegative(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorNegative(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector smin = parameters.Vector1.Expand();
			IScalarExpression[] se = new IScalarExpression[Length];
			for(int y=0;y<Length;y++)
				se[y] = new ScalarNegative(context,smin[y]);
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="VectorNorm")]
	public class VectorEuclideanNorm: ScalarOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorEuclideanNorm(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorEuclideanNorm(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			IScalarExpression se = new ScalarSquare(context,v[0]);
			for(int i=1;i<v.Length;i++)
			{
				se = new ScalarAddition(context,se,new ScalarSquare(context,v[i]));
			}
			return new ScalarSquareRoot(context,se);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="VectorMaxNorm")]
	public class VectorInfinityNorm: ScalarOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorInfinityNorm(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorInfinityNorm(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			IScalarExpression emax = v[0];
			double dmax = Math.Abs(v[0].Calculate());
			for(int i=1;i<v.Length;i++)
			{
				if(Math.Abs(v[i].Calculate()) > dmax)
				{
					dmax = Math.Abs(v[i].Calculate());
					emax = v[i];
				}
			}
			return new ScalarAbsolute(context,emax);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="max")]
	public class VectorMaxElement: ScalarOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorMaxElement(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorMaxElement(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			ScalarVector v = parameters.Vector1.Expand();
			double max = double.MinValue;
			for(int i=0;i<parameters.Vector1.Length;i++)
				if(v[i].Calculate() > max)
					max = v[i].Calculate();
			return max;
		}
		public override IScalarExpression Expand()
		{
			ScalarVector xsub = parameters.Vector1.Expand();
			if(xsub.IsConstant)
			{
				double max = xsub[0].Calculate();
				IScalarExpression maxExpr = xsub[0];
				for(int i=1;i<parameters.Vector1.Length;i++)
					if(xsub[i].Calculate() > max)
					{
						max = xsub[i].Calculate();
						maxExpr = xsub[i];
					}
				return maxExpr;
			}
			return new VectorMaxElement(context,xsub);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="min")]
	public class VectorMinElement: ScalarOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorMinElement(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorMinElement(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			ScalarVector v = parameters.Vector1.Expand();
			double min = double.MaxValue;
			for(int i=0;i<parameters.Vector1.Length;i++)
				if(v[i].Calculate() < min)
					min = v[i].Calculate();
			return min;
		}
		public override IScalarExpression Expand()
		{
			ScalarVector xsub = parameters.Vector1.Expand();
			if(xsub.IsConstant)
			{
				double min = xsub[0].Calculate();
				IScalarExpression minExpr = xsub[0];
				for(int i=1;i<parameters.Vector1.Length;i++)
					if(xsub[i].Calculate() < min)
					{
						min = xsub[i].Calculate();
						minExpr = xsub[i];
					}
				return minExpr;
			}
			return new VectorMinElement(context,xsub);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sum")]
	public class VectorSum: ScalarOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorSum(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorSum(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			ScalarVector v = parameters.Vector1.Expand();
			double sum = 0;
			for(int i=0;i<parameters.Vector1.Length;i++)
				sum += v[i].Calculate();
			return(sum);
		}
		public override IScalarExpression Expand()
		{
			ScalarVector xsub = parameters.Vector1.Expand();
			IScalarExpression expr = ScalarExpressionValue.Zero(context);
			for(int i=0;i<xsub.Length;i++)
				expr = new ScalarAddition(context,expr,xsub[i]);
			return expr;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="length")]
	public class VectorLength: ScalarOperator
	{
		protected Vector1Parameters parameters;
		public Vector1Parameters Parameters {get {return parameters;}}
		public VectorLength(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorLength(Context context, IVectorExpression sub): base(context)
		{
			this.parameters = new Vector1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return (double) parameters.Vector1.Length;
		}
		public override IScalarExpression Expand()
		{
			return new ScalarExpressionValue(context,parameters.Vector1.Length);
		}
	}
	#endregion

	#region ScalarVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class VectorScalarMultiplication: VectorOperator
	{
		protected Scalar1Vector1Parameters parameters;
		public Scalar1Vector1Parameters Parameters {get {return parameters;}}
		public VectorScalarMultiplication(Context context, Scalar1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorScalarMultiplication(Context context, IVectorExpression vector, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(scalar,vector);
			Init(parameters);
		}
		public VectorScalarMultiplication(Context context, IScalarExpression scalar, IVectorExpression vector): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(scalar,vector);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			int len = v.Length;
			IScalarExpression[] se = new IScalarExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ScalarMultiplication(context,parameters.Scalar1,v[i]);
			return new ScalarVector(context,se);
		}
		public override IVectorExpression Simplify()
		{
			IScalarExpression xScalar = parameters.Scalar1.Simplify();
			IVectorExpression xVector = parameters.Vector1.Simplify();
			if(xVector.IsEntity)
				return Expand().Simplify();
			if(xScalar.IsConstant)
			{
				double d = xScalar.Calculate();
				if(d == 1)
					return xVector;
				if(d == -1)
					return new VectorNegative(context,xVector).Simplify();
				if(d == 0)
				{
					IScalarExpression[] v = new IScalarExpression[xVector.Length];
					for(int i=0;i<v.Length;i++)
						v[i] = ScalarExpressionValue.Zero(context);
					return new ScalarVector(context,v);
				}
			}
			return new VectorScalarMultiplication(context,xVector,xScalar);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="/")]
	public class VectorScalarDivision: VectorOperator
	{
		protected Scalar1Vector1Parameters parameters;
		public Scalar1Vector1Parameters Parameters {get {return parameters;}}
		public VectorScalarDivision(Context context, Scalar1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorScalarDivision(Context context, IVectorExpression vector, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(scalar,vector);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			int len = v.Length;
			IScalarExpression[] se = new IScalarExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ScalarDivision(context,v[i],parameters.Scalar1);
			return new ScalarVector(context,se);
		}
		public override IVectorExpression Simplify()
		{
			IScalarExpression xScalar = parameters.Scalar1.Simplify();
			IVectorExpression xVector = parameters.Vector1.Simplify();
			if(xVector.IsEntity)
				return Expand().Simplify();
			if(xScalar.IsConstant)
			{
				double d = xScalar.Calculate();
				if(d == 1)
					return xVector;
				if(d == -1)
					return new VectorNegative(context,xVector).Simplify();
				if(double.IsInfinity(d))
				{
					IScalarExpression[] v = new IScalarExpression[xVector.Length];
					for(int i=0;i<v.Length;i++)
						v[i] = ScalarExpressionValue.Zero(context);
					return new ScalarVector(context,v);
				}
			}
			return new VectorScalarDivision(context,xVector,xScalar);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public override string ToString()
		{
			return "("+parameters.Vector1.ToString()+"/"+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="VectorNorm")]
	public class VectorPNorm: ScalarOperator
	{
		protected Scalar1Vector1Parameters parameters;
		public Scalar1Vector1Parameters Parameters {get {return parameters;}}
		public VectorPNorm(Context context, Scalar1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorPNorm(Context context, IVectorExpression vector, IScalarExpression normselector): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(normselector,vector);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			IScalarExpression se = new ScalarRaiseToPower(context,v[0],parameters.Scalar1);
			for(int i=1;i<v.Length;i++)
			{
				se = new ScalarAddition(context,se,new ScalarRaiseToPower(context,v[i],parameters.Scalar1));
			}
			return new ScalarRoot(context,se,parameters.Scalar1);
		}
		public override string ToString()
		{
			return "VectorNorm("+parameters.Vector1.ToString()+","+parameters.Scalar1.ToString()+")";
		}
	}
	#endregion

	#region Other Operators
	[ParsingObject(ParsingObjectType.Function,250,Character="get")]
	public class VectorGet: ScalarOperator
	{
		protected Scalar1Vector1Parameters parameters;
		public Scalar1Vector1Parameters Parameters {get {return parameters;}}
		public VectorGet(Context context, Scalar1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorGet(Context context, IVectorExpression vector, IScalarExpression y): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(y,vector);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			if(parameters.Scalar1.IsConstant)
			{
				int yy = Convert.ToInt32(parameters.Scalar1.Calculate());
				return parameters.Vector1.Expand()[yy];
			}
			return this;
		}
		public override string ToString()
		{
			return "get("+parameters.Vector1.ToString()+","+parameters.Scalar1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="set")]
	public class VectorSet: StdProcedure, IProcExpression
	{
		protected Scalar2Vector1Parameters parameters;
		public Scalar2Vector1Parameters Parameters {get {return parameters;}}
		public VectorSet(Context context, IVectorExpression vector, IScalarExpression y, IScalarExpression val): base(context)
		{
			this.parameters = new Scalar2Vector1Parameters(y,val,vector);
			Init(parameters);
		}
		public override bool Execute()
		{
			int yy = Convert.ToInt32(parameters.Scalar1.Calculate());
			VectorExpressionVariable v1 = parameters.Vector1 as VectorExpressionVariable;
			if(v1 != null)
			{
				ScalarVector m = v1.Value.Expand();
				m[yy] = parameters.Scalar2;
				v1.Value = m;
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = parameters.Vector1 as Variable;
			if(v == null)
				return("set(" + parameters.Vector1.ToString() + "," + parameters.Scalar1.ToString() + "," + parameters.Scalar2.ToString() + ")");
			else
				return("set(" + v.VariableName + "," + parameters.Scalar1.ToString() + "," + parameters.Scalar2.ToString() + ")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="slice")]
	public class VectorSlice: VectorOperator
	{
		protected Scalar2Vector1Parameters parameters;
		public Scalar2Vector1Parameters Parameters {get {return parameters;}}
		public VectorSlice(Context context, Scalar2Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorSlice(Context context, IVectorExpression sub, IScalarExpression top, IScalarExpression bottom): base(context)
		{
			this.parameters = new Scalar2Vector1Parameters(top,bottom,sub);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector smin = parameters.Vector1.Expand();
			int top = (int)Math.Floor(parameters.Scalar1.Calculate());
			int bottom = (int)Math.Floor(parameters.Scalar2.Calculate());
			MathHelper.NormalizeMinMaxSpan(ref top, ref bottom, smin.Length);
			int len = bottom-top+1;
			IScalarExpression[] se = new IScalarExpression[len];
			for(int y=0;y<len;y++)
				se[y] = smin[y+top];
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get
			{
				int top = (int)Math.Floor(parameters.Scalar1.Calculate());
				int bottom = (int)Math.Floor(parameters.Scalar2.Calculate());
				MathHelper.NormalizeMinMaxSpan(ref top, ref bottom, parameters.Vector1.Length);
				return bottom-top+1;
			}
		}
		public override string ToString()
		{
			return "slice("+parameters.Vector1.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Scalar2.ToString()+")";
		}
	}
	#endregion
}
