package assignment2;

public class ActionQueue extends MyQueue<Direction>{
    MyStack<String> stack = new MyStack<String>();
    String directions = "";
    public ActionQueue(){
        super();
    }
    public void clear(){
        super.clear();
    }

    public void loadFromEncodedString(String msg){
        while (msg.length() > 0){
            directions = "";
            int closeBrace = msg.indexOf(']');
            int openBrace = msg.indexOf('[');
            // if there isn't a close brace in the string
            if (closeBrace == -1 || openBrace == -1){
                throw new IllegalArgumentException("the input string is invalid.");
            }

            int cur = closeBrace-1;
            while (msg.charAt(cur) != '['){
                if (msg.charAt(cur) == 'N' || msg.charAt(cur) == 'S' || msg.charAt(cur) == 'E' || msg.charAt(cur) == 'W'){
                    if (msg.charAt(cur) == 'N'){
                        this.stack.push("N");
                    }
                    if (msg.charAt(cur) == 'S'){
                        this.stack.push("S");
                    }
                    if (msg.charAt(cur) == 'E'){
                        this.stack.push("E");
                    }
                    if (msg.charAt(cur) == 'W'){
                        this.stack.push("W");
                    }
                } else {
                    throw new IllegalArgumentException("The input string syntax is invalid.");
                }
                cur -= 1;
            }

            while (this.stack.getSize() > 0){
                directions += this.stack.pop();
            }

            // edge case for an empty []
            if ((msg.charAt(closeBrace - 1) == '[')){
                throw new IllegalArgumentException("No direction was provided");
            }

            cur -= 1;
            String repeatNum = "";
            MyStack<Character> repeatNums = new MyStack<Character>();

            // checks that the character after [ is a digit
            if (!(msg.charAt(cur) > 47 && msg.charAt(cur) < 58)){
                throw new IllegalArgumentException("No K value was provided");
            }

            // make a stack of K values
            while (msg.charAt(cur) > 47 && msg.charAt(cur) < 58 && cur >= 0){
                repeatNums.push((Character)(msg.charAt(cur)));
                if (cur != 0){
                    cur -= 1;
                }else{
                    break;
                }
            }
            if (msg.charAt(cur) == '-'){
                throw new IllegalArgumentException("The K value must be a positive integer");
            }

            // add the stack in reverse to a string of repeat nums
            for (int i=0; i<=repeatNums.getSize(); i++){
                repeatNum += repeatNums.pop();
            }
            int repeats = Integer.parseInt(repeatNum);

            directions = directions.repeat(repeats);
            System.out.println(directions);

            for (int i = 0; i<directions.length();i++){
                if (directions.charAt(i) == 'N'){
                    this.enqueue(Direction.NORTH);
                }
                if (directions.charAt(i) == 'E'){
                    this.enqueue(Direction.EAST);
                }
                if (directions.charAt(i) == 'S'){
                    this.enqueue(Direction.SOUTH);
                }
                if (directions.charAt(i) == 'W'){
                    this.enqueue(Direction.WEST);
                }
            }

            if (cur == 0){
                msg = msg.substring(closeBrace+1);
            } else if (cur > 0){
                msg = msg.substring(0,(cur-1)) + msg.substring(closeBrace+1);
            }
        }
    }
}
