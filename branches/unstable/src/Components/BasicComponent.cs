using System;
using System.Xml;
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
			return serviceEffectMap[aService.ID] as IServiceEffectSpecification;
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
			return serviceEffectMap[serviceID] as IServiceEffectSpecification;
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
		/// <param name="aSignature">The service to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		/// <param name="aRoleID">Role of the signature</param>
		public void AddServiceEffectSpecification(IIdentifier anInterfaceID, IIdentifier aSignatureID, IServiceEffectSpecification aServEffSpec)
		{
			IRole role = GetProvidesRoleByInterfaceID(anInterfaceID);
			if (role == null)
				throw new RoleIDNotFoundException(anInterfaceID);
			
			AddServiceEffectSpecification(ComponentFactory.CreateService(role.Interface,aSignatureID),aServEffSpec);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is BasicComponent)) return false;
			if ((object)this == obj) return true;
			Console.WriteLine(base.Equals (obj));
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

		public override void Serialize(System.Xml.XmlTextWriter writer) 
		{
			// add interface links
			Hashtable interfaces = new Hashtable();
			foreach(IIdentifier id in providesMap.Keys)
				interfaces[id] = ((IRole)providesMap[id]).Interface;
			foreach(IIdentifier id in requiresMap.Keys)
				interfaces[id] = ((IRole)requiresMap[id]).Interface;
			foreach(IInterfaceModel iface in interfaces.Values)
			{
				writer.WriteStartElement("Interface","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",iface.ID.ToString());
				writer.WriteEndElement();
			}

			//add provides-interfaces
			foreach(IIdentifier c in providesMap.Keys)
			{
				writer.WriteStartElement("ProvidingRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",((IRole)providesMap[c]).Name);
				writer.WriteAttributeString("id",((IRole)providesMap[c]).ID.ToString());
				writer.WriteAttributeString("interface",((IRole)providesMap[c]).Interface.ID.ToString());
				writer.WriteEndElement();
			}

			//add requires-interfaces
			foreach(IIdentifier c in requiresMap.Keys)
			{
				writer.WriteStartElement("RequiringRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",((IRole)requiresMap[c]).Name);
				writer.WriteAttributeString("id",((IRole)requiresMap[c]).ID.ToString());
				writer.WriteAttributeString("interface",((IRole)requiresMap[c]).Interface.ID.ToString());
				writer.WriteEndElement();
			}

			//serialize service effect specs
			if (serviceEffectMap.Count > 0) 
			{
				foreach(IIdentifier sigID in serviceEffectMap.Keys) 
				{
					IServiceEffectSpecification sef = serviceEffectMap[sigID] as IServiceEffectSpecification;

					writer.WriteStartElement("ServiceEffectSpecification","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("service",sigID.ToString());
					writer.WriteAttributeString("id","");

					foreach (IAttributeType attrType in sef.Attributes.Keys)
					{
						writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
						writer.WriteAttributeString("guid",attrType.GUID.ToString());
						sef.Attributes[attrType].Serialize(writer);
						writer.WriteEndElement();
					}

					writer.WriteStartElement("ServiceList","http://palladio.informatik.uni-oldenburg.de/XSD");
					foreach (IService service in sef.RequiredServicesList) 
					{
						service.Serialize(writer);
					}
					writer.WriteEndElement();

					writer.WriteStartElement("AuxiliarySpecifications","http://palladio.informatik.uni-oldenburg.de/XSD");
					foreach (IServiceInformation auxSpec in sef.ServiceInformations) 
					{
						
					}
					writer.WriteEndElement();
					
					writer.WriteEndElement();
				}
			}
		}

		public override void Deserialize(System.Xml.XmlNode element) 
		{
			System.Xml.XmlNode node = element.FirstChild;

			while (node != null)
			{
				switch (node.Name) 
				{
					case "ProvidingRole":
						FirstClassEntity iface = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(node.Attributes["interface"].Value) as GloballyUniqueIdentifier );
						if (!(iface != null && iface is IInterfaceModel))
							throw new DeserializationException("Interface "+node.Attributes["interface"].Value+" not found.");
						this.AddProvidesInterface(iface as IInterfaceModel);
						IRole newRole = this.GetProvidesRoleByInterfaceID(iface.ID);
						newRole.Name = node.Attributes["name"].Value;
						break;
					case "RequiringRole":
						iface = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(node.Attributes["interface"].Value) as GloballyUniqueIdentifier );
						if (!(iface != null && iface is IInterfaceModel))
							throw new DeserializationException("Interface "+node.Attributes["interface"].Value+" not found.");
						this.AddRequiresInterface(iface as IInterfaceModel);
						newRole = this.GetRequiresRoleByInterfaceID(iface.ID);
						newRole.Name = node.Attributes["name"].Value;
						break;
					case "ServiceEffectSpecification":
						IServiceEffectSpecification sef = ComponentFactory.CreateServiceEffectSpecification();

						// search for the refered provides-interface to which this spec applies to
						string[] serviceID = node.Attributes["service"].Value.Split(':');
						IInterfaceModel provides = ModelPersistencyService.Instance.GetEntity(IdentifiableFactory.CreateGUID(serviceID[0])) as IInterfaceModel;

						if (provides == null) 
							throw new DeserializationException("ProvidesInterface "+serviceID[0]+" not found");

						ISignature signature = null;

						foreach (ISignature sig in provides.SignatureList) 
						{
							if (sig.ID.ToString() == serviceID[1])
								signature = sig;
						}

						if (signature == null) 
							throw new DeserializationException("Signature "+serviceID[1]+" not found");

						// provides-interface found. 
						// now add the listed signatures from the required-interfaces to the spec.
						foreach (XmlNode sefChild in node.ChildNodes)
						{
							switch (sefChild.Name)
							{
								case "ServiceList":
									foreach(XmlNode serviceNode in sefChild.ChildNodes)
									{
										IInterfaceModel requires = ModelPersistencyService.Instance.GetEntity(IdentifiableFactory.CreateGUID(serviceNode.Attributes["guid"].Value)) as IInterfaceModel;

										if (requires == null) 
											throw new DeserializationException("RequiresInterface "+node.Attributes["guid"].Value+" not found");

										ISignature extSignature = null;

										foreach (ISignature sig in requires.SignatureList) 
										{
											if (sig.ID.ToString() == serviceNode.Attributes["id"].Value)
												extSignature = sig;
										}

										if (extSignature == null) 
											throw new DeserializationException("Signature "+serviceNode.Attributes["id"].Value+" not found in RequiresInterface "+serviceNode.Attributes["guid"].Value);

										sef.RequiredServicesList.AddServices(ComponentFactory.CreateService(requires,extSignature.ID));
									}
									break;
								case "AuxiliarySpecifications":
									foreach(XmlNode auxSpecNode in sefChild.ChildNodes)
									{
									}
									break;
							}
						}
						
						this.AddServiceEffectSpecification(ComponentFactory.CreateService(provides,signature.ID), sef);
						break;
				}
				node = node.NextSibling;
			}
		}

		private IIdentifier NewID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
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