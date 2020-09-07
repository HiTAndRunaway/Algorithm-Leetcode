/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stackL1 = new Stack<>();
        Stack<Integer> stackL2 = new Stack<>();
        while(l1 != null){
            stackL1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stackL2.push(l2.val);
            l2 = l2.next;
        }
        int nafla = 0;
        ListNode AdalaxiL = null;
        while(!stackL1.isEmpty() || !stackL2.isEmpty() || nafla > 0){
            int x = (stackL1.isEmpty()) ? 0 : stackL1.pop();
            int y = (stackL2.isEmpty()) ? 0 : stackL2.pop();
            int sum = x + y + nafla;
            ListNode node = new ListNode(sum % 10);
            node.next = AdalaxiL;
            AdalaxiL = node;
            nafla = sum / 10;
        }
        return AdalaxiL;
    }
}