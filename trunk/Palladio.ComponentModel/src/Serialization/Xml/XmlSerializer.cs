using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.Query;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This is an implementation of the xml serializer.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/24 16:48:58  joemal
	/// connect the reader
	///
	/// Revision 1.1  2005/05/08 12:02:16  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	internal class XmlSerializer : IXmlSerializer 
	{
		#region data

		//the namespace of the componentmodels xml tree
		public const string XMLNAMESPACE = "http://palladio.informatik.uni-oldenburg.de/XSD";

		//holds the supported types of the serializer
		private static Type[] SUPPORTED_TYPES = {typeof(XmlFileLocation),typeof(XmlNodeLocation)};

		//holds the query interface of the componentmodel
		private IQuery query;

		//holds the builder interface of the componentmodel
		private IBuilderManager builderManager;

		//holds the registered plugins
		private Hashtable plugins=new Hashtable(); 

		#endregion

		#region constructor 

		/// <summary>
		/// called to create a new serializer.
		/// </summary>
		/// <param name="query">the query interface of the componentmodel</param>
		/// <param name="builderManager">the builder interface of the componentmodel</param>
		public XmlSerializer(IQuery query, IBuilderManager builderManager)
		{
			this.query = query;
			this.builderManager = builderManager;
		}

		#endregion

		#region public methods

		/// <summary>
		/// called by the serialization manager when the serializer has been registered. This method can be used to 
		/// inilize the serializer.
		/// </summary>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while inilizing the serializer.</exception>
		public void Registered()
		{
			//not needed
		}

		/// <summary>
		/// called to load a model from the given location. The location is from one of the supported location types, returned
		/// by the properties. The serializer can throw the two specified exceptions.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while reading the model.</exception>
		/// <exception cref="ArgumentException">thrown, if the type of the location is not one of the supported ones.</exception>
		public void Load(ISerializationLocation location)
		{
			if (location is XmlFileLocation)
				new XmlCMReader(builderManager,plugins).Read((XmlFileLocation)location);
			else if (location is XmlNodeLocation)
				new XmlCMReader(builderManager,plugins).Read((XmlNodeLocation)location);
			else
				throw new ArgumentException("Unsupported type of location");
		}

		/// <summary>
		/// called to store a model to the given location. The location is from one of the supported location types, returned
		/// by the properties. The serializer can throw the two specified exceptions.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while writing the model.</exception>
		/// <exception cref="ArgumentException">thrown, if the type of the location is not one of the supported ones.</exception>
		public void Store(ISerializationLocation location)
		{
			if (location is XmlFileLocation)
				new XmlCMWriter(query, plugins).Write((XmlFileLocation)location);
			else if (location is XmlNodeLocation)
				new XmlCMWriter(query, plugins).Write((XmlNodeLocation)location);
			else
				throw new ArgumentException("Unsupported type of location");
		}

		/// <summary>
		/// called by the serialization manager after the serializer has been unregistered. This method can be used to 
		/// tidy up and free resources the serializer has used.
		/// </summary>
		public void UnRegistered()
		{
			//not needed
		}

		/// <summary>
		/// called to register a plugin that can be used to load and store protocols.
		/// </summary>
		/// <param name="plugIn">the plugin</param>
		public void RegisterProcotocolPlugin(IXmlProtocolPlugIn plugIn)
		{
			RegisterPlugIn(plugIn,plugIn.SupportedTypes);
		}

		/// <summary>
		/// called to unregister plugins that are used to load and store protocols from given types.
		/// </summary>
		/// <param name="protocolsTypes">the types of the protocols</param>
		public void UnregisterProtocolPlugin(params IProtocolTypeIdentifier[] protocolsTypes)
		{
			this.UnregisterPlugIn(protocolsTypes);
		}

		/// <summary>
		/// called to register a plugin that can be used to load and store attributes.
		/// </summary>
		/// <param name="plugIn"></param>
		public void RegisterAttributePlugin(IXmlAttributePlugIn plugIn)
		{
			this.RegisterPlugIn(plugIn,plugIn.SupportedTypes);
		}

		/// <summary>
		/// called to unregister plugins that are used to load and store attributes from given types.
		/// </summary>
		/// <param name="attributeTypes">the types of the attributes</param>
		public void UnregisterAttributePlugin(params IAttributeType[] attributeTypes)
		{
			this.UnregisterPlugIn(attributeTypes);
		}

		#endregion

		#region private methods

		//called to register the given plugin for the given types
		private void RegisterPlugIn(IXmlPlugIn plugIn, object[] supportedTypes)
		{
			foreach (Type t in supportedTypes)
			{
				CheckUnusedSerializers(t);
				plugins[t] = plugIn;
			}		
			plugIn.Registered();			
		}

		//called to unregister a plugin for the given types
		private void UnregisterPlugIn(object[] types)
		{
			foreach(Type t in types)
			{
				CheckUnusedSerializers(t);
				plugins.Remove(t);
			}			
		}

		//called to check, whether a plugin is registered for the given type. If one has been found, its
		//unregister method is called, if its is only registered for the given type.
		private void CheckUnusedSerializers(Type type)
		{
			if (!plugins.ContainsKey(type)) return;
			IXmlPlugIn plugin = (IXmlPlugIn) plugins[type];

			int a=0;
			foreach(IXmlPlugIn aPlugIn in this.plugins.Values)
				if (aPlugIn == plugin) a++;
			
			//the only found instance is replaced by a new one or removed->the serializer is not needed any longer
			if (a==1)
				plugin.Unregistered();
		}

		#endregion

		#region properties

		/// <summary>
		/// the property has to return an array of supported location types. The load and store methods must support the
		/// serialization and deserialization from this localtion types.
		/// </summary>
		public Type[] SupportedLocationTypes
		{
			get
			{
				return XmlSerializer.SUPPORTED_TYPES;
			}
		}

		#endregion
	}
}
