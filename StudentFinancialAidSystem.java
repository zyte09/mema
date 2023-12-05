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

        while (true) {
            System.out.println("\nPRESS FROM THE FOLLOWING OPTION : ");
            System.out.println("\nPRESS 1: TO ADD STUDENT INFORMATION. ");
            System.out.println("PRESS 2: TO DELETE STUDENT INFORMATION. ");
            System.out.println("PRESS 3: TO UPDATE STUDENT INFORMATION. ");
            System.out.println("PRESS 4: TO DISPLAY STUDENT INFORMATION. ");
            System.out.println("PRESS 5: TO APPLY FOR SCHOLARSHIP. ");
            System.out.println("PRESS 6: TO EXIT SYSTEM. ");
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

                    System.out.println("ENTER STUDENT AGE: ");
                    Integer studentAge = input.nextInt();
                    age.add(studentAge);
                    input.nextLine();

                    System.out.println("ENTER STUDENT MAJOR: ");
                    String studentMajor = input.nextLine().toUpperCase().trim(); // remove leading and trailing space
                    majors.add(studentMajor);

                    System.out.println("ENTER STUDENT GWA: ");
                    Double studentGwa = input.nextDouble();
                    gwa.add(studentGwa);
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
                    name.remove(i);
                    studentNumber.remove(i);
                    age.remove(i);
                    majors.remove(i);
                    gwa.remove(i);
                    email.remove(i);
                    address.remove(i);
                    System.out.println("SUCCESS!! STUDENT INFORMATION DELETED");

                }
            } else if (option.equals("3")){
                System.out.println("ENTER STUDENT NUMBER(TO UPDATE): ");
                String studentCode = input.nextLine().toUpperCase();
                int i = studentNumber.indexOf(studentCode);  
                if (i == -1) {
                    System.out.println("STUDENT NOT FOUND! CANNOT UPDATE INFORMATION");
                } else {
        
                    System.out.println("");
                    System.out.println("ENTER STUDENT NAME: ");
                    String newName = input.nextLine().toUpperCase();
                    name.set(i, newName);

                    System.out.println("ENTER STUDENT NUMBER: ");
                    String newCode = input.nextLine().toUpperCase();
                    studentNumber.set(i, newCode);

                    System.out.println("ENTER STUDENT AGE: ");
                    Integer newAge = input.nextInt();
                    age.set(i, newAge);
                    input.nextLine();

                    System.out.println("ENTER STUDENT MAJOR: ");
                    String newMajor = input.nextLine().toUpperCase();
                    majors.set(i, newMajor);

                    System.out.println("ENTER STUDENT GWA: ");
                    Double newGwa = input.nextDouble();
                    gwa.set(i, newGwa);
                    input.nextLine();

                    System.out.println("ENTER STUDENT EMAIL ID: ");
                    String newEmail = input.nextLine().toUpperCase();
                    email.set(i, newEmail);

                    System.out.println("ENTER STUDENT ADDRESS: ");
                    String newAddress = input.nextLine();
                    address.set(i, newAddress);

                    System.out.println("\nSUCCESS!! STUDENT INORMATION UPDATED");
                }       
            } else if (option.equals("4")) {
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
                    System.out.println("STUDENT INFORMATION PRINTED");
                    }
            } else if (option.equals("5")) {
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
                    
                        if (studentGwa <= 84) {
                            System.out.println("\n YOUR GRADES DOESN'T MEET THE REQUIREMENTS. YOU CANNOT APPLY FOR CSHOLARSHIP.");
                        } else if (studentGwa >= 85) {
                            System.out.println("CONGRATULATIONS! YOU ARE ELIGIBLE TO ENROLL");

                            if (formatMajor.equals("BS ECE")) {
                                System.out.println("SCHOLARSHIP: CSS-A Fastech Synergy Philippines >> 100% discount on tuition fees");
                            } else if (formatMajor.equals("BS ENTREP")) {
                                System.out.println("SCHOLARSHIP: CSS-B AFREIGHT Philippines Inc. >> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees");
                            } else if (formatMajor.equals("BEEd") || formatMajor.equals("BSE-Eng") || formatMajor.equals("BSE-Math")) {
                                System.out.println("SCHOLARSHIP: CSS-B Diwa Learning Systems Inc. >> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees");
                            } else if (formatMajor.equals("BEEd") || formatMajor.equals("BSE-Eng") || formatMajor.equals("BSE-Math") || formatMajor.equals("BPE-Spe")) {
                                System.out.println("SCHOLARSHIP: CSS-C Spouses Saturnino and Segundina Belen >> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees");
                                System.out.println("SCHOLARSHIP: CSS-C Spouses Lope and Flaviana Leonio >> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees");
                                System.out.println("SCHOLARSHIP: Amada Gomez >> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees");
                                System.out.println("SCHOLARSHIP: Francisco Esteban >> 100% discount on tuition fees, 100% discount on registration and miscellaneous fees");
                            } else if (formatMajor.equals("BS IT") || formatMajor.equals("BSCS") || formatMajor.equals("BS EMC") || formatMajor.equals("BS EE") || formatMajor.equals("BS IE") || formatMajor.equals("BS CPE") || formatMajor.equals("BS MT")) {
                                System.out.println("SCHOLARSHIP: CSS-D FAITH Colleges >> 100% discount on tuition fees");
                            } else {
                                System.out.println("STUDENT MAJOR DOES NOT MATCH ANY ELIGIBLE SCHOLARSHIPS");
                            }
                        }
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