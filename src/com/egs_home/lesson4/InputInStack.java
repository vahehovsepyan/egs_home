package com.egs_home.lesson4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class InputInStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> strings = new Stack<>();
        String text;
        while (true){
            text= scanner.nextLine();
            if (text.isEmpty()){
                break;
            }
            strings.push(text);
        }
        toFile(strings);

        /*while (!strings.empty()){
            String s = strings.peek();
            strings.pop();
            System.out.println(s);
        }*/
    }

    public static void toFile(Stack stack){
        try (FileWriter fw = new FileWriter("OutputFromStack.txt");
             BufferedWriter bW = new BufferedWriter(fw)){
            while (!stack.empty()){
                bW.write(String.valueOf(stack.peek())+"\n");
                stack.pop();
                bW.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
