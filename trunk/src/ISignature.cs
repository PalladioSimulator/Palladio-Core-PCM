using System;
using System.Reflection;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface ISignature	: ICloneable
	{
		#region Properties

		MethodAttributes Attributes { get; }

		CallingConventions CallingConvention { get; }

		string Name { get; }

		Type ReturnType { get; }

		bool IsAbstract { get; }

		bool IsConstructor { get; }

		bool IsAssembly { get; }

		bool IsFamily { get; }

		bool IsFamilyAndAssembly { get; }
		
		bool IsFamilyOrAssembly { get; }

		bool IsFinal { get; }

		bool IsHideBySig { get; }

		bool IsPrivate { get; }

		bool IsPublic { get; }

		bool IsStatic { get; }

		bool IsVirtual { get; }

		#endregion

		#region Methods

		ParameterInfo[] GetParameters(); 

		bool Match( ISignature aSig );

		bool MatchContraVariant( ISignature aSig );

		bool HasMatches(IList aSigList);

		bool HasMatches(IList aSigList, out IList aMatchList);

		bool HasOneMatch(IList aSigList);

		bool HasOneMatch(IList aSigList, out ISignature aMatch);
		
		#endregion
	}
}
