using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.ComponentModel.Exceptions;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Components 
{
	/// <summary>
	/// Default Component class. A component consits of a set of
	/// Provides and RequiresInterface which can be adapted to
	/// its environment.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.2  2005/02/21 15:37:44  joemal
	/// replace keyword as with real typcast
	///
	/// Revision 1.1  2005/02/21 13:52:55  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class BasicComponent : AbstractComponent, IBasicComponent 
	{
		#region Methods
		/// <summary>
		/// Get the service effect specification which belongs to the given service.
		/// </summary>
		/// <param name="aService">the service provided by a role of this component.</param>
		/// <returns>The service effect specification of aService.</returns>
		public IServiceEffectSpecification GetServiceEffectSpecification(IService aService)
		{
			IRole aRole = GetProvidesRoleByInterfaceID(aService.Interface.ID);
			if (aRole == null)
				throw new RoleIDNotFoundException(aService.Interface.ID);
			if (!aRole.Interface.SignatureList.ContainsSignatureID(aService.Signature.ID))
				throw new SignatureNotFoundException(aService.Signature.ID);
			if (!serviceEffectMap.Contains(aService.ID))
				throw new ServiceHasNoServEffSpecException(aService);
			return (IServiceEffectSpecification)serviceEffectMap[aService.ID];
		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public IService[] GetServicesWithServiceEffectSpecification()
		{
			IService[] result = new IService[this.serviceEffectMap.Count];
			int count = 0;
			foreach (IIdentifier id in this.serviceEffectMap.Keys)
			{
				string[] ids = id.ToString().Split(':');
				IInterfaceModel iface = this.GetProvidesRoleByInterfaceID(IdentifiableFactory.CreateGUID(ids[0])).Interface;
				result[count++] = ComponentFactory.CreateService(iface, IdentifiableFactory.CreateStringID(ids[1]));
			}
			return result;
		}

		/// <summary>
		/// Get the service effect specification associated with aSig.
		/// </summary>
		/// <param name="serviceID">The service ID to which an service effect is affected</param>
		/// <returns>The service effect specification of aSig in role aRole.</returns>
		public IServiceEffectSpecification GetServiceEffectSpecification(IIdentifier serviceID)
		{
			if (!serviceEffectMap.Contains(serviceID))
				throw new ServiceHasNoServEffSpecException(serviceID);
			return (IServiceEffectSpecification)serviceEffectMap[serviceID];
		}

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aService">The service and its role to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		public void ChangeServiceEffectSpecification(IService aService, IServiceEffectSpecification aServEffSpec)
		{
			GetServiceEffectSpecification(aService.ID);
			serviceEffectMap[aService.ID] = aServEffSpec;
		}

		/// <summary>
		/// Add the service effect specification aServEffSpec of aSignature to serviceEffectMap.
		/// </summary>
		/// <param name="aService">The service to which an service effect gets added</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		public void AddServiceEffectSpecification(IService aService, IServiceEffectSpecification aServEffSpec)
		{
			if (aService == null || aServEffSpec == null)
				throw new ArgumentNullException("Service or service effect can't be null!");
			if (serviceEffectMap.ContainsKey(aService.ID))
				throw new ServiceEffectAlreadySpecifiedException(aService);
			IRole role = GetProvidesRoleByInterfaceID(aService.Interface.ID);
			if (role == null)
				throw new RoleIDNotFoundException(aService.Interface.ID);
			if (!role.Interface.SignatureList.ContainsSignatureID(aService.Signature.ID))
				throw new SignatureNotFoundException(aService.Signature.ID);
			serviceEffectMap.Add(aService.ID,aServEffSpec);
		}

		/// <summary>
		/// Add the service effect specification of aSignature to aServEffSpec.
		/// </summary>
		/// <param name="anInterfaceID">The service to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		/// <param name="aSignatureID">Role of the signature</param>
		public void AddServiceEffectSpecification(IIdentifier anInterfaceID, IIdentifier aSignatureID, IServiceEffectSpecification aServEffSpec)
		{
			IRole role = GetProvidesRoleByInterfaceID(anInterfaceID);
			if (role == null)
				throw new RoleIDNotFoundException(anInterfaceID);
			
			AddServiceEffectSpecification(ComponentFactory.CreateService(role.Interface,aSignatureID),aServEffSpec);
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new BasicComponent(this);
		}

		public void DeleteServiceEffectSpecification(params IService[] services)
		{
			foreach (IService sr in services)
			{
				if (sr == null)
					throw new ArgumentNullException("Service can't be null!");
				if (!serviceEffectMap.ContainsKey(sr.ID))
					throw new ServiceHasNoServEffSpecException(sr);
			}
			foreach (IService sr in services)
			{
				serviceEffectMap.Remove(sr.ID);
			}
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		/// <param name="id">ID of the component</param>
		public BasicComponent(AttributeHash anAttHash, string name, GloballyUniqueIdentifier id) : base (anAttHash,name,id)
		{
			//serviceEffectMap = new ServiceEffectHashmap();
			serviceEffectMap = new Hashtable();
		}

		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="anotherComponent">The basic component to copy.</param>
		public BasicComponent(BasicComponent anotherComponent) : base(anotherComponent)
		{
			//serviceEffectMap = (ServiceEffectHashmap)anotherComponent.serviceEffectMap.Clone();
			serviceEffectMap = (Hashtable)anotherComponent.serviceEffectMap.Clone();
		}

		#endregion

		#region Data
		private Hashtable serviceEffectMap;
														
		#endregion
	}
}