using System;
using System.Collections;
using System.IO;
using System.Text;
using System.Xml;
using System.Xml.Schema;
using System.Xml.Serialization;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// Serializer for the Palladio Finite State Machines (FSMs). Handles laoding and saving of
	/// FSMs including <see cref="IAttribute"/>s and <see cref="IInput"/>s.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/18 09:30:47  kelsaka
	/// - extraced load and save into separate classes
	/// - started implementation of loading from xml
	///
	/// </code>
	/// </remarks>
	internal class FSMLoader
	{
		/// <summary>
		/// Use the attribute type GUID as key.
		/// </summary>
		private Hashtable attributeSerializerPlugins;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public FSMLoader()
		{
		}

		#region public methods

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a <see cref="XmlNode"/>.
		/// </summary>
		/// <param name="xmlNode">A xmlNode that represents a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		public IFiniteStateMachine Load (XmlNode xmlNode, Hashtable attributeSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		public IFiniteStateMachine Load (FileInfo xmlFilePath, Hashtable attributeSerializerPlugins)
		{
			this.attributeSerializerPlugins = attributeSerializerPlugins;
			IEditableFiniteStateMachine efsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());

			XmlTextReader xmlTextReader = new XmlTextReader(xmlFilePath.Name);

			XmlValidatingReader validatingReader = null;
			try 
			{
				validatingReader = new XmlValidatingReader(xmlTextReader);
				validatingReader.ValidationType = ValidationType.Schema;			
	
				XmlSchemaCollection schemaCollection = new XmlSchemaCollection();
				schemaCollection.Add(XMLSerializer.XMLNAMESPACE,
					System.AppDomain.CurrentDomain.BaseDirectory+"\\Palladio.ComponentModel.xsd");

				foreach(IAttributeSerializerPlugin plugin in attributeSerializerPlugins.Values)
					schemaCollection.Add(plugin.XmlNamespace, plugin.XmlSchemaURI);

				validatingReader.Schemas.Add(schemaCollection);
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
				xmlDoc.Load(validatingReader);
				validatingReader.Close();
			}
			catch(Exception exc)
			{
				throw new ModelSerializationException("Unable to load the xml document.",exc);
			}

			XmlNamespaceManager mgr = new XmlNamespaceManager(xmlDoc.NameTable);
			mgr.AddNamespace("cm",XMLSerializer.XMLNAMESPACE);

			
			return efsm;
		}

		#endregion
	}
}
