using System;
using System.Collections;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure.Elements;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Builder
{
	/// <summary>
	/// This class is the default implementation of the builder used to fill basic components.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.3  2004/06/23 16:33:51  joemal
	/// - add methods to hold the builders of the elements
	///
	/// Revision 1.2  2004/06/22 17:08:29  joemal
	/// - change method signature in service builder
	///
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultBasicComponentBuilder : AbstractComponentBuilder,IBasicComponentBuilder
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

		#endregion

		#region constructor

		/// <summary>
		/// constructs a new DefaultBasicComponentBuilder for the given component.
		/// </summary>
		/// <param name="component">the component filled with this builder.</param>
		/// <param name="elements">the factory, used to create the elements of the architecture</param>
		/// <param name="builder">the factory, used to create the builder</param>
		public DefaultBasicComponentBuilder(IBasicComponent component, IElementFactory elements, IBuilderFactory builder) 
			: base(component,elements,builder)
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// called to add a service to the basic component
		/// </summary>
		/// <param name="provIfaceID">the id of the provides interface to which the signature of the service has to be added</param>
		/// <param name="signatureID">the id of the signature</param>
		/// <returns>the builder to fill the service</returns>
		public IServiceBuilder AddService(IIdentifier provIfaceID, IIdentifier signatureID)
		{
			if (!this.BasicComponent.HasProvidesInterface(provIfaceID)) 
				this.BasicComponent.AddProvidesInterface(provIfaceID,ComponentFactory.CreateInterfaceModel());

			ISignature[] sigs = ComponentFactory.CreateSignatureArray(signatureID.ToString());
			this.BasicComponent.GetProvidesInterface(provIfaceID).SignatureList.AddSignatures(sigs);

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			this.BasicComponent.AddServiceEffectSpecification(provIfaceID,sigs[0],seff);

			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			seff.AddAuxiliarySpecification(fsmSeff);

			IServiceBuilder builder = this.builderFactory.CreateBuilder(this.BasicComponent,seff);
			serviceBuilderTable.Add(CreateExternalSignature(provIfaceID,signatureID),builder);

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
			ISignature sig = ComponentFactory.CreateSignatureArray(sigID.ToString())[0];
			return ComponentFactory.CreateSignatureWithRole(iFaceID,sig);			
		}

		#endregion
	}
}
//EOF
