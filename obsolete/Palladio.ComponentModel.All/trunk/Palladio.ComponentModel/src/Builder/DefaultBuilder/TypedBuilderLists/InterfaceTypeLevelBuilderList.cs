using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypedBuilderLists
{
	/// <summary>
	/// Typed List of <see cref="IInterfaceTypeLevelBuilder"/>. Typed collection for constraints / builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/06/05 10:37:48  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.1  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	///
	/// </pre>
	/// </remarks>
	internal class InterfaceTypeLevelBuilderList
	{
		private ArrayList builderList;

		/// <summary>
		/// Initializes the list.
		/// </summary>
		public InterfaceTypeLevelBuilderList()
		{
			Init();
		}

		/// <summary>
		/// ArrayList init.
		/// </summary>
		private void Init()
		{
			this.builderList = new ArrayList();
		}

		/// <summary>
		/// Adds the given builder to the list.
		/// </summary>
		/// <param name="builder">The builder to add.</param>
		public void Add(IInterfaceTypeLevelBuilder builder)
		{
			this.builderList.Add(builder);
		}

		/// <summary>
		/// Removes the given builder from the list.
		/// </summary>
		/// <param name="builder">The builder to remove.</param>
		public void Remove(IInterfaceTypeLevelBuilder builder)
		{
			this.builderList.Remove(builder);
		}

		/// <summary>
		/// Starting with the first element of the list the all further elements wrap inner ones.
		/// This method returns a copies of the elements of the internal lists of builder / constraints.
		/// </summary>
		/// <param name="ifaceId">The id of the interface to build and to apply the constraints to.</param>
		/// <returns>The very most outer wrapper of the chain.</returns>
		public IInterfaceTypeLevelBuilder GetOuterBuilder(IInterfaceIdentifier ifaceId)
		{
			IInterfaceTypeLevelBuilder[] outBuilders = new IInterfaceTypeLevelBuilder[builderList.Count];

			// make a copy using the clone-method of the builders
			for(int x = 0; x < builderList.Count; x++)
			{
				outBuilders[x] = ((IInterfaceTypeLevelBuilder)builderList[x]).Clone(ifaceId);
			}

			for(int x = 0; x < builderList.Count; x++)
			{
				if(x != 0) //except the very first entry (the builder itself) all constraints have children.
				{
					// make a chain with the copies of the builders / constraints
					outBuilders[x].ChildBuilder
						= outBuilders[x - 1];
				}
			}
			return outBuilders[builderList.Count - 1]; // return the outer constraint			
		}
	}
}
