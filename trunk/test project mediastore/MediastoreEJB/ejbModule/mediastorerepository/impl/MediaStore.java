package mediastorerepository.impl;

public class MediaStore

implements	mediastorerepository.impl.IMediaStore {

	protected mediastorerepository.impl.ports.IMediaStore_MediaStore m_portProvided_IMediaStore_MediaStore = new mediastorerepository.impl.ports.IMediaStore_MediaStore(
			this);

	public mediastorerepository.IMediaStore getPortProvided_IMediaStore_MediaStore() {
		return m_portProvided_IMediaStore_MediaStore;
	}

	protected mediastorerepository.impl.contexts.IMediaStoreContext myContext = null;

	public void setContext(
			mediastorerepository.impl.contexts.IMediaStoreContext myContext) {
		this.myContext = myContext;

	}

	public de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

	iMediaStore_download0(
			de.uka.ipd.sdq.simucomframework.variables.StackContext ctx)

	{
		/*
		 * PROTECTED REGION
		 * ID(download0__rzeDABpXEdyxqpPYxT_m3w__xSi60BpXEdyxqpPYxT_m3w) START
		 */

		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> resultStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> methodBodyStackFrame = ctx
				.getStack().currentStackFrame();
		if (this.myDefaultComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame
					.addVariables(this.myDefaultComponentStackFrame);
		}
		if (this.myComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame.addVariables(this.myComponentStackFrame);
		}

		/* ExternalCallAction - START */
		{ // this scope is needed if the same service is called multiple times
			// in one SEFF. Otherwise there is a duplicate local variable
			// definition.

			// Start Simulate an external call
			try {
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
						.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
						.getStack().createAndPushNewStackFrame();

				stackframe.addValue("ids.NUMBER_OF_ELEMENTS", ctx.evaluate(
						"ids.NUMBER_OF_ELEMENTS", currentFrame));

				// Start a response time measurement
				long startTimeCall_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_ = System
						.nanoTime();

				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

				myContext.getRoleRequired_IAudioDB_MediaStore().queryDB0(ctx);

				// Stop the time measurement

				// Stop the response time measurement
				long endTimeCall_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_ = System
						.nanoTime();
				long resultCall_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_ = endTimeCall_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_
						- startTimeCall_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_;
				// System.out.println("Call_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_: "+resultCall_IAudioDB_queryDB0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___GqUxwEhFEd2v5eXKEbOQ9g_);

				// Copy out parameter fileList to local stack frame

				methodBodyStackFrame.addValue("fileList.NUMBER_OF_ELEMENTS",
						ctx.evaluate("RETURN.NUMBER_OF_ELEMENTS", callResult));

				// Copy out parameter fileSize to local stack frame

				methodBodyStackFrame.addValue("fileSize.BYTESIZE", ctx
						.evaluate("RETURN.INNER.BYTESIZE", callResult));

			} finally {

				ctx.getStack().removeStackFrame();

			}
			// END Simulate an external call

		}
		/* ExternalCallAction - END */

		for (int iterationCount_gyFk0EhFEd2v5eXKEbOQ9g = 0, maxIterationCount_gyFk0EhFEd2v5eXKEbOQ9g = (Integer) ctx
				.evaluate("fileList.NUMBER_OF_ELEMENTS", Integer.class); iterationCount_gyFk0EhFEd2v5eXKEbOQ9g < maxIterationCount_gyFk0EhFEd2v5eXKEbOQ9g; iterationCount_gyFk0EhFEd2v5eXKEbOQ9g++) {

			/* ExternalCallAction - START */
			{ // this scope is needed if the same service is called multiple
				// times in one SEFF. Otherwise there is a duplicate local
				// variable definition.

				// Start Simulate an external call
				try {
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
							.getStack().currentStackFrame();
					// prepare stackframe
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
							.getStack().createAndPushNewStackFrame();

					stackframe.addValue("file.BYTESIZE", ctx.evaluate(
							"fileSize.BYTESIZE", currentFrame));

					// Start a response time measurement
					long startTimeCall_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_ = System
							.nanoTime();

					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

					myContext.getRoleRequired_ISound_MediaStore().watermark0(
							ctx);

					// Stop the time measurement

					// Stop the response time measurement
					long endTimeCall_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_ = System
							.nanoTime();
					long resultCall_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_ = endTimeCall_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_
							- startTimeCall_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_;
					// System.out.println("Call_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_: "+resultCall_ISound_watermark0__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___u770YEhFEd2v5eXKEbOQ9g_);

				} finally {

					ctx.getStack().removeStackFrame();

				}
				// END Simulate an external call

			}
			/* ExternalCallAction - END */

		}

		return resultStackFrame;

		/* PROTECTED REGION END */
	}

	public de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

	iMediaStore_upload1(
			de.uka.ipd.sdq.simucomframework.variables.StackContext ctx)

	{
		/*
		 * PROTECTED REGION
		 * ID(upload1__rzeDABpXEdyxqpPYxT_m3w__xSi60BpXEdyxqpPYxT_m3w) START
		 */

		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> resultStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> methodBodyStackFrame = ctx
				.getStack().currentStackFrame();
		if (this.myDefaultComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame
					.addVariables(this.myDefaultComponentStackFrame);
		}
		if (this.myComponentStackFrame.getContents().size() > 0) {
			methodBodyStackFrame.addVariables(this.myComponentStackFrame);
		}

		/* ExternalCallAction - START */
		{ // this scope is needed if the same service is called multiple times
			// in one SEFF. Otherwise there is a duplicate local variable
			// definition.

			// Start Simulate an external call
			try {
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
						.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
						.getStack().createAndPushNewStackFrame();

				stackframe.addValue("file.BYTESIZE", ctx.evaluate(
						"file.BYTESIZE", currentFrame));

				// Start a response time measurement
				long startTimeCall_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_ = System
						.nanoTime();

				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

				myContext.getRoleRequired_IAudioDB_MediaStore().addFile1(ctx);

				// Stop the time measurement

				// Stop the response time measurement
				long endTimeCall_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_ = System
						.nanoTime();
				long resultCall_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_ = endTimeCall_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_
						- startTimeCall_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_;
				// System.out.println("Call_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_: "+resultCall_IAudioDB_addFile1__Component__MediaStore__AssemblyCtx____this_assemblyContextID____CallID___dW7_gEg4Ed2v5eXKEbOQ9g_);

			} finally {

				ctx.getStack().removeStackFrame();

			}
			// END Simulate an external call

		}
		/* ExternalCallAction - END */

		return resultStackFrame;

		/* PROTECTED REGION END */
	}

	// Component Parameter Defaults
	protected de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myDefaultComponentStackFrame = null;

	// Component Parameter setter
	protected de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame = null;

	public void setComponentFrame(
			de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame) {
		this.myComponentStackFrame = myComponentStackFrame;
		this.myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

	}

}
