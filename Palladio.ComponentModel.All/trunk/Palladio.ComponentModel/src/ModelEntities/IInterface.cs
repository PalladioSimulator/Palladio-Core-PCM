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
	/// Revision 1.3  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.2  2005/03/16 13:32:34  joemal
	/// implement lowlevelbuilder
	///
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
	}

	/// <summary>
	/// determ wether an interfaces that is bound to an component is in provides or requires role
	/// </summary>
	public enum InterfaceRole
	{
		/// <summary>
		/// The bound interface is in provides role
		/// </summary>
		PROVIDES,

		/// <summary>
		/// The bound interface is in requires role
		/// </summary>
		REQUIRES
	}
}
