using System;
using System.Xml;
using System.Xml.Schema;
using System.Collections;
using Palladio.Identifier;
using Palladio.Attributes;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für ModelPersistencyService.
	/// </summary>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1.2.2  2004/12/02 23:39:48  uffi
	/// IAttributeHash replaced by AttributeHash,
	/// added attribute serialization
	///
	/// </pre>
	public class ModelPersistencyService
	{
		private static ModelPersistencyService singletonInstance;

		private Hashtable entities; 
		private Hashtable repositoryInfos;

		protected ModelPersistencyService()
		{
			this.entities = new Hashtable();
			this.repositoryInfos = new Hashtable();
		}

		public static ModelPersistencyService Instance
		{
			get 
			{
				if (singletonInstance == null)
					singletonInstance = new ModelPersistencyService();
				return singletonInstance;
			}
		}

		// used by factory methods
		public void RegisterEntity(IIdentifiable entity, ModelPersistencyInfo info)
		{
			if (!this.entities.ContainsKey(entity.ID))
			{
				this.entities.Add(entity.ID, entity);
				Console.WriteLine("registered "+entity.ID);
				if (info == null)
					this.repositoryInfos.Add(entity.ID, ModelPersistencyInfo.ATTACHED);
				else
					this.repositoryInfos.Add(entity.ID, info);
			}
			else
			{
				this.entities[entity.ID] = entity;
//				//throw new Exception("ID schon registriert");
			}
		}

		public FirstClassEntity GetEntity(IIdentifier id)
		{
			return this.entities[id] as FirstClassEntity;
		}

		public void ClearEntityTable()
		{
			this.entities.Clear();
			this.repositoryInfos.Clear();
			Console.WriteLine("entity table cleared");
		}

		/// <summary>
		/// Loads a CompositeComponent which previously has been serialized into a XML file
		/// </summary>
		/// <param name="xmlFileName">The complete filename of the XML file</param>
		/// <returns>A new ICompositeComponent instance.</returns>
		public ICompositeComponent LoadCompositeComponent(string xmlFileName)
		{
			XmlTextReader textReader = new XmlTextReader(xmlFileName);
			textReader.WhitespaceHandling = WhitespaceHandling.None;

			// validate file against schema definition
			XmlValidatingReader validator = new XmlValidatingReader(textReader);
			validator.ValidationType = ValidationType.Schema;

			XmlSchemaCollection schemaCollection = new XmlSchemaCollection();
			schemaCollection.Add("http://palladio.informatik.uni-oldenburg.de/XSD","palladio_cm.ref.xsd");
			validator.Schemas.Add(schemaCollection);

			validator.ValidationEventHandler += new ValidationEventHandler(validator_ValidationEventHandler);

			while (validator.Read()) { }
			
			// file is valid. create dom tree
			validator.Close();
			textReader.Close();
			
			textReader = new XmlTextReader(xmlFileName);

			XmlDocument xmldoc = new XmlDocument();
			xmldoc.Load(textReader);

			ICompositeComponent result = LoadCompositeComponent(xmldoc.DocumentElement);

			textReader.Close();
			return result;
		}

		private ICompositeComponent LoadCompositeComponent(XmlNode root)
		{
			// find structure node
			XmlNode structureNode = root.FirstChild;
			while ( (structureNode != null) && structureNode.Name != "Structure")
			structureNode = structureNode.NextSibling;

			// find entities node
			XmlNode entitiesNode = root.FirstChild;
			while ( (entitiesNode != null) && entitiesNode.Name != "Entities")
			entitiesNode = entitiesNode.NextSibling;
					
			// process entities
			foreach (XmlNode entityNode in entitiesNode.ChildNodes)
			{
				string guid = entityNode.Attributes["guid"].Value;

				if (!this.entities.ContainsKey(guid)) // TODO changeEntity?
				{
					if (entityNode.Attributes["location"].Value == "attached" && entityNode.FirstChild != null)
					{
						if (entityNode.FirstChild.Name == "BasicComponent")
						{
							IBasicComponent attachedComp = LoadBasicComponent(entityNode.FirstChild);
							RegisterEntity(attachedComp, ModelPersistencyInfo.ATTACHED);
						}
						else if (entityNode.FirstChild.Name == "CompositeComponent")
						{
							ICompositeComponent attachedComp = LoadCompositeComponent(entityNode.FirstChild);
							RegisterEntity(attachedComp, ModelPersistencyInfo.ATTACHED);
						}
						else if (entityNode.FirstChild.Name == "Interface")
						{
							IInterfaceModel attachedInterface = LoadInterfaceModel(entityNode.FirstChild);
							RegisterEntity(attachedInterface, ModelPersistencyInfo.ATTACHED);
						}
					}
					else
					{
						// TODO repository attribute sammeln und entity laden
						//this.repositoryInfos.Add(guid, new ModelPersistencyInfo());
					}
				}
			}

			ICompositeComponent comp = ComponentFactory.CreateCompositeComponent(
				root.Attributes["name"].Value, 
				IdentifiableFactory.CreateGUID(root.Attributes["guid"].Value) as GloballyUniqueIdentifier,
				ModelPersistencyInfo.ATTACHED); // TODO

			comp.Deserialize(structureNode);
			return comp;
		}

		private IBasicComponent LoadBasicComponent(XmlNode root)
		{
			// find structure node
			XmlNode structureNode = root.FirstChild;
			while ( (structureNode != null) && structureNode.Name != "Structure")
				structureNode = structureNode.NextSibling;

			// find entities node
			XmlNode entitiesNode = root.FirstChild;
			while ( (entitiesNode != null) && entitiesNode.Name != "Entities")
				entitiesNode = entitiesNode.NextSibling;
					
			// process entities
			foreach (XmlNode entityNode in entitiesNode.ChildNodes)
			{
				string guid = entityNode.Attributes["guid"].Value;

				if (!this.entities.ContainsKey(guid)) // TODO changeEntity?
				{
					if (entityNode.Attributes["location"].Value == "attached" && entityNode.FirstChild != null)
					{
						if (entityNode.FirstChild.Name == "Interface")
						{
							IInterfaceModel attachedInterface = LoadInterfaceModel(entityNode.FirstChild);
							RegisterEntity(attachedInterface, ModelPersistencyInfo.ATTACHED);
						}
					}
					else
					{
						// TODO repository attribute sammeln und entity laden
						//this.repositoryInfos.Add(guid, new ModelPersistencyInfo());
					}
				}
			}

			IBasicComponent comp = ComponentFactory.CreateBasicComponent(
				root.Attributes["name"].Value,
				IdentifiableFactory.CreateGUID(root.Attributes["guid"].Value) as GloballyUniqueIdentifier,
				ModelPersistencyInfo.ATTACHED); // TODO

			comp.Deserialize(structureNode);
			return comp;
		}

		private IInterfaceModel LoadInterfaceModel(XmlNode root)
		{
			IInterfaceModel interfaceModel = ComponentFactory.CreateInterfaceModel(
				root.Attributes["name"].Value,
				IdentifiableFactory.CreateGUID(root.Attributes["guid"].Value) as GloballyUniqueIdentifier,
				ModelPersistencyInfo.ATTACHED); // TODO

			interfaceModel.Deserialize(root);
			return interfaceModel;
		}

		/// <summary>
		/// The Serialize method is used to write the model to a XML stream.
		/// </summary>
		/// <param name="filename">The name of the file into which this component shall be written.</param>
		public void SaveEntity(IIdentifier guid, string filename) 
		{
			if (!this.entities.ContainsKey(guid))
				throw new Exception("guid not found");

			FirstClassEntity entity = this.entities[guid] as FirstClassEntity;

			XmlTextWriter writer = new XmlTextWriter(filename,System.Text.Encoding.UTF8);
			writer.Formatting = Formatting.Indented;
			writer.Indentation= 3;
			writer.Namespaces = true;

			// Starts a new document
			writer.WriteStartDocument();

			SaveEntity(entity, writer);

			// Ends the document
			writer.WriteEndDocument();
			writer.Close();
		}

		private void SaveEntity(FirstClassEntity entity, XmlTextWriter writer)
		{
			if (entity is ICompositeComponent)
			{
				ICompositeComponent comp = entity as ICompositeComponent;

				writer.WriteStartElement("CompositeComponent","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",entity.Name);
				writer.WriteAttributeString("guid",entity.ID.ToString());

				foreach (IAttributeType attrType in comp.Attributes.Keys)
				{
					writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",attrType.GUID.ToString());
					comp.Attributes[attrType].Serialize(writer);
					writer.WriteEndElement();
				}

				writer.WriteStartElement("Structure","http://palladio.informatik.uni-oldenburg.de/XSD");

				entity.Serialize(writer);
 
				writer.WriteEndElement();

				writer.WriteStartElement("Entities","http://palladio.informatik.uni-oldenburg.de/XSD");			
				// create list of contained first-class entity ids
				ArrayList idList = new ArrayList();
				idList.AddRange(comp.ComponentIDs);
				foreach (IIdentifier id in comp.ProvidedRoles)
				{
					FirstClassEntity iface = comp.GetProvidesInterface(id) as FirstClassEntity;
					if (!idList.Contains( iface.ID ))
						idList.Add( iface.ID );
				}
				foreach (IIdentifier id in comp.RequiredRoles)
				{
					FirstClassEntity iface = comp.GetRequiresInterface(id) as FirstClassEntity;
					if (!idList.Contains( iface.ID ))
						idList.Add( iface.ID );
				}

				foreach (IIdentifier id in idList)
				{
					writer.WriteStartElement("Entity","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",id.ToString());

					if (this.repositoryInfos[id] == ModelPersistencyInfo.ATTACHED)
					{
						writer.WriteAttributeString("location","attached");

						FirstClassEntity embeddedEntity = this.entities[id] as FirstClassEntity;
						SaveEntity(embeddedEntity, writer);
					}
					writer.WriteEndElement();
				}
				writer.WriteEndElement();

				writer.WriteEndElement();
			}
			else if (entity is IBasicComponent)
			{
				IBasicComponent comp = entity as IBasicComponent;

				writer.WriteStartElement("BasicComponent","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",entity.Name);
				writer.WriteAttributeString("guid",entity.ID.ToString());

				foreach (IAttributeType attrType in comp.Attributes.Keys)
				{
					writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",attrType.GUID.ToString());
					comp.Attributes[attrType].Serialize(writer);
					writer.WriteEndElement();
				}

				writer.WriteStartElement("Structure","http://palladio.informatik.uni-oldenburg.de/XSD");

				entity.Serialize(writer);
 
				writer.WriteEndElement();

				writer.WriteStartElement("Entities","http://palladio.informatik.uni-oldenburg.de/XSD");			
				// create list of contained first-class entity ids
				ArrayList idList = new ArrayList();
				foreach (IIdentifier id in comp.ProvidedRoles)
				{
					FirstClassEntity iface = comp.GetProvidesInterface(id) as FirstClassEntity;
					if (!idList.Contains( iface.ID ))
						idList.Add( iface.ID );
				}
				foreach (IIdentifier id in comp.RequiredRoles)
				{
					FirstClassEntity iface = comp.GetRequiresInterface(id) as FirstClassEntity;
					if (!idList.Contains( iface.ID ))
						idList.Add( iface.ID );
				}

				foreach (IIdentifier id in idList)
				{
					writer.WriteStartElement("Entity","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",id.ToString());

					if (this.repositoryInfos[id] == ModelPersistencyInfo.ATTACHED)
					{
						writer.WriteAttributeString("location","attached");

						FirstClassEntity embeddedEntity = this.entities[id] as FirstClassEntity;
						SaveEntity(embeddedEntity, writer);
					}
					writer.WriteEndElement();
				}
				writer.WriteEndElement();

				writer.WriteEndElement();
			}
			else if (entity is IInterfaceModel)
			{
				IInterfaceModel iface = entity as IInterfaceModel;

				writer.WriteStartElement("Interface","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",entity.Name);
				writer.WriteAttributeString("guid",entity.ID.ToString());

				foreach (IAttributeType attrType in iface.Attributes.Keys)
				{
					writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",attrType.GUID.ToString());
					iface.Attributes[attrType].Serialize(writer);
					writer.WriteEndElement();
				}

				entity.Serialize(writer);

				writer.WriteEndElement();
			}
		}


		private static void validator_ValidationEventHandler(object sender, ValidationEventArgs e)
		{
			throw new Exception(e.Message);
		}
	}
}
