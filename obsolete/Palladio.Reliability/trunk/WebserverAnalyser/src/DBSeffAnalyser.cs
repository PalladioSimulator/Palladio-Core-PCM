using System;
using System.Collections;
using System.Data.SqlClient;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.WebserverComponentModel;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// Zusammenfassung für DBSeffAnalyser.
	/// </summary>
	public class DBSeffAnalyser : WebserverModelHelper
	{
		private ConnectionPool pool;

		public DBSeffAnalyser(ConnectionPool pool)
		{
			this.pool = pool;
		}

		public void Analyse()
		{
			AnalyseServiceEffect();
			AnalyseExecutionTimes();
		}


		private void AnalyseExecutionTimes()
		{
			SqlCommand selectInterfacesCmd = new SqlCommand();
			selectInterfacesCmd.Connection = pool.BorrowConnection();

			SqlCommand selectTimesCmd = new SqlCommand();
			selectTimesCmd.Connection = pool.BorrowConnection();

			foreach (string className in Class2Component.GetClassNames())
			{
				IComponent component = Class2Component.GetBasicComponent(className);
				CompTimesAttribute compTimeAttribute = CompTimesAttribute.GetAttribute(component);

				selectInterfacesCmd.CommandText = "SELECT DISTINCT InterfaceName FROM CallTable WHERE ClassName = '" + className + "'";
				SqlDataReader interfaceReader = selectInterfacesCmd.ExecuteReader();

				// for each interface implemented by the class
				while (interfaceReader.Read())
				{
					string interfaceName = interfaceReader.GetString(0);

					IInterfaceModel iModel = GetInterfaceModel(interfaceName);
					foreach (ISignature signature in iModel.SignatureList.GetSignatures())
					{
						MeasuredTimeAttribute timeAttribute = compTimeAttribute.GetTime(iModel.Name, signature.Name);
						selectTimesCmd.CommandText = "SELECT ExecutionTime FROM CallTable WHERE " +
							"(ClassName = '" + className + "') AND " +
							"(InterfaceName = '" + interfaceName + "') AND " +
							"(MethodName = '" + signature.Name + "')";
						SqlDataReader timesReader = selectTimesCmd.ExecuteReader();
						while (timesReader.Read())
						{
							timeAttribute.AddTime(timesReader.GetInt64(0));
						}
						timesReader.Close();
					}
				}
				interfaceReader.Close();
			}

			pool.ReturnConnection(selectInterfacesCmd.Connection);
			pool.ReturnConnection(selectTimesCmd.Connection);
		}


		private void AnalyseServiceEffect()
		{
			SqlCommand cmd = new SqlCommand();
			cmd.Connection = pool.BorrowConnection();
			cmd.CommandText = "SELECT RunID, ThreadID, CallNumber, ClassName, InterfaceName, MethodName, CallTime, ReturnTime FROM CallTable;";

			SqlDataReader reader = cmd.ExecuteReader();
			while (reader.Read())
			{
				AnalyseMethodCall(reader.GetInt64(0), reader.GetInt64(1), reader.GetInt64(2), reader.GetString(3), reader.GetString(4), reader.GetString(5), reader.GetInt64(6), reader.GetInt64(7));
			}
			reader.Close();
			pool.ReturnConnection(cmd.Connection);
		}

		private void AnalyseMethodCall(long runID, long threadID, long callNumber, string className, string interfaceName, string methodName, long startTime, long stopTime)
		{
			SqlCommand cmd = new SqlCommand();
			cmd.Connection = pool.BorrowConnection();
			cmd.CommandText = "SELECT ID, ClassName, InterfaceName, MethodName, CallTime, ReturnTime FROM CallTable "
				+ "WHERE (CallerID = " + callNumber + ") "
				+ "AND (RunID = " + runID + ") "
				+ "AND (ThreadID = " + threadID + ") ORDER BY CallNumber";

			SqlDataReader reader = cmd.ExecuteReader();

			WalkThroughSeff(reader, className, interfaceName, methodName, startTime, stopTime);

			reader.Close();
			pool.ReturnConnection(cmd.Connection);
		}

		private void WalkThroughSeff(SqlDataReader reader, string serviceClassName, string serviceInterfaceName, string serviceMethodName, long serviceStartTime, long serviceStopTime)
		{
			IServiceEffectSpecification seff = Class2Component.GetServiceEffect(serviceClassName, serviceInterfaceName, serviceMethodName);
			// service has no service effect specification
			if (seff == null)
				return;

			// analyse service effect 
			ArrayList transitionList = new ArrayList();
			IFiniteStateMachine fsm = ((IFSMServiceEffect) seff.GetServiceInformation(typeof (IFSMServiceEffect))).FSM;

			IState currentState = fsm.StartState;
			long stateEntryTime = serviceStartTime; // the start state is entered as soon as the service starts

			while (reader.Read())
			{
				string interfaceName = reader.GetString(2);
				string methodName = reader.GetString(3);
				long startTime = reader.GetInt64(4);
				long stopTime = reader.GetInt64(5);

				IService s = FindService(seff.RequiredServicesList, interfaceName, methodName);
				if (s == null)
					throw new ApplicationException("Service '" + interfaceName + "." + methodName + "' not found the Seff '" + serviceInterfaceName + "." + serviceMethodName + "' in component '" + Class2Component.GetBasicComponent(serviceClassName).Name + "'!");

				ITransition transition = fsm.GetNextTransition(currentState, FSMFactory.CreateDefaultInput(s));

				AnalyseState(stateEntryTime, startTime, currentState);
				AnalyseTransition(startTime, stopTime, transition);

				currentState = transition.DestinationState;
				stateEntryTime = stopTime; // return time of the transition is the entry time for the next state


				// Collect all visited transtions.
				// Useful for debugging service effect spec's 
				transitionList.Add(transition);
			}

			// Analyse the final state
			AnalyseState(stateEntryTime, serviceStopTime, currentState);

			// check if the last state is a final state in the seff
			if (!fsm.IsFinalState(currentState))
			{
				Console.WriteLine(serviceClassName + "\t" + serviceInterfaceName + "." + serviceMethodName);
				Console.WriteLine("No final state was reached!");
				foreach (ITransition transition in transitionList)
				{
					Console.WriteLine("\t" + TransitionToString(transition));
				}
			}

			// If a transition was taken, that is not specified by the seff,
			// the corresponding transitions are printed.
			if (ContainsErrorState(transitionList))
			{
				Console.WriteLine(serviceClassName + "\t" + serviceInterfaceName + "." + serviceMethodName);
				foreach (ITransition transition in transitionList)
				{
					Console.WriteLine("\t" + TransitionToString(transition));
				}
			}
		}

		/// <summary>
		/// Analyses the execution times of a states.
		/// </summary>
		/// <param name="stateEntryTime">Time the source state is entered.</param>
		/// <param name="transitionStartTime"></param>
		private void AnalyseState(long stateEntryTime, long transitionStartTime, IState state)
		{
			long stateTime = transitionStartTime - stateEntryTime;
			MeasuredTimeAttribute.AddTime(state, stateTime);
		}

		/// <summary>
		/// Analyses the execution times of a transition
		/// </summary>
		/// <param name="transition"></param>
		private void AnalyseTransition(long startTime, long stopTime, ITransition transition)
		{
			long transitionTime = stopTime - startTime;
			MeasuredTimeAttribute.AddTime(transition, transitionTime);
		}

		private bool ContainsErrorState(ArrayList transitionList)
		{
			foreach (ITransition transition in transitionList)
			{
				if (transition.SourceState.IsErrorState || transition.DestinationState.IsErrorState)
					return true;
			}
			return false;
		}

	}
}