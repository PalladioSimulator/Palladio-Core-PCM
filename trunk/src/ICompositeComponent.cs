using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public interface ICompositeComponent : IComponent
	{
		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		IList ComponentList 
		{ 
			get;
		}

		/// <summary>
		/// List of Binding objects which represent 
		/// the wiring of the internal components.
		/// </summary>
		IList BindingList 
		{ 
			get;
		}

		/// <summary>
		/// List of ProvidesMapping objects mapping the provides interfaces
		/// of the internal components onto the provides interfaces of the
		/// CompositeComponent.
		/// </summary>
		IList ProvMappingList 
		{ 
			get;
		}

		/// <summary>
		/// List of RequiresMapping objects mapping the requires interfaces
		/// of the internal components onto the requires interfaces of the
		/// CompositeComponent.
		/// </summary>
		IList ReqMappingList 
		{ 
			get;
		}


		IList MappingList 
		{
			get;
		}

//		void AddBinding( IBinding aBinding );
//
//		void AddBindingList( IList aBindingList );
//
//		void RemoveBinding( IBinding aBinding );
//
//		void RemoveBindingList( IList aBindingList );
//
//		void ClearBindings();
//
//		void AddMapping( IMapping aMapping );
//
//		void AddMappingList( IList aMappingList );
//
//		void AddReqMapping( RequiresMapping aReqMapping );
//
//		void AddReqMappingList( IList aReqMappingList );
//
//		void AddProvMapping( ProvidesMapping aProvMapping );
//
//		void AddProvMappingList( IList aProvMappingList );
//
//		void RemoveMapping( IMapping aMapping );
//
//		void RemoveMappingList( IList aMappingList );
//
//		void AddComponent( IComponent aComponent );
//
//		void AddComponentList( IList aCompList );
//
//		void RemoveComponent( IComponent aComponent );
//
//		void RemoveComponentList( IList aComponentList );
	}
}
