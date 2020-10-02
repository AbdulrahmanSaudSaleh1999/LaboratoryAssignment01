public class SRAList
{
    //Reminder: USE OF ARRAYLIST IS PROHIBITED AND PROGRAM SHOULD NOT ACCEPT -1 AS AN INPUT

    private Node head;      //stores Reference to Head of the list
    private Node tail;      //stores Reference to Tail of the list
    private int size = 0;   //current size

    public SRAList() { }

    public int size() {return size;}
    public boolean isEmpty() { return size==0; }

    //searches for first occurrence of ID and return reference to the node
    public Node search(int id)
    {
        if (isEmpty())
        {
            throw new NullPointerException("The list is empty!");
        }

        else if (id <= 0 && id >= 1000000)
        {
            throw new IllegalArgumentException("ID must be between 0 and 1000000!");
        }

        else
        {
            Node temp = head;
            while (temp != null)
            {
                if (temp.getID() == id)
                    return temp;

                temp = temp.getNext();
            }
        }

        return null; //if not found
    }

    //attach Node N to the appropriate position in List (at the start of the list)
    public Node add(Node N)
    {
        if(isEmpty()) // if list is empty, the new node will be the tail and head
        {
            head = N;
            tail = N;
        }

        else if (search(N.getID())!=null)
        {
            throw new IllegalArgumentException("There already exists a node with the same ID!");
        }

        else
        {
            head.setPrev(N);
            N.setNext(head);
            head = N;
        }

        size++;
        return N;
    }

    //removes Node N from List
    public void remove(Node N)
    {
        if (isEmpty())
        {
            throw new NullPointerException("The list is empty!");
        }

        else if (N == null) // if the node doesnt exist in the list, then print message
        {
            System.out.println("The input node does not exist in the list!");
        }

        else
        {
            Node temp = search(N.getID());

            if (size == 1)
            {
                head = null;
                tail = null;
            }

            else if (temp == head)       // if the Node we want to remove is the head, we set the new head as the node after it
            {
                head = head.getNext();
                head.setPrev(null);
            }

            else if (temp == tail)  // if the Node we want to remove is the tail, we set the new tail as the node before it
            {
                tail = tail.getPrev();
                tail.setNext(null);
            }

            else // if the Node is in between the head and tail
            {
                Node successor = temp.getNext();
                Node predecessor = temp.getPrev();

                successor.setPrev(predecessor);
                predecessor.setNext(successor);

                temp.setNext(null);
                temp.setPrev(null);
            }

            size--;
        }
    }

    //Sorts list in an ascending order based on midterm scores using selection sort
    public void sortMidterm()
    {
        if (isEmpty())
        {
            throw new NullPointerException("The list is empty!");
        }

        else
        {
            Node current, index;
            double temp;

            for (current = head; current.getNext() != null; current = current.getNext())
            {
                for (index = current.getNext(); index != null; index = index.getNext())
                {
                    //If current's data is greater than index's data, swap the data of current and index
                    if (current.getMidtermscore() > index.getMidtermscore())
                    {
                        temp = current.getMidtermscore();
                        current.setMidtermscore(index.getMidtermscore());
                        index.setMidtermscore(temp);
                    }
                }
            }
        }
    }

    //Sorts list in an ascending order based on final scores using selection sort
    public void sortFinal()
    {
        if (isEmpty())
        {
            throw new NullPointerException("The list is empty!");
        }

        else
        {
            Node current, index;
            double temp;

            for (current = head; current.getNext() != null; current = current.getNext())
            {
                for (index = current.getNext(); index != null; index = index.getNext())
                {
                    //If current's data is greater than index's data, swap the data of current and index
                    if (current.getFinalscore() > index.getFinalscore())
                    {
                        temp = current.getFinalscore();
                        current.setFinalscore(index.getFinalscore());
                        index.setFinalscore(temp);
                    }
                }
            }
        }
    }

    //Pointer method
    public Node MedianPointer()
    {
        Node pointer = head;

        if (size > 2)
        {
            int count = size/2;
            while (count!=0)
            {
                pointer = pointer.getNext();
                count--;
            }
        }

        return pointer;
    }

    //Orders List and returns the Median of MidTerm scores
    public double MedianMidterm()
    {
        sortMidterm();
        Node median = MedianPointer();

        if (size == 1)
            return head.getMidtermscore();
        else if (size%2==0)
            return (median.getMidtermscore() + median.getNext().getMidtermscore()) / 2;
        else
            return median.getNext().getMidtermscore();
    }

    //Orders List and returns the Median of Final scores
    public double MedianFinal()
    {
        sortFinal();
        Node median = MedianPointer();

        if (size == 1)
            return head.getFinalscore();
        if (size%2==0)
            return (median.getFinalscore() + median.getNext().getFinalscore()) / 2;
        else
            return median.getNext().getFinalscore();
    }

    //Computes and returns the Average of Total score
    public double AverageTotal()
    {
        Node current = head;
        double sum = 0.0;
        while (current != null)
        {
            sum += current.getMidtermscore() + current.getFinalscore();
            current = current.getNext();
        }
        return (sum)/size;
    }

    //Computes and returns Number of students above average (total score)
    public int ComputeAboveAvg()
    {
        int count = 0;
        double average = AverageTotal();
        Node current = head;

        while (current!=null)
        {
            if (current.getMidtermscore() + current.getFinalscore() > average)
                count++;
            current = current.getNext();
        }

        return count;
    }

    //Computes and returns Number of students below average (total score)
    public int ComputeBelowAvg()
    {
        int count = 0;
        double average = AverageTotal();
        Node current = head;

        while (current!=null)
        {
            if (current.getMidtermscore() + current.getFinalscore() < average)
                count++;
            current = current.getNext();
        }

        return count;
    }

    // USED FOR DEBUGGING PURPOSES
    public void printNodes()
    {
        Node current = head;
        while (current!=null)
        {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
