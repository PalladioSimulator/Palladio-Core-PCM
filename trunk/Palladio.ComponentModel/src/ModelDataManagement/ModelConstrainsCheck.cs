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
	/// Revision 1.3  2005/03/19 18:35:41  joemal
	/// implement the rest of the lowlevelbuilder
	///
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

			ComponentExitsCheck(parentCompID);

			IComponent parentComp = (IComponent) entities[parentCompID];
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
		/// <param name="ifaceID">the id of the interface</param>
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
		/// <param name="role">the role of the interface</param>
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
		/// check the constrains before adding a protocol an interface
		/// </summary>
		/// <param name="ifaceId">the id of the interface</param>
		/// <param name="protocol">the protocol</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">an signature with given id already exists in cm</exception>
		public void AddProtocolCheck(IProtocol protocol,IInterfaceIdentifier ifaceId)
		{
			EntityExistsCheck(protocol.ID);
			InterfaceExitsCheck(ifaceId);
		}

		/// <summary>
		/// check the constrains before adding a provides delegation connector
		/// </summary>
		/// <param name="innerCompId">a component id</param>
		/// <param name="innerIFaceId">an interface id</param>
		/// <param name="outerCompId">a component id</param>
		/// <param name="outerIFaceId">an interface id</param>
		/// <param name="innerRole">the inner role to connect to</param>
		/// <param name="outerRole">the outer role to connect to</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides
		/// interface of the component</exception>
		public void AddProvidesDelegationCheck(IComponentIdentifier innerCompId, IInterfaceIdentifier innerIFaceId,
			IComponentIdentifier outerCompId, IInterfaceIdentifier outerIFaceId,ModelDataSet.RolesRow innerRole, 
			ModelDataSet.RolesRow outerRole)
		{
			ComponentExitsCheck(innerCompId);
			ComponentExitsCheck(outerCompId);
			InterfaceExitsCheck(innerIFaceId);
			InterfaceExitsCheck(outerIFaceId);
			RoleExitsCheck(innerCompId,innerIFaceId,innerRole);
			RoleExitsCheck(outerCompId,outerIFaceId,outerRole);

			if (innerRole.type != (sbyte)InterfaceRole.PROVIDES)
				throw new NotAProvidesIFaceException(innerCompId,innerIFaceId);
			if (outerRole.type != (sbyte)InterfaceRole.PROVIDES)
				throw new NotAProvidesIFaceException(outerCompId,outerIFaceId);

			ModelDataSet.ComponentsRow innerCompRow = dataset.Components.FindByid(innerRole.fk_comp);
			if (innerCompRow.parentComponent != outerRole.fk_comp)
				throw new ComponentHierarchyException("Component "+outerCompId+" is not the parent component of "+
					innerCompId+".");
		}
		
		/// <summary>
		/// check the constrains before adding a requires delegation connector
		/// </summary>
		/// <param name="innerCompId">a component id</param>
		/// <param name="innerIFaceId">an interface id</param>
		/// <param name="outerCompId">a component id</param>
		/// <param name="outerIFaceId">an interface id</param>
		/// <param name="innerRole">the inner role to connect to</param>
		/// <param name="outerRole">the outer role to connect to</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires 
		/// interface of the component</exception>
		public void AddRequiresDelegationCheck(IComponentIdentifier innerCompId, IInterfaceIdentifier innerIFaceId,
			IComponentIdentifier outerCompId, IInterfaceIdentifier outerIFaceId,ModelDataSet.RolesRow innerRole, 
			ModelDataSet.RolesRow outerRole)
		{
			ComponentExitsCheck(innerCompId);
			ComponentExitsCheck(outerCompId);
			InterfaceExitsCheck(innerIFaceId);
			InterfaceExitsCheck(outerIFaceId);
			RoleExitsCheck(innerCompId,innerIFaceId,innerRole);
			RoleExitsCheck(outerCompId,outerIFaceId,outerRole);

			if (innerRole.type != (sbyte)InterfaceRole.REQUIRES)
				throw new NotARequiresIFaceException(innerCompId,innerIFaceId);
			if (outerRole.type != (sbyte)InterfaceRole.REQUIRES)
				throw new NotARequiresIFaceException(outerCompId,outerIFaceId);

			ModelDataSet.ComponentsRow innerCompRow = dataset.Components.FindByid(innerRole.fk_comp);
			if (innerCompRow.parentComponent != outerRole.fk_comp)
				throw new ComponentHierarchyException("Component "+outerCompId+" is not the parent component of "+
					innerCompId+".");
		}

		/// <summary>
		/// checks the constrains before adding the assembly connector.
		/// </summary>
		/// <param name="reqCompId">a component id</param>
		/// <param name="reqIFaceId">an interface id</param>
		/// <param name="provCompId">a component id</param>
		/// <param name="provIFaceId">an interface id</param>
		/// <param name="reqRole">the role of the requires side of the connection</param>
		/// <param name="provRole">the role of the provides side of the connection</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">both components have not the same parent id</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires</exception> 
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides </exception>
		public void AddAssemblyConnectorCheck(IComponentIdentifier reqCompId, IInterfaceIdentifier reqIFaceId, 
			IComponentIdentifier provCompId, IInterfaceIdentifier provIFaceId, 
			ModelDataSet.RolesRow reqRole, ModelDataSet.RolesRow provRole)
		{
			ComponentExitsCheck(reqCompId);
			ComponentExitsCheck(provCompId);
			InterfaceExitsCheck(reqIFaceId);
			InterfaceExitsCheck(provIFaceId);
			RoleExitsCheck(reqCompId,reqIFaceId,reqRole);
			RoleExitsCheck(provCompId,provIFaceId,provRole);

			if (reqRole.type != (sbyte)InterfaceRole.REQUIRES)
				throw new NotARequiresIFaceException(reqCompId,reqIFaceId);
			if (provRole.type != (sbyte)InterfaceRole.PROVIDES)
				throw new NotAProvidesIFaceException(provCompId,provIFaceId);

			ModelDataSet.ComponentsRow provCompRow = dataset.Components.FindByid(provRole.fk_comp);
			ModelDataSet.ComponentsRow reqCompRow = dataset.Components.FindByid(reqRole.fk_comp);

			if (provCompRow.parentComponent != reqCompRow.parentComponent)
				throw new ComponentHierarchyException("Component "+reqCompId+" has not the same parent "+
					"component like the component "+provCompId);
		}
		
		//check whether the given interface exits in cm
		private void InterfaceExitsCheck(IInterfaceIdentifier ifaceID)
		{
			if (!entities.ContainsKey(ifaceID.Key))
				throw new InterfaceNotFoundException(ifaceID);			
		}

		//check whether the given component exits in cm
		private void ComponentExitsCheck(IComponentIdentifier compID)
		{
			if (!entities.ContainsKey(compID.Key))
				throw new ComponentNotFoundException(compID);
		}

		//check whether the role exits in cm 
		private void RoleExitsCheck(IComponentIdentifier compID, IInterfaceIdentifier ifaceID, ModelDataSet.RolesRow role)
		{
			if (role == null)
				throw new InterfaceNotFromComponentException(compID,ifaceID);
		}
	}
}
