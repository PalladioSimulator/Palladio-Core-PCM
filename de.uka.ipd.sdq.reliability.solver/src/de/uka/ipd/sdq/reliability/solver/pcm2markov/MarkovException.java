package de.uka.ipd.sdq.reliability.solver.pcm2markov;

public class MarkovException extends RuntimeException {

    private static final long serialVersionUID = -5972349732096236246L;

    public MarkovException() {
    }

    public MarkovException(String message) {
        super(message);
    }

    public MarkovException(String message, Exception innerException) {
        super(message, innerException);
    }
}
