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

namespace cdrnet.Lib.MathLib.Scalar
{
	[ParsingObject(ParsingObjectType.Function,250,Character="sum")]
	public class ScalarSum: ScalarOperator
	{
		protected Scalar4Parameters parameters;
		public Scalar4Parameters Parameters {get {return parameters;}}
		public ScalarSum(Context context, Scalar4Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarSum(Context context, IScalarExpression lambda, IScalarExpression var, IScalarExpression start, IScalarExpression end) : base(context)
		{
			this.parameters = new Scalar4Parameters(lambda,var,start,end);
			Init(parameters);
		}
		public override double Calculate()
		{
			throw new NotImplementedException();
		}
		public override IScalarExpression Simplify()
		{
			ScalarExpressionVariable var = parameters.Scalar2 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			bool waslocked = var.IsThreatenedAsVariable;
			IScalarExpression wasvalue = var.Value;
			var.IsThreatenedAsVariable = true;
			IScalarExpression lambda = parameters.Scalar1.Simplify();
			IScalarExpression start = parameters.Scalar3.Simplify();
			IScalarExpression end = parameters.Scalar4.Simplify();
			var.IsThreatenedAsVariable = false;
			if(start.Equals(end))
			{
				var.Value = start;
				IScalarExpression res = lambda.Simplify();
				var.Value = wasvalue;
				var.IsThreatenedAsVariable = waslocked;
				return res;
			}
			var.Value = wasvalue;
			var.IsThreatenedAsVariable = waslocked;
			return new ScalarSum(context,lambda,var,start,end);
		}
		public override IScalarExpression Expand()
		{
			ScalarExpressionVariable var = parameters.Scalar2 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			bool waslocked = var.IsThreatenedAsVariable;
			IScalarExpression wasvalue = var.Value;
			var.IsThreatenedAsVariable = true;
			IScalarExpression lambda = parameters.Scalar1.Expand().Simplify();
			IScalarExpression start = parameters.Scalar3.Expand().Simplify();
			IScalarExpression end = parameters.Scalar4.Expand().Simplify();
			var.IsThreatenedAsVariable = false;
			IScalarExpression rsp;
			if(start.Equals(end))
			{
				var.Value = start;
				rsp = lambda.Simplify();
				var.Value = wasvalue;
				var.IsThreatenedAsVariable = waslocked;
				return rsp;
			}
			double dstart, dend;
			int istart, iend;
			if(start.IsConstant && end.IsConstant)
			{
				dstart = start.Calculate();
				dend = end.Calculate();
				if(!double.IsInfinity(dstart) && !double.IsInfinity(dend))
				{
					if(dend > dstart)
					{
						istart = (int)Math.Ceiling(dstart);
						iend = (int)Math.Floor(dend);
					}
					else
					{
						istart = (int)Math.Ceiling(dend);
						iend = (int)Math.Floor(dstart);
					}
					var.Value = new ScalarExpressionValue(context,istart++);
					rsp = lambda.Simplify();
					for(int i=istart;i<=iend;i++)
					{
						var.Value = new ScalarExpressionValue(context,i);
						rsp = new ScalarAddition(context,rsp,lambda.Simplify());
					}
					var.Value = wasvalue;
					var.IsThreatenedAsVariable = waslocked;
					return rsp;
				}
			}
			var.Value = wasvalue;
			var.IsThreatenedAsVariable = waslocked;
			return new ScalarSum(context,lambda,var,start,end);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			VariableManager vlambda = new VariableManager(context);
			VariableManager vstart = new VariableManager(context);
			VariableManager vend = new VariableManager(context);
			parameters.Scalar1.CollectVariables(vlambda,false);
			parameters.Scalar3.CollectVariables(vstart,false);
			parameters.Scalar4.CollectVariables(vend,false);
			if(!vlambda.IsDefined(var) && !vstart.IsDefined(var) && !vend.IsDefined(var))
				return ScalarExpressionValue.Zero(context);
			if(!vstart.IsDefined(var) && !vend.IsDefined(var))
				return new ScalarSum(context,parameters.Scalar1.Differentiate(var),parameters.Scalar2,parameters.Scalar3,parameters.Scalar4);
			return base.Differentiate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="product")]
	public class ScalarProduct: ScalarOperator
	{
		protected Scalar4Parameters parameters;
		public Scalar4Parameters Parameters {get {return parameters;}}
		public ScalarProduct(Context context, Scalar4Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarProduct(Context context, IScalarExpression lambda, IScalarExpression var, IScalarExpression start, IScalarExpression end) : base(context)
		{
			this.parameters = new Scalar4Parameters(lambda,var,start,end);
			Init(parameters);
		}
		public override double Calculate()
		{
			throw new NotImplementedException();
		}
		public override IScalarExpression Simplify()
		{
			ScalarExpressionVariable var = parameters.Scalar2 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			bool waslocked = var.IsThreatenedAsVariable;
			IScalarExpression wasvalue = var.Value;
			var.IsThreatenedAsVariable = true;
			IScalarExpression lambda = parameters.Scalar1.Simplify();
			IScalarExpression start = parameters.Scalar3.Simplify();
			IScalarExpression end = parameters.Scalar4.Simplify();
			var.IsThreatenedAsVariable = false;
			if(start.Equals(end))
			{
				var.Value = start;
				IScalarExpression res = lambda.Simplify();
				var.Value = wasvalue;
				var.IsThreatenedAsVariable = waslocked;
				return res;
			}
			var.Value = wasvalue;
			var.IsThreatenedAsVariable = waslocked;
			return new ScalarProduct(context,lambda,var,start,end);
		}
		public override IScalarExpression Expand()
		{
			ScalarExpressionVariable var = parameters.Scalar2 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			bool waslocked = var.IsThreatenedAsVariable;
			IScalarExpression wasvalue = var.Value;
			var.IsThreatenedAsVariable = true;
			IScalarExpression lambda = parameters.Scalar1.Expand().Simplify();
			IScalarExpression start = parameters.Scalar3.Expand().Simplify();
			IScalarExpression end = parameters.Scalar4.Expand().Simplify();
			var.IsThreatenedAsVariable = false;
			IScalarExpression rsp;
			if(start.Equals(end))
			{
				var.Value = start;
				rsp = lambda.Simplify();
				var.Value = wasvalue;
				var.IsThreatenedAsVariable = waslocked;
				return rsp;
			}
			double dstart, dend;
			int istart, iend;
			if(start.IsConstant && end.IsConstant)
			{
				dstart = start.Calculate();
				dend = end.Calculate();
				if(!double.IsInfinity(dstart) && !double.IsInfinity(dend))
				{
					if(dend > dstart)
					{
						istart = (int)Math.Ceiling(dstart);
						iend = (int)Math.Floor(dend);
					}
					else
					{
						istart = (int)Math.Ceiling(dend);
						iend = (int)Math.Floor(dstart);
					}
					var.Value = new ScalarExpressionValue(context,istart++);
					rsp = lambda.Simplify();
					for(int i=istart;i<=iend;i++)
					{
						var.Value = new ScalarExpressionValue(context,i);
						rsp = new ScalarMultiplication(context,rsp,lambda.Simplify());
					}
					var.Value = wasvalue;
					var.IsThreatenedAsVariable = waslocked;
					return rsp;
				}
			}
			var.Value = wasvalue;
			var.IsThreatenedAsVariable = waslocked;
			return new ScalarProduct(context,lambda,var,start,end);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			VariableManager vlambda = new VariableManager(context);
			VariableManager vstart = new VariableManager(context);
			VariableManager vend = new VariableManager(context);
			parameters.Scalar1.CollectVariables(vlambda,false);
			parameters.Scalar3.CollectVariables(vstart,false);
			parameters.Scalar4.CollectVariables(vend,false);
			if(!vlambda.IsDefined(var) && !vstart.IsDefined(var) && !vend.IsDefined(var))
				return ScalarExpressionValue.Zero(context);
			if(!vstart.IsDefined(var) && !vend.IsDefined(var))
			{
				ScalarExpressionVariable k = context.ContextVariables.CreateNewParameter("k");
				IScalarExpression dlambda = parameters.Scalar1.Differentiate(var);
				IScalarExpression klambda = parameters.Scalar1.Substitute(parameters.Scalar2,k);
				return new ScalarSum(context,new ScalarMultiplication(context,new ScalarMultiplication(context,new ScalarProduct(context,klambda,k,parameters.Scalar3,new ScalarSubtraction(context,parameters.Scalar2,ScalarExpressionValue.One(context))),new ScalarProduct(context,klambda,k,new ScalarAddition(context,parameters.Scalar2,ScalarExpressionValue.One(context)),parameters.Scalar4)),dlambda),parameters.Scalar2,parameters.Scalar3,parameters.Scalar4);
			}
			return base.Differentiate(var);
		}
	}
}
