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
using System.Text;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Parsing
{
	/// <summary>
	/// Math operator/object symbol
	/// </summary>
	public class TypeAnalyzerObjectItem: IComparable
	{
		Type type;
		TypeAnalyzerTypeItem returnType;
		TypeAnalyzerTypeItem[] parameterTypes;
		ParsingObjectAttribute attribute;
		ConstructorInfo constructorInfo;
		double priority;
		internal TypeAnalyzerObjectItem(Type type, ParsingObjectAttribute attr, ConstructorInfo cInfo)
		{
			this.type = type;
			this.attribute = attr;
			this.constructorInfo = cInfo;
		}
		public Type SubType
		{
			get {return(type);}
		}
		public ConstructorInfo Constructor
		{
			get {return(constructorInfo);}
		}
		public ParsingObjectAttribute SubAttribute
		{
			get {return(attribute);}
		}
		public TypeAnalyzerTypeItem ReturnTypeItem
		{
			get {return(returnType);}
		}
		public TypeAnalyzerTypeItem[] ParameterTypeItems
		{
			get {return(parameterTypes);}
		}
		public double Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		internal bool ExtendInfo(TypeAnalyzerTypeCollection types)
		{
			priority = attribute.Priority;
			if(attribute.Type==ParsingObjectType.Value)
			{
				returnType = types.FindItem(ParsingExpressionType.Scalar,1);
				return true;
			}
			if(attribute.Type==ParsingObjectType.Literal)
			{
				returnType = types.FindItem(ParsingExpressionType.Literal,1);
				return true;
			}
			Type[] tx = type.GetInterfaces();
			foreach(Type t in type.GetInterfaces())
			{
				bool ieFound = false;
				foreach(Type t2 in t.GetInterfaces())
				{
					if(t2.Equals(typeof(IExpression)))
					{
						ieFound = true;
						break;
					}
				}
				if(ieFound)
				{
					returnType = types.FindItem(t);
					break;
				}
			}
			if(attribute.Type==ParsingObjectType.Variable)
				return true;
			ParameterInfo[] pInfo = constructorInfo.GetParameters();
			parameterTypes = new TypeAnalyzerTypeItem[pInfo.Length-1];
			try
			{
				if(pInfo.Length == 2 && pInfo[1].Name == "parameters")
				{
					parameterTypes = null;
					return false;
				}
				for(int i=1;i<pInfo.Length;i++) //0 = Context Parameter
				{
					parameterTypes[i-1] = types.FindItem(pInfo[i].ParameterType);
				}
			}
			catch(ParsingTokenLookupFailedException e)
			{
				parameterTypes = null;
				return false;
			}
			return true;
		}
		int IComparable.CompareTo(object b)
		{
			TypeAnalyzerObjectItem b1 = b as TypeAnalyzerObjectItem;
			if(this.Priority > b1.Priority)
				return(1);
			if(this.Priority < b1.Priority)
				return(-1);
			return(0);
		}
		public override string ToString()
		{
			string tmp1 = string.Format("{0}",attribute.Priority).PadRight(4);
			string tmp2 = attribute.Character.PadRight(15);
			string tmp3 = attribute.Type.ToString().PadRight(14);
			return(string.Format("{0} {1} {2} {3}",tmp1,tmp2,tmp3,type.Name));
		}
	}
	/// <summary>
	/// Math type symbol
	/// </summary>
	public class TypeAnalyzerTypeItem
	{
		Type type;
		ParsingTypeAttribute attribute;
		internal TypeAnalyzerTypeItem(Type type, ParsingTypeAttribute attr)
		{
			this.type = type;
			this.attribute = attr;
		}
		public Type SubType
		{
			get {return(type);}
		}
		public ParsingTypeAttribute SubAttribute
		{
			get {return(attribute);}
		}
		public override string ToString()
		{
			return(string.Format("{0}\t{1}\t{2}",attribute.Type.ToString(),attribute.Dimensions,type.Name));
		}
	}
	/// <summary>
	/// Container for math operator/object symbols
	/// </summary>
	public class TypeAnalyzerObjectCollection: CollectionBase
	{
		public void Add(TypeAnalyzerObjectItem item)
		{
			InnerList.Add(item);
		}
		public void Remove(TypeAnalyzerObjectItem item)
		{
			InnerList.Remove(item);
		}
		public TypeAnalyzerObjectItem this[int index]
		{
			get {return((TypeAnalyzerObjectItem)InnerList[index]);}
		}
		public void ExtendInfo(TypeAnalyzerTypeCollection typeList)
		{
			for(int i=InnerList.Count-1;i>-1;i--)
			{
				if(!((TypeAnalyzerObjectItem)InnerList[i]).ExtendInfo(typeList))
					InnerList.RemoveAt(i);
			}
			ReorderPriority();
		}
		private void ReorderPriority()
		{
			InnerList.Sort();
			for(int i=0;i<InnerList.Count;i++)
			{
				this[i].Priority = this[i].SubAttribute.Priority;  //i+1;
			}
		}
		public TypeAnalyzerObjectItem FindVariableItem(Context context, string var)
		{
			Variable v = context.ContextVariables.GetCreateVariable(var);
			Type t = v.GetType();
			foreach(TypeAnalyzerObjectItem item in this)
			{
				if(item.SubType.Equals(t))
					return(item);
			}
			return null;
		}
		public TypeAnalyzerObjectItem FindItem(ParsingObjectType type)
		{
			foreach(TypeAnalyzerObjectItem item in this)
			{
				if(item.SubAttribute.Type.Equals(type))
					return(item);
			}
			throw(new ParsingTokenLookupFailedException(type.ToString()));
		}
		public TypeAnalyzerObjectItem FindItem(ParsingObjectType type, string character)
		{
			foreach(TypeAnalyzerObjectItem item in this)
			{
				if(item.SubAttribute.Type.Equals(type) && item.SubAttribute.Character.Equals(character))
					return(item);
			}
			throw(new ParsingTokenLookupFailedException(character+" ("+type.ToString()+")"));
		}
		public TypeAnalyzerObjectItem FindItem(ParsingObjectType type, string character, TypeAnalyzerTypeItem[] parameters)
		{
			foreach(TypeAnalyzerObjectItem item in this)
			{
				if(item.SubAttribute.Type.Equals(type) && item.SubAttribute.Character.Equals(character) && parameters.Length.Equals(item.ParameterTypeItems.Length))
				{
					bool isMatch = true;
					for(int i=0;i<item.ParameterTypeItems.Length;i++)
						if(!item.ParameterTypeItems[i].Equals(parameters[i]))
						{
							isMatch = false;
							break;
						}
					if(isMatch)
						return(item);
				}
			}
			throw(new ParsingTokenLookupFailedException(character+" ("+type.ToString()+")"));
		}
		public bool HasItem(ParsingObjectType type, string character, TypeAnalyzerTypeItem[] parameters)
		{
			foreach(TypeAnalyzerObjectItem item in this)
			{
				if(item.SubAttribute.Type.Equals(type) && item.SubAttribute.Character.Equals(character) && parameters.Length.Equals(item.ParameterTypeItems.Length))
				{
					bool isMatch = true;
					for(int i=0;i<item.ParameterTypeItems.Length;i++)
						if(!item.ParameterTypeItems[i].Equals(parameters[i]))
						{
							isMatch = false;
							break;
						}
					if(isMatch)
						return(true);
				}
			}
			return(false);
		}
		public TypeAnalyzerObjectItem FindItem(ParsingObjectType type, TypeAnalyzerTypeItem[] parameters)
		{
			foreach(TypeAnalyzerObjectItem item in this)
			{
				bool isMatch = true;
				if(item.SubAttribute.Type.Equals(type) && parameters.Length.Equals(item.ParameterTypeItems.Length))
				{
					for(int i=0;i<item.ParameterTypeItems.Length;i++)
						if(!item.ParameterTypeItems[i].Equals(parameters[i]))
						{
							isMatch = false;
							break;
						}
					if(isMatch)
						return(item);
				}
				if((type.Equals(ParsingObjectType.List) || type.Equals(ParsingObjectType.Vector)) && item.SubAttribute.Type.Equals(type) && parameters.Length > 0 && item.ParameterTypeItems.Length>0)
					if(item.ParameterTypeItems[0].Equals(parameters[0]) && item.ReturnTypeItem.SubAttribute.Dimensions == parameters.Length)
						return(item);
			}
			if(parameters.Length > 0 && (type.Equals(ParsingObjectType.List) || type.Equals(ParsingObjectType.Vector)))
				foreach(TypeAnalyzerObjectItem item in this)
					if(item.SubAttribute.Type.Equals(type) && item.ReturnTypeItem.SubAttribute.Dimensions == 0 && item.ParameterTypeItems[0].Equals(parameters[0]))
						return(item);
			throw(new ParsingTokenLookupFailedException(type.ToString()));
		}
		public TypeAnalyzerObjectCollection Filter(ParsingObjectType type)
		{
			TypeAnalyzerObjectCollection tmp = new TypeAnalyzerObjectCollection();
			foreach(TypeAnalyzerObjectItem item in InnerList)
			{
				if(item.SubAttribute.Type == type)
					tmp.Add(item);
			}
			tmp.ReorderPriority();
			return(tmp);
		}
		public TypeAnalyzerObjectCollection Filter(ParsingObjectType type, int priority)
		{
			TypeAnalyzerObjectCollection tmp = new TypeAnalyzerObjectCollection();
			foreach(TypeAnalyzerObjectItem item in InnerList)
			{
				if(item.SubAttribute.Type == type && item.SubAttribute.Priority == priority)
					tmp.Add(item);
			}
			tmp.ReorderPriority();
			return(tmp);
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			foreach(TypeAnalyzerObjectItem item in InnerList)
			{
				sb.Append(item.ToString());
				sb.Append("\n");
			}
			return(sb.ToString());
		}
	}
	/// <summary>
	/// Container for math type symbols
	/// </summary>
	public class TypeAnalyzerTypeCollection: CollectionBase
	{
		public void Add(TypeAnalyzerTypeItem item)
		{
			InnerList.Add(item);
		}
		public void Remove(TypeAnalyzerTypeItem item)
		{
			InnerList.Remove(item);
		}
		public TypeAnalyzerTypeItem this[int index]
		{
			get {return((TypeAnalyzerTypeItem)InnerList[index]);}
		}
		public TypeAnalyzerTypeItem FindItem(ParsingExpressionType type, int dimension)
		{
			foreach(TypeAnalyzerTypeItem item in this)
			{
				if(item.SubAttribute.Type.Equals(type) && item.SubAttribute.Dimensions.Equals(dimension))
					return(item);
			}
			throw(new ParsingTokenLookupFailedException(type.ToString()+dimension.ToString()));
		}
		public TypeAnalyzerTypeItem FindItem(Type interfaceType)
		{
			if(interfaceType.IsArray)
			{
				string name = interfaceType.FullName;
				int pos = name.Length-2;
				if(name[pos] != '[')
					throw(new ParsingTokenLookupFailedException(interfaceType.ToString()));
				interfaceType = interfaceType.Assembly.GetType(name.Substring(0,pos));
			}
			foreach(TypeAnalyzerTypeItem item in this)
			{
				if(item.SubType.Equals(interfaceType))
					return(item);
			}
			throw(new ParsingTokenLookupFailedException(interfaceType.ToString()));
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			foreach(TypeAnalyzerTypeItem item in InnerList)
			{
				sb.Append(item.ToString());
				sb.Append("\n");
			}
			return(sb.ToString());
		}
	}
	/// <summary>
	/// The 'TypeAnalyzer' class scans Math.NET and any
	/// given third party extention assembly for compatible
	/// math operators, objects and types and manages the
	/// internal symbol table.
	/// </summary>
	public class TypeAnalyzer
	{
		TypeAnalyzerTypeCollection typeList;
		TypeAnalyzerObjectCollection objectList;
		ArrayList opsInner, opsOuter, opsPre, opsRelat, opsFunc;
		ArrayList assemblies;
		bool init;
		Context context;
		internal TypeAnalyzer(Context context)
		{
			this.context = context;
			init = false;
			assemblies = new ArrayList();
			typeList = new TypeAnalyzerTypeCollection();
			objectList = new TypeAnalyzerObjectCollection();
			opsInner = new ArrayList();
			opsOuter = new ArrayList();
			opsPre = new ArrayList();
			opsRelat = new ArrayList();
			opsFunc = new ArrayList();			
		}
		public Context Context
		{
			get {return context;}
		}
		public void AddExternalAssembly(Assembly a)
		{
			init = false;
			assemblies.Add(a);
		}
		public void AddExternalAssembly(string path)
		{
			init = false;
			assemblies.Add(Assembly.LoadFrom(path));
		}
		public void InitParser()
		{
			if(init)
				return;
			ConversionMap.ResetMapTable();
			objectList.Clear();
			typeList.Clear();
			opsInner.Clear();
			opsOuter.Clear();
			opsPre.Clear();
			opsRelat.Clear();
			opsFunc.Clear();
			AnalyzeAssembly(Assembly.GetExecutingAssembly());
			foreach(Assembly a in assemblies)
				AnalyzeAssembly(a);
			objectList.ExtendInfo(typeList);
			init = true;
		}
		private void AnalyzeAssembly(Assembly a)
		{
			foreach(Type t in a.GetTypes())
				AnalyzeType(t);
		}
		private void AnalyzeType(Type t)
		{
			if(t.IsClass)
			{
				object[] poas = t.GetCustomAttributes(typeof(ParsingObjectAttribute),false);
				if(poas.Length != 0)
				{
					ParsingObjectAttribute poa = poas[0] as ParsingObjectAttribute;
					ConstructorInfo[] cInfo = t.GetConstructors();
					for(int i=0;i<cInfo.Length;i++)
						objectList.Add(new TypeAnalyzerObjectItem(t,poa,cInfo[i]));
					switch(poa.Type)
					{
						case ParsingObjectType.InnerOperator:
							opsInner.Add(poa.Character);
							break;
						case ParsingObjectType.OuterOperator:
							opsOuter.Add(poa.Character);
							break;
						case ParsingObjectType.PreOperator:
							opsPre.Add(poa.Character);
							break;
						case ParsingObjectType.Relation:
							opsRelat.Add(poa.Character);
							break;
						case ParsingObjectType.Function:
							opsFunc.Add(poa.Character);
							break;
					}
				}
				object[] cmeas = t.GetCustomAttributes(typeof(ConversionMapEntryAttribute),false);
				if(cmeas.Length > 0)
				{
					ConversionMapEntryAttribute cmea = cmeas[0] as ConversionMapEntryAttribute;
					for(int i=0;i<cmea.BaseTypes.Length;i++)
						ConversionMap.AddMapEntry((ConversionMapEntry)t.GetConstructor(new Type[] {}).Invoke(new object[] {}),cmea.BaseTypes[i],cmea.ConversionType);
				}
			}
			if(t.IsInterface)
			{
				object[] ptas = t.GetCustomAttributes(typeof(ParsingTypeAttribute),false);
				if(ptas.Length != 0)
				{
					ParsingTypeAttribute pta = ptas[0] as ParsingTypeAttribute;
					typeList.Add(new TypeAnalyzerTypeItem(t,pta));
				}
			}
		}
		public bool IsInit
		{
			get {return(init);}
		}
		public TypeAnalyzerObjectCollection ObjectList
		{
			get {return(objectList);}
		}
		public TypeAnalyzerTypeCollection TypeList
		{
			get {return(typeList);}
		}
		public ArrayList InnerOperators
		{
			get {return(opsInner);}
		}
		public ArrayList OuterOperators
		{
			get {return(opsOuter);}
		}
		public ArrayList PreOperators
		{
			get {return(opsPre);}
		}
		public ArrayList Relations
		{
			get {return(opsRelat);}
		}
		public ArrayList Functions
		{
			get {return(opsFunc);}
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("*** TYPE LIST ***\n");
			sb.Append(typeList.ToString());
			sb.Append("\n*** OBJECT LIST ***\n");
			sb.Append(objectList.ToString());
			return(sb.ToString());
		}
	}
}
