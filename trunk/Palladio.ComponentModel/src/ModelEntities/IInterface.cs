using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// An Interface is the description of an interface (of a component).
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IInterface : IComponentModelEntity
	{
		/// <summary>
		/// returns the typed id of the interface
		/// </summary>
		IInterfaceIdentifier InterfaceID
		{
			get;
		}

		/// <summary>
		/// The name of the Interface
		/// </summary>
		string Name { get; set; }
	}
}
