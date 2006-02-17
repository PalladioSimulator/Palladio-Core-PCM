using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects the RequiresInterfaces of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	public class ComponentBinding : IComponentBinding
	{
		#region Properties

		/// <summary>
		/// Component providing several services.
		/// </summary>
		public IComponent ProvComponent
		{
			get { return provComponent; }
		}

		/// <summary>
		/// Component requiring the services of ProvComponent.
		/// </summary>
		public IComponent ReqComponent
		{
			get { return reqComponent; }
		}

		/// <summary>
		/// The bindings between the interfaces of both components.
		/// </summary>
		public IInterfaceBinding[] IfaceBindings
		{
			get { return interfaceBindings; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <returns>True, if as much is provided as required.</returns>
		public bool CheckInteroperability()
		{
			// TODO:  Implementierung von CompBinding.CheckInteroperability hinzufügen
			return false;
		}

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the interoperability check.</param>
		/// <returns>True, if as much is provided as required.</returns>
		public bool CheckInteroperability(out System.Collections.IList anErrorList)
		{
			// TODO:  Implementierung von CompBinding.Palladio.ComponentModel.IBinding.CheckInteroperability hinzufügen
			anErrorList = null;
			return false;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			// TODO:  Implementierung von CompBinding.Clone hinzufügen
			return null;
		}

		/// <summary>
		/// Generates the bindings between the requiring and providing component
		/// by matching the names of the interfaces. If an required interface cannot 
		/// be matched an exception is thrown.
		/// </summary>
		/// <returns>The InterfaceBindings between both components.</returns>
		private IInterfaceBinding[] GenerateBindings()
		{
			IList bindList = new ArrayList();
			foreach( RequiresInterface reqIface in reqComponent.GetRequiresIfaceList() )
			{
				bool found = false;
				foreach ( ProvidesInterface provIface in provComponent.GetProvidesIfaceList() )
				{
					if (reqIface.Name.Equals(provIface.Name))
					{
						found = true;
						bindList.Add( new InterfaceBinding( reqIface, provIface ) );
						break;
					}
				}
				if (!found)
					throw new NoBindingFoundException(reqIface);
			}
			InterfaceBinding[] result = new InterfaceBinding[bindList.Count];
			bindList.CopyTo(result,0);
			return result;
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Binds the RequiresInterfaces of aReqComp to the ProvidesInterfaces 
		/// of aProvComp. The interfaces are matched by names.
		/// </summary>
		/// <param name="aReqComp">Component requiring something</param>
		/// <param name="aProvComp">Component providing something</param>
		public ComponentBinding(IComponent aReqComp, IComponent aProvComp)
		{
			provComponent = aProvComp;
			reqComponent = aReqComp;
			interfaceBindings = GenerateBindings();
		}

		/// <summary>
		/// Binds the RequiresInterfaces of aReqComp to the ProvidesInterfaces 
		/// of aProvComp using aBindingList.
		/// </summary>
		/// <param name="aReqComp">Component requiring something</param>
		/// <param name="aProvComp">Component providing something</param>
		/// <param name="aBindingList">A list of InterfaceBinding objects</param>
		public ComponentBinding(IComponent aReqComp, IComponent aProvComp, IList aBindingList)
		{
			provComponent = aProvComp;
			reqComponent = aReqComp;
			interfaceBindings = new InterfaceBinding[aBindingList.Count];
			aBindingList.CopyTo(interfaceBindings,0);
		}
		#endregion

		#region Data

		private IComponent provComponent;
		private IComponent reqComponent;
		private IInterfaceBinding[] interfaceBindings;
		#endregion
	}
}
