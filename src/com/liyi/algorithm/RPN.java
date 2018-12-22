package com.liyi.algorithm;


import java.util.Stack;

public class RPN {
    public static void main(String[] args) {
        //测试用例
        //String str = "1+2*3-4*5-6+7*8-9"; //123*+45*-6-78*+9-
        String str = "a*(b-c*d)+e-f/g*(h+i*j-k)"; // abcd*-*e+fg/hij*+k-*-
        //String str = "6*(5+(2+3)*8+3)"; //6523+8*+3+*
        //String str = "a+b*c+(d*e+f)*g"; //abc*+de*f+g*f

        Stack<Character> operators = new Stack<>(); //运算符
        Stack output = new Stack(); //输出结果
        parsePRN(operators, output, str);
        System.out.println(output);
    }


    public static void parsePRN(Stack<Character> operator ,Stack numbers,String str){
        if(str.length() == 0) return ;
        int len = str.length();
        boolean isNumber = Boolean.FALSE;
        for(int i =0;i<len;){
            isNumber = Boolean.FALSE;
            int index =i;
            while(i<len && !isOperator(str.charAt(i))){
                isNumber=Boolean.TRUE;
                i++;
            }
            if(isNumber){
                numbers.push(str.substring(index,i));
            }else{
                char c = str.charAt(i++);
                if(c == '('){
                    operator.push(c);
                }else if(c == ')'){
                    //只要能进来，就一定是)，经过while一顿操作，peek剩下( ,需要弹出
                    while(!operator.empty() && operator.peek()!='('){
                        numbers.push(operator.pop());
                    }
                    if(!operator.empty()){
                        operator.pop();
                    }
                }else{
                    while(!operator.empty() && operator.peek() != '(' && compareOperator(operator.peek(),c) >=0){
                        numbers.push(operator.pop());
                    }
                    operator.push(c);
                }
            }

        }
        while(!operator.empty()){
            numbers.push(operator.pop());
        }
    }


    enum Operator{
        ADD('+',1),
        SUB('-',1),
        MUL('*',2),
        DIV('/',2),
        LEFT('(',3),
        RIGHT(')',3);
        char type;
        int value;
        Operator(char type ,int value){
            this.type =type;
            this.value=value;
        }
    }
    public static boolean isOperator(char c){
        for(Operator tempC: Operator.values() ){
            if(tempC.type == c){
                return true;
            }
        }
        return false;
    }

    public static int compareOperator(char c1 ,char c2){
        int v1 = 0;
        int v2 = 0;
        for(Operator tempC :Operator.values()){
            if(tempC.type == c1){
                v1 = tempC.value;
            }
            if(tempC.type == c2){
                v2 = tempC.value;
            }
        }
        return v1 - v2;
    }
}
