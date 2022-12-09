import java.util.ArrayList;

public class Point {
    private int x;
    private int y;

    private int[] position;

    private ArrayList<int[]> positionsVisited = new ArrayList<>();

    public Point (int x, int y){
        setX(x);
        setY(y);
        setPosition(x, y);
    }
    public Point (Point p){
        this.setX(p.getX());
        this.setY(p.getY());
        this.setPosition(p.getPosition());
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.position = new int[]{x, y};
        this.x = x;
        this.y = y;
    }
    public void setPosition(int[] pos) {
        this.position = pos;
        this.x = pos[0];
        this.y = pos[1];
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int[] getPosition(){
        return position;
    }

    public int countPositionsVisitedAtLeastOnce(){
        return positionsVisited.size();
    }

    public void calculatePostionHead(char dir, int moves, Point head, Point tail){

        for(int i = 0; i < moves; i++){
            if(dir == 'R'){
                head.setPosition(head.getX() + 1, head.getY());
            }
            else if(dir == 'L'){
                head.setPosition(head.getX() - 1, head.getY());
            }
            else if (dir == 'U'){
                head.setPosition(head.getX(), head.getY() + 1);
            }
            else if (dir == 'D'){
                head.setPosition(head.getX(), head.getY() - 1);
            }
            calculatePositionTail(head, tail);
        }
    }

    private boolean posAlreadyVisited(int[] pos){
        for (int[] posVisited: positionsVisited) {
            if(pos[0] == posVisited[0] && pos[1] == posVisited[1]){
                return true;
            }
        }
        return false;
    }
    private boolean isAdjacent(int[] positionHead, int[] positionTail) {
        if (positionHead[0] == positionTail[0] || positionHead[1] == positionTail[1]) {
            return 1 >= Math.abs(positionHead[0] - positionTail[0]) + Math.abs(positionHead[1] - positionTail[1]);
        }
        else {
            return 2 == Math.abs(positionHead[0] - positionTail[0]) + Math.abs(positionHead[1] - positionTail[1]);
        }
    }

    public void calculatePositionTail(Point head, Point tail){
        int[] positionHead = head.getPosition();
        int[] positionTail = tail.getPosition();

        if(isAdjacent(positionHead, positionTail)){
            return;
        }
        if(!tail.posAlreadyVisited(positionTail)){
            tail.positionsVisited.add(positionTail);
        }

        if(positionHead[0] > positionTail[0] && positionHead[1] == positionTail[1]){
            tail.setPosition(tail.getX() + 1, tail.getY());
        }

        else if(positionHead[0] < positionTail[0] && positionHead[1] == positionTail[1]){
            tail.setPosition(tail.getX() - 1, tail.getY());
        }
        else if(positionHead[1] > positionTail[1] && positionHead[0] == positionTail[0]){
            tail.setPosition(tail.getX(), tail.getY() + 1);
        }

        else if(positionHead[1] < positionTail[1] && positionHead[0] == positionTail[0]){
            tail.setPosition(tail.getX(),tail.getY() - 1);
        }

        else if(positionHead[0] > positionTail[0] && positionHead[1] > positionTail[1]){
            tail.setPosition(tail.getX() + 1, tail.getY() + 1);
        }

        else if(positionHead[0] < positionTail[0] && positionHead[1] > positionTail[1]){
            tail.setPosition(tail.getX() - 1, tail.getY() + 1);
        }
        else if(positionHead[0] > positionTail[0]){
            tail.setPosition(tail.getX() + 1, tail.getY() - 1);
        }
        else if(positionHead[0] < positionTail[0]){
            tail.setPosition(tail.getX() - 1, tail.getY() - 1);
        }
    }
}
