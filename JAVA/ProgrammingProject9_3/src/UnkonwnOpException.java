/**
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter9
 */

public class UnkonwnOpException extends Exception{
	public UnkonwnOpException()
	{
		super("UnknownOpException");
	}
	public UnkonwnOpException(char op)
	{
		super(op + " is an unknown operator.");
	}
	
	public UnkonwnOpException(String msg)
	{
		super(msg);
	}
}
