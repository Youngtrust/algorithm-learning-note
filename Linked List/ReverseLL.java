/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
t = a;
a = b;
b = c
c = t
*/ 
class Solution {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode list_to_do = head.next;
        LinkedListNode reversed_list = head;
    
        reversed_list.next = null;

        while (list_to_do != null) {
            LinkedListNode temp = list_to_do;
            list_to_do = list_to_do.next;

            temp.next = reversed_list;
            reversed_list = temp;
        }

    return reversed_list;
    }

} 