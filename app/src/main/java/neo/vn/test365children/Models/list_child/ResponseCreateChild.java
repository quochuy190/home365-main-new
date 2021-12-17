package neo.vn.test365children.Models.list_child;

import com.google.gson.annotations.SerializedName;

public class ResponseCreateChild{

	@SerializedName("MESSAGE")
	private String mESSAGE;

	@SerializedName("USER_MOTHER")
	private String uSERMOTHER;

	@SerializedName("PASSWORD")
	private String pASSWORD;

	@SerializedName("USER_CHILD")
	private String uSERCHILD;

	@SerializedName("ERROR")
	private String eRROR;

	@SerializedName("RESULT")
	private String rESULT;

	public void setMESSAGE(String mESSAGE){
		this.mESSAGE = mESSAGE;
	}

	public String getMESSAGE(){
		return mESSAGE;
	}

	public void setUSERMOTHER(String uSERMOTHER){
		this.uSERMOTHER = uSERMOTHER;
	}

	public String getUSERMOTHER(){
		return uSERMOTHER;
	}

	public void setPASSWORD(String pASSWORD){
		this.pASSWORD = pASSWORD;
	}

	public String getPASSWORD(){
		return pASSWORD;
	}

	public void setUSERCHILD(String uSERCHILD){
		this.uSERCHILD = uSERCHILD;
	}

	public String getUSERCHILD(){
		return uSERCHILD;
	}

	public void setERROR(String eRROR){
		this.eRROR = eRROR;
	}

	public String getERROR(){
		return eRROR;
	}

	public void setRESULT(String rESULT){
		this.rESULT = rESULT;
	}

	public String getRESULT(){
		return rESULT;
	}
}