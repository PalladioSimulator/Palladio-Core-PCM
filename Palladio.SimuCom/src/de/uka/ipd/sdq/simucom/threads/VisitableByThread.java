package de.uka.ipd.sdq.simucom.threads;

public interface VisitableByThread {
	void accept(IThreadActionVisitor t);
}
