using System;
using System.Collections;
using System.Xml;
using System.Xml.Schema;
using Palladio.Attributes;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEntities.Impl;
using Palladio.ComponentModel.Query;
using Palladio.Identifier;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This is the reader used by XmlSerializer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.11  2005/10/09 14:42:12  kelsaka
	/// - removed convenience properties to access a component model entity directly from a
	///  builder. use the access cm-environment>query instead
	///
	/// Revision 1.10  2005/09/28 19:12:03  joemal
	/// fix bug
	///
	/// Revision 1.9  2005/09/18 15:36:23  joemal
	/// add fsm seffs and protocols
	///
	/// Revision 1.8  2005/08/30 14:59:41  kelsaka
	/// - fixed bugs
	///
	/// Revision 1.7  2005/08/25 16:45:38  joemal
	/// add stream location to serializer
	///
	/// Revision 1.6  2005/07/23 18:59:57  joemal
	/// IType now is implemented in external object. Plugins for serializer are created.
	///
	/// Revision 1.5  2005/07/13 11:10:05  joemal
	/// implement
	///
	/// Revision 1.4  2005/06/25 16:53:29  joemal
	/// merge the implementation with the changed xsd
	///
	/// Revision 1.3  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.2  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.1  2005/05/24 16:47:24  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public class XmlCMReader
	{
		#region data

		//the buildermanager
		private IBuilderManager builderManager;

		//the plugins
		private Hashtable plugins;

		private IQueryRepository queryRepository;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new XmlCMReader using the given builder and plugins
		/// </summary>
		/// <param name="builderManager">the buildermanager</param>
		/// <param name="plugins">the plugins</param>
		public XmlCMReader(IBuilderManager builderManager, Hashtable plugins)
		{
			this.builderManager = builderManager;
			this.queryRepository = builderManager.RootTypeLevelBuilder.QueryRepository;
			this.plugins = plugins;
		}

		#endregion 

		#region public methods

		/// <summary>
		/// called to read a serialized model from a file.
		/// </summary>
		/// <param name="location">the location that contains the file</param>
		/// <exception cref="ModelSerializationException">thrown if any reading error occurs during the deserialization</exception>
		public void Read(XmlFileLocation location)
		{
			XmlReader reader = null;

			try 
			{
				reader = new XmlTextReader(location.XmlFile);
			}
			catch(Exception exception)
			{
				throw new ModelSerializationException("Unable to open the xml file "+location.XmlFile+".",exception);
			}
			
			Read(reader);

			reader.Close();
		}

		/// <summary>
		/// called to read the serialized model from a xml reader.
		/// </summary>
		/// <param name="location">the location that contains the node</param>
		/// <exception cref="ModelSerializationException">thrown if any reading error occurs during the deserialization</exception>
		public void Read(XmlNodeLocation location)
		{
			Read(location.XmlReader);
		}

		/// <summary>
		/// called to read a serialized model from a stream.
		/// </summary>
		/// <param name="location">the location that contains the stream</param>
		/// <exception cref="ModelSerializationException">thrown if any reading error occurs during the deserialization</exception>
		public void Read(XmlStreamLocation location)
		{
			XmlReader reader = null;

			reader = new XmlTextReader(location.Stream);	
			Read(reader);
			reader.Close();
		}

		#endregion

		#region private methods

		//read the model from the reader
		private void Read(XmlReader reader)
		{
			XmlValidatingReader validator=null;
			try 
			{
				validator = new XmlValidatingReader(reader);
				validator.ValidationType = ValidationType.Schema;			
	
				XmlSchemaCollection schemaCollection = new XmlSchemaCollection();
				schemaCollection.Add(XmlSerializer.XMLNAMESPACE,
					System.AppDomain.CurrentDomain.BaseDirectory+"\\Palladio.ComponentModel.xsd");

				foreach(IXmlPlugIn plugin in plugins.Values)
					schemaCollection.Add(plugin.XmlNameSpace,System.AppDomain.CurrentDomain.BaseDirectory+"\\"+plugin.XmlSchema);

				validator.Schemas.Add(schemaCollection);
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml schema Palladio.ComponentModel.xsd "+
					"or one of the plugins once.",exc);
			}

			XmlDocument xmlDoc = null;
			try
			{
				xmlDoc = new XmlDocument();	
				xmlDoc.Load(validator);
				reader.Close();
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml document.",exc);
			}

			XmlNamespaceManager mgr = new XmlNamespaceManager(xmlDoc.NameTable);
			mgr.AddNamespace("cm",XmlSerializer.XMLNAMESPACE);

            //model validated, clear old model
			this.builderManager.RootTypeLevelBuilder.ClearAll();
			ReadTLModel(xmlDoc.DocumentElement,mgr);
		}

		#endregion

		#region type level read methods

		//reads the model of the typelevel
		private void ReadTLModel(XmlElement rootElement,XmlNamespaceManager mgr)
		{
			XmlNode typeLevelNode = rootElement.SelectSingleNode("//cm:TypeLevel",mgr);
            ExtractInterfaces(typeLevelNode, mgr);
			ExtractTLComponents(typeLevelNode, mgr);
			ExtractTLStaticViewRoot(typeLevelNode,mgr);
		}

		//adds components and connections to the static 
		private void ExtractTLStaticViewRoot(XmlNode typeLevelNode, XmlNamespaceManager mgr)
		{
			XmlNodeList nodeList = typeLevelNode.SelectNodes("cm:StaticViewRoot/cm:Structure/cm:Component",mgr);									
			IRootTypeLevelBuilder builder = this.builderManager.RootTypeLevelBuilder;
			foreach(XmlNode compNode in nodeList)
				builder.AddExistingComponent((IComponentIdentifier) this.ExtractEntityIdentifier(compNode));

			nodeList = typeLevelNode.SelectNodes("cm:StaticViewRoot/cm:Structure/cm:AssemblyConnector",mgr);									
			foreach(XmlNode conRefNode in nodeList)
			{
				IConnectionIdentifier conID =(IConnectionIdentifier) this.ExtractEntityIdentifier(conRefNode);
				XmlNode conNode = this.GetEntityNode(conID.Key,typeLevelNode,mgr);
				string name = this.ExtractEntityName(conNode,mgr);
				IInterfaceIdentifier provIFaceID = (IInterfaceIdentifier)this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:ProvidingIFace",mgr));
				IComponentIdentifier provCompID = (IComponentIdentifier) this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:ProvidingComponent",mgr));
				IInterfaceIdentifier reqIFaceID = (IInterfaceIdentifier)this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:RequireingIFace",mgr));
				IComponentIdentifier reqCompID = (IComponentIdentifier) this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:RequireingComponent",mgr));

				builder.AddAssemblyConnector(conID,name,reqCompID,reqIFaceID,provCompID,provIFaceID);

				ExtractEntityAttributes(builder.QueryRepository.GetConnection(conID),conNode,mgr);
			}
		}

		//creates all components (basic and composite)
		private void ExtractTLComponents(XmlNode typeLevelNode, XmlNamespaceManager mgr)
		{
			IRootTypeLevelBuilder typeLevelBuilder = builderManager.RootTypeLevelBuilder;
			
			//create all basic components
			XmlNodeList compNodes = typeLevelNode.SelectNodes("cm:BasicComponent",mgr);
			foreach(XmlNode compNode in compNodes)
			{
				IComponentIdentifier compID = (IComponentIdentifier) ExtractEntityIdentifier(compNode);
				string name = ExtractEntityName(compNode,mgr);
				IBasicComponentBuilder compBuilder = typeLevelBuilder.CreateBasicComponent(compID,name);
				ExtractComponentIfaces(compBuilder,compNode,mgr);
				ExtractSeffs(compBuilder,typeLevelNode,compNode,mgr);
				ExtractEntityAttributes(this.queryRepository.GetComponent(compBuilder.ComponentId),compNode,mgr);
			}		

			//create empty composite components and bind their interfaces to them
			compNodes = typeLevelNode.SelectNodes("cm:CompositeComponent",mgr);
			foreach(XmlNode compNode in compNodes)
			{
				IComponentIdentifier compID = (IComponentIdentifier) ExtractEntityIdentifier(compNode);
				string name = ExtractEntityName(compNode,mgr);
				ICompositeComponentBuilder compBuilder = typeLevelBuilder.CreateCompositeComponent(compID,name);
				ExtractComponentIfaces(compBuilder,compNode,mgr);
				ExtractEntityAttributes(this.queryRepository.GetComponent(compBuilder.ComponentId),compNode,mgr);
			}		

			//now all components are present, fill the composite components 
			foreach(XmlNode compNode in compNodes)
			{
				IComponentIdentifier compID = (IComponentIdentifier) ExtractEntityIdentifier(compNode);
				ICompositeComponentBuilder compBuilder = this.builderManager.GetCompositeComponentTypeLevelBuilder(compID);
				BuildCompositeComponent(compBuilder,typeLevelNode,compNode,mgr);
			}		
		}

		//adds the seffs to a basic component
		private void ExtractSeffs(IBasicComponentBuilder builder,XmlNode typelevelNode ,XmlNode bcNode, XmlNamespaceManager mgr)
		{
			XmlNodeList seffRefNodes = bcNode.SelectNodes("cm:Structure/cm:ServiceEffectSpecification",mgr);
			foreach(XmlNode seffRefNode in seffRefNodes)
			{
				string guid = seffRefNode.Attributes["guid"].Value;
				XmlNode entityNode = GetEntityNode(guid, typelevelNode,mgr);
				IServiceEffectSpecification seff = ExtractSeff(entityNode);
				IInterfaceIdentifier ifaceId = (IInterfaceIdentifier) 
					ExtractEntityIdentifier(seffRefNode.SelectSingleNode("cm:Interface",mgr));
				ISignatureIdentifier sigId = (ISignatureIdentifier) 
					ExtractEntityIdentifier(seffRefNode.SelectSingleNode("cm:Signature",mgr));
				builder.AddServiceEffectSpecification(seff,ifaceId,sigId);
			}	
		}

		//extract a seff
		private IServiceEffectSpecification ExtractSeff(XmlNode seffNode)
		{
			string typeGuid = seffNode.Attributes["type"].Value;
			IXmlSeffPlugIn plugIn = (IXmlSeffPlugIn) this.plugins[new InternalEntityIdentifier(typeGuid)];
			if (plugIn == null)
				throw new ModelSerializationException("No plugin found for sefftype "+typeGuid+".");
			ISeffIdentifier seffId = new InternalEntityIdentifier(seffNode.Attributes["guid"].Value);
			return plugIn.LoadSeff(seffId, seffNode);
		}

		#endregion

		#region entity methods

		//fills a composite component with components and connections
		private void BuildCompositeComponent(ICompositeComponentBuilder builder, XmlNode typeLevelNode, XmlNode node, XmlNamespaceManager mgr)
		{
			XmlNodeList nodeList = node.SelectNodes("cm:Structure/cm:Component",mgr);									
			foreach(XmlNode compNode in nodeList)
				builder.AddExistingComponent((IComponentIdentifier) this.ExtractEntityIdentifier(compNode));

			nodeList = node.SelectNodes("cm:Structure/cm:DelegationConnector",mgr);									
			foreach(XmlNode conRefNode in nodeList)
			{
				IConnectionIdentifier conID =(IConnectionIdentifier) this.ExtractEntityIdentifier(conRefNode);
				XmlNode conNode = this.GetEntityNode(conID.Key,typeLevelNode,mgr);
				
				string name = this.ExtractEntityName(conNode,mgr);
				IInterfaceIdentifier innerIfaceID = (IInterfaceIdentifier)this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:InnerIFace",mgr));
				IComponentIdentifier innerCompID = (IComponentIdentifier) this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:InnerComponent",mgr));
				IInterfaceIdentifier outerIfaceID = (IInterfaceIdentifier)this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:OuterIFace",mgr));

				if (conRefNode.SelectSingleNode("cm:Type",mgr).InnerText.Equals("Provides"))
					builder.AddProvidesDelegationConnector(conID,name,outerIfaceID,innerCompID,innerIfaceID);
				else
					builder.AddRequiresDelegationConnector(conID,name,innerCompID,innerIfaceID,outerIfaceID);
			}				

			nodeList = node.SelectNodes("cm:Structure/cm:AssemblyConnector",mgr);									
			foreach(XmlNode conRefNode in nodeList)
			{
				IConnectionIdentifier conID =(IConnectionIdentifier) this.ExtractEntityIdentifier(conRefNode);
				XmlNode conNode = this.GetEntityNode(conID.Key,typeLevelNode,mgr);

				
				string name = this.ExtractEntityName(conNode,mgr);
				IInterfaceIdentifier provIFaceID = (IInterfaceIdentifier)this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:ProvidingIFace",mgr));
				IComponentIdentifier provCompID = (IComponentIdentifier) this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:ProvidingComponent",mgr));
				IInterfaceIdentifier reqIFaceID = (IInterfaceIdentifier)this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:RequireingIFace",mgr));
				IComponentIdentifier reqCompID = (IComponentIdentifier) this.
					ExtractEntityIdentifier(conRefNode.SelectSingleNode("cm:RequireingComponent",mgr));

				builder.AddAssemblyConnector(conID,name,reqCompID,reqIFaceID,provCompID,provIFaceID);
			}
		}

        //adds interfaces to the components
		private void ExtractComponentIfaces(IComponentBuilder builder, XmlNode compNode, XmlNamespaceManager mgr)
		{
			XmlNodeList provIfaces = compNode.SelectNodes("cm:Structure/cm:ProvidesInterface",mgr);
			foreach(XmlNode ifaceNode in provIfaces)
			{
				string guid=ifaceNode.Attributes["guid"].Value;
				builder.AddExistingInterfaceAsProvides(new InternalEntityIdentifier(guid));
			}
			XmlNodeList reqIfaces = compNode.SelectNodes("cm:Structure/cm:RequiresInterface",mgr);
			foreach(XmlNode ifaceNode in reqIfaces)
			{
				string guid=ifaceNode.Attributes["guid"].Value;
				builder.AddExistingInterfaceAsRequires(new InternalEntityIdentifier(guid));
			}
		}

		//creates all interfaces
		private void ExtractInterfaces(XmlNode typelevelNode, XmlNamespaceManager mgr)
		{
			IRootTypeLevelBuilder typeLevelBuilder = builderManager.RootTypeLevelBuilder;
			
			XmlNodeList ifaceNodes = typelevelNode.SelectNodes("cm:Interface",mgr);
			foreach(XmlNode ifaceNode in ifaceNodes)
			{
				IInterfaceIdentifier ifaceID = (IInterfaceIdentifier)ExtractEntityIdentifier(ifaceNode);
				string name = ExtractEntityName(ifaceNode,mgr);
				IInterfaceBuilder ifaceBuilder = typeLevelBuilder.CreateInterface(ifaceID,name);
				ExtractSignatures(ifaceBuilder,typelevelNode,ifaceNode, mgr);
				ExtractProtocols(ifaceBuilder,typelevelNode,ifaceNode, mgr);
				ExtractEntityAttributes(this.queryRepository.GetInterface(ifaceBuilder.InterfaceId),ifaceNode,mgr);
			}
		}

		//add the signatures to an interface
		private void ExtractSignatures(IInterfaceBuilder ifaceBuilder, XmlNode typelevelNode,XmlNode ifaceNode,
			XmlNamespaceManager mgr)
		{
			XmlNodeList sigRefNodes = ifaceNode.SelectNodes("cm:Structure/cm:Signature",mgr);
			foreach(XmlNode sigRefNode in sigRefNodes)
			{
				string guid = sigRefNode.Attributes["guid"].Value;
				XmlNode entityNode = GetEntityNode(guid, typelevelNode,mgr);
				string name = ExtractEntityName(entityNode,mgr);
				ISignatureBuilder sigBuilder = ifaceBuilder.AddSignature(new InternalEntityIdentifier(guid),name);
				ExtractSignature(sigBuilder,entityNode,mgr);
			}
		}

		//extract a signature
		private void ExtractSignature(ISignatureBuilder builder, XmlNode sigNode, XmlNamespaceManager mgr)
		{
			XmlNode retTypeNode = sigNode.SelectSingleNode("cm:ReturnType",mgr);
			builder.SetReturnType(ExtractType(retTypeNode));

            XmlNodeList parameters = sigNode.SelectNodes("cm:Parameter",mgr);
			foreach(XmlNode parameter in parameters)
			{
				IType type = ExtractType(parameter.SelectSingleNode("cm:Type",mgr));
				string name = parameter.SelectSingleNode("cm:Name",mgr).InnerText;
				ParameterModifierEnum modifier = (ParameterModifierEnum) 
					byte.Parse(parameter.SelectSingleNode("cm:Modifier",mgr).InnerText);
				builder.AppendParameter(type,name,modifier);
			}

			XmlNodeList exceptions = sigNode.SelectNodes("cm:Exception",mgr);
			foreach(XmlNode exception in exceptions)
				builder.AddException(ExtractType(exception));

			ExtractEntityAttributes(this.queryRepository.GetSignature(builder.SignatureId),sigNode,mgr);
		}
        
		//extract the type from given node
		private IType ExtractType(XmlNode typeNode)
		{
			ITypeIdentifier typeID = new InternalEntityIdentifier(typeNode.Attributes["typeid"].Value);
			
			if (typeID.Equals(VoidType.TYPEID)) return new VoidType();
			
			IXmlTypePlugIn typePlugIn = (IXmlTypePlugIn) plugins[typeID];
			if (typePlugIn == null)
				throw new ModelSerializationException("No plugin found for the type with id \""+typeID.Key+"\".");
			return typePlugIn.LoadType(typeNode);
		}

		//adds the protocols to an interface
		private void ExtractProtocols(IInterfaceBuilder builder,XmlNode typelevelNode ,XmlNode ifaceNode, XmlNamespaceManager mgr)
		{
			XmlNodeList protRefNodes = ifaceNode.SelectNodes("cm:Structure/cm:Protocol",mgr);
			foreach(XmlNode protRefNode in protRefNodes)
			{
				string guid = protRefNode.Attributes["guid"].Value;
				XmlNode entityNode = GetEntityNode(guid, typelevelNode,mgr);
				IProtocol protocol = ExtractProtocol(entityNode);
				builder.AddProtocol(protocol);
			}	
		}

		//extract a protocol
		private IProtocol ExtractProtocol(XmlNode protocolNode)
		{
			string typeGuid = protocolNode.Attributes["type"].Value;
			IXmlProtocolPlugIn plugIn = (IXmlProtocolPlugIn) this.plugins[new InternalEntityIdentifier(typeGuid)];
			if (plugIn == null)
				throw new ModelSerializationException("No plugin found for protocoltype "+typeGuid+".");
			IProtocolIdentifier protId = new InternalEntityIdentifier(protocolNode.Attributes["guid"].Value);
			return plugIn.LoadProtocol(protId, protocolNode);
		}

		//extract the identifier of an entity or entity reference
		private IIdentifier ExtractEntityIdentifier(XmlNode node)
		{
			return new InternalEntityIdentifier(node.Attributes["guid"].Value);
		}

		//extract the name of an entity
		private string ExtractEntityName(XmlNode entityNode, XmlNamespaceManager mgr)
		{
			return entityNode.SelectSingleNode("cm:Name",mgr).InnerText;
		}

		//called to add the attributes to an entity
		private void ExtractEntityAttributes(IComponentModelEntity entity,XmlNode entityNode, XmlNamespaceManager mgr)
		{
			XmlNodeList attrNodeList = entityNode.SelectNodes("cm:Attributes/cm:Attribute",mgr);
			foreach(XmlNode attrNode in attrNodeList)
			{
				Guid guid = new Guid(attrNode.Attributes["type"].Value);
				string descr = attrNode.SelectSingleNode("cm:Description",mgr).InnerText;
				string name = attrNode.SelectSingleNode("cm:Name",mgr).InnerText;
				Type type = new ReflectedType(attrNode.SelectSingleNode("cm:ValueType",mgr).InnerText).GetType();
				IAttributeType attrType = new DefaultAttributeType(guid,name,descr,type);
				IXmlAttributePlugIn attrPlugIn = (IXmlAttributePlugIn) plugins[attrType];
				if (attrPlugIn == null)
					throw new ModelSerializationException("No plugin found for attributetype \""+attrType.DisplayName+"\".");
				IAttribute attr = attrPlugIn.LoadAttribute(attrNode);
				entity.Attributes.Add(attrType,attr);
			}
		}

		//returns the xml-node that belongs to the entity that is referenced by the given guid 
		private XmlNode GetEntityNode(string guid,XmlNode levelNode, XmlNamespaceManager mgr)
		{
			XmlNode entityNode = levelNode.SelectSingleNode("*[@guid=\""+guid+"\"]",mgr);
			if (entityNode == null)
				throw new ModelSerializationException("Unable to find the referenced entity with guid \""+guid+"\".");

			return entityNode;
		}

		#endregion		
	}
}
