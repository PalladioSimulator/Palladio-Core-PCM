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
	internal class BasicComponent : AbstractComponent, IBasicComponent 
	{
		#region Methods

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

		public override bool Equals(object obj)
		{
			if (!(obj is BasicComponent)) return false;
			if ((object)this == obj) return true;
			if (!base.Equals (obj)) return false;
			BasicComponent cmp = (BasicComponent) obj;
			return (serviceEffectTable != null ? serviceEffectTable.Equals(cmp.serviceEffectTable) : cmp.serviceEffectTable == null);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode () ^ (serviceEffectTable != null ? serviceEffectTable.GetHashCode() : 0 );
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
		public override object Clone()
		{
			return new BasicComponent(this);
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		public BasicComponent(IAttributeHash anAttHash) : base (anAttHash)
		{
			serviceEffectTable = new Hashtable();
		}

		public BasicComponent(BasicComponent anotherComponent) : base(anotherComponent)
		{
			serviceEffectTable = new Hashtable();
			foreach (DictionaryEntry e in anotherComponent.serviceEffectTable)
			{
				ISignatureList seff = (ISignatureList) ((ISignatureList) e.Value).Clone();
				ISignature	   sig  = (ISignature)		 ((ISignature)		 e.Key).Clone();
				requiresTable.Add( sig, seff );
			}
		}

		#endregion

		#region Data

		/// <summary>
		/// key: ISignature
		/// value: ISignatureList
		/// </summary>
		private Hashtable serviceEffectTable;

		#endregion
	}
}