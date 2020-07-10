import java.math.BigInteger;

public class RType extends Instruction{
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public String getShamt() {
		return shamt;
	}
	public void setShamt(String shamt) {
		this.shamt = shamt;
	}
	public String getFunct() {
		return funct;
	}
	public void setFunct(String funct) {
		this.funct = funct;
	}
	private String opCode;
	private String op="000000";
	private String shamt="00000";
	private String funct;
	private String rs;
	private String rt;
	private String rd;
	@Override public String getBi()
	{
		bi=op;
		bi+=MIPS2Hex.regToBi(rs);
		bi+=MIPS2Hex.regToBi(rt);
		bi+=MIPS2Hex.regToBi(rd);
		bi+=getShamt();
		bi+=MIPS2Hex.ropToBi(getOpCode());
		return "0x0"+new BigInteger(bi, 2).toString(16);
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
	public String getRd() {
		return rd;
	}
	public void setRd(String rd) {
		this.rd = rd;
	}
	public RType (String inst)
	{
		setType('R');
		setAddr(MIPS2Hex.pc);
		if (inst.contains(":"))
				{
					setLabeled(true);
					String[] splitOp= inst.split(":");
					setLabel(splitOp[0].substring(0,splitOp[0].length()));
					String[] splitInst=splitOp[1].split(",");
					setOpCode( splitInst[0].substring(0,splitInst[0].length()));
					setRd(splitInst[1].substring(0,splitInst[0].length()));
					setRs(splitInst[2].substring(0,splitInst[0].length()));
					setRt(splitInst[3].substring(0,splitInst[0].length()));

					
					
				}
		else
			
				{
					setLabeled(false);
					String[] splitInst=inst.split(",");
					setOpCode( splitInst[0].substring(0,splitInst[0].length()));
					if(opCode.equals("move"))
					{
						setRd(splitInst[1].substring(0,splitInst[0].length()));
						setRs(splitInst[2].substring(0,splitInst[0].length()));
						setRt("$zero");
						setOpCode("add");
					}
					else
					{
					setRd(splitInst[1].substring(0,splitInst[0].length()));
					setRs(splitInst[2].substring(0,splitInst[0].length()));
					setRt(splitInst[3].substring(0,splitInst[0].length()));
					}
				}
		
		
	}
	
	

}
