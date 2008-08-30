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
		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "GETFIELD"), 1);		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "ILOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "SALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "BIPUSH"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "ISHL"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "IUSHR"), 1);		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.of(I)I", "IRETURN"), 1);		
		
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set(II)V", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set(II)V", "GETFIELD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set(II)V", "ILOAD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set(II)V", "I2S"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set(II)V", "SASTORE"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/CodeTable.set(II)V", "RETURN"), 1);		
				
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of(I)I", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of(I)I", "GETFIELD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of(I)I", "ILOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of(I)I", "IALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.of(I)I", "IRETURN"), 1);
				
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set(II)V", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set(II)V", "GETFIELD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set(II)V", "ILOAD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set(II)V", "IASTORE"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/Compressor$HashTable.set(II)V", "RETURN"), 1);				
		
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "ALOAD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "DUP"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "GETFIELD"), 3);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "DUP_X1"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "ICONST_1"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "ISUB"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "PUTFIELD"), 2);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "IFLE"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "IADD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "BALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "SIPUSH"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "IAND"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "GOTO"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "ICONST_M1"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/InputBuffer.readByte()I", "IRETURN"), 1);	
		
		counts.put(new BytecodePos("spec/benchmarks/compress/ Compressor$HashTable.hsize()I", "ALOAD"), 1);
		counts.put(new BytecodePos("spec/benchmarks/compress/ Compressor$HashTable.hsize()I", "GETFIELD"), 1);
		counts.put(new BytecodePos("sspec/benchmarks/compress/ Compressor$HashTable.hsize()I", "IRETURN"), 1);
		
	}
	
}

class BytecodePos {
	private String bytecode;
	private String methodName;
	
	@Override
	public int hashCode() {
		return bytecode.hashCode() + methodName.hashCode(); 		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof BytecodePos) {
			BytecodePos bcpos = (BytecodePos)obj;
			if(bcpos.getBytecode().compareTo(this.bytecode) == 0 &&
					bcpos.getMethodName().compareTo(this.methodName) == 0) {
				return true;
			}
		} 
		return false;	
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