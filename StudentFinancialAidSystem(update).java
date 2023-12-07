import java.util.*;

public class StudentFinancialAidSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> studentNumber = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> majors = new ArrayList<>();
        ArrayList<Double> gwa = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> address = new ArrayList<>();

        Map<String, List<String>> scholarships = new HashMap<>();
        Map<String, String> selectedScholarshipMap = new HashMap<>();
        Map<Integer, String> otherscholarships = new HashMap<>();

        while (true) {
            System.out.println("\nPRESS FROM THE FOLLOWING OPTION:");
            System.out.println("\nPRESS 1: TO ADD STUDENT INFORMATION.");
            System.out.println("PRESS 2: TO DELETE STUDENT INFORMATION.");
            System.out.println("PRESS 3: TO UPDATE STUDENT INFORMATION.");
            System.out.println("PRESS 4: TO APPLY FOR SCHOLARSHIP. ");
            System.out.println("PRESS 5: TO DISPLAY STUDENT INFORMATION.");
            System.out.println("PRESS 6: TO EXIT SYSTEM.");
            System.out.print("\nENTER YOUR OPTION: ");
            String option = input.nextLine();
            
            if (!option.matches("[1-6]")) {
                System.out.println("\n\n");
                System.out.println("Invalid option!! Please enter a number between 1 and 6.");
                continue;
            } else {
                if (option.equals("1")) {
                    System.out.println("");
                    System.out.print("\033[H\033[2J");
                    System.out.println("ENTER STUDENT NAME: ");
                    String studentName = input.nextLine().toUpperCase();
                    name.add(studentName);

                    System.out.println("ENTER STUDENT NUMBER: ");
                    String studentCode = input.nextLine().toUpperCase();
                    studentNumber.add(studentCode);

                    int studentAge = 0;
                    boolean validAge = false;

                    while(!validAge) {
                        System.out.println("ENTER STUDENT AGE: ");
                    if (input.hasNextInt()) {
                        studentAge = input.nextInt();
                        if (studentAge >= 18 && studentAge <= 25) {
                            validAge = true;
                            age.add(studentAge);
                        } else { 
                            System.out.println("INVALID AGE!! PLEASE ENTER A VALID AGE BETWEEN 18 AND 25");
                        }
                    } else {
                        System.out.println("INVALID INPUT!! PLEASE ENTER A VALID AGE BETWEEN 18 AND 25.");
                        input.next();
                        
                    }
                }
                input.nextLine();
                
                    System.out.println("ENTER STUDENT MAJOR: ");
                    String studentMajor = input.nextLine().toUpperCase().trim(); // remove leading and trailing space
                    majors.add(studentMajor);

                    double studentGwa = 0;
                    boolean validGwa = false;

                    while(!validGwa) {
                        System.out.println("ENTER STUDENT GWA: ");
                    if (input.hasNextDouble()) {
                        studentGwa = input.nextDouble();
                        if (studentGwa >= 0 && studentGwa <= 100) {
                            validGwa = true;
                            gwa.add(studentGwa);
                        } else { 
                            System.out.println("INVALID GWA!! PLEASE ENTER A VALID GWA BETWEEN 0 AND 100");
                        }
                    } else {
                        System.out.println("INVALID INPUT!! PLEASE ENTER A VALID GWA.");
                        input.next();
                    }
                }
                input.nextLine();

                    System.out.println("ENTER STUDENT EMAIL ID: ");
                    String studentEmail = input.nextLine();
                    email.add(studentEmail);

                    System.out.println("ENTER STUDENT ADDRESS: ");
                    String studentAddress = input.nextLine().toUpperCase();
                    address.add(studentAddress);

                    System.out.println("\n\n\nSUCCESS! STUDENT INFORMATION ADDED");
                
                } else if (option.equals("2")) {
                    System.out.println("ENTER STUDENT NUMBER(TO DELETE): ");
                    String studentCode = input.nextLine().toUpperCase();
                    int i = studentNumber.indexOf(studentCode);
                    
                    if (i == -1) {
                        System.out.println("STUDENT NOT FOUND! CANNOT DELETE INFORMATION");
                    } else { 
                        System.out.println("ARE YOU SURE?");
                        System.out.println("PRESS 'Y' TO DELETE, PRESS 'N' TO CANCEL");
                        String confirmation = input.nextLine().toUpperCase();

                        if (confirmation.equals("Y")) {
                        name.remove(i);
                        studentNumber.remove(i);
                        age.remove(i);
                        majors.remove(i);
                        gwa.remove(i);
                        email.remove(i);
                        address.remove(i);
                        System.out.println("SUCCESS!! STUDENT INFORMATION DELETED");
                    } else if (confirmation.equals("N")){
                        System.out.println("DELETION CANCELED!");
                    } else {
                        System.out.println("INVALID INPUT! DELETION CANCELED!");
                    }
                }
            } else if (option.equals("3")){
                System.out.println("ENTER STUDENT NUMBER(TO UPDATE): ");
                String studentCode = input.nextLine().toUpperCase();
                int i = studentNumber.indexOf(studentCode);  
                if (i == -1) {
                    System.out.println("STUDENT NOT FOUND! CANNOT UPDATE INFORMATION");
                } else {
                    System.out.println("");
                    System.out.println("ENTER UPDATED STUDENT NAME: ");
                    String newName = input.nextLine().toUpperCase();
                    name.set(i, newName);

                    System.out.println("ENTER UPDATED STUDENT NUMBER: ");
                    String newCode = input.nextLine().toUpperCase();
                    studentNumber.set(i, newCode);

                    int newAge = 0;
                    boolean validNewAge = false;
                    while (!validNewAge) {
                        System.out.println("ENTER UPDATED STUDENT AGE: ");
                        if (input.hasNextInt()) {
                            newAge = input.nextInt();
                            if (newAge >= 18 && newAge <= 25) {
                                validNewAge = true;
                                age.set(i, newAge);
                            } else {
                                System.out.println("INVALID AGE!! PLEASE ENTER A VALID AGE BETWEEN 18 AND 25");
                            }
                        } else {
                            System.out.println("INVALID INPUT!! PLEASE ENTER A VALID AGE.");
                            input.next(); 
                        }
                    }
                    input.nextLine();

                    System.out.println("ENTER UPDATED STUDENT MAJOR: ");
                    String newMajor = input.nextLine().toUpperCase();
                    majors.set(i, newMajor);

                    double newGwa = 0;
                    boolean validNewGwa = false;

                    while(!validNewGwa) {
                        System.out.println("ENTER UPDATED STUDENT GWA: ");
                    if (input.hasNextDouble()) {
                        newGwa = input.nextDouble();
                        if (newGwa >= 0 && newGwa <= 100) {
                            validNewGwa = true;
                            gwa.add(newGwa);
                        } else { 
                            System.out.println("INVALID GWA!! PLEASE ENTER A VALID GWA BETWEEN 0 AND 100");
                        }
                    } else {
                        System.out.println("INVALID INPUT!! PLEASE ENTER A VALID GWA.");
                        input.next();
                    }
                }
                input.nextLine();
                    System.out.println("ENTER UPDATED STUDENT EMAIL ID: ");
                    String newEmail = input.nextLine().toUpperCase();
                    email.set(i, newEmail);

                    System.out.println("ENTER UPDATED STUDENT ADDRESS: ");
                    String newAddress = input.nextLine();
                    address.set(i, newAddress);

                    System.out.println("\nSUCCESS!! STUDENT INFORMATION UPDATED");
                }
            } else if (option.equals("4")) {
                System.out.println("ENTER STUDENT NUMBER(TO APPLY): ");
                String studentCode = input.nextLine().toUpperCase();
                int i = studentNumber.indexOf(studentCode);

                if (i == -1) {
                    System.out.println("STUDENT NOT FOUND!");
                } else {
                    System.out.println("\nNAME: " + name.get(i));
                    double studentGwa = gwa.get(i);
                    System.out.println("GWA: " + gwa.get(i));

                    String studentMajor = majors.get(i).toUpperCase();
                    System.out.println("MAJOR: " + majors.get(i));
                    String formatMajor = studentMajor.replaceAll("\\s|-", "").toUpperCase();
                
                    scholarships.put("BSECE", Collections.singletonList("SCHOLARSHIP: CSS-A Fastech Synergy Philippines \n>> 100% discount on tuition fees"));
                    scholarships.put("BSENTREP", Collections.singletonList("SCHOLARSHIP: CSS-B AFREIGHT Philippines Inc. \n>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees"));
                    scholarships.put("BEED", Arrays.asList(
                    "SCHOLARSHIP: CSS-B Diwa Learning Systems Inc. \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees",
                    "SCHOLARSHIP: CSS-C Spouses Saturnino and Segundina Belen \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees",
                    "SCHOLARSHIP: CSS-C Spouses Lope and Flaviana Leonio \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees",
                    "SCHOLARSHIP: Amada Gomez \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees",
                    "SCHOLARSHIP: Francisco Esteban \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees"
                    ));
                    scholarships.put("BSEENG", scholarships.get("BEED"));
                    scholarships.put("BSESPE", Arrays.asList(
                        "SCHOLARSHIP: CSS-C Spouses Lope and Flaviana Leonio \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees",
                        "SCHOLARSHIP: Amada Gomez \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees",
                        "SCHOLARSHIP: Francisco Esteban \n\t>> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees"
                        ));

                        scholarships.put("BSIT", Collections.singletonList("SCHOLARSHIP: CSS - D FAITH Colleges\n\t>> 100% discount on tuition fees"));
                        scholarships.put("BSCS", scholarships.get("BSIT"));
                        scholarships.put("BSEMC", scholarships.get("BSIT"));
                        scholarships.put("BSEE", scholarships.get("BSIT"));
                        scholarships.put("BSIE", scholarships.get("BSIT"));
                        scholarships.put("BSCPE", scholarships.get("BSIT"));
                        scholarships.put("BSMT", scholarships.get("BSIT"));
                        
                    if (studentGwa <= 84) {
                        System.out.println("\nYOUR GRADES DON'T MEET THE REQUIREMENTS. YOU CANNOT APPLY FOR SCHOLARSHIP.");
                    } else if (studentGwa >= 85) {
                        if (scholarships.containsKey(formatMajor)) {
                            System.out.println("CONGRATULATIONS! YOU ARE ELIGIBLE TO ENROLL");
                            List<String> availableScholarships = scholarships.get(formatMajor);
                                    
                            // Display available scholarships
                            for (int j = 0; j < availableScholarships.size(); j++) {
                                System.out.println((j + 1) + ". " + availableScholarships.get(j));
                            }
                            // Choose scholarship
                            System.out.println("Choose a scholarship (1-" + availableScholarships.size() + "): ");
                            int choice = 0; 
                            boolean validChoice = false;
                            
                            // Validate user choice and proceed accordingly
                            while (!validChoice) {
                                if (input.hasNextInt()){
                                    choice = input.nextInt();
                                if (choice >= 1 && choice <= availableScholarships.size()) {
                                    validChoice = true;
                                    String selectedScholarship = availableScholarships.get(choice - 1);
                                    System.out.println("You chose: " + availableScholarships.get(choice - 1));
                                    selectedScholarshipMap.put(studentCode, selectedScholarship);
                            } else {
                                System.out.println("INVALID CHOICE! PLEASE SELECT A VALID CHOICE.");
                            }
                        } else {
                            System.out.println("INVALID INPUT! ENTER A NUMBER BETWEEN 1 AND " + availableScholarships.size() + ": ");
                            input.next();
                        }
                    }
                    input.nextLine();
                    
                    //Generic Scholar
                    System.out.println("\nDO YOU WANT TO APPLY FOR GENERIC SCHOLARSHIP?");
                    System.out.println("PRESS 'Y' TO YES, PRESS 'N' TO NO");
                    String applyGeneric = input.nextLine().toUpperCase();
                    
                    if (applyGeneric.equals("Y")) {
                        // Other scholarship progs
                        System.out.println("");
                        otherscholarships.put(1, "Student Assistantship Program (SAP) \n>> 100% discount on tuition fees");
                        otherscholarships.put(2, "Batangas Province Scholarship Program (BAPROSA) \n>> 5,000 to 10,000 financial assistance");
                        otherscholarships.put(3, "CHED Tulong Dunong Program (TDP) \n>> 7,500 per semester");
                        otherscholarships.put(4, "Lipa City Scholarship Program (EBA) \n>> 100% discount on tuition fees*");
                        otherscholarships.put(5, "CHED Scholarship Program (CSP) \n>> Full Merit = 30,000 per semester  \n>> Half Merit = 15,000 per semester");
                        otherscholarships.put(6, "Sto. Tomas Scholarship Program (EPS) \n>> 100% discount on tuition fees, registration, and miscellaneous fees*");
                        otherscholarships.put(7, "Dr. Eustacio and Trinidad Leviste-Endaya Scholarship Program (Malvar) \n>> 100% discount on tuition fees, registration, and miscellaneous fees*");
                        
                        for (Map.Entry<Integer, String> entry : otherscholarships.entrySet()) {
                            System.out.println(entry.getKey() + ". " + entry.getValue());
                        }
                        // Ask the user to input the other scholarship number to apply
                        System.out.println("\nCHOOSE A SCHOLARSHIP NUMBER (1-7): ");
                        int otherscholarshipChoice = input.nextInt();
                        input.nextLine();
                        
                        if (otherscholarships.containsKey(otherscholarshipChoice)) {
                            String selectedOtherscholarship = otherscholarships.get(otherscholarshipChoice);
                            System.out.println("YOU CHOSE:: " + selectedOtherscholarship);
                            selectedScholarshipMap.put(studentCode, selectedOtherscholarship);
                        } else {
                            System.out.println("INVALID CHOICE! PLEASE SELECT A VALID CHOICE.");
                        }
                    }
                } 
            } else {
                System.out.println("\nSTUDENT MAJOR DOES NOT MATCH ANY ELIGIBLE SCHOLARSHIPS");
            }
        }
            } else if (option.equals("5")) {
                System.out.println("ENTER STUDENT NUMBER(TO DISPLAY): ");
                String studentCode = input.nextLine().toUpperCase();
                int i = studentNumber.indexOf(studentCode);
                if (i == -1) {
                    System.out.println("STUDENT NOT FOUND! CANNOT DISPLAY INFORMATION");
                } else {
                    System.out.println("\nNAME: " + name.get(i));
                    System.out.println("STUDENT NUMBER: " + studentNumber.get(i));
                    System.out.println("AGE: " + age.get(i));
                    System.out.println("MAJOR: " + majors.get(i));
                    System.out.println("GWA: " + gwa.get(i));
                    System.out.println("EMAIL: " + email.get(i));
                    System.out.println("ADDRESS: " + address.get(i));
                    String selectedScholarship = selectedScholarshipMap.get(studentCode); // Fetch the selected scholarship for the student
                    if (selectedScholarship != null) {
                        System.out.print(selectedScholarship);
                    } else {
                        System.out.println("No scholarship selected.");
                    }
                    System.out.println("\n\nSTUDENT INFORMATION PRINTED");
                }
            } if (option.equals("6")){
                    System.out.println("THANK YOU. HAVE A GREAT DAY!");
                    break;
                } 
            }
        }
    input.close();    
    } 
}
