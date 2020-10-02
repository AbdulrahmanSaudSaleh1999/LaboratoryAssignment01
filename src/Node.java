public class Node
{
    //Reminder: USE OF ARRAYLIST IS PROHIBITED AND PROGRAM SHOULD NOT ACCEPT -1 AS AN INPUT

    private int id;                 //stores ID of student
    private String name;            //only first name, spaces are not allowed
    private double midtermscore;    //score out of 60
    private double finalscore;      //score out 40
    private Node next;              //pointer to next node
    private Node prev;              //pointer to previous node

    public Node()
    {
        setID(0);
        setName("");
        setMidtermscore(0.0);
        setFinalscore(0.0);
        setNext(null);
        setPrev(null);
    }

    public Node(int id, String name, double midtermscore, double finalscore, Node next, Node prev)
    {
        setID(id);
        setName(name);
        setMidtermscore(midtermscore);
        setFinalscore(finalscore);
        setNext(next);
        setPrev(prev);
    }

    public int getID() { return id; }
    public void setID(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMidtermscore() { return midtermscore; }
    public void setMidtermscore(double midtermscore) { this.midtermscore = midtermscore; }

    public double getFinalscore() { return finalscore; }
    public void setFinalscore(double finalscore) { this.finalscore = finalscore; }

    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }

    public Node getPrev() { return prev; }
    public void setPrev(Node prev) { this.prev = prev; }

    // USED FOR DEBUGGING PURPOSES
    public String toString()
    {
        return (id + " " + name + " " + midtermscore + " " + finalscore);
    }


}
