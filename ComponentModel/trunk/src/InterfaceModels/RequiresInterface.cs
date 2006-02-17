using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A RequiresInterface is used to specify the services and its relations
	/// required by a component.
	/// </summary>
	public class RequiresInterface : AbstractComponentInterface    	 
	{
		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new RequiresInterface(this);
		}
		#endregion

		#region Constructors 

		/// <summary>
		/// Creates a new RequiresInterface using aRequiresIModel for
		/// the description of the required services and aName as name
		/// of the interface. 
		/// </summary>
		/// <param name="aReqIModel">IInterfaceModel describing 
		/// the required services.</param>
		/// <param name="aName">An unique name of the interface.</param>
		public RequiresInterface( IInterfaceModel aReqIModel, string aName ) :
			base( aReqIModel, aName )
		{
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aReqIface">RequiresInterface to copy.</param>
		public RequiresInterface(  RequiresInterface aReqIface ) : 
			this( aReqIface.IModel, aReqIface.Name ) {}

		#endregion
	}
}
