/* 
 * Implementing a stack using an array. I.e not using the Java API
 */

 /*
  * Stack only allows retrieval from the front. 
  * Insertion should push the other values down/further away from the front of the array
  * What is the maximum size of the stack
  * What is the data structure of the stack. Could be Strings or integers or Object
  */


public class MyStack {
  private int array[];
  private int top;
  private int capacity;

  public MyStack(int capacity) {
    //initialising the stack according to the parameters provided. i.e. maximum capacity of stack should be the size of the array
    this.array = new int[capacity];
    this.top = -1;
    this.capacity = capacity;
  }

  //Creating a push method. This should add a value to the front of the array and reset the top to point to the item that followed the popped/removed item
  public void push(int item){
    if(isFull()){
      throw new RuntimeException("Stack is Full..." );
    }
    array[++top] = item;
  }

  private boolean isFull() {
    if(top == capacity-1){
      return true;
    }
    return false;
  }

  //Creating the pop method. This should take the item at the front of the array and reset the top to point to the new value
  public int pop(){
    if(isEmpty()){
      throw new RuntimeException("Stack is Empty..." );
    }
    return array[top--];
  }

  private boolean isEmpty() {
    if(top == -1){
      return true;
    }
    return false;
  }

  //Creating a peek method which just check which value is at the front without removing it. I.e. Which item is top pointing to?
  public int peek(){
    return array[top];
  }

  public static void main(String[] args) {
    MyStack myStack = new MyStack(3);

    myStack.push(4);
    myStack.push(3);
    myStack.push(2);
    // System.out.println( myStack.pop());
    // System.out.println( myStack.pop());
    System.out.println(myStack.peek());
    myStack.push(1);
  }
}
