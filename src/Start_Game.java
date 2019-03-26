import java.util.Scanner;

public class Start_Game {
	
	static int pointPlayer = 0;
	static int pointDealer = 0;
	static int countAsP = 0;
	static int countAsD = 0;
	static Card tempDealerCard1 = null;
	static Card tempDealerCard2 = null;
	static Card tempPlayerCard1 = null;
	static Card tempPlayerCard2 = null;
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// like K, Q, 2, 3, etc.
		String[] ranks = new String[] {
				"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
		};
		
		// diamond, heart, etc.
		String[] suits = new String[] {
				"Diamond", "Heart", "Club", "Spade"
		};
		// point values
		int[] values = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
		};
		
		Deck deck = new Deck(ranks, suits, values);
		
		deck.shuffle();
		System.out.println("Dealer's Cards:");
		tempDealerCard1 = deck.deal();
		System.out.println(tempDealerCard1);
		tempDealerCard2 = deck.deal();
		System.out.println("-----Hidden Card-----");
		pointDealer = tempDealerCard1.pointValue() + tempDealerCard2.pointValue();
		
		System.out.println("Your Cards:");
		tempPlayerCard1 = deck.deal();
		System.out.println(tempPlayerCard1);
		tempPlayerCard2 = deck.deal();
		System.out.println(tempPlayerCard2);
		pointPlayer = tempPlayerCard1.pointValue() + tempPlayerCard2.pointValue();
		checkForWin(deck);
	}
	public static void checkForWin(Deck deck) {
		if (pointPlayer == 21) {
			System.out.println("Blackjack! You win!");
		}
		else if (tempPlayerCard1.rank() == "A") {
			countAsP++;
			if (pointPlayer + 10 == 21) {
				System.out.println("Blackjack! You win!");
			}
			else if (countAsP > 1) {
				if (pointPlayer + 20 == 21) {
					System.out.println("Blackjack! You win!");
				}
			}
		}
		else if (tempPlayerCard2.rank() == "A") {
			countAsP++;
			if (pointPlayer + 10 == 21) {
				System.out.println("Blackjack! You win!");
			}
			else if (countAsP > 1) {
				if (pointPlayer + 20 == 21) {
					System.out.println("Blackjack! You win!");
				}
			}
		}
		else {
			if (pointPlayer > 21) {
				System.out.println("Bust! You lose!");
			}
			else {
				System.out.println("Hit or Stand?");
				System.out.println("Enter 'H' or 'S' or 'Q' (to quit)");
				String choice = in.nextLine();
				while (!choice.equals("Q")) {
					switch (choice) {
					case "H":
						tempPlayerCard1 = null;
						tempPlayerCard2 = null;
						tempDealerCard1 = null;
						tempDealerCard2 = null;
						break;
					case "S":
						tempPlayerCard1 = null;
						tempPlayerCard2 = null;
						tempDealerCard1 = null;
						tempDealerCard2 = null;
						break;
					default:
						System.out.println("Please enter valid command.");
						break;
					}
				}
			}
		}
	}
}
