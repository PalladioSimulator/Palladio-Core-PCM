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
	#region Derivation & Integration
	[ParsingObject(ParsingObjectType.Function,250,Character="diff")]
	public class ScalarDerive: ScalarOperator
	{
		protected Scalar3Parameters parameters;
		public Scalar3Parameters Parameters {get {return parameters;}}
		public ScalarDerive(Context context, Scalar3Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarDerive(Context context,IScalarExpression lambda, IScalarExpression var): base(context)
		{
			this.parameters = new Scalar3Parameters(lambda,var,ScalarExpressionValue.One(context));
			Init(parameters);
		}
		public ScalarDerive(Context context,IScalarExpression lambda, IScalarExpression var, IScalarExpression times): base(context)
		{
			this.parameters = new Scalar3Parameters(lambda,var,times);
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
			bool virt = var.IsThreatenedAsVariable;
			var.IsThreatenedAsVariable = true;

			try
			{
				if(parameters.Scalar3.IsConstant)
				{
					double d = parameters.Scalar3.Calculate();
					if(!double.IsInfinity(d))
					{
						int t = (int)Math.Floor(d);
						if(t < 0)
						{
							var.IsThreatenedAsVariable = virt;
							return new ScalarIntegrate(context,parameters.Scalar1,var,new ScalarExpressionValue(context,-t)).Simplify();
						}
						if(t == 0)
						{
							var.IsThreatenedAsVariable = virt;
							return parameters.Scalar1;
						}
						if(t == 1)
						{
							IScalarExpression tmp = parameters.Scalar1.Differentiate(var);
							var.IsThreatenedAsVariable = virt;
							if((tmp as ScalarDerive) != null)
								return this;
							else
								return tmp;
						}
						if(t > 1)
						{
							IScalarExpression se = parameters.Scalar1.Simplify();
							for(int i=0;i<t;i++)
							{
								se = se.Differentiate(var);
								if((se as ScalarDerive) != null)
									return this;
								se = se.Simplify();
								ScalarConversionMap.Convert(ref se, "simple");
							}
							var.IsThreatenedAsVariable = virt;
							return se;
						}
					}
				}
			}
			catch(NotSupportedException e) {}

			//do not expand if infinity or not constant:
			var.IsThreatenedAsVariable = virt;
			return new ScalarDerive(context,parameters.Scalar1.Simplify(),parameters.Scalar2,parameters.Scalar3.Simplify());
		}
		public override IScalarExpression Expand()
		{
			return Simplify();
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			if(var.Equals(parameters.Scalar2))
				return new ScalarDerive(context,parameters.Scalar1,parameters.Scalar2,new ScalarAddition(context,parameters.Scalar3,ScalarExpressionValue.One(context)));
			else
				return base.Differentiate(var);
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(var.Equals(parameters.Scalar2))
				return new ScalarDerive(context,parameters.Scalar1,parameters.Scalar2,new ScalarSubtraction(context,parameters.Scalar3,ScalarExpressionValue.One(context)));
			else
				return base.Integrate(var);
		}
	}

	[ParsingObject(ParsingObjectType.Function,250,Character="int")]
	public class ScalarIntegrate: ScalarOperator
	{
		protected Scalar3Parameters parameters;
		public Scalar3Parameters Parameters {get {return parameters;}}
		public ScalarIntegrate(Context context, Scalar3Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarIntegrate(Context context,IScalarExpression lambda, IScalarExpression var): base(context)
		{
			this.parameters = new Scalar3Parameters(lambda,var,ScalarExpressionValue.One(context));
			Init(parameters);
		}
		public ScalarIntegrate(Context context,IScalarExpression lambda, IScalarExpression var, IScalarExpression times): base(context)
		{
			this.parameters = new Scalar3Parameters(lambda,var,times);
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
			bool virt = var.IsThreatenedAsVariable;
			var.IsThreatenedAsVariable = true;

			try
			{
				if(parameters.Scalar3.IsConstant)
				{
					double d = parameters.Scalar3.Calculate();
					if(!double.IsInfinity(d))
					{
						int t = (int)Math.Floor(d);
						if(t < 0)
						{
							var.IsThreatenedAsVariable = virt;
							return new ScalarDerive(context,parameters.Scalar1,var,new ScalarExpressionValue(context,-t)).Simplify();
						}
						if(t == 0)
						{
							var.IsThreatenedAsVariable = virt;
							return parameters.Scalar1;
						}
						if(t == 1)
						{
							IScalarExpression tmp = parameters.Scalar1.Integrate(var);
							var.IsThreatenedAsVariable = virt;
							if((tmp as ScalarIntegrate) != null)
								return this;
							else
								return tmp;
						}
						if(t > 1)
						{
							IScalarExpression se = parameters.Scalar1.Simplify();
							for(int i=0;i<t;i++)
							{
								se = se.Integrate(var);
								if((se as ScalarIntegrate) != null)
									return this;
								se = se.Simplify();
								ScalarConversionMap.Convert(ref se, "simple");
							}
							var.IsThreatenedAsVariable = virt;
							return se;
						}
					}
				}
			}
			catch(NotSupportedException e) {}

			//do not expand if infinity or not constant:
			var.IsThreatenedAsVariable = virt;
			return new ScalarIntegrate(context,parameters.Scalar1.Simplify(),parameters.Scalar2,parameters.Scalar3.Simplify());
		}
		public override IScalarExpression Expand()
		{
			return Simplify();
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(var.Equals(parameters.Scalar2))
				return new ScalarIntegrate(context,parameters.Scalar1,parameters.Scalar2,new ScalarAddition(context,parameters.Scalar3,ScalarExpressionValue.One(context)));
			else
				return base.Integrate(var);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			if(var.Equals(parameters.Scalar2))
				return new ScalarIntegrate(context,parameters.Scalar1,parameters.Scalar2,new ScalarSubtraction(context,parameters.Scalar3,ScalarExpressionValue.One(context)));
			else
				return base.Differentiate(var);
		}
	}

	[ParsingObject(ParsingObjectType.Function,250,Character="int")]
	public class ScalarIntegrateLimit: ScalarOperator
	{
		protected Scalar5Parameters parameters;
		public Scalar5Parameters Parameters {get {return parameters;}}
		public ScalarIntegrateLimit(Context context, Scalar5Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarIntegrateLimit(Context context,IScalarExpression lambda, IScalarExpression var, IScalarExpression a, IScalarExpression b): base(context)
		{
			this.parameters = new Scalar5Parameters(lambda,var,ScalarExpressionValue.One(context),a,b);
			Init(parameters);
		}
		public ScalarIntegrateLimit(Context context,IScalarExpression lambda, IScalarExpression var, IScalarExpression times, IScalarExpression a, IScalarExpression b): base(context)
		{
			this.parameters = new Scalar5Parameters(lambda,var,times,a,b);
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
			bool virt = var.IsThreatenedAsVariable;
			var.IsThreatenedAsVariable = true;
			IScalarExpression F = new ScalarIntegrate(context,parameters.Scalar1,var,parameters.Scalar3).Simplify();
			ScalarConversionMap.Convert(ref F, "simple");
			if((F as ScalarDerive != null) || (F as ScalarIntegrate != null) || (F as ScalarIntegrateLimit != null))
			{
				var.IsThreatenedAsVariable = virt;
				return new ScalarIntegrateLimit(context,parameters.Scalar1.Simplify(),var,parameters.Scalar3.Simplify(),parameters.Scalar4.Simplify(),parameters.Scalar5.Simplify());
			}
			var.IsThreatenedAsVariable = false;
			var.Value = parameters.Scalar5;
			IScalarExpression Fb = F.Simplify();
			var.Value = parameters.Scalar4;
			IScalarExpression Fa = F.Simplify();
			var.IsThreatenedAsVariable = virt;
			return new ScalarSubtraction(context,Fb,Fa).Simplify();
		}
		public override IScalarExpression Expand()
		{
			return Simplify();
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(var.Equals(parameters.Scalar2))
				return new ScalarIntegrateLimit(context,parameters.Scalar1,var,new ScalarAddition(context,parameters.Scalar3,ScalarExpressionValue.One(context)),parameters.Scalar4,parameters.Scalar5);
			else
				return base.Integrate(var);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			if(var.Equals(parameters.Scalar2))
				return new ScalarIntegrateLimit(context,parameters.Scalar1,var,new ScalarSubtraction(context,parameters.Scalar3,ScalarExpressionValue.One(context)),parameters.Scalar4,parameters.Scalar5);
			else
				return base.Differentiate(var);
		}
	}
	#endregion

	#region Approximation
	[ParsingObject(ParsingObjectType.Function,250,Character="jet")]
	public class ScalarTaylorJet: ScalarOperator
	{
		protected Scalar5Parameters parameters;
		public Scalar5Parameters Parameters {get {return parameters;}}
		public ScalarTaylorJet(Context context, Scalar5Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTaylorJet(Context context,IScalarExpression lambda, IScalarExpression var, IScalarExpression pos, IScalarExpression val, IScalarExpression n): base(context)
		{
			this.parameters = new Scalar5Parameters(lambda,var,pos,val,n);
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
			var.Value = parameters.Scalar3.Simplify();
			
			IScalarExpression delta = new ScalarSubtraction(context,parameters.Scalar4,parameters.Scalar3).Simplify();

			if(parameters.Scalar5.IsConstant)
			{
				double dn = parameters.Scalar5.Calculate();
				if(!double.IsInfinity(dn) && dn >= 1)
				{
					int n = (int)Math.Floor(dn);		
					IScalarExpression diff = parameters.Scalar1;
					var.IsThreatenedAsVariable = false;
					IScalarExpression result = diff.Simplify();
					var.IsThreatenedAsVariable = true;
					for(int i=1;i<=n;i++)
					{
						diff = diff.Differentiate(var).Simplify();
						ScalarConversionMap.Convert(ref diff,"simple");
						var.IsThreatenedAsVariable = false;
						IScalarExpression frac = new ScalarDivision(context,diff,new ScalarFactorial(context,new ScalarExpressionValue(context,i)));
						result = new ScalarAddition(context,result,new ScalarMultiplication(context,frac,new ScalarRaiseToPower(context,delta,new ScalarExpressionValue(context,i)))).Simplify();
						var.IsThreatenedAsVariable = true;
					}
					return result;
				}
			}
			//do not expand if infinity or not constant:
			var.IsThreatenedAsVariable = true;
			ScalarExpressionVariable k = new ScalarExpressionVariable(context,"k",ScalarExpressionValue.One(context));
			IScalarExpression sfrac = new ScalarDivision(context,new ScalarDerive(context,parameters.Scalar1,var,k),new ScalarFactorial(context,k));
			//var.IsThreatenedAsVariable = false;
			IScalarExpression prod = new ScalarMultiplication(context,sfrac,new ScalarRaiseToPower(context,delta,k)).Simplify();
			//var.IsThreatenedAsVariable = false;
			return new ScalarSum(context,prod,k,ScalarExpressionValue.Zero(context),parameters.Scalar5);
		}
		public override IScalarExpression Expand()
		{
			return Simplify();
		}
	}
	#endregion

	#region Gamma & Psi
	[ParsingObject(ParsingObjectType.Function,250,Character="Gamma")]
	public class ScalarGamma: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarGamma(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarGamma(Context context,IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			throw new NotSupportedException();
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				double xCalc = xSub.Calculate();
				if(xCalc == 0) // not mathematically correct however ...
					return ScalarExpressionValue.PositiveInfinity(context);
				if(xCalc > 0 && xCalc % 1 == 0)
					return new ScalarFactorial(context,new ScalarExpressionValue(context,xCalc-1)).Simplify();
			}
			return new ScalarGamma(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarMultiplication(context,new ScalarPsi(context,parameters.Scalar1),this),parameters.Scalar1.Differentiate(var));
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="Psi")]
	public class ScalarPsi: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarPsi(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarPsi(Context context,IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			throw new NotSupportedException();
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				double xCalc = xSub.Calculate();
				if(xCalc == 0) // not mathematically correct however ...
					return ScalarExpressionValue.NegativeInfinity(context);
			}
			return new ScalarPsi(context,xSub);
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new Logarithm.ScalarNaturalLogarithm(context,new ScalarGamma(context,parameters.Scalar1));
			return base.Integrate(var);
		}
	}
	#endregion
}
