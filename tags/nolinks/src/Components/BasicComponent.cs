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
		/// <param name="aSig">A signature provided in a role of this component.</param>
		/// <returns>The service effect specification of aSig.</returns>
		public IServiceEffectSpecification GetServiceEffectSpecification(IExternalSignature aSig)
		{
			IRole aRole;
			if ((aRole = providesMap[aSig.RoleID]) == null)
				throw new RoleIDNotFoundException(aSig.RoleID);
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
			return GetServiceEffectSpecification(ComponentFactory.CreateExternalSignature(aRoleID,aSig));
		}

		/// <summary>
		/// Changes the service effect specification of aSignature to aServEffSpec.
		/// If aService.Signature does not exist an SignatureNotFoundException is thrown.
		/// </summary>
		/// <param name="aSignature">The service and its role to which an service effect is affected</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		public void ChangeServiceEffectSpecification(IExternalSignature aSignature, IServiceEffectSpecification aServEffSpec)
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
			ChangeServiceEffectSpecification(ComponentFactory.CreateExternalSignature(aRoleID,aSignature),aServEffSpec);
		}

		/// <summary>
		/// Add the service effect specification of aSignature to aServEffSpec.
		/// </summary>
		/// <param name="aSignature">The service to which an service effect gets added</param>
		/// <param name="aServEffSpec">The service effect specification</param>
		public void AddServiceEffectSpecification(IExternalSignature aSignature, IServiceEffectSpecification aServEffSpec)
		{
			if (aSignature == null || aServEffSpec == null)
				throw new ArgumentNullException("Signature and service effect can't be null!");
			if (serviceEffectMap.Contains(aSignature))
				throw new ServiceEffectAlreadySpecifiedException(aSignature.Signature);
			if (!providesMap.Contains(aSignature.RoleID))
				throw new RoleIDNotFoundException(aSignature.RoleID);
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
			AddServiceEffectSpecification(ComponentFactory.CreateExternalSignature(aRoleID,aSignature),aServEffSpec);
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

		public void DeleteServiceEffectSpecification(params IExternalSignature[] signatures)
		{
			foreach (IExternalSignature sr in signatures)
			{
				if (sr == null)
					throw new ArgumentNullException("Signature can't be null!");
				if (!serviceEffectMap.Contains(sr))
					throw new SignatureNotFoundException(sr.Signature);
			}
			foreach (IExternalSignature sr in signatures)
			{
				serviceEffectMap.Remove(sr);
			}
		}

		public override void Serialize(System.Xml.XmlTextWriter writer) 
		{
			writer.WriteStartElement("BasicComponent","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("id",this.ID.ToString());

			//serialize provides-interfaces
			writer.WriteStartElement("Provides","http://palladio.informatik.uni-oldenburg.de/XSD");
			foreach(IIdentifier c in providesMap.Keys)
			{
				((IRole)providesMap[c]).Serialize(writer);
			}
			writer.WriteEndElement();

			//serialize requires-interfaces
			writer.WriteStartElement("Requires","http://palladio.informatik.uni-oldenburg.de/XSD");
			foreach(IIdentifier c in requiresMap.Keys)
			{
				((IRole)requiresMap[c]).Serialize(writer);
			}
			writer.WriteEndElement();

			//serialize service effect specs
			if (serviceEffectMap.Count > 0) 
			{
				foreach(IExternalSignature sig in serviceEffectMap.Keys) 
				{
					writer.WriteStartElement("ServiceEffectSpecification","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("sigref",sig.ID.ToString());

					IServiceEffectSpecification sef = serviceEffectMap[sig];

					writer.WriteStartElement("ExternalSignatureList","http://palladio.informatik.uni-oldenburg.de/XSD");
					foreach (IExternalSignature extsig in sef.SignatureList) 
					{
						extsig.Serialize(writer);
					}
					writer.WriteEndElement();

					writer.WriteEndElement();
				}
			}
			writer.WriteEndElement();
		}

		public override void Deserialize(System.Xml.XmlNode element) 
		{
			this.myID = NewID(element.Attributes["id"].Value.ToString());

			System.Xml.XmlNode node = element.FirstChild;

			while (node != null)
			{
				switch (node.Name) 
				{
					case "Provides":
						foreach (XmlNode roleNode in node.ChildNodes)
						{
							IInterfaceModel role = ComponentFactory.CreateInterfaceModel();
							role.Deserialize(roleNode);
							this.AddProvidesInterface(NewID(roleNode.Attributes["id"].Value.ToString()), role);
						}
						break;
					case "Requires":
						foreach (XmlNode roleNode in node.ChildNodes)
						{
							IInterfaceModel role = ComponentFactory.CreateInterfaceModel();
							role.Deserialize(roleNode);
							this.AddRequiresInterface(NewID(roleNode.Attributes["id"].Value.ToString()), role);
						}
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

										sef.SignatureList.AddSignatures(ComponentFactory.CreateExternalSignature(exid[0],referedReqSig));
									}
									break;
							}
						}
						this.AddServiceEffectSpecification(ComponentFactory.CreateExternalSignature(id[0],referedProvSig), sef);
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