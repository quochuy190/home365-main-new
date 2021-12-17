package neo.vn.test365children.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HomeworkDone{

	@SerializedName("MESSAGE")
	private String mESSAGE;

	@SerializedName("DETAILS")
	private List<DETAILSItem> dETAILS;

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

	public void setDETAILS(List<DETAILSItem> dETAILS){
		this.dETAILS = dETAILS;
	}

	public List<DETAILSItem> getDETAILS(){
		return dETAILS;
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