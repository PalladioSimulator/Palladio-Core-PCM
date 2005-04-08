using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for all visual representations of the componentmodels connections in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class Connection : AbstractEntity
	{
		/// <summary>
		/// called to create a new visual representation of a componentmodels connection in the example.
		/// </summary>
		/// <param name="connection">the connection</param>
		/// <param name="modelEnvironment">the model</param>
		public Connection(IConnection connection, ComponentModelEnvironment modelEnvironment) : 
			base(connection, modelEnvironment)
		{
		}

		/// <summary>
		/// called to paint the visual representation of an entity and its childs
		/// </summary>
		public override void Paint()
		{
			Console.WriteLine("Connection "+Model.Name+" painted.");
		}


		/// <summary>
		/// called to return the model of the connection
		/// </summary>
		public IConnection Model
		{
			get
			{
				return (IConnection) this.entity;
			}
		}
	}
}
