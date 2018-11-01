/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.
 */

/*
t = a;
a = b;
b = c
c = t
*/ 
class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n){
        if(m >= n || head == null){
            return head;
        }

        //dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i = 1; i< m; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        ListNode preNode = head;
        ListNode mNode = head.next;
        List nNode = mNode, postnNode = mNode.next;

        for(int i = m; i < n; i++){
            if(postnNode == null){
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;

        return dummy.next;

    }
} 

//--------------------------------------------------------------------------------

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
         if(head == null) return null;
         ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
         dummy.next = head;
         ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
         for(int i = 0; i<m-1; i++) pre = pre.next;
 
         ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
         ListNode then = start.next; // a pointer to a node that will be reversed
 
         // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
         // dummy-> 1 -> 2 -> 3 -> 4 -> 5
 
         for(int i=0; i<n-m; i++)
         {
             start.next = then.next;
             then.next = pre.next;
             pre.next = then;
             then = start.next;
         }
 
         // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
         // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
 
         return dummy.next;
 
     }
 }