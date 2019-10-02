//Bryce Stoker 111999983 R02
public class HiringTable {
    static final int MAX_SKILLS = 3;
    static final int MAX_COMPANIES = 3;
    static final int MAX_APPLICANTS = 50;
    Applicant[] list = new Applicant[MAX_APPLICANTS];

    public HiringTalbe(){
        
    }

    public int size() {
        // @param returns size of table
        int count = 0;
        for (int i = 0; i < MAX_APPLICANTS; i++) {
            if (list[i] != null && !list[i].getAppName().equals(""))
                count++;
        }
        return count;
    }

    public void addApplicant(Applicant newApplicant) {
        // @param applicant is added to the table
        try {
            for (int i = 0; i < MAX_APPLICANTS; i++) {
                if (list[i] == null) {
                    list[i] = newApplicant;
                    break;
                }
            }
            System.out.println("Successfully added!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error! Too many applicants! Maximum is 50.");
        }

    }

    public void removeApplicant(String name) {
        // @param applicant is removed from the table.
        Applicant toRemove = refineSearch(name, this);
        Applicant[] tempList = new Applicant[50];
        for (int i = 0; i < MAX_APPLICANTS; i++) {
            if (toRemove.getAppName().equals(name)) {
                for (int k = i; k < MAX_APPLICANTS - 1; k++) {
                    tempList[k] = list[k + 1];
                }
                break;
            } else {
                tempList[i] = list[i];
            }
        }
        list = tempList;
    }

    public Applicant getApplicant(String name) {
        // @param return applicant of name.
        try {
            return refineSearch(name, this);
        } catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("Error: Applicant not found exception.");
            return null;
        }
    }

    public HiringTable clone() { // TODO: make sure this is an object not a hiringtable
        // @param clones the table
        HiringTable hiringtable = new HiringTable();
        for (int i = 0; i < MAX_APPLICANTS; i++)
            hiringtable.list[i] = list[i];
        return hiringtable;
    }

    public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA) {
        // @param returns specific search criteria
        System.out.println("Company Name    Applicant    GPA        College          Skills");
        Applicant[] tempList = new Applicant[MAX_APPLICANTS];
        String pCompany = "";
        String pSkill = "";
        String paCompany = "";
        String paSkill = ""; // p is this method, pa is applicant
        // parse arrays to strings
        // begin checks
        for (int j = 0; j < MAX_APPLICANTS; j++) {
            for (int k = 0; k < 1; k++) {
                if (table.list[j] != null)
                    pCompany += table.list[j].getCompanyName()[k];
                if (table.list[j] != null)
                    pSkill += table.list[j].getSkills()[k];
            }
        }
        for (int i = 0; i < MAX_APPLICANTS; i++) {

            if (table.list[i] != null && table.list[i].getGPA() == GPA) // check for GPA. Add to temp list if true
                tempList[i] = table.list[i];
            if (table.list[i] != null && table.list[i].getCollegeName().equals(college))
                tempList[i] = table.list[i];
            if (table.list[i] != null && table.list[i].getCompanyName().toString().contains(pCompany))
                tempList[i] = table.list[i];
            if (table.list[i] != null && table.list[i].getSkills().toString().contains(pSkill))
                tempList[i] = table.list[i];
        }
        for (int i = 0; i < MAX_APPLICANTS; i++) {
            if (table.list[i] != null)
                table.list[i].toString();
        }
    }

    public static Applicant refineSearch(String name, HiringTable table) {
        // @param returns Applicant of name.
        for (int i = 0; i < MAX_APPLICANTS; i++) {
            if (table.list[i] != null && table.list[i].getAppName().equals(name))
                return table.list[i];
        }
        System.out.println("No results found.");
        return null;
    }

    public void printApplicantTable() {
        // @param Prints all applicants in table
        System.out.println("Company Name    Applicant    GPA        College          Skills");

        for (int i = 0; i < MAX_APPLICANTS; i++) {
            if (list[i] != null) {
                System.out.println(list[i].toString());
            }
        }
    }
}