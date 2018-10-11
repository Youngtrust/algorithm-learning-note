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
    public static void main(String[] args) {
  
      //test 1
      {
        int[] list1 = {3, 1, 3, 4, 3, 0};
        int[] list1_expected = {3, 1, 4, 0};
        
        LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
        LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);
        
        System.out.print("Original: ");
        LinkedList.display(list_head1);
        list_head1 = remove_duplicates(list_head1);
        
        System.out.print("After removing duplicates:");
        LinkedList.display(list_head1);
      }
  
      // test2
      {
        int[] list1 = {3, 3, 3, 3, 3, 5};
        int[] list1_expected = {3, 5};
        LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
        LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);
        
        System.out.print("Original: ");
        LinkedList.display(list_head1);
        list_head1 = remove_duplicates(list_head1);
        
        System.out.print("After removing duplicates:");
        LinkedList.display(list_head1);
      }
  
      // test3
      {
        int[] list1 = {1};
        int[] list1_expected = {1};
        LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
        LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);
        
        System.out.print("Original: ");
        LinkedList.display(list_head1);
        list_head1 = remove_duplicates(list_head1);
        
        System.out.print("After removing duplicates:");
        LinkedList.display(list_head1);
      }
  
      // test4
      {
        int[] list1 = {1, 2, 3, 3};
        int[] list1_expected = {1, 2, 3};
        LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
        LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);
        
        System.out.print("Original: ");
        LinkedList.display(list_head1);
        list_head1 = remove_duplicates(list_head1);
        
        System.out.print("After removing duplicates:");
        LinkedList.display(list_head1);     
      }
    }
  }  