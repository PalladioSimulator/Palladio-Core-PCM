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
		/// Get the service effect specification associated with aSig.
		/// </summary>
		/// <param name="aService">A service provided by a role of this component.</param>
		/// <returns>The service effect specification of aSig.</returns>
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
		public void AddServiceEffectSpecification(IIdentifier anInterfaceeID, IIdentifier aSignatureID, IServiceEffectSpecification aServEffSpec)
		{
			IRole role = GetProvidesRoleByInterfaceID(anInterfaceeID);
			if (role == null)
				throw new RoleIDNotFoundException(anInterfaceeID);
			
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
			//serialize provides-interfaces
			foreach(IIdentifier c in providesMap.Keys)
			{
				writer.WriteStartElement("ProvidingRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",((IRole)providesMap[c]).Name);
				writer.WriteAttributeString("id",((IRole)providesMap[c]).ID.ToString());
				
				writer.WriteStartElement("Interface","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",((IRole)providesMap[c]).Interface.ID.ToString());
				
				writer.WriteEndElement();
				writer.WriteEndElement();
			}

			//serialize requires-interfaces
			foreach(IIdentifier c in requiresMap.Keys)
			{
				writer.WriteStartElement("RequiringRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",((IRole)requiresMap[c]).Name);
				writer.WriteAttributeString("id",((IRole)requiresMap[c]).ID.ToString());
				
				writer.WriteStartElement("Interface","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",((IRole)requiresMap[c]).Interface.ID.ToString());
				
				writer.WriteEndElement();
				writer.WriteEndElement();
			}

			//serialize service effect specs
			if (serviceEffectMap.Count > 0) 
			{
				foreach(IService sig in serviceEffectMap.Keys) 
				{
					writer.WriteStartElement("ServiceEffectSpecification","http://palladio.informatik.uni-oldenburg.de/XSD");
					//writer.WriteAttributeString("sigref",sig.ID.ToString());
					
					IServiceEffectSpecification sef = serviceEffectMap[sig] as IServiceEffectSpecification;

					//					writer.WriteStartElement("ExternalSignatureList","http://palladio.informatik.uni-oldenburg.de/XSD");
					//					foreach (IExternalSignature extsig in sef.SignatureList) 
					//					{
					//						extsig.Serialize(writer);
					//					}
					//					writer.WriteEndElement();
					
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
						XmlNode ifaceNode = node.FirstChild;
						FirstClassEntity iface = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(ifaceNode.Attributes["guid"].Value) as GloballyUniqueIdentifier );
						if (!(iface != null && iface is IInterfaceModel))
							throw new DeserializationException("Interface "+ifaceNode.Attributes["guid"].Value+" not found.");
						this.AddProvidesInterface(iface as IInterfaceModel);
						IRole newRole = this.GetProvidesRoleByInterfaceID(iface.ID);
						newRole.Name = node.Attributes["name"].Value;
						break;
					case "RequiringRole":
						ifaceNode = node.FirstChild;
						iface = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(ifaceNode.Attributes["guid"].Value) as GloballyUniqueIdentifier );
						if (!(iface != null && iface is IInterfaceModel))
							throw new DeserializationException("Interface "+ifaceNode.Attributes["guid"].Value+" not found.");
						this.AddRequiresInterface(iface as IInterfaceModel);
						newRole = this.GetRequiresRoleByInterfaceID(iface.ID);
						newRole.Name = node.Attributes["name"].Value;
						break;
					case "ServiceEffectSpecification":
						IServiceEffectSpecification sef = ComponentFactory.CreateServiceEffectSpecification();

						// search for the refered provides-interface to which this spec applies to
						string sigref = node.Attributes["sigref"].Value.ToString();
						ISignature referedProvSig = null;

						string[] id = sigref.Split(new char[]{':'},2);
						IInterfaceModel refProvRole = this.GetProvidesInterface(NewID(id[0]));

						if (refProvRole == null) 
							throw new DeserializationException("ProvidesInterface "+id[0]+" not found");

						foreach (ISignature sig in refProvRole.SignatureList) 
						{
							if (sig.ID.ToString() == id[1])
								referedProvSig = sig;
						}

						if (referedProvSig == null) 
							throw new DeserializationException("Signature "+id[1]+" not found");

						// provides-interface found. 
						// now add the listed signatures from the required-interfaces to the spec.
						foreach (XmlNode sefChild in node.ChildNodes)
						{
							switch (sefChild.Name)
							{
								case "ExternalSignatureList":
									
									foreach(XmlNode exSigNode in sefChild.ChildNodes)
									{
										string exsigref = exSigNode.Attributes["sigref"].Value.ToString();
										ISignature referedReqSig = null;

										string[] exid = exsigref.Split(new char[]{':'},2);
										IInterfaceModel refReqRole = this.GetRequiresInterface(NewID(exid[0]));
										if (refReqRole == null) 
											throw new DeserializationException("RequiresInterface "+exid[0]+" not found");

										foreach (ISignature sig in refReqRole.SignatureList) 
										{
											if (sig.ID.ToString() == exid[1])
												referedReqSig = sig;
										}
										if (referedReqSig == null) 
											throw new DeserializationException("Signature "+exid[1]+" not found");

										//sef.SignatureList.AddSignatures(ComponentFactory.CreateService(exid[0],referedReqSig));
									}
									break;
							}
						}
						//this.AddServiceEffectSpecification(ComponentFactory.CreateService(id[0],referedProvSig), sef);
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
		public BasicComponent(IAttributeHash anAttHash, string name, GloballyUniqueIdentifier id) : base (anAttHash,name,id)
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