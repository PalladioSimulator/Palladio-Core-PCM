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

namespace cdrnet.Lib.MathLib.Exceptions
{
	public class MathException: Exception
	{
		public override string ToString()
		{
			return("An unspecified Math.NET exception has been thrown. Please check your expression and try again.");
		}
	}

	#region Parsing Exceptions
	public class ParsingException: MathException
	{
		public override string ToString()
		{
			return("An unspecified parsing exception has been thrown. Please check your expression and try again.");
		}
	}
	public class ParsingUnknownTokenProviderException: ParsingException
	{
		public override string ToString()
		{
			return("Parsing Provider (Expression Tokenizer) not found. Please specify your provider before invoking the parser!");
		}
	}
	public class ParsingTokenLookupFailedException: ParsingException
	{
		private string token;
		public ParsingTokenLookupFailedException(string token)
		{
			this.token = token;
		}
		public override string ToString()
		{
			return("Lookup failed for Token '" + token + "'!");
		}
	}
	public class ParsingUnknownTokenException: ParsingException
	{
		private string token;
		public ParsingUnknownTokenException(string token)
		{
			this.token = token;
		}
		public override string ToString()
		{
			return("Unknown Token '" + token + "'!");
		}
	}
	public class ParsingLogicalExpressionException: ParsingException
	{
		public override string ToString()
		{
			return("Logical Error in Exception detected!");
		}
	}
	public class ParsingLogicalParenthesisOrderException: ParsingLogicalExpressionException
	{
		public override string ToString()
		{
			return("Logical Error in Parenthesis '()' Order detected!");
		}
	}
	public class ParsingLogicalBracketOrderException: ParsingLogicalExpressionException
	{
		public override string ToString()
		{
			return("Logical Error in Bracket '[]' Order detected!");
		}
	}
	public class ParsingLogicalMetaBracketOrderException: ParsingLogicalExpressionException
	{
		public override string ToString()
		{
			return("Logical Error in Metabracket '{}' Order detected!");
		}
	}
	public class ParsingLogicalOuterOperatorOrderException: ParsingLogicalExpressionException
	{
		public override string ToString()
		{
			return("Logical Error in OuterOperator Order detected!");
		}
	}
	public class ParsingAttributeMissingException: ParsingLogicalExpressionException
	{
		public override string ToString()
		{
			return "The attribute decoration of a given instance is missing!";
		}
	}
	#endregion

	#region Expression Exceptions
	public class ExpressionException: MathException
	{
		public override string ToString()
		{
			return("An unspecified expression exception has been thrown. Please check your expression and try again.");
		}
	}
	public class ExpressionArgumentNotOfRequiredTypeException: ExpressionException
	{
		public override string ToString()
		{
			return("A given argument is not of the required type.");
		}
	}
	public class ExpressionArgumentNotOfRequiredFormatException: ExpressionException
	{
		public override string ToString()
		{
			return("A given argument is not of the required format.");
		}
	}
	public class ExpressionVariableRequiredException: ExpressionArgumentNotOfRequiredTypeException
	{
		public override string ToString()
		{
			return("A variable is required.");
		}
	}
	public class ExpressionInfiniteRecursiveException: ExpressionArgumentNotOfRequiredTypeException
	{
		public override string ToString()
		{
			return("Recursive Expression detected.");
		}
	}
	public class ExpressionRankMismatchException: ExpressionException
	{
		public override string ToString()
		{
			return("Rank (Dimension) Mismatch.");
		}
	}
	public class ExpressionIndexOutOfRangeException: ExpressionException
	{
		public override string ToString()
		{
			return("Index out of Range.");
		}
	}
	public class ExpressionNotDeriveableException: ExpressionException
	{
		public override string ToString()
		{
			return("Unable to derive the given expression!");
		}
	}
	public class ExpressionNotIntegratableException: ExpressionException
	{
		public override string ToString()
		{
			return("Unable to integrate the given expression!");
		}
	}
	public class ExpressionInconsistentSystemException: ExpressionException
	{
		public override string ToString()
		{
			return("Inconsistent System (overdefined)");
		}
	}
	public class ExpressionNonRowEchelonMatrixException: ExpressionException
	{
		public override string ToString()
		{
			return("Row-echelon matrix expected");
		}
	}
	public class ExpressionNotExpandableException: ExpressionException
	{
		public override string ToString()
		{
			return("Unable to expand the given expression!");
		}
	}
	#endregion

	#region Calculation Exceptions
	public class CalcException: MathException
	{
		public override string ToString()
		{
			return("An unspecified calculation exception has been thrown. Please check your expression and try again.");
		}
	}
	public class CalcDivideByZeroException: CalcException
	{
		public override string ToString()
		{
			return("A divide by zero exception has been thrown. Please check your expression and try again.");
		}
	}
	public class CalcOverflowException: CalcException
	{
		public override string ToString()
		{
			return("An overflow exception has been thrown. Please check your expression and try again.");
		}
	}
	public class CalcNotConstantException: CalcException
	{
		public override string ToString()
		{
			return("the given expression is not constant. no value may be evaluated.");
		}
	}
	#endregion

	#region Internal Exceptions
	public class InternalException: MathException
	{
		private string msg;
		public InternalException(string msg)
		{
			this.msg = msg;
		}
		public override string ToString()
		{
			return "Math.NET Internal Exception: " + msg;
		}
	}
	#endregion
}
