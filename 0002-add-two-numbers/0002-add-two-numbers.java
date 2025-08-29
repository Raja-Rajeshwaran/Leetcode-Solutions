class Solution {
    static ListNode head,tail;
    public void create(int data){
        ListNode l=new ListNode(data);
        if(head==null){
            head=l;
            tail=l;
        }
        else{
            tail.next=l;
            tail=l;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        head=null;
        ListNode l=new ListNode();
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null) sum+=l1.val;
            if(l2!=null) sum+=l2.val;
            int digit=sum%10;
            create(digit);
            carry=sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry!=0)
        create(carry);
        return head;
    }
}
