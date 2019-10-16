package Syntax.Generic;

public class Stack<T>{
    final int size;
    T[] items;
    int top;

    public Stack(int size){
        this.size = size > 0 ? size : 10;
        items = (T []) new Object[size];
        top = -1;
    }

    public void push(T item){
        if(top == size -1)
    }

    public T pop(){
        return items[top];
    }
}