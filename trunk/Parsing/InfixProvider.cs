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
	public class InfixTokenizer: ITreeTokenProvider
	{
		private Regex tkRegex;
		private TypeAnalyzer ta;
		public InfixTokenizer()
		{
			//@"^([a-z]([a-z0-9'])*|\d+(\.\d+)?|[\[\](){},;]|[*+-^/|])+$"
			this.tkRegex = new Regex(@"^([a-z]([a-z0-9'])*|\d+(\.\d+)?|[\[\](){},;]|""([^""])*""|.)+$",RegexOptions.Singleline|RegexOptions.Compiled|RegexOptions.IgnoreCase|RegexOptions.IgnorePatternWhitespace);
		}
		public override string ToString()
		{
			return("cdrnet Math.NET Parsing Provider for INFIX Expressions");
		}
		public TypeAnalyzer TypeAnalyzer
		{
			get {return(ta);}
			set {ta = value;}
		}
		public TreeTokenNode ParseExpression(string expression)
		{
			ParserLinearToken[] plt = ParseToLinearTokens(expression);
			if(plt.Length == 1)
				plt[0].ExtendObjectType(null,null,null);
			if(plt.Length == 2)
			{
				plt[0].ExtendObjectType(null,plt[1],null);
				plt[1].ExtendObjectType(plt[0],null,null);
			}
			if(plt.Length > 2)
			{
				plt[0].ExtendObjectType(null,plt[1],null);
				plt[1].ExtendObjectType(plt[0],plt[2],null);
				plt[plt.Length-1].ExtendObjectType(plt[plt.Length-2],null,plt[plt.Length-3]);
				for(int i=2;i<plt.Length-1;i++)
					plt[i].ExtendObjectType(plt[i-1],plt[i+1],plt[i-2]);
			}
			TreeTokenNode container = new TreeTokenNode(2);
			container.Token = new TreeToken("(");
			container.Token.ObjectType = ParsingObjectType.Parenthesis;
			foreach(ParserLinearToken item in plt)
			{
				TreeTokenNode node = new TreeTokenNode(2);
				node.Token = item.ConvertToTreeToken();
				container.Add(node);
			}
			TokenWalker walker = new TokenWalker(ta);
			walker.WalkTokenRecursive(container);			
			return(container);
		}
		private class TokenWalker
		{
			private TypeAnalyzer ta;
			public TokenWalker(TypeAnalyzer ta)
			{
				this.ta = ta;
			}
			public void WalkTokenRecursive(TreeTokenNode subroot)
			{
				if(subroot.GetFlag(0))
					return;
				//STEP 1 - Parenthesis & Functions - f(a,a*(b+d))
				WalkParenthesis(subroot);
				//STEP 2 - Lists - {1,2,{3,4},5}
				WalkLists(subroot);
				//STEP 3 - Matrices - [1,2;3,4;5,6]
				WalkMatrices(subroot);
				//STEP 4 - OuterOperators - |-2|
				WalkOuters(subroot);
				//STEP 5 - Values & Variables 2*a
				WalkValuesVariables(subroot);
				//STEP 6 - PreOperators - (-x)
				WalkPres(subroot);
				//STEP 9 - RemoveRedundantStuff
				WalkCleanUp(subroot);
				//STEP 7 - InnerOperators - a+b*c
				WalkInners(subroot);
				//STEP 8 - Relations - (A=B)AND(C<D)
				WalkRelations(subroot);
				//STEP 10 - Seperators
				WalkSeperators(subroot);
				//STEP 9 - RemoveRedundantStuff
				WalkCleanUp(subroot);
				subroot.SetFlag(0,true);
				subroot.EvaluateObjectType(ta);
			}
			private void WalkParenthesis(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.Parenthesis);
				if(iList.Length > 0) 
				{
					int level = 0, opening=0, closing=-1;
					opening = closing + 1;
					level = 0;
					for(int l=opening;l<iList.Length;l++)
					{
						if(subroot[iList[l]].Token.Value == "(")
							level++;
						else
							level--;
						if(level == 0)
						{
							closing = l;
							break;
						}
					}
					if(closing<=opening)
						throw(new ParsingLogicalParenthesisOrderException());
					if(iList[opening] > 0 && subroot[iList[opening]-1].Token.ObjectType == ParsingObjectType.Function)
					{	//Function Parenthesis
						for(int i=iList[opening]+1;i<iList[closing];i++)
							subroot[iList[opening]-1].Add(subroot[i]);
						for(int i=iList[closing];i>=iList[opening];i--)
							subroot.RemoveAt(i);
						WalkTokenRecursive(subroot[iList[opening]-1]);
					}
					else
					{	//Nonfunction Paranthesis
						if(iList[opening]>0 && subroot[iList[opening]-1].Token.ObjectType == ParsingObjectType.Variable)
						{
							throw(new ParsingUnknownTokenException(subroot[iList[opening]-1].Token.Value));
						}
						for(int i=iList[opening]+1;i<iList[closing];i++)
							subroot[iList[opening]].Add(subroot[i]);
						for(int i=iList[closing];i>iList[opening];i--)
							subroot.RemoveAt(i);
						WalkTokenRecursive(subroot[iList[opening]]);
					}
				}
				if(iList.Length > 1) 
				{
					this.WalkParenthesis(subroot);
				}
			}
			private void WalkLists(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.List);
				if(iList.Length > 0) 
				{
					int level = 0, opening=0, closing=-1;
					opening = closing + 1;
					for(int l=opening;l<iList.Length;l++)
					{
						if(subroot[iList[l]].Token.Value == "{")
							level++;
						else
							level--;
						if(level == 0)
						{
							closing = l;
							break;
						}
					}
					if(closing<=opening)
						throw(new ParsingLogicalMetaBracketOrderException());
					for(int i=iList[opening]+1;i<iList[closing];i++)
						subroot[iList[opening]].Add(subroot[i]);
					for(int i=iList[closing];i>iList[opening];i--)
						subroot.RemoveAt(i);
					WalkTokenRecursive(subroot[iList[opening]]);
				}
				if(iList.Length > 1) 
				{
					this.WalkLists(subroot);
				}
			}
			private void WalkMatrices(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.Vector);
				if(iList.Length > 0) 
				{
					int level = 0, opening=0, closing=-1;
					opening = closing + 1;
					for(int l=opening;l<iList.Length;l++)
					{
						if(subroot[iList[l]].Token.Value == "[")
							level++;
						else
							level--;
						if(level == 0)
						{
							closing = l;
							break;
						}
					}
					if(closing<=opening)
						throw(new ParsingLogicalBracketOrderException());
					for(int i=iList[opening]+1;i<iList[closing];i++)
						subroot[iList[opening]].Add(subroot[i]);
					for(int i=iList[closing];i>iList[opening];i--)
						subroot.RemoveAt(i);
					WalkTokenRecursive(subroot[iList[opening]]);
				}
				if(iList.Length > 1) 
				{
					this.WalkMatrices(subroot);
				}
			}
			private void WalkSeperators(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(ParsingObjectType.Seperator);
				for(int j=iList.Length-1;j>=0;j--)
					subroot.RemoveAt(iList[j]);
			}
			private void WalkOuters(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.OuterOperator);
				if(iList.Length > 0) 
				{
					int opening=0, closing=-1;
					string chr = subroot[iList[opening]].Token.Value;
					opening = closing + 1;
					for(int l=opening+1;l<iList.Length;l++)
					{
						if(subroot[iList[l]].Token.Value == chr)
						{
							closing = l;
							break;
						}
					}
					if(closing<=opening)
						throw(new ParsingLogicalOuterOperatorOrderException());
					for(int i=iList[opening]+1;i<iList[closing];i++)
						subroot[iList[opening]].Add(subroot[i]);
					for(int i=iList[closing];i>iList[opening];i--)
						subroot.RemoveAt(i);
					WalkTokenRecursive(subroot[iList[opening]]);
				}
				if(iList.Length > 1) 
					this.WalkOuters(subroot);
			}
			private void WalkValuesVariables(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.Value);
				for(int i=0;i<iList.Length;i++)
				{
					subroot[iList[i]].SetFlag(0,true);
					subroot[iList[i]].EvaluateObjectType(ta);
				}
				iList = subroot.FindChilds(0,false,ParsingObjectType.Variable);
				for(int i=0;i<iList.Length;i++)
				{
					subroot[iList[i]].SetFlag(0,true);
					subroot[iList[i]].EvaluateObjectType(ta);
				}
				iList = subroot.FindChilds(0,false,ParsingObjectType.Complex);
				for(int i=0;i<iList.Length;i++)
				{
					subroot[iList[i]].SetFlag(0,true);
					subroot[iList[i]].EvaluateObjectType(ta);
				}
				iList = subroot.FindChilds(0,false,ParsingObjectType.Literal);
				for(int i=0;i<iList.Length;i++)
				{
					subroot[iList[i]].SetFlag(0,true);
					subroot[iList[i]].EvaluateObjectType(ta);
				}
			}
			private void WalkPres(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.InnerOperator);
				if(iList.Length > 0 && subroot.Count > 1 && iList[0] == 0)
				{
					subroot[0].Add(subroot[1]);
					subroot.RemoveAt(1);
					subroot[0].Token.ObjectType = ParsingObjectType.PreOperator;
					WalkTokenRecursive(subroot[0]);
				}
				iList = subroot.FindChilds(0,false,ParsingObjectType.PreOperator);
				for(int i=iList.Length-1;i>=0;i--)
				{
					subroot[iList[i]].Add(subroot[iList[i]+1]);
					subroot.RemoveAt(iList[i]+1);
					WalkTokenRecursive(subroot[iList[i]]);
				}
			}
			private void WalkInners(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.InnerOperator);
				bool matched = false;
				if(iList.Length > 0)
				{
					for(int p=20;p<600;p++) //Priority Classes
					{
						TypeAnalyzerObjectCollection oc = ta.ObjectList.Filter(ParsingObjectType.InnerOperator,p);
						if(oc.Count == 0)
							continue;
						for(int k=0;k<iList.Length;k++) //Tokens
						{
							for(int i=0;i<oc.Count;i++) //Operators
							{
								TreeTokenNode currentNode = subroot[iList[k]];
								if(currentNode.Token.Value == oc[i].SubAttribute.Character)
								{
									TreeTokenNode previousNode = subroot[iList[k]-1];
									TreeTokenNode nextNode = subroot[iList[k]+1];
									if(oc[i].ParameterTypeItems[0] == previousNode.ObjectType.ReturnTypeItem
										&& oc[i].ParameterTypeItems[1] == nextNode.ObjectType.ReturnTypeItem)
									{	//Match
										currentNode.SetFlag(0,true);
										currentNode.Add(previousNode);
										currentNode.Add(nextNode);
										currentNode.EvaluateObjectType(ta);
										subroot.RemoveAt(iList[k]+1);
										subroot.RemoveAt(iList[k]-1);
										matched = true;
										break;
									}
								}
							}
							if(matched)
								break;
						}
						if(matched)
							break;
					}
				}
				if(iList.Length > 1 & !matched) //more than one failed token!
					throw(new ParsingTokenLookupFailedException(subroot[iList[0]].Token.Value + " (InnerOperator)"));
				if(iList.Length > 1) 
					this.WalkInners(subroot);
			}
			private void WalkRelations(TreeTokenNode subroot)
			{
				int[] iList;
				iList = subroot.FindChilds(0,false,ParsingObjectType.Relation);
				bool matched = false;
				if(iList.Length > 0)
				{
					TypeAnalyzerObjectCollection oc = ta.ObjectList.Filter(ParsingObjectType.Relation);
					for(int i=0;i<oc.Count;i++) //Relations
					{
						for(int k=0;k<iList.Length;k++) //Tokens
						{
							TreeTokenNode currentNode = subroot[iList[k]];
							TreeTokenNode previousNode = subroot[iList[k]-1];
							TreeTokenNode nextNode = subroot[iList[k]+1];
							if(currentNode.Token.Value == oc[i].SubAttribute.Character)
							{
								if(oc[i].ParameterTypeItems[0] == previousNode.ObjectType.ReturnTypeItem
									&& oc[i].ParameterTypeItems[1] == nextNode.ObjectType.ReturnTypeItem)
								{	//MATCH
									currentNode.SetFlag(0,true);
									currentNode.Add(previousNode);
									currentNode.Add(nextNode);
									currentNode.EvaluateObjectType(ta);
									subroot.RemoveAt(iList[k]+1);
									subroot.RemoveAt(iList[k]-1);
									matched = true;
									break;
								}
							}
						}
						if(matched)
							break;
					}
				}
				if(iList.Length > 1 & !matched) //more than one failed token!
					throw(new ParsingTokenLookupFailedException(subroot[iList[0]].Token.Value + " (Relation)"));
				if(iList.Length > 1) 
					this.WalkRelations(subroot);
			}
			private void WalkCleanUp(TreeTokenNode subroot)
			{
				if(subroot.Token.IsParenthesis && subroot.Count==1)
				{
					TreeTokenNode sub = subroot[0];
					subroot.Token = sub.Token;
					subroot.RemoveAt(0);
					subroot.ObjectType = sub.ObjectType;
					for(int i=0;i<sub.Count;i++)
						subroot.Add(sub[i]);
				}
			}
		}
		private ParserLinearToken[] ParseToLinearTokens(string exp)
		{
			//exp = exp.Replace(" ","");
			Match m = tkRegex.Match(exp);
			ParserLinearToken[] plt = new ParserLinearToken[m.Groups[1].Captures.Count];
			int shift = 0;
			if(m.Captures.Count == 0)
				throw(new ParsingUnknownTokenException("OPERATOR"));
			for(int i=0;i<m.Groups[1].Captures.Count;i++)
			{
				string val = m.Groups[1].Captures[i].Value;
				ParserLinearToken tmp = new ParserLinearToken(val);
				char firstchr = val[0]; //val.ToCharArray(0,1)[0];
				char lastchr = val[val.Length-1];
				if(firstchr==' ')
				{
					shift++;
					continue;
				}
				//NUMBERS & CHARACTERS
				if(Char.IsLetter(firstchr))
					tmp.IsCharacter = true;
				if(Char.IsNumber(firstchr))
					tmp.IsValue = true;
				//SEPERATORS
				if(firstchr=='(')
					tmp.IsOpeningParenthesis = true;
				if(firstchr==')')
					tmp.IsClosingParenthesis = true;
				if(firstchr=='[')
					tmp.IsOpeningBracket = true;
				if(firstchr==']')
					tmp.IsClosingBracket = true;
				if(firstchr=='{')
					tmp.IsOpeningMetaBracket = true;
				if(firstchr=='}')
					tmp.IsClosingMetaBracket = true;
				if(firstchr==',')
					tmp.IsComma = true;
				if(firstchr=='"' && lastchr=='"' && val.Length > 1)
					tmp.IsLiteral = true;
				//REGISTERED OPERATORS
				if(ta.InnerOperators.Contains(val))
					tmp.IsInner = true;
				if(ta.OuterOperators.Contains(val))
					tmp.IsOuter = true;
				if(ta.PreOperators.Contains(val))
					tmp.IsPre = true;
				if(ta.Relations.Contains(val))
					tmp.IsRelation = true;
				if(ta.Functions.Contains(val))
					tmp.IsFunction = true;
				if(!tmp.IsAnything)
					throw(new ParsingUnknownTokenException(val));
				plt[i-shift] = tmp;
			}
			if(shift>0)
			{
				ParserLinearToken[] plt2 = new ParserLinearToken[plt.Length-shift];
				for(int i=0;i<plt2.Length;i++)
					plt2[i] = plt[i];
				return plt2;
			}
			return plt;
		}
		private class ParserLinearToken
		{
			string stk;
			ParsingObjectType objType;
			bool isValue, isCharacter, isInner, isOuter, isPre, isParenthesisA, isParenthesisB, isBracketA, isBracketB, isMetaBracketA, isMetaBracketB, isComma, isRelation, isFunction, isLiteral;
			public ParserLinearToken(string stk)
			{
				this.stk = stk;
			}
			public string Value
			{
				get {return(stk);}
			}
			public ParsingObjectType ObjectType
			{
				get {return(objType);}
				set {objType = value;}
			}
			public bool IsValue
			{
				get {return(isValue);}
				set {isValue = value;}
			}
			public bool IsCharacter
			{
				get {return(isCharacter);}
				set {isCharacter = value;}
			}
			public bool IsInner
			{
				get {return(isInner);}
				set {isInner = value;}
			}
			public bool IsOuter
			{
				get {return(isOuter);}
				set {isOuter = value;}
			}
			public bool IsPre
			{
				get {return(isPre);}
				set {isPre = value;}
			}
			public bool IsOperator
			{
				get {return(isInner||isOuter||isPre);}
			}
			public bool IsOpeningParenthesis // (
			{
				get {return(isParenthesisA);}
				set {isParenthesisA = value;}
			}
			public bool IsClosingParenthesis // )
			{
				get {return(isParenthesisB);}
				set {isParenthesisB = value;}
			}
			public bool IsOpeningBracket // [
			{
				get {return(isBracketA);}
				set {isBracketA = value;}
			}
			public bool IsClosingBracket // ]
			{
				get {return(isBracketB);}
				set {isBracketB = value;}
			}
			public bool IsOpeningMetaBracket // {
			{
				get {return(isMetaBracketA);}
				set {isMetaBracketA = value;}
			}
			public bool IsClosingMetaBracket // }
			{
				get {return(isMetaBracketB);}
				set {isMetaBracketB = value;}
			}
			public bool IsComma // ,
			{
				get {return(isComma);}
				set {isComma = value;}
			}
			public bool IsRelation
			{
				get {return(isRelation);}
				set {isRelation = value;}
			}
			public bool IsLiteral
			{
				get {return(isLiteral);}
				set {isLiteral = value;}
			}
			public bool IsFunction
			{
				get {return(isFunction);}
				set {isFunction = value;}
			}
			public bool IsAnything
			{
				get {return(isComma||isMetaBracketA||isMetaBracketB||isBracketA||isBracketB||isParenthesisA||isParenthesisB||isPre||isOuter||isInner||isCharacter||isValue||isRelation||isFunction||isLiteral);}
			}
			public bool IsKindOfOpeningBracket
			{
				get {return(isMetaBracketA||isBracketA||isParenthesisA||isOuter);}
			}
			public bool IsKindOfClosingBracket
			{
				get {return(isMetaBracketB||isBracketB||isParenthesisB||isOuter);}
			}
			public bool IsSeperator
			{
				get {return(isComma);}
			}
			public bool CanBeOpeningEntity
			{
				get {return(this.IsKindOfOpeningBracket||isValue||isCharacter||isPre||isLiteral);}
			}
			public bool CanBeClosingEntity
			{
				get {return(this.IsKindOfClosingBracket||isValue||isCharacter||isLiteral);}
			}
			public bool CanBeEntitySuccessor
			{
				get {return(this.IsOuter||this.IsInner||this.IsKindOfClosingBracket||this.IsSeperator||this.IsRelation);}
			}
			public bool CanBeEntityPredecessor
			{
				get {return(this.isPre||this.IsOuter||this.IsInner||this.IsKindOfOpeningBracket||this.IsSeperator||this.IsRelation);}
			}
			public TreeToken ConvertToTreeToken()
			{
				TreeToken tt = new TreeToken(stk);
				tt.ObjectType = objType;
				return(tt);
			}
			public void ExtendObjectType(ParserLinearToken prevToken, ParserLinearToken nextToken, ParserLinearToken prePrevToken)
			{
				//Complex
				if(stk == "I")
				{
					objType = ParsingObjectType.Complex;
					return;
				}
				// Value & Variable
				if(isValue)
				{
					objType = ParsingObjectType.Value;
					return;
				}
				if(isCharacter&&!IsOperator&&!isFunction)
				{
					objType = ParsingObjectType.Variable;
					return;
				}
				// Special
				if(isRelation)
				{
					objType = ParsingObjectType.Relation;
					return;
				}
				if(IsSeperator)
				{
					objType = ParsingObjectType.Seperator;
					return;
				}
				if(isBracketA || isBracketB)
				{
					objType = ParsingObjectType.Vector;
					return;
				}
				if(isParenthesisA || isParenthesisB)
				{
					objType = ParsingObjectType.Parenthesis;
					return;
				}
				if(isMetaBracketA || isMetaBracketB)
				{
					objType = ParsingObjectType.List;
					return;
				}
				if(isLiteral)
				{
					objType = ParsingObjectType.Literal;
					return;
				}
				// Mixed/Dependant
				if(prevToken == null)
				{
					if(nextToken == null)
					{
						if(isCharacter)
						{
							objType = ParsingObjectType.Variable;
							return;
						}
					}
					else
					{
						if(isCharacter && isFunction && nextToken.IsOpeningParenthesis)
						{
							objType = ParsingObjectType.Function;
							return;
						}
						if(isCharacter && nextToken.CanBeEntitySuccessor)
						{
							objType = ParsingObjectType.Variable;
							return;
						}
						if(isPre && nextToken.CanBeOpeningEntity)
						{
							objType = ParsingObjectType.PreOperator;
							return;
						}
						if(isOuter && (nextToken.CanBeOpeningEntity || nextToken.CanBeEntitySuccessor))
						{
							objType = ParsingObjectType.OuterOperator;
							return;
						}
					}
				}
				else
				{
					if(nextToken == null)
					{
						if(isCharacter && prevToken.CanBeEntityPredecessor)
						{
							objType = ParsingObjectType.Variable;
							return;
						}
						if(isOuter && (prevToken.CanBeClosingEntity || prevToken.CanBeEntityPredecessor))
						{
							objType = ParsingObjectType.OuterOperator;
							return;
						}
					}
					else
					{
						if(isCharacter && isFunction && prevToken.CanBeEntityPredecessor && nextToken.IsOpeningParenthesis)
						{
							objType = ParsingObjectType.Function;
							return;
						}
						if(isCharacter && prevToken.CanBeEntityPredecessor && nextToken.CanBeEntitySuccessor && !(prevToken.CanBeClosingEntity && nextToken.CanBeOpeningEntity))
						{
							objType = ParsingObjectType.Variable;
							return;
						}
						if(isCharacter && prevToken.IsOuter && nextToken.IsOuter && (prePrevToken == null || prePrevToken.CanBeEntityPredecessor))
						{	//e.g. "|x|" while x could also be an InnerOperator
							objType = ParsingObjectType.Variable;
							return;
						}
						if(isInner && prevToken.CanBeClosingEntity && nextToken.CanBeOpeningEntity)
						{
							objType = ParsingObjectType.InnerOperator;
							return;
						}
						if(isPre && prevToken.CanBeEntityPredecessor && nextToken.CanBeOpeningEntity)
						{
							objType = ParsingObjectType.PreOperator;
							return;
						}
						if(isOuter && (prevToken.CanBeClosingEntity && nextToken.CanBeEntitySuccessor || prevToken.CanBeEntityPredecessor && nextToken.CanBeOpeningEntity))
						{
							objType = ParsingObjectType.OuterOperator;
							return;
						}
					}
				}
				throw(new ParsingTokenLookupFailedException(stk));
			}
			public override string ToString()
			{
				return("LinearToken["+stk+"|"+objType.ToString()+"]");
			}
		}
	}
}