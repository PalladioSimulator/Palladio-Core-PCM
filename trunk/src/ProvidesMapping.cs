using System;

namespace ComponentModel
{
	/// <summary>
	/// </summary>
	public class ProvidesMapping
	{
		public ProvidesInterface InnerProvI { get; }
		public ProvidesInterface OuterProvI { get; }

		public IComponent InnerComp { get; }
		public IComponent OuterComp { get; }


		public ProvidesMapping ( IComponent anInnerComp, ProvidesInterface anInnerProvI, 
								 IComponent anOuterComp, ProvidesInterface anOuterProvI )
		{
		}
	}
}
