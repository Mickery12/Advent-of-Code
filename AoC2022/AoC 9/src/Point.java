import java.util.ArrayList;

public class Point {
    private int x;
    private int y;

    private int[] position;
    
    private ArrayList<Point> positionsVisited = new ArrayList<>();

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

    public ArrayList<Point> getPositionsVisited(){
        return positionsVisited;
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

    public int positionsVisitedTotal(){
        return positionsVisited.size();
    }
    
    private boolean comparePosition(int[] pos){
        return (this.getPosition()[0] == pos[0] && this.getPosition()[1] == pos[1]);
    }

    public void calculatePostionHead(char dir, int moves, Point head, Point tail, int puzzlePart, Point[] tails){

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
            if(puzzlePart == 1){
                calculatePositionTail(head, tail);
            }
            else {
                calculatePositionTails(tails);
            }
            head.positionsVisited.add(new Point(head));
        }
    }
    
    private boolean isAdjacent(int[] positionHead, int[] positionTail) {
        if (positionHead[0] == positionTail[0] || positionHead[1] == positionTail[1]) {
            return 1 >= Math.abs(positionHead[0] - positionTail[0]) + Math.abs(positionHead[1] - positionTail[1]);
        }
        else {
            return 2 == Math.abs(positionHead[0] - positionTail[0]) + Math.abs(positionHead[1] - positionTail[1]);
        }
    }

    private boolean positionAlreadyVisited(Point p){
        for (Point pV: this.positionsVisited) {
            if(pV.comparePosition(p.getPosition()))
                return true;
        }
        return false;
    }
    
    private void calculatePositionTails(Point[] tails ){
        
        for(int i = 1;  i < tails.length; i++){
            int[] positionHead = tails[i-1].getPosition();
            int[] positionTail = tails[i].getPosition();
            if(isAdjacent(positionHead, positionTail)){
                continue;
            }
            if(!tails[9].positionAlreadyVisited(tails[i])){
                tails[9].positionsVisited.add(new Point(tails[i]));
            }
            
            if(positionHead[0] > positionTail[0] && positionHead[1] == positionTail[1]){
                tails[i].setPosition(tails[i].getX() + 1, tails[i].getY());
            }
            
            else if(positionHead[0] < positionTail[0] && positionHead[1] == positionTail[1]){
                tails[i].setPosition(tails[i].getX() - 1, tails[i].getY());
            }
            else if(positionHead[1] > positionTail[1] && positionHead[0] == positionTail[0]){
                tails[i].setPosition(tails[i].getX(), tails[i].getY() + 1);
            }
            
            else if(positionHead[1] < positionTail[1] && positionHead[0] == positionTail[0]){
                tails[i].setPosition(tails[i].getX(),tails[i].getY() - 1);
            }
            
            else if(positionHead[0] > positionTail[0] && positionHead[1] > positionTail[1]){
                tails[i].setPosition(tails[i].getX() + 1, tails[i].getY() + 1);
            }
            
            else if(positionHead[0] < positionTail[0] && positionHead[1] > positionTail[1]){
                tails[i].setPosition(tails[i].getX() - 1, tails[i].getY() + 1);
            }
            else if(positionHead[0] > positionTail[0]){
                tails[i].setPosition(tails[i].getX() + 1, tails[i].getY() - 1);
            }
            else if(positionHead[0] < positionTail[0]){
                tails[i].setPosition(tails[i].getX() - 1, tails[i].getY() - 1);
            }
            if(!tails[9].positionAlreadyVisited(tails[i])){
                tails[9].positionsVisited.add(new Point(tails[i]));
            }
        }

    }
    public void calculatePositionTail(Point head, Point tail){
        int[] positionHead = head.getPosition();
        int[] positionTail = tail.getPosition();

        if(isAdjacent(positionHead, positionTail)){
            return;
        }
        
        
        if(!tail.positionAlreadyVisited(tail)){
            tail.positionsVisited.add(new Point(tail));
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
        if(!tail.positionAlreadyVisited(tail)){
            tail.positionsVisited.add(new Point(tail));
        }
    }
}
