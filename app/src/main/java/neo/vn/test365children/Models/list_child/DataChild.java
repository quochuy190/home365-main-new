package neo.vn.test365children.Models.list_child;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataChild{

	@SerializedName("MESSAGE")
	private String mESSAGE;

	@SerializedName("ERROR")
	private String eRROR;

	@SerializedName("INFO")
	private List<INFOItem> iNFO;

	@SerializedName("RESULT")
	private String rESULT;

	public void setMESSAGE(String mESSAGE){
		this.mESSAGE = mESSAGE;
	}

	public String getMESSAGE(){
		return mESSAGE;
	}

	public void setERROR(String eRROR){
		this.eRROR = eRROR;
	}

	public String getERROR(){
		return eRROR;
	}

	public void setINFO(List<INFOItem> iNFO){
		this.iNFO = iNFO;
	}

	public List<INFOItem> getINFO(){
		return iNFO;
	}

	public void setRESULT(String rESULT){
		this.rESULT = rESULT;
	}

	public String getRESULT(){
		return rESULT;
	}
}