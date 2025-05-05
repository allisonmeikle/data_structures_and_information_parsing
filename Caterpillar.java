package assignment2;

public class Caterpillar extends MyDoublyLinkedList<Position>{
    public Caterpillar(){
        this.addFirst(new Position(7,7));
    }
    public Position getHead(){
        return this.peekFirst();
    }
    public void eat(Position p){
        if (Position.getDistance(p, this.getHead()) <= 1){
            this.addFirst(p);
        } else {
            throw new IllegalArgumentException("You cannot eat that as it is not orthagonally adjacent to you.");
        }
    }
    public void move(Position p){
        if (Position.getDistance(p, this.getHead()) <= 1){
            this.addFirst(p);
            this.removeLast();
        } else {
            throw new IllegalArgumentException("You cannot move there as it is not orthagonally adjacent to you.");
        }
    }

    public boolean selfCollision(Position p){
        boolean touching = false;

        for (int i=0;i<=this.getSize();i++){
            Position cur = this.removeFirst();
            if (cur.equals(p)){
                return true;
            }
            this.addLast(cur);
        }
        return false;
    }
}
