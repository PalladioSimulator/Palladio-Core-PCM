using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A CompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
	public class CompositeComponent : ICompositeComponent 
	{
		#region Properties

		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		public IList ComponentList 
		{ 
			get { return componentList; }
		}

		/// <summary>
		/// List of ComponentBinding objects which represent 
		/// the wiring of the internal components.
		/// </summary>
		public IList BindingList 
		{ 
			get { return bindingList; }
		}

		/// <summary>
		/// List of ICompProvMappings mapping the provides interfaces
		/// of the internal components onto the provides interfaces of the
		/// CompositeComponent.
		/// </summary>
		public IList ProvMappingList 
		{ 
			get { return provMappingList; }
		}

		/// <summary>
		/// List of IReqCompMappings mapping the requires interfaces
		/// of the internal components onto the requires interfaces of the
		/// CompositeComponent.
		/// </summary>
		public IList ReqMappingList 
		{ 
			get { return reqMappingList; }
		}

		/// <summary>
		/// List of all mappings including ICompProvMappings and ICompReqMappings.
		/// </summary>
		public IList MappingList 
		{
			get { 
				Vector resultList = new Vector(ReqMappingList);
				resultList.AddRange(ProvMappingList);
				return resultList;
			}
		}
		#endregion

		#region Methods

		/// <summary>
		/// Interfaces provided by the component constrained by its environment.
		/// </summary>
		/// <param name="aProvIfaceList">
		/// List of ProvidesInterface objects provided to the component.
		/// </param>
		/// <returns>
		/// A list of ProvidesInterface objects.
		/// </returns>
		public IList GetProvidesIfaceList(IList aProvIfaceList) 
		{
			return null;
		}

		/// <summary>
		/// Interfaces required by the component adapted to the requirements
		/// of the environment.
		/// </summary>
		/// <param name="aReqIfaceList">
		/// List of RequiresInterface objects required from the component.
		/// </param>
		/// <returns>
		/// A List of RequireInterface objects.
		/// </returns>
		public IList GetRequiresIfaceList(IList aReqIfaceList) 
		{
			return null;
		}

		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		/// <returns>
		/// A list of ProvidesInterface objects.
		/// </returns>
		public IList GetProvidesIfaceList() 
		{
			return null;
		}

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIfaceList() 
		{
			return null;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone() 
		{
			return null;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty Component.
		/// </summary>
		public CompositeComponent() 
		{
		}

		#endregion

		#region Data

		private IList componentList;
		private IList bindingList;
		private IList provMappingList;
		private IList reqMappingList;

		#endregion

	}
}
