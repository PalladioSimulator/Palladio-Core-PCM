using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// IParameterBuilder. Builds IParameters.
	/// Alternatively directly use the signatures methods for creating a new parameter.
	/// </summary>
	/// <remarks>
	/// <p>This builder interface contains all non model-level specifical methods of a signature.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.3  2005/04/20 13:26:43  kelsaka
	/// - added new Init-method implementation
	///
	/// Revision 1.2  2005/04/16 12:37:46  kelsaka
	/// - added first ideas using constraints with the builders
	///
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	public interface IParameterBuilder
	{
		#region Methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="parameter">The parameter to build.</param>
		void Init(IModelDataManager modelDataManager, IParameter parameter);

		#endregion

		#region Properties


		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		IParameter Parameter
		{
			get;
		}

		#endregion
	}
}
