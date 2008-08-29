package tmp;

import java.util.Hashtable;

public class BCounts {

	private Hashtable<BytecodePos,Integer> counts;
	
	public BCounts() {
		counts = new Hashtable<BytecodePos,Integer>();

		init();
	}
	
	public Hashtable<BytecodePos,Integer> getCounts() {
		return counts;
	}
	
	private void init() {
		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "GETFIELD"), 1);		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "ILOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "SALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "BIPUSH"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "ISHL"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "IUSHR"), 1);		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of", "IRETURN"), 1);
		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set", "GETFIELD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set", "ILOAD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set", "I2S"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set", "SASTORE"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set", "RETURN"), 1);		
		
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of", "GETFIELD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of", "ILOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of", "IALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of", "IRETURN"), 1);
		
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set", "GETFIELD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set", "ILOAD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set", "IASTORE"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set", "RETURN"), 1);		
		
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "ALOAD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "DUP"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "GETFIELD"), 3);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "DUP_X1"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "ICONST_1"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "ISUB"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "PUTFIELD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "IFLE"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "IADD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "BALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "SIPUSH"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "IAND"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "GOTO"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "ICONST_M1"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte", "IRETURN"), 1);	
	}
	
}

class BytecodePos {
	private String bytecode;
	private String methodName;
	
	@Override
	public int hashCode() {
		return bytecode.hashCode() + methodName.hashCode(); 		
	}
	
	public BytecodePos(String methodName, String bytecode) {
		this.bytecode = bytecode;
		this.methodName = methodName;
	}
	
	public String getBytecode() {
		return bytecode;
	}
	public void setBytecode(String bytecode) {
		this.bytecode = bytecode;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}