import java.util.Scanner;

public class main {

    public static String firstInputTeam;
    public static String secondInputTeam;

    public static void main(String[] args){
        while(!setup.repeatTheApplication) {
            System.out.println(application());
        }
    }

    private static String application(){
        readTheTeams();
        return setup.calculateWinnerTeam();
    }

    private static void readTheTeams(){
        Scanner scanner = new Scanner(System.in);
        firstInputTeam = scanner.nextLine();
        scanner = new Scanner(System.in);
        secondInputTeam = scanner.nextLine();
    }
}
