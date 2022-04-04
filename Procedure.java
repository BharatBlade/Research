public class Procedure {
	public String patient_id = "";
	public String encounter_id = "";
	public String code_system = "";
	public String code = "";
	public String principal_procedure_indicator = "";
	public String date = "";
	public String derived_by_TriNetX = "";
	public String source_id = "";
	
	public Procedure(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		patient_id = t[0];
		encounter_id = t[1];
		code_system = t[2];
		code = t[3];
		principal_procedure_indicator = t[4];
		date = t[5];
		derived_by_TriNetX = t[6];
		source_id = t[7];
	}
	
	public String toString() {
		return "*" + patient_id + "|" + encounter_id + "|" + code_system + "|" + code + "|" + principal_procedure_indicator + "|" + date + "|" + derived_by_TriNetX + "|" + source_id + "*";
	}
}
