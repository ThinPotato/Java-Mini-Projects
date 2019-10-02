
//Bryce Stoker 111999983 R02
import java.util.Scanner;

public class HiringSystem {
    static HiringTable table = new HiringTable();
    static HiringTable backup = new HiringTable();
    static HiringTable superBackup = new HiringTable();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            printCmd();

            System.out.println("\nPlease enter a command.");
            input = scan.nextLine();

            if (input.equals("A")) {
                addApp();
                printCmd();
            } else if (input.equalsIgnoreCase("R")) {
                remApp();
            } else if (input.equalsIgnoreCase("G")) {
                getApp();
            } else if (input.equalsIgnoreCase("P")) {
                printList();
            } else if (input.equalsIgnoreCase("RS")) {
                search();
            } else if (input.equalsIgnoreCase("S")) {
                System.out.println("There are " + table.size() + " Applicants in the system.");
            } else if (input.equalsIgnoreCase("D")) {
                backup = table.clone();
                superBackup = backup.clone();
                System.out.println("The System was backed up successfully.");
            } else if (input.equalsIgnoreCase("CB")) {
                CompareBackup();
            } else if (input.equalsIgnoreCase("RB")) {
                table = superBackup;
            }
        } while (!input.equalsIgnoreCase("Q"));
    }

    public static void CompareBackup() {
        for (int i = 0; i < HiringTable.MAX_APPLICANTS; i++) {
            if (backup.list[i] != null && table.list[i] != null && !backup.list[i].equals(table.list[i])) {
                System.out.println("The Current list is not the same as the backup.");
                break;
            }
        }
        System.out.println("The Current list is the same as the backup.");
    }

    public static void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a company to filter for: ");
        String company = scan.nextLine();
        System.out.println("Enter a skill to filter for: ");
        String skill = scan.nextLine();
        System.out.println("Enter a college to filter for: ");
        String college = scan.nextLine();
        System.out.println("Enter a GPA to filter for ");
        Double GPA;
        try {
            GPA = Double.parseDouble(scan.nextLine());
        } catch (NumberFormatException e) {
            GPA = -1.0;
        }

        HiringTable.refineSearch(table, company, skill, college, GPA);
    }

    public static void printList() {
        // @param used to print the first row of the table
        table.printApplicantTable();
    }

    public static void getApp() {
        // @param gets the applicant then prints
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Applicant name:");

        String input = scan.nextLine();
        Applicant toPrint = HiringTable.refineSearch(input, table);
        System.out.println("Company Name    Applicant    GPA        College          Skills");
        System.out.println(toPrint.toString());

    }

    public static void remApp() {
        // @param removes applicant then prints
        Scanner scan = new Scanner(System.in);
        System.out.println("Who to remove?");
        String name = scan.nextLine();
        table.removeApplicant(name);

    }

    public static void addApp() {
        // @param add applicant then print
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Applicant name:");
        String appName = scan.nextLine();
        System.out.println("Enter Applicant college");
        String appCollege = scan.nextLine();
        System.out.println("Enter up to 3 companies seperated by , :");
        String appCompanies = scan.nextLine();
        System.out.println("Enter up to 3 skills seperated by, :");
        String appSkills = scan.nextLine();
        System.out.println("Enter Applicant GPA:");
        Double appGPA = scan.nextDouble();

        Applicant newApp = new Applicant(appCompanies.split(","), appName, appGPA, appCollege, appSkills.split(","));
        System.out.println("Applicant " + appName + " has been added to the system.");

        table.addApplicant(newApp);
    }

    public static void printCmd() {
        // Aparam main menu print command
        System.out.printf(
                "(A)   Add Applicant \n(R)   Remove Applicant \n(G)   Get Applicant \n(P)   Print List \n(RS)  Refine Search \n(S)   Size \n(D)   Backup \n(CB)  Compare Backup \n(RB)  Revert Backup \n(Q)   Quit");

    }
}

class Applicant {
    private String[] companyName = new String[3];
    private String appName;
    private double GPA;
    private String collegeName;
    private String[] skills = new String[3];

    public Applicant() {

    }

    public Applicant(String[] companyName, String appName, double GPA, String collegeName, String[] skills) {
        // @param Constructor of applicant. all values are passed to variables.
        this.companyName = companyName;
        this.appName = appName;
        this.GPA = GPA;
        this.collegeName = collegeName;
        this.skills = skills;
    }

    public boolean equals(HiringTable object) {
        // @param check if everything is the same as object. return true if it is
        Applicant app = object;
        if (this.companyName == app.companyName && this.appName == app.appName && this.GPA == app.GPA
                && this.collegeName == app.collegeName && this.skills == app.skills)
            return true;
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        // @param copy the class and return a new one that is a clone.
        Applicant temp = (Applicant) super.clone();
        return temp;
    }

    public String toString() {
        // @param turn all of class data to a String output
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < companyName.length; i++) {
            temp1 += " " + companyName[i];
        }
        for (int i = 0; i < skills.length; i++) {
            temp2 += " " + skills[i];
        }
        String temp = String.format("%-16s%-13s%-10s%-17s%-18s", appName, GPA, collegeName, temp1, temp2);
        return temp;
    }

    void setCompanyName(String[] CompanyName) {
        this.companyName = CompanyName;
    }

    String[] getCompanyName() {
        return this.companyName;
    }

    void setAppName(String appName) {
        this.appName = appName;
    }

    String getAppName() {
        return this.appName;
    }

    void setGPA(double GPA) {
        this.GPA = GPA;
    }

    double getGPA() {
        return this.GPA;
    }

    void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    String getCollegeName() {
        return this.collegeName;
    }

    void setSkills(String[] skills) {
        this.skills = skills;
    }

    String[] getSkills() {
        return this.skills;
    }

}