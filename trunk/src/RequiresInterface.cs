using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Defines the requirements of a component.
	/// </summary>
	public class RequiresInterface : AbstractComponentInterface    	 
	{

		#region Constructors 

		public RequiresInterface( IInterfaceModel aReqIModel, string aName ) :
			base( aReqIModel, aName )
		{
		}

		public RequiresInterface(  RequiresInterface aReqIFace ) : 
			this( aReqIFace.IModel, aReqIFace.Name ) {}

		#endregion


		#region Methods

		public override object Clone()
		{
			return new RequiresInterface(this);
		}


		#endregion
	}
}
