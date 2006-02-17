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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Digital
{
	//new stuff

	#region Bit Parameters
	public class Bit1Parameters: Parameters
	{
		private IBitExpression bit1;
		public Bit1Parameters() : base(1) {}
		public Bit1Parameters(IBitExpression b1) : base(1)
		{
			bit1 = b1;
		}
		public IBitExpression Bit1
		{
			get {return bit1;}
			set {bit1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BitConversionMap.Convert(ref bit1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bit1Parameters(bit1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bit1Parameters(bit1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bit1Parameters(bit1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bit1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Bit2Parameters: Parameters
	{
		private IBitExpression bit1, bit2;
		public Bit2Parameters() : base(2) {}
		public Bit2Parameters(IBitExpression b1, IBitExpression b2) : base(2)
		{
			bit1 = b1;
			bit2 = b2;
		}
		public IBitExpression Bit1
		{
			get {return bit1;}
			set {bit1 = value;}
		}
		public IBitExpression Bit2
		{
			get {return bit2;}
			set {bit2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BitConversionMap.Convert(ref bit1, conversionType);
			BitConversionMap.Convert(ref bit2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bit2Parameters(bit1.Simplify(),bit2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bit2Parameters(bit1.Expand(),bit2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bit2Parameters(bit1.Substitute(original,replacement),bit2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bit1;
					case 1:
						return bit2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Bus Parameters
	public class Bus1Parameters: Parameters
	{
		private IBusExpression bus1;
		public Bus1Parameters() : base(1) {}
		public Bus1Parameters(IBusExpression u1) : base(1)
		{
			bus1 = u1;
		}
		public IBusExpression Bus1
		{
			get {return bus1;}
			set {bus1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BusConversionMap.Convert(ref bus1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bus1Parameters(bus1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bus1Parameters(bus1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bus1Parameters(bus1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bus1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Bus2Parameters: Parameters
	{
		private IBusExpression bus1, bus2;
		public Bus2Parameters() : base(2) {}
		public Bus2Parameters(IBusExpression u1, IBusExpression u2) : base(2)
		{
			bus1 = u1;
			bus2 = u2;
		}
		public IBusExpression Bus1
		{
			get {return bus1;}
			set {bus1 = value;}
		}
		public IBusExpression Bus2
		{
			get {return bus2;}
			set {bus2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BusConversionMap.Convert(ref bus1, conversionType);
			BusConversionMap.Convert(ref bus2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bus2Parameters(bus1.Simplify(),bus2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bus2Parameters(bus1.Expand(),bus2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bus2Parameters(bus1.Substitute(original,replacement),bus2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bus1;
					case 1:
						return bus2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Bus3Parameters: Parameters
	{
		private IBusExpression bus1, bus2, bus3;
		public Bus3Parameters() : base(3) {}
		public Bus3Parameters(IBusExpression u1, IBusExpression u2, IBusExpression u3) : base(3)
		{
			bus1 = u1;
			bus2 = u2;
			bus3 = u3;
		}
		public IBusExpression Bus1
		{
			get {return bus1;}
			set {bus1 = value;}
		}
		public IBusExpression Bus2
		{
			get {return bus2;}
			set {bus2 = value;}
		}
		public IBusExpression Bus3
		{
			get {return bus3;}
			set {bus3 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BusConversionMap.Convert(ref bus1, conversionType);
			BusConversionMap.Convert(ref bus2, conversionType);
			BusConversionMap.Convert(ref bus3, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bus3Parameters(bus1.Simplify(),bus2.Simplify(),bus3.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bus3Parameters(bus1.Expand(),bus2.Expand(),bus3.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bus3Parameters(bus1.Substitute(original,replacement),bus2.Substitute(original,replacement),
				bus3.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bus1;
					case 1:
						return bus2;
					case 2:
						return bus3;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Bit Bus Parameters
	public class Bit1Bus1Parameters: Parameters
	{
		private IBitExpression bit1;
		private IBusExpression bus1;
		public Bit1Bus1Parameters() : base(2) {}
		public Bit1Bus1Parameters(IBitExpression b1, IBusExpression u1) : base(2)
		{
			bit1 = b1;
			bus1 = u1;
		}
		public IBitExpression Bit1
		{
			get {return bit1;}
			set {bit1 = value;}
		}
		public IBusExpression Bus1
		{
			get {return bus1;}
			set {bus1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BitConversionMap.Convert(ref bit1, conversionType);
			BusConversionMap.Convert(ref bus1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bit1Bus1Parameters(bit1.Simplify(),bus1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bit1Bus1Parameters(bit1.Expand(),bus1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bit1Bus1Parameters(bit1.Substitute(original,replacement),bus1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bit1;
					case 1:
						return bus1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Bit1Bus2Parameters: Parameters
	{
		private IBitExpression bit1;
		private IBusExpression bus1, bus2;
		public Bit1Bus2Parameters() : base(3) {}
		public Bit1Bus2Parameters(IBitExpression b1, IBusExpression u1, IBusExpression u2) : base(3)
		{
			bit1 = b1;
			bus1 = u1;
			bus2 = u2;
		}
		public IBitExpression Bit1
		{
			get {return bit1;}
			set {bit1 = value;}
		}
		public IBusExpression Bus1
		{
			get {return bus1;}
			set {bus1 = value;}
		}
		public IBusExpression Bus2
		{
			get {return bus2;}
			set {bus2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			BitConversionMap.Convert(ref bit1, conversionType);
			BusConversionMap.Convert(ref bus1, conversionType);
			BusConversionMap.Convert(ref bus2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Bit1Bus2Parameters(bit1.Simplify(),bus1.Simplify(),bus2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Bit1Bus2Parameters(bit1.Expand(),bus1.Expand(),bus2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Bit1Bus2Parameters(bit1.Substitute(original,replacement),bus1.Substitute(original,replacement),
				bus2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return bit1;
					case 1:
						return bus1;
					case 2:
						return bus2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar Bit Bus Parameters
	public class Scalar1Bit1Bus1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IBitExpression bit1;
		private IBusExpression bus1;
		public Scalar1Bit1Bus1Parameters() : base(2) {}
		public Scalar1Bit1Bus1Parameters(IScalarExpression s1, IBitExpression b1, IBusExpression u1) : base(2)
		{
			scalar1 = s1;
			bit1 = b1;
			bus1 = u1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IBitExpression Bit1
		{
			get {return bit1;}
			set {bit1 = value;}
		}
		public IBusExpression Bus1
		{
			get {return bus1;}
			set {bus1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			BitConversionMap.Convert(ref bit1, conversionType);
			BusConversionMap.Convert(ref bus1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Bit1Bus1Parameters(scalar1.Simplify(),bit1.Simplify(),bus1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Bit1Bus1Parameters(scalar1.Expand(),bit1.Expand(),bus1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Bit1Bus1Parameters(scalar1.Substitute(original,replacement),
				bit1.Substitute(original,replacement),bus1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return scalar1;
					case 1:
						return bit1;
					case 2:
						return bus1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Digital Operators
	/// <summary>
	/// BitOperator is a base operator for operators
	/// returning an <see cref="IBitExpression"/>.
	/// </summary>
	/// <remarks>
	/// <b>Deriving from this operator base</b><br/>
	/// Please note that it's important to overload at least either
	/// Expand() or all the following: Calculate()
	/// to avoid infinite loops!
	/// </remarks>
	public abstract class BitOperator: MathExpression, IBitExpression
	{
		public BitOperator(Context context): base(context) {}
		public virtual bool Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual IBitExpression Expand()
		{
			return (IBitExpression) InnerExpand();
		}
		public IBitExpression SafeExpand()
		{
			return (IBitExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IBitExpression Simplify()
		{
			return (IBitExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IBitExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IBitExpression) InnerSubstitute(original,replacement);
		}
		#endregion
	}
	/// <summary>
	/// BusOperator is a base operator for operators
	/// returning an <see cref="IBusExpression"/>.
	/// </summary>
	/// <remarks>
	/// <b>Deriving from this operator base</b><br/>
	/// Please note that it's important to overload at least either
	/// Expand() or all the following: Calculate()
	/// to avoid infinite loops!
	/// </remarks>
	public abstract class BusOperator: MathExpression, IBusExpression
	{
		public BusOperator(Context context): base(context) {}
		public virtual BitArray Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract DigitalBus Expand();
		public IBusExpression SafeExpand()
		{
			return (IBusExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IBusExpression Simplify()
		{
			return (IBusExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IBusExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IBusExpression) InnerSubstitute(original,replacement);
		}
		#endregion
	}
	#endregion

	//old stuff

	#region Operator Base (deactive)
	/*
	public abstract class BiBitOperator
	{
		protected IBitExpression first, last;
		private int priority;
		protected BiBitOperator(IBitExpression first, IBitExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IBitExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IBitExpression AfterExpression
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
			BitConversionMap.Convert(ref first,conversionType);
			BitConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiBitOperator x = exp as BiBitOperator;
				//override this method if not true!!
				if(x.first.Equals(this.first) && x.last.Equals(this.last) || x.first.Equals(this.last) && x.last.Equals(this.first))
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
	public abstract class SingleBitOperator
	{
		protected IBitExpression sub;
		private int priority;
		protected SingleBitOperator(IBitExpression sub)
		{
			this.sub = sub;
		}
		public IBitExpression SubExpression
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
			BitConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleBitOperator x = exp as SingleBitOperator;
				//override this method if not true!!
				if(x.sub.Equals(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class BiBusOperator
	{
		protected IBusExpression first, last;
		private int priority;
		protected BiBusOperator(IBusExpression first, IBusExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IBusExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IBusExpression AfterExpression
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
			BusConversionMap.Convert(ref first,conversionType);
			BusConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiBusOperator x = exp as BiBusOperator;
				//override this method if not true!!
				if(x.first.Equals(this.first) && x.last.Equals(this.last) || x.first.Equals(this.last) && x.last.Equals(this.first))
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
	public abstract class TriBusOperator
	{
		protected IBusExpression first, middle, last;
		private int priority;
		protected TriBusOperator(IBusExpression first, IBusExpression middle, IBusExpression last)
		{
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public IBusExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IBusExpression MiddleExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public IBusExpression AfterExpression
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
			get {return(first.IsConstant && middle.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			BusConversionMap.Convert(ref first,conversionType);
			BusConversionMap.Convert(ref middle,conversionType);
			BusConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriBusOperator x = exp as TriBusOperator;
				if(x.first.Equals(this.first) && x.last.Equals(this.last) && x.middle.Equals(this.middle))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			middle.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class SingleBusOperator
	{
		protected IBusExpression sub;
		private int priority;
		protected SingleBusOperator(IBusExpression sub)
		{
			this.sub = sub;
		}
		public IBusExpression SubExpression
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
			BusConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleBusOperator x = exp as SingleBusOperator;
				//override this method if not true!!
				if(x.sub.Equals(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class EmptyOperator
	{
		private int priority;
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
				return(true);
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
		}
	}
	*/
	#endregion
	#region Typed Operator Base (deactive)
	/*
	public abstract class BiBusToBusOperator: BiBusOperator
	{
		public BiBusToBusOperator(IBusExpression first, IBusExpression last): base(first, last) {}
		public abstract DigitalBus ExpressionBus
		{
			get;
		}
		public BitArray Calculate()
		{
			return ExpressionBus.Calculate();
		}
		public IBusExpression Simplify()
		{
			return ExpressionBus.Simplify();
		}
	}
	public abstract class TriBusToBusOperator: TriBusOperator
	{
		public TriBusToBusOperator(IBusExpression first, IBusExpression middle, IBusExpression last): base(first, middle, last) {}
		public abstract DigitalBus ExpressionBus
		{
			get;
		}
		public BitArray Calculate()
		{
			return ExpressionBus.Calculate();
		}
		public IBusExpression Simplify()
		{
			return ExpressionBus.Simplify();
		}
	}
	public abstract class SingleBusToBusOperator: SingleBusOperator
	{
		public SingleBusToBusOperator(IBusExpression sub): base(sub) {}
		public abstract DigitalBus ExpressionBus
		{
			get;
		}
		public BitArray Calculate()
		{
			return ExpressionBus.Calculate();
		}
		public IBusExpression Simplify()
		{
			return ExpressionBus.Simplify();
		}
	}
	*/
	#endregion
}
