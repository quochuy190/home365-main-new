package neo.vn.test365children.Models.list_child;

import com.google.gson.annotations.SerializedName;

public class INFOItem{

	@SerializedName("SCHOOL_NAME")
	private Object sCHOOLNAME;

	@SerializedName("MESSAGE")
	private String mESSAGE;

	@SerializedName("PASS")
	private String pASS;

	@SerializedName("LEVEL_NAME")
	private String lEVELNAME;

	@SerializedName("USERNAME")
	private String uSERNAME;

	@SerializedName("ID_LEVEL")
	private int iDLEVEL;

	@SerializedName("ERROR")
	private String eRROR;

	@SerializedName("ID")
	private int iD;

	@SerializedName("CLASS")
	private Object cLASS;

	@SerializedName("AVATAR")
	private Object aVATAR;

	@SerializedName("RESULT")
	private String rESULT;

	@SerializedName("FULLNAME")
	private Object fULLNAME;

	public void setSCHOOLNAME(Object sCHOOLNAME){
		this.sCHOOLNAME = sCHOOLNAME;
	}

	public Object getSCHOOLNAME(){
		return sCHOOLNAME;
	}

	public void setMESSAGE(String mESSAGE){
		this.mESSAGE = mESSAGE;
	}

	public String getMESSAGE(){
		return mESSAGE;
	}

	public void setPASS(String pASS){
		this.pASS = pASS;
	}

	public String getPASS(){
		return pASS;
	}

	public void setLEVELNAME(String lEVELNAME){
		this.lEVELNAME = lEVELNAME;
	}

	public String getLEVELNAME(){
		return lEVELNAME;
	}

	public void setUSERNAME(String uSERNAME){
		this.uSERNAME = uSERNAME;
	}

	public String getUSERNAME(){
		return uSERNAME;
	}

	public void setIDLEVEL(int iDLEVEL){
		this.iDLEVEL = iDLEVEL;
	}

	public int getIDLEVEL(){
		return iDLEVEL;
	}

	public void setERROR(String eRROR){
		this.eRROR = eRROR;
	}

	public String getERROR(){
		return eRROR;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setCLASS(Object cLASS){
		this.cLASS = cLASS;
	}

	public Object getCLASS(){
		return cLASS;
	}

	public void setAVATAR(Object aVATAR){
		this.aVATAR = aVATAR;
	}

	public Object getAVATAR(){
		return aVATAR;
	}

	public void setRESULT(String rESULT){
		this.rESULT = rESULT;
	}

	public String getRESULT(){
		return rESULT;
	}

	public void setFULLNAME(Object fULLNAME){
		this.fULLNAME = fULLNAME;
	}

	public Object getFULLNAME(){
		return fULLNAME;
	}
}