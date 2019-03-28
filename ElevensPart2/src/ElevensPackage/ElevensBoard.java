package ElevensPackage;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
                //super must be the first call or else you get an error
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
            if (containsPairSum11(selectedCards) == true){
                return true;
            }
            else if (containsJQK(selectedCards) == true){
                return true;
            }
            return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
            for (int i = 0; i<10; i++){
                for (int j = 0; j<10; j++){
                    if (cardAt(i).pointValue() + cardAt(j).pointValue() == 11){
                        return true;
                    }
                }
            }
            boolean countK = false;
            boolean countJ = false;
            boolean countQ = false;
            for (int c = 0; c<10; c++){
                if (cardAt(c).rank().equals("king")){
                    countK = true;
                }
                if (cardAt(c).rank().equals("queen")){
                    countQ = true;
                }
                if (cardAt(c).rank().equals("jack")){
                    countJ = true;
                }
            }
            if (countK == true && countQ == true && countJ == true){
                return true;
            }
            return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
            int pairVal = cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue();
            if (pairVal == 11){
                return true;
            }
            return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
            boolean countK = false;
            boolean countJ = false;
            boolean countQ = false;
            for (int c = 0; c<4; c++){
                if (cardAt(selectedCards.get(c)).rank().equals("king")){
                    countK = true;
                }
                if (cardAt(selectedCards.get(c)).rank().equals("queen")){
                    countQ = true;
                }
                if (cardAt(selectedCards.get(c)).rank().equals("jack")){
                    countJ = true;
                }
            }
            if (countK == true && countQ == true && countJ == true){
                return true;
            }
            return false;
	}
}
