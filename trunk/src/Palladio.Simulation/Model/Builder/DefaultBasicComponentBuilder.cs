using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.Simulation.Model.Elements;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This class is the default implementation of the builder used to fill basic components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>	
	/// </remarks>
	internal class DefaultBasicComponentBuilder : AbstractComponentBuilder,IBasicComponentBuilder
	{
		#region data

		/// <summary>
		/// holds the table of builders for the services
		/// </summary>
		private IDictionary serviceBuilderTable = new Hashtable();

		#endregion

		#region properties

		/// <summary>
		/// called to return the basic component, which has to be filled by this builder
		/// </summary>
		protected IBasicComponent BasicComponent
		{
			get
			{
				return (IBasicComponent)this.component;
			}
		}

		/// <summary>
		/// called to get the observer for this builders basiccomponent.
		/// </summary>
		protected IBasicComponentObserver BasicComponentObserver
		{
			get
			{
				return (IBasicComponentObserver)this.observer;
			}
		}

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new DefaultBasicComponentBuilder for the given component.
		/// </summary>
		/// <param name="component">the component filled with this builder.</param>
		/// <param name="elements">the factory, used to create the elements of the architecture</param>
		/// <param name="builder">the factory, used to create the builder</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		public DefaultBasicComponentBuilder(IBasicComponent component, IElementFactory elements, IBuilderFactory builder,
			IBasicComponentObserver observer): base(component,elements,builder,observer)
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// called to add a service to the basic component
		/// </summary>
		/// <param name="provIfaceID">the id of the provides interface to which the signature of the service has to be added</param>
		/// <param name="signatureID">the id of the signature</param>
		/// <param name="observer">
		/// The observer for the service. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder to fill the service</returns>/// <returns>the builder to fill the service</returns>
		public IServiceBuilder AddService(IIdentifier provIfaceID, IIdentifier signatureID,IServiceObserver observer)
		{
			if (!this.BasicComponent.HasProvidesInterface(provIfaceID)) 
				this.BasicComponent.AddProvidesInterface(provIfaceID,ComponentFactory.CreateInterfaceModel());

			ISignature sig = ComponentFactory.CreateSignature(signatureID.ToString());
			this.BasicComponent.GetProvidesInterface(provIfaceID).SignatureList.AddSignatures(sig);

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			this.BasicComponent.AddServiceEffectSpecification(provIfaceID,sig,seff);

			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			seff.AddAuxiliarySpecification(fsmSeff);

			IServiceBuilder builder = this.builderFactory.CreateBuilder(this.BasicComponent,seff,observer);
			serviceBuilderTable.Add(CreateExternalSignature(provIfaceID,signatureID),builder);

			if(observer != null)
				this.BasicComponentObserver.OnServiceAdded(this.component.ID,provIfaceID,signatureID);

			return builder;
		}

		/// <summary>
		/// call to get the builder for an existing service. Null is returned, if the service doesn't exist.
		/// </summary>
		/// <param name="provIfaceID">the id of the provides interface where the signature of the service can be found</param>
		/// <param name="signatureID">the id of the signature of the service</param>
		/// <returns>the builder</returns>
		public IServiceBuilder GetServiceBuilder(IIdentifier provIfaceID, IIdentifier signatureID)
		{
			return (IServiceBuilder)serviceBuilderTable[CreateExternalSignature(provIfaceID,signatureID)];
		}

		/// <summary>
		/// call to create an external signature from given iface id and signature id
		/// </summary>
		/// <param name="iFaceID"></param>
		/// <param name="sigID"></param>
		/// <returns></returns>
		private IExternalSignature CreateExternalSignature(IIdentifier iFaceID, IIdentifier sigID)
		{
			ISignature sig = ComponentFactory.CreateSignature(sigID.ToString());
			return ComponentFactory.CreateExternalSignature(iFaceID,sig);			
		}

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. 
		/// The Reset methods of all servicebuilders are called.
		/// </summary>
		public override void Reset()
		{
			foreach(IServiceBuilder builder in this.serviceBuilderTable.Values)
				builder.Reset();
		}

		#endregion
	}
}
//EOF
