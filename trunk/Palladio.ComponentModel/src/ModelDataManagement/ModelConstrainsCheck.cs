using System;
using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelDataManagement
{
	/// <summary>
	/// This class contains methods that check the constrains while building or changing the structure of the 
	/// component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/03/16 13:32:34  joemal
	/// implement lowlevelbuilder
	///
	/// Revision 1.1  2005/03/15 12:31:02  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class ModelConstrainsCheck 
	{
		#region data

		//holds the entities
		private EntityHashtable entities;

		//holds the dataset
		private ModelDataSet dataset;

		#endregion

		/// <summary>
		/// called to create a new ModelConstrainsCheck object using given dataset and entitytable.
		/// </summary>
		/// <param name="dataset">the dataset of the model</param>
		/// <param name="entities">the entity table</param>
		public ModelConstrainsCheck(ModelDataSet dataset, EntityHashtable entities)
		{
            this.entities = entities;
			this.dataset = dataset;
		}

		/// <summary>
		/// Check the constrains before adding a component.
		/// The parent component if present must still be added and must be from type composite.
		/// </summary>
		/// <param name="comp">the component to be added</param>
		/// <param name="parentCompID">the id of the parent component</param>
		/// <exception cref="ComponentNotFoundException">the parent component could not be found in the model.</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddComponentCheck(IComponent comp, IComponentIdentifier parentCompID)
        {
			EntityExistsCheck(comp.ID);
			//no parent specified
			if (parentCompID == null) return;
			IComponent parentComp = (IComponent) entities[parentCompID];
			//parent component with given id doesn't exists
			if (parentComp == null)
				throw new ComponentNotFoundException(parentCompID);
			//parent component is not from type composite
			if (parentComp.Type != ComponentType.COMPOSITE)
				throw new WrongComponentTypeException(parentCompID);
        }

		/// <summary>
		/// check wether the entity with given id already exists in current componentmodel.
		/// </summary>
		/// <param name="entityID">the id of the entity to be checked</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void EntityExistsCheck(IIdentifier entityID)
		{
			if (entities.ContainsKey(entityID.Key))
				throw new EntityAlreadyExistsException(entityID);			
		}

		/// <summary>
		/// check the constrains before adding an interface to the componentmodel
		/// </summary>
		/// <param name="iface">the interfaces that should be added</param>
		/// <exception cref="EntityAlreadyExistsException">an interface with given id already exists in cm</exception>
		public void AddInterfaceCheck(IInterface iface)
		{
			EntityExistsCheck(iface.ID);
		}

		/// <summary>
		/// check the constrains before adding a signature to the componentmodel
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an signature with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		public void AddSignatureCheck(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			EntityExistsCheck(signature.ID);
			if (!entities.ContainsKey(ifaceID.Key))
				throw new InterfaceNotFoundException(ifaceID);
		}

		/// <summary>
		/// check the constrains before binding an interface to a component
		/// </summary>
		/// <param name="compId">the identifier of the component</param>
		/// <param name="ifaceId">the identifier of the interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">the component could not be found in cm</exception>
		public void AddIFaceToCompCheck(IComponentIdentifier compId, IInterfaceIdentifier ifaceId, InterfaceRole role)
		{
			if (!entities.ContainsKey(ifaceId.Key))
				throw new InterfaceNotFoundException(ifaceId);
			if (!entities.ContainsKey(compId.Key))
				throw new ComponentNotFoundException(compId);				
		}

		/// <summary>
		/// check the constrains before add a protocol an interface
		/// </summary>
		/// <param name="ifaceId">the id of the interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		public void AddProtocolCheck(IInterfaceIdentifier ifaceId)
		{
			if (!entities.ContainsKey(ifaceId.Key))
				throw new InterfaceNotFoundException(ifaceId);
		}
	}
}
