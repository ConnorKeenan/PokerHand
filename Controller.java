import java.util.ArrayList;
/** Collects data from multiple methods of PokerHand, Deck, and Card
Primary purpose is to display 1,000 PokerHands and formulate a summary of its results
 */
public class Controller
{   
    private ArrayList<PokerHand> collecter; //collects all hands dealt
    private ArrayList<String> results;  //for each hand, store rank outcome 
    private ArrayList<Integer> results2;//accumulates count of ranks   
    public Controller()
    {   
        results = new ArrayList<>();
        results2 = new ArrayList<>();
        collecter = new ArrayList<>();           
    }  

    /**
     *Displays 1,000 poker hands and prints percentages based on those hands
     */ 

    public void simulateOneThousand()
    {
        Deck tempDeck = new Deck();
        double straightFlush=0;
        double flush=0;
        double onePair=0;       
        double threeOfAKind=0;        
        double straight=0;
        double high=0;           //9 entries to collect data from PokerHand Rankings
        tempDeck.shuffle();        

        System.out.println("---Poker Stats---");
        System.out.println("-----------1,000 Hands-----------");

        for(int i=0; i<1000; i++)
            collecter.add(tempDeck.dealHand()); 
        //now get results
        for(int i=0; i<1000; i++)
        {
            results.add((collecter.get(i).evaluate())); //Adds hand ranking to results<>           
            System.out.println(collecter.get(i) + "--" + collecter.get(i).evaluate());  //prints hand and ranking
            results2.add((collecter.get(i).evaluate3())); //Will not work    

            straightFlush = straightFlush + (collecter.get(i).getStraightFlush());
            flush = flush + (collecter.get(i).getFlush());
            onePair = onePair + (collecter.get(i).getOnePair());
            threeOfAKind = threeOfAKind + (collecter.get(i).getThreeOfAKind());
            straight = straight + (collecter.get(i).getStraight());
            high = high + (collecter.get(i).getHigh());

        }        
        System.out.println("Straight Flush       " + straightFlush + "       Percent: " +  straightFlush/10 + "%");
        System.out.println("Flush                " + flush + "       Percent: " +  flush/10 + "%"); 
        System.out.println("One Pair             " + onePair + "       Percent: " +  onePair/10 + "%");    
        System.out.println("Three of a Kind      " + threeOfAKind + "       Percent: " +  threeOfAKind/10 + "%");        
        System.out.println("Straight             " + straight + "       Percent: " + straight/10 + "%");         
        System.out.println("Only High            " + high + "       Percent: " + high/10 + "%");            
    }

    /**
     *Displays 10 poker hands and prints percentages based on those hands
     */ 
    public void simulateTen()
    {
        Deck tempDeck = new Deck();
        double straightFlush=0;
        double flush=0;
        double onePair=0;       
        double threeOfAKind=0;        
        double straight=0;
        double high=0;           //9 entries to collect data from PokerHand Rankings
        tempDeck.shuffle();        

        System.out.println("---Poker Stats---");
        System.out.println("-----------10 Hands-----------");

        for(int i=0; i<10; i++)
            collecter.add(tempDeck.dealHand()); 
        //now get results
        for(int i=0; i<10; i++)
        {
            results.add((collecter.get(i).evaluate())); //Adds hand ranking to results<>           
            System.out.println(collecter.get(i) + "--" + collecter.get(i).evaluate());  //prints hand and ranking
            results2.add((collecter.get(i).evaluate3())); //Will not work    

            straightFlush = straightFlush + (collecter.get(i).getStraightFlush());
            flush = flush + (collecter.get(i).getFlush());
            onePair = onePair + (collecter.get(i).getOnePair());
            threeOfAKind = threeOfAKind + (collecter.get(i).getThreeOfAKind());
            straight = straight + (collecter.get(i).getStraight());
            high = high + (collecter.get(i).getHigh());

        }         
        System.out.println("Straight Flush       " + straightFlush + "       Percent: " +  straightFlush*10 + "%");
        System.out.println("Flush                " + flush + "       Percent: " +  flush*10 + "%"); 
        System.out.println("One Pair             " + onePair + "       Percent: " +  onePair*10 + "%");    
        System.out.println("Three of a Kind      " + threeOfAKind + "       Percent: " +  threeOfAKind*10 + "%");        
        System.out.println("Straight             " + straight + "       Percent: " + straight*10 + "%");         
        System.out.println("Only High            " + high + "       Percent: " + high*10 + "%");            
    }
}
