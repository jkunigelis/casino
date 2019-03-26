public class Start_Game {
	
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
		
		boolean end = false;
		
		Deck deck = new Deck(ranks, suits, values);
		
		deck.shuffle();
		System.out.println("Dealer's Cards:");
		Card tempDealerCard1 = deck.deal();
		System.out.println(tempDealerCard1);
		Card tempDealerCard2 = deck.deal();
		System.out.println("-----Hidden Card-----");
		
		System.out.println("Your Cards:");
		Card tempPlayerCard1 = deck.deal();
		System.out.println(tempPlayerCard1);
		Card tempPlayerCard2 = deck.deal();
		Card tempPlayerCard3 = new Card("2", "Spade", 0);
		System.out.println(tempPlayerCard2);
		
		while (end == false) {
			if (tempPlayerCard1.pointValue() + tempPlayerCard2.pointValue() == 21) {
				System.out.println("Blackjack! You win!");
				end = true;
			}
			else if (tempPlayerCard1.rank() == "A") {
				if (11 + tempPlayerCard2.pointValue() == 21) {
					System.out.println("Blackjack! You win!");
					end = true;
				}
			}
			else if (tempPlayerCard2.rank() == "A") {
				if (11 + tempPlayerCard1.pointValue() == 21) {
					System.out.println("Blackjack! You win!");
					end = true;
				}
			}
			else {
				if (tempPlayerCard1.pointValue() + tempPlayerCard2.pointValue() + tempPlayerCard3.pointValue() > 21) {
					System.out.println("Bust! You lose!");
					end = true;
				}
				else {
					System.out.println("Hit!");
					System.out.println("Your Cards:");
					System.out.println(tempPlayerCard1);
					System.out.println(tempPlayerCard2);
					tempPlayerCard3 = deck.deal();
					System.out.println(tempPlayerCard3);
				}
			}
		}
		
	}
}