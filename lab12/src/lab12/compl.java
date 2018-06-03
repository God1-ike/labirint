package lab12;

import java.awt.TextArea;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class compl extends TextArea {
	   class user {
	        String surname;
	        String name;
	        String middle_name;
	        String number;
	        user(String s, String n, String mn, String num) {
	            surname = s;
	            name = n;
	            middle_name = mn;
	            number = num;
	        }
	    }
	    int Position = 0;
	    LinkedList<user> list = new LinkedList<user>();;
	    public void input(String surn, String nam, String mid_nam, String numb) {
	            user input_data = new user(surn, nam, mid_nam, numb);
	            list.add(Position, input_data);
	            Position++;
	    }
	    public String out() {
	        String str = "";
	        for(int i = 0; i < list.size(); i++) {
	            user temp = list.get(i);
	            str += temp.surname + " ";  
	            str += temp.name + " "; 
	            str += temp.middle_name + " ";
	            str += temp.number + "\n";  
	        }
	        return str;
	    }
	    public String left() {
	        if(Position > 0)
	        Position--;
	        String str = "";
	        if(list.size() != 0) {
	            user temp = list.get(Position);
	            str += temp.surname + " ";  
	            str += temp.name + " "; 
	            str += temp.middle_name + " ";
	            str += temp.number + "\n";  
	        }
	        return str;
	    }
	    public String right() {
	        if(Position  + 1 < list.size())
	        Position++;
	        String str = "";
	        if(list.size() != 0) {
	            user temp = list.get(Position);
	            str += temp.surname + " ";  
	            str += temp.name + " "; 
	            str += temp.middle_name + " ";
	            str += temp.number + "\n";  
	        }
	        return str;
	    }
	    public String delete() {
	        if(list.size() != 0)
	            list.remove(Position);
	        return out();
	    }
}
