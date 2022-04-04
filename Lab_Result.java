public class Lab_Result {
	public String patient_id = "";
	public String encounter_id = "";
	public String code_system = "";
	public String code = "";
	public String date = "";
	public String lab_result_num_val = "";
	public String lab_result_text_val = "";
	public String derived_by_TriNetX = "";
	public String source_id = "";
	
	public Lab_Result(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		patient_id = t[0];
		encounter_id = t[1];
		code_system = t[2];
		code = t[3];
		date = t[4];
		lab_result_num_val = t[5];
		lab_result_text_val = t[6];
		derived_by_TriNetX = t[7];
		source_id = t[8];
	}
	
	public String toString() {
		return "%" + patient_id + "|" + encounter_id + "|" + code_system + "|" + code + "|" + date + "|" + lab_result_num_val + "|" + lab_result_text_val + "|" + derived_by_TriNetX + "|" + source_id + "%";
	}
	
}
