public class DoublyLinkedList {
    static Node head;

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){

            data=d;
            prev=next=null;

        }

    }

    static void addFront(int n) {


        if (head == null) {
            Node newNode = new Node(n);

            newNode.next=null;
            newNode.prev=null;
            head=newNode;

        }

        else{

            Node newNode=new Node(n);

            newNode.next=head;
            head.prev=newNode;
            newNode.prev=null;
            head=newNode;
        }

    }

    static void addEnd(int d) {

        Node iterator=head;
        while(iterator.next!=null) {
            iterator=iterator.next;
        }
       Node newNode=new Node(d);

        iterator.next=newNode;
        newNode.next=null;
        newNode.prev=iterator;

    }
//-----------------------------------------------------------------------------------------------------

    static Node[] oncekiSonrakiNodeBul(){
        Node iterator=head;
        Node[]references=new Node[2];
        while(iterator.next!=null){
            if(iterator.data==1){
                references[0]=iterator;
                references[1]=iterator.next;
            }
            iterator=iterator.next;
        }

    return references;}


    static void bulVeEkleReference(Node[]references,int data) {

        Node onceki=references[0];
        Node sonraki=references[1];
        Node orta=new Node(data);
        orta.next=sonraki;
        orta.prev=onceki;

        onceki.next=orta;
        sonraki.prev=orta;

    }

 //----------------------------------------------------------------------------------------------------------
    static void bulVeArdındanEkle(int sonrasınaEklenecekOlan,int data) {

        Node iterator=head;
        while(iterator.next!=null) {

            if(iterator.data==sonrasınaEklenecekOlan) {
                Node newNode=new Node(data);

                newNode.next=iterator.next;
                iterator.next=newNode;
                iterator.next.prev=newNode;
                newNode.prev=iterator;
            }
            iterator=iterator.next;
        }
    }


    static void sondanSil() {

        Node iterator=head;
        while(iterator.next.next!=null) {iterator=iterator.next;}
        iterator.next=null;
        
    }


    static void bastanSil(){

        head=head.next;
        head.prev=null;
    }

    static void bulVeOrtalardanSil(int silinecekNodunDatası) {

        Node iterator=head;
        while(iterator.next.data!=silinecekNodunDatası) {
            iterator=iterator.next;
        }
        iterator.next.next.prev=iterator;
        iterator.next=iterator.next.next;

    }

    static Node sonNodunRefi() {

        Node iterator = head;
        while(iterator.next!=null) iterator=iterator.next;

        return iterator;
    }

    static void reverseTraverse(Node end){

        Node End=end;
        while(End!=null) {

            System.out.println(End.data);
            End=End.prev;
        }
    }

    static void print() {

        Node pnode=head;
        while(pnode!=null) {
            System.out.println(pnode.data);
            pnode=pnode.next;
        }
    }




    public static void main(String[] args) {

        addFront(7);
        addFront(5);
        addFront(2);
        bulVeOrtalardanSil(5);
        addFront(1);
        addFront(4);
        bulVeArdındanEkle(4, 3);
        addEnd(8);
        sondanSil();
        bastanSil();

        bulVeEkleReference(oncekiSonrakiNodeBul(),0);
        print();

        System.out.println("-----");
        reverseTraverse(sonNodunRefi());

    }
}