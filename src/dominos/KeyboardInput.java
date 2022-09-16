package dominos;

import java.util.Scanner;

public class KeyboardInput {
    public String getPlayerInput() {
        Scanner in = new Scanner(System.in);
        String playerInput = in.nextLine();
        return playerInput;
    }
}
