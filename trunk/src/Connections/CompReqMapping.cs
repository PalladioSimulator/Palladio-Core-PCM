using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps the RequiresInterfaces of an inner Component
	/// onto the RequiresInterfaces of an outer Component.
	/// </summary>
	public class CompReqMapping : ICompReqMapping
	{
		#region Properties

		/// <summary>
		/// This Component is contained in the OuterComponent. 
		/// </summary>
		public IComponent InnerComponent 
		{ 
			get { return innerComponent; }
		}

		/// <summary>
		/// This Component is containing the InnerComponent.
		/// </summary>
		public IComponent OuterComponent 
		{ 
			get { return outerComponent; }
		}

		/// <summary>
		/// Connections between the interfaces of both components.
		/// </summary>
		public IIfaceReqMapping[] InterfaceMappings
		{
			get { return interfaceMappings; }
		}
		#endregion

		#region Methods 

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. The relation depends on the role of the element.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the
		/// subtypececk.</param>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		public bool IsSubType(out IList anErrorList)
		{
			// TODO:  Implementierung von CompReqMapping.IsSubType hinzufügen
			anErrorList = null;
			return false;
		}

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. The relation depends on the role of the element.
		/// </summary>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		public bool IsSubType()
		{
			// TODO:  Implementierung von CompReqMapping.Palladio.ComponentModel.IMapping.IsSubType hinzufügen
			return false;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			// TODO:  Implementierung von CompReqMapping.Clone hinzufügen
			return null;
		}

		/// <summary>
		/// Generates the IIfaceReqMappings of the two components by matching the
		/// names of the interfaces.
		/// </summary>
		/// <returns>The mappings of the RequiresInterfaces of both components.</returns>
		private IfaceReqMapping[] GenerateMappings()
		{
			IList mappingList = new ArrayList();
			foreach( RequiresInterface reqInner in innerComponent.GetRequiresIfaceList() )
			{
				bool found = false;
				foreach ( RequiresInterface reqOuter in outerComponent.GetRequiresIfaceList() )
				{
					if (reqOuter.Name.Equals(reqInner.Name))
					{
						found = true;
						mappingList.Add( new IfaceReqMapping(reqInner,reqOuter) );
						break;
					}
				}
				if (!found)
					throw new NoMappingFoundException(reqInner);
			}
			IfaceReqMapping[] result = new IfaceReqMapping[mappingList.Count];
			mappingList.CopyTo(result,0);
			return result;
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Maps the RequiresInterfaces of anInnerComp onto the
		/// RequiresInterfaces of anOuterComp by matching the names
		/// of the interfaces.
		/// </summary>
		/// <param name="anInnerComp">Component included in anOuterComp</param>
		/// <param name="anOuterComp">Component including anInnerComp</param>
		public CompReqMapping(IComponent anInnerComp, IComponent anOuterComp)
		{
			innerComponent = anInnerComp;
			outerComponent = anOuterComp;
			interfaceMappings = GenerateMappings();
		}

		/// <summary>
		/// Maps the RequiresInterfaces of anInnerComp onto the
		/// RequiresInterfaces of anOuterComp using aMappingList.
		/// </summary>
		/// <param name="anInnerComp">Component included in anOuterComp</param>
		/// <param name="anOuterComp">Component including anInnerComp</param>
		/// <param name="aMappingList">List of IIfaceReqMapping objects</param>
		public CompReqMapping(IComponent anInnerComp, IComponent anOuterComp, IList aMappingList)
		{
			innerComponent = anInnerComp;
			outerComponent = anOuterComp;
			interfaceMappings = new IfaceReqMapping[aMappingList.Count];
			aMappingList.CopyTo(interfaceMappings,0);
		}
		#endregion

		#region Data

		private IComponent innerComponent;
		private IComponent outerComponent;
		private IIfaceReqMapping[] interfaceMappings;
		#endregion
	}
}
