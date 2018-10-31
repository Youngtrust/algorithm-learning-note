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

    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

} 