using System;
using System.Collections;


namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Methods and data common to the Provides- and RequiresInterface.
	/// </summary>
	public abstract class AbstractComponentInterface : AbstractIModel 
	{
		#region Properties

		/// <summary>
		/// The IInterfaceModel describing the ComponentInterface.
		/// </summary>
		public IInterfaceModel IModel 
		{
			get { return iModel; }
		}

		/// <summary>
		/// An unique name of the ComponentInterface.
		/// </summary>
		public string Name
		{
			get { return name; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if this interface is a subset of anIModel. In
		/// other words all services of this IInterfaceModel must be
		/// provided by anIModel and all relations between these 
		/// services expected by this IInterfaceModel must be fulfilled
		/// by anIModel, but anIModel can provide more than what is required
		/// by this IInterfaceModel.
		/// </summary>
		/// <param name="anIModel">An other IInterfaceModel.</param>
		/// <param name="anErrorList">List of error which occured during the subtypecheck.</param>
		/// <returns>True, if this IInterfaceModel is a subset of anIModel, false otherwise.</returns>
		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			if (anIModel is AbstractComponentInterface) 
			{
				AbstractComponentInterface compIface = (AbstractComponentInterface) anIModel;
			return IModel.IsSubSetOf( compIface.IModel, out anErrorList );
			}
			else
			{
				throw new IModelNotComponentInterfaceException();
			}
		}

		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel an anIModel.</returns>
		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if (anIModel is AbstractComponentInterface) 
			{
				AbstractComponentInterface compIface = (AbstractComponentInterface) anIModel;
				AbstractComponentInterface resultIface = (AbstractComponentInterface) this.Clone();
				resultIface.iModel = IModel.Merge( compIface.IModel );
				return resultIface;
			}
			else
			{
				throw new IModelNotComponentInterfaceException();
			}
		}

		/// <summary>
		/// Intersects this IInterfaceModel and anIModel. 
		/// The result contains alls services and relationships wich exist in both
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModel">IInterfaceModel to intersect with.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of both IInterfaceModels</returns>
		public override IInterfaceModel GetIntersection(IInterfaceModel anIModel)
		{
			if (anIModel is AbstractComponentInterface) 
			{
				AbstractComponentInterface compIface = (AbstractComponentInterface) anIModel;
				AbstractComponentInterface resultIface = (AbstractComponentInterface) this.Clone();
				resultIface.iModel = IModel.GetIntersection( compIface.IModel );
				return resultIface;
			}
			else
			{
				throw new IModelNotComponentInterfaceException();
			}
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (obj is AbstractComponentInterface)
			{
				AbstractComponentInterface aComIface = (AbstractComponentInterface)obj;
				return (this.IModel.Equals( aComIface.IModel ) &&
					this.Name.Equals( aComIface.Name ));
			}
			return false;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return name.GetHashCode ();
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new AbstractComponentInterface using anIModel as 
		/// IInterfaceModel and aName as name.
		/// </summary>
		/// <param name="anIModel">Model describing this ComponentInterface.</param>
		/// <param name="aName">A unique name of the ComponentInterface.</param>
		protected AbstractComponentInterface( IInterfaceModel anIModel, string aName )
		{
			iModel = (IInterfaceModel)anIModel.Clone();
			name = (string)aName.Clone();
		}
		#endregion

		#region Data

		private IInterfaceModel iModel;
		private string name;
		#endregion
	}
}