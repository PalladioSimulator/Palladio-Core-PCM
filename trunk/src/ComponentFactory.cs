using System;
using Palladio.Attributes;
using Palladio.ComponentModel.Signature;

namespace Palladio.ComponentModel
{
	
	
	/// <summary>
	/// TODO - Add class summary
	/// </summary>
	/// <remarks>
	/// 	created by - sliver
	/// 	created on - 17.05.2004 20:30:05
	/// </remarks>
	public class ComponentFactory : object
	{
		public static ISignature CreateSignature( IAttributeHash anAttributeHash, string aRoleID, IType aReturnType, string aName, IParameter[] aParamArray, params IType[] anExceptionArray)
		{
			return new MethodSignature(anAttributeHash, aRoleID, aReturnType, aName, aParamArray, anExceptionArray);
		}
		
		public static ISignature CreateSignature( string aRoleID, IType aReturnType, string aName, IParameter[] aParamArray, params IType[] anExceptionArray)
		{
			return new MethodSignature( attributesFactory.Default.CreateAttributeHash(), aRoleID, aReturnType, aName, aParamArray, anExceptionArray);
		}

		public static ISignature CreateSignature( string aRoleID, string aName, params IParameter[] aParamArray )
		{
			return new MethodSignature(attributesFactory.Default.CreateAttributeHash(), aRoleID, new ReflectedType(typeof(void)), aName, aParamArray, new IType[0]);
		}
		
		private static AttributesFactory attributesFactory = new AttributesFactory();
	}
}
