using System;
using System.Collections;
using ComponentNetworkSimulation;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using ReflectionBasedVisitor;
namespace testapplication
{

	public class TestApp
	{
		public static Random random = new Random();

		public static void Main()
		{
	/*		try 
			{
				ISimulationEnvironment env = new SimpleTestSimulationEnvironment();
				env.Simulate();
			}
			catch(Exception exc)
			{
				Console.Out.WriteLine(""+exc.GetType()+exc.StackTrace);
				
			}
*/
			IFiniteStateMachine fsm = createFSM();
			MyVisitor visitor = new MyVisitor();
			visitor.setStartService(fsm);
			int cntr = 0;
			while(visitor.VisitNext() && cntr++<20);
			Console.ReadLine();
		}

		private static IFiniteStateMachine createFSM()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());		
			InputSymbolHash inps = FSMFactory.CreateInputFromList("e0","e1","e2");
			fsm.AddInputSymbols(inps.StoredInputs);

			StateHash states = FSMFactory.CreateStatesFromList("0","1","2","3");
			fsm.AddStates(states.StoredStates);
			fsm.StartState = states["0"];
			fsm.FinalStates = new IState[] {states["3"]};
			
			fsm.AddTransition("0",inps["e0"].ID,"1");
			fsm.AddTransition("1",inps["e1"].ID,"2");
			fsm.AddTransition("1",inps["e2"].ID,"3");
			fsm.AddTransition("2",inps["e2"].ID,"3");

			return fsm;
		}

		public class MyVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
		{
			private ArchitectureStack stack = new ArchitectureStack();

			public MyVisitor() : base(false){}

			//Todo: later add service, IFaceModel, Component
			public void setStartService(IFiniteStateMachine fsm)
			{
				stack.Clear();
				stack.Push(fsm);
			}

			public bool VisitNext()
			{
				Console.WriteLine("Next Step");
				if (stack.Count != 0) Visit(stack.Pop());

				return (stack.Count != 0);
			}

			public override void VisitObject(object o)
			{
				Console.WriteLine("Visit unknown obj");
			}

			public void VisitIState(IState state)
			{
				Console.WriteLine("Visit state: "+state);
				IFiniteStateMachine fsm = (IFiniteStateMachine)stack.Peek();

				ITransition[] outTrans = fsm.GetOutgoingTransitions(state);
				int count = outTrans.Length;

				if (fsm.IsFinalState(state)) count ++;
                int next = TestApp.random.Next(count);				

				if (next < outTrans.Length)	
					stack.Push(outTrans[next]);
				else 
					stack.Pop();
			}

			public void VisitITransition(ITransition transition)
			{
				Console.WriteLine("Visit transition: "+transition.InputSymbol);
				stack.Push(transition.DestinationState);
			}
		}

		public class StaticTimeState : IState
		{
			protected string id;
			protected IAttributeHash attributes;

			/// <summary>
			/// If true, this state is an error state in which the FSM can drop if
			/// running along an invalid transition
			/// </summary>
			public bool IsErrorState
			{
				get
				{
					return false;
				}

				set
				{
				}
			}
		
			/// <summary>
			/// Return a string representation of this state, e.g. for graphical output.
			/// Here implemented as payload.ToString();
			/// </summary>
			public string ID
			{
				get
				{
					return id;
				}
			}

			/// <summary>
			/// Information describing this state. Any type of information object can be
			/// associated to a state.
			/// </summary>
			public virtual IAttributeHash Attributes
			{
				get
				{
					return attributes;
				}
			}

			/// <summary>
			///		Default implementation of GetHashCode(). 
			///		Refers to the hashcode of name.
			/// </summary>
			/// <returns>
			///		Hashcode of Name
			///	</returns>
			public override int GetHashCode() 
			{
				return id.GetHashCode();
			}
		
			/// <summary>
			///		Default implementation of Equals.
			/// </summary>
			/// <param name="obj">
			///		The other object.
			///	</param>
			/// <returns>
			///		True, if Name, IsStartState and
			///		IsFinalState are Equal; false otherwise.
			///	</returns>
			public override bool Equals(object obj) 
			{
				if (obj is IState) 
				{ 
					IState state = (IState)obj;
					return id.Equals(state.ID);
				}
				return false;
			}

			/// <summary>
			/// Overriden ToString for debug purposes
			/// </summary>
			/// <returns>The label of this state</returns>
			public override string ToString()
			{
				return ID;
			}

			/// <summary>
			/// Implementation of the data structure driven visitor movement. It is
			/// not implemented here!
			/// </summary>
			/// <param name="v">The visitor visiting this object</param>
			public virtual void AcceptVisitor(IVisitor v) {}
		}
 

		public class ArchitectureStack : Stack
		{
			public void Push(IState state)
			{
                base.Push(state);
			}

			public void Push(ITransition transition)
			{
				base.Push(transition);
			}

			public void Push(IFiniteStateMachine fsm)
			{
				base.Push(fsm);
				this.Push(fsm.StartState);
			}
			
			//todo: später mal weiter Push methoden für Komponenten, IFaces und Services

			public override void Push(object obj)
			{
				throw(new NotImplementedException("This method is not supported in this implementation of stack."));
			}

			public Type PeekType() 
			{
				return this.Peek().GetType();
			}
		}
	}
}
