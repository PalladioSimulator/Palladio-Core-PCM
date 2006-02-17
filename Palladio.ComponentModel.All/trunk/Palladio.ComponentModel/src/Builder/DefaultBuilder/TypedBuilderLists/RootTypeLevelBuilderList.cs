using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypedBuilderLists
{
	/// <summary>
	/// Typed List of <see cref="IRootTypeLevelBuilder"/>. Typed collection for constraints / builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.1  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// </pre>
	/// </remarks>
	internal class RootTypeLevelBuilderList
	{
		private ArrayList builderList;

		/// <summary>
		/// Initializes the list.
		/// </summary>
		public RootTypeLevelBuilderList()
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
		public void Add(IRootTypeLevelBuilder builder)
		{
			this.builderList.Add(builder);
		}

		/// <summary>
		/// Removes the given builder from the list.
		/// </summary>
		/// <param name="builder">The builder to remove.</param>
		public void Remove(IRootTypeLevelBuilder builder)
		{
			this.builderList.Remove(builder);
		}

		/// <summary>
		/// Starting with the first element of the list the all further elements wrap inner ones.
		/// This method returns a copies of the elements of the internal lists of builder / constraints.
		/// </summary>
		/// <returns>The very most outer wrapper of the chain.</returns>
		public IRootTypeLevelBuilder GetOuterBuilder()
		{
			IRootTypeLevelBuilder[] rootBuilders = new IRootTypeLevelBuilder[builderList.Count];

			// make a copy using the clone-method of the builders
			for(int x = 0; x < builderList.Count; x++)
			{
				rootBuilders[x] = ((IRootTypeLevelBuilder)builderList[x]).Clone();
			}

			for(int x = 0; x < builderList.Count; x++)
			{
				if(x != 0) //except the very first entry (the builder itself) all constraints have children.
				{
					// make a chain with the copies of the builders / constraints
					rootBuilders[x].ChildBuilder
						= rootBuilders[x - 1];
				}
			}
			return rootBuilders[builderList.Count - 1]; // return the outer constraint			
		}
	}
}
