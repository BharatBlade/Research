import java.util.ArrayList;

public class Encounter {
	public String encounter_id = "";
	public String patient_id = "";
	public String start_date = "";
	public String end_date = "";
	public String type = "";
	public String start_date_derived_by_TriNetX = "";
	public String end_date_derived_by_TriNetX = "";
	public String derived_by_TriNetX = "";
	public String source_id = "";
	
	public ArrayList<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
	public ArrayList<Lab_Result> labs = new ArrayList<Lab_Result>();
	public ArrayList<Medication_Drug> drugs = new ArrayList<Medication_Drug>();
	public ArrayList<Medication_Ingredient> ingredients = new ArrayList<Medication_Ingredient>();
	public ArrayList<Procedure> procedures = new ArrayList<Procedure>();
	public ArrayList<Vitals_Signs> signs = new ArrayList<Vitals_Signs>();
	
	public Encounter(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		encounter_id = t[0];
		patient_id = t[1];
		start_date = t[2];
		end_date = t[3];
		type = t[4];
		start_date_derived_by_TriNetX = t[5];
		end_date_derived_by_TriNetX = t[6];
		derived_by_TriNetX = t[7];
		source_id = t[8];
	}
	
	public String toString() {
		return "@" + encounter_id + "|" + patient_id + "|" + start_date + "|" + end_date + "|" + type + "|"
					+ start_date_derived_by_TriNetX + "|" + end_date_derived_by_TriNetX + "|" + derived_by_TriNetX + "|" + source_id + "@"
					+ diagnoses + labs + drugs + ingredients + procedures + signs;
	}
}
