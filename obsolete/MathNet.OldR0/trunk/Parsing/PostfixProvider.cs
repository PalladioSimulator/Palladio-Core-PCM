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
using System.Reflection;
using System.Collections;
using System.Collections.Specialized;
using System.Text.RegularExpressions;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Parsing
{
	public class PostfixTokenizer: ITreeTokenProvider
	{
		private TypeAnalyzer ta;
		public PostfixTokenizer()
		{
		}
		public override string ToString()
		{
			return("cdrnet Math.NET Parsing Provider for POSTFIX Expressions");
		}
		public TypeAnalyzer TypeAnalyzer
		{
			get {return(ta);}
			set {ta = value;}
		}
		public TreeTokenNode ParseExpression(string expression)
		{
			String[] tokens = expression.Split(' ');
			Stack stk = new Stack(tokens.Length+2);
			foreach(string token in tokens)
			{
				char c = token[0];
				if(ta.Functions.Contains(token)) //Function
				{
					TypeAnalyzerObjectItem oi = ta.ObjectList.FindItem(ParsingObjectType.Function,token);
					if(MatchObjectItems(stk,oi,token))
						continue;
				}
				if(ta.InnerOperators.Contains(token)) //InnerOperator
				{
					TypeAnalyzerObjectItem oi = ta.ObjectList.FindItem(ParsingObjectType.InnerOperator,token);
					if(MatchObjectItems(stk,oi,token))
						continue;
				}
				if(ta.PreOperators.Contains(token)) //PreOperator
				{
					TypeAnalyzerObjectItem oi = ta.ObjectList.FindItem(ParsingObjectType.PreOperator,token);
					if(MatchObjectItems(stk,oi,token))
						continue;
				}
				if(ta.OuterOperators.Contains(token)) //OuterOperator
				{
					TypeAnalyzerObjectItem oi = ta.ObjectList.FindItem(ParsingObjectType.OuterOperator,token);
					if(MatchObjectItems(stk,oi,token))
						continue;
				}
				if(Char.IsNumber(c)) //Value
				{
					TreeTokenNode tnn = new TreeTokenNode(2);
					tnn.Token = new TreeToken(token);
					tnn.Token.ObjectType = ParsingObjectType.Value;
					tnn.EvaluateObjectType(ta);
					stk.Push(tnn);
					continue;
				}
				if(Char.IsLetter(c)) //Variable
				{
					TreeTokenNode tnn = new TreeTokenNode(2);
					tnn.Token = new TreeToken(token);
					tnn.Token.ObjectType = ParsingObjectType.Variable;
					tnn.EvaluateObjectType(ta);
					stk.Push(tnn);
					continue;
				}
				throw(new ParsingUnknownTokenException(token)); //Others not yet supported
			}
			if(stk.Count != 1)
				throw(new ParsingLogicalExpressionException());
			return((TreeTokenNode)stk.Pop());
		}
		private bool MatchObjectItems(Stack stk, TypeAnalyzerObjectItem op, string token)
		{
			int cnt = op.ParameterTypeItems.Length;
			TreeTokenNode[] nlist = new TreeTokenNode[cnt];
			for(int i=cnt-1;i>=0;i--) //Reverse Stack
				nlist[i] = (TreeTokenNode)stk.Pop();
			for(int i=0;i<cnt;i++)
			{
				if(!nlist[i].ObjectType.ReturnTypeItem.SubAttribute.Type.Equals(op.ParameterTypeItems[i].SubAttribute.Type))
				{
					for(int j=0;j<cnt;j++)
						stk.Push(nlist[j]);
					return(false);
				}
			}
			TreeTokenNode node = new TreeTokenNode(2);
			node.Token = new TreeToken(token);
			node.Token.ObjectType = op.SubAttribute.Type;
			for(int i=0;i<cnt;i++)
			{
				node.Add(nlist[i]);
			}
			node.EvaluateObjectType(ta);
			stk.Push(node);
			return(true);
		}
	}
}
