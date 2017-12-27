public class SlowMessagePrinter implements MessagePrinter{

private final int delay;

public SlowMessagePrint(int delay){
this.delay = delay;
}

public void print (String message){
char [] chars = message.toCharArray();
}

public void println(String message){
print (message + "\n");
}
}