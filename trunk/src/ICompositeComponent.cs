using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ICompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
	public interface ICompositeComponent : IComponent, IVisitable
	{
		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		IComponent[] Components 
		{ 
			get;
		}

		/// <summary>
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		IBinding[] Bindings
		{ 
			get;
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IMapping[] ProvidesMappings
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterface of the
		/// CompositeComponent.
		/// </summary>
		IMapping[] RequiresMappings
		{ 
			get;
		}
		
		void AddComponents(params IComponent[] aCompArray);

		void DeleteComponents(params IComponent[] aCompArray);
		

		void AddProvidesInterface(ISignatureList aProvInterface, IMapping aProvMapping );

		void AddRequiresInterface(ISignatureList aReqInterface, IMapping aReqMapping);

		void DeleteProvidesInterfaces(ISignatureList aProvInterface, IMapping aProvMapping);

		void DeleteRequiresInterface(ISignatureList aReqInterface, IMapping aReqMapping);


		IMapping GetProvidesMappingByOuter(string aProvRoleID);

		IBinding GetBindingByRequires(AttachedInterface aReqInterface);

		IMapping GetRequiresMappingByInner(AttachedInterface aReqInterface);

		IMapping[] GetRequiresMappingsByOuter(string aReqRoleID);

		IBinding[] GetBindingsByProvides(AttachedInterface aProvInterface);

		IMapping[] GetProvidesMappingByInner(AttachedInterface aProvInterface);
		
	}
}
