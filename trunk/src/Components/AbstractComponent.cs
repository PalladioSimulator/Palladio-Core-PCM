using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Collections;

namespace Palladio.ComponentModel.Components 
{

	/// <summary>
	/// Default Component class. A component consits of a set of
	/// Provides and RequiresInterface which can be adapted to
	/// its environment.
	/// </summary>
	internal abstract class AbstractComponent : IComponent 
	{
		#region Properties

		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		public ISignatureList[] ProvidesInterfaces 
		{ 
			get 
			{
				ISignatureList[] result =  new ISignatureList[providesMap.Values.Count];
				providesMap.Values.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		public ISignatureList[] RequiresInterfaces { 
			get
			{
				ISignatureList[] result =  new ISignatureList[requiresMap.Values.Count];
				requiresMap.Values.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// A list of attributes attached this component. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();
			
		/// <summary>
		/// Get the ProvidesInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The ProvidesInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		public ISignatureList GetProvidesInterface(string aRoleID)
		{
			ISignatureList result = (ISignatureList) providesMap[aRoleID];
			if (result == null)
				throw new RoleIDNotFoundException(aRoleID);
			return result;
		}
		
		/// <summary>
		/// Get the RequiresInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The RequiresInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		public ISignatureList GetRequiresInterface(string aRoleID)
		{
			ISignatureList result = (ISignatureList) requiresMap[aRoleID];
			if (result == null)
				throw new RoleIDNotFoundException(aRoleID);
			return result;
		}

		public bool HasProvidesInterface(string aRoleID)
		{
			return (aRoleID != null ? providesMap[aRoleID] != null : false);
		}
		
		public bool HasRequiresInterface(string aRoleID)
		{
			return (aRoleID != null ? requiresMap[aRoleID] != null : false);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is AbstractComponent)) return false;
			if ((object)this == obj) return true;
			AbstractComponent cmp = (AbstractComponent)obj;
			return (
				providesMap.Equals(cmp.providesMap) &&
				requiresMap.Equals(cmp.requiresMap)
				);
		}

		public override int GetHashCode()
		{
			return providesMap.GetHashCode() ^ requiresMap.GetHashCode();
		}


		protected bool ArrayIsNull(Array anArray)
		{
			if (anArray == null)
				return true;

			foreach( object o in anArray )
			{
				if (o == null)
					return true;
			}
			return false;
		}



		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		public AbstractComponent(IAttributeHash anAttHash)
		{
			providesMap = new Hashmap();
			requiresMap = new Hashmap();
			attributes = anAttHash;
		}

		public AbstractComponent(AbstractComponent anotherComponent)
		{
			requiresMap = anotherComponent.requiresMap.Clone();
			providesMap = anotherComponent.providesMap.Clone();
			attributes = (IAttributeHash)anotherComponent.attributes.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key: string holding the roleID
		/// value: ISignatureList
		/// </summary>
		protected Hashmap providesMap;
		/// <summary>
		/// key: string holding the roleID
		/// value: ISignatureList
		/// </summary>
		protected Hashmap requiresMap;

		private IAttributeHash attributes;

		#endregion
	}
}