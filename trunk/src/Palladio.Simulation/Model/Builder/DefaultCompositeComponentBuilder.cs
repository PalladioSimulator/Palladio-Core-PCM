using System;
using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Simulation.Model.Elements;

namespace Palladio.Simulation.Model.Builder
{
	/// <summary>
	/// This class is the default implementation of the builder used to fill composite components.
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
	internal class DefaultCompositeComponentBuilder : AbstractComponentBuilder,ICompositeComponentBuilder
	{
		#region data

		//holds the builders of the inner components
		private System.Collections.IDictionary builders = new System.Collections.Hashtable();

		#endregion

		#region properties

		/// <summary>
		/// called to return the composite component, which has to be filled by this builder
		/// </summary>
		protected ICompositeComponent CompositeComponent
		{
			get
			{
				return (ICompositeComponent)this.component;
			}
		}

		/// <summary>
		/// called to get the observer for this builders compositecomponent.
		/// </summary>
		protected ICompositeComponentObserver CompositeComponentObserver
		{
			get
			{
				return (ICompositeComponentObserver)this.observer;
			}
		}

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new DefaultCompositeComponentBuilder for the given component.
		/// </summary>
		/// <param name="component">the component to be filled with this builder.</param>
		/// <param name="elements">the factory, used to create the elements of the architecture</param>
		/// <param name="builder">the factory, used to create the builder</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		public DefaultCompositeComponentBuilder(ICompositeComponent component, IElementFactory elements, IBuilderFactory builder,
			ICompositeComponentObserver observer) : base(component,elements,builder,observer)
		{
		}

		#endregion

		#region methods

		/// <summary>
		/// called to add a basic component with given id.
		/// </summary>
		/// <param name="componentID">the id of the new component.</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder to fill this component</returns>
		public IBasicComponentBuilder AddBasicComponent(IIdentifier componentID, IBasicComponentObserver observer)
		{
			IBasicComponent basicComp = ComponentFactory.CreateBasicComponent(componentID);
			this.CompositeComponent.AddComponents(basicComp);

			IBasicComponentBuilder builder = this.builderFactory.CreateBuilder(basicComp,observer);
			this.builders.Add(componentID,builder);

			if(this.observer != null)
				CompositeComponentObserver.OnBasicComponentAdded(CompID,componentID);

			return builder;
		}

		/// <summary>
		/// called to add a composite component with given id.
		/// </summary>
		/// <param name="componentID">the id of the new component.</param>		
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder to fill this component</returns>
		public ICompositeComponentBuilder AddCompositeComponent(IIdentifier componentID,ICompositeComponentObserver observer)
		{
			ICompositeComponent compositeComp = ComponentFactory.CreateCompositeComponent(componentID);
			this.CompositeComponent.AddComponents(compositeComp);

			ICompositeComponentBuilder builder = this.builderFactory.CreateBuilder(compositeComp,observer);
			this.builders.Add(componentID,builder);

			if(this.observer != null)
				CompositeComponentObserver.OnCompositeComponentAdded(CompID,componentID);

			return builder;
		}

		/// <summary>
		/// called to get the builder of the component with the given id. If the component doesn't exist, null
		/// is returned.
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the builder of the component</returns>
		public IComponentBuilder getComponentBuilder(IIdentifier componentID)
		{
			return (IComponentBuilder)builders[componentID];
		}

		/// <summary>
		/// called to add a binding to the composite component.
		/// </summary>
		/// <param name="provComp">the id of the providing component</param>
		/// <param name="reqComp">the id of the requiring component</param>
		/// <param name="provIFaceID">the id of the provides interface</param>
		/// <param name="reqIFaceID">the id of the requires interface</param>
		/// <param name="parms">the parameters for the binding</param>
		public void AddBinding(IIdentifier provComp, IIdentifier reqComp, IIdentifier provIFaceID, IIdentifier reqIFaceID, 
			ISimulationBindingParams parms)
		{
			IComponent pComp = this.CompositeComponent.GetComponent(provComp);
			IComponent rComp = this.CompositeComponent.GetComponent(reqComp);

			ISimulationBinding binding = elementFactory.CreateBinding(rComp,reqIFaceID,pComp,provIFaceID,parms);
			this.CompositeComponent.AddBindings(binding);

			if(this.observer != null)
				CompositeComponentObserver.OnBindingAdded(CompID,provComp,reqComp,provIFaceID,reqIFaceID,parms);
		}

		/// <summary>
		/// called to add a mapping between a requires interface of an inner component with a requires interface
		/// of this component.
		/// </summary>
		/// <param name="requiringComp">the inner component</param>
		/// <param name="compReqIFaceID">the interface of the inner component</param>
		/// <param name="thisCompReqIFaceID">the interface of this component</param>
		public void AddRequiresMapping(IIdentifier requiringComp, IIdentifier compReqIFaceID, IIdentifier thisCompReqIFaceID)
		{
			IComponent innerComp = CompositeComponent.GetComponent(requiringComp);
			if (!innerComp.HasRequiresInterface(compReqIFaceID))
				innerComp.AddRequiresInterface(compReqIFaceID,ComponentFactory.CreateInterfaceModel());

			if (!CompositeComponent.HasRequiresInterface(thisCompReqIFaceID))
				this.AddRequiresInterface(thisCompReqIFaceID);

			copyMissingSignatures(innerComp.GetRequiresInterface(compReqIFaceID),
				CompositeComponent.GetRequiresInterface(thisCompReqIFaceID));

			IMapping mapping = ComponentFactory.CreateRequiresMapping(innerComp,compReqIFaceID,
				this.CompositeComponent,thisCompReqIFaceID);

			this.CompositeComponent.AddRequiresMappings(mapping);

			if(this.observer != null)
				CompositeComponentObserver.OnRequiresMappingAdded(CompID,requiringComp,compReqIFaceID,thisCompReqIFaceID);
		}

		/// <summary>
		/// called to add a mapping between a provides interface of an inner component with a provides interface
		/// of this component.
		/// </summary>
		/// <param name="providingComp">the inner component</param>
		/// <param name="compProvIFaceID">the interface of the inner component</param>
		/// <param name="thisCompProvIFaceID">the interface of this component</param>
		public void AddProvidesMapping(IIdentifier providingComp, IIdentifier compProvIFaceID, IIdentifier thisCompProvIFaceID)
		{
			IComponent innerComp = this.CompositeComponent.GetComponent(providingComp);
			if (!innerComp.HasProvidesInterface(compProvIFaceID))
				innerComp.AddProvidesInterface(compProvIFaceID,ComponentFactory.CreateInterfaceModel());

			if (!CompositeComponent.HasProvidesInterface(thisCompProvIFaceID))
				this.AddProvidesInterface(thisCompProvIFaceID);

			copyMissingSignatures(innerComp.GetProvidesInterface(compProvIFaceID),
				CompositeComponent.GetProvidesInterface(thisCompProvIFaceID));

			IMapping mapping = ComponentFactory.CreateProvidesMapping(this.CompositeComponent,thisCompProvIFaceID,
				innerComp,compProvIFaceID);

			this.CompositeComponent.AddProvidesMappings(mapping);

			if(this.observer != null)
				CompositeComponentObserver.OnProvidesMappingAdded(CompID,providingComp,compProvIFaceID,thisCompProvIFaceID);
		}

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. 
		/// The Reset methods of all contained componentbuilders and of the contained bindings are called.
		/// </summary>
		public override void Reset()
		{
			foreach(IBinding binding in CompositeComponent.Bindings)
				if (binding is ITimeConsumer) ((ITimeConsumer)binding).Reset();

			foreach(IComponentBuilder builder in this.builders.Values)
				builder.Reset();
		}

		//called to add copies of all signatures from Interface fromIFace that are missing in interface toIFace to toIFace.
		private void copyMissingSignatures(IInterfaceModel fromIFace, IInterfaceModel toIFace)
		{
			foreach(ISignature sig in fromIFace.SignatureList)
				if (!toIFace.SignatureList.ContainsSignature(sig)) 
					toIFace.SignatureList.AddSignatures((ISignature)sig.Clone());
		}

		#endregion
	}
}
//EOF
