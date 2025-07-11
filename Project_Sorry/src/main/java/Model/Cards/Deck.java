package Model.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * The Deck class initializes and manages a deck of cards for a game.
 * It supports methods for drawing cards, checking if the deck is empty, and more.
 * The deck contains 40 cards: 4 cards for each of the numbers 1, 2, 3, 4, 5, 7, 8, 10, 11, 12,
 * and 4 cards labeled "Sorry."
 *
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class Deck {
    private static final int NUMBER_OF_CARDS = 44;

    private ArrayList<Card> cards;

    /**
     * <b>constructor</b>: Constructs a new instance of Deck and initializes the cards.
     * <b>Post-condition</b>:Constructs a new instance of Deck and initializes the cards.
     * The deck is shuffled after initialization.
     */
    public Deck() {
        this.cards = new ArrayList<>(NUMBER_OF_CARDS);
        initializeCards();
    }

    /**
     * Initializes the cards and shuffles the deck.
     * <b>Post-condition</b>: The deck has been initialized and shuffled.
     */
    public void initializeCards() {
        for (int i = 0; i < 4; i++) {
            cards.add(new NumberOneCard());
            cards.add(new NumberTwoCard());
            cards.add(new SimpleNumberCard(3));
            cards.add(new NumberFourCard());
            cards.add(new SimpleNumberCard(5));
            cards.add(new NumberSevenCard());
            cards.add(new SimpleNumberCard(8));
            cards.add(new NumberTenCard());
            cards.add(new NumberElevenCard());
            cards.add(new SimpleNumberCard(12));
            cards.add(new SorryCard());
        }

        Collections.shuffle(cards);
    }

    /**
     * Checks if the deck is empty.
     * @return
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Adds a card to the deck.
     * <b>Post-condition</b>: The card has been added to the deck.
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Gets the value of the card at the specified index.
     * <b>Pre-condition</b>: The index is valid.
     * <b>Post-condition</b>: The value of the card at the specified index has been returned.
     * @param index the index of the card
     * @return the value of the card at the specified index
     */
    public int getCardValue(int index) {
        return cards.get(index).getValue();
    }

    /**
     * Removes a card from the deck.
     * <b>Post-condition</b>: The card has been removed from the deck.
     * @param card the card to remove
     */
    public void removeCard(Card card) {
        this.cards.remove(card);
    }


    /**
     * Returns the size of the deck.
     * <b>Post-condition</b>: The size of the deck has been returned.
     * @return the size of the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Draws a card from the deck at the specified index.
     * <b>Pre-condition</b>: The index is valid.
     * <b>Post-condition</b>: The card at the specified index has been returned.
     * @param index the index from which to draw the card
     * @return the drawn card
     */
    public Card drawCard(int index) {
        return cards.get(index);
    }

    /**
     * Clears all cards from the deck.
     * <b>Post-condition</b>: The deck is empty.
     */
    public void clearAll() {
        this.cards.clear();
    }

    /**
     * Gets all the cards in the deck.
     * <b>Post-condition</b>: All the cards in the deck have been returned.
     * @return all the cards in the deck
     */
    public ArrayList<Card> getCards() {
        return new ArrayList<>(this.cards);
    }

    /**
     * Removes the first occurrence of a card from the deck with the specified value.
     * @param cardValue the value of the card to remove
     */
    public void removeCardNumber(int cardValue) {
        Iterator<Card> iterator = this.cards.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getValue() == cardValue) {
                iterator.remove();
                return; // Card removed, exit method
            }
        }
    }

    /**
     * Redoes the deck
     */
    public void redoDeck() {
        this.cards.clear();
        initializeCards();
    }

}
