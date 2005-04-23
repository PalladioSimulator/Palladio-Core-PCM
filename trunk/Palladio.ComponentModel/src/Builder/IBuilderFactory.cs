using System.Collections;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Manages the wrappers/decorators for the builders which are used for the constraints.
	/// Use this factory to get new builders.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// </pre>
	/// </remarks>
	internal interface IBuilderFactory : IBuilderManager
	{

		#region properties

		IBasicComponentTypeLevelBuilder BasicComponentBuilder
		{
			get;
		}

		#endregion		
	}
}
