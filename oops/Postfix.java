import java.util.*;
class Stack 
{
    private int stk []=new int[100];
    private int top=-1;
    public void push(int ele)
    {
        if(!isFull())
        {
            stk[++top]=ele;
        }
        else
        {
            return;
        }
    }

    public int pop()
    {
        if(!isEmpty())
        {
            int d=stk[top];
            top--;
            return d;
        }
        else
        {
            return 0;
        }
    }
    public boolean isEmpty()
    {
        if(top==-1)
        {
            return true;
        }
        return false;
    }

    public boolean isFull()
    {
        if(top==100)
        {
            return true;
        }
        return false;
    }
}

public class Postfix {


        public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter postfix: ");
        String str = sc1.nextLine();
        int i;
        int n1,n2;
        Stack stack = new Stack();
        String[] splt = str.split(" ");
        for (String ele : splt) {
            try {
                i = Integer.parseInt(ele);
                stack.push(i);
            } catch (NumberFormatException e) {
                switch(ele)
                {
                    case"+":
                    n1=stack.pop();
                    n2=stack.pop();
                    stack.push(n2+n1);
                    break;
                    case"-":
                    n1=stack.pop();
                    n2=stack.pop();
                    stack.push(n2-n1);
                    break;
                    case"*":
                    n1=stack.pop();
                    n2=stack.pop();
                    stack.push(n2*n1);
                    break;
                    case"/":
                    n1=stack.pop();
                    n2=stack.pop();
                    stack.push(n2/n1);
                    break;
                    default:
                    System.out.println("invalid operation ");
                }
            }
        }
        System.out.println("Ans= "+stack.pop());
        
    }
}
