//Anas Gaber Youssef 2066017
//Utku Can Kutkut    2152080
import java.math.BigInteger;
import java.util.ArrayList;

public class MIPS2Hex {
	//convert register address to binary
	public static String regToBi(String r) 
	{
		String rb="";
		switch(r) {
		
		case "$zero":
				rb="00000";
			break;
		case "$v0":
				rb="00010";
				break;
		case "$v1":
				rb="00011";
				break;
		case "$a0":
				rb="00100";
				break;
		case "$a1":
				rb="00101";
				break;
		case "$a2":
				rb="00110";
				break;
		case "$a3":
				rb="00111";
				break;
		case "$t0":
				rb="01000";
				break;
		case "$t1":
				rb="01001";
				break;
		case "$t2":
				rb="01010";
				break;
		case "$t3":
				rb="01011";
				break;
		case "$t4":
				rb="01100";
				break;
		case "$t5":
				rb="01101";
				break;
		case "$t6":
				rb="01110";
				break;
		case "$t7":
				rb="01111";
				break;
		case "$s0":
				rb="10000";
				break;
		case "$s1":
				rb="10001";
				break;
		case "$s2":
				rb="10010";
				break;
		case "$s3":
				rb="10011";
				break;
		case "$s4":
				rb="10100";
				break;
		case "$s5":
				rb="10101";
				break;
		case "$s6":
				rb="10110";
				break;
		case "$s7":
				rb="10111";
				break;	
		case "$sp":
			rb="11101";
			break;
				
		}
		return rb;
	}
	//convert rtype op to binary
	public static String ropToBi(String op)
	{
		String rOp="";
		switch (op)
		{
		case"add":
			rOp="100000";
			break;
		case"slt":
			rOp="101010";
			break;
		case"sll":
			rOp="000000";
			break;
		case"subu":
			rOp="100011";
			break;
		case"srl":
			rOp="000010";
			break;
		case"sub":
			rOp="100010";
			break;
		case"addu":
			rOp="100001";
			break;
		case"and":
			rOp="100100";
			break;
		case"or":
			rOp="100101";
			break;
		case"nor":
			rOp="100111";
			break;
		case"xor":
			rOp="100110";
			break;
		case"jr":
			rOp="001000";
			break;
		}
		
		return rOp;
	}
	public static String iopToBi(String op)
	{
		String iOp="";
		switch (op)
		{
		case"addi":
			iOp="001000";
			break;
		case"beq":
			iOp="000100";
			break;
		case"bne":
			iOp="000101";
			break;
		case"lw":
			iOp="100011";
			break;
		case"sw":
			iOp="101011";
			break;
		case"andi":
			iOp="001100";
			break;
		case"ori":
			iOp="001101";
			break;
		case"xori":
			iOp="001110";
			break;
		case"slti":
			iOp="001010";
			break;
		}
		
		return iOp;
	}
	public static String jopToBi(String op)
	{
		String jOp="";
		switch (op)
		{
		case"j":
			jOp="000010";
			break;
		case"jal":
			jOp="000011";
			break;
		case"jr":
			jOp="";
			break;
			
		}
		return jOp;
	}
		
	public static void iCp()
	{
		BigInteger four=new BigInteger("4");
		BigInteger decimal = new BigInteger(pc,16);
        decimal = decimal.add(four);    
        pc=decimal.toString(16);
        
	}
	public static String offSet(String cAddr)
	{
		BigInteger four=new BigInteger("4");
		BigInteger decimal = new BigInteger(cAddr,16);
        decimal = decimal.add(four);    
        return decimal.toString(16);
        
	}
	public static String inst;
	public static ArrayList<Instruction> eInst=new ArrayList<Instruction>();
	public static String pc="80001000";
	public static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList<String> biList = new ArrayList<String>();
	public static void main(String[] args) throws NullPointerException {
		
		
		GUI nG=new GUI();
		nG.setVisible(true);

	}
	}


