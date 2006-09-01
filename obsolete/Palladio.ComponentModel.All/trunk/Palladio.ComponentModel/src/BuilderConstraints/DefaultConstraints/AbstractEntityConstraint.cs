using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Query;
using Palladio.Identifier;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints
{
	/// <summary>
	/// the base class of all constraint that belong to the entity builders. 
	/// It holds the instance of the entity and the query interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/06/05 10:28:35  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractEntityConstraint : IEntityBuilder 
	{
		#region data

		//the id of the builders entity
		private IIdentifier entityId;

		//the query interface of the model
		private IQuery query;

		#endregion

		/// <summary>
		/// called to create the constraint
		/// </summary>
		/// <param name="query">the query</param>
		public AbstractEntityConstraint(IQuery query)
		{
			this.query = query;
		}

		/// <summary>
		/// internal constructor that has to be used by the clone method to create a copy of this constraint using
		/// the given entity.
		/// </summary>
		/// <param name="entityId">the id of the entity</param>
		/// <param name="query">the query</param>
		protected AbstractEntityConstraint(IIdentifier entityId, IQuery query)
		{
			this.entityId = entityId;
			this.query = query;
		}

		/// <summary>
		/// called to get the instance of the models query interface
		/// </summary>
		protected IQuery Query
		{
			get { return query; }
		}

		/// <summary>
		/// called to returns the id of the entity that belongs to this builder
		/// </summary>
		public IIdentifier Id
		{
			get
			{
				return this.entityId;
			}
		}
	}
}
