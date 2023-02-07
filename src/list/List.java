/*
 * @Author: Ereflect
 * @Date: 2023-02-05 16:22:54
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2023-02-07 12:18:30
 * @Description: 请填写简介 
 */
class List {
    ListNode head;
    
    public void addToTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
        head = newNode;
        return;
        }
        ListNode p = head;
        while (p.next != null) {
        p = p.next;
        }
        p.next = newNode;
    }
    
    public void deleteNode(int val) {
        if (head == null) return;
        if (head.val == val) {
        head = head.next;
        return;
        }
        ListNode p = head;
        while (p.next != null && p.next.val != val) {
        p = p.next;
        }
        if (p.next != null) {
        p.next = p.next.next;
        }
    }
    }
    