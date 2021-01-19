package blackJack;

class Hand 
{
   protected int size;
   protected Card [] cardsInHand;
   protected int value,aces;
   protected boolean aceInHand,valueOfAce;
   public Hand()
   {
      aceInHand = false;
      valueOfAce = false;
      size = 0; 
      value = 0;
      aces = 0;
      cardsInHand = new Card[5];
   }
   public int getSize()
   {
      return size;
   }
   /**
    * Ace in hand is set to true if at least one ace is hand.
    * valueOfAce is set to true if the value of the one ace is set to 11
    * the valueOfAce is set to false if 11 will cause the player to lose...
    * if so the value of hand is decremented by 10 setting all aces to have 
    * values of 1's
    */
   public void addCard(Card c)
   {
      cardsInHand[size] = c;    
      if(c.number == 1)
      {
         if(aceInHand)
         {
             value += 1;
         }
         else 
         {
            value += 11;
            aceInHand = true;
            valueOfAce = true;
         }
      }
      else
        value = value + c.value;
      size++;
   }
   public void resetHand()
   {
      size = 0;
      value = 0;
      aceInHand = false;
      valueOfAce = false;
   }
   public boolean checkWin()
   {
      return value == 21;
   }
   public boolean checkLose()
   {
      if(value > 21)
      {
         if(valueOfAce)
         {
            value = value -10;
            valueOfAce = false;
         }
      }
      return value > 21;
   }
}