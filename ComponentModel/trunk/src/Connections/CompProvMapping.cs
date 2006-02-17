using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps the ProvidesInterfaces of an inner Component
	/// onto the ProvidesInterfaces of an outer Component.
	/// </summary>
	public class CompProvMapping : ICompProvMapping 
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
		/// Mappings of the ProvidesInterfaces of the
		/// InnerComponent onto the ProvidesInterfaces of
		/// the OuterComponent.
		/// </summary>
		public IIfaceProvMapping[] InterfaceMappings
		{
			get { return ifaceMappings; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. In this case the ProvidesInterfaces of the outer 
		/// component have to be a subtype of the ones of the inner component.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the
		/// subtypececk.</param>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		public bool IsSubType(out System.Collections.IList anErrorList)
		{
			// TODO:  Implementierung von ProvCompMapping.IsSubType hinzufügen
			anErrorList = null;
			return false;
		}

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. In this case the ProvidesInterfaces of the outer 
		/// component have to be a subtype of the ones of the inner component.
		/// </summary>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		public bool IsSubType()
		{
			// TODO:  Implementierung von ProvCompMapping.Palladio.ComponentModel.IMapping.IsSubType hinzufügen
			return false;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			// TODO:  Implementierung von ProvCompMapping.Clone hinzufügen
			return null;
		}
		
		/// <summary>
		/// Generates the IIfaceProvMappings of the two components by matching the
		/// names of the interfaces.
		/// </summary>
		/// <returns>The mappings of the ProvidesInterfaces of both components.</returns>
		private IIfaceProvMapping[] GenerateMappings()
		{
			IList mappingList = new ArrayList();
			foreach ( ProvidesInterface provOuter in outerComponent.GetProvidesIfaceList() )
			{
				bool found = false;
				foreach( ProvidesInterface provInner in innerComponent.GetProvidesIfaceList() )
				{
					if (provOuter.Name.Equals(provInner.Name))
					{
						found = true;
						mappingList.Add( new IfaceProvMapping(provInner,provOuter) );
						break;
					}
				}
				if (!found)
					throw new NoMappingFoundException(provOuter);
			}
			IfaceProvMapping[] result = new IfaceProvMapping[mappingList.Count];
			mappingList.CopyTo(result,0);
			return result;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Maps the ProvidesInterfaces of anInnerComp onto the
		/// ProvidesInterfaces of anOuterComp by matching the names
		/// of the interfaces.
		/// </summary>
		/// <param name="anInnerComp">Component included in anOuterComp</param>
		/// <param name="anOuterComp">Component including anInnerComp</param>
		public CompProvMapping(IComponent anInnerComp, IComponent anOuterComp)
		{
			innerComponent = anInnerComp;
			outerComponent = anOuterComp;
			ifaceMappings = GenerateMappings();
		}

		/// <summary>
		/// Maps the ProvidesInterfaces of anInnerComp onto the
		/// ProvidesInterfaces of anOuterComp using aMappingList.
		/// </summary>
		/// <param name="anInnerComp">Component included in anOuterComp</param>
		/// <param name="anOuterComp">Component including anInnerComp</param>
		/// <param name="aMappingList">List of IIfaceProvMapping objects</param>
		public CompProvMapping(IComponent anInnerComp, IComponent anOuterComp, IList aMappingList)
		{
			innerComponent = anInnerComp;
			outerComponent = anOuterComp;
			ifaceMappings = new IfaceProvMapping[aMappingList.Count];
			aMappingList.CopyTo(ifaceMappings,0);
		}
		#endregion

		#region Data

		private IIfaceProvMapping[] ifaceMappings;
		private IComponent innerComponent;
		private IComponent outerComponent;
		#endregion
	}
}
