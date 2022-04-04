import java.util.ArrayList;
import java.util.Arrays;

public class Patient {
	public String patient_id = "";
	public String sex = "";
	public String race = "";
	public String ethnicity = "";
	public String marital_status = "";
	public String year_of_birth = "";
	public String reason_yob_missing = "";
	public String month_year_death = "";
	public String postal_code = "";
	public String patient_regional_location = "";
	public String source_id = "";
	
	public ArrayList<Encounter> encounters = new ArrayList<Encounter>();
	public ArrayList<Genomic> genomics = new ArrayList<Genomic>();
	
	public Patient(String p) {
		String temp = p.substring(1, p.length()-1);
		String [] t = temp.split("\",\"");
		patient_id = t[0];
		sex = t[1];
		race = t[2];
		ethnicity = t[3];
		marital_status = t[4];
		year_of_birth = t[5];
		reason_yob_missing = t[6];
		month_year_death = t[7];
		postal_code = t[8];
		patient_regional_location = t[9];
		source_id = t[10];
	}
	
	public String toString() {
		return "!" + patient_id + "|"
					+ sex + "|"
					+ race + "|"
					+ ethnicity + "|"
					+ marital_status + "|"
					+ year_of_birth + "|"
					+ reason_yob_missing + "|"
					+ month_year_death + "|"
					+ postal_code + "|"
					+ patient_regional_location + "|"
					+ source_id + "!"
					+ encounters + genomics;
	}
	
}
