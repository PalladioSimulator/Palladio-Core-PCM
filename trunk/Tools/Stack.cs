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
using System.Reflection;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Parsing;

namespace cdrnet.Lib.MathLib.Tools
{
	public class ExpressionStack
	{
		private Parser parser;
		private IExpressionStringFormatter formatter;
		private Stack stack;
		private int level;
		public ExpressionStack(Parser parser, IExpressionStringFormatter formatter)
		{
			level = 0;
			stack = new Stack(32);
			this.parser = parser;
			this.formatter = formatter;
		}
		//EVENTS
		public event StackItemEventHandler OnPopElement;
		public event StackItemEventHandler OnPushElement;
		public event StackItemEventHandler OnNewOutput;
		public event EventHandler OnEmptyStack;
		public event EventHandler OnBeforeExecute;
		public event StringEventHandler OnNewLogEntry;
		//PROPERTIES
		public Parser Parser
		{
			get {return parser;}
		}
		public IExpressionStringFormatter Formatter
		{
			get {return formatter;}
		}
		//STACK PROPERTIES
		public int Count
		{
			get {return stack.Count;}
		}
		public bool IsEmpty
		{
			get {return stack.Count == 0;}
		}
		public int Level
		{
			get {return level;}
		}
		//STACK MANIPULATION
		public void Clear()
		{
			stack.Clear();
			level = 0;
		}
		public void PublishNewOutput(ExpressionStackItem item)
		{
			if(OnNewOutput != null)
				OnNewOutput(this,new StackItemEventArgs(item));
		}
		public void PublishNewLogEntry(string entry)
		{
			if(OnNewLogEntry != null)
				OnNewLogEntry(this,new StringEventArgs(entry));
		}
		public void Push(string expression)
		{
			try
			{
				IExpression exp = parser.Parse(expression);
				Push(exp);
			}
			catch(Exception e)
			{
				PublishNewLogEntry(e.ToString());
			}
		}
		public void Push(IExpression expression)
		{
			ExpressionStackItem item = new ExpressionStackItem(this,expression);
			IProcExpression proc = expression as IProcExpression;
			if(proc == null)
			{
				item.Level = level;
				stack.Push(item);
				if(OnPushElement != null)
					OnPushElement(this,new StackItemEventArgs(item));
			}
			if(OnNewOutput != null)
				OnNewOutput(this,new StackItemEventArgs(item));
		}
		public ExpressionStackItem Peek()
		{
			return stack.Peek() as ExpressionStackItem;
		}
		public IExpression Pop()
		{
			ExpressionStackItem item = stack.Pop() as ExpressionStackItem;
			if(OnPopElement != null)
				OnPopElement(this,new StackItemEventArgs(item));
			if(IsEmpty)
			{
				if(OnEmptyStack != null)
					OnEmptyStack(this,EventArgs.Empty);
			}
			else
			{
				if(OnNewOutput != null)
					OnNewOutput(this,new StackItemEventArgs(Peek()));
			}
			return item.Expression;
		}
		private bool PopList(ref ExpressionStackItem[] items)
		{
			if(items.Length > stack.Count)
				return false;
			for(int i=items.Length-1;i>=0;i--)
				items[i] = stack.Pop() as ExpressionStackItem;
			return true;
		}
		private void PushList(ExpressionStackItem[] items)
		{
			for(int i=0;i<items.Length;i++)
				stack.Push(items[i]);
		}
		public bool ExecuteOperator(ParsingObjectType type, string name, int pcount)
		{
			if(OnBeforeExecute != null)
				OnBeforeExecute(this,EventArgs.Empty);
			ExpressionStackItem[] items = new ExpressionStackItem[pcount];
			if(PopList(ref items))
			{
				TypeAnalyzerTypeItem[] typelist = new TypeAnalyzerTypeItem[pcount];
				for(int i=0;i<typelist.Length;i++)
					typelist[i] = items[i].Type;
				try
				{
					TypeAnalyzerObjectItem oi = parser.Provider.TypeAnalyzer.ObjectList.FindItem(type,name,typelist);
					object[] para = new object[pcount];
					for(int i=0;i<para.Length;i++)
						para[i] = items[i].Expression;
					IExpression nexp = oi.Constructor.Invoke(para) as IExpression;
					if(IsEmpty)
					{
						if(OnEmptyStack != null)
							OnEmptyStack(this,EventArgs.Empty);
					}
					else
					{
						for(int i=0;i<pcount;i++)
							if(OnPopElement != null)
								OnPopElement(this,new StackItemEventArgs(items[items.Length-1-i]));
					}
					Push(nexp);
					return true;
				}
				catch
				{
					PushList(items);
					return false;
				}
			}
			else
				return false;
		}
//		public bool ExecuteList()
//		{
//		}
//		public bool ExecuteVector()
//		{
//		}
	}

	public class ExpressionStackItem
	{
		private int level = 0;
		protected IExpression expression;
		protected string infixstring;
		protected string formatted;
		protected TypeAnalyzerTypeItem type = null;
		protected ExpressionStack stack;
		public ExpressionStackItem(ExpressionStack stack, IExpression expression)
		{
			this.stack = stack;
			this.formatted = stack.Formatter.Format(expression);
			expression = ExpressionConverter.Convert(expression,"simple");
			this.infixstring = expression.ToString();
			this.expression = expression;
		}
		public int Level
		{
			get {return level;}
			set {level = value;}
		}
		public IExpression Expression
		{
			get {return expression;}
		}
		public string InfixString
		{
			get {return infixstring;}
		}
		public string FormattedString
		{
			get {return formatted;}
		}
		public TypeAnalyzerTypeItem Type
		{
			get
			{
				if(type != null)
					return type;
				else
				{
					Type texp = expression.GetType();
					Type[] tinterfaces = texp.GetInterfaces();
					Type tlookingfor = null;
					for(int i=0;i<tinterfaces.Length && tlookingfor==null;i++)
					{
						Type[] subinterfaces = tinterfaces[i].GetInterfaces();
						for(int j=0;j<subinterfaces.Length;j++)
						{
							if(subinterfaces[j].Equals(typeof(IExpression)))
							{
								tlookingfor = tinterfaces[i];
								break;
							}
						}
					}
					if(tlookingfor != null)
					{
						type = stack.Parser.Provider.TypeAnalyzer.TypeList.FindItem(tlookingfor);
						return type;
					}
					throw new Exceptions.ParsingTokenLookupFailedException(expression.ToString());
				}
			}
		}
	}
}
