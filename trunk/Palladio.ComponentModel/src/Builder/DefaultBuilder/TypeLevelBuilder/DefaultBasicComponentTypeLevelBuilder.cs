using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the basic component builder at the type level.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/06 19:06:59  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.2  2005/03/18 07:36:27  kelsaka
	/// - corrected errors
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public class DefaultBasicComponentTypeLevelBuilder : IBasicComponentBuilder, IBasicComponentDeploymentLevelBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;


		public DefaultBasicComponentTypeLevelBuilder(ILowLevelBuilder lowLevelBulder) 
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

		public IBasicComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException (); }
		}

		/// <summary>
		/// called to add an existing interface to a component.
		/// </summary>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">determ whether the interface is bound as requires or provides interface</param>
		public IInterfaceBuilder AddInterface (IInterfaceIdentifier ifaceIdentifier, InterfaceRole role)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a new <see cref="IInterfaceBuilder"/>, which allows to build new interfaces.
		/// </summary>
		/// <returns>A new InterfaceBuilder.</returns>
		public IInterfaceBuilder AddInterface ()
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveInterface (IInterfaceIdentifier ifaceID)
		{
			throw new NotImplementedException ();
		}
	}
}
