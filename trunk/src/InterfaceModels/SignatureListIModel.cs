using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A SignatureList is the simplest form of an IInterfaceModel, just
	/// containing a set of signatures.
	/// </summary>
	public class SignatureListIModel : AbstractIModel  
	{
		#region Properties

		/// <summary>
		/// A list of ISignature objects.
		/// </summary>
		public IList SignatureList 
		{
			get { return signatureList; }
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
			anErrorList = new Vector();

			if (anIModel is SignatureListIModel ) 
			{
				SignatureListIModel sigListIM = (SignatureListIModel) anIModel;

				//TODO Performance Tuning!
				foreach( ISignature sI in this.SignatureList ) 
				{
					IList matchList = new Vector();
					foreach( ISignature sJ in sigListIM.SignatureList ) 
					{
						if (sigMatch.Match(sI, sJ)) 
						{
							matchList.Add(sJ);
						}
					}
					if (matchList.Count == 0)  // no match found
					{
						anErrorList.Add( new NoMatchFoundError(sI) );
					}
					else if (matchList.Count > 1) // ambiguous match
					{
						anErrorList.Add( new AmbiguousMatchError(sI,matchList) );
					}
				}
				return (anErrorList.Count == 0);
			} 
			else 
			{
				throw new IModelNotSignatureListIModelException();
			}
		}
	
		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel an anIModel.</returns>
		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if ( anIModel is SignatureListIModel ) 
			{
				SignatureListIModel sigListIM = (SignatureListIModel) anIModel;
				Vector mergedList = new Vector( this.SignatureList );
				foreach(ISignature sig in sigListIM.SignatureList)
				{
					IList matchList;
					if (!sigMatch.HasMatches( sig, mergedList,out matchList))
					{
						mergedList.Add(sig);
					} 
					else if (matchList.Count > 1) 
					{
						throw new AmbiguousMatchException(sig,matchList);
					}
				}
				SignatureListIModel resultIModel = (SignatureListIModel) this.Clone();
				resultIModel.signatureList = mergedList;
				return resultIModel;
			} 
			else 
			{
				throw new IModelNotSignatureListIModelException();
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
		public override IInterfaceModel GetIntersection( IInterfaceModel anIModel )
		{
			if ( anIModel is SignatureListIModel ) 
			{
				IList interList = new Vector();
				SignatureListIModel sigIModel = (SignatureListIModel) anIModel;

				foreach (ISignature sig in SignatureList) 
				{
					if ( sigMatch.HasOneMatch(sig, sigIModel.SignatureList) )
					{
						interList.Add( sig );
					}
				}
				SignatureListIModel resultIModel = (SignatureListIModel) this.Clone();
				resultIModel.signatureList = interList;
				return resultIModel;
			} 
			else 
			{
				throw new IModelNotSignatureListIModelException();
			}
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone() 
		{
			return new SignatureListIModel(this);
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
			if (obj is SignatureListIModel) 
			{
				SignatureListIModel other = (SignatureListIModel)obj;
				return this.SignatureList.Equals(other.SignatureList);
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
			return this.SignatureList.GetHashCode();
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			string result = "Signatures:\n";
			foreach (ISignature sig in SignatureList)
			{
				result += "\t"+sig+"\n";
			}
			return result;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty SignatureList.
		/// </summary>
		public SignatureListIModel() 
		{
			signatureList = new Vector();
			sigMatch = new EqualsSigMatch();
		}

		/// <summary>
		/// Creates a new SignatureListIModel using the Signatures contained 
		/// in aSignatureList.
		/// </summary>
		/// <param name="aSignatureList">List of ISignatures.</param>
		
		public SignatureListIModel(IList aSignatureList) 
		{
			signatureList = new Vector(aSignatureList);
			sigMatch = new EqualsSigMatch();
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSigIModel">SignatureListIModel to copy.</param>
		public SignatureListIModel(SignatureListIModel aSigIModel)
		{
			signatureList = new Vector(aSigIModel.SignatureList);
			sigMatch = new EqualsSigMatch();
		}
		#endregion

		#region Data

		private IList signatureList;
		private ISigMatch sigMatch;
		#endregion
	}
}
