import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Jobs {
    private UI ui = new UI();
    private User user;
    private Random rand = new Random();
    private Scanner scn = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.00"); 

    //Positions, base salaries and companies
    Map<String, String[][]> degreeToJobs = new HashMap<>();
    Map<String, String[]> degreeToCompanies = new HashMap<>();

    static String[][] engineering = {
        {"Engineering Intern", "45000"},
        {"Junior Engineer", "65000"},
        {"Design Engineer", "75000"},
        {"Project Engineer", "85000"},
        {"Systems Engineer", "95000"},
        {"Senior Engineer", "110000"},
        {"Lead Engineer", "125000"},
        {"Principal Engineer", "145000"},
        {"Engineering Manager", "160000"},
        {"Director of Engineering", "190000"}
    };

    static String[][] hospitality = {
        {"Host", "32000"},
        {"Server", "35000"},
        {"Bartender", "38000"},
        {"Shift Supervisor", "42000"},
        {"Assistant Manager", "48000"},
        {"Restaurant Manager", "60000"},
        {"Operations Manager", "75000"},
        {"General Manager", "90000"},
        {"Regional Manager", "115000"},
        {"Director of Hospitality", "140000"}
    };

    static String[][] healthcare = {
        {"Medical Assistant", "40000"},
        {"Licensed Practical Nurse", "55000"},
        {"Registered Nurse", "75000"},
        {"Charge Nurse", "85000"},
        {"Nurse Practitioner", "110000"},
        {"Physician Assistant", "120000"},
        {"General Physician", "180000"},
        {"Specialist Physician", "250000"},
        {"Medical Director", "300000"},
        {"Chief Medical Officer", "350000"}
    };

    static String[][] finance = {
        {"Finance Intern", "45000"},
        {"Accounting Clerk", "55000"},
        {"Junior Financial Analyst", "65000"},
        {"Financial Analyst", "80000"},
        {"Senior Financial Analyst", "95000"},
        {"Finance Manager", "115000"},
        {"Controller", "140000"},
        {"Director of Finance", "165000"},
        {"Vice President of Finance", "190000"},
        {"Chief Financial Officer", "230000"}
    };

    static String[][] it = {
        {"IT Support Technician", "50000"},
        {"Help Desk Analyst", "55000"},
        {"Junior Systems Administrator", "65000"},
        {"Systems Administrator", "80000"},
        {"Network Engineer", "90000"},
        {"Senior Systems Engineer", "110000"},
        {"Solutions Architect", "130000"},
        {"IT Manager", "150000"},
        {"Director of IT", "175000"},
        {"Chief Information Officer", "210000"}
    };

    static String[][] service = {
        {"Customer Service Representative", "38000"},
        {"Senior Customer Service Representative", "42000"},
        {"Service Desk Specialist", "48000"},
        {"Team Lead", "55000"},
        {"Service Supervisor", "62000"},
        {"Service Manager", "75000"},
        {"Operations Manager", "90000"},
        {"Regional Service Manager", "110000"},
        {"Director of Services", "135000"},
        {"Vice President of Customer Experience", "165000"}
    };

    static String[][] trades = {
        {"Apprentice", "40000"},
        {"Journeyman", "55000"},
        {"Certified Tradesperson", "65000"},
        {"Senior Tradesperson", "75000"},
        {"Crew Lead", "85000"},
        {"Site Supervisor", "95000"},
        {"Project Supervisor", "110000"},
        {"Construction Manager", "130000"},
        {"Operations Manager", "150000"},
        {"Director of Trades Operations", "175000"}
    };

    static String[][] transportation = {
        {"Entry Driver", "42000"},
        {"Commercial Driver", "55000"},
        {"Senior Driver", "65000"},
        {"Fleet Coordinator", "75000"},
        {"Dispatch Supervisor", "85000"},
        {"Logistics Coordinator", "95000"},
        {"Transportation Manager", "115000"},
        {"Fleet Manager", "135000"},
        {"Regional Logistics Manager", "160000"},
        {"Director of Transportation", "185000"}
    };

    static String[][] administration = {
        {"Office Assistant", "38000"},
        {"Administrative Assistant", "45000"},
        {"Executive Assistant", "60000"},
        {"Office Coordinator", "65000"},
        {"Administrative Supervisor", "75000"},
        {"Office Manager", "90000"},
        {"Operations Administrator", "105000"},
        {"Administrative Manager", "125000"},
        {"Director of Administration", "150000"},
        {"Chief Administrative Officer", "180000"}
    };

    static String[] engineeringCompanies = {"Siemens", "Bombardier", "Magna", "Tesla", "Magellon", "Celestica", "Rockwell", "Collins"};
    static String[] hospitalityCompanies = {"Air Canada", "West Hospitality", "Marriot", "Hilton", "Wyndham", "Fairmont", "Ritz-Carlton", "Sheraton"};
    static String[] healthcareCompanies = {"UHN", "SickKids", "Toronto General", "Humber River", "Sunnybrook", "Mount Sinai", "Toronto Western", "North York"};
    static String[] tradesCompanies = {"EllisDon", "PLC", "Aecon", "Ledcor", "Ainsworth", "Modern Niagara", "Graham Construction", "Black & McDonald"};
    static String[] transportationCompanies = {"TTC", "GO Transit", "Purolator", "Viva", "MiWay", "Zum", "UP Express", "Coach Canada"};
    static String[] administrationCompanies = {"Service Canada", "Service Ontario", "CRA", "IRCC", "PSPC", "CMHC", "Canada Post", "Brookfield"};
    static String[] serviceCompanies = {"Loblaws", "Metro", "Canadian Tire", "No Frills", "Sobeys", "Best Buy", "Food Basics", "Shoppers"};
    static String[] itCompanies = {"Shopify", "BlackBerry", "Kinaxis", "CGI", "Rogers", "Bell", "Telus", "1Password"};
    static String[] financeCompanies = {"TD", "CIBC", "RBC", "Scotiabank", "BMO", "HSBC", "Tangerine", "Simplii"};

    public Jobs(User user){
        this.user = user;
        degreeToJobs.put("engineering", engineering);
        degreeToJobs.put("hospitality", hospitality);
        degreeToJobs.put("healthcare", healthcare);
        degreeToJobs.put("trades", trades);
        degreeToJobs.put("transportation", transportation);
        degreeToJobs.put("administration", administration);
        degreeToJobs.put("it", it);
        degreeToJobs.put("finance", finance);
        degreeToJobs.put("service", service);

        degreeToCompanies.put("engineering", engineeringCompanies);
        degreeToCompanies.put("healthcare", healthcareCompanies);
        degreeToCompanies.put("hospitality", hospitalityCompanies);
        degreeToCompanies.put("service", serviceCompanies);
        degreeToCompanies.put("trades", tradesCompanies);
        degreeToCompanies.put("administration", administrationCompanies);
        degreeToCompanies.put("finance", financeCompanies);
        degreeToCompanies.put("transportation", transportationCompanies);
        degreeToCompanies.put("it", itCompanies);
    }

    //Calculate Salary
    private double calcSalary(int originalSalary){
        ArrayList<Double> wages = new ArrayList<>();
        
        //Create 3 salaries 
        for(int j = 0; j < 3; j++){
            double baseSalary = originalSalary;

            int expFactor = user.yearsWorked;
            boolean degFactor = user.hasDegree;
            boolean empFactor = user.employed;

            for(int i = 0; i < 3; i++){
                if(skillBonus()) baseSalary += 1000;
            }

            if(empFactor || degFactor){
                baseSalary += degBonus(degFactor);
                baseSalary += empBonus(empFactor);
            }

            if(expFactor > 5){
                double growthRate = (expFactor*expRate(true));
                double deposit = baseSalary*growthRate;
                baseSalary += deposit;
            }
            else{
                double declineRate = (adjustmentFactor(expFactor)*expRate(false));
                double deduction = baseSalary*declineRate;
                baseSalary -= deduction;
            }
            wages.add(baseSalary); 
        }
        double[] salaries = wages.stream().mapToDouble(Double::doubleValue).toArray();;
        insertionSort(salaries);
        return linearSearch(salaries);
    }

    //Helper calculations
    private boolean skillBonus(){
        boolean bonus = rand.nextBoolean();;
        return bonus;
    }

    private int empBonus(boolean currentlyEmployed){
        int bonus = 0;
        if(currentlyEmployed) bonus = rand.nextInt(500, 1500);
        return bonus;
    }

    private int degBonus(boolean degree){
        int bonus = 0;
        if(degree) bonus = rand.nextInt(3000, 15000);
        return bonus;
    }

    private double expRate(boolean add){
        double rate = 0;
        if(add){
            rate = rand.nextDouble(0.08, 0.15);
        }
        else{
            rate = rand.nextDouble(0.01, 0.02);
        }
        return rate;
    }

    private double adjustmentFactor(int exp){
        return Math.pow((10*(0.5)), exp);
    }

    private void insertionSort(double[] salaries){
        int totalSalaries = salaries.length;
      
        for (int i = 1; i < totalSalaries; i++) {
            double key = salaries[i]; 
            int j = i - 1;

            while (j >= 0 && salaries[j] > key) {
                salaries[j + 1] = salaries[j];
                j = j - 1;
            }
            salaries[j + 1] = key; 
        }
    }

    private double linearSearch(double[] salaries){
        double minValue = salaries[0];
    
        for(double i : salaries){
            if(minValue > i) minValue = i;
        }
        return minValue;
    }

    public void loadJobs(){
        ui.divider();
        ui.job();
        
        ArrayList<String> jobListings = new ArrayList<>();
        
        System.out.println("0. Return to Dashboard");
        for(int i=0; i < 3; i++){
            jobListings.add(createJob(i + 1));
        }
        
        System.out.print("Next action: ");
        int action = Integer.parseInt(scn.nextLine());

        if (action == 0) return;

        if (action >= 1 && action <= 3) {
            String pickedJob = jobListings.get(action - 1);
            user.useAttempt();
            user.employed = true; 
            user.currentJob = pickedJob; 
            user.addNotifs("Hired! You are now working as: " + pickedJob);
            System.out.println("Application Successful! New(1) Notification!");
        }
    }

    public String createJob(int index){
        String[][] selectedJobs;
        String[] selectedCompanies;

        if(!user.hasDegree){
            selectedJobs = service;
            selectedCompanies = serviceCompanies;
        } else {
            selectedJobs = degreeToJobs.getOrDefault(user.degreeType, service);
            selectedCompanies = degreeToCompanies.getOrDefault(user.degreeType, serviceCompanies);
        }

        int seniority = findPosition(user.yearsWorked);
        String position = selectedJobs[seniority][0];
        String company = selectedCompanies[rand.nextInt(selectedCompanies.length)];
        double salary = calcSalary(Integer.parseInt(selectedJobs[seniority][1]));

        String fullTitle = company + " " + position;
        System.out.println(index + ". Position: " + fullTitle + " - $" + df.format(salary));
        return fullTitle;
    }

    public int findPosition(int yearsWorked){
        int pos = 0;
        if(yearsWorked > 5){
            pos = rand.nextInt(4,10);
        }
        else{
            pos = rand.nextInt(0,3);
        }
        return pos;
    }
}