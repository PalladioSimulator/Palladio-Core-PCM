using System;
using System.Reflection;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Signature of a service.
	/// </summary>
	public class MethodSignature : ISignature
	{

		#region Data

		private MethodInfo info;
		#endregion


		#region Properties

		MethodInfo Info
		{
			get { return info; }
		}

		public MethodAttributes Attributes
		{
			get { return Info.Attributes; }
		}

		public CallingConventions CallingConvention
		{
			get
			{
				return Info.CallingConvention;
			}
		}

		public string Name
		{
			get
			{
				return Info.Name;
			}
		}

		public Type ReturnType
		{
			get
			{
				return Info.ReturnType;
			}
		}

		public bool IsAbstract
		{
			get
			{
				return Info.IsAbstract;
			}
		}

		public bool IsConstructor
		{
			get
			{
				return Info.IsConstructor;
			}
		}

		public bool IsAssembly
		{
			get
			{
				return Info.IsAssembly;
			}
		}

		public bool IsFamily
		{
			get
			{
				return Info.IsFamily;
			}
		}

		public bool IsFamilyAndAssembly
		{
			get
			{
				return Info.IsFamilyAndAssembly;
			}
		}

		public bool IsFamilyOrAssembly
		{
			get
			{
				return Info.IsFamilyOrAssembly;
			}
		}

		public bool IsFinal
		{
			get
			{
				return Info.IsFinal;
			}
		}

		public bool IsHideBySig
		{
			get
			{
				return Info.IsHideBySig;
			}
		}

		public bool IsPrivate
		{
			get
			{
				return Info.IsPrivate;
			}
		}

		public bool IsPublic
		{
			get
			{
				return Info.IsPublic;
			}
		}

		public bool IsStatic
		{
			get
			{
				return Info.IsStatic;
			}
		}

		public bool IsVirtual
		{
			get
			{
				return Info.IsVirtual;
			}
		}

		# endregion


		#region Methods

		public ParameterInfo[] GetParameters()
		{
			return Info.GetParameters();
		}

		public bool Match(ISignature aSig)
		{
			ArrayList parList = new ArrayList( aSig.GetParameters() );

			foreach (ParameterInfo parInf in GetParameters()) 
			{
				if (!parList.Contains(parInf)) return false;
			}

			return (
				(aSig.Attributes == Attributes) &&
				(aSig.CallingConvention == CallingConvention) &&
				(aSig.Name == Name) &&
				(aSig.ReturnType.Equals(ReturnType))
				);
		}

		public bool HasMatches(IList aSigList, out IList aMatchList)
		{
			aMatchList = new ArrayList();
			foreach (ISignature sig in aSigList) 
			{
				if (this.Match(sig)) 
				{
					aMatchList.Add(sig);
				}
			}
			return (aMatchList.Count == 0);
		}

		public bool HasMatches(IList aSigList)
		{
			IList matchList;
			return HasMatches(aSigList, out matchList);
		}

		public bool HasOneMatch(IList aSigList)
		{
			ISignature match;
			return HasOneMatch(aSigList, out match);
		}

		public bool HasOneMatch(IList aSigList, out ISignature aMatch)
		{
			aMatch = null;
			IList matchList;
			if (HasMatches(aSigList, out matchList) && (matchList.Count == 1))
			{
				aMatch = (ISignature) matchList[0];
				return true;
			}
			return false;
		}

		public bool MatchContraVariant(ISignature aSig)
		{
			return false;
		}

		public object Clone() 
		{
			return new MethodSignature(this);
		}

		#endregion


		#region Constructors

		public MethodSignature( MethodInfo anInfo ) 
		{
			info = anInfo;
		}

		public MethodSignature( MethodSignature aSig ) : this (aSig.Info) {}

		#endregion
	}
}
