using Palladio.Attributes;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// Connects the RequiresInterface of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.2  2005/02/21 15:37:43  joemal
	/// replace keyword as with real typcast
	///
	/// Revision 1.1  2005/02/21 13:48:18  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultAssemblyConnector : DefaultConnection, IAssemblyConnector
	{
		public DefaultAssemblyConnector(AttributeHash anAttHash, IRole aReqRole, IRole aProvRole) : base(anAttHash,aReqRole,aProvRole) {}

		public DefaultAssemblyConnector(DefaultAssemblyConnector aAssemblyConnector) : base(aAssemblyConnector) {}

		public override object Clone()
		{
			return new DefaultAssemblyConnector(this);
		}
	}
}
