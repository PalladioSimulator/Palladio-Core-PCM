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
		IProvidesMapping[] ProvidesMappings
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IRequiresMapping[] RequiresMappings
		{ 
			get;
		}
		
		void AddComponents(params IComponent[] aCompArray);

		void DeleteComponents(params IComponent[] aCompArray);
		

		void AddProvidesInterfaces(IProvidesMapping aProvMapping, params ISignatureList[] aProvIfaceArray);
		
		void AddRequiresInterface(IRequiresMapping aReqMapping, ISignatureList aReqInterface);
		
		void DeleteProvidesInterfaces(IProvidesMapping aProvMapping, params ISignatureList[] aProvIfaceArray);

		void DeleteRequiresInterface(IRequiresMapping aReqMapping, ISignatureList aReqInterface);


		IProvidesMapping GetProvidesMappingByOuter(string aProvRoleID);

		IBinding GetBindingByRequires(AttachedInterface aReqInterface);

		IRequiresMapping GetRequiresMappingByInner(AttachedInterface aReqInterface);

		IRequiresMapping GetRequiresMappingByOuter(string aReqRoleID);

		IBinding GetBindingByProvides(AttachedInterface aProvInterface);

		IProvidesMapping GetProvidesMappingByInner(AttachedInterface aProvInterface);
		
	}
}
