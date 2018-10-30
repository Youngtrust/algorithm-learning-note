//We are given a linked list of integers and we have to remove all the duplicate nodes from it by keeping only the first occurrence of each duplicate. The following example elaborates it further.

//use hash set
class removeDuplicate{
    public static LinkedListNode remove_duplicates(LinkedListNode head) 
    {
      if (head == null) {
        return head;
      }
  
      // Let's track list values in a hash table.
      HashSet<Integer> dup_set = new HashSet<Integer>();
      LinkedListNode curr = head;
      dup_set.add(curr.data);
  
      while (curr.next != null) {
        if (!dup_set.contains(curr.next.data)) {
          // Element not found in map, let's add it.
          dup_set.add(curr.next.data);
          curr = curr.next;
        } 
        else {
          // Duplicate node found. Let's remove it from the list.
          curr.next = curr.next.next;
        }
      }
      return head;
    }
  }  