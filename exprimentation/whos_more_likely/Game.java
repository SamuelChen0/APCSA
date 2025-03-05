package exprimentation.whos_more_likely;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Game{
    
    public static void main(String[] args) {
        ArrayList <String> players = new ArrayList<String> ();
        ArrayList <String> questions = new ArrayList<String> ();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList< String> votes = new ArrayList<String>();
    
        System.out.println("how many poeple are playing?");
        int numOfPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i =0; i <numOfPlayers; i++){
            System.out.println("pls enter player number"+ (i+1) +" name");
            players.add(scanner.nextLine());
        }
        
        for(int y = 0; y < players.size(); y++){
            System.out.println("pls create 3 questions");
            for(int j=0; j<3; j++){
                System.out.println("Question" +(j+1) +" : who's more likely ");
                questions.add(scanner.nextLine());
            }
        }
        System.out.println("the game is about to start!");
        
        for(int i =0; i < questions.size(); i++){
            String question = questions.get(random.nextInt(questions.size()));
            System.out.println("who's more likely to " + question);
            questions.remove(question);
            
            System.out.println("vote for one of the following players");

            for (int u = 0; u < players.size(); u++){
                System.out.println(players.get(u) + " cast ur vote; ");
                String vote = scanner.nextLine();
                for(int g = 0; g <100; g++){
                    System.out.println("不要偷偷看別人答案😡");
                }

            }
            
            boolean seventyfivepercent = false;
            String answer = null;
            int currentCount = 1;
            for (int t = 1; t < votes.size(); t++) {
                if (votes.get(i).equals(votes.get(i - 1))) {
                    currentCount++;
                    if (currentCount >= 0.75 * votes.size()) {  
                        seventyfivepercent =true; // Found an element repeated >= 75% of the time
                        answer = votes.get(t);
                    }
                } else {
                    currentCount = 1; // Reset count for the next element
                }
            }
            if( seventyfivepercent == true){
                System.out.println(answer);
            }else{
                System.out.println("No one is chosen by more than 75% of the players");
            }


        }

    }
}


