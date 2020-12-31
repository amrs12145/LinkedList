
package linked_list;

public class LinkedList {

    
    public static void main(String[] args)
    {
        Linked_List obj = new Linked_List();
        
        obj.insertFirst(1);
        obj.insertAt(1,2);
        obj.insertLast(3);
        
        obj.print();
        
    }
}


class Node
{
    int data;
    Node next;

    Node( int data )
    {
        this.data = data;
        this.next = null;
    }
}


class Linked_List
{
    Node Head,Tail;
    int length;
    
    Linked_List()
    {
        Head=Tail=null;
        length=0;
    }
    
    public void insertFirst(int data)
    {
        if ( isEmpty() )
        {
            Node n = new Node(data);
            Head=Tail=n;
            length++;
        }
        else
        {
            Node n = new Node(data);
            n.next = Head;
            Head = n;
            length++;
        }
    }
    
    public void insertLast(int data)
    {
        if( isEmpty() )
        {
            Node n = new Node(data);
            Head=Tail=n;
            length++;
        }
        else
        {
            Node n = new Node(data);
            Tail.next = n;
            Tail = n;
            length++;
        }
    }
    
    public void insertAt(int pos ,int data)
    {
        Node ptr = Head;
        
        if ( pos <= length && pos>=0 )
        {
            if ( pos==0 )
            {
                insertFirst(data);
            }
            else if ( pos == length )
            {
                insertLast(data);
            }
            else
            {
                for( int i=1; i < pos ;i++)
                {
                    ptr = ptr.next;
                }
                Node n = new Node(data);
                n.next = ptr.next;
                ptr.next = n;
                length++;
                
            }
        }
    }
    
    
    public void print()
    {
        Node cur= Head;
        
        while( cur !=null )
        {
            System.out.println( cur.data  );
            cur = cur.next;
        }
        
    }
    
    
    
    
    
    boolean isEmpty()
    {
        return length==0;
    }
}




