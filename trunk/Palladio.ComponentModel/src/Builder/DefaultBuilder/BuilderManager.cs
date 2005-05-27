using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypedBuilderLists;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.DeploymentLevelBuilder;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// <p>The default implementation of the builder factory.
	/// Manages the wrappers/decorators for the builders which are used for the constraints.
	/// Default builders and constraints are initialized.</p>
	/// </summary>
	/// <remarks>
	/// Only constraints that are attached by a client should be removed.
	/// <p>
	/// Internally lets create duplicates of builders and constraints before returning them.
	/// </p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.11  2005/05/27 15:22:51  kelsaka
	/// - added return of entity ids
	///
	/// Revision 1.10  2005/05/27 11:56:48  kelsaka
	/// - added access to builders at deployment level
	///
	/// Revision 1.9  2005/05/27 11:20:20  kelsaka
	/// - added methods for accessing builders of implementation and deployment level to BuilderManager.
	///
	/// Revision 1.8  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.7  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.4  2005/05/23 09:16:38  kelsaka
	/// - fix: not all builder methods for use in the deserialisation used the given
	/// identifier
	///
	/// Revision 1.3  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.2  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.1  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// </pre>
	/// </remarks>
	internal class BuilderManager : IBuilderManager
	{
		#region data

		/// <summary>
		/// general modelDataManager
		/// </summary>
		IModelDataManager modelDataManager;

		// ArrayLists of Constraints
		RootTypeLevelBuilderList rootTypeLevelBuilderConstraints;
		BasicComponentTypeLevelBuilderList basicComponentTypeLevelBuilderConstraints;
		CompositeComponentTypeLevelBuilderList compositeComponentTypeLevelBuilderConstraints;
		InterfaceTypeLevelBuilderList interfaceTypeLevelBuilderConstraints;
		SignatureTypeLevelBuilderList signatureTypeLevelBuilderConstraints;
	
		#endregion

		#region constructors

		/// <summary>
		/// Default constructor. Initializes all builders without any constraints than
		/// default constraints and the the default builders.
		/// </summary>
		/// <param name="modelDataManager"></param>
		public BuilderManager(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
			Init();
		}

		#endregion

		#region methods

		/// <summary>
		/// Adds builders and default constraints to the lists of constraints.
		/// </summary>
		private void Init()
		{
			// initialize builder/constraints-lists with empty entities.
			this.rootTypeLevelBuilderConstraints = new RootTypeLevelBuilderList();
			this.rootTypeLevelBuilderConstraints.Add(new DefaultRootTypeLevelBuilder(modelDataManager, this));
			this.rootTypeLevelBuilderConstraints.Add(new RootTypeLevelConstraint(modelDataManager));

			this.basicComponentTypeLevelBuilderConstraints = new BasicComponentTypeLevelBuilderList();
			this.basicComponentTypeLevelBuilderConstraints.Add(new DefaultBasicComponentTypeLevelBuilder(modelDataManager, null, this));
			this.basicComponentTypeLevelBuilderConstraints.Add(new BasicComponentTypeLevelConstraint(modelDataManager));
		
			this.compositeComponentTypeLevelBuilderConstraints = new CompositeComponentTypeLevelBuilderList();
			this.compositeComponentTypeLevelBuilderConstraints.Add(new DefaultCompositeComponentTypeLevelBuilder(modelDataManager, null, this));
			this.compositeComponentTypeLevelBuilderConstraints.Add(new CompositeComponentTypeLevelConstraint(modelDataManager));

			this.interfaceTypeLevelBuilderConstraints = new InterfaceTypeLevelBuilderList();
			this.interfaceTypeLevelBuilderConstraints.Add(new DefaultInterfaceTypeLevelBuilder(modelDataManager, null, this));
			this.interfaceTypeLevelBuilderConstraints.Add(new InterfaceTypeLevelConstraint(modelDataManager));

			this.signatureTypeLevelBuilderConstraints = new SignatureTypeLevelBuilderList();
			this.signatureTypeLevelBuilderConstraints.Add(new DefaultSignatureTypeLevelBuilder(modelDataManager, null, this));
			//this.signatureTypeLevelBuilderConstraints.Add(new SignatureTypeLevelConstraint(modelDataManager)); // currently there are no signature constraints (necessary)
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (IRootTypeLevelBuilder builderConstraint)
		{
			this.rootTypeLevelBuilderConstraints.Add(builderConstraint);
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (IRootTypeLevelBuilder builderConstraint)
		{
			this.rootTypeLevelBuilderConstraints.Remove(builderConstraint);
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (IBasicComponentTypeLevelBuilder builderConstraint)
		{
			this.basicComponentTypeLevelBuilderConstraints.Add(builderConstraint);
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (IBasicComponentTypeLevelBuilder builderConstraint)
		{
			this.basicComponentTypeLevelBuilderConstraints.Remove(builderConstraint);
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (ICompositeComponentTypeLevelBuilder builderConstraint)
		{
			this.compositeComponentTypeLevelBuilderConstraints.Add(builderConstraint);
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (ICompositeComponentTypeLevelBuilder builderConstraint)
		{
			this.compositeComponentTypeLevelBuilderConstraints.Remove(builderConstraint);
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (IInterfaceTypeLevelBuilder builderConstraint)
		{
			this.interfaceTypeLevelBuilderConstraints.Add(builderConstraint);
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (IInterfaceTypeLevelBuilder builderConstraint)
		{
			this.interfaceTypeLevelBuilderConstraints.Remove(builderConstraint);
		}

		/// <summary>
		/// Adds the given builder constraint to the list of constraints for
		/// this builder.
		/// </summary>
		/// <param name="builderConstraint">A constraint for this builder.</param>
		public void AddBuilderConstraint (ISignatureTypeLevelBuilder builderConstraint)
		{
			this.signatureTypeLevelBuilderConstraints.Add(builderConstraint);
		}

		/// <summary>
		/// Removes the given constraints from the list of constraints applied to this builder.
		/// </summary>
		/// <param name="builderConstraint">The constraint to remove.</param>
		public void RemoveBuilderConstraint (ISignatureTypeLevelBuilder builderConstraint)
		{
			this.signatureTypeLevelBuilderConstraints.Remove(builderConstraint);
		}

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="component">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		public IBasicComponentTypeLevelBuilder GetBasicComponentTypeLevelBuilder (IComponent component)
		{
			return this.basicComponentTypeLevelBuilderConstraints.GetOuterBuilder(component);
		}

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="component">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		public ICompositeComponentTypeLevelBuilder GetCompositeComponentTypeLevelBuilder (IComponent component)
		{
			return this.compositeComponentTypeLevelBuilderConstraints.GetOuterBuilder(component);
		}

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="iInterface">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		public IInterfaceTypeLevelBuilder GetInterfaceTypeLevelBuilder (IInterface iInterface)
		{
			return this.interfaceTypeLevelBuilderConstraints.GetOuterBuilder(iInterface);
		}

		/// <summary>
		/// Creates a new builder including all actually defined constraints for this builder.
		/// </summary>
		/// <param name="signature">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		public ISignatureTypeLevelBuilder GetSignatureTypeLevelBuilder (ISignature signature)
		{
			return this.signatureTypeLevelBuilderConstraints.GetOuterBuilder(signature);
		}

		#region type level

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		public IBasicComponentTypeLevelBuilder GetBasicComponentTypeLevelBuilder (IComponentIdentifier componentID)
		{
			//this.modelDataManager.Query.QueryEntities.GetComponent(componentID);
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		public ICompositeComponentTypeLevelBuilder GetCompositeComponentTypeLevelBuilder (IComponentIdentifier componentID)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="iInterfaceID">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		public IInterfaceTypeLevelBuilder GetInterfaceTypeLevelBuilder (IInterfaceIdentifier iInterfaceID)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="signatureID">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		public ISignatureTypeLevelBuilder GetSignatureTypeLevelBuilder (ISignatureIdentifier signatureID)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#region implementation level

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		public IBasicComponentImplementationLevelBuilder GetBasicComponentImplementationLevelBuilder (IComponentIdentifier componentID)
		{
			throw new NotImplementedException ("The implementation level is not done yet.");
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		public ICompositeComponentImplementationLevelBuilder GetCompositeComponentImplementationLevelBuilder (IComponentIdentifier componentID)
		{
			throw new NotImplementedException ("The implementation level is not done yet.");
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="iInterfaceID">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		public IInterfaceImplementationLevelBuilder GetInterfaceImplementationLevelBuilder (IInterfaceIdentifier iInterfaceID)
		{
			throw new NotImplementedException ("The implementation level is not done yet.");
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="signatureID">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		public ISignatureImplementationLevelBuilder GetSignatureImplementationLevelBuilder (ISignatureIdentifier signatureID)
		{
			throw new NotImplementedException ("The implementation level is not done yet.");
		}

		#endregion

		#region deployment level

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Basic component builder for the type level.</returns>
		public IBasicComponentDeploymentLevelBuilder GetBasicComponentDeploymentLevelBuilder (IComponentIdentifier componentID)
		{
			throw new NotImplementedException ("The deployment level is not done yet.");
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="componentID">The component to build</param>
		/// <returns>Composite component builder for the type level.</returns>
		public ICompositeComponentDeploymentLevelBuilder GetCompositeComponentDeploymentLevelBuilder (IComponentIdentifier componentID)
		{
			throw new NotImplementedException ("The deployment level is not done yet.");
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="iInterfaceID">The interface to build</param>
		/// <returns>interface builder for the type level.</returns>
		public IInterfaceDeploymentLevelBuilder GetInterfaceDeploymentLevelBuilder (IInterfaceIdentifier iInterfaceID)
		{
			throw new NotImplementedException ("The deployment level is not done yet.");
		}

		/// <summary>
		/// Creates a builder (including all actually defined constraints) for the given identifiert.
		/// </summary>
		/// <param name="signatureID">The signature to build</param>
		/// <returns>signature builder for the type level.</returns>
		public ISignatureDeploymentLevelBuilder GetSignatureDeploymentLevelBuilder (ISignatureIdentifier signatureID)
		{
			throw new NotImplementedException ("The deployment level is not done yet.");
		}

		#endregion

		#endregion

		#region properties

		/// <summary>
		/// The root builder of the actual component model. Root builder for the type level.
		/// Use this builder to set up the static structure of the component model.
		/// The root builder that is returned applies all actually defined constraints.
		/// </summary>
		/// <remarks>Formerly this property was called "RootBuilder".</remarks>
		public IRootTypeLevelBuilder RootTypeLevelBuilder
		{
			get
			{
				return this.rootTypeLevelBuilderConstraints.GetOuterBuilder();
			}
		}

		#endregion
	}
}
