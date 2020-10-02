import java.util.Scanner;

public class Tester
{
    //Reminder: USE OF ARRAYLIST IS PROHIBITED AND PROGRAM SHOULD NOT ACCEPT -1 AS AN INPUT

    public static void main(String[] args)
    {
        IntroduceProgram();

        Scanner input = new Scanner(System.in);
        SRAList list = new SRAList(); // Creates double linked list
        int count = 1;

        System.out.println("Enter number of nodes:");
        int numOfNodes = input.nextInt();

        if (numOfNodes > 0 && numOfNodes < 1000000)
        {
            while(count <= numOfNodes)
            {
                System.out.println("Enter input for node " + count);
                int id = input.nextInt();
                String name = input.next();
                double midtermscore = input.nextDouble();
                double finalscore = input.nextDouble();

                CreateNewNode(list, id, name, midtermscore, finalscore);
                count++;
            }

            System.out.println("Enter ID of a node you wish to remove (enter -1 to stop removing nodes): ");
            int victimID = input.nextInt();  //ID of the node we want to remove

            while(victimID != -1)
            {
                list.remove(list.search(victimID));
                System.out.println("Enter ID of a node you wish to remove (enter -1 to stop removing nodes)");
                victimID = input.nextInt();
            }

             /* USED FOR DEBUGGING PURPOSES
             list.printNodes();
             */

            PrintResults(list);
        }

        else
            throw new IllegalArgumentException("Your input is out of range!");

    }

    // Prints the intructions for inputting data
    public static void IntroduceProgram()
    {
        System.out.println("You are currently using the Student Results Analysis Tool");
        System.out.println("Step 1: Enter the number of nodes you'd like to input.The range for the input N is 0 < N < 1000000");
        System.out.println("Step 2: Enter the information for each node in the following format: " +
                "Student ID (Betwen 0 & 1000000), " +
                "Student First Name (Spaces are illegal), " +
                "Midterm Grade (Score out of 60), " +
                "Final Grade (Score out of 40).");
        System.out.println("Step 3: Enter ID of a node you wish to remove from the node list. Enter -1 to stop removing nodes and get analysis results");
        System.out.println();
    }

    // Prints the following: midterm median, final median, the average total, number of students above and below average
    public static void PrintResults(SRAList list)
    {
        System.out.println("The median score of the midterm is: " + list.MedianMidterm());
        System.out.println("The median score of the final is: " + list.MedianFinal());
        System.out.println("The average score is " + list.AverageTotal());
        System.out.println("There are " + list.ComputeAboveAvg() + " students above average");
        System.out.println("There are " + list.ComputeBelowAvg() + " students below average");
    }

    public static void CreateNewNode(SRAList list, int id, String name, double midtermscore, double finalscore)
    {
        Node newNode;
        if (isNodeValid(id, name, midtermscore, finalscore))
        {
            newNode = new Node(id, name, midtermscore, finalscore, null, null);
            list.add(newNode);
        }
        else
            throw new IllegalArgumentException("Node is illegal");
    }

    public static boolean isNodeValid(int id, String name, double midtermscore, double finalscore)
    {
        return (isIDValid(id) && isNameValid(name) && isMidtermValid(midtermscore) && isFinalValid(finalscore));
    }

    public static boolean isIDValid(int id)
    {
        if (id > 0 && id < 1000000)
            return true;
        else
            throw new IllegalArgumentException("ID must be between 0 and 1000000!");
    }

    public static boolean isNameValid(String name)
    {
        if (name.contains(" "))
            throw new IllegalArgumentException("Name cannot contain a space!");

        else
            return true;
    }

    public static boolean isMidtermValid(double midtermscore)
    {
        if (midtermscore >= 0 && midtermscore <= 60)
            return true;
        else
            throw new IllegalArgumentException("Midterm Score must be between 0.0 and 60.0!");
    }

    public static boolean isFinalValid(double finalscore)
    {
        if (finalscore >= 0 && finalscore <= 40)
            return true;
        else
            throw new IllegalArgumentException("Midterm Score must be between 0.0 and 60.0!");
    }
}
