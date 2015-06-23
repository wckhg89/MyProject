package pack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class EX10_7_1 extends SimpleTagSupport implements SimpleTag{
	private String limit;
	
	public void setLimit(String limit){
		this.limit = limit;
	}
	
	public void doTag() throws JspException, IOException {
		double number = Math.random();
		int number2 = (int)(1+Math.random() * Integer.parseInt(limit));
        JspWriter out = getJspContext().getOut();
        out.print("<p>Random number (between 0 to 1)</p>");
        out.print(number);
        
        out.print("<p>Random number (between 0 to "+Integer.parseInt(limit)+")</p>");
        out.print(number2);
    }
	
}
