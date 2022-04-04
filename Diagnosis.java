public class Diagnosis {
	public String patient_id = "";
	public String encounter_id = "";
	public String code_system = "";
	public String code = "";
	public String principal_diagnosis_indicator = "";
	public String admitting_diagnosis = "";
	public String reason_for_visit = "";
	public String date = "";
	public String derived_by_TriNetX = "";
	public String source_id = "";
	
	public Diagnosis(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		patient_id = t[0];
		encounter_id = t[1];
		code_system = t[2];
		code = t[3];
		principal_diagnosis_indicator = t[4];
		admitting_diagnosis = t[5];
		reason_for_visit = t[6];
		date = t[7];
		derived_by_TriNetX = t[8];
		source_id = t[9];
	}
	
	public String toString() {
		return "#" + patient_id + "|" + encounter_id + "|" + code_system + "|"
					+ code + "|" + principal_diagnosis_indicator + "|" + admitting_diagnosis + "|"
					+ reason_for_visit + "|" + date + "|" + derived_by_TriNetX + "|" + source_id + "#";
	}
}
