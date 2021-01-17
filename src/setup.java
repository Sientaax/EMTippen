import java.util.Random;

public class setup {

    public static boolean repeatTheApplication = false;
    private static int currentHighestNumberA = 0;
    private static int currentHighestNumberB = 0;

    public static String calculateWinnerTeam(){
        if(checkTheTeams()){
            if(selectRandomNumberA() > selectRandomNumberB()){
                repeatTheApplication = true;
                return "Der Sieger wird " + main.firstInputTeam + " sein.";
            }else if(selectRandomNumberB() > selectRandomNumberA()){
                repeatTheApplication = true;
                return "Der Sieger wird " + main.secondInputTeam + " sein.";
            }else{
                repeatTheApplication = true;
                return "Es wird ein untentschieden geben.";
            }
        }else{
            return "Bitte überprüfe deine Eingabe. Mögliche Fehler:\nvertippt, ein Team spielt bei der EM nicht mit, zwei mal das selbe Team";
        }
    }

    private static boolean checkTheTeams(){
        int counterForNoErrors = 0;
        for(int i = 0; i < groups.teams.length; i++) {
            if(main.firstInputTeam.equals(groups.teams[i])) {
                counterForNoErrors++;
            }
            if(main.secondInputTeam.equals(groups.teams[i])){
                counterForNoErrors++;
            }
        }
        if(!main.firstInputTeam.equals(main.secondInputTeam)){
            counterForNoErrors++;
        }
        return counterForNoErrors == 3;
    }

    private static int selectRandomNumberA(){
        for(int i = 0; i < determineTheTeamA(); i++){
            Random r = new Random();
            int random;
            random = 1 + r.nextInt(48);
            if(random > currentHighestNumberA){
                currentHighestNumberA = random;
            }
        }
        return currentHighestNumberA;
    }

    private static int selectRandomNumberB() {
        for(int i = 0; i < determineTheTeamB(); i++){
            Random r = new Random();
            int random;
            random = 1 + r.nextInt(48);
            if(random > currentHighestNumberB){
                currentHighestNumberB = random;
            }
        }
        return currentHighestNumberB;
    }

    private static int determineTheTeamA(){
        int counter = 1;
        boolean checker = false;
        for(int i = 0; i < groups.teams.length; i++){
            if(groups.teams[i].equals(main.firstInputTeam)){
                checker = true;
            }
            if(!checker){
                counter++;
            }
        }
        return counter;
    }

    private static int determineTheTeamB(){
        int counter = 1;
        boolean checker = false;
        for(int i = 0; i < groups.teams.length; i++){
            if(groups.teams[i].equals(main.secondInputTeam)){
                checker = true;
            }
            if(!checker){
                counter++;
            }
        }
        return counter;
    }
}
