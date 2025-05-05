package assignment2;

public class World {
    private Caterpillar c;
    private Position curFood;
    private Region map;
    private ActionQueue actions;
    private TargetQueue foodPos;
    private GameState curState;

    public World(TargetQueue tQ, ActionQueue aQ){
        this.foodPos = tQ;
        this.actions = aQ;
        this.map = new Region(0,0,15,15);
        this.c = new Caterpillar();
        this.curFood = foodPos.dequeue();
        this.curState = GameState.MOVE;
    }

    public void step(){
        Direction nextHeading;
        if (this.actions.isEmpty()){
            curState = GameState.NO_MORE_ACTION;
        } else {
            nextHeading = actions.dequeue();

            Position cur = c.getHead();
            Position newPos = new Position(0,0);

            // check which way and initialize nextPos
            if (nextHeading == Direction.NORTH){
                newPos = new Position(cur.getX(),cur.getY()-1);
            } else if (nextHeading == Direction.SOUTH){
                newPos = new Position(cur.getX(),cur.getY()+1);
            } else if (nextHeading == Direction.EAST) {
                newPos = new Position(cur.getX()+1, cur.getY());
            } else if (nextHeading == Direction.WEST) {
                newPos = new Position(cur.getX()-1, cur.getY());
            }

            if (!map.contains(newPos)){
                curState = GameState.WALL_COLLISION;
            } else if (c.selfCollision(newPos)){
                curState = GameState.SELF_COLLISION;
            } else {
                c.move(newPos);
                curState = GameState.MOVE;
            }

            if (curFood.equals(newPos)) {
                if (foodPos.isEmpty()) {
                    curState = GameState.DONE;
                } else {
                    curState = GameState.EAT;
                    c.eat(curFood);
                    curFood = this.foodPos.dequeue();
                }
            }
        }
        if (curState != GameState.MOVE && curState != GameState.EAT){
            return;
        }
    }

    public GameState getState(){
        return this.curState;
    }
    public Caterpillar getCaterpillar(){
        return this.c;
    }
    public Position getFood(){
        return this.curFood;
    }
    public boolean isRunning(){
        return (this.curState == GameState.MOVE || this.curState == GameState.EAT);
    }

    public static void main (String[] args){
        String food = "(5,9)";
        String direction = "10[E]";

        TargetQueue t = new TargetQueue();
        ActionQueue a = new ActionQueue();

        t.addTargets(food);
        a.loadFromEncodedString(direction);

        World world = new World(t, a);
        //move 9 steps E, wall collision
        for (int i = 0; i < 9; i++) {  // move 9 steps E from (7,7) to (15,7)
            world.step();
        }
        System.out.println(world.getState());
        System.out.println(world.getCaterpillar().getHead().getX());
    }
}
