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
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.Logarithm;
using cdrnet.Lib.MathLib.Scalar.Trigonometry;

namespace cdrnet.Lib.MathLib.Scalar
{
	[ConversionMapEntry(typeof(ScalarIntegrate),"simple")]
	public class ScalarMapIntegrationDivision: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarIntegrate it = exp as ScalarIntegrate;
			ScalarExpressionVariable var = it.Parameters.Scalar2 as ScalarExpressionVariable;
			ScalarDivision x = it.Parameters.Scalar1 as ScalarDivision; // INT f(x)/g(x)
			if(x == null || var == null)
				return false;
			VariableManager m1 = new VariableManager(context);
			VariableManager m2 = new VariableManager(context);
			x.Parameters.Scalar1.CollectVariables(m1,false);
			x.Parameters.Scalar2.CollectVariables(m2,false);
			if(!m1.IsDefined(var))
			{
				if(x.Parameters.Scalar1.Equals(ScalarExpressionValue.One(context))) // INT 1/f(x)
				{
					if(x.Parameters.Scalar2.GetType() == typeof(ScalarAddition)) // INT 1/(f(x)+g(x))
					{
						ScalarAddition y = x.Parameters.Scalar2 as ScalarAddition;
						VariableManager my1 = new VariableManager(context);
						VariableManager my2 = new VariableManager(context);
						y.Parameters.Scalar1.CollectVariables(my1,false);
						y.Parameters.Scalar2.CollectVariables(my2,false);
						if(my1.IsDefined(var) && my2.IsDefined(var)) // INT 1/(f(x)+g(x))
						{
						}
						if(!my1.IsDefined(var) && my2.IsDefined(var)) // INT 1/(a+g(x)))
						{
							if(y.Parameters.Scalar2.Equals(var)) // INT 1/(a+x)
							{
								exp = new ScalarNaturalLogarithm(context,y).Simplify();
								return true;
							}
							if(y.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication)) // INT 1/(a+f(x)*g(x))
							{
								ScalarMultiplication z = y.Parameters.Scalar2 as ScalarMultiplication;
								VariableManager mz1 = new VariableManager(context);
								VariableManager mz2 = new VariableManager(context);
								z.Parameters.Scalar1.CollectVariables(mz1,false);
								z.Parameters.Scalar2.CollectVariables(mz2,false);
								if(!mz1.IsDefined(var) && mz2.IsDefined(var)) // INT 1/(a+b*f(x))
								{
									if(z.Parameters.Scalar2.Equals(var)) // INT 1/(a+b*x)
									{
										exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar1).Simplify();
										return true;
									}
								}
								if(mz1.IsDefined(var) && !mz2.IsDefined(var)) // INT 1/(a+f(x)*b)
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(a+x*b)
									{
										exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar2).Simplify();
										return true;
									}
								}
							}
							if(y.Parameters.Scalar2.GetType() == typeof(ScalarDivision)) // INT 1/(a+f(x)/g(x))
							{
								ScalarDivision z = y.Parameters.Scalar2 as ScalarDivision;
								if(!VariableManager.IsDefined(var,z.Parameters.Scalar2,false))
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(a+x/b)
									{
										exp = new ScalarMultiplication(context,z.Parameters.Scalar2,new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarMultiplication(context,y.Parameters.Scalar1,z.Parameters.Scalar2),z.Parameters.Scalar1))).Simplify();
										return true;
									}
								}
							}
						}
						if(my1.IsDefined(var) && !my2.IsDefined(var)) // INT 1/(f(x)+a)
						{
							if(y.Parameters.Scalar1.Equals(var)) // INT 1/(x+a)
							{
								exp = new ScalarNaturalLogarithm(context,y).Simplify();
							}
							if(y.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication)) // INT 1/(f(x)*g(x)+a)
							{
								ScalarMultiplication z = y.Parameters.Scalar1 as ScalarMultiplication;
								VariableManager mz1 = new VariableManager(context);
								VariableManager mz2 = new VariableManager(context);
								z.Parameters.Scalar1.CollectVariables(mz1,false);
								z.Parameters.Scalar2.CollectVariables(mz2,false);
								if(!mz1.IsDefined(var) && mz2.IsDefined(var)) // INT 1/(b*f(x)+a)
								{
									if(z.Parameters.Scalar2.Equals(var)) // INT 1/(b*x+a)
									{
										exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar1).Simplify();
										return true;
									}
								}
								if(mz1.IsDefined(var) && !mz2.IsDefined(var)) // INT 1/(f(x)*b+a)
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(x*b+a)
									{
										exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar2).Simplify();
										return true;
									}
								}
							}
							if(y.Parameters.Scalar1.GetType() == typeof(ScalarDivision)) // INT 1/(f(x)/g(x)+a)
							{
								ScalarDivision z = y.Parameters.Scalar1 as ScalarDivision;
								if(!VariableManager.IsDefined(var,z.Parameters.Scalar2,false))
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(x/b+a)
									{
										exp = new ScalarMultiplication(context,z.Parameters.Scalar2,new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarMultiplication(context,y.Parameters.Scalar2,z.Parameters.Scalar2),z.Parameters.Scalar1))).Simplify();
										return true;
									}
								}
							}
						}
					}
					if(x.Parameters.Scalar2.GetType() == typeof(ScalarSubtraction)) // INT 1/(f(x)-g(x))
					{
						ScalarSubtraction y = x.Parameters.Scalar2 as ScalarSubtraction;
						VariableManager my1 = new VariableManager(context);
						VariableManager my2 = new VariableManager(context);
						y.Parameters.Scalar1.CollectVariables(my1,false);
						y.Parameters.Scalar2.CollectVariables(my2,false);
						if(my1.IsDefined(var) && my2.IsDefined(var)) // INT 1/(f(x)-g(x))
						{
						}
						if(!my1.IsDefined(var) && my2.IsDefined(var)) // INT 1/(a-g(x)))
						{
							if(y.Parameters.Scalar2.Equals(var)) // INT 1/(a-x)
							{
								exp = new ScalarNegative(context,new ScalarNaturalLogarithm(context,y).Simplify());
								return true;
							}
							if(y.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication)) // INT 1/(a-f(x)*g(x))
							{
								ScalarMultiplication z = y.Parameters.Scalar2 as ScalarMultiplication;
								VariableManager mz1 = new VariableManager(context);
								VariableManager mz2 = new VariableManager(context);
								z.Parameters.Scalar1.CollectVariables(mz1,false);
								z.Parameters.Scalar2.CollectVariables(mz2,false);
								if(!mz1.IsDefined(var) && mz2.IsDefined(var)) // INT 1/(a-b*f(x))
								{
									if(z.Parameters.Scalar2.Equals(var)) // INT 1/(a-b*x)
									{
										exp = new ScalarNegative(context,new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar1)).Simplify();
										return true;
									}
								}
								if(mz1.IsDefined(var) && !mz2.IsDefined(var)) // INT 1/(a-f(x)*b)
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(a-x*b)
									{
										exp = new ScalarNegative(context,new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar2)).Simplify();
										return true;
									}
								}
							}
							if(y.Parameters.Scalar2.GetType() == typeof(ScalarDivision)) // INT 1/(a-f(x)/g(x))
							{
								ScalarDivision z = y.Parameters.Scalar2 as ScalarDivision;
								if(!VariableManager.IsDefined(var,z.Parameters.Scalar2,false))
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(a-x/b)
									{
										exp = new ScalarNegative(context,new ScalarMultiplication(context,z.Parameters.Scalar2,new ScalarNaturalLogarithm(context,new ScalarSubtraction(context,new ScalarMultiplication(context,y.Parameters.Scalar1,z.Parameters.Scalar2),z.Parameters.Scalar1)))).Simplify();
										return true;
									}
								}
							}
						}
						if(my1.IsDefined(var) && !my2.IsDefined(var)) // INT 1/(f(x)-a)
						{
							if(y.Parameters.Scalar1.Equals(var)) // INT 1/(x-a)
							{
								exp = new ScalarNaturalLogarithm(context,y).Simplify();
							}
							if(y.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication)) // INT 1/(f(x)*g(x)-a)
							{
								ScalarMultiplication z = y.Parameters.Scalar1 as ScalarMultiplication;
								VariableManager mz1 = new VariableManager(context);
								VariableManager mz2 = new VariableManager(context);
								z.Parameters.Scalar1.CollectVariables(mz1,false);
								z.Parameters.Scalar2.CollectVariables(mz2,false);
								if(!mz1.IsDefined(var) && mz2.IsDefined(var)) // INT 1/(b*f(x)-a)
								{
									if(z.Parameters.Scalar2.Equals(var)) // INT 1/(b*x-a)
									{
										exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar1).Simplify();
										return true;
									}
								}
								if(mz1.IsDefined(var) && !mz2.IsDefined(var)) // INT 1/(f(x)*b-a)
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT 1/(x*b-a)
									{
										exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,y),z.Parameters.Scalar2).Simplify();
										return true;
									}
								}
							}
							if(y.Parameters.Scalar1.GetType() == typeof(ScalarDivision)) // INT 1/(f(x)/g(x)-a)
							{
								ScalarDivision z = y.Parameters.Scalar1 as ScalarDivision;
								if(!VariableManager.IsDefined(var,z.Parameters.Scalar2,false))
								{
									if(z.Parameters.Scalar1.Equals(var)) //INT 1/(x/b-a)
									{
										exp = new ScalarMultiplication(context,z.Parameters.Scalar2,new ScalarNaturalLogarithm(context,new ScalarSubtraction(context,new ScalarMultiplication(context,y.Parameters.Scalar2,z.Parameters.Scalar2),z.Parameters.Scalar1))).Simplify();
										return true;
									}
								}
							}
						}
					}
					if(x.Parameters.Scalar2.GetType().Equals(typeof(ScalarMultiplication))) // INT 1/(f(x)*g(x))
					{
						ScalarMultiplication y = x.Parameters.Scalar2 as ScalarMultiplication;
						VariableManager my1 = new VariableManager(context);
						VariableManager my2 = new VariableManager(context);
						y.Parameters.Scalar1.CollectVariables(my1,false);
						y.Parameters.Scalar2.CollectVariables(my2,false);
						if(my1.IsDefined(var) && my2.IsDefined(var)) // INT 1/(f(x)*g(x))
						{
						}
						if(!my1.IsDefined(var) && my2.IsDefined(var)) // INT 1/(a*f(x))
						{
							if(y.Parameters.Scalar2.Equals(var)) // INT 1/(a*x)
							{
								exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,var),y.Parameters.Scalar1).Simplify();
								return true;
							}
						}
						if(my1.IsDefined(var) && !my2.IsDefined(var)) // INT 1/(f(x)*a)
						{
							if(y.Parameters.Scalar1.Equals(var)) // INT 1/(x*a)
							{
								exp = new ScalarDivision(context,new ScalarNaturalLogarithm(context,var),y.Parameters.Scalar2).Simplify();
								return true;
							}
						}
					}
				}
				else
				{
					IScalarExpression nd = new ScalarDivision(context,ScalarExpressionValue.One(context),x.Parameters.Scalar2);
					nd = new ScalarIntegrate(context,nd,it.Parameters.Scalar2,it.Parameters.Scalar3);
					bool changed = this.ConvertTo(ref nd);
					exp = new ScalarMultiplication(context,x.Parameters.Scalar1,nd);
					return changed;
				}
			}
			if(m1.IsDefined(var) && m2.IsDefined(var))
			{
				if(x.Parameters.Scalar1.Equals(var)) // INT x/f(x)
				{
					if(x.Parameters.Scalar2.GetType() == typeof(ScalarAddition)) // INT x/(f(x)+g(x))
					{
						ScalarAddition y = x.Parameters.Scalar2 as ScalarAddition;
						VariableManager my1 = new VariableManager(context);
						VariableManager my2 = new VariableManager(context);
						y.Parameters.Scalar1.CollectVariables(my1,false);
						y.Parameters.Scalar2.CollectVariables(my2,false);
						if(my1.IsDefined(var) && my2.IsDefined(var)) // INT x/(f(x)+g(x))
						{
						}
						if(!my1.IsDefined(var) && my2.IsDefined(var)) // INT x/(a+g(x)))
						{
							if(y.Parameters.Scalar2.Equals(var)) // INT x/(a+x)
							{
								exp = new ScalarSubtraction(context,var,new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarNaturalLogarithm(context,y))).Simplify();
								return true;
							}
							if(y.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication)) // INT x/(a+f(x)*g(x))
							{
								ScalarMultiplication z = y.Parameters.Scalar2 as ScalarMultiplication;
								VariableManager mz1 = new VariableManager(context);
								VariableManager mz2 = new VariableManager(context);
								z.Parameters.Scalar1.CollectVariables(mz1,false);
								z.Parameters.Scalar2.CollectVariables(mz2,false);
								if(!mz1.IsDefined(var) && mz2.IsDefined(var)) // INT x/(a+b*f(x))
								{
									if(z.Parameters.Scalar2.Equals(var)) // INT x/(a+b*x)
									{
										exp = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,z.Parameters.Scalar1,var),new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarNaturalLogarithm(context,y))),new ScalarSquare(context,z.Parameters.Scalar1)).Simplify();
										return true;
									}
								}
								if(mz1.IsDefined(var) && !mz2.IsDefined(var)) // INT x/(a+f(x)*b)
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT x/(a+x*b)
									{
										exp = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,z.Parameters.Scalar2,var),new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarNaturalLogarithm(context,y))),new ScalarSquare(context,z.Parameters.Scalar2)).Simplify();
										return true;
									}
								}
							}
							if(y.Parameters.Scalar2.GetType() == typeof(ScalarDivision)) // INT x/(a+f(x)/g(x))
							{
								ScalarDivision z = y.Parameters.Scalar2 as ScalarDivision;
								if(!VariableManager.IsDefined(var,z.Parameters.Scalar2,false))
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT x/(a+x/b)
									{
										exp = new ScalarSubtraction(context,new ScalarMultiplication(context,z.Parameters.Scalar2,var),new ScalarMultiplication(context,new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarSquare(context,z.Parameters.Scalar2)),new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarMultiplication(context,y.Parameters.Scalar1,z.Parameters.Scalar2),var)))).Simplify();
										return true;
									}
								}
							}
						}
						if(my1.IsDefined(var) && !my2.IsDefined(var)) // INT x/(f(x)+a)
						{
							if(y.Parameters.Scalar1.Equals(var)) // INT x/(x+a)
							{
								exp = new ScalarSubtraction(context,var,new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarNaturalLogarithm(context,y))).Simplify();
							}
							if(y.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication)) // INT x/(f(x)*g(x)+a)
							{
								ScalarMultiplication z = y.Parameters.Scalar1 as ScalarMultiplication;
								VariableManager mz1 = new VariableManager(context);
								VariableManager mz2 = new VariableManager(context);
								z.Parameters.Scalar1.CollectVariables(mz1,false);
								z.Parameters.Scalar2.CollectVariables(mz2,false);
								if(!mz1.IsDefined(var) && mz2.IsDefined(var)) // INT x/(b*f(x)+a)
								{
									if(z.Parameters.Scalar2.Equals(var)) // INT x/(b*x+a)
									{
										exp = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,z.Parameters.Scalar1,var),new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarNaturalLogarithm(context,y))),new ScalarSquare(context,z.Parameters.Scalar1)).Simplify();
										return true;
									}
								}
								if(mz1.IsDefined(var) && !mz2.IsDefined(var)) // INT x/(f(x)*b+a)
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT x/(x*b+a)
									{
										exp = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,z.Parameters.Scalar2,var),new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarNaturalLogarithm(context,y))),new ScalarSquare(context,z.Parameters.Scalar2)).Simplify();
										return true;
									}
								}
							}
							if(y.Parameters.Scalar1.GetType() == typeof(ScalarDivision)) // INT x/(f(x)/g(x)+a)
							{
								ScalarDivision z = y.Parameters.Scalar1 as ScalarDivision;
								if(!VariableManager.IsDefined(var,z.Parameters.Scalar2,false))
								{
									if(z.Parameters.Scalar1.Equals(var)) // INT x/(x/b+a)
									{
										exp = new ScalarSubtraction(context,new ScalarMultiplication(context,z.Parameters.Scalar2,var),new ScalarMultiplication(context,new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarSquare(context,z.Parameters.Scalar2)),new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarMultiplication(context,y.Parameters.Scalar2,z.Parameters.Scalar2),var)))).Simplify();
										return true;
									}
								}
							}
						}
					}
				}
				if(x.Parameters.Scalar1.GetType().Equals(typeof(ScalarAddition))) // INT (f(x)+g(x))/h(x)
				{
					ScalarAddition y = x.Parameters.Scalar1 as ScalarAddition;
					IScalarExpression int1 = new ScalarIntegrate(context,new ScalarDivision(context,y.Parameters.Scalar1,x.Parameters.Scalar2),it.Parameters.Scalar2,it.Parameters.Scalar3);
					IScalarExpression int2 = new ScalarIntegrate(context,new ScalarDivision(context,y.Parameters.Scalar2,x.Parameters.Scalar2),it.Parameters.Scalar2,it.Parameters.Scalar3);
					this.ConvertTo(ref int1);
					this.ConvertTo(ref int2);
					exp = new ScalarAddition(context,int1,int2);
					return true;
				}
				if(x.Parameters.Scalar1.GetType().Equals(typeof(ScalarSubtraction))) // INT (f(x)-g(x))/h(x)
				{
					ScalarSubtraction y = x.Parameters.Scalar1 as ScalarSubtraction;
					IScalarExpression int1 = new ScalarIntegrate(context,new ScalarDivision(context,y.Parameters.Scalar1,x.Parameters.Scalar2),it.Parameters.Scalar2,it.Parameters.Scalar3);
					IScalarExpression int2 = new ScalarIntegrate(context,new ScalarDivision(context,y.Parameters.Scalar2,x.Parameters.Scalar2),it.Parameters.Scalar2,it.Parameters.Scalar3);
					this.ConvertTo(ref int1);
					this.ConvertTo(ref int2);
					exp = new ScalarSubtraction(context,int1,int2);
					return true;
				}
				if(x.Parameters.Scalar1.GetType().Equals(typeof(ScalarMultiplication)))
				{
					ScalarMultiplication y = x.Parameters.Scalar1 as ScalarMultiplication;
					VariableManager my1 = new VariableManager(context);
					VariableManager my2 = new VariableManager(context);
					y.Parameters.Scalar1.CollectVariables(my1,false);
					y.Parameters.Scalar2.CollectVariables(my2,false);
					if(my1.IsDefined(var) && my2.IsDefined(var)) // INT (f(x)*g(x))/h(x)
					{
					}
					if(!my1.IsDefined(var) && my2.IsDefined(var)) // INT (a*f(x))/h(x)
					{
						IScalarExpression int1 = new ScalarIntegrate(context,new ScalarDivision(context,y.Parameters.Scalar2,x.Parameters.Scalar2),it.Parameters.Scalar2,it.Parameters.Scalar3);
						this.ConvertTo(ref int1);
						exp = new ScalarMultiplication(context,y.Parameters.Scalar1,int1);
						return true;
					}
					if(my1.IsDefined(var) && !my2.IsDefined(var)) // INT (f(x)*a)/h(x)
					{
						IScalarExpression int1 = new ScalarIntegrate(context,new ScalarDivision(context,y.Parameters.Scalar1,x.Parameters.Scalar2),it.Parameters.Scalar2,it.Parameters.Scalar3);
						this.ConvertTo(ref int1);
						exp = new ScalarMultiplication(context,y.Parameters.Scalar2,int1);
						return true;
					}
				}
			}
			return(false);
		}
	}
}
