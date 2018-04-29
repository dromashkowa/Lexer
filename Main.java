/**
 * Created by danya on 29.04.2018.
 */
import java.util.Scanner;
import java.util.Iterator;
import java.util.Queue;


public class Main {
    public static void main(String[] args){
        Lexer lexer = new Lexer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");

        String test = sc.nextLine();
        System.out.println(test);
        Queue<Token> tokens = lexer.MakeTokens(test);
        Iterator iter = tokens.iterator();
        while (iter.hasNext())
        {
            Token t = (Token)iter.next();
            System.out.println(t.TypeOfToken  + " " + t.Token);
        }
    }
}
