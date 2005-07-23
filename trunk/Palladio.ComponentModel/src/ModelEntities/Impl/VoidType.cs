using System;
using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// This is the implementation of IType that represents an void type. It is used as void
	/// return type by a signature.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/23 18:58:18  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class VoidType : IType
	{	
		//the id of the type
		public static ITypeIdentifier TYPEID = new InternalEntityIdentifier("F483360F-FBB9-4258-A381-2CD62C05CD30");

		/// <summary>
		/// returns the id of the type. This id is unique for an implementation of IType.
		/// </summary>
		public ITypeIdentifier TypeID
		{
			get
			{
				return VoidType.TYPEID;
			}
		}

		/// <summary>
		/// returns the name of the type
		/// </summary>
		public string Name
		{
			get
			{
				return "System.void";
			}
		}
	}
}
