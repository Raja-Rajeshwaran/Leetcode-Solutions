class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode(0);
        ListNode dummy=head;
        while(list1!=null && list2!=null){
            int data1=list1.val;
            int data2=list2.val;
            if(data1<data2){
                head.next=list1;
                list1=list1.next;
            }
            else if(data1>data2){
                head.next=list2;
                list2=list2.next;
            }
            else if(data1==data2){
                 head.next=list1;
                 list1=list1.next; 
                 head=head.next;
                 head.next=list2; 
                 list2=list2.next;
            }
            head=head.next;
        }
        if(list1!=null) head.next=list1;
        if(list2!=null) head.next=list2;
        return dummy.next;
    }
}