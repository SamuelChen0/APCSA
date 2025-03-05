package exprimentation.whos_more_likely;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class WhosMoreLikelyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfPlayers = getNumberOfPlayers(scanner);
        if (numberOfPlayers < 4) {
            System.out.print("Need " + (4 - numberOfPlayers) + " more player(s) to start the game");
            scanner.close();
            return;
        }

        int numberOfVotes = getNumberOfVotes(scanner);
        if (numberOfVotes < 1) {
            System.out.print("At least 1 vote is required to reveal.");
            scanner.close();
            return;
        }

        ArrayList<String> players = getPlayerNames(scanner, numberOfPlayers);
        ArrayList<String> questions = getQuestions(scanner, players);

        startGame(scanner, numberOfPlayers, numberOfVotes, players, questions);
        scanner.close();
    }

    private static int getNumberOfPlayers(Scanner scanner) {
        System.out.println("Enter the number of players:");
        return scanner.nextInt();
    }

    private static int getNumberOfVotes(Scanner scanner) {
        System.out.println("Reveal answer when how many votes does a player get:");
        return scanner.nextInt();
    }

    private static ArrayList<String> getPlayerNames(Scanner scanner, int numberOfPlayers) {
        scanner.nextLine();
        ArrayList<String> players = new ArrayList<>();
        System.out.println("Enter the names of the players:");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            players.add(scanner.nextLine());
        }
        return players;
    }

    private static ArrayList<String> getQuestions(Scanner scanner, ArrayList<String> players) {
        ArrayList<String> questions = new ArrayList<>();
        for (String player : players) {
            System.out.println(player + ", enter 3 questions:");
            for (int i = 0; i < 3; i++) {
                System.out.print("Question " + (i + 1) + ": Who's more likely to ");
                questions.add(scanner.nextLine());
            }
        }
        return questions;
    }

    private static void startGame(Scanner scanner, int numberOfPlayers, int numberOfVotes, ArrayList<String> players, ArrayList<String> questions) {
        Random random = new Random();
        boolean continueGame = true;

        while (continueGame) {
            String question = questions.get(random.nextInt(questions.size()));
            questions.remove(question);
            System.out.println("\nQuestion: Who's more likely to " + question);

            HashMap<String, Integer> votes = initializeVotes(players);
            castVotes(scanner, players, votes);

            boolean revealAnswer = checkRevealAnswer(votes, numberOfVotes);
            if (revealAnswer) {
                revealAnswer(votes, question);
            } else {
                System.out.println("Everyone got less than " + numberOfVotes + " votes. The answer will not be revealed.");
            }

            System.out.print("\nDo you want to continue? (yes/no) ");
            String response = scanner.nextLine();
            continueGame = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over. Thanks for playing!");
    }

    private static HashMap<String, Integer> initializeVotes(ArrayList<String> players) {
        HashMap<String, Integer> votes = new HashMap<>();
        for (String player : players) {
            votes.put(player, 0);
        }
        return votes;
    }

    private static void castVotes(Scanner scanner, ArrayList<String> players, HashMap<String, Integer> votes) {
        System.out.println("Vote for one of the following players (Remember to capitalize the first letter):");
        for (String player : players) {
            System.out.print(player + ", ");
        }
        System.out.println();

        for (String voter : players) {
            System.out.print(voter + ", cast your vote: ");
            String vote = scanner.nextLine();
            if (votes.containsKey(vote)) {
                votes.put(vote, votes.get(vote) + 1);
            } else {
                System.out.println("Invalid player name, please try again.");
                
            }
        }
    }

    private static boolean checkRevealAnswer(HashMap<String, Integer> votes, int numberOfVotes) {
        for (String player : votes.keySet()) {
            if (votes.get(player) >= numberOfVotes) {
                return true;
            }
        }
        return false;
    }

    private static void revealAnswer(HashMap<String, Integer> votes, String question) {
        String mostVoted = getMostVotedPlayer(votes);
        System.out.println("The answer is revealed! " + mostVoted + " is most likely to " + question);
    }

    private static String getMostVotedPlayer(HashMap<String, Integer> votes) {
        String mostVoted = "";
        int maxVotes = 0;
        for (String player : votes.keySet()) {
            if (votes.get(player) > maxVotes) {
                maxVotes = votes.get(player);
                mostVoted = player;
            }
        }
        return mostVoted;
    }
}



