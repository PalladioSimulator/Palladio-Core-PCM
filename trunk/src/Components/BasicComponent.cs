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
			ISignatureList result = (ISignatureList) serviceEffectMap[aSig];
			if (result == null)
				throw new SignatureNotFoundException(aSig);
			return result;
		}

		/// <summary>
		/// Changes the service effect specification of aService.Signature to aService.EffectSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aService">Service associating a signature with a service effect specification.</param>
		public void ChangeServiceEffectSpecification(IServiceEffectMapping aServiceEffectMapping)
		{																																									 
			ChangeServiceEffectSpecification(aServiceEffectMapping.Signature, aServiceEffectMapping.EffectSpec);
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
			CheckServiceEffect(aServEffSpec);
			serviceEffectMap[aSignature] = aServEffSpec;
		}

		public void AddProvidesInterface(ISignatureList aProvInterface, params IServiceEffectMapping[] aServiceArray)
		{
			// check preconditions
			if(aProvInterface == null)
				throw new NullNotAllowedException();

			if ((aProvInterface.RoleID == null) || (aProvInterface.RoleID == ""))
				throw new MissingRoleIDException();

			// no other interface with the roleID of aProvInterface must exist.
			if (HasProvidesInterface(aProvInterface.RoleID))
				throw new RoleIDAlreadySpecifiedException(aProvInterface.RoleID);

			// each signature has a service effect specification.
			Hashmap srvMap = new Hashmap();
			foreach (IServiceEffectMapping srv in aServiceArray)
			{
				srvMap.Add(srv.Signature,srv.EffectSpec);
			}
			foreach (ISignature sig in aProvInterface.Signatures)
			{
				if (srvMap[sig] == null)
					throw new SignatureHasNoServEffSpecException(sig);
			}
			
			// each RequiresInterface needed by a service effect specification exists.
			foreach (ISignatureList sigList in srvMap.Values)
			{
				CheckServiceEffect(sigList);
			}


			foreach( DictionaryEntry e in srvMap )
			{
				serviceEffectMap.Add(e.Key,e.Value);
			}
			providesMap.Add( aProvInterface.RoleID, aProvInterface );
		}

		public void DeleteProvidesInterfaces(params ISignatureList[] aProvArray)
		{
			foreach (ISignatureList sigList in aProvArray)
			{
				foreach (ISignature sig in sigList.Signatures)
				{
					serviceEffectMap.Remove(sig);
				}
				providesMap.Remove(sigList.RoleID);
			}
		}

		public void DeleteProvidesInterfaces(params string[] aProvRoleArray)
		{
			foreach( string roleID in aProvRoleArray )
			{
				DeleteProvidesInterfaces( GetProvidesInterface(roleID) );
			}
		}

		public void AddRequiresInterfaces(params ISignatureList[] aReqArray)
		{
			//check preconditions
			if (ArrayIsNull(aReqArray))
				throw new NullNotAllowedException();

			foreach (ISignatureList sigList in aReqArray)
			{
				if ((sigList.RoleID == null) || (sigList.RoleID == ""))
					throw new MissingRoleIDException();

				if (requiresMap.Contains(sigList.RoleID))
					throw new RoleIDAlreadySpecifiedException(sigList.RoleID);
			}

			foreach (ISignatureList sigList in aReqArray)
			{
				requiresMap.Add(sigList.RoleID,sigList);
			}
		}

		public void DeleteRequiresInterfaces(params ISignatureList[] aReqArray)
		{
			foreach (ISignatureList sigList in aReqArray)
			{
				DeleteRequiresInterfaces(sigList.RoleID);
			}
		}

		public void DeleteRequiresInterfaces(params string[] aReqRoleArray)
		{
			foreach (string roleID in aReqRoleArray)
			{
				requiresMap.Remove(roleID);
			}
		}
		public override bool Equals(object obj)
		{
			if (!(obj is BasicComponent)) return false;
			if ((object)this == obj) return true;
			if (!base.Equals (obj)) return false;
			BasicComponent cmp = (BasicComponent) obj;
			return serviceEffectMap.Equals(cmp.serviceEffectMap);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode ();
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

		private void CheckServiceEffect(ISignatureList aServEffSpec)
		{
			foreach (ISignature sig in aServEffSpec.Signatures)
			{
				try 
				{
					if (!GetRequiresInterface(sig.RoleID).ContainsSignature(sig))
						throw new MissingRequirementException(sig);
				}
				catch (RoleIDNotFoundException)
				{
					throw new MissingRequirementException(sig);
				}
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		public BasicComponent(IAttributeHash anAttHash) : base (anAttHash)
		{
			serviceEffectMap = new Hashmap();
		}

		public BasicComponent(BasicComponent anotherComponent) : base(anotherComponent)
		{
			serviceEffectMap = anotherComponent.serviceEffectMap.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key: ISignature
		/// value: ISignatureList
		/// </summary>
		private Hashmap serviceEffectMap;
														
		#endregion
	}
}