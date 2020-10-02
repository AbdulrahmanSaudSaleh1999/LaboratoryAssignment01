import java.util.Scanner;

public class Tester
{
    //Reminder: USE OF ARRAYLIST IS PROHIBITED AND PROGRAM SHOULD NOT ACCEPT -1 AS AN INPUT

    public static void main(String[] args)
    {
        SRAList list = new SRAList();

        Node o1 = new Node(201, "Mohammad", 45, 30, null, null);
        //Node o2 = new Node(209, "Ahmed", 38, 22, null, null);
        Node o3 = new Node(203, "Saleh", 45, 38, null, null);
        //Node o4 = new Node(202, "Sarah", 47, 33, null, null);

        list.add(o1);
        //list.add(o2);
        list.add(o3);
        //list.add(o4);

        System.out.println(o1.toString());
        //System.out.println(o2.toString());
        System.out.println(o3.toString());
        //System.out.println(o4.toString());
        System.out.println();
        System.out.println(list.MedianMidterm());
        System.out.println(list.MedianFinal());
        System.out.println(list.AverageTotal());
        System.out.println(list.ComputeAboveAvg());
        System.out.println(list.ComputeBelowAvg());
    }
}
