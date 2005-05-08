using System;
using System.Collections;
using System.Runtime.Serialization;
using System.Xml;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;
using Palladio.Identifier;

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
				throw new SerializationException("Unable to create the xml file "+location.XmlFile+".",exception);
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
//			try
//			{
				writer.WriteStartElement("ComponentModel",XmlSerializer.XMLNAMESPACE);
				WriteTLModel(writer);
				WriteILModel(writer);
				WriteDLModel(writer);
//			}
//			catch(Exception exc)
//			{
//				Console.WriteLine("Error: "+exc);
//				throw new SerializationException("Unable to write to the xml file.",exc);
//			}
		}

		#endregion

		#region typelevel methods

		private void WriteTLModel(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRootTL");
			
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

			writer.WriteStartElement("Entities");
			WriteInterfaces(writer,ifaceIDs);
			WriteBasicComponentsTL(writer,basicCompIDs);
			WriteCompositeComponentsTL(writer,compositeCompIDs);
			WriteConnections(writer,conIDs);
			writer.WriteEndElement();

			writer.WriteEndElement();
		}

		private void WriteBasicComponentsTL(XmlWriter writer, params IComponentIdentifier[] compIDs)
		{
			foreach (IComponentIdentifier compID in compIDs)
			{				
				writer.WriteStartElement("BasicComponent");
				
				IComponent comp = query.QueryEntities.GetComponent(compID);				
				WriteEntityBaseAttributes(writer,comp);
				
				writer.WriteStartElement("Structure");
				IInterfaceIdentifier[] ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetProvidesInterfaceIDs();
				WriteEntityGuids(writer,"ProvidesInterface",ifaceIDs);
				ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetRequiresInterfaceIDs();
				WriteEntityGuids(writer,"RequiresInterface",ifaceIDs);
				writer.WriteEndElement();								

				writer.WriteEndElement();	
			}
		}

		private void WriteCompositeComponentsTL(XmlWriter writer, params IComponentIdentifier[] compIDs)
		{
			foreach (IComponentIdentifier compID in compIDs)
			{				
				writer.WriteStartElement("CompositeComponent");
				
				IComponent comp = query.QueryEntities.GetComponent(compID);				
				WriteEntityBaseAttributes(writer,comp);
				
				writer.WriteStartElement("Structure");
				IInterfaceIdentifier[] ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetProvidesInterfaceIDs();
				WriteEntityGuids(writer,"ProvidesInterface",ifaceIDs);
				ifaceIDs = query.QueryTypeLevel.QueryComponent(compID).GetRequiresInterfaceIDs();
				WriteEntityGuids(writer,"RequiresInterface",ifaceIDs);
				IComponentIdentifier[] bcIDs = query.QueryTypeLevel.QueryCompositeComponent(compID).getBasicComponents();
				IComponentIdentifier[] ccIDs = query.QueryTypeLevel.QueryCompositeComponent(compID).getCompositeComponents();
				WriteEntityGuids(writer,"Component",bcIDs);
				WriteEntityGuids(writer,"Component",ccIDs);
				IConnectionIdentifier[] conIDs = query.QueryTypeLevel.QueryCompositeComponent(compID).GetConnections();
				WriteConnectionRef(writer,conIDs);
				writer.WriteEndElement();					
			
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

		private void WriteILModel(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRootIL");

			writer.WriteEndElement();
		}

		#endregion

		#region deploymentlevel methods 

		private void WriteDLModel(XmlWriter writer)
		{
			writer.WriteStartElement("StaticViewRootDL");

			writer.WriteEndElement();
		}

		#endregion

		#region entity write methods

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

		private void WriteInterfaces(XmlWriter writer, params IInterfaceIdentifier[] ifaceIDs)
		{
			foreach(IInterfaceIdentifier ifaceID in ifaceIDs)
			{
				IInterface iface = query.QueryEntities.GetInterface(ifaceID);
				writer.WriteStartElement("Interface");
				WriteEntityBaseAttributes(writer,iface);

				writer.WriteStartElement("Structure");
				ISignatureIdentifier[] sigIDs = query.QueryTypeLevel.QueryInterface(ifaceID).GetSignatures();
				WriteEntityGuids(writer,"Signature",sigIDs);
				IProtocolIdentifier[] protIDs = query.QueryTypeLevel.QueryInterface(ifaceID).GetProtocols();
				WriteEntityGuids(writer,"Protocol",protIDs);
				writer.WriteEndElement();

				writer.WriteStartElement("Entities");
				WriteSignatures(writer,sigIDs);
				WriteProtocols(writer,protIDs);
				writer.WriteEndElement();

				writer.WriteEndElement();
			}
		}

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

		private void WriteParameters(XmlWriter writer, params IParameter[] parms)
		{
			//todo: modify schema 
			//parms[0].
			foreach(IParameter parm in parms)
				writer.WriteElementString("Parameter",parm.Name);
		}

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
					throw new SerializationException("No plugin found for protocoltype \""+prot.ProtocolTypeID.Key+"\".");
                protocolPlugIn.SaveProtocol(writer, prot);
				writer.WriteEndElement();
			}
		}

		private void WriteEntityBaseAttributes(XmlWriter writer, IComponentModelEntity entity)
		{
			writer.WriteAttributeString("guid",entity.ID.Key);			
			writer.WriteElementString("Name",entity.Name);
			writer.WriteStartElement("Attributes");
			//todo: write attributes
			//			foreach(IAttribute attr in entity.Attributes)

			writer.WriteEndElement();
		}

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
