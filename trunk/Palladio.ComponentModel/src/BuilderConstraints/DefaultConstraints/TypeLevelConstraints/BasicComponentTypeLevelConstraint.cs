using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.Query;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints
{

	/// <summary>
	/// Default constraints for basic components at the type level. This constraints are used always
	/// as they are the neccessary for a valid and consistent static structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.7  2005/06/05 10:38:31  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.6  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.5  2005/05/21 17:12:17  kelsaka
	/// - added new exception for use with signatures
	/// - finished adding constraints for the type level
	///
	/// Revision 1.4  2005/05/18 09:47:38  kelsaka
	/// - added BC default constraints implementation
	/// - fixed error in unit tests / added new test-case
	///
	/// Revision 1.3  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.2  2005/04/23 17:42:08  kelsaka
	/// - added further methods for constraint-support
	///
	/// Revision 1.1  2005/04/23 14:56:44  kelsaka
	/// - enhanced constraints management
	///
	/// </pre>
	/// </remarks>
	public class BasicComponentTypeLevelConstraint : ComponentTypeLevelConstraint,IBasicComponentTypeLevelBuilder
	{
		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="query">the query interface of the model.</param>
		public BasicComponentTypeLevelConstraint(IQuery query):
			base(query)
		{
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="query">the query interface of the model.</param>
		/// <param name="componentId">The id of the component this instance is constraint for.</param>
		private BasicComponentTypeLevelConstraint(IComponentIdentifier componentId, IQuery query):
			base(componentId,query)

		{
		}

		#endregion

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IBasicComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get
			{
				return ((IBasicComponentTypeLevelBuilder)componentBuilderSuccessor).ImplementationLevelBuilder;
			}
		}

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		/// <remarks>This property should only be used for constraints management. Constraints
		/// in the component model are organized as an kind of pipe and filter architecture.
		/// For this the ChildBuilder property allows to set the successor (child) that is
		/// called after executing the acutal constraint. If there is no violation of a constraint
		/// each constraint-class delegates the request to its child; otherwise exceptions
		/// will be thrown.</remarks>
		public IBasicComponentTypeLevelBuilder ChildBuilder
		{
			set
			{
				this.componentBuilderSuccessor = value;
			}
		}

		/// <summary>
		/// Clones the actual builder / constraints instance except the created / supervised
		/// component model entity.
		/// </summary>
		/// <param name="compId">The id of the component model entity that has to be builder /
		/// supervised.</param>
		/// <returns>A copy of the actual builder / constraint.</returns>
		/// <remarks>This method should only be used for constraints management.</remarks>
		public IBasicComponentTypeLevelBuilder Clone(IComponentIdentifier compId)
		{
			return new BasicComponentTypeLevelConstraint(compId,this.Query);		}
		}
}
