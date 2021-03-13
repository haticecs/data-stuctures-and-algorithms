package HashTable;

//HashTable are basically array of linked lists.
//Super fast lookups
public class HashTable {

   private static int INITIAL_SIZE = 16;
   private static HashEntry[] data; //Array

   //Linked List representation 
   static class HashEntry{
      String key;
      String value;
      HashEntry next;
        public HashEntry(String key, String value){
           this.key = key;
           this.value = value;
           this.next = null;
        }
   }

   //Constructor for Hash Table
   public HashTable(){
      data = new HashEntry[INITIAL_SIZE];
   }

   public void put(String key, String value){
      //Get the index
      int index = getIndex(key);

      //Create the linked list entry
      HashEntry entry = new HashEntry(key, value);

      //If no entry there - add it
      if(data[index] == null){
         data[index] = entry;
      }
      //Else handle collision by adding to the end of the list.
      else{
         HashEntry entries = data[index];
         //walk to the end
         while(entries.next != null){
            entries = entries.next;
         }
         //add our new entry there
         entries.next = entry;
      }
   }
   public String get(String key){
      //Get the index
      int index = getIndex(key);

      //Get the current list of entries{}
      HashEntry entries = data[index];

      //walk in the chain until find a match
      while(entries != null){
         if(entries.key.equals(key)){  //check for match
            return entries.value;      //if match found, return it
         }
         entries = entries.next;       //else go to next node in the chain
      }
      //if we have no entries against this key
      return null;
   }

   public int getIndex(String key) {
         // Get the hash code from Java's built in function
         //It is the number representation of an string.
        int hashCode = key.hashCode();
        //System.out.println("hash code: " + hashCode);
        // Convert to index
        //% operator enables smaller array.
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee") || key.equals("Tim Lee")) {
            index = 4;
        }

        //System.out.println("index: " + index);
        return index;
   }
   
   public static void main(String[] args) {
      HashTable hashTable = new HashTable();
      hashTable.put("John Smith", "521-1234");
      hashTable.put("Lisa Smith", "521-8976");
      hashTable.put("Sam Doe", "521-5030");
      hashTable.put("Sandra Dee", "521-9655");
      hashTable.put("Ted Baker", "418-4165");
      System.out.println(hashTable.get("John Smith"));
      System.out.println(hashTable.get("Lisa Smith"));
      System.out.println(hashTable.get("Sam Doe"));
      System.out.println(hashTable.get("Sandra Dee"));
      System.out.println(hashTable.get("Ted Baker"));
   }
}