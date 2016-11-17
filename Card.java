import java.util.ArrayList;

/** Models a playing card  */
public class Card
{
    
    private String suite;
    private int value;
           
    public Card(int value, String suite)
    {
        this.suite=suite;
        this.value=value;
    }
    
    public String getSuite()
    {
        return suite;
    }
    public int getValue()
    {
        return value;
    }

    public String toString()
    {
        if(value==1)
        {
            String finalCard = "Ace of " + suite;       
            return finalCard; 
        }
        else if(value==11)
        {
            String finalCard = "Jack of " + suite;     
            return finalCard; 
        }
        else if(value==12)
        {
            String finalCard = "Queen of " + suite;     
            return finalCard; 
        }
        else if(value==13)
        {
            String finalCard = "King of " + suite; 
            return finalCard; 
        }       
        String finalCard = value + " of " + suite;
        return finalCard;    
    }
}
