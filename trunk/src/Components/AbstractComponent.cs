using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;

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
				ISignatureList[] result =  new ISignatureList[providesTable.Values.Count];
				providesTable.Values.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		public ISignatureList[] RequiresInterface { 
			get
			{
				ISignatureList[] result =  new ISignatureList[requiresTable.Values.Count];
				requiresTable.Values.CopyTo(result,0);
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
			ISignatureList result = (ISignatureList) providesTable[aRoleID];
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
			ISignatureList result = (ISignatureList) requiresTable[aRoleID];
			if (result == null)
				throw new RoleIDNotFoundException(aRoleID);
			return result;
		}

		public bool HasProvidesInterface(string aRoleID)
		{
			return (providesTable[aRoleID] != null);
		}
		
		public bool HasRequiresInterface(string aRoleID)
		{
			return (requiresTable[aRoleID] != null);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is AbstractComponent)) return false;
			if ((object)this == obj) return true;
			AbstractComponent cmp = (AbstractComponent)obj;
			return (
				( providesTable != null ? providesTable.Equals(cmp.providesTable) : cmp.providesTable == null) &&
				( requiresTable != null ? requiresTable.Equals(cmp.requiresTable) : cmp.requiresTable == null)
			);
		}

		public override int GetHashCode()
		{
			return (
				( providesTable != null ? providesTable.GetHashCode() : 0) ^
				( requiresTable != null ? requiresTable.GetHashCode() : 0)
				);
		}



		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		public AbstractComponent(IAttributeHash anAttHash)
		{
			providesTable = new Hashtable();
			requiresTable = new Hashtable();
			attributes = anAttHash;
		}

		public AbstractComponent(AbstractComponent anotherComponent)
		{
			providesTable = new Hashtable();
			requiresTable = new Hashtable();
			foreach (DictionaryEntry e in anotherComponent.providesTable)
			{
				ISignatureList prov = (ISignatureList) ((ISignatureList) e.Value).Clone();
				providesTable.Add( prov.RoleID, prov );
			}
			foreach (DictionaryEntry e in anotherComponent.requiresTable)
			{
				ISignatureList req = (ISignatureList) ((ISignatureList) e.Value).Clone();
				requiresTable.Add( req.RoleID, req );
			}
			attributes = (IAttributeHash)anotherComponent.attributes.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key: string holding the roleID
		/// value: ISignatureList
		/// </summary>
		protected Hashtable providesTable;
		/// <summary>
		/// key: string holding the roleID
		/// value: ISignatureList
		/// </summary>
		protected Hashtable requiresTable;

		private IAttributeHash attributes;

		#endregion
	}
}