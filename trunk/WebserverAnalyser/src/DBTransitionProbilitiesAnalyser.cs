using System;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Identifier;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.WebserverComponentModel;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// Zusammenfassung für DBTransitionProbilitiesAnalyser.
	/// </summary>
	public class DBTransitionProbilitiesAnalyser
	{
		/// <summary>
		/// Determines the transition probabilities for each service effect specification
		/// of each component.
		/// </summary>
		/// <param name="basicComponents"></param>
		public static void ComputeTransitionProbabilities(IBasicComponent[] basicComponents)
		{
			foreach (IBasicComponent component in basicComponents)
			{
				foreach (IIdentifier providedRole in component.ProvidedRoles)
				{
					IInterfaceModel iModel = component.GetProvidesInterface(providedRole);
					foreach (ISignature signature in iModel.SignatureList.GetSignatures())
					{
						IServiceEffectSpecification seff = WebserverModelHelper.FindServiceEffectSpecification(component, iModel, signature);
						if (seff != null)
						{
							ComputeTransitionProbabilities(seff);
						}
					}
				}
			}
		}

		/// <summary>
		/// Computes the transition probabilities for a service effect specification.
		/// </summary>
		/// <param name="seff"></param>
		private static void ComputeTransitionProbabilities(IServiceEffectSpecification seff)
		{
			IFSMServiceEffect fsmSeff = (IFSMServiceEffect) seff.GetAuxiliarySpecification(typeof (IFSMServiceEffect));
			if (fsmSeff == null)
				throw new ApplicationException("No FSM found for the service effect specification!");

			foreach (IState state in fsmSeff.FSM.States)
			{
				ITransition[] transitions = fsmSeff.FSM.GetOutgoingTransitions(state);

				// The total number of visits to the state is the divisor.
				// After each visit to a state either a transition must be taken or
				// the process terminates. Therefore, each transition probaiblity
				// must be NumOfVisitsToTransition / NumOfVisitsToState.
				double total = MeasuredTimeAttribute.GetAttribute(state).NumberOfVisits;

				foreach (ITransition transition in transitions)
				{
					double visitsToTransition = MeasuredTimeAttribute.GetAttribute(transition).NumberOfVisits;
					double transitionProbability = total == 0 ? 0 : visitsToTransition/total;
					ProbabilityAttribute.SetAttribute(transition, transitionProbability);
				}
			}
		}


		private DBTransitionProbilitiesAnalyser()
		{
		}
	}
}
