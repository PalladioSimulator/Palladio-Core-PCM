using System;
using Palladio.ComponentModel;
using ComponentNetworkSimulation.Structure.Elements;

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
	/// Revision 1.1  2004/06/22 12:17:19  joemal
	/// inital class creation
	///
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class DefaultBasicComponentBuilder : AbstractComponentBuilder,IBasicComponentBuilder
	{
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
		/// adds a service to the component. The service is defined by the given signature, which has to be added to 
		/// </summary>
		/// <param name="provIfaceID"></param>
		/// <param name="signatureID"></param>
		/// <returns></returns>
		public IServiceBuilder AddService(Palladio.Identifier.IIdentifier provIfaceID, Palladio.Identifier.IIdentifier signatureID)
		{
			if (!this.BasicComponent.HasProvidesInterface(provIfaceID)) 
				this.BasicComponent.AddProvidesInterface(provIfaceID,ComponentFactory.CreateInterfaceModel());

			ISignature[] sigs = ComponentFactory.CreateSignatureArray(signatureID.ToString());
			this.BasicComponent.GetProvidesInterface(provIfaceID).SignatureList.AddSignatures(sigs);

			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			this.BasicComponent.AddServiceEffectSpecification(provIfaceID,sigs[0],seff);

			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			seff.AddAuxiliarySpecification(fsmSeff);

			return this.builderFactory.CreateBuilder(this.BasicComponent,fsmSeff);
		}

		#endregion
	}
}
//EOF
