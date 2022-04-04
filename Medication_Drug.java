public class Medication_Drug {
	public String patient_id = "";
	public String encounter_id = "";
	public String unique_id = "";
	public String code_system = "";
	public String code = "";
	public String start_date = "";
	public String route = "";
	public String brand = "";
	public String strength = "";
	public String quantity_dispensed = "";
	public String days_supply = "";
	public String derived_by_TriNetX = "";
	public String source_id = "";
	
	public Medication_Drug(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		patient_id = t[0];
		encounter_id = t[1];
		unique_id = t[2];
		code_system = t[3];
		code = t[4];
		start_date = t[5];
		route = t[6];
		brand = t[7];
		strength = t[8];
		quantity_dispensed = t[9];
		days_supply = t[10];
		derived_by_TriNetX = t[11];
		source_id = t[12];
	}
	
	public String toString() {
		return "^" + patient_id + "|" + encounter_id + "|"+ unique_id + "|" + code_system + "|"
					+ code + "|" + start_date + "|" + route + "|" + brand + "|" + strength + "|"
					+ quantity_dispensed + "|" + days_supply + "|" + derived_by_TriNetX + "|" + source_id + "^";
	}
}
