using System;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// This interface defines the factory ussed to configure the whole framework. It only contains properties which 
	/// returns several other factories.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/06/22 12:01:56  joemal
	/// add factory to configure the framework
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IEnvironmentFactory
	{
		/// <summary>
		/// returns the factory which creates the elements used in the componentarchitecture
		/// </summary>
		Structure.Elements.IElementFactory ArchitectureElementFactory
		{
			get;
		}

		/// <summary>
		/// returns the factory which creates the builders used to build the componentarchitecture
		/// </summary>
		Structure.Builder.IBuilderFactory ArchitectureBuilderFactory
		{
			get;
		}

		/// <summary>
		/// returns the factory which creates the visitors used to visit components in the componentarchitecture
		/// </summary>
		Structure.Visitor.IVisitorFactory ArchitectureVisitorFactory
		{
			get;
		}
	}
}
//EOF