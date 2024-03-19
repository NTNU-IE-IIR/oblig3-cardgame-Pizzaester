package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = {'S','H','D','C'};
  private ArrayList<PlayingCard> cardDeck = new ArrayList<>();



  /**
   * Creates a new deck of cards.
   */
  public DeckOfCards() {
    int i = 0;
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        cardDeck.add(i, new PlayingCard(suit, face));
        i++;
        }
      }
  }

  public Collection<PlayingCard> dealHand(int n) {
    if (n < 0 || n > cardDeck.size()) {
      throw new IllegalArgumentException("Number of cards to deal must be between 0 and the number of cards in the deck");
    }
    Random random = new Random();
    Collection<PlayingCard> dealtCards = new HashSet<PlayingCard>();
    for (int i = 0; i < n; ) {
      int index = random.nextInt(54);
      if (cardDeck.get(index) != null) {
        dealtCards.add(cardDeck.remove(index));
        i++;
      }
    }
    return dealtCards;
  }



  /**
   * Clears the deck of cards.
   */
  public void clearDeck() {
    cardDeck.clear();
  }
}
