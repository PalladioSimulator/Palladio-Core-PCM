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
	/// Revision 1.6  2005/06/17 18:31:43  joemal
	/// changes in the connection tables
	///
	/// Revision 1.5  2005/06/05 10:39:23  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.4  2005/03/28 19:02:16  joemal
	/// primary keys in the dataset now are the guids of the entities
	///
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

		#region contructor

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

		#endregion

		#region public methods

		/// <summary>
		/// check the constrains before adding a component
		/// </summary>
		/// <param name="component">the component to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void CreateComponentCheck(IComponent component)
		{
			EntityAlreadyExistsCheck(component.ID);
		}

		/// <summary>
		/// Check the constrains before adding a component to another or to the static view.
		/// The parent component if present must still be created and must be from type composite.
		/// </summary>
		/// <param name="componentId">the id of component to be added</param>
		/// <param name="parentComponentId">the id of the parent component</param>
		/// <exception cref="ComponentNotFoundException">the parent component could not be found in the model.</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		/// <exception cref="EntityAlreadyExistsException">the component is still a child of the parent component</exception>
		public void AddCompToCompCheck(IComponentIdentifier componentId, IComponentIdentifier parentComponentId)
		{
			string query = "fk_child = '"+componentId.Key+"' and fk_parent ";			
			if (parentComponentId != null)
			{				
				query += "= '"+parentComponentId.Key+"'";
				ComponentExitsCheck(parentComponentId);
				IComponent parentComp = (IComponent) entities[parentComponentId];
				//parent component is not from type composite
				if (parentComp.Type != ComponentType.COMPOSITE)
					throw new WrongComponentTypeException(parentComponentId);
			}
			else
				query += " is null";

			if (dataset.CompRelations.Select(query).Length != 0)
				throw new EntityAlreadyExistsException("The component "+parentComponentId+" is already the parent component"+
										"of the component "+componentId+".");						
        }

		/// <summary>
		/// check the constrains before adding an interface to the componentmodel
		/// </summary>
		/// <param name="iface">the interfaces that should be added</param>
		/// <exception cref="EntityAlreadyExistsException">an interface with given id already exists in cm</exception>
		public void CreateInterfaceCheck(IInterface iface)
		{
			EntityAlreadyExistsCheck(iface.ID);
		}

		/// <summary>
		/// check the constrains before binding an interface to a component
		/// </summary>
		/// <param name="compId">the identifier of the component</param>
		/// <param name="ifaceId">the identifier of the interface</param>
		/// <param name="role">the role of the interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">the component could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">the interface is still bound with the component 
		/// at given role</exception>
		public void AddIFaceToCompCheck(IComponentIdentifier compId, IInterfaceIdentifier ifaceId, InterfaceRole role)
		{
			InterfaceExitsCheck(ifaceId);
			ComponentExitsCheck(compId);
			if (QueryRole(new ConnectionPoint(ifaceId,compId),role)!=null)
				throw new EntityAlreadyExistsException("The interface is still bound with the component.");
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
			EntityAlreadyExistsCheck(signature.ID);
			InterfaceExitsCheck(ifaceID);
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
			EntityAlreadyExistsCheck(protocol.ID);
			InterfaceExitsCheck(ifaceId);
		}

		/// <summary>
		/// check the constrains before adding a provides delegation connector
		/// </summary>
		/// <param name="innerPoint">the connecting point of the inner component</param>
		/// <param name="outerPoint">the connecting point of the outer component</param>
		/// <param name="role">the side of the component to connect to</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="InterfaceNotFromComponentException">the interface is not bound to the component</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides
		/// interface of the component</exception>
		public void AddProvidesDelegationCheck(ConnectionPoint innerPoint,ConnectionPoint outerPoint,InterfaceRole role)
		{
			ComponentExitsCheck(innerPoint.componentID);
			ComponentExitsCheck(outerPoint.componentID);
			InterfaceExitsCheck(innerPoint.ifaceID);
			InterfaceExitsCheck(outerPoint.ifaceID);

			if (role != InterfaceRole.PROVIDES)
				throw new NotAProvidesIFaceException(innerPoint.componentID,innerPoint.ifaceID);

			RoleExitsCheck(innerPoint,role);
			RoleExitsCheck(outerPoint,role);

			ParentCheck(innerPoint.componentID,outerPoint.componentID,"The outer component is not the parent of the inner one.");
		}
		
		/// <summary>
		/// check the constrains before adding a requires delegation connector
		/// </summary>
		/// <param name="innerPoint">the connecting point of the inner component</param>
		/// <param name="outerPoint">the connecting point of the outer component</param>
		/// <param name="role">the side of the component to connect to</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="InterfaceNotFromComponentException">the interface is not bound to the component</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires 
		/// interface of the component</exception>
		public void AddRequiresDelegationCheck(ConnectionPoint innerPoint,ConnectionPoint outerPoint,InterfaceRole role)
		{
			ComponentExitsCheck(innerPoint.componentID);
			ComponentExitsCheck(outerPoint.componentID);
			InterfaceExitsCheck(innerPoint.ifaceID);
			InterfaceExitsCheck(outerPoint.ifaceID);

			if (role != InterfaceRole.REQUIRES)
				throw new NotARequiresIFaceException(innerPoint.componentID,innerPoint.ifaceID);

			RoleExitsCheck(innerPoint,role);
			RoleExitsCheck(outerPoint,role);

			ParentCheck(innerPoint.componentID,outerPoint.componentID,"The outer component is not the parent of the inner one.");
		}

		/// <summary>
		/// checks the constrains before adding the assembly connector.
		/// </summary>
		/// <param name="parentCompID">the id of the components parent component</param>
		/// <param name="requiresPoint">the connecting point of the providing component</param>
		/// <param name="providesPoint">the connecting point of the providing component</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="InterfaceNotFromComponentException">the interface is not bound with the component</exception>
		/// <exception cref="ComponentNotFoundException">one of the components could not be found in cm</exception>
		/// <exception cref="NotARequiresIFaceException">the first given interface is not a requires</exception> 
		/// <exception cref="NotAProvidesIFaceException">the second given interface is not a provides </exception>
		/// <exception cref="ComponentHierarchyException">one of the components is not a child of the parent component.</exception>
		public void AddAssemblyConnectorCheck(IComponentIdentifier parentCompID,ConnectionPoint requiresPoint,
			ConnectionPoint providesPoint)
		{
			ComponentExitsCheck(requiresPoint.componentID);
			ComponentExitsCheck(providesPoint.componentID);
			InterfaceExitsCheck(requiresPoint.ifaceID);
			InterfaceExitsCheck(providesPoint.ifaceID);

			RoleExitsCheck(requiresPoint,InterfaceRole.REQUIRES);
			RoleExitsCheck(providesPoint,InterfaceRole.PROVIDES);

			ParentCheck(requiresPoint.componentID,parentCompID,"The requiring component is not a child of the parent component.");
			ParentCheck(providesPoint.componentID,parentCompID,"The providing component is not a child of the parent component.");
		}

		/// <summary>
		/// check wether the entity with given id already exists in current componentmodel.
		/// </summary>
		/// <param name="entityID">the id of the entity to be checked</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void EntityAlreadyExistsCheck(IIdentifier entityID)
		{
			if (entities.ContainsKey(entityID.Key))
				throw new EntityAlreadyExistsException(entityID);			
		}

		#endregion

		#region private methods
		
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

		//queries the role by componentid, interfaceid and role
		private ModelDataSet.RolesRow QueryRole(ConnectionPoint point, InterfaceRole role)
		{
			string query = "fk_comp = '"+point.componentID.Key+"' and fk_iface = '"+point.ifaceID.Key+"' and type = "+(sbyte)role;
			DataRow[] result = dataset.Roles.Select(query);

			if (result.Length == 0) return null;	

			return (ModelDataSet.RolesRow) result[0];
		}

		//check wether the given interface belongs to the component at given role
		private void RoleExitsCheck(ConnectionPoint point, InterfaceRole role)
		{
			if (QueryRole(point,role)==null)
				throw new InterfaceNotFromComponentException(point.componentID,point.ifaceID);
		}

		// checks wether the component with the given parent id is the parent of the compIDs one.
		private void ParentCheck(IComponentIdentifier childID, IComponentIdentifier parentID, string errorMessage)
		{
			string query = "fk_child = '"+childID.Key+"' and fk_parent";
			if (parentID == null)
				query += " is null";
			else
				query += " = '"+parentID.Key+"'";

			DataRow[] result = dataset.CompRelations.Select(query);

			if (result.Length == 0) 
				throw new ComponentHierarchyException(errorMessage);
		}

		#endregion
	}
}
