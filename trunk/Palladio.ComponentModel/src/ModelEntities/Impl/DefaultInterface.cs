using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// Default Interface class. The interface has a name, an id and an attribute hashmap.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:37  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultInterface : AbstractEntity ,IInterface
	{
		#region Properties

		/// <summary>
		/// returns the typed id of this interface
		/// </summary>
		public IInterfaceIdentifier InterfaceID
		{
			get
			{
				return (IInterfaceIdentifier) id;
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an interface with given name and given id. 
		/// </summary>
		/// <param name="aID">ID of the interface</param>
		/// <param name="name">the name of the interface</param>
		public DefaultInterface(IInterfaceIdentifier aID, string name) : base(aID, name)
		{
		}		

		#endregion
	}
}