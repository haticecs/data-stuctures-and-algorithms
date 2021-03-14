package Queue;

// FIFO -> First in First Out
public class Queue {

   class Node{
      int data;
      Node next;
      public Node(int data){
         this.data = data;
      }
   }

   Node head; //REMOVE THINGS HERE
   Node tail; //ADD THINGS HERE
   int size = 0;

   public int peek(){
      return head.data;
   }

   public boolean isEmpty(){
      return (head == null);
   }

   public void add(int data){
      //Create new node
      Node newNode = new Node(data);

      //set tail's next to point to new node
      if(tail != null){
         tail.next = newNode;
      }
      //update tail
      tail = newNode;

      //handle the case of first element where head is null
      if(head == null){
         head = tail;
      }
      size++;
   }

   public int remove()
   {
      //if the queue is empty...
      if(head == null){
         tail = null;
         return 0;
      }
      //store the data
      int data = head.data;
      //update head
      head = head.next;
      size --;
      return data;
   }

   public static void main(String[] args) {
      Queue queue = new Queue();
      queue.add(1);
      queue.add(2);
      queue.add(3);
      System.out.println(queue.remove()); //1
      System.out.println(queue.remove()); //2
      System.out.println(queue.size); //1
   }
}