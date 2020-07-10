import java.math.BigInteger;

public class IType extends Instruction{
	private String opCode;
	private String rs;
	private String imm;
	private String rt;
	private String bi="";
	
	public IType(String inst)
	{
		
		setType('I');
		setAddr(MIPS2Hex.pc);
		if (inst.contains(":"))
				{
					setLabeled(true);
					String[] splitOp= inst.split(":");
					setLabel(splitOp[0].substring(0,splitOp[0].length()));
					String[] splitInst=splitOp[1].split(",");
					setOpCode( splitInst[0].substring(0,splitInst[0].length()));
					switch (opCode)
					{
					
					case"lw":
					case"sw":
						setRs(splitInst[1].substring(0,splitInst[1].length()));
						setImm(splitInst[2].substring(0,splitInst[2].length()));
						setRt(splitInst[3]);
						break;
					default:
						setRs(splitInst[1].substring(0,splitInst[1].length()));
						setRt(splitInst[2].substring(0,splitInst[2].length()));
						setImm(splitInst[3]);
						break;
						
					}
					
					
				}
		else
			
				{
					
					setLabeled(false);
					String[] splitInst=inst.split(",");
					setOpCode( splitInst[0].substring(0,splitInst[0].length()));
					switch (opCode)
					{
					
					case"lw":
					case"sw":
						setRs(splitInst[1].substring(0,splitInst[1].length()));
						setImm(splitInst[2].substring(0,splitInst[2].length()));
						setRt(splitInst[3]);
						break;
					case"beq":
					case"bne":
						setRs(splitInst[1].substring(0,splitInst[1].length()));
						setRt(splitInst[2].substring(0,splitInst[2].length()));
						setImm(brAddr(splitInst[3]));
						break;
					default:
						setRs(splitInst[1].substring(0,splitInst[1].length()));
						setRt(splitInst[2].substring(0,splitInst[2].length()));
						setImm(splitInst[3]);
					
				
					}
					
				}
		
		

	}
	@Override public String getBi()
	{
		bi="";
		switch (this.opCode)
		{
		case "addi":
		case "andi":
		case "ori":
		case "xori":
		case "slti":
			bi+=MIPS2Hex.iopToBi(opCode);
			bi+=MIPS2Hex.regToBi(rt);
			bi+=MIPS2Hex.regToBi(rs);
			break;
		case "bne":
		case "beq":
			bi+=MIPS2Hex.iopToBi(opCode);
			bi+=MIPS2Hex.regToBi(rs);
			bi+=MIPS2Hex.regToBi(rt);
			break;
		case "sw":
		case "lw":
			bi+=MIPS2Hex.iopToBi(opCode);
			bi+=MIPS2Hex.regToBi(rt);
			bi+=MIPS2Hex.regToBi(rs);
			break;
			
		}
		
		return "0x"+new BigInteger(bi, 2).toString(16)+getImm();
	}
	public String getImm() {
		return imm;
	}
	public void setImm(String immm) {
		if(this.opCode.contains("addi")||this.opCode.contains("lw")||this.opCode.contains("sw")||this.opCode.contains("andi")||this.opCode.contains("ori")||this.opCode.contains("xori")||this.opCode.contains("slti"))
		{
		if(immm.contains("0x"))
			this.imm = immm.substring(2);
		else
		{
	         int num1=Integer.parseInt(immm);
	         if(num1<0) {	
	        	 	String num2=Integer.toHexString(num1);
	         		this.imm=num2.substring(4);
	         }
	         else {
	        	 String num2=Integer.toHexString(num1);
	        	 switch (num2.length())
	        	 {
	        	 case 1:
	        		 this.imm="000"+num2;
	        		 break;
	        	 case 2:
	        		 this.imm="00"+num2;
	        		 break;
	        	 case 3:
	        		 this.imm="0"+num2;
	        	default :
	        	 this.imm=num2;
	        		 break;
	        	 }
	         }
		}
		}
		else 
			this.imm=immm;
	         
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public String getRs() {
		return rs;
	}
	public void setRs(String rs) {
		this.rs = rs;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}

}
