package dominos;

import java.util.Scanner;
/**
 * Name: Vasileios Grigorios Kourakos
 * This class handles player command line
 * input.
 */
public class KeyboardInput {
    /**
     * This method simply scans the next string input
     * of the player in the command line and
     * returns it.
     * @return The string input
     */
    public String getPlayerInput() {
        Scanner in = new Scanner(System.in);
        String playerInput = in.nextLine();
        return playerInput;
    }
}
