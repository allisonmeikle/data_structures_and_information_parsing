package assignment2;

public class Position {
    private int xCoord;
    private int yCoord;
    public Position (int xPos, int yPos){
        this.xCoord = xPos;
        this.yCoord = yPos;
    }
    public Position(Position pos){
        this.xCoord = pos.xCoord;
        this.yCoord = pos.yCoord;
    }
    public void reset(int xPos, int yPos){
        this.xCoord = xPos;
        this.yCoord = yPos;
    }
    public void reset(Position pos){
        this.xCoord = pos.xCoord;
        this.yCoord = pos.yCoord;
    }
    public static int getDistance(Position pos1, Position pos2){
        return (int)(Math.abs(pos1.xCoord-pos2.xCoord)+Math.abs(pos1.yCoord-pos2.yCoord));
    }
    public int getX(){
        return this.xCoord;
    }
    public int getY(){
        return this.yCoord;
    }
    public void moveWest(){
        this.xCoord -= 1;
    }
    public void moveEast(){
        this.xCoord += 1;
    }
    public void moveNorth(){
        this.yCoord -= 1;
    }
    public void moveSouth(){
        this.yCoord += 1;
    }
    public boolean equals (Object obj){
        if (obj instanceof Position){
            return (this.xCoord == ((Position)obj).xCoord && this.yCoord == ((Position)obj).yCoord);
        }
        return false;
    }

}
