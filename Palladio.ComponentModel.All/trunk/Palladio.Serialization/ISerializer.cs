using System;

namespace Palladio.Serialization
{
	/// <summary>
	/// This interface defines methods that must be implemented by a serializer. Serializers are registered in 
	/// the SerializationManager to support several methods to load or store a model. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/08 12:07:09  joemal
	/// add exception clause in comments
	///
	/// Revision 1.1  2005/04/25 16:34:34  joemal
	/// initial creation
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
		/// <exception cref="ModelSerializationException">thrown if an error occurs while inilizing the serializer.</exception>
		void Registered();

		/// <summary>
		/// called to load a model from the given location. The location is from one of the supported location types, returned
		/// by the properties. The serializer can throw the two specified exceptions.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while reading the model.</exception>
 		/// <exception cref="ArgumentException">thrown, if the type of the location is not one of the supported ones.</exception>
		void Load(ISerializationLocation location);

		/// <summary>
		/// called to store a model to the given location. The location is from one of the supported location types, returned
		/// by the properties. The serializer can throw the two specified exceptions.
		/// </summary>
		/// <param name="location">the location</param>
 		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while writing the model.</exception>
		/// <exception cref="ArgumentException">thrown, if the type of the location is not one of the supported ones.</exception>
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
