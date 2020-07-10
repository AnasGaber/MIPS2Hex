import java.math.BigInteger;
public class Instruction {
	protected char type;
	protected boolean labeled;
	protected String label;
	protected String instAddr;
	protected String opCode;
	protected String bi="";
	public String brAddr(String tLabel) 
	{
		BigInteger four=new BigInteger("4");
		String out;
		String brA="";
		String tAddr="";
		int i;
		for(i=0;i<MIPS2Hex.eInst.size();i++)
		{	
				if(MIPS2Hex.eInst.get(i).getLabel().equals(tLabel))
				{
					tAddr=MIPS2Hex.eInst.get(i).getAddr();	
					break;
				}
		}
		brA=MIPS2Hex.offSet(instAddr);
		 BigInteger n1 = new BigInteger(tAddr,16);
         BigInteger n2 = new BigInteger(brA,16);
         BigInteger n3 = n2.subtract(n1);

		out=n3.divide(four).toString(16);
		if(out.length()==1)
			out="000"+out;
		else if (out.length()==2)
			out="00"+out;
		else if (out.length()==3)
			out="0"+out;
		int intVal = Integer.parseInt(out, 16);
		String twosComplement = Integer.toHexString((-1 * intVal));
			return twosComplement.substring(4);
		
	}
	public String jAddr(String tLabel) 
	{

		String tAddr="";
		int i;
		for(i=0;i<MIPS2Hex.eInst.size();i++)
		{	
				if(MIPS2Hex.eInst.get(i).getLabel().equals(tLabel))
					{
					tAddr=MIPS2Hex.eInst.get(i).getAddr();
					break;
					}
				
		}
		String bTA= new BigInteger(tAddr, 16).toString(2);
		bTA=bTA.substring(4);
		bTA=bTA.substring(0, bTA.length() - 2);;
		return bTA;
		
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setLabeled(boolean b)
	{
		labeled=b;
	}
	public boolean getLabeled()
	{
		return labeled;
	}
	public void setAddr(String Addr)
	{
		instAddr=Addr;
	}
	public String getAddr()
	{
		return instAddr;
	}
	public String getBi() {
		return bi;
	}
	
}
