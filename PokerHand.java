import java.util.ArrayList;
public class PokerHand
{
    private ArrayList<Card> theHand;  
    int straightFlush=0;
    int flush=0;
    int onePair=0;    
    int threeOfAKind=0;    
    int straight=0;
    int high=0;           //6 entries atored in order declared below
    /**
     *Constructor, initializes instance variables, creates theHand, 
     *and adds cards to theHand.
     */ 
    public PokerHand(Card card1, Card card2, Card card3)
    {      
        theHand = new ArrayList<>();        
        theHand.add(card1);
        theHand.add(card2);
        theHand.add(card3);  
        //card1, card2, card3
        //Collections.sort(theHand);
    }

    /**
     *Small test, returns a card in the hand
     */
    public Card test()
    {
        return theHand.get(0);
    }

    /**
     *Returns a String value of the hand
     */ 
    public String toString()
    {      
        // return "" + theHand;
        return theHand.get(0).toString()
        + ", " + theHand.get(1).toString()
        + ", " + theHand.get(2).toString();        
    }

    /**
     *Returns the ranking of the PokerHand.
     */
    public String evaluate()
    {
        if(isStraightFlush())
        {
            return "Straight Flush";
        } 
        else if(isFlush())
        {
            return "Flush";
        }
        else if(isOnePair())
        {
            return "Pair";
        }       
        else if(isThreeOfAKind())
        {
            return "Three of a Kind";
        }   
        else if(isStraight())
        {
            return "Straight";
        }

        return "High card: " + isHigh();        //If the hand has ONL a high card

    }

    /**
     *Returns an integer to represent the ranking of the hand.
     */
    public int evaluate2()
    {        
        if(isStraightFlush())
        {
            return 1;
        } 
        else if(isFlush())
        {
            return 2;
        }
        else if(isOnePair())
        {
            return 3;
        }       
        else if(isThreeOfAKind())
        {
            return 4;
        }           
        else if(isStraight())
        {
            return 5;
        }

        if(!isStraightFlush() && !isFlush() && !isOnePair() 
        && !isThreeOfAKind() && !isStraight())
        {
            return 6;      //Since isHigh() would return a String, this tests
        }                 //the other methods to see if the hand only had a high card        
        return 6; //If isHigh() return 9, if no ranking, still isHigh()
    }   

    /**
     *Takes the ranking from evaluate2() and adds 1 to the appropriate variable.
     */
    public int evaluate3()
    {       
        if(evaluate2()==1)
        {
            return ++straightFlush;
        }
        else if(evaluate2()==2)
        {
            return ++flush;
        }
        else if(evaluate2()==3)
        {
            return ++onePair;
        }            
        else if(evaluate2()==4)
        {
            return ++threeOfAKind;
        }           
        else if(evaluate2()==5)
        {
            return ++straight;
        }
        else if(evaluate2()==6)
        {
            return ++high;
        }       
        return 6;
    }

    /**
     *Returns the number of straight flushes dealt
     */
    public int getStraightFlush()
    {
        return straightFlush;
    }

    /**
     *Returns the number of times flush was dealt
     */
    public int getFlush()
    {
        return flush;
    }

    /**
     *Returns the number of pairs
     */
    public int getOnePair()
    {
        return onePair;
    }

    /**
     *Returns the number of times there is three of a kind
     */
    public int getThreeOfAKind()
    {
        return threeOfAKind;
    }

    /**
     *Returns the number of straights
     */
    public int getStraight()
    {
        return straight;
    }

    /**
     *Returns number there was only a high card
     */
    public int getHigh()
    {
        return high;
    }

    /**
     *Returns true if all cards are same suit and are consecutive
     */    
    public boolean isStraightFlush()
    {
        int first=theHand.get(0).getValue();
        int second=theHand.get(1).getValue();
        int third=theHand.get(2).getValue();
        String name1=theHand.get(0).getSuite();
        String name2=theHand.get(1).getSuite();
        String name3=theHand.get(2).getSuite();

        for(Card c:theHand)
        {
            if(first == second + 1 && second == third + 1)
            {
                if(name1.equals(name2) && name1.equals(name3) && name2.equals(name1) 
                && name2.equals(name3) && name3.equals(name1) && name3.equals(name2))
                {               
                    return true;             
                }       
            }

            if(first == third + 1 && third == second + 1)
            {
                if(name1.equals(name2) && name1.equals(name3) && name2.equals(name1) 
                && name2.equals(name3) && name3.equals(name1) && name3.equals(name2))
                {               
                    return true;             
                }       
            }

            if(second == first + 1 && first == third + 1)
            {
                if(name1.equals(name2) && name1.equals(name3) && name2.equals(name1) 
                && name2.equals(name3) && name3.equals(name1) && name3.equals(name2))
                {               
                    return true;             
                }       
            }

            if(second == third + 1 && third == first + 1)
            {
                if(name1.equals(name2) && name1.equals(name3) && name2.equals(name1) 
                && name2.equals(name3) && name3.equals(name1) && name3.equals(name2))
                {               
                    return true;             
                }       
            }

            if(third == first + 1 && first == second + 1)            
            {
                if(name1.equals(name2) && name1.equals(name3) && name2.equals(name1) 
                && name2.equals(name3) && name3.equals(name1) && name3.equals(name2))
                {               
                    return true;             
                }       
            }

            if(third == second + 1 && second == first + 1)
            {               
                if(name1.equals(name2) && name1.equals(name3) && name2.equals(name1) 
                && name2.equals(name3) && name3.equals(name1) && name3.equals(name2))
                {               
                    return true;             
                }                  
            }            
        }
        return false;
    }

    /**
     *Returns true if all cards are same suit
     */    
    public boolean isFlush()
    {       
        String first=theHand.get(0).getSuite();
        String second=theHand.get(1).getSuite();
        String third=theHand.get(2).getSuite();

        for(Card c:theHand)
        {
            if(first.equals(second) && first.equals(third) && second.equals(first) 
            && second.equals(third) && third.equals(first) && third.equals(second))
            {               
                return true;             
            }            
        }
        return false;
    }

    /**
     *Returns true if two cards share values and other 3 are 
     *different values.
     */    
    public boolean isOnePair()  
    {

        int first=theHand.get(0).getValue();
        int second=theHand.get(1).getValue();
        int third=theHand.get(2).getValue();               
        for(Card c:theHand)
        {
            if(first == second && second == first) //Checks possibility of the first two card being a pair
            {
                if(first != third)
                {
                    if(second != third)
                    {
                        return true;
                    }
                }
            }

            else if(first == third && third == first) //Check to see if first and third are a pair
            {
                if(first != second)
                {
                    if(third != second)
                    {
                        return true;
                    }
                }
            }

            else if(second == third && third == second)
            {
                if(second != first)
                {
                    if(third != first)
                    {
                        return true;
                    }
                }
            }     
            else if(first == second && first == third && second == first //A pair is not three of a kind
            && second == third && third == first && third == second)
            {               
                return false;             
            }       
        }
        return false;
    }

    /**
     *Returns true if three cards share values and the other 2
     *are different values.
     */    
    public boolean isThreeOfAKind()
    {        
        int first=theHand.get(0).getValue();
        int second=theHand.get(1).getValue();
        int third=theHand.get(2).getValue();

        for(Card c:theHand)
        {
            if(first == second && first == third && second == first 
            && second == third && third == first && third == second)
            {               
                return true;             
            }            
        }
        return false;
    }     

    /**
     *Returns true if cards are consectutive and share at least
     *2 suites but are not all same suite.
     */    
    public boolean isStraight()
    {
        int first=theHand.get(0).getValue();
        int second=theHand.get(1).getValue();
        int third=theHand.get(2).getValue();

        for(Card c:theHand)
        {
            if(first == second + 1 && second == third + 1)
            {
                return true;
            }

            if(first == third + 1 && third == second + 1)
            {
                return true;
            }

            if(second == first + 1 && first == third + 1)
            {
                return true;
            }

            if(second == third + 1 && third == first + 1)
            {
                return true;
            }

            if(third == first + 1 && first == second + 1)            
            {
                return true;
            }

            if(third == second + 1 && second == first + 1)
            {               
                return true;             
            }            
        }
        return false;       
    }    

    /**
     *Returns highest card     
     */    
    public Card isHigh()
    {       
        int testValue=theHand.get(0).getValue();
        Card finalCard=theHand.get(0);
        for(Card c:theHand)
        {
            if(c.getValue()>testValue)
            {
                testValue=c.getValue();
                finalCard = c;                
            }     
            if(c.getValue() == 1)  //Accounts for Ace
            {
                finalCard=c;
            }
        }    
        return finalCard;
    }

}
