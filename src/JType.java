import java.math.BigInteger;

public class JType extends Instruction {
	
	private String jiAddr;
	public JType (String inst)
	{
		setType('J');
		setAddr(MIPS2Hex.pc);
		if (inst.contains(":"))
				{
					setLabeled(true);
					String[] splitOp= inst.split(":");
					setLabel(splitOp[0].substring(0,splitOp[0].length()));
					String[] splitInst=splitOp[1].split(" ");
					setOpCode( splitInst[0].substring(0,splitInst[0].length()));
					setjAddr(splitInst[1]);


					
					
				}
		else
			
				{
					setLabeled(false);
					String[] splitInst=inst.split(" ");
					setOpCode( splitInst[0].substring(0,splitInst[0].length()));
					setjAddr(splitInst[1]);
					
				}
		
		
	}
	@Override public String getBi()
	{
		String out="";
		if(this.getOpCode().equals("jr"))
		{
			bi="";
			bi+="000000";
			bi+=MIPS2Hex.regToBi(jiAddr);
			bi+="000000000000000";
			bi+=MIPS2Hex.ropToBi(getOpCode());
			out="0x0"+new BigInteger(bi, 2).toString(16);
		}
		
		else
		{
			bi="";
			bi+=MIPS2Hex.jopToBi(getOpCode());
			bi+=jAddr(jiAddr);
		out="0x0"+new BigInteger(bi, 2).toString(16);
		}
		return out;
	}
	public String getjAddr() {
		return jiAddr;
	}
	public void setjAddr(String jiAddr) {
		this.jiAddr = jiAddr;
	}
	}
	


