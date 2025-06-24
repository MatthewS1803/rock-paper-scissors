import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        String playAgain;
        String userInput;
        String difficulty;
        String userName;
        int chance;
        playAgain = "yes";
        
        
        // Greet user and ask for difficulty
        System.out.println("Hey there! Welcome to Rock-Paper-Scissors.");
        System.out.println("Let's see if you can beat me!");
        System.out.println("Before we start, tell me what is your name?");
        userName = scnr.nextLine();
        System.out.print("Hello " + userName + "! Please choose your difficulty (easy, medium, hard, impossible): ");
        difficulty = scnr.nextLine().trim().toLowerCase();
        
        // Validate difficulty choice 
        while (!(difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard") || difficulty.equals("impossible"))) {
            System.out.print("Invalid option. Please choose the correct difficulty setting: ");
            difficulty = scnr.nextLine().trim().toLowerCase();
        }
        
        int playerScore = 0;  // The player's score 
        int computerScore = 0;  // The computer's score
        
        // Game Starts
        do {
          System.out.print("Please make your move (rock, paper, or scissors): ");
          userInput  = scnr.nextLine();
          rpsMoves playerMove = rpsMoves.fromString(userInput); 
          
          // If user inputs invalid move, asks user to enter move play play Again
          if (playerMove == null) {
            System.out.println("Sorry it seems like you chose an invalid move.\n Please enter rock, paper or scissors.");
            continue; // continues until user inputs valid moves
          }
          
          // Computer selects moves based on difficulty
          rpsMoves computerMove;
          chance = rand.nextInt(100);
          
          // If user selects easy difficulty
          switch (difficulty) {
              case "easy":
                computerMove = rpsMoves.getRandomMove();
                break;
              
              // If user selects medium difficulty
              case "medium":
                if (chance < 30) {
                    computerMove = rpsMoves.getLosingMove(playerMove); // If chance is less than 30 percent it chooses the losing move
                } else {
                    computerMove = rpsMoves.getRandomMove(); // else moves are random
                }
                break;
              
              // If user selects hard difficulty
              case "hard":
                if (chance < 50) {
                    computerMove = rpsMoves.getWinningMove(playerMove); // If chance is less than 50 percent it chooses the winning move
                } else {
                    computerMove = rpsMoves.getRandomMove(); // else moves are random
                }
                break;
              
              // If user selects impossible difficulty
              case "impossible" :
                computerMove = rpsMoves.getWinningMove(playerMove); // Computer always chooses winning move
                break;
              default:
                computerMove = rpsMoves.getRandomMove(); 
          }
          
          System.out.println("I choose: " + computerMove);
          
          // If user ties with computer
          if (playerMove.loses(computerMove)) {
            System.out.println(Messages.getRandomLose());
            computerScore++;  // Increment the computer's score by one
          }
          else if (playerMove.wins(computerMove)) {
            System.out.println(Messages.getRandomWin());
            playerScore++;  // Increment the player's score by one
          }
          else {
            System.out.print(Messages.getRandomTie());
            System.out.println("Let's go again!");
            continue;
          }
          
          // Displays the current score
          System.out.println("Score so far - " + userName + ": " + playerScore + " | Me: " + computerScore + "\n");
          
          // Asks user if they want to play again 
          while (true) {
            System.out.print("Want to play again? (yes/no)");
            playAgain = scnr.nextLine().trim().toLowerCase();
            if (playAgain.equals("yes") || playAgain.equals("no")) {
                break;
            }
            else {
                System.out.println("Sorry I didn't understand. Please type 'yes' or 'no'. ");
            }
            System.out.println();  
          }
          
        } while (playAgain.equalsIgnoreCase("yes"));
        
        // Ends the game and displays final score
        System.out.println("Thanks for playing! Come back soon!");
        System.out.println("Final Score - " + userName + ": " + playerScore + " | Me: " + computerScore + "\n");
        if (playerScore > computerScore) {
            System.out.println("You made the right moves when it counted. Good game.");
        }
        else if (playerScore < computerScore) {
            System.out.println("You played well. I just happened to come out ahead this time.");
        }
        else {
            system.out.println("Wow its a tie! Looks like the universe loves symmetry.")
        }
  }     
}
