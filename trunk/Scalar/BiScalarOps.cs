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
using cdrnet.Lib.MathLib.Scalar.Logarithm;

namespace cdrnet.Lib.MathLib.Scalar
{
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*",Commutative=true,Associative=true)]
	public class ScalarMultiplication: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarMultiplication(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ScalarMultiplication(Context context, IScalarExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Scalar2Parameters(first,last);
			Init(Parameters);
		}
		public override double Calculate()
		{
			return parameters.Scalar1.Calculate() * parameters.Scalar2.Calculate();
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new ScalarExpressionValue(context,xFirst.Calculate() * xLast.Calculate());
			}
			if(xFirst.IsEntity)
			{
				double t = xFirst.Calculate();
				if(t == 0)
					return(xFirst);
				if(t == 1)
					return(xLast);
				if(t == -1)
					return new ScalarNegative(context,xLast);
			}
			if(xLast.IsEntity)
			{
				double t = xLast.Calculate();
				if(t == 0)
					return(xLast);
				if(t == 1)
					return(xFirst);
				if(t == -1)
					return new ScalarNegative(context,xFirst);
			}
			return new ScalarMultiplication(context,xFirst,xLast);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1.Differentiate(var),parameters.Scalar2),new ScalarMultiplication(context,parameters.Scalar1,parameters.Scalar2.Differentiate(var)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			VariableManager mf = new VariableManager(context);
			VariableManager ml = new VariableManager(context);
			parameters.Scalar1.CollectVariables(mf,false);
			parameters.Scalar2.CollectVariables(ml,false);
			if(!mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,var,this);
			if(mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,parameters.Scalar2,parameters.Scalar1.Integrate(var));
			if(!mf.IsDefined(var) && ml.IsDefined(var))
				return new ScalarMultiplication(context,parameters.Scalar1,parameters.Scalar2.Integrate(var));
			if(mf.IsDefined(var) && ml.IsDefined(var))
			{
				IScalarExpression tmpl = parameters.Scalar2.Differentiate(var).Simplify();
				IScalarExpression tmpf = parameters.Scalar1.Differentiate(var).Simplify();
				ScalarConversionMap.Convert(ref tmpl,"simple");
				ScalarConversionMap.Convert(ref tmpf,"simple");
				if(parameters.Scalar2.Equals(tmpf))
					return new ScalarDivision(context,new ScalarSquare(context,parameters.Scalar1),ScalarExpressionValue.Two(context));
				if(parameters.Scalar1.Equals(tmpl))
					return new ScalarDivision(context,new ScalarSquare(context,parameters.Scalar2),ScalarExpressionValue.Two(context));
			}
			return base.Integrate(var);
		}
//		public IScalarExpression[] Isolate(ScalarExpressionVariable var, IScalarExpression to)
//		{
//			bool bf = VariableManager.Contains(var.VariableName,first);
//			bool bl = VariableManager.Contains(var.VariableName,last);
//			if(bf && bl)
//			{
//				ScalarExpressionVariable t = new ScalarExpressionVariable("t",to);
//				t.IsThreatenedAsVariable = true;
//				IScalarExpression[] rfs = first.Isolate(var, t);
//				IScalarExpression[] rls = last.Isolate(var, t);
//				int len = rfs.Length * rls.Length;
//				t.IsThreatenedAsVariable = false;
//				IScalarExpression[] rsp = new IScalarExpression[len];
//				for(int f=0;f<rfs.Length;f++)
//					for(int l=0;l<rls.Length;l++)
//					{
//						rsp[f*l] = new ScalarMultiplication(rfs[f].Simplify(),rls[l].Simplify());
//					}
//				return rsp;
//			}
//		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+",Commutative=true,Associative=true)]
	public class ScalarAddition: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarAddition(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ScalarAddition(Context context, IScalarExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Scalar2Parameters(first,last);
			Init(parameters);
		}
		public override double Calculate()
		{
			return(parameters.Scalar1.Calculate() + parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new ScalarExpressionValue(context,xFirst.Calculate() + xLast.Calculate());
			}
			if(xFirst.IsEntity && xFirst.Calculate() == 0)
			{
				return xLast;
			}
			if(xLast.IsEntity && xLast.Calculate() == 0)
			{
				return xFirst;
			}
			return new ScalarAddition(context,xFirst,xLast);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarAddition(context,parameters.Scalar1.Differentiate(var),parameters.Scalar2.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			VariableManager mf = new VariableManager(context);
			VariableManager ml = new VariableManager(context);
			parameters.Scalar1.CollectVariables(mf,false);
			parameters.Scalar2.CollectVariables(ml,false);
			if(!mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,var,this);
			if(mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar2,var),parameters.Scalar1.Integrate(var));
			if(!mf.IsDefined(var) && ml.IsDefined(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,var),parameters.Scalar2.Integrate(var));
			if(mf.IsDefined(var) && ml.IsDefined(var))
				return new ScalarAddition(context,parameters.Scalar1.Integrate(var),parameters.Scalar2.Integrate(var));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-",Commutative=false,Associative=false)]
	public class ScalarSubtraction: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarSubtraction(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarSubtraction(Context context, IScalarExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Scalar2Parameters(first,last);
			Init(parameters);
		}
		public override double Calculate()
		{
			return(parameters.Scalar1.Calculate() - parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new ScalarExpressionValue(context,xFirst.Calculate() - xLast.Calculate());
			}
			if(xFirst.IsEntity && xFirst.Calculate() == 0)
			{
				return new ScalarNegative(context,xLast);
			}
			if(xLast.IsEntity && xLast.Calculate() == 0)
			{
				return xFirst;
			}
			if(xLast.IsConstant && xFirst.IsConstant && xLast.Calculate() == xFirst.Calculate())
			{
				return ScalarExpressionValue.Zero(context);
			}
			return new ScalarSubtraction(context,xFirst,xLast);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarSubtraction(context,parameters.Scalar1.Differentiate(var),parameters.Scalar2.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			VariableManager mf = new VariableManager(context);
			VariableManager ml = new VariableManager(context);
			parameters.Scalar1.CollectVariables(mf,false);
			parameters.Scalar2.CollectVariables(ml,false);
			if(!mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,var,this);
			if(mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarSubtraction(context,parameters.Scalar1.Integrate(var),new ScalarMultiplication(context,parameters.Scalar2,var));
			if(!mf.IsDefined(var) && ml.IsDefined(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,var),parameters.Scalar2.Integrate(var));
			if(mf.IsDefined(var) && ml.IsDefined(var))
				return new ScalarSubtraction(context,parameters.Scalar1.Integrate(var),parameters.Scalar2.Integrate(var));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="/",Commutative=false,Associative=false)]
	public class ScalarDivision: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarDivision(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarDivision(Context context, IScalarExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Scalar2Parameters(first,last);
			Init(parameters);
		}
		public override double Calculate()
		{
			return(parameters.Scalar1.Calculate() / parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			double dfirst = 1, dlast = 0;
			if(xFirst.IsEntity)
				dfirst = xFirst.Calculate();
			if(xLast.IsEntity)
				dlast = xLast.Calculate();
			if(dlast == 1)
			{
				return xFirst;
			}
			if(dlast == -1)
			{
				if(xFirst.IsEntity)
					return new ScalarExpressionValue(context,-dfirst);
				else
					return new ScalarNegative(context,xFirst);
			}
			if(dfirst == 0)
			{
				return xFirst;
			}
			if(xFirst.IsEntity && xLast.IsEntity && Math.Floor(dfirst) == dfirst && Math.Floor(dlast) == dlast)
			{
				double gcd = MathHelper.EvaluateGcd(dfirst,dlast);
				dfirst /= gcd;
				dlast /= gcd;
				if(dfirst == 0)
					return ScalarExpressionValue.Zero(context);
				if(dlast == 1)
					return new ScalarExpressionValue(context,dfirst);
				if(dlast == -1)
					return new ScalarExpressionValue(context,-dfirst);
				return new ScalarDivision(context,new ScalarExpressionValue(context,dfirst),new ScalarExpressionValue(context,dlast));
			}
			return new ScalarDivision(context,xFirst,xLast);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1.Differentiate(var),parameters.Scalar2),new ScalarMultiplication(context,parameters.Scalar1,parameters.Scalar2.Differentiate(var))),new ScalarSquare(context,parameters.Scalar2));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			VariableManager mf = new VariableManager(context);
			VariableManager ml = new VariableManager(context);
			xFirst.CollectVariables(mf,false);
			xLast.CollectVariables(ml,false);
			if(!mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,var,this);
			if(mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarDivision(context,xFirst.Integrate(var),xLast);
			if(mf.IsDefined(var) && ml.IsDefined(var))
			{
				IScalarExpression tmp = xLast.Differentiate(var).Simplify();
				if(xFirst.Equals(tmp))
					return new ScalarNaturalLogarithm(context,xLast);
				IScalarExpression xRatio = new ScalarDivision(context,xFirst, tmp);
				ScalarConversionMap.Convert(ref xRatio,"simple");
				if(!VariableManager.IsDefined(var,xRatio,false))
				{
					IScalarExpression nc = new ScalarDivision(context,xFirst,new ScalarMultiplication(context,xRatio,xLast));
					ScalarConversionMap.Convert(ref nc, "simple");
					IScalarExpression yFirst, yLast;
					ScalarNegative ncn = nc as ScalarNegative;
					bool neg = false;
					if(ncn != null)
					{
						neg = true;
						nc = ncn.Parameters.Scalar1;
					}
					ScalarDivision ncd = nc as ScalarDivision;
					if(ncd != null)
					{
						yFirst = ncd.parameters.Scalar1;
						yLast = ncd.parameters.Scalar2;
						IScalarExpression check = yLast.Differentiate(var);
						if(neg)
							check = new ScalarNegative(context,check);
						ScalarConversionMap.Convert(ref check, "simple");
						if(check.Equals(yFirst))
							return new ScalarMultiplication(context,xRatio,new ScalarNaturalLogarithm(context,yLast));
					}
				}
			}
			if(!mf.IsDefined(var) && ml.IsDefined(var))
			{
				if(xLast.Equals(var))
					return new ScalarMultiplication(context,xFirst,new ScalarNaturalLogarithm(context,xLast));
				if(!xFirst.IsEntity || xFirst.Calculate() != 1)
					return new ScalarMultiplication(context,xFirst,new ScalarDivision(context,ScalarExpressionValue.One(context),xLast).Integrate(var));
			}
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,40,Character="^",Commutative=false,Associative=false)]
	public class ScalarRaiseToPower: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarRaiseToPower(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarRaiseToPower(Context context, IScalarExpression expr, IScalarExpression power): base(context)
		{
			this.parameters = new Scalar2Parameters(expr,power);
			Init(parameters);
		}
		public override double Calculate()
		{
			return(Math.Pow(parameters.Scalar1.Calculate(),parameters.Scalar2.Calculate()));
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new ScalarExpressionValue(context,Math.Pow(xFirst.Calculate(),xLast.Calculate()));
			}
			if(xLast.IsEntity)
			{
				double d = xLast.Calculate();
				if(d == 0)
					return ScalarExpressionValue.One(context);
				if(d == 1)
					return xFirst;
			}
			if(xFirst.IsEntity)
			{
				double d = xFirst.Calculate();
				if(d == 1)
					return xFirst;
			}
			return new ScalarRaiseToPower(context,xFirst,xLast);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,this,new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar2.Differentiate(var),new ScalarNaturalLogarithm(context,parameters.Scalar1)),new ScalarDivision(context,new ScalarMultiplication(context,parameters.Scalar2,parameters.Scalar1.Differentiate(var)),parameters.Scalar1)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			VariableManager mf = new VariableManager(context);
			VariableManager ml = new VariableManager(context);
			xFirst.CollectVariables(mf,false);
			xLast.CollectVariables(ml,false);
			if(!mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,var,this);
			if(mf.IsDefined(var) && !ml.IsDefined(var))
			{
				if(xFirst.Equals(var)) //x^(1+n)/(1+n)
					return new ScalarDivision(context,new ScalarRaiseToPower(context,xFirst,new ScalarAddition(context,ScalarExpressionValue.One(context),xLast)),new ScalarAddition(context,ScalarExpressionValue.One(context),xLast));
			}
			if(!mf.IsDefined(var) && ml.IsDefined(var))
			{
				if(xLast.Equals(var)) //1/ln(n)*n^x
					return new ScalarDivision(context,this,new Logarithm.ScalarNaturalLogarithm(context,xFirst));
			}
			return base.Integrate(var);
			//return(new ScalarDivision(new ScalarRaiseToPower(first,last),new ScalarAddition(new ScalarDivision(last.Integrate(var),new ScalarNaturalLogarithm(first)),new ScalarMultiplication(new ScalarDivision(last,first.Integrate(var)),first))));
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="rt",Commutative=false,Associative=false)]
	public class ScalarRoot: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarRoot(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters; 
			Init(parameters);
		}
		public ScalarRoot(Context context, IScalarExpression expr, IScalarExpression power): base(context)
		{
			this.parameters = new Scalar2Parameters(expr,power);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Pow(parameters.Scalar1.Calculate(),1/parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity && (xLast.Calculate() != 0))
			{
				double test = Math.Pow(xFirst.Calculate(),1/xLast.Calculate());
				if(test == Math.Floor(test))
					return new ScalarExpressionValue(context,test);
			}
			return new ScalarRoot(context,xFirst,xLast);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			IScalarExpression ea = new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,parameters.Scalar1,parameters.Scalar2));
			IScalarExpression eb = new ScalarDivision(context,new ScalarMultiplication(context,parameters.Scalar2.Differentiate(var),new Logarithm.ScalarNaturalLogarithm(context,parameters.Scalar1)),new ScalarSquare(context,parameters.Scalar2));
			return new ScalarMultiplication(context,this,new ScalarSubtraction(context,ea,eb));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			VariableManager mf = new VariableManager(context);
			VariableManager ml = new VariableManager(context);
			xFirst.CollectVariables(mf,false);
			xLast.CollectVariables(ml,false);
			if(!mf.IsDefined(var) && !ml.IsDefined(var))
				return new ScalarMultiplication(context,var,this);
			if(mf.IsDefined(var) && !ml.IsDefined(var))
			{
				if(xFirst.Equals(var)) //x^(1+1/n)/(1+1/n)
					return new ScalarDivision(context,new ScalarRaiseToPower(context,xFirst,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarDivision(context,ScalarExpressionValue.One(context),xLast))),new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarDivision(context,ScalarExpressionValue.One(context),xLast)));
			}
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="%",Commutative=false,Associative=false)]
	public class ScalarModulo: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarModulo(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarModulo(Context context, IScalarExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Scalar2Parameters(first,last);
			Init(parameters);
		}
		public override double Calculate()
		{
			return(parameters.Scalar1.Calculate() % parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity && (xLast.Calculate() != 0))
			{
				return new ScalarExpressionValue(context,xFirst.Calculate() % xLast.Calculate());
			}
			return new ScalarModulo(context,xFirst,xLast);
		}
	}
}
