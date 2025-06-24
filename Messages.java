import java.util.Random;

public class Messages {
    // Winning Messages 
    private static final String[] winMessages = {
        "Ugh...fine, you win. This time.",
        "Yeah yeah...you win. Probably just a fluke.",
        "I let you win. Totally on purpose. Totally...",
        "Well, congratulations... I guess",
        "Is this your peak? Is this your moment? Enjoy it.",
        "I'd say 'well played' but... let's not get ahead of ourselves.",
        "I see you brought your A-game today!",
        "You win! Want to go best two out of three?",
        "That was fun! Let's do it again sometime!",
        "Wow! You actually beat me! Nicely done.",
        "I underestimated you - and you made me pay for it!",
        "I'm not even mad.. that was awesome!"
    };
    
    // Losing Messages
    private static final String[] loseMessages = {
        "Too easy. Next time, bring a challenge.",
        "Seriously? That was your move?",
        "Do you even *know* how this game works?",
        "I should teach a class on how to win at this.",
        "I'm not saying I'm better... but the scoreboard is.",
        "Don't worry, losing builds character. You'll be fine.",
        "That was a fun round! I just happened to come out ahead.",
        "You played well - I was just a bit luckier this time.",
        "You've got skill - I just happened to read your right.",
        "I won this round, but you made me work for it!",
        "I've got to admit - that was a close call.",
        "You're a strong opponent. I got lucky this round."
    };
    
    // Tie Messages
    private static final String[] tieMessages = {
        "It's a tie. Great minds think alike! \n",
        "Looks like we're in sync. \n",
        "Okay, okay - a draw. \n",
        "Same move? That's kind of awesome. \n",
        "That was a close one. \n",
        "Nobody wins, but nobody loses either - fair enough! \n",
        "A tie? Boring. Try something original next time. \n",
        "Copycat. \n",
        "A draw? Ugh. \n",
        "Is your strategy just to mirror me? \n",
        "Wow. Matching moves? Try thinking for yourself. \n",
        "Nobody wins - but I feel like I still came out ahead. \n"
    };
    
    private static final Random rand = new Random();
    
    // Randomizes the win messages
    public static String getRandomWin() {
        return winMessages[rand.nextInt(winMessages.length)];
    }
    
    // Randomizes the lose messages
    public static String getRandomLose() {
        return loseMessages[rand.nextInt(loseMessages.length)];
    }
    
    // Randomizes the tie messages
    public static String getRandomTie() {
        return tieMessages[rand.nextInt(tieMessages.length)];
    }
    
}
