//using System;
//using System.Collections;
//using Utils.Collections;
//
//
//namespace FiniteStateMachines.Decorators {
//	/// <summary>
//	/// Zusammenfassung für FSP.
//	/// </summary>
//	public class FSP {
//		protected FSM one;
//		protected FSM two;
//		protected FSM sp;
//		protected bool debug = !false;
//
//		public FSP() {
//			
//		}
//		public FSP(FSM one, FSM two) {
//			this.one = one;
//			this.two = two;
//			this.sp = GenerateFSP(one,two);
//		}
//		public FSM getSP() {
//			return this.sp;
//		}
//		public FSM GenerateFSP(FSM one, FSM two) {
//			this.sp = new FSM();
//			Stack oneStates = new Stack();
//			Stack twoStates = new Stack();
//
//			Set spInput = GenerateSpInput(one,two);
//
//	
//			CPState StartState = new CPState(one.StartState,two.StartState);
//			oneStates.Push(one.StartState);
//			twoStates.Push(two.StartState);
//			while(oneStates.Count!= 0 && twoStates.Count!=0) {
//
//				AbstractState oneBefore = (AbstractState) oneStates.Pop();
//				AbstractState twoBefore = (AbstractState) twoStates.Pop();
//
//				
//
//				CPState fromState = new CPState(oneBefore,twoBefore);
//				CPState toState = new CPState();
//				foreach(Input i in spInput) {
//
//
//					AbstractState oneNext = one.GetNextState(oneBefore,i);
//					if(this.debug)
//						Console.WriteLine("oneNext is: "+oneNext.ToString());
//
//
//					AbstractState twoNext = two.GetNextState(twoBefore,i);
//					if(this.debug)
//						Console.WriteLine("twoNext is: "+twoNext.ToString());
//
//
//					if(BigSelfPointing(i,fromState)) {
//						Console.WriteLine("Big Selfpointing");
//						this.sp.setTransition(fromState,i,fromState);
//						oneStates.Pop();
//						twoStates.Pop();
//						continue;
//					}
//					if(SelfPointing(oneBefore,one,i)&& SelfPointing(twoBefore,two,i)) {
//						//						//&& oneNext !=one.ErrorState && twoNext!=two.ErrorState)
//						Console.WriteLine("Both Selfpointing");
//						CPState sps = new CPState(oneNext,twoNext);
//						Console.WriteLine("in selfpointing folling transition set: "+"\n"
//							+new Transition(sps.getState(),i,sps.getState()));
//						this.sp.setTransition(sps,i,sps);
//						//						if(SelfPointing(oneBefore,one,i))
//						oneStates.Pop();
//						//						if(SelfPointing(twoBefore,two,i))
//						twoStates.Pop();
//					}
//					//if oneNext is ErrorState and twoNext not
//					//1
//					if(oneNext != one.ErrorState && twoNext != two.ErrorState) {
//						Console.WriteLine("both are not ErrorState");
//						toState = new CPState(oneNext,twoNext);
//						sp.setTransition(fromState,i,toState);
//						Console.WriteLine("1: i put on Stack :"+ oneNext.ToString()+" "+ twoNext.ToString());
//						oneStates.Push(oneNext);
//						twoStates.Push(twoNext);
//					}
//					//2
//					if(oneNext == one.ErrorState && 
//						twoNext != two.ErrorState) {
//						if(!oneBefore.Equals(one.ErrorState)) {
//							Console.WriteLine("OneBefore is : "+oneBefore+" and not Errorstate.");
//							toState = new CPState(oneBefore,twoNext);
//							this.sp.setTransition(fromState,i,toState);
//							oneStates.Push(oneBefore);
//							twoStates.Push(twoNext);
//							Console.WriteLine("2: i put on Stack :"+ oneBefore.ToString()+" "+ twoNext.ToString());
//						}
//						else
//							Console.WriteLine("no way 2");
//					}
//					//oneNext !=errorState twoNext == Errorstate
//					//3
//					if(oneNext!= one.ErrorState && twoNext == two.ErrorState) {
//						
//						if(twoBefore.Equals(two.ErrorState)) {
//							Console.WriteLine("twoBefore is : "+twoBefore+"and not ErrorState");
//							toState = new CPState(oneNext,twoBefore);
//							this.sp.setTransition(fromState,i,toState);
//							oneStates.Push(oneNext);
//							twoStates.Push(twoBefore);
//							Console.WriteLine("3: i put on Stack :"+ oneNext.ToString()+" "+ twoBefore.ToString());
//						}
//						Console.WriteLine("no way 3");
//				
//					}
//				
//
//					
//					//					if(fromState == toState)
//					//					{
//					//						Console.WriteLine("beide gleich");
//					//						oneStates.Pop();
//					//						twoStates.Pop();
//					//				
//					//			
//					//					}
//					Console.WriteLine("------------------------------");
//				}
//			}
//			return this.sp;
//		}
//		protected bool SelfPointing(AbstractState state, FSM fsm,Input i) {
//			if(one.GetNextState(state,i)== state)
//				return true;
//			return false;
//			
//			
//		}
//		protected bool BigSelfPointing(Input i,CPState fromState) {
//			CPState s = new CPState(this.one.GetNextState(fromState.oneState,i),
//				this.two.GetNextState(fromState.twoState,i));
//			Console.WriteLine(s.ToString()+" != "+fromState.ToString());
//			Console.WriteLine("fromstate is :" +fromState.ToString());
//			if(s==fromState)
//				return true;
//			return false;
//		}
//			
//	
//		protected Set GenerateSpInput(FSM one, FSM two) {
//			Set spInput = new Set();
//			Set oneInput = one.InputAlphabet;
//			Set twoInput = two.InputAlphabet;
//			foreach(Input i in oneInput)
//				spInput.Add(i);
//			foreach(Input i in twoInput)
//				spInput.Add(i);
//			return spInput;
//		}
//	}
//}
