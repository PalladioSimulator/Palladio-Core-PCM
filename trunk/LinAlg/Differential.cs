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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	[ParsingObject(ParsingObjectType.Function,250,Character="grad")]
	public class ScalarGradient: VectorOperator
	{
		protected Scalar1Vector1Parameters parameters;
		public Scalar1Vector1Parameters Parameters {get {return parameters;}}
		public ScalarGradient(Context context, Scalar1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarGradient(Context context, IScalarExpression lambda, IVectorExpression basevector): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(lambda,basevector);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			int len = v.Length;
			IScalarExpression[] se = new IScalarExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ScalarDerive(context,parameters.Scalar1,v[i]);
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="jacobi")]
	public class ScalarJacobian: MatrixOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public ScalarJacobian(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarJacobian(Context context, IVectorExpression lambda, IVectorExpression basevector): base(context)
		{
			this.parameters = new Vector2Parameters(lambda,basevector);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarVector slambda = parameters.Vector1.Expand();
			ScalarVector sparams = parameters.Vector2.Expand();
			IVectorExpression[] ve = new IVectorExpression[slambda.Length];
			for(int y=0;y<slambda.Length;y++)
				ve[y] = new ScalarGradient(context,slambda[y],sparams);
			return new MatrixTranspose(context,new ScalarMatrix(context,ve)).Expand();
		}
		public override int LengthX
		{
			get {return parameters.Vector2.Length;}
		}
		public override int LengthY
		{
			get {return parameters.Vector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="div")]
	public class ScalarDivergence: ScalarOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public ScalarDivergence(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarDivergence(Context context, IVectorExpression field, IVectorExpression basevector): base(context)
		{
			this.parameters = new Vector2Parameters(field,basevector);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			ScalarVector v = parameters.Vector1.Expand();
			ScalarVector vars = parameters.Vector2.Expand();
			if(vars[0] as ScalarExpressionVariable == null)
				throw new ExpressionVariableRequiredException();
			IScalarExpression sum = v[0].Differentiate(vars[0] as ScalarExpressionVariable);
			for(int i=1;i<Math.Min(v.Length,vars.Length);i++)
			{
				if(vars[i] as ScalarExpressionVariable == null)
					throw new ExpressionVariableRequiredException();
				sum = new ScalarAddition(context,sum,v[i].Differentiate(vars[i] as ScalarExpressionVariable));
			}
			return sum;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="laplace")]
	public class ScalarLaplacian: ScalarOperator
	{
		protected Scalar1Vector1Parameters parameters;
		public Scalar1Vector1Parameters Parameters {get {return parameters;}}
		public ScalarLaplacian(Context context, Scalar1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarLaplacian(Context context, IScalarExpression lambda, IVectorExpression basevector): base(context)
		{
			this.parameters = new Scalar1Vector1Parameters(lambda,basevector);
			Init(parameters);
		}
		public override IScalarExpression Expand()
		{
			return new ScalarDivergence(context,new ScalarGradient(context,parameters.Scalar1,parameters.Vector1),parameters.Vector1);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="rot")]
	public class ScalarRotation: VectorOperator
	{
		protected Vector2Parameters parameters;
		public Vector2Parameters Parameters {get {return parameters;}}
		public ScalarRotation(Context context, Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarRotation(Context context, IVectorExpression field, IVectorExpression basevector): base(context)
		{
			this.parameters = new Vector2Parameters(field,basevector);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector sfield = parameters.Vector1.Expand();
			ScalarVector sparams = parameters.Vector2.Expand();
			if(sfield.Length != 3 || sparams.Length != 3)
				throw(new ExpressionRankMismatchException());
			if(sparams[0] as ScalarExpressionVariable==null || sparams[1] as ScalarExpressionVariable==null || sparams[2] as ScalarExpressionVariable==null)
				throw new ExpressionVariableRequiredException();
			IScalarExpression[] se = new IScalarExpression[3];
			se[0] = new ScalarSubtraction(context,sfield[2].Differentiate(sparams[1] as ScalarExpressionVariable),sfield[1].Differentiate(sparams[2] as ScalarExpressionVariable));
			se[1] = new ScalarSubtraction(context,sfield[0].Differentiate(sparams[2] as ScalarExpressionVariable),sfield[2].Differentiate(sparams[0] as ScalarExpressionVariable));
			se[2] = new ScalarSubtraction(context,sfield[1].Differentiate(sparams[0] as ScalarExpressionVariable),sfield[0].Differentiate(sparams[1] as ScalarExpressionVariable));
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return 3;}
		}
	}
}