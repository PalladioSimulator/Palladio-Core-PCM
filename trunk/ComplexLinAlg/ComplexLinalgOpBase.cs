using System;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Complex;

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	#region ComplexVector Parameters
	public class ComplexVector1Parameters: Parameters
	{
		private IComplexVectorExpression complexvector1;
		public ComplexVector1Parameters() : base(1) {}
		public ComplexVector1Parameters(IComplexVectorExpression v1) : base(1)
		{
			complexvector1 = v1;
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new ComplexVector1Parameters(complexvector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new ComplexVector1Parameters(complexvector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new ComplexVector1Parameters(complexvector1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complexvector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class ComplexVector2Parameters: Parameters
	{
		private IComplexVectorExpression complexvector1, complexvector2;
		public ComplexVector2Parameters() : base(2) {}
		public ComplexVector2Parameters(IComplexVectorExpression t1, IComplexVectorExpression t2) : base(2)
		{
			complexvector1 = t1;
			complexvector2 = t2;
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public IComplexVectorExpression ComplexVector2
		{
			get {return complexvector2;}
			set {complexvector2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
			ComplexVectorConversionMap.Convert(ref complexvector2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new ComplexVector2Parameters(complexvector1.Simplify(),complexvector2.Simplify());
		}
		public override Parameters Expand()
		{
			return new ComplexVector2Parameters(complexvector1.Expand(),complexvector2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new ComplexVector2Parameters(complexvector1.Substitute(original,replacement),complexvector2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complexvector1;
					case 1:
						return complexvector2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region ComplexMatrix Parameters
	public class ComplexMatrix1Parameters: Parameters
	{
		private IComplexMatrixExpression complexmatrix1;
		public ComplexMatrix1Parameters() : base(1) {}
		public ComplexMatrix1Parameters(IComplexMatrixExpression m1) : base(1)
		{
			complexmatrix1 = m1;
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new ComplexMatrix1Parameters(complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new ComplexMatrix1Parameters(complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new ComplexMatrix1Parameters(complexmatrix1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class ComplexMatrix2Parameters: Parameters
	{
		private IComplexMatrixExpression complexmatrix1, complexmatrix2;
		public ComplexMatrix2Parameters() : base(2) {}
		public ComplexMatrix2Parameters(IComplexMatrixExpression t1, IComplexMatrixExpression t2) : base(2)
		{
			complexmatrix1 = t1;
			complexmatrix2 = t2;
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix2
		{
			get {return complexmatrix2;}
			set {complexmatrix2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new ComplexMatrix2Parameters(complexmatrix1.Simplify(),complexmatrix2.Simplify());
		}
		public override Parameters Expand()
		{
			return new ComplexMatrix2Parameters(complexmatrix1.Expand(),complexmatrix2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new ComplexMatrix2Parameters(complexmatrix1.Substitute(original,replacement),complexmatrix2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complexmatrix1;
					case 1:
						return complexmatrix2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region ComplexVector ComplexMatrix Parameters
	public class ComplexVector1ComplexMatrix1Parameters: Parameters
	{
		private IComplexVectorExpression complexvector1;
		private IComplexMatrixExpression complexmatrix1;
		public ComplexVector1ComplexMatrix1Parameters() : base(2) {}
		public ComplexVector1ComplexMatrix1Parameters(IComplexVectorExpression v1, IComplexMatrixExpression m1) : base(2)
		{
			complexvector1 = v1;
			complexmatrix1 = m1;
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new ComplexVector1ComplexMatrix1Parameters(complexvector1.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new ComplexVector1ComplexMatrix1Parameters(complexvector1.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new ComplexVector1ComplexMatrix1Parameters(complexvector1.Substitute(original,replacement),complexmatrix1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complexvector1;
					case 1:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar ComplexVector ComplexMatrix Parameters
	public class Scalar1ComplexVector1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexVectorExpression complexvector1;
		public Scalar1ComplexVector1Parameters() : base(2) {}
		public Scalar1ComplexVector1Parameters(IScalarExpression s1, IComplexVectorExpression v1) : base(2)
		{
			scalar1 = s1;
			complexvector1 = v1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1ComplexVector1Parameters(scalar1.Simplify(),complexvector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1ComplexVector1Parameters(scalar1.Expand(),complexvector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1ComplexVector1Parameters(scalar1.Substitute(original,replacement),complexvector1.Substitute(original,replacement));
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
						return complexvector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1ComplexMatrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexMatrixExpression complexmatrix1;
		public Scalar1ComplexMatrix1Parameters() : base(2) {}
		public Scalar1ComplexMatrix1Parameters(IScalarExpression s1, IComplexMatrixExpression m1) : base(2)
		{
			scalar1 = s1;
			complexmatrix1 = m1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1ComplexMatrix1Parameters(scalar1.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1ComplexMatrix1Parameters(scalar1.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1ComplexMatrix1Parameters(scalar1.Substitute(original,replacement),complexmatrix1.Substitute(original,replacement));
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
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1ComplexMatrix2Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexMatrixExpression complexmatrix1;
		private IComplexMatrixExpression complexmatrix2;
		public Scalar1ComplexMatrix2Parameters() : base(3) {}
		public Scalar1ComplexMatrix2Parameters(IScalarExpression s1, IComplexMatrixExpression m1, IComplexMatrixExpression m2) : base(3)
		{
			scalar1 = s1;
			complexmatrix1 = m1;
			complexmatrix2 = m2;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix2
		{
			get {return complexmatrix2;}
			set {complexmatrix2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1ComplexMatrix2Parameters(scalar1.Simplify(),complexmatrix1.Simplify(),complexmatrix2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1ComplexMatrix2Parameters(scalar1.Expand(),complexmatrix1.Expand(),complexmatrix2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1ComplexMatrix2Parameters(scalar1.Substitute(original,replacement),complexmatrix1.Substitute(original,replacement),
				complexmatrix2.Substitute(original,replacement));
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
						return complexmatrix1;
					case 2:
						return complexmatrix2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2ComplexMatrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IScalarExpression scalar2;
		private IComplexMatrixExpression complexmatrix1;
		public Scalar2ComplexMatrix1Parameters() : base(3) {}
		public Scalar2ComplexMatrix1Parameters(IScalarExpression s1, IScalarExpression s2, IComplexMatrixExpression m1) : base(3)
		{
			scalar1 = s1;
			scalar2 = s2;
			complexmatrix1 = m1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2ComplexMatrix1Parameters(scalar1.Simplify(),scalar2.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2ComplexMatrix1Parameters(scalar1.Expand(),scalar2.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2ComplexMatrix1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				complexmatrix1.Substitute(original,replacement));
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
						return scalar2;
					case 2:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar4ComplexMatrix1Parameters: Parameters
	{
		private IScalarExpression scalar1, scalar2, scalar3, scalar4;
		private IComplexMatrixExpression complexmatrix1;
		public Scalar4ComplexMatrix1Parameters() : base(5) {}
		public Scalar4ComplexMatrix1Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3, IScalarExpression s4, IComplexMatrixExpression m1) : base(5)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
			scalar4 = s4;
			complexmatrix1 = m1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public IScalarExpression Scalar3
		{
			get {return scalar3;}
			set {scalar3 = value;}
		}
		public IScalarExpression Scalar4
		{
			get {return scalar4;}
			set {scalar4 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
			ScalarConversionMap.Convert(ref scalar4, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar4ComplexMatrix1Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify(),scalar4.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar4ComplexMatrix1Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand(),scalar4.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar4ComplexMatrix1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement),scalar4.Substitute(original,replacement),complexmatrix1.Substitute(original,replacement));
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
						return scalar2;
					case 3:
						return scalar3;
					case 4:
						return scalar4;
					case 5:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2ComplexMatrix2Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IScalarExpression scalar2;
		private IComplexMatrixExpression complexmatrix1;
		private IComplexMatrixExpression complexmatrix2;
		public Scalar2ComplexMatrix2Parameters() : base(4) {}
		public Scalar2ComplexMatrix2Parameters(IScalarExpression s1, IScalarExpression s2, IComplexMatrixExpression m1, IComplexMatrixExpression m2) : base(4)
		{
			scalar1 = s1;
			scalar2 = s2;
			complexmatrix1 = m1;
			complexmatrix2 = m2;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix2
		{
			get {return complexmatrix2;}
			set {complexmatrix2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2ComplexMatrix2Parameters(scalar1.Simplify(),scalar2.Simplify(),complexmatrix1.Simplify(),complexmatrix2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2ComplexMatrix2Parameters(scalar1.Expand(),scalar2.Expand(),complexmatrix1.Expand(),complexmatrix2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2ComplexMatrix2Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				complexmatrix1.Substitute(original,replacement),complexmatrix2.Substitute(original,replacement));
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
						return scalar2;
					case 2:
						return complexmatrix1;
					case 3:
						return complexmatrix2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Complex ComplexVector ComplexMatrix Parameters
	public class Complex1ComplexVector1Parameters: Parameters
	{
		private IComplexExpression complex1;
		private IComplexVectorExpression complexvector1;
		public Complex1ComplexVector1Parameters() : base(2) {}
		public Complex1ComplexVector1Parameters(IComplexExpression c1, IComplexVectorExpression v1) : base(2)
		{
			complex1 = c1;
			complexvector1 = v1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex1ComplexVector1Parameters(complex1.Simplify(),complexvector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex1ComplexVector1Parameters(complex1.Expand(),complexvector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex1ComplexVector1Parameters(complex1.Substitute(original,replacement),complexvector1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complexvector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex2ComplexVector1Parameters: Parameters
	{
		private IComplexExpression complex1,complex2;
		private IComplexVectorExpression complexvector1;
		public Complex2ComplexVector1Parameters() : base(3) {}
		public Complex2ComplexVector1Parameters(IComplexExpression c1, IComplexExpression c2, IComplexVectorExpression v1) : base(3)
		{
			complex1 = c1;
			complex2 = c2;
			complexvector1 = v1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexExpression Complex2
		{
			get {return complex2;}
			set {complex2 = value;}
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexConversionMap.Convert(ref complex2, conversionType);
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex2ComplexVector1Parameters(complex1.Simplify(),complex2.Simplify(),complexvector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex2ComplexVector1Parameters(complex1.Expand(),complex2.Expand(),complexvector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex2ComplexVector1Parameters(complex1.Substitute(original,replacement),complex2.Substitute(original,replacement),
				complexvector1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complex2;
					case 2:
						return complexvector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex3ComplexVector1Parameters: Parameters
	{
		private IComplexExpression complex1,complex2,complex3;
		private IComplexVectorExpression complexvector1;
		public Complex3ComplexVector1Parameters() : base(4) {}
		public Complex3ComplexVector1Parameters(IComplexExpression c1, IComplexExpression c2, IComplexExpression c3, IComplexVectorExpression v1) : base(4)
		{
			complex1 = c1;
			complex2 = c2;
			complex3 = c3;
			complexvector1 = v1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexExpression Complex2
		{
			get {return complex2;}
			set {complex2 = value;}
		}
		public IComplexExpression Complex3
		{
			get {return complex3;}
			set {complex3 = value;}
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexConversionMap.Convert(ref complex2, conversionType);
			ComplexConversionMap.Convert(ref complex3, conversionType);
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex3ComplexVector1Parameters(complex1.Simplify(),complex2.Simplify(),complex3.Expand(),complexvector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex3ComplexVector1Parameters(complex1.Expand(),complex2.Expand(),complex3.Expand(),complexvector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex3ComplexVector1Parameters(complex1.Substitute(original,replacement),complex2.Substitute(original,replacement),
				complex3.Substitute(original,replacement),complexvector1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complex2;
					case 2:
						return complex3;
					case 3:
						return complexvector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex1ComplexMatrix1Parameters: Parameters
	{
		private IComplexExpression complex1;
		private IComplexMatrixExpression complexmatrix1;
		public Complex1ComplexMatrix1Parameters() : base(2) {}
		public Complex1ComplexMatrix1Parameters(IComplexExpression c1, IComplexMatrixExpression m1) : base(2)
		{
			complex1 = c1;
			complexmatrix1 = m1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex1ComplexMatrix1Parameters(complex1.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex1ComplexMatrix1Parameters(complex1.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex1ComplexMatrix1Parameters(complex1.Substitute(original,replacement),complexmatrix1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex2ComplexMatrix1Parameters: Parameters
	{
		private IComplexExpression complex1, complex2;
		private IComplexMatrixExpression complexmatrix1;
		public Complex2ComplexMatrix1Parameters() : base(3) {}
		public Complex2ComplexMatrix1Parameters(IComplexExpression c1, IComplexExpression c2, IComplexMatrixExpression m1) : base(3)
		{
			complex1 = c1;
			complex2 = c2;
			complexmatrix1 = m1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexExpression Complex2
		{
			get {return complex2;}
			set {complex2 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexConversionMap.Convert(ref complex2, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex2ComplexMatrix1Parameters(complex1.Simplify(),complex2.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex2ComplexMatrix1Parameters(complex1.Expand(),complex2.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex2ComplexMatrix1Parameters(complex1.Substitute(original,replacement),complex2.Substitute(original,replacement),
				complexmatrix1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complex2;
					case 2:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar Complex ComplexVector ComplexMatrix Parameters
	public class Scalar1Complex1ComplexVector1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexExpression complex1;
		private IComplexVectorExpression complexvector1;
		public Scalar1Complex1ComplexVector1Parameters() : base(3) {}
		public Scalar1Complex1ComplexVector1Parameters(IScalarExpression s1, IComplexExpression c1, IComplexVectorExpression v1) : base(3)
		{
			scalar1 = s1;
			complex1 = c1;
			complexvector1 = v1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexVectorExpression ComplexVector1
		{
			get {return complexvector1;}
			set {complexvector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexVectorConversionMap.Convert(ref complexvector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Complex1ComplexVector1Parameters(scalar1.Simplify(),complex1.Simplify(),complexvector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Complex1ComplexVector1Parameters(scalar1.Expand(),complex1.Expand(),complexvector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Complex1ComplexVector1Parameters(scalar1.Substitute(original,replacement),complex1.Substitute(original,replacement),
				complexvector1.Substitute(original,replacement));
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
						return complex1;
					case 2:
						return complexvector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1Complex1ComplexMatrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexExpression complex1;
		private IComplexMatrixExpression complexmatrix1;
		public Scalar1Complex1ComplexMatrix1Parameters() : base(3) {}
		public Scalar1Complex1ComplexMatrix1Parameters(IScalarExpression s1, IComplexExpression c1, IComplexMatrixExpression m1) : base(3)
		{
			scalar1 = s1;
			complex1 = c1;
			complexmatrix1 = m1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexMatrixExpression ComplexMatrix1
		{
			get {return complexmatrix1;}
			set {complexmatrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexMatrixConversionMap.Convert(ref complexmatrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Complex1ComplexMatrix1Parameters(scalar1.Simplify(),complex1.Simplify(),complexmatrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Complex1ComplexMatrix1Parameters(scalar1.Expand(),complex1.Expand(),complexmatrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Complex1ComplexMatrix1Parameters(scalar1.Substitute(original,replacement),complex1.Substitute(original,replacement),
				complexmatrix1.Substitute(original,replacement));
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
						return complex1;
					case 2:
						return complexmatrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region ComplexVector, ComplexMatrix Operators
	public abstract class ComplexVectorOperator: MathExpression, IComplexVectorExpression
	{
		public ComplexVectorOperator(Context context): base(context) {}
		public virtual ValueComplexVector Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract ComplexVector Expand();
		public IComplexVectorExpression SafeExpand()
		{
			return (IComplexVectorExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IComplexVectorExpression Simplify()
		{
			return (IComplexVectorExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IComplexVectorExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IComplexVectorExpression) InnerSubstitute(original, replacement);
		}
		#endregion

		public abstract int Length {get;}
		public IComplexMatrixExpression ToMatrix()
		{
			return new ComplexMatrix(context,new IComplexVectorExpression[]{this});
		}
	}
	public abstract class ComplexMatrixOperator: MathExpression, IComplexMatrixExpression
	{
		public ComplexMatrixOperator(Context context): base(context) {}
		public virtual ValueComplexMatrix Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract ComplexMatrix Expand();
		public IComplexMatrixExpression SafeExpand()
		{
			return (IComplexMatrixExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IComplexMatrixExpression Simplify()
		{
			return (IComplexMatrixExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IComplexMatrixExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IComplexMatrixExpression) InnerSubstitute(original, replacement);
		}
		#endregion

		public abstract int LengthX {get;}
		public abstract int LengthY {get;}
		public IComplexVectorExpression GetRowVector(int y)
		{
			ComplexMatrix me = Expand();
			IComplexExpression[] ce = new IComplexExpression[LengthX];
			for(int x=0;x<LengthX;x++)
				ce[x] = me[x,y];
			return new ComplexVector(context,ce);
		}
		public IComplexVectorExpression GetColumnVector(int x)
		{
			ComplexMatrix me = Expand();
			IComplexExpression[] ce = new IComplexExpression[LengthY];
			for(int y=0;y<LengthY;y++)
				ce[y] = me[x,y];
			return new ComplexVector(context,ce);
		}
	}
	#endregion
}
