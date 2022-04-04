public class Genomic {
	public String patient_id = "";
	public String code_system = "";
	public String code = "";
	public String test_date = "";
	public String derived_by_TriNetX = "";
	public String source_id = "";
	
	public Genomic(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		patient_id = t[0];
		code_system = t[1];
		code = t[2];
		test_date = t[3];
		derived_by_TriNetX = t[4];
		source_id = t[5];
	}
	
	public String toString() {
		return "$" + patient_id + "|" + code_system + "|" + code + "|" + test_date + "|" + derived_by_TriNetX + "|" + source_id + "$";
	}
	
}
