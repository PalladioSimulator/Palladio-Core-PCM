using System;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public class DefaultBasicComponentBuilder : IBasicComponentBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;


		public DefaultBasicComponentBuilder(ILowLevelBuilder lowLevelBulder) 
		{
			this.lowLevelBuilder = lowLevelBuilder;
		}

	





	}
}
