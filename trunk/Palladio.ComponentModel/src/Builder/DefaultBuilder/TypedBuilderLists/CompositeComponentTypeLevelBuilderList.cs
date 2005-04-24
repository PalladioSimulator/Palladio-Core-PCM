using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypedBuilderLists
{
	/// <summary>
	/// Typed List of <see cref="ICompositeComponentTypeLevelBuilder"/>. Typed collection for constraints / builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	///
	/// </pre>
	/// </remarks>
	internal class CompositeComponentTypeLevelBuilderList
	{
		private ArrayList builderList;

		/// <summary>
		/// Initializes the list.
		/// </summary>
		public CompositeComponentTypeLevelBuilderList()
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
		public void Add(ICompositeComponentTypeLevelBuilder builder)
		{
			this.builderList.Add(builder);
		}

		/// <summary>
		/// Removes the given builder from the list.
		/// </summary>
		/// <param name="builder">The builder to remove.</param>
		public void Remove(ICompositeComponentTypeLevelBuilder builder)
		{
			this.builderList.Remove(builder);
		}

		/// <summary>
		/// Starting with the first element of the list the all further elements wrap inner ones.
		/// This method returns a copies of the elements of the internal lists of builder / constraints.
		/// </summary>
		/// <param name="component">The component to build and to apply the constraints to.</param>
		/// <returns>The very most outer wrapper of the chain.</returns>
		public ICompositeComponentTypeLevelBuilder GetOuterBuilder(IComponent component)
		{
			ICompositeComponentTypeLevelBuilder[] outBuilders = new ICompositeComponentTypeLevelBuilder[builderList.Count];

			// make a copy using the clone-method of the builders
			for(int x = 0; x < builderList.Count; x++)
			{
				outBuilders[x] = ((ICompositeComponentTypeLevelBuilder)builderList[x]).Clone(component);
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
