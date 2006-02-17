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
using cdrnet.Lib.MathLib.Complex;

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	#region Vector Parameters
	public class Vector1Parameters: Parameters
	{
		private IVectorExpression vector1;
		public Vector1Parameters() : base(1) {}
		public Vector1Parameters(IVectorExpression v1) : base(1)
		{
			vector1 = v1;
		}
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			VectorConversionMap.Convert(ref vector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Vector1Parameters(vector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Vector1Parameters(Vector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Vector1Parameters(vector1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return vector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Vector2Parameters: Parameters
	{
		private IVectorExpression vector1, vector2;
		public Vector2Parameters() : base(2) {}
		public Vector2Parameters(IVectorExpression v1, IVectorExpression v2) : base(2)
		{
			vector1 = v1;
			vector2 = v2;
		}
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public IVectorExpression Vector2
		{
			get {return vector2;}
			set {vector2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			VectorConversionMap.Convert(ref vector1, conversionType);
			VectorConversionMap.Convert(ref vector2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Vector2Parameters(vector1.Simplify(),vector2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Vector2Parameters(vector1.Expand(),vector2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Vector2Parameters(vector1.Substitute(original,replacement),vector2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return vector1;
					case 1:
						return vector2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Matrix Parameters
	public class Matrix1Parameters: Parameters
	{
		private IMatrixExpression matrix1;
		public Matrix1Parameters() : base(1) {}
		public Matrix1Parameters(IMatrixExpression m1) : base(1)
		{
			matrix1 = m1;
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Matrix1Parameters(matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Matrix1Parameters(matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Matrix1Parameters(matrix1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Matrix2Parameters: Parameters
	{
		private IMatrixExpression matrix1, matrix2;
		public Matrix2Parameters() : base(2) {}
		public Matrix2Parameters(IMatrixExpression t1, IMatrixExpression t2) : base(2)
		{
			matrix1 = t1;
			matrix2 = t2;
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public IMatrixExpression Matrix2
		{
			get {return matrix2;}
			set {matrix2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			MatrixConversionMap.Convert(ref matrix1, conversionType);
			MatrixConversionMap.Convert(ref matrix2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Matrix2Parameters(matrix1.Simplify(),matrix2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Matrix2Parameters(matrix1.Expand(),matrix2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Matrix2Parameters(matrix1.Substitute(original,replacement),matrix2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return matrix1;
					case 1:
						return matrix2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Vector Matrix Parameters
	public class Vector1Matrix1Parameters: Parameters
	{
		private IVectorExpression vector1;
		private IMatrixExpression matrix1;
		public Vector1Matrix1Parameters() : base(2) {}
		public Vector1Matrix1Parameters(IVectorExpression v1, IMatrixExpression m1) : base(2)
		{
			vector1 = v1;
			matrix1 = m1;
		}
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			VectorConversionMap.Convert(ref vector1, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Vector1Matrix1Parameters(vector1.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Vector1Matrix1Parameters(vector1.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Vector1Matrix1Parameters(vector1.Substitute(original,replacement),matrix1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return vector1;
					case 1:
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar Vector Matrix Parameters
	public class Scalar1Vector1Matrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IVectorExpression vector1;
		private IMatrixExpression matrix1;
		public Scalar1Vector1Matrix1Parameters() : base(3) {}
		public Scalar1Vector1Matrix1Parameters(IScalarExpression s1, IVectorExpression v1, IMatrixExpression m1) : base(3)
		{
			scalar1 = s1;
			vector1 = v1;
			matrix1 = m1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Vector1Matrix1Parameters(scalar1.Simplify(),vector1.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Vector1Matrix1Parameters(scalar1.Expand(),vector1.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Vector1Matrix1Parameters(scalar1.Substitute(original,replacement),vector1.Substitute(original,replacement),
				matrix1.Substitute(original,replacement));
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
						return vector1;
					case 2:
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1Vector1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IVectorExpression vector1;
		public Scalar1Vector1Parameters() : base(2) {}
		public Scalar1Vector1Parameters(IScalarExpression s1, IVectorExpression v1) : base(2)
		{
			scalar1 = s1;
			vector1 = v1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Vector1Parameters(scalar1.Simplify(),vector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Vector1Parameters(scalar1.Expand(),vector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Vector1Parameters(scalar1.Substitute(original,replacement),vector1.Substitute(original,replacement));
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
						return vector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2Vector1Parameters: Parameters
	{
		private IScalarExpression scalar1, scalar2;
		private IVectorExpression vector1;
		public Scalar2Vector1Parameters() : base(3) {}
		public Scalar2Vector1Parameters(IScalarExpression s1, IScalarExpression s2, IVectorExpression v1) : base(3)
		{
			scalar1 = s1;
			scalar2 = s2;
			vector1 = v1;
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
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2Vector1Parameters(scalar1.Simplify(),scalar2.Simplify(),vector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2Vector1Parameters(scalar1.Expand(),scalar2.Expand(),vector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2Vector1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				vector1.Substitute(original,replacement));
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
						return vector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2Vector2Parameters: Parameters
	{
		private IScalarExpression scalar1, scalar2;
		private IVectorExpression vector1, vector2;
		public Scalar2Vector2Parameters() : base(4) {}
		public Scalar2Vector2Parameters(IScalarExpression s1, IScalarExpression s2, IVectorExpression v1, IVectorExpression v2) : base(4)
		{
			scalar1 = s1;
			scalar2 = s2;
			vector1 = v1;
			vector2 = v2;
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
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public IVectorExpression Vector2
		{
			get {return vector2;}
			set {vector2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
			VectorConversionMap.Convert(ref vector2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2Vector2Parameters(scalar1.Simplify(),scalar2.Simplify(),vector1.Simplify(),vector2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2Vector2Parameters(scalar1.Expand(),scalar2.Expand(),vector1.Expand(),vector2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2Vector2Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				vector1.Substitute(original,replacement),vector2.Substitute(original,replacement));
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
						return vector1;
					case 3:
						return vector2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar3Vector1Parameters: Parameters
	{
		private IScalarExpression scalar1, scalar2, scalar3;
		private IVectorExpression vector1;
		public Scalar3Vector1Parameters() : base(4) {}
		public Scalar3Vector1Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3, IVectorExpression v1) : base(4)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
			vector1 = v1;
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
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar3Vector1Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify(),vector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar3Vector1Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand(),vector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar3Vector1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement),vector1.Substitute(original,replacement));
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
						return scalar3;
					case 3:
						return vector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1Matrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IMatrixExpression matrix1;
		public Scalar1Matrix1Parameters() : base(2) {}
		public Scalar1Matrix1Parameters(IScalarExpression s1, IMatrixExpression m1) : base(2)
		{
			scalar1 = s1;
			matrix1 = m1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Matrix1Parameters(scalar1.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Matrix1Parameters(scalar1.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Matrix1Parameters(scalar1.Substitute(original,replacement),matrix1.Substitute(original,replacement));
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
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1Matrix2Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IMatrixExpression matrix1;
		private IMatrixExpression matrix2;
		public Scalar1Matrix2Parameters() : base(3) {}
		public Scalar1Matrix2Parameters(IScalarExpression s1, IMatrixExpression m1, IMatrixExpression m2) : base(3)
		{
			scalar1 = s1;
			matrix1 = m1;
			matrix2 = m2;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public IMatrixExpression Matrix2
		{
			get {return matrix2;}
			set {matrix2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
			MatrixConversionMap.Convert(ref matrix2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Matrix2Parameters(scalar1.Simplify(),matrix1.Simplify(),matrix2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Matrix2Parameters(scalar1.Expand(),matrix1.Expand(),matrix2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Matrix2Parameters(scalar1.Substitute(original,replacement),matrix1.Substitute(original,replacement),
				matrix2.Substitute(original,replacement));
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
						return matrix1;
					case 2:
						return matrix2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar3Matrix1Parameters: Parameters
	{
		private IScalarExpression scalar1, scalar2, scalar3;
		private IMatrixExpression matrix1;
		public Scalar3Matrix1Parameters() : base(4) {}
		public Scalar3Matrix1Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3, IMatrixExpression m1) : base(4)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
			matrix1 = m1;
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
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar3Matrix1Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar3Matrix1Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar3Matrix1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement),matrix1.Substitute(original,replacement));
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
						return scalar3;
					case 3:
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2Matrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IScalarExpression scalar2;
		private IMatrixExpression matrix1;
		public Scalar2Matrix1Parameters() : base(3) {}
		public Scalar2Matrix1Parameters(IScalarExpression s1, IScalarExpression s2, IMatrixExpression m1) : base(3)
		{
			scalar1 = s1;
			scalar2 = s2;
			matrix1 = m1;
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
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2Matrix1Parameters(scalar1.Simplify(),scalar2.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2Matrix1Parameters(scalar1.Expand(),scalar2.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2Matrix1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				matrix1.Substitute(original,replacement));
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
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar4Matrix1Parameters: Parameters
	{
		private IScalarExpression scalar1, scalar2, scalar3, scalar4;
		private IMatrixExpression matrix1;
		public Scalar4Matrix1Parameters() : base(5) {}
		public Scalar4Matrix1Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3, IScalarExpression s4, IMatrixExpression m1) : base(5)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
			scalar4 = s4;
			matrix1 = m1;
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
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
			ScalarConversionMap.Convert(ref scalar4, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar4Matrix1Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify(),scalar4.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar4Matrix1Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand(),scalar4.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar4Matrix1Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement),scalar4.Substitute(original,replacement),matrix1.Substitute(original,replacement));
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
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2Matrix2Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IScalarExpression scalar2;
		private IMatrixExpression matrix1;
		private IMatrixExpression matrix2;
		public Scalar2Matrix2Parameters() : base(4) {}
		public Scalar2Matrix2Parameters(IScalarExpression s1, IScalarExpression s2, IMatrixExpression m1, IMatrixExpression m2) : base(4)
		{
			scalar1 = s1;
			scalar2 = s2;
			matrix1 = m1;
			matrix2 = m2;
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
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public IMatrixExpression Matrix2
		{
			get {return matrix2;}
			set {matrix2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
			MatrixConversionMap.Convert(ref matrix2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2Matrix2Parameters(scalar1.Simplify(),scalar2.Simplify(),matrix1.Simplify(),matrix2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2Matrix2Parameters(scalar1.Expand(),scalar2.Expand(),matrix1.Expand(),matrix2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2Matrix2Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				matrix1.Substitute(original,replacement),matrix2.Substitute(original,replacement));
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
						return matrix1;
					case 3:
						return matrix2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Complex Vector Matrix Parameters
	public class Complex1Vector1Parameters: Parameters
	{
		private IComplexExpression complex1;
		private IVectorExpression vector1;
		public Complex1Vector1Parameters() : base(2) {}
		public Complex1Vector1Parameters(IComplexExpression c1, IVectorExpression v1) : base(2)
		{
			complex1 = c1;
			vector1 = v1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex1Vector1Parameters(complex1.Simplify(),vector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex1Vector1Parameters(complex1.Expand(),vector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex1Vector1Parameters(complex1.Substitute(original,replacement),vector1.Substitute(original,replacement));
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
						return vector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex1Matrix1Parameters: Parameters
	{
		private IComplexExpression complex1;
		private IMatrixExpression matrix1;
		public Complex1Matrix1Parameters() : base(2) {}
		public Complex1Matrix1Parameters(IComplexExpression c1, IMatrixExpression m1) : base(2)
		{
			complex1 = c1;
			matrix1 = m1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex1Matrix1Parameters(complex1.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex1Matrix1Parameters(complex1.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex1Matrix1Parameters(complex1.Substitute(original,replacement),matrix1.Substitute(original,replacement));
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
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar Complex Vector Matrix Parameters
	public class Scalar1Complex1Vector1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexExpression complex1;
		private IVectorExpression vector1;
		public Scalar1Complex1Vector1Parameters() : base(3) {}
		public Scalar1Complex1Vector1Parameters(IScalarExpression s1, IComplexExpression c1, IVectorExpression v1) : base(3)
		{
			scalar1 = s1;
			complex1 = c1;
			vector1 = v1;
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
		public IVectorExpression Vector1
		{
			get {return vector1;}
			set {vector1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			VectorConversionMap.Convert(ref vector1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Complex1Vector1Parameters(scalar1.Simplify(),complex1.Simplify(),vector1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Complex1Vector1Parameters(scalar1.Expand(),complex1.Expand(),vector1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Complex1Vector1Parameters(scalar1.Substitute(original,replacement),complex1.Substitute(original,replacement),
				vector1.Substitute(original,replacement));
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
						return vector1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar1Complex1Matrix1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private IComplexExpression complex1;
		private IMatrixExpression matrix1;
		public Scalar1Complex1Matrix1Parameters() : base(3) {}
		public Scalar1Complex1Matrix1Parameters(IScalarExpression s1, IComplexExpression c1, IMatrixExpression m1) : base(3)
		{
			scalar1 = s1;
			complex1 = c1;
			matrix1 = m1;
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
		public IMatrixExpression Matrix1
		{
			get {return matrix1;}
			set {matrix1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			MatrixConversionMap.Convert(ref matrix1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Complex1Matrix1Parameters(scalar1.Simplify(),complex1.Simplify(),matrix1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Complex1Matrix1Parameters(scalar1.Expand(),complex1.Expand(),matrix1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Complex1Matrix1Parameters(scalar1.Substitute(original,replacement),complex1.Substitute(original,replacement),
				matrix1.Substitute(original,replacement));
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
						return matrix1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Vector, Matrix Operators
	public abstract class VectorOperator: MathExpression, IVectorExpression
	{
		public VectorOperator(Context context): base(context) {}
		public virtual ValueVector Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract ScalarVector Expand();
		public IVectorExpression SafeExpand()
		{
			return (IVectorExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IVectorExpression Simplify()
		{
			return (IVectorExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IVectorExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IVectorExpression) InnerSubstitute(original,replacement);
		}
		#endregion

		public abstract int Length {get;}
		public IMatrixExpression ToMatrix()
		{
			return new ScalarMatrix(context,new IVectorExpression[]{this});
		}
	}
	public abstract class MatrixOperator: MathExpression, IMatrixExpression
	{
		public MatrixOperator(Context context): base(context) {}
		public virtual ValueMatrix Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract ScalarMatrix Expand();
		public IMatrixExpression SafeExpand()
		{
			return (IMatrixExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IMatrixExpression Simplify()
		{
			return (IMatrixExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IMatrixExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IMatrixExpression) InnerSubstitute(original,replacement);
		}
		#endregion

		public abstract int LengthX {get;}
		public abstract int LengthY {get;}
		public IVectorExpression GetRowVector(int y)
		{
			ScalarMatrix me = Expand();
			IScalarExpression[] se = new IScalarExpression[LengthX];
			for(int x=0;x<LengthX;x++)
				se[x] = me[x,y];
			return new ScalarVector(context,se);
		}
		public IVectorExpression GetColumnVector(int x)
		{
			ScalarMatrix me = Expand();
			IScalarExpression[] se = new IScalarExpression[LengthY];
			for(int y=0;y<LengthY;y++)
				se[y] = me[x,y];
			return new ScalarVector(context,se);
		}
	}
	#endregion

	public abstract class MatrixListOperator: MathExpression, IMatrixListExpression
	{
		public MatrixListOperator(Context context): base(context) {}
		public virtual ValueMatrixList Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract MatrixList Expand();
		public IMatrixListExpression SafeExpand()
		{
			return (IMatrixListExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IMatrixListExpression Simplify()
		{
			return (IMatrixListExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IMatrixListExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IMatrixListExpression) InnerSubstitute(original,replacement);
		}
		#endregion

		public abstract int Length {get;}
	}
}
