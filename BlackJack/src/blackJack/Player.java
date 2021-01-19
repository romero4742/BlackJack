package blackJack;

public class Player 
{
    protected int credits;
    protected String name;
    protected Hand hand;
    protected int currentBet;
    
   public Player()
   {
      this.name = "Player";
      this.credits = 100;
      hand = new Hand();
   }
 
   public void setCredits(int credits)
   {
      this.credits = credits;
   }
   
   public int currentBet()
   {
      return currentBet;
   }
   
   public int getCredits()
   {
       return credits;
   }
   public void addCredits(int credits)
   {
      this.credits += credits;
   }
   public void subtractCredits(int credits)
   {
      currentBet = credits;
      this.credits = this.credits - credits;
   }
   public void setName(String name)
   {
      name = name.replace(" ","");
      if(name.length() == 0)
      {
         this.name = "Player";
         return;
      }
      this.name = name;
   }
   public String getName()
   {
      return name;
   }
}


