package assignment2;

public class Region {
    int minX;
    int minY;
    int maxX;
    int maxY;

    public Region(int minX, int minY, int maxX, int maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    public boolean contains (Position p){
        return (p.getX() >= this.minX && p.getX() <= this.maxX && p.getY() >= this.minY && p.getY() <= this.maxY);
    }
}
