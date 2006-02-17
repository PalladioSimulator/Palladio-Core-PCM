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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Literal;

namespace cdrnet.Lib.MathLib.Parsing
{
	/// <summary>
	/// The 'Parser' class is a simple programming interface for
	/// the whole parsing environment. It's highly recommended to
	/// use this class instead of the different helper classes.
	/// </summary>
	public class Parser
	{
		TypeAnalyzer ta;
		Context context;
		ITreeTokenProvider provider;
		public Parser()
		{
			context = new Context();
			context.Parser = this;
			ta = new TypeAnalyzer(context);
		}
		public Parser(Context context)
		{
			context.Parser = this;
			ta = new TypeAnalyzer(context);
		}
		/// <summary>
		/// Use this method to select a matching PreParser,
		/// like the builtin 'InfixTokenizer'. PreParsers evaluate
		/// string expressions to a kind of token tree structure,
		/// ready for final operator/type matching...
		/// </summary>
		public ITreeTokenProvider Provider
		{
			get {return provider;}
			set {provider = value;}
		}
		public Context Context
		{
			get {return context;}
		}
		public VariableManager VariableManager
		{
			get {return context.ContextVariables;}
			set {context.ContextVariables = value;}
		}
		/// <summary>
		/// Use this method to add external (third party)
		/// assemblies containing additional types and operators
		/// to the parser's symbol table
		/// </summary>
		/// <param name="path">File System Path to the Assembly File</param>
		public void IncludeExternalMathAssembly(string path)
		{
			ta.AddExternalAssembly(path);
		}
		/// <summary>
		/// Use this method to add external (third party)
		/// assemblies containing additional types and operators
		/// to the parser's symbol table
		/// </summary>
		/// <param name="a">An instance of the Assembly</param>
		public void IncludeExternalMathAssembly(Assembly a)
		{
			ta.AddExternalAssembly(a);
		}
		public override string ToString()
		{
			string tmp;
			if(provider == null)
				tmp = "No Parsing Provider Defined Yet";
			else
				tmp = provider.ToString();
			tmp += "\n\n";
			ta.InitParser();
			tmp += ta.ToString();
			return tmp;
		}
		/// <summary>
		/// Use this method to parse any given string expression
		/// to an IExpression instance using the specified PreParser.
		/// </summary>
		/// <param name="expression">string expression to parse</param>
		/// <returns>an IExpression instance</returns>
		public IExpression Parse(string expression)
		{
			if(provider == null)
				throw(new ParsingUnknownTokenProviderException());
			ta.InitParser();
			provider.TypeAnalyzer = ta;
			TreeTokenNode rootnode = provider.ParseExpression(expression);
			rootnode.EvaluateObjectType(ta);
			return (IExpression)TreeToIExpression(rootnode);
		}
		/// <summary>
		/// Parses a TokenTree to an IExpression instance (recursive)
		/// </summary>
		private object TreeToIExpression(TreeTokenNode node)
		{
			if(node.ObjectType.SubAttribute.Type == ParsingObjectType.Value)
			{
				return new ScalarExpressionValue(context,Double.Parse(node.Token.Value));
			}
			if(node.ObjectType.SubAttribute.Type == ParsingObjectType.Literal)
			{
				return new LiteralExpressionValue(context,node.Token.Value.Substring(1,node.Token.Value.Length-2));
			}
			if(node.ObjectType.SubAttribute.Type == ParsingObjectType.Complex)
			{
				return ScalarComplex.I(context);
			}
			if(node.ObjectType.SubAttribute.Type == ParsingObjectType.List && node.ObjectType.ReturnTypeItem.SubAttribute.Dimensions == 0)
			{
				Type aType = node.ObjectType.Constructor.GetParameters()[1].ParameterType;
				string nt = aType.FullName.Substring(0,aType.FullName.IndexOf('['));
				Type iType = aType.Assembly.GetType(nt);
				Array prms = Array.CreateInstance(iType,node.Count);
				for(int i=0;i<node.Count;i++)
				{
					prms.SetValue(TreeToIExpression(node[i]),new int[] {i});
				}
				return node.ObjectType.Constructor.Invoke(new object[] {context,prms});
			}
			if(node.ObjectType.SubAttribute.Type == ParsingObjectType.Vector && node.ObjectType.ReturnTypeItem.SubAttribute.Dimensions == 0)
			{
				Type aType = node.ObjectType.Constructor.GetParameters()[1].ParameterType;
				string nt = aType.FullName.Substring(0,aType.FullName.IndexOf('['));
				Type iType = aType.Assembly.GetType(nt);
				Array prms = Array.CreateInstance(iType,node.Count);
				for(int i=0;i<node.Count;i++)
				{
					prms.SetValue(TreeToIExpression(node[i]),new int[] {i});
				}
				return node.ObjectType.Constructor.Invoke(new object[] {context,prms});
			}
			if(node.ObjectType.SubAttribute.Type == ParsingObjectType.Variable)
			{
				Variable var = context.ContextVariables.GetCreateVariable(node.Token.Value);
				return var;
			}
			object[] parameters = new Object[node.Count+1];
			parameters[0] = context;
			for(int i=0;i<node.Count;i++)
			{
				parameters[i+1] = TreeToIExpression(node[i]);
			}
			return node.ObjectType.Constructor.Invoke(parameters);
		}
	}
}
