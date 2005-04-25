using System;

namespace Palladio.Serialization
{
	/// <summary>
	/// This interface defines the public members of the serialization manager.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/25 16:34:34  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface ISerializationManager
	{
		/// <summary>
		/// called to register a serializer. If another serializer already exists for one of the supported types of the new
		/// one, it is replaced. If the replaced serializer does not belong to any other supported type, its unregister-method
		/// is called.
		/// </summary>
		/// <param name="serializer">the serializer</param>
		void RegisterSerializer(ISerializer serializer);

		/// <summary>
		/// called to load a model from the given location. If the manager could not find a serializer for the type
		/// of the given location, it throws an UnknownTypeException.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while reading the model.</exception>
		/// <exception cref="UnknownTypeException">thrown if no serializer could be found for the type 
		/// of the given location.</exception>
		void Load(ISerializationLocation location);

		/// <summary>
		/// called to store a model to the given location. If the manager could not find a serializer for the type
		/// of the given location, it throws an UnknownTypeException.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="OpenLocationException">thrown if the location can't be opened.</exception>
		/// <exception cref="ModelSerializationException">thrown if an error occurs while writing the model.</exception>
		/// <exception cref="UnknownTypeException">thrown if no serializer could be found for the type of 
		/// the given location.</exception>
		void Store(ISerializationLocation location);

		/// <summary>
		/// called to unregister serializer that are registered for the given location types. 
		/// </summary>
		/// <param name="supportedTypes">a set of types</param>
		void UnregisterSerializer(params Type[] supportedTypes);
	}
}
