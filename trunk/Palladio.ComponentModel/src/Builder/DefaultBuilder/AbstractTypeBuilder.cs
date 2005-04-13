using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Type builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractTypeBuilder : ITypeBuilder
	{
		#region data

		private ILowLevelBuilder lowLevelBuilder;
		private IType type;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="type">The type to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IType type)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.type = type;			
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IType Type
		{
			get { return this.type; }
		}

		#endregion


	}
}
