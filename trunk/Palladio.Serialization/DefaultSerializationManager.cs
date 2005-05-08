using System;
using System.Collections;

namespace Palladio.Serialization
{
	/// <summary>
	/// This class is the default implementation of the serialization manager. Using Assemblies can directly create an instance
	/// of this class and use it. 
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
	///
	/// </pre>
	/// </remarks>
	public class DefaultSerializationManager : ISerializationManager
	{
		#region data

		/// <summary>
		/// holds the registered serializers
		/// </summary>
		private Hashtable serializers = new Hashtable();

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new manager.
		/// </summary>
		public DefaultSerializationManager()
		{
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to register a serializer. If another serializer already exists for one of the supported types of the new
		/// one, it is replaced. If the replaced serializer does not belong to any other supported type, its unregister-method
		/// is called.
		/// </summary>
		/// <param name="serializer">the serializer</param>
		public void RegisterSerializer(ISerializer serializer)
		{
			foreach (Type t in serializer.SupportedLocationTypes)
			{
				CheckUnusedSerializers(t);
				serializers[t] = serializer;
			}
			serializer.Registered();
		}

		/// <summary>
		/// called to load a model from the given location. If the manager could not find a serializer for the type
		/// of the given location, it throws an UnknownTypeException.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="ModelSerializationException">thrown if the location can't be opened.</exception>
		/// <exception cref="UnknownTypeException">thrown if an error occurs while reading the model.</exception>
		/// <exception cref="OpenLocationException">thrown if no serializer could be found for the type 
		/// of the given location.</exception>
		public void Load(ISerializationLocation location)
		{
			ISerializer serializer = (ISerializer) serializers[location.GetType()];
			if (serializer == null)
				throw new UnknownTypeException(location);
            serializer.Load(location);
		}

		/// <summary>
		/// called to store a model to the given location. If the manager could not find a serializer for the type
		/// of the given location, it throws an UnknownTypeException.
		/// </summary>
		/// <param name="location">the location</param>
		/// <exception cref="ModelSerializationException">thrown if the location can't be opened.</exception>
		/// <exception cref="OpenLocationException">thrown if an error occurs while writing the model.</exception>
		/// <exception cref="UnknownTypeException">thrown if no serializer could be found for the type of 
		/// the given location.</exception>
		public void Store(ISerializationLocation location)
		{
			ISerializer serializer = (ISerializer) serializers[location.GetType()];
			if (serializer == null)
				throw new UnknownTypeException(location);
			serializer.Store(location);
		}

		/// <summary>
		/// called to unregister serializer that are registered for the given location types. 
		/// </summary>
		/// <param name="supportedTypes">a set of types</param>
		public void UnregisterSerializer(params Type[] supportedTypes)
		{
			foreach(Type t in supportedTypes)
			{
				CheckUnusedSerializers(t);
				serializers.Remove(t);
			}
		}

		#endregion

		#region private methods

		//called to check, whether a serlializer is registered for the given type. If one has been found, its
		//unregister method is called, if its is only registered for the given type.
		private void CheckUnusedSerializers(Type type)
		{
			if (!serializers.ContainsKey(type)) return;
			ISerializer replacedSerializer = (ISerializer) serializers[type];

			int a=0;
			foreach(ISerializer serializer in this.serializers.Values)
				if (serializer == replacedSerializer) a++;
			
			//the only found instance is replaced by a new one or removed->the serializer is not needed any longer
            if (a==1)
				replacedSerializer.UnRegistered();
		}

		#endregion
	}
}
