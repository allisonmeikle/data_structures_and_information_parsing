package assignment2;

public class TargetQueue extends MyQueue<Position>{
    private MyStack<String> stack;

    public TargetQueue(){
        super();
        this.stack = new MyStack<String>();
    }
    public void clear(){
        super.clear();
        this.stack.clear();
    }
    public void addTargets(String str){
        String num = "";
        String curStr = str;

        // base case for an empty string
        while (curStr.length() > 0){
            int i;
            if (curStr.charAt(0) == 46 && curStr.length() == 1){
                return;
            }

            if (curStr.length() < 5){
                throw new IllegalArgumentException("The input string is invalid");
            } else {
                i = 0;
//                 if it starts with a period, remove it
                if (curStr.charAt(0) == 46){
                    curStr = curStr.substring(1);
                }

                // if the first char is (, add it to the stack and shift the list back by 1
                if (curStr.charAt(i) == 40) {
                    this.stack.push("(");
                    i++;
                } else {
                    throw new IllegalArgumentException("The syntax of the input string is invalid");
                }

                while (curStr.charAt(i) <= 58 && curStr.charAt(i) >= 47) {
                    num = num.concat(String.valueOf(curStr.charAt(i)));
                    i++;
                }

                // if the character is a ,
                if (curStr.charAt(i) == 44){
                    try{
                        int validNum = Integer.parseInt(num);
                    } catch (NumberFormatException e){
                        throw new IllegalArgumentException("The digits of the position are not valid");
                    }
                    this.stack.push(num);
                    this.stack.push(",");
                    i++;
                } else {
                    throw new IllegalArgumentException("The syntax of the input string is invalid");
                }

                // clear the string for the next set of coordinates
                num = "";
                while (curStr.charAt(i) <= 58 && curStr.charAt(i) >= 47) {
                    num = num.concat(String.valueOf(curStr.charAt(i)));
                    i++;
                }
                try{
                    int validNum = Integer.parseInt(num);
                } catch (NumberFormatException e){
                    throw new IllegalArgumentException("The digits of the position are not valid");
                }

                // if the character is a ), perform checks and add Position to queue
                if (curStr.charAt(i) == 41){
                    i++;
                    if (this.stack.getSize() != 3){
                        throw new IllegalArgumentException("The syntax of the input is not valid");
                    }
                    String comma = this.stack.pop();
                    String xCoordinate = this.stack.pop();
                    String openBracket = this.stack.pop();

                    if (comma.compareTo(",") != 0 || openBracket.compareTo("(") != 0){
                        throw new IllegalArgumentException("The syntax of the input is not valid");
                    }

                    if (num.compareTo("") == 0){
                        throw new IllegalArgumentException("No y-coordinate was provided.");
                    }
                    System.out.println(xCoordinate);
                    System.out.println(num);
                    this.enqueue(new Position(Integer.parseInt(xCoordinate), Integer.parseInt(num)));
                } else {
                    throw new IllegalArgumentException("The syntax of the input string is invalid");
                }

                num = "";
                if ((curStr.substring(i)).length()>1){
                    curStr = curStr.substring(i);
                    if (curStr.charAt(0) != 46){
                        throw new IllegalArgumentException("The syntax of the input string is invalid");
                    }
                } else {
                    curStr = "";
                }
            }
        }
    }
}
