using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/03/18 07:36:27  kelsaka
	/// - corrected errors
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public class DefaultBasicComponentBuilder : IBasicComponentBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;


		public DefaultBasicComponentBuilder(ILowLevelBuilder lowLevelBulder) 
		{
			this.lowLevelBuilder = lowLevelBuilder;
		}


		/// <summary>
		/// called to add an existing interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">determ whether the interface is bound as requires or provides interface</param>
		public void AddInterfaceToComponent (IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, InterfaceRole role)
		{
			throw new NotImplementedException ();
		}
	}
}
