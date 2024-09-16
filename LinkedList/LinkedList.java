public class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size; //for size calculation

    public void addFirst(int data){
        //Step1 = create new node
        Node newNode = new Node(data);
        size++; 
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 - newNode next = head
        newNode.next = head; //link

        // step3 - head = newNode
        head = newNode; 
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++; 
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

   
   //Add mid in the linkedlist
    public void addMid(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;  //for size calculation
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        //i = idx-1 temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }


    //Remove First in LinkedList
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }


    //Remove Last in LinkedList
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
    
        // prev: i = size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    
    //Search(Iterative)
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        //key not FoUnd
        return -1;
    }

    //Search(Recursive) //O(n)
    public int helper(Node head, int key){ //helper function for recursive search.
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    //Reverse a linkedlist (iterative approach)
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Find and remove nth Node from End (--amazone--flipkart--adobe--qualcomm)
    public void deleteNthfromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next; // remove first
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public static void main(String[] args){
        LinkedList ll =  new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addMid(2, 9);
        ll.print();
        ll.deleteNthfromEnd(3);
        ll.print();

    }
}

