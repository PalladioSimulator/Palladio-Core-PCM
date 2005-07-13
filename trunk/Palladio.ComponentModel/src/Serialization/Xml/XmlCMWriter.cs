using System;
using System.Collections;
using System.Xml;
using Palladio.Attributes;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Query.TypeLevel;
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
	/// Revision 1.8  2005/07/13 11:06:01  joemal
	/// some changes of the entities attributes
	///
	/// Revision 1.7  2005/06/25 16:53:28  joemal
	/// merge the implementation with the changed xsd
	///
	/// Revision 1.6  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
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
			writer.WriteStartElement("TypeLevel");

			WriteStaticViewTL(writer);
			IComponent[] comps = query.QueryRepository.GetComponents();
			WriteBasicComponentTL(writer,comps);
			WriteCompositeComponentTL(writer,comps);
			WriteInterfaces(writer,query.QueryRepository.GetInterfaces());
			WriteSignatures(writer,query.QueryRepository.GetSignatures());
			WriteProtocols(writer,query.QueryRepository.GetProtocols());
			WriteConnections(writer,query.QueryRepository.GetConnections());

			writer.WriteEndElement();
		}

		//writes the static view root
		private void WriteStaticViewTL(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRoot");			
			writer.WriteStartElement("Structure");			
			WriteRefs(writer,"Component",query.QueryTypeLevel.QueryStaticView().GetComponents());
			WriteConnectorRefs(writer);
			writer.WriteEndElement();
			writer.WriteEndElement();
		}

		//writes the list of typelevel basic components
		private void WriteBasicComponentTL(XmlWriter writer, params IComponent[] comps)
		{
			foreach(IComponent comp in comps)
			{
				if (comp.Type != ComponentType.BASIC) continue;
				
				writer.WriteStartElement("BasicComponent");
				WriteEntityBaseAttributes(writer,comp);
				writer.WriteStartElement("Structure");			
				WriteRefs(writer,"ProvidesInterface",query.QueryTypeLevel.QueryComponent(comp.ComponentID).GetProvidesInterfaceIDs());
				WriteRefs(writer,"RequiresInterface",query.QueryTypeLevel.QueryComponent(comp.ComponentID).GetRequiresInterfaceIDs());
				writer.WriteEndElement();
				writer.WriteEndElement();				
			}
		}

		//writes the list of typelevel composite components
		private void WriteCompositeComponentTL(XmlWriter writer, params IComponent[] comps)
		{
			foreach(IComponent comp in comps)
			{
				if (comp.Type != ComponentType.COMPOSITE) continue;

				writer.WriteStartElement("CompositeComponent");
				WriteEntityBaseAttributes(writer,comp);
				writer.WriteStartElement("Structure");	
				IQueryCompositeComponentTypeLevel queryComp = query.QueryTypeLevel.QueryCompositeComponent(comp.ComponentID);
				WriteRefs(writer,"ProvidesInterface",queryComp.GetProvidesInterfaceIDs());
				WriteRefs(writer,"RequiresInterface",queryComp.GetRequiresInterfaceIDs());
				WriteRefs(writer,"Component",queryComp.GetComponents());
				WriteConnectorRefs(writer,comp.ComponentID);
				writer.WriteEndElement();
				writer.WriteEndElement();				
			}
		}

		#endregion

		#region implementationlevel methods 

		//writes the implementation part of the model
		private void WriteILModel(XmlWriter writer)
		{
			writer.WriteStartElement("ImplementationLevel");

			writer.WriteEndElement();
		}

		#endregion

		#region deploymentlevel methods 

		//writes the deployment part of the model
		private void WriteDLModel(XmlWriter writer)
		{
			writer.WriteStartElement("DeploymentLevel");

			writer.WriteEndElement();
		}

		#endregion

		#region entity write methods

		//writes the given connections
		private void WriteConnections(XmlWriter writer, params IConnection[] cons)
		{
			foreach(IConnection con in cons)
			{
				writer.WriteStartElement("Connector");
				WriteEntityBaseAttributes(writer,con);
				writer.WriteEndElement();
			}						
		}

		//writes the given interfaces
		private void WriteInterfaces(XmlWriter writer, params IInterface[] ifaces)
		{
			foreach(IInterface iface in ifaces)
			{
				writer.WriteStartElement("Interface");
				WriteEntityBaseAttributes(writer,iface);

				//structure
				writer.WriteStartElement("Structure");
				WriteRefs(writer,"Signature",query.QueryTypeLevel.QueryInterface(iface.InterfaceID).GetSignatures());
				WriteRefs(writer,"Protocol",query.QueryTypeLevel.QueryInterface(iface.InterfaceID).GetProtocols());
				writer.WriteEndElement();

				writer.WriteEndElement();
			}
		}

		//writes the given signatures
		private void WriteSignatures(XmlWriter writer, params ISignature[] sigs)
		{
			foreach(ISignature sig in sigs)
			{
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
		private void WriteProtocols(XmlWriter writer, params IProtocol[] prots)
		{
			foreach(IProtocol prot in prots)
			{
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
				writer.WriteElementString("Description",attrType.Description);
				writer.WriteElementString("Name",attrType.DisplayName);
				writer.WriteElementString("ValueType",attrType.ValueType.ToString());
				attrPlugIn.SaveAttribute(writer,attr);
				writer.WriteEndElement();
			}

			writer.WriteEndElement();
		}

		//writes the references to the listed entities
		private void WriteRefs(XmlWriter writer,string type, params IIdentifier[] identifiers)
		{
			foreach(IIdentifier entityID in identifiers)
			{
				writer.WriteStartElement(type);
				writer.WriteAttributeString("guid",entityID.Key);
				writer.WriteEndElement();
			}
		}

		//writes the references of the static views connectors
		private void WriteConnectorRefs(XmlWriter writer)
		{
			IConnectionIdentifier[] conIDs=query.QueryTypeLevel.QueryStaticView().GetConnections();

			foreach(IConnectionIdentifier conID in conIDs)
			{
				IQueryConnectionTypeLevel conQuery = query.QueryTypeLevel.QueryConnection(conID);
				writer.WriteStartElement("AssemblyConnector");
				writer.WriteAttributeString("guid",conID.Key);

				writer.WriteStartElement("ProvidingIFace");
				writer.WriteAttributeString("guid",conQuery.GetProvidingInterface().Key);
				writer.WriteEndElement();

				writer.WriteStartElement("ProvidingComponent");
				writer.WriteAttributeString("guid",conQuery.GetProvidingComponent().Key);
				writer.WriteEndElement();

				writer.WriteStartElement("RequireingIFace");
				writer.WriteAttributeString("guid",conQuery.GetRequiringInterface().Key);
				writer.WriteEndElement();

				writer.WriteStartElement("RequireingComponent");
				writer.WriteAttributeString("guid",conQuery.GetRequiringComponent().Key);
				writer.WriteEndElement();

				writer.WriteEndElement();

			}						
		}

		//writes the references of the components connectors
		private void WriteConnectorRefs(XmlWriter writer, IComponentIdentifier compID)
		{
			IConnectionIdentifier[] conIDs=query.QueryTypeLevel.QueryCompositeComponent(compID).GetAssemblyConnectors();			

			foreach(IConnectionIdentifier conID in conIDs)
			{
				IQueryConnectionTypeLevel conQuery = query.QueryTypeLevel.QueryConnection(conID);
				writer.WriteStartElement("AssemblyConnector");
				writer.WriteAttributeString("guid",conID.Key);

				writer.WriteStartElement("ProvidingIFace");
				writer.WriteAttributeString("guid",conQuery.GetProvidingInterface().Key);
				writer.WriteStartElement("ProvidingComponent");
				writer.WriteAttributeString("guid",conQuery.GetProvidingComponent().Key);
				writer.WriteStartElement("RequireingIFace");
				writer.WriteAttributeString("guid",conQuery.GetRequiringInterface().Key);
				writer.WriteStartElement("RequireingComponent");
				writer.WriteAttributeString("guid",conQuery.GetRequiringComponent().Key);
				writer.WriteEndElement();
			}			

			conIDs=query.QueryTypeLevel.QueryCompositeComponent(compID).GetDelegationConnectors();

			foreach(IConnectionIdentifier conID in conIDs)
			{
				IQueryConnectionTypeLevel conQuery = query.QueryTypeLevel.QueryConnection(conID);
				IInterfaceIdentifier reqIfaceID = conQuery.GetRequiringInterface();
				IComponentIdentifier reqCompID = conQuery.GetRequiringComponent();
				IInterfaceIdentifier provIfaceID = conQuery.GetProvidingInterface();
				IComponentIdentifier provCompID = conQuery.GetProvidingComponent();

				writer.WriteStartElement("DelegationConnector");
				writer.WriteAttributeString("guid",conID.Key);
				if (query.QueryTypeLevel.QueryComponent(compID).IsProvidesInterface(reqIfaceID))
				{
					writer.WriteElementString("Type","Provides");
					WriteRefs(writer,"InnerIFace",provIfaceID);
					WriteRefs(writer,"InnerComponent",provCompID);
					WriteRefs(writer,"OuterIFace",reqIfaceID);
				}
				else
				{
					writer.WriteElementString("Type","Requires");										
					WriteRefs(writer,"InnerIFace",reqIfaceID);
					WriteRefs(writer,"InnerComponent",reqCompID);
					WriteRefs(writer,"OuterIFace",provIfaceID);
				}

				writer.WriteEndElement();
			}			
		}

		#endregion
	}
}
