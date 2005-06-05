using System;
using System.Collections;
using System.Xml;
using Palladio.Attributes;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;
using Palladio.Identifier;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This is the writer used by XmlSerializer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/06/05 10:30:26  joemal
	/// temporary disabled
	///
	/// Revision 1.4  2005/05/24 16:49:41  joemal
	/// change the exceptions
	///
	/// Revision 1.3  2005/05/19 18:07:19  joemal
	/// add parameter and attribute serialization
	///
	/// Revision 1.2  2005/05/08 17:23:40  joemal
	/// fix a bug
	///
	/// Revision 1.1  2005/05/08 12:02:16  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	internal class XmlCMWriter 
	{
		#region data

		//holds the query interface of the componentmodel
		private IQuery query;

		//holds the registered plugins
		private Hashtable plugins=new Hashtable(); 

		#endregion

		#region constructor 

		/// <summary>
		/// called to create a new serializer.
		/// </summary>
		/// <param name="query">the query interface of the componentmodel</param>
		/// <param name="plugins">the hashtable with registered plugins</param>
		public XmlCMWriter(IQuery query, Hashtable plugins)
		{
			this.query = query;
			this.plugins = plugins;
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to write the serialized model to a file.
		/// </summary>
		/// <param name="location">the location that contains the file</param>
		public void Write(XmlFileLocation location)
		{
			XmlTextWriter writer = null;

			try 
			{
				writer = new XmlTextWriter(location.XmlFile,System.Text.Encoding.UTF8);
			}
			catch(Exception exception)
			{
				throw new ModelSerializationException("Unable to create the xml file "+location.XmlFile+".",exception);
			}

			writer.Formatting = Formatting.Indented;
			writer.Indentation= 3;
			writer.Namespaces = true;
			writer.WriteStartDocument();
			Write(writer);
			writer.Close();
		}

		/// <summary>
		/// called to write the serialized model to a xml node.
		/// </summary>
		/// <param name="location">the location that contains the node</param>
		public void Write(XmlNodeLocation location)
		{
			Write(location.XmlWriter);
		}

		#endregion

		#region private method

		//called to write the document
		private void Write(XmlWriter writer)
		{
			try
			{
				writer.WriteStartElement("ComponentModel",XmlSerializer.XMLNAMESPACE);
				WriteTLModel(writer);
				WriteILModel(writer);
				WriteDLModel(writer);
			}
			catch(Exception exc)
			{
				Console.WriteLine("Error: "+exc);
				throw new ModelSerializationException("Unable to write to the xml file.",exc);
			}
		}

		#endregion

		#region typelevel methods

		//write the type level part of the model
		private void WriteTLModel(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRootTL");
			
			//structure
			writer.WriteStartElement("Structure");
			IInterfaceIdentifier[] ifaceIDs = query.QueryTypeLevel.QueryStaticView().GetInterfaces();
			WriteEntityGuids(writer,"Interface",ifaceIDs);
			IComponentIdentifier[] basicCompIDs = query.QueryTypeLevel.QueryStaticView().GetBasicComponents();
			WriteEntityGuids(writer,"Component",basicCompIDs);
			IComponentIdentifier[] compositeCompIDs = query.QueryTypeLevel.QueryStaticView().GetCompositeComponents();
			WriteEntityGuids(writer,"Component",compositeCompIDs);
			IConnectionIdentifier[] conIDs = query.QueryTypeLevel.QueryStaticView().GetConnections();
			WriteConnectionRef(writer,conIDs);
			writer.WriteEndElement();

			//entities
			writer.WriteStartElement("Entities");
			WriteInterfaces(writer,ifaceIDs);
			WriteBasicComponentsTL(writer,basicCompIDs);
			WriteCompositeComponentsTL(writer,compositeCompIDs);
			WriteConnections(writer,conIDs);
			writer.WriteEndElement();

			writer.WriteEndElement();
		}

		//write the given type level basic components
		private void WriteBasicComponentsTL(XmlWriter writer, params IComponentIdentifier[] compIDs)
		{
			foreach (IComponentIdentifier compID in compIDs)
			{				
				writer.WriteStartElement("BasicComponent");
				
				IComponent comp = query.QueryEntities.GetComponent(compID);				
				WriteEntityBaseAttributes(writer,comp);
				
				//structure
				writer.WriteStartElement("Structure");
				IInterfaceIdentifier[] ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetProvidesInterfaceIDs();
				WriteEntityGuids(writer,"ProvidesInterface",ifaceIDs);
				ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetRequiresInterfaceIDs();
				WriteEntityGuids(writer,"RequiresInterface",ifaceIDs);
				writer.WriteEndElement();								

				writer.WriteEndElement();	
			}
		}

		//write the given type level composite component 
		private void WriteCompositeComponentsTL(XmlWriter writer, params IComponentIdentifier[] compIDs)
		{
			foreach (IComponentIdentifier compID in compIDs)
			{				
				writer.WriteStartElement("CompositeComponent");
				
				IComponent comp = query.QueryEntities.GetComponent(compID);				
				WriteEntityBaseAttributes(writer,comp);
				
				//structure
				writer.WriteStartElement("Structure");
				IInterfaceIdentifier[] ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetProvidesInterfaceIDs();
				WriteEntityGuids(writer,"ProvidesInterface",ifaceIDs);
				ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetRequiresInterfaceIDs();
				WriteEntityGuids(writer,"RequiresInterface",ifaceIDs);
				IComponentIdentifier[] bcIDs = query.QueryTypeLevel.QueryCompositeComponent(compID).GetBasicComponents();
				IComponentIdentifier[] ccIDs = query.QueryTypeLevel.QueryCompositeComponent(compID).GetCompositeComponents();
				WriteEntityGuids(writer,"Component",bcIDs);
				WriteEntityGuids(writer,"Component",ccIDs);
				IConnectionIdentifier[] conIDs = query.QueryTypeLevel.QueryCompositeComponent(compID).GetConnections();
				WriteConnectionRef(writer,conIDs);
				writer.WriteEndElement();					
			
				//entities
				writer.WriteStartElement("Entities");
				WriteBasicComponentsTL(writer,bcIDs);
				WriteCompositeComponentsTL(writer,ccIDs);
				WriteConnections(writer,conIDs);
				writer.WriteEndElement();

				writer.WriteEndElement();	
			}			
		}

		#endregion

		#region implementationlevel methods 

		//writes the implementation part of the model
		private void WriteILModel(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRootIL");

			writer.WriteEndElement();
		}

		#endregion

		#region deploymentlevel methods 

		//writes the deployment part of the model
		private void WriteDLModel(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRootDL");

			writer.WriteEndElement();
		}

		#endregion

		#region entity write methods

		//writes the given connections
		private void WriteConnections(XmlWriter writer, params IConnectionIdentifier[] conIDs)
		{
			foreach(IConnectionIdentifier conID in conIDs)
			{
				IConnection con = query.QueryEntities.GetConnection(conID);
				writer.WriteStartElement("Connector");
				WriteEntityBaseAttributes(writer,con);
				writer.WriteEndElement();
			}						
		}

		//writes the structure of the given connections
		private void WriteConnectionRef(XmlWriter writer, IConnectionIdentifier[] conIDs)
		{
			foreach(IConnectionIdentifier conID in conIDs)
			{
				IComponentIdentifier incomingCompID = query.QueryTypeLevel.QueryConnection(conID).GetRequiringComponent();
				IComponentIdentifier outgoingCompID = query.QueryTypeLevel.QueryConnection(conID).GetProvidingComponent();
				IInterfaceIdentifier incomingIfaceID = query.QueryTypeLevel.QueryConnection(conID).GetRequiringInterface();
				IInterfaceIdentifier outgoingIfaceID = query.QueryTypeLevel.QueryConnection(conID).GetProvidingInterface();
				writer.WriteStartElement("Connector");

				writer.WriteAttributeString("guid",conID.Key);
				writer.WriteElementString("incomingCompID",incomingCompID.Key);
				writer.WriteElementString("incomingIFaceID",incomingIfaceID.Key);
				writer.WriteElementString("outgoingCompID",outgoingCompID.Key);
				writer.WriteElementString("outgoingIFaceID",outgoingIfaceID.Key);

				writer.WriteEndElement();
			}
		}

		//writes the given interfaces
		private void WriteInterfaces(XmlWriter writer, params IInterfaceIdentifier[] ifaceIDs)
		{
			foreach(IInterfaceIdentifier ifaceID in ifaceIDs)
			{
				IInterface iface = query.QueryEntities.GetInterface(ifaceID);
				writer.WriteStartElement("Interface");
				WriteEntityBaseAttributes(writer,iface);

				//structure
				writer.WriteStartElement("Structure");
				ISignatureIdentifier[] sigIDs = query.QueryTypeLevel.QueryInterface(ifaceID).GetSignatures();
				WriteEntityGuids(writer,"Signature",sigIDs);
				IProtocolIdentifier[] protIDs = query.QueryTypeLevel.QueryInterface(ifaceID).GetProtocols();
				WriteEntityGuids(writer,"Protocol",protIDs);
				writer.WriteEndElement();

				//entities
				writer.WriteStartElement("Entities");
				WriteSignatures(writer,sigIDs);
				WriteProtocols(writer,protIDs);
				writer.WriteEndElement();

				writer.WriteEndElement();
			}
		}

		//writes the given signatures
		private void WriteSignatures(XmlWriter writer, params ISignatureIdentifier[] sigIDs)
		{
			foreach(ISignatureIdentifier sigID in sigIDs)
			{
				ISignature sig = query.QueryEntities.GetSignature(sigID);
				writer.WriteStartElement("Signature");
				WriteEntityBaseAttributes(writer,sig);
				
				writer.WriteElementString("ReturnType",sig.ReturnType.ToString());				
				WriteParameters(writer,sig.Parameters);
				foreach(Type t in sig.Exceptions)
					writer.WriteElementString("Exception",t.ToString());
				writer.WriteEndElement();
			}
		}

		//writes the given parameters
		private void WriteParameters(XmlWriter writer, params IParameter[] parms)
		{
			foreach(IParameter parm in parms)
			{
				writer.WriteStartElement("Parameter");
				writer.WriteElementString("Name",parm.Name);
				writer.WriteElementString("Type",parm.Type.ToString());
				writer.WriteElementString("Modifier",""+(byte)parm.Modifier);
				writer.WriteEndElement();
			}
		}

		//writes the given protocols
		private void WriteProtocols(XmlWriter writer, params IProtocolIdentifier[] protIDs)
		{
			foreach(IProtocolIdentifier protID in protIDs)
			{
				IProtocol prot = query.QueryEntities.GetProtocol(protID);
				writer.WriteStartElement("Protocol");
				writer.WriteAttributeString("type",prot.ProtocolTypeID.Key);
				writer.WriteAttributeString("guid",prot.ProtocolID.Key);
				IXmlProtocolPlugIn protocolPlugIn = (IXmlProtocolPlugIn) plugins[prot.ProtocolTypeID];
				if (protocolPlugIn == null)
					throw new ModelSerializationException("No plugin found for protocoltype \""+prot.ProtocolTypeID.Key+"\".");
                protocolPlugIn.SaveProtocol(writer, prot);
				writer.WriteEndElement();
			}
		}

		//writes the basic attributes of each entity
		private void WriteEntityBaseAttributes(XmlWriter writer, IComponentModelEntity entity)
		{
			writer.WriteAttributeString("guid",entity.ID.Key);			
			writer.WriteElementString("Name",entity.Name);
			writer.WriteStartElement("Attributes");
			foreach(IAttributeType attrType in entity.Attributes.AttributeTypes)
			{
				IXmlAttributePlugIn attrPlugIn = (IXmlAttributePlugIn) plugins[attrType];
				if (attrPlugIn == null)
					throw new ModelSerializationException("No plugin found for attributetype \""+attrType.DisplayName+"\".");				

				IAttribute attr = entity.Attributes[attrType];
				writer.WriteStartElement("Attribute");
				writer.WriteAttributeString("type",attrType.GUID.ToString());
				attrPlugIn.SaveAttribute(writer,attr);
				writer.WriteEndElement();
			}

			writer.WriteEndElement();
		}

		//writes the guid reference of an entity. Used in structure parts of composite components etc.
		private void WriteEntityGuids(XmlWriter writer,string entityTag, params IIdentifier[] entities)
		{
			foreach(IIdentifier entityID in entities)
			{
				writer.WriteStartElement(entityTag);
				writer.WriteAttributeString("guid",entityID.Key);
				writer.WriteEndElement();
			}
		}

		#endregion

	}
}
