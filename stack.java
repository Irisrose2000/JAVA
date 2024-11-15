import java.util.Scanner;
class Stack
{
    private int stackSize;
    private int[] stackArray;
    private int top;
    public Stack(int size)
    {
        this.stackSize=size;
        this.stackArray=new int[stackSize];
        this.top=-1;
    }
        public void push(int value) {
        if (top == stackSize - 1) {
            System.out.println("Stack is full. Cannot push.");
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " to the stack.");
        }
    }

    public void pop()
    {
        if(top==-1)
        {
            System.out.println("stack is empty");
        }
        else
        {
           int value=stackArray[top--];
            System.out.println("the element is poped\n");
        }
    }
       public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

}
public class Main
{
    public static void main(String[]args)
    {
        int choice;
        Scanner scan =new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scan.nextInt();
        Stack stack = new Stack(size);

        do
        {
            System.out.println("choose the option");
            System.out.println("1.push\t2.pop\t3.display\t4.exit\n");
             choice =scan.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("enter the value\n");
                    int value =scan.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("exiting...\n");
                    break;
                default:
                System.out.println("Invalid choice\n");
                break;
                    
            }
        }while(choice<4);
    }
}
