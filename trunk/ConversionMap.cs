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
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Core
{
	[AttributeUsage(AttributeTargets.Class)]
	public class ConversionMapEntryAttribute: System.Attribute
	{
		string ctype;
		Type[] btype;
		public ConversionMapEntryAttribute(Type baseType, string conversionType)
		{
			this.ctype = conversionType;
			this.btype = new Type[] {baseType};
		}
		public ConversionMapEntryAttribute(Type[] baseTypes, string conversionType)
		{
			this.ctype = conversionType;
			this.btype = baseTypes;
		}
		public string ConversionType
		{
			get {return(ctype);}
		}
		public Type[] BaseTypes
		{
			get {return(btype);}
		}
	}
	public class ConversionMap
	{
		private struct ConversionMapEntryKey
		{
			public string BaseType;
			public string ConversionType;
			public ConversionMapEntryKey(string baseType, string conversionType)
			{
				BaseType = baseType;
				ConversionType = conversionType;
			}
		}
		private static Hashtable mapTable;
		public static void InitMapTable()
		{
			if(mapTable == null)
				mapTable = new Hashtable();
		}
		public static void ResetMapTable()
		{
			InitMapTable();
			mapTable.Clear();
		}
		public static void AddMapEntry(ConversionMapEntry entry, Type baseType, string conversionType)
		{
			ConversionMapEntryKey key = new ConversionMapEntryKey(baseType.FullName,conversionType);
			InitMapTable();
			ArrayList al;
			if(mapTable.Contains(key))
				al = (ArrayList)mapTable[key];
			else
				al = new ArrayList();
			al.Add(entry);
			mapTable[key] = al;
		}
		public static ArrayList GetMapEntryList(Type baseType, string conversionType)
		{
			ConversionMapEntryKey key = new ConversionMapEntryKey(baseType.FullName,conversionType);
			InitMapTable();
			if(mapTable.Contains(key))
				return((ArrayList)mapTable[key]);
			else
				return(new ArrayList());
		}
		public static void Convert(ref IExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(ConversionMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	public abstract class ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IExpression exp);
	}
}
