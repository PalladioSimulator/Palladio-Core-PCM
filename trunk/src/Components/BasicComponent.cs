using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.TypedCollections;
using Palladio.Identifier;

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
		public IServiceEffectSpecification GetServiceEffectSpecification(ISignatureWithRole aSig)
		{
			IRole aRole;
			if ((aRole = providesMap[aSig.RoleID]) == null)
				throw new RoleIDNotFoundException(aSig.RoleID.ToString());
			if (!aRole.Interface.SignatureList.ContainsSignature(aSig.Signature))
				throw new SignatureNotFoundException(aSig.Signature);
			if (!serviceEffectMap.Contains(aSig))
				throw new SignatureHasNoServEffSpecException(aSig.Signature);
			return serviceEffectMap[aSig];
		}

		/// <summary>
		/// Get the service effect specification associated with aSig.
		/// </summary>
		/// <param name="aSig">The service to which an service effect is affected</param>
		/// <param name="aRoleID">Role of the signature</param>
		/// <returns>The service effect specification of aSig in role aRole.</returns>
		public IServiceEffectSpecification GetServiceEffectSpecification(IIdentifier aRoleID, ISignature aSig)
		{
			return GetServiceEffectSpecification(ComponentFactory.CreateSignatureWithRole(aRoleID,aSig));
		}

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature">The service and its role to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		public void ChangeServiceEffectSpecification(ISignatureWithRole aSignature, IServiceEffectSpecification aServEffSpec)
		{
			GetServiceEffectSpecification(aSignature);
			serviceEffectMap[aSignature] = aServEffSpec;
		}

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature">The service to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		/// <param name="aRoleID">Role of the signature</param>
		public void ChangeServiceEffectSpecification(IIdentifier aRoleID, ISignature aSignature, IServiceEffectSpecification aServEffSpec)
		{
			ChangeServiceEffectSpecification(ComponentFactory.CreateSignatureWithRole(aRoleID,aSignature),aServEffSpec);
		}

		/// <summary>
		/// Add the service effect specification of aSignature to aServEffSpec.
		/// </summary>
		/// <param name="aSignature">The service to which an service effect gets added</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		public void AddServiceEffectSpecification(ISignatureWithRole aSignature, IServiceEffectSpecification aServEffSpec)
		{
			if (aSignature == null || aServEffSpec == null)
				throw new ArgumentNullException("Signature and service effect can't be null!");
			if (serviceEffectMap.Contains(aSignature))
				throw new ServiceEffectAlreadySpecifiedException(aSignature.Signature);
			if (!providesMap.Contains(aSignature.RoleID))
				throw new RoleIDNotFoundException(aSignature.RoleID.ToString());
			if (!providesMap[aSignature.RoleID].Interface.SignatureList.ContainsSignature(aSignature.Signature))
				throw new SignatureNotFoundException(aSignature.Signature);
			serviceEffectMap.Add(aSignature,aServEffSpec);
		}

		/// <summary>
		/// Add the service effect specification of aSignature to aServEffSpec.
		/// </summary>
		/// <param name="aSignature">The service to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		/// <param name="aRoleID">Role of the signature</param>
		public void AddServiceEffectSpecification(IIdentifier aRoleID, ISignature aSignature, IServiceEffectSpecification aServEffSpec)
		{
			AddServiceEffectSpecification(ComponentFactory.CreateSignatureWithRole(aRoleID,aSignature),aServEffSpec);
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
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new BasicComponent(this);
		}

		public void DeleteServiceEffectSpecification(params ISignatureWithRole[] signatures)
		{
			foreach (ISignatureWithRole sr in signatures)
			{
				if (sr == null)
					throw new ArgumentNullException("Signature can't be null!");
				if (!serviceEffectMap.Contains(sr))
					throw new SignatureNotFoundException(sr.Signature);
			}
			foreach (ISignatureWithRole sr in signatures)
			{
				serviceEffectMap.Remove(sr);
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		/// <param name="id">ID of the component</param>
		public BasicComponent(IAttributeHash anAttHash, IIdentifier id) : base (anAttHash,id)
		{
			serviceEffectMap = new ServiceEffectHashmap();
		}

		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="anotherComponent">The basic component to copy.</param>
		public BasicComponent(BasicComponent anotherComponent) : base(anotherComponent)
		{
			serviceEffectMap = (ServiceEffectHashmap)anotherComponent.serviceEffectMap.Clone();
		}

		#endregion

		#region Data
		private ServiceEffectHashmap serviceEffectMap;
														
		#endregion
	}
}