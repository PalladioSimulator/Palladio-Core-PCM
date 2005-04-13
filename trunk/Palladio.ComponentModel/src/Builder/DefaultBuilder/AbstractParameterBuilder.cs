using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Parameter builder - methods that are available at all levels.
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
	public abstract class AbstractParameterBuilder : IParameterBuilder
	{
		#region data

		private ILowLevelBuilder lowLevelBuilder;
		private IParameter parameter;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="parameter">The parameter to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IParameter parameter)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.parameter = parameter;
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IParameter Parameter
		{
			get { return this.parameter; }
		}

		#endregion


	}
}
