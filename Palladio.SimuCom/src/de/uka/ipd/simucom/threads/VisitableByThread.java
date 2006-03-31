package de.uka.ipd.simucom.threads;

public interface VisitableByThread {
	void accept(IThreadActionVisitor t);
}
