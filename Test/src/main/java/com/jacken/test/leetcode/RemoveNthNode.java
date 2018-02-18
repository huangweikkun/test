package com.jacken.test.leetcode;

/**
 * @author jacken
 * @date 2018/01/28
 */
public class RemoveNthNode {

   public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
  }

  public static ListNode removeNthNode(ListNode head, int n) {
      ListNode start = new ListNode(0);
      ListNode slow = start, fast = start;
      slow.next = head;
      //Move fast in front so that the gap between slow and fast becomes n
      for(int i=1; i<=n+1; i++) { fast = fast.next; }
      //Move fast to the end, maintaining the gap
      while(fast != null) { slow = slow.next; fast = fast.next; }
      //Skip the desired node
      slow.next = slow.next.next;
      return start.next;
  }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode fourth = new ListNode(4);
        third.next = fourth;
        ListNode fifth = new ListNode(5);
        fourth.next = fifth;

        ListNode head = first;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("the head value is:" + removeNthNode(first, 2).val);


    }
}
