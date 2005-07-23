using Palladio.ComponentModel;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.Types
{
	/// <summary>
	/// The internal implementation of a simple string type. Only the name is stored by this implementation.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/07/23 18:53:57  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class StringType : IType
	{
		#region data

		//the id of this implementation
		internal static ITypeIdentifier TYPEID = 
			ComponentModelIdentifier.CreateTypeID("F7982654-445E-4f86-BF2B-7388E36C7991");

		//holds the name of the type
		private string typeName;

		#endregion

		/// <summary>
		/// called to create a new stringtype
		/// </summary>
		/// <param name="typeName">the name of the type</param>
		public StringType(string typeName)
		{
			this.typeName = typeName;
		}

		/// <summary>
		/// returns the id of the type. This id is unique for an implementation of IType.
		/// </summary>
		public ITypeIdentifier TypeID
		{
			get
			{
				return StringType.TYPEID;
			}
		}

		/// <summary>
		/// returns the name of the type
		/// </summary>
		public string Name
		{
			get 
			{
				return this.typeName;
			}
		}

		/// <summary>
		/// two string types are equals if their names are the same
		/// </summary>
		/// <param name="obj">the object to be compared</param>
		/// <returns>true, if obj is from type stringtype and the names are the same</returns>
		public override bool Equals(object obj)
		{
			if (obj is StringType)
				return (this.Name == ((StringType)obj).Name);

			return false;
		}

		/// <summary>
		/// return a new hashcode for this type
		/// </summary>
		/// <returns>the hashcode</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode() ^ (0xF0F0 << 3);
		}
	}
}
