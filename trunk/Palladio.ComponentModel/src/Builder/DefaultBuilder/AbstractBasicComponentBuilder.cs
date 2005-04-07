using System;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the basic component builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractBasicComponentBuilder : IBasicComponentBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;
		private IComponent component;


		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="component">The component to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IComponent component)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.component = component;
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
