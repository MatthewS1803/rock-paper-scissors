import java.util.Random;

public enum rpsMoves {
  ROCK, PAPER, SCISSORS;
  
  // Decides who wins the round
  public boolean wins(rpsMoves other) {
    return (this == ROCK && other == SCISSORS) || 
    (this == PAPER && other == ROCK) || 
    (this == SCISSORS && other == PAPER);
  }
  
  // Decides who loses the round
  public boolean loses(rpsMoves other) {
      return (this == ROCK && other == PAPER) ||
      (this == PAPER && other == SCISSORS) ||
      (this == SCISSORS && other == ROCK);
  }
  
  // Chooses a random move to play
  public static rpsMoves getRandomMove() {
    rpsMoves[] moves = values(); // Assigns moves to all values of rpsMoves
    int i = new Random().nextInt(3);
    return moves[i];
  }
  
  // Assigns winning move for the computer
  public static rpsMoves getWinningMove(rpsMoves move) {
      switch (move) {
          case ROCK : return PAPER;
          case PAPER : return SCISSORS;
          case SCISSORS : return ROCK;
          default: return getRandomMove();
      }
  }
  
  // Assigns losing move for the computer        
  public static rpsMoves getLosingMove(rpsMoves move) {
      switch(move) {
          case ROCK: return SCISSORS;
          case PAPER: return ROCK;
          case SCISSORS: return PAPER;
          default: return getRandomMove();
      }
  }
  
  /**
   * Converts a user-input string into a corresponding rpsMove enum value.
   * Removes non-letter characters, making it lowercase, and trimming any spaces
   * Returns the appropriate enum value. Otherwise, it returns null
   * 
   */
  public static rpsMoves fromString(String input) {
    if (input == null) return null; // If input is empty
    
    String convertInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
    
    switch(convertInput) {
      case "rock":
        return ROCK;
      case "paper":
        return PAPER;
      case "scissors":
        return SCISSORS;
      default:
        return null; // Input didn't match any known moves
    }
    
  }
}
