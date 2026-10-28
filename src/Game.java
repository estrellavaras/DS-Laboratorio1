public class Game {

  private static final String CARDS_LOW_TO_HIGH = "23456789TJQKA";

  public String winner(String[] deckSteve, String[] deckJosh) {
    int stevePoints = 0;
    int joshPoints = 0;

    for (int round = 0; round < deckSteve.length; round++) {
      int steveCardValue = getCardPosition(deckSteve[round]);
      int joshCardValue = getCardPosition(deckJosh[round]);

      if (steveCardValue > joshCardValue) {
        stevePoints++;
      } else if (joshCardValue > steveCardValue) {
        joshPoints++;
      }
    }
    if (stevePoints > joshPoints) {
      return "Steve wins " + stevePoints + " to " + joshPoints;
    }
    if (joshPoints > stevePoints) {
      return "Josh wins " + joshPoints + " to " + stevePoints;
    }
    return "Tie";
  }

  private int getCardPosition(String card) {
    return CARDS_LOW_TO_HIGH.indexOf(card);
  }
}