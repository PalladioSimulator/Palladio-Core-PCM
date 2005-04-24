using System;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Query;

namespace Palladio.ComponentModel.Serialization
{
	/// <summary>
	/// This interface defines methods that must be implemented by a serializer. Serializer are registered in 
	/// the SerializationManager to support several methods of loading and storing the model. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/24 19:15:26  joemal
	/// add serialization manager
	///
	///
	/// </pre>
	/// </remarks>
	public interface ISerializer
	{
		/// <summary>
		/// called by the serialization manager when the serializer has been registered. This method can be used to 
		/// inilize the serializer.
		/// </summary>
		/// <param name="builderManager">the buildermanager, used to create a model</param>
		/// <param name="queryManager">the querymanager used to retrieve informations from the model</param>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while inilizing the serializer.</exception>
		void Registered(IBuilderManager builderManager, IQuery queryManager);

		/// <summary>
		/// called to load a model from the given location. The location is from one of the supported location types, returned
		/// by the properties. The serializer can throw the two specified exceptions.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while reading the model.</exception>
		void Load(ISerializationLocation location);

		/// <summary>
		/// called to store a model to the given location. The location is from one of the supported location types, returned
		/// by the properties. The serializer can throw the two specified exceptions.
		/// </summary>
		/// <param name="location">the location</param>
 		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while writing the model.</exception>
		void Store(ISerializationLocation location);

		/// <summary>
		/// called by the serialization manager after the serializer has been unregistered. This method can be used to 
		/// tidy up and free resources the serializer has used.
		/// </summary>
		void UnRegistered();

		/// <summary>
		/// the property has to return an array of supported location types. The load and store methods must support the
		/// serialization and deserialization from this localtion types.
		/// </summary>
		Type[] SupportedLocationTypes
		{
			get;
		}
	}
}
