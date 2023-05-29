package STARData;
import java.util.ArrayList;

import org.apache.avro.generic.GenericRecord;


public class STARDataPatient {
	
	
	public String AGE_DATA;
	public String BMICALC_DATA;
	public String BMITCR_DATA;
//	public String COD_DATA;
//	public String CODOSTXT_DATA;
//	public String COD2_DATA;
//	public String COD2OSTXT_DATA;
//	public String COD3_DATA;
//	public String COD3OSTXT_DATA;
	public String DIAB_DATA;
	public ArrayList<String> DISCHARGEDATE_DATA = new ArrayList<String>();
//	public String EDUCATION_DATA;
//	public String ETHCAT_DATA;
//	public String ETHNICITY_DATA;
	public String FUNCSTATTCR_DATA;
	public String FUNCSTATTRF_DATA;
	public String FUNCSTATTRR_DATA;
//	public String GRFSTAT_DATA;
//	public String GSTATUS_DATA;
//	public String GTIME_DATA;
//	public String HCCDIAG_DATA;
//	public String HCCDIAGNOSISTCR_DATA;
//	public String HCCEVERAPPR_DATA;
	public String HCVNAT_DATA;
	public String HCVSEROSTATUS_DATA;
//	public String HIVSEROSTATUS_DATA;
//	public String INFECT_DATA;
	public String INITMELDORPELD_DATA;
	public String INITMELDPELDLABSCORE_DATA;
	public String MELDPELDLABSCORE_DATA;
	public String MALIG_DATA;
//	public String PERMSTATE_DATA;
//	public String PERMSTATETRR_DATA;
//	public String PRIPAYMENTTCR_DATA;
//	public String PRIPAYMENTTRR_DATA;
	public String PTCODE_DATA;
//	public String RETXDATE_DATA;
	public String TRRIDCODE_DATA;
//	public String TXDATE_DATA;
	
	public ArrayList<STARDataFollowUp> followUps = new ArrayList<STARDataFollowUp>();
	public boolean [] readmissions = new boolean[4];
	
	public STARDataPatient() {
		
	}
	
	public STARDataPatient(GenericRecord nextRecord) {
		for(int i = 0; i < readmissions.length; i++) {
			readmissions[i] = false;
		}
		AGE_DATA = nextRecord.get("AGE").toString();
		BMICALC_DATA = nextRecord.get("BMICALC").toString();
		BMITCR_DATA = nextRecord.get("BMITCR").toString();
//		COD_DATA = nextRecord.get("COD").toString();
//		CODOSTXT_DATA = nextRecord.get("CODOSTXT").toString();
//		COD2_DATA = nextRecord.get("COD2").toString();
//		COD2OSTXT_DATA = nextRecord.get("COD2OSTXT").toString();
//		COD3_DATA = nextRecord.get("COD3").toString();
//		COD3OSTXT_DATA = nextRecord.get("COD3OSTXT").toString();
		DIAB_DATA = nextRecord.get("DIAB").toString();
		DISCHARGEDATE_DATA.add(nextRecord.get("DISCHARGEDATE").toString());
		
//		EDUCATION_DATA = nextRecord.get("EDUCATION").toString();
//		ETHCAT_DATA = nextRecord.get("ETHCAT").toString();
//		ETHNICITY_DATA = nextRecord.get("ETHNICITY").toString();
		FUNCSTATTCR_DATA = nextRecord.get("FUNCSTATTCR").toString();
		FUNCSTATTRF_DATA = nextRecord.get("FUNCSTATTRF").toString();
		FUNCSTATTRR_DATA = nextRecord.get("FUNCSTATTRR").toString();
//		GRFSTAT_DATA = nextRecord.get("GRFSTAT").toString();
//		GSTATUS_DATA = nextRecord.get("GSTATUS").toString();
//		GTIME_DATA = nextRecord.get("GTIME").toString();
//		HCCDIAG_DATA = nextRecord.get("HCCDIAG").toString();
//		HCCDIAGNOSISTCR_DATA = nextRecord.get("HCCDIAGNOSISTCR").toString();
//		HCCEVERAPPR_DATA = nextRecord.get("HCCEVERAPPR").toString();
		HCVNAT_DATA = nextRecord.get("HCVNAT").toString();
		HCVSEROSTATUS_DATA = nextRecord.get("HCVSEROSTATUS").toString();
//		HIVSEROSTATUS_DATA = nextRecord.get("HIVSEROSTATUS").toString();
//		INFECT_DATA = nextRecord.get("INFECT").toString();
		INITMELDORPELD_DATA = nextRecord.get("INITMELDORPELD").toString();
		INITMELDPELDLABSCORE_DATA = nextRecord.get("INITMELDPELDLABSCORE").toString();
		MELDPELDLABSCORE_DATA = nextRecord.get("MELDPELDLABSCORE").toString();
		MALIG_DATA = nextRecord.get("MALIG").toString();
//		PERMSTATE_DATA = nextRecord.get("PERMSTATE").toString();
//		PERMSTATETRR_DATA = nextRecord.get("PERMSTATETRR").toString();
//		PRIPAYMENTTCR_DATA = nextRecord.get("PRIPAYMENTTCR").toString();
//		PRIPAYMENTTRR_DATA = nextRecord.get("PRIPAYMENTTRR").toString();
		PTCODE_DATA = nextRecord.get("PTCODE").toString();
//		RETXDATE_DATA = nextRecord.get("RETXDATE").toString();
		TRRIDCODE_DATA = nextRecord.get("TRRIDCODE").toString();
//		TXDATE_DATA = nextRecord.get("TXDATE").toString();

	}
	
	public void addFollowUp(GenericRecord nextRecord) {
		followUps.add(new STARDataFollowUp(nextRecord));
	}
	
}
