import java.util.Random;
import javax.swing.*;

public class NumberGuessr {

	static void playGame() {
		Random random = new Random();
		int actualNumber = random.nextInt(1000);

		ImageIcon startImage = new ImageIcon("/Users/_bobal_/eclipse-workspace/NumberGame/src/startImage.png");
		ImageIcon inputImage = new ImageIcon("/Users/_bobal_/eclipse-workspace/NumberGame/src/inputImage.png");
		ImageIcon gameOverImage = new ImageIcon("/Users/_bobal_/eclipse-workspace/NumberGame/src/gameOverImage.png");
		JOptionPane.showMessageDialog(null, "Guess the number within 7 tries!\n Between 0 and 999, inclusive.",
				"Guess The Number!", JOptionPane.INFORMATION_MESSAGE, startImage);
		for (int i = 0; i < 7; i++) {
			int triesLeft = 7 - i;
			String inputString = "Tries left: " + triesLeft + "\nEnter your guess: ";
			String guessString;
			int guessNumber;
			try {
				guessString = (String) JOptionPane.showInputDialog(null, inputString, "",
						JOptionPane.INFORMATION_MESSAGE, inputImage, null, "");
				guessNumber = Integer.parseInt(guessString);
			} catch (Exception e) {
				ImageIcon invalidImage = new ImageIcon(
						"/Users/_bobal_/eclipse-workspace/NumberGame/src/invalidInput.png");
				JOptionPane.showMessageDialog(null, "Invalid Input.\nTry again!", "Invalid Try",
						JOptionPane.INFORMATION_MESSAGE, invalidImage);
				i--;
				continue;
			}
			if (guessNumber > actualNumber) {
				ImageIcon incorrectGuessImage = new ImageIcon(
						"/Users/_bobal_/eclipse-workspace/NumberGame/src/higherGuess.png");
				if (i == 6) {
					JOptionPane.showMessageDialog(null, "You lose. :(\nThe correct number was " + actualNumber + ".",
							"Defeat!", JOptionPane.INFORMATION_MESSAGE, gameOverImage);
					break;
				}
				JOptionPane.showMessageDialog(null,
						"Incorrect!\n" + guessNumber + " was HIGHER than the actual number.", "Higher Guess",
						JOptionPane.INFORMATION_MESSAGE, incorrectGuessImage);

			} else if (guessNumber < actualNumber) {
				ImageIcon incorrectGuessImage = new ImageIcon(
						"/Users/_bobal_/eclipse-workspace/NumberGame/src/lowerGuess.png");
				if (i == 6) {
					JOptionPane.showMessageDialog(null, "You lose. :(\nThe correct number was " + actualNumber + ".",
							"Defeat!", JOptionPane.INFORMATION_MESSAGE, gameOverImage);
					break;
				}
				JOptionPane.showMessageDialog(null, "Incorrect!\n" + guessNumber + " was LOWER than the actual number.",
						"Lower Guess", JOptionPane.INFORMATION_MESSAGE, incorrectGuessImage);

			} else {
				ImageIcon correctGuessImage = new ImageIcon(
						"/Users/_bobal_/eclipse-workspace/NumberGame/src/correctAnswer.png");
				JOptionPane.showMessageDialog(null, "Congratulations! You WIN!\nThe number was " + actualNumber + ".",
						"Victory!", JOptionPane.INFORMATION_MESSAGE, correctGuessImage);
				break;
			}
		}
	}

	public static void main(String[] args) {
		boolean playAgain = true;
		String[] options = { "No", "Yes" };
		do {
			playGame();
			int reply = JOptionPane.showOptionDialog(null, "Do you want to try a new number?", "Play again?",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
			playAgain = (reply == 1) ? true : false;
		} while (playAgain);

	}
}