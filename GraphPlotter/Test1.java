import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Test {

  public static void main(String[] args) throws Exception{
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String foo = "x*x*x+x*x-x";
	for(int i=0;i<foo.length();i++)
	{
	if(foo.charAt(i)=='x')
	{
	foo = changeCharInPosition(i, '2', foo);
	}
	}
   System.out.println(engine.eval(foo));
    } 

public static  String changeCharInPosition(int position, char ch, String str){
    char[] charArray = str.toCharArray();
    charArray[position] = ch;
    return new String(charArray);
	}	
	
	
	
}