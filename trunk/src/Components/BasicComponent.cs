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
	/// Provides and RequiresInterfaces which can be adapted to
	/// its environment.
	/// </summary>
	internal class BasicComponent : IBasicComponent 
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
		public ISignatureList[] RequiresInterfaces { 
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

		/// <summary>
		/// Get the service effect specification associated with aSig.
		/// </summary>
		/// <param name="aSig">A signature provided in a role of this component.</param>
		/// <returns>The service effect specification of aSig.</returns>
		public ISignatureList GetServiceEffectSpecification(ISignature aSig)
		{
			ISignatureList result = (ISignatureList) serviceEffectTable[aSig];
			if (result == null)
				throw new SignatureNotFoundException(aSig);
			return result;
		}

		/// <summary>
		/// Changes the service effect specification of aService.Signature to aService.EffectSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aService">Service associating a signature with a service effect specification.</param>
		public void ChangeServiceEffectSpecification(IService aService)
		{
			ChangeServiceEffectSpecification(aService.Signature, aService.EffectSpec);
		}

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature"></param>
		/// <param name="aServEffSpec"></param>
		public void ChangeServiceEffectSpecification(ISignature aSignature, ISignatureList aServEffSpec)
		{
			GetServiceEffectSpecification(aSignature);
			serviceEffectTable[aSignature] = aServEffSpec;
		}

		public void AddProvidesInterface(ISignatureList aProvInterface, params IService[] aServiceArray)
		{
			Hashtable srvTable = new Hashtable();
			foreach (IService srv in aServiceArray)
			{
				srvTable.Add(srv.Signature,srv.EffectSpec);
			}
			foreach (ISignature sig in aProvInterface.Signatures)
			{
				if (srvTable[sig] == null)
					throw new SignatureHasNoServEffSpec(sig);
			}
			foreach( DictionaryEntry e in srvTable )
			{
				serviceEffectTable.Add(e.Key,e.Value);
			}
			providesTable.Add( aProvInterface.RoleID, aProvInterface );
		}

		public void DeleteProvidesInterfaces(params ISignatureList[] aProvArray)
		{
			foreach (ISignatureList sigList in aProvArray)
			{
				foreach (ISignature sig in sigList.Signatures)
				{
					serviceEffectTable.Remove(sig);
				}
				providesTable.Remove(sigList.RoleID);
			}
		}

		public void AddRequiresInterfaces(params ISignatureList[] aReqArray)
		{
			foreach (ISignatureList sigList in aReqArray)
			{
				requiresTable.Add(sigList.RoleID,sigList);
			}
		}

		public void DeleteRequiresInterfaces(params ISignatureList[] aReqArray)
		{
			foreach (ISignatureList sigList in aReqArray)
			{
				requiresTable.Remove(sigList.RoleID);
			}
		}

		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor)
		{
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new BasicComponent(this);
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		public BasicComponent(IAttributeHash anAttHash)
		{
			providesTable = new Hashtable();
			requiresTable = new Hashtable();
			serviceEffectTable = new Hashtable();
			attributes = anAttHash;
		}

		public BasicComponent(BasicComponent anotherComponent)
		{
			providesTable = new Hashtable();
			requiresTable = new Hashtable();
			serviceEffectTable = new Hashtable();
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
			foreach (DictionaryEntry e in anotherComponent.serviceEffectTable)
			{
				ISignatureList seff = (ISignatureList) ((ISignatureList) e.Value).Clone();
				ISignature	   sig  = (ISignature)		 ((ISignature)		 e.Key).Clone();
				requiresTable.Add( sig, seff );
			}
			attributes = (IAttributeHash)anotherComponent.attributes.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key: string holding the roleID
		/// value: ISignatureList
		/// </summary>
		private Hashtable providesTable;
		/// <summary>
		/// key: string holding the roleID
		/// value: ISignatureList
		/// </summary>
		private Hashtable requiresTable;
		/// <summary>
		/// key: ISignature
		/// value: ISignatureList
		/// </summary>
		private Hashtable serviceEffectTable;

		private IAttributeHash attributes;

		#endregion
	}
}