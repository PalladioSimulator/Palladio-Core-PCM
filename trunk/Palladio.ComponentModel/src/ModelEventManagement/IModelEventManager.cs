namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface defines the methods and properties of the ModelEventManager.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal interface IModelEventManager
	{
		/// <summary>
		/// returns the interface to all component model events. 
		/// </summary>
		IEventInterface EventInterface { get; }

		/// <summary>
		/// returns the registration part of the manager. 
		/// </summary>
		IEntityRegistration EntityRegistration{get;}
	}
}