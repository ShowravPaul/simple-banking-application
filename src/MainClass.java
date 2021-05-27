import java.util.*;

public class MainClass {
    static Scanner inInt = new Scanner(System.in);
    static Scanner inString = new Scanner(System.in);
    static Client users[] = new Client[101];

    public static void main(String args[]){
        int officerID = 123;
        String officerPassword = "123";

        System.out.println("________________________________________________________\n" +
                "________________Welcome to the ABCD bank________________\n" +
                "________________________________________________________\n");

        while(true){
            System.out.println("An officer should be logged in first.\n");

            System.out.print("Enter officer ID: ");
            int officerIDInput = inInt.nextInt();
            System.out.println("");
            System.out.print("Enter officer password: ");
            String officerPasswordInput = inString.nextLine();

            if(officerID == officerIDInput && officerPassword.equals(officerPasswordInput)) break;
            else System.out.println("Didn't match ID or password. Please try again!\n");
        }

        while(true) {
            System.out.println("------------------------------------\n" +
                            "-> enter 1 to create a new account\n" +
                            "-> enter 2 to cash in money\n" +
                            "-> enter 3 to cash out money\n" +
                            "-> enter 4 to check balance\n" +
                            "-> enter 0 to exit\n" +
                    "------------------------------------\n");

            int index = 1;
            int pressedKey = inInt.nextInt();

            if(pressedKey == 0) {
                System.out.println("Logged out successfully. Good bye!");
                break;
            }
            else if(pressedKey == 1){
                System.out.print("Enter name: ");
                String name = inString.nextLine();

                System.out.println("");

                System.out.print("Enter password: ");
                String password = inString.nextLine();

                users[index] = new Client(name, password, index);

                System.out.println("A new account has been created.\n" +
                        "Your ID: " + index + "\n" +
                        "Please save this ID. Because you will need it to login.");
                index++;
            }
            else if(pressedKey == 2){
                int ID = userLogin();
                if(ID != -1){
                    System.out.print("Amount to cash in: ");
                    int amount = inInt.nextInt();
                    users[ID].cashIn(amount);
                }
                else System.out.println("Didn't match ID or password. Please try again!\n");
            }
            else if(pressedKey == 3){
                int ID = userLogin();
                if(ID != -1){
                    System.out.print("Amount to cash out: ");
                    int amount = inInt.nextInt();
                    users[ID].cashOut(amount);
                }
                else System.out.println("Didn't match ID or password. Please try again!\n");
            }
            else if(pressedKey == 4){
                int ID = userLogin();
                if(ID != -1){
                    users[ID].checkBalance();
                }
                else System.out.println("Didn't match ID or password. Please try again!\n");
            }
        }
    }

    static int userLogin(){
        System.out.print("Enter ID: ");
        int ID = inInt.nextInt();

        System.out.println("");

        System.out.print("Enter password: ");
        String password = inString.nextLine();

        if(users[ID].checkPassword(password)){
            System.out.println("Logged in successfully.\n");
            return ID;
        }
        else {
            System.out.println("Didn't match ID or password. Please try again!\n");
            return -1;
        }
    }
}