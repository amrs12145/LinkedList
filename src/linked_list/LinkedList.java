
package linked_list;

public class LinkedList {

    
    public static void main(String[] args)
    {
        Linked_List obj = new Linked_List();
        
        obj.insertFirst(1);
        obj.insertAt(1,2);
        obj.insertLast(3);
        obj.removeLast();
        obj.print();
        System.out.println( obj.search(3) );

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
        Node cur = Head;
        
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
                    cur = cur.next;
                }
                Node n = new Node(data);
                n.next = cur.next;
                cur.next = n;
                length++;
                
            }
        }
    }
    
    
    public void removeFirst()
    {
        if ( !isEmpty() )
        {
            Head = Head.next;
            length--;
        }
        else
        {
            System.out.println("Empty LinkedList");
        }
    }
    
    
    public void removeLast()
    {
        if ( !isEmpty() )
        {
            Node cur = Head;
            
            
            while( cur.next.next !=null )
            {
                cur = cur.next;
            }            
            /*    //  IF U HAVE THE LENGTH
            for( int i=1; i<length-1 ;i++ )
            {
                cur = cur.next;
            }
            */
            
            Tail = cur;
            Tail.next = null;
            length--;
        }
        else
        {
            System.out.println("Empty LinkedList");
        }
    }
    
     public void removeAt(int pos)
    {
        Node cur = Head;
        
        if ( pos <= length-1 && pos>=0 )
        {
            if ( pos==0 )
                removeFirst();
            else if ( pos == length-1 )
                removeLast();
            else
            {
                
                for ( int i=1; i < pos ;i++ )
                {
                    cur = cur.next;
                }
                
                cur.next = cur.next.next;
                length--;
                
                
            }
        }
        else
        {
            System.out.println("Error while removing At");
        }
    }
    
    
    
     
    public int search(int data)
    {
        Node cur = Head;
        int pos =0;
        while( cur !=null )
        {
            if( cur.data == data )
                return pos;
            cur = cur.next;
            pos++;
        }
    return -1;
    }
    
    
     
    public int getHead()
    {
        return Head.data;
    }
    public int getLast()
    {
        return Tail.data;
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
    
    
    
    
    boolean checkSize()
    {
        Node cur = Head;
        int c=0;
        while( cur.next!=null )
        {
            c++;
            cur = cur.next;
        }
        
        return length == (c+1);
    }
    boolean isEmpty()
    {
        return length==0;
    }
}




