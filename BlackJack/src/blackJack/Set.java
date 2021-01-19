package blackJack;

class Set<T>
{
	protected int size;
	protected Node<T> head;
	
	public Set()
	{
	   head = new Node<T>(null,null);
	   size = 0;
	}
	
	
	   /**
	    * This method prints out the data stored in a set.
	    * 
	    */
	   
	   public String printElements()
	   {
              int counter = 0;
	      Node<T> n = head.getNext();
	      String str = "";
	      while(n != null)
	      {
	         str += String.valueOf(n.data);
                 counter++;
	         if(n.next != null)
		    str += ", ";
                 if(counter %10 == 0)
                     str +="\n";
	         n = n.next;
	      }
              System.out.println("\n\nThere are "+counter+" cards");
	      return str;
	   }
	   
	public void cutFrom(int target)
        {
           Node<T> targetNode = head.getNext();
           for(int i = 1; i < target; i++)
           {
              targetNode = targetNode.getNext();
           }
           Node<T> temp = targetNode.getNext();
           targetNode.setNext(null);
           Node<T> prevHead = head.next;
           head.setNext(temp);
           while(temp.getNext() != null)
           {
              temp = temp.getNext();
           }
           temp.setNext(prevHead);
        }
           
	public boolean addElement(T newData)
	{
	   if(size == 0)
	   {
	      Node<T> newNode = new Node<T>(newData,null);
	      head.next = newNode;
	      size++;
	      return true;
	   }
	   Node<T> newNode = new Node<T>(newData,head.next);
	   head.next = newNode;
           size++;
	   return true;
	}
	public int size()
	{
		return size;
	}

}

class Node<T>
{
   protected T data;
   protected Node<T> next;
      
   public Node(T data, Node<T> next)
   {
      this.data = data;
      this.next = next;
   } 
   public void setNext(Node<T> node)
   {
      next = node;
   }
   public void setData(T data)
   {
      this.data = data;
   }
   public T getData()
   {
      return data;
   }
   public Node<T> getNext()
   {
      return next;
   }
   public String toString()
   {
      return String.format("%s  %s", data,next);
   }
}