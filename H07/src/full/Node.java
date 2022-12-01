package full;

import java.util.ArrayList;

public class Node {
    public int[] pNull;
    public Node prevNode;
    public Direction move;
    public int cost;
    public int estimated;
    public int[][] grid;

    public Node() {
        pNull = new int[]{0,0};
        prevNode = null;
        move = null;
        cost = 0;
        estimated = Integer.MAX_VALUE;
    }

    public Node(int[] pNull, Node prevNode, Direction move) {
        this.pNull = pNull;
        this.prevNode = prevNode;
        this.move = move;
        this.grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            this.grid[i] = prevNode.grid[i].clone();
        }
        this.cost = prevNode.cost+this.grid[prevNode.pNull[0]][prevNode.pNull[1]];
        this.grid[prevNode.pNull[0]][prevNode.pNull[1]] = this.grid[pNull[0]][pNull[1]];
        this.grid[pNull[0]][pNull[1]] = 0;
        this.estimated = Solver.linearConflict(this.grid);
        if (this.estimated == 0) {
            Solver.setEndNode(this);
        }
    }

}
