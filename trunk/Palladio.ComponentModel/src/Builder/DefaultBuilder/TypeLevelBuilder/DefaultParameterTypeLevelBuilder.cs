using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the parameter builder at the type level.
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
	public class DefaultParameterTypeLevelBuilder : AbstractParameterBuilder, IParameterTypeLevelBuilder
	{

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="parameter">The parameter to build.</param>
		public DefaultParameterTypeLevelBuilder(ILowLevelBuilder lowLevelBuilder, IParameter parameter) 
		{
			base.Init(lowLevelBuilder, parameter);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IParameterImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException ("ImplementationLevelBuilder is not done yet."); }
		}
	}
}
