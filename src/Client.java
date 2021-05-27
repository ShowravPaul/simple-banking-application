public class Client {
    Client(String name, String password, int ID) {
        this.name = name;
        this.ID = ID;
        this.password = password;
    }

    private String name;
    private int ID;
    private String password;
    private int balance;

    boolean checkPassword(String inputPassword) {
        if(inputPassword.equals(password)) return true;
        else return false;
    }

    public void checkBalance() {
        System.out.println(name + ", your current balance is : " + this.balance + " taka.");
    }

    public void cashIn(int money){
        this.balance += money;
        System.out.println(name + ", your Cash in request was successful." +
                " Your current balance is : " + this.balance + " taka.");
    }

    public void cashOut(int money){
        if(money > this.balance){
            System.out.println(name + ", you do not have enough balance to cash out this amount." +
                    " Your current balance is : " + this.balance + " taka.");
        }
        else{
            this.balance -= money;
            System.out.println(name + ", your Cash out request was Successfull." +
                    " Your current balance is : " + this.balance + " taka.");
        }
    }
}