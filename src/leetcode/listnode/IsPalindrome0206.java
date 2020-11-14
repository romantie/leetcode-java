package leetcode.listnode;

/**
 * 判断一个链表是否回文，中间往后反转链表
 */
public class IsPalindrome0206 {

    public static boolean idpalindrome(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //先通过快慢指针，找到中间节点
        ListNode frist = dummy;
        ListNode sec = dummy;
        while(sec!=null && sec.next!=null){
            frist = frist.next;
            sec = sec.next.next;
        }
        //找到中间节点后
        //反转中间节点之后的链表
        ListNode reverseHead = reverse(frist.next);
        while (reverseHead!=null){
            if(reverseHead.val != head.val){
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;

    }

    public static ListNode reverse(ListNode head){
        ListNode newNode = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }
}
