/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationundo;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author clatulip
 */
public class DrawingUndoStackSimulation {
    private Stack<DrawingOp> myOpStack; // ). If a drawingOp is popped off the undone stack, it then needs to be pushed back on to the myOpsStack
    private Stack<DrawingOp> unDone;
    

    public DrawingUndoStackSimulation() {
        myOpStack = new Stack<>();
        unDone = new Stack<>();
        runSimulation();
    }

    /**
     * Randomly creates a new color or drawing operation
     */
    private DrawingOp createNewOp() {
        int opName = (int)(Math.random()*11);
        DrawingOp op = null;
        switch (opName) {
            case 0:
                op = new DrawingOp("Draw Line");
                break;
            case 1:
                op = new DrawingOp("Draw Rectangle");    
                break;
            case 2:
                op = new DrawingOp("Draw Oval");
                break;
            case 3:
                op = new DrawingOp("Draw Curve");
                break;
            case 4:
                op = new ColorOp("Change Line Color", "red");
                break;
            case 5:
                op = new ColorOp("Change Line Color", "blue");
                break;
            case 6:
                op =  new ColorOp("Change Fill Color", "yellow");
                break;
            case 7:
                op =  new ColorOp("Change Fill Color", "black");
                break;
            case 8: 
                op = new LineWidthOp("Change Line Width", 1);
                break;
            case 9: 
                op = new LineWidthOp("Change Line Width", 2);
                break;
            case 10: 
                op = new LineWidthOp("Change Line Width", 5);
                break;
        }
        
        return op;
    }
    
    private void runSimulation() {
        // TO DO:
        // when the switch statement handles a undo (pop) operation, push the drawingOp object that was popped of the myOpsStack onto the undone stack
        // Add a case 6 to the switch statement for redo.
        // add a statement to clear the undone stack to case 2 in the switch statement.
        System.out.println("***Running simulation***");
        int countDown = 30;
        while (countDown > 0) {
            int randStackOp = (int)(Math.random()*7); 
            switch (randStackOp) {
                case 0:
                case 1:
                case 2:
                    // push
                    DrawingOp o = createNewOp();
                    System.out.println(o.getName() + ". Pushed new op on top of stack");
                    myOpStack.push(o);
                    printStack();
                    break;
                case 3:
                    // peek
                    try {
                        DrawingOp p = myOpStack.peek();
                        System.out.println("Peeked, current op at top of stack is:" + p.toString());
                    } catch (EmptyStackException e) {
                        System.out.println("EXCEPTION: Stack is empty, can't peek.");
                    }
                    break;
                case 4: 
                    // pop (Undo Operation)
                    try {
                        DrawingOp q = myOpStack.pop();
                        unDone.push(q); //pushes the popped item onto the undo stack
                        System.out.println("UNDO! Popped, got this off stack:" + q.toString() + " and added pushed it onto the redo stack");
                    } catch (EmptyStackException e) {
                        System.out.println("EXCEPTION: Stack is empty, can't pop.");
                    }
                    printStack();
                    break;
                case 5:
                    // check size
                    System.out.println("Stack size is: " + myOpStack.size());
                    break;
                case 6: 
                    // redo
                    try{
                         DrawingOp q = unDone.pop();
                        myOpStack.push(q);     
                        System.out.println("REDO! Activated, pushed " + q.toString() + " back onto the stack.");
                    } catch (EmptyStackException e){
                        System.out.println("EXCEPTION: Redo Stack is empty, can't undo.");
                    }
                    
            }
            
            countDown--;
        }
    }
    
    public void printStack() {
        System.out.println("\t Printing stack: \n");
        // note that this collections-based for loop prints the collection,
        // but in bottom-to-top order. 
        for (DrawingOp o : myOpStack) {
            System.out.println("\t\t" + o.toString());
        }
        if (myOpStack.empty()) System.out.println("\t\t ***Stack is empty.***");
    }
    
    
}
