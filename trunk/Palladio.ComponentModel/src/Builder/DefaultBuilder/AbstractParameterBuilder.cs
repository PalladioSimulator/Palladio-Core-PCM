using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Parameter builder - methods that are available at all levels.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.4  2005/04/20 16:23:44  joemal
	/// fix a bug
	///
	/// Revision 1.3  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.2  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractParameterBuilder : IParameterBuilder
	{
		#region data

		/// <summary>
		/// holds a reference to the modeldatamanager
		/// </summary>
		protected IModelDataManager modelDataManager;
		private IParameter parameter;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="parameter">The parameter to build.</param>
		public void Init(IModelDataManager modelDataManager, IParameter parameter)
		{
			this.modelDataManager = modelDataManager;
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
