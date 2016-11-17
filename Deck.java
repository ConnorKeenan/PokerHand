import java.util.*;
/**
 * Models a deck of cards 
 * @author Connor Keenan 
 */
public class Deck
{    
    Random rgen = new Random();
    private Card [] myDeck;
    private int currentCardIndex; //Location of next card to deal  

    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {        
        myDeck=new Card[52];
        currentCardIndex = 0;
        String [] suites={"Clubs", "Diamonds", "Hearts", "Spades"}; 
        for(int i = 0 ; i < myDeck.length;i++)
        {
            myDeck[i] = new Card(1 + i % 13, suites[i/13]); 
        }        
    }

    /**
     * Returns the next card, currentCardIndex++
     */
    public Card deal()
    {          
            if(currentCardIndex >= 48)
            {
                shuffle();
                currentCardIndex = 0;
            }            
            return(myDeck[currentCardIndex++]);          
    }  

    /**
     * Returns a hand, deals 3 cards
     */
    public PokerHand dealHand()
    {             
        
        Card card1 = deal();
        Card card2 = deal();
        Card card3 = deal();    
        PokerHand hand=new PokerHand(card1, card2, card3);       
        return hand;
    }    

    /**
     * Returns myDeck[] to the start, shuffles the deck
     */
    public void shuffle()
    {
        Card temp;
        for(int first=0;first<myDeck.length;first++)
        {
            //set second to a random loc 0-51 in deck   
            int second = rgen.nextInt(52);
            temp = myDeck[first];;
            myDeck[first] = myDeck[second];  
            myDeck[second] = temp;
            //swap first card with random second card temp-remember a card    
        }
        //after shuffle, deck should start at deck[0] again
        //return myDeck[0];
    }

    /**
     * Prints 10 cards for testing concerns
     */
    public void testing()
    {
        for(int i=0; i<10;i++)
        {
            System.out.println(deal());
        }
    }
}
