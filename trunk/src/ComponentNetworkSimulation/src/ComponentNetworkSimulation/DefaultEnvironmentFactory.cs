using System;
using ComponentNetworkSimulation.Structure.Elements;
using ComponentNetworkSimulation.Structure.Builder;
using ComponentNetworkSimulation.Structure.Visitor;

namespace ComponentNetworkSimulation
{
	/// <summary>
	/// This is the default environmentfactory of the framework. It all created instances are from the default classes of the
	/// framework. To change some of the elements, override the properties and return special factories. This is the only factory,
	/// that can be extended.
	/// 
	/// Example of extension:
	/// 
	/// To change some creational methods in the ElementFactory, implement the interface IElementFactory. 
	/// All methods that should not be changed, can be delegated to the default elementfactory, created by a call to 
	/// CreateDefaultElementFactory(). Other methods can return own instances.
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/06/22 12:01:56  joemal
	/// add factory to configure the framework
	///
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultEnvironmentFactory : IEnvironmentFactory
	{
		#region data

		/// <summary>
		/// holds the instance of IElementFactory
		/// </summary>
		private IElementFactory elementFactory;

		/// <summary>
		/// holds the instance of IBuilderFactory
		/// </summary>
		private IBuilderFactory builderFactory;

		/// <summary>
		/// holds the instance of IVisitorFactory
		/// </summary>
		private IVisitorFactory visitorFactory;

		#endregion

		/// <summary>
		/// return the used instance of IElementFactory. By default, this is the default one of the framework.
		/// </summary>
		public virtual IElementFactory ArchitectureElementFactory
		{
			get
			{
				if (elementFactory == null) elementFactory = CreateDefaultElementFactory();
				return elementFactory;
			}
		}

		/// <summary>
		/// return the used instance of IBuilderFactory. By default, this is the default one of the framework.
		/// </summary>
		public virtual IBuilderFactory ArchitectureBuilderFactory
		{
			get
			{
				if (builderFactory == null) builderFactory = CreateDefaultBuilderFactory(this.ArchitectureElementFactory);
				return builderFactory;
			}
		}

		/// <summary>
		/// return the used instance of IVisitorFactory. By default, this is the default one of the framework.
		/// </summary>
		public virtual IVisitorFactory ArchitectureVisitorFactory
		{
			get
			{
				if (visitorFactory == null) visitorFactory = CreateDefaultVisitorFactory();
				return visitorFactory;
			}
		}

		/// <summary>
		/// called to create a the default elementfactory of the framework
		/// </summary>
		/// <returns>the default elementfactory of the framework</returns>
		public static IElementFactory CreateDefaultElementFactory()
		{
			return new Structure.Elements.DefaultElementFactory();
		}
		
		/// <summary>
		/// called to create a the default visitorfactory of the framework
		/// </summary>
		/// <returns>the default visitorfactory of the framework</returns>
		public static IVisitorFactory CreateDefaultVisitorFactory()
		{
			return new Structure.Visitor.DefaultVisitorFactory();
		}

		/// <summary>
		/// called to create a the default elementfactory of the framework
		/// </summary>
		/// <param name="elements">the elementfactory, used by the builders to create the elements of the architecture</param>
		/// <returns>the default elementfactory of the framework</returns>
		public static IBuilderFactory CreateDefaultBuilderFactory(Structure.Elements.IElementFactory elements)
		{
			return new Structure.Builder.DefaultBuilderFactory(elements);
		}
	}
}
//EOF