import java.util.LinkedList;

// Sort a linked list in O(n log n) time using constant space complexity.

// Example 1:

// Input: 4->2->1->3
// Output: 1->2->3->4
// Example 2:

// Input: -1->5->3->4->0
// Output: -1->0->3->4->5

// 题目限定了时间必须为O(nlgn)，符合要求只有快速排序，归并排序，堆排序，而根据单链表的特点，最适于用归并排序
// 于不能通过坐标来直接访问元素，所以快排什么的可能不太容易实现
// 堆排序的话，如果让新建结点的话，还是可以考虑的，若只能交换结点，最好还是不要用。
// 而归并排序（又称混合排序）因其可以利用递归来交换数字，天然适合链表这种结构。

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// 归并排序的核心是一个 merge() 函数，其主要是合并两个有序链表，
// 而归并排序的核心其实是分治法 Divide and Conquer，就是将链表从中间断开，分成两部分，左右两边再分别调用排序的递归函数
// sortList()，
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;

        ListNode firstHalf = sortList(head);
        secondHalf = sortList(secondHalf);

        return merge(firstHalf, secondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;

        while (one != null && two != null) {
            if (one.val <= two.val) {
                prev.next = one;
                prev = one;
                one = one.next;
            } else {
                prev.next = two;
                prev = two;
                two = two.next;
            }
        }

        if (one != null) {
            prev.next = one;
        }

        if (two != null) {
            prev.next = two;
        }

        return dummyHead.next;
    }

}