public class ConsoleMessagePrinter implements MessagePrinter{

public void print (String message){
System.out.print(message);
}

public void println(String message){
print (message + "\2n");
}}