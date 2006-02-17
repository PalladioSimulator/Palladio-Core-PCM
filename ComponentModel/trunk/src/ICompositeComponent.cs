using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ICompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
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
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		IList BindingList 
		{ 
			get;
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IList ProvMappingList 
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IList ReqMappingList 
		{ 
			get;
		}

		/// <summary>
		/// List of all mappings including ICompProvMappings and ICompReqMappings.
		/// </summary>
		IList MappingList 
		{
			get;
		}
	}
}
