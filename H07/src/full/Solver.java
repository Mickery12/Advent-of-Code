package full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solver {
    private static final int COLLISION_COST = 3;
    private static boolean Print = false;

    private ArrayList<Node> unvisitedNodes;
    private ArrayList<Node> childs;
    private ArrayList<Node> visited;
    private Node curNode;
    private static int minDist = Integer.MAX_VALUE;
    private static Node endNode = null;

    public Solver() {

    }

    public static int getYForV(int v) {
        return ((v - 1) % 16) / 4;
    }


    public static int getXForV(int v) {
        return (v + 3) % 4;
    }

    public static void setEndNode(Node n) {
        endNode = n;
    }

    public static int linearConflict(int[][] grid) {
        int cost = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int v = grid[x][y];
                if (v == 0) continue;
                int newCost = Math.abs(x - (getXForV(v))) + Math.abs(y - getYForV(v)) ;
                if (getXForV(v) == x) {
                    if (y < getYForV(v)) {
                        for (int a = y+1; a <= getYForV(v); a++) {
                            int w = grid[x][a];
                            if (getXForV(w) == x && w > v) {
                                newCost += COLLISION_COST;
                                break;
                            }
                        }
                    } else {
                        for (int a = y-1 ; a >= getYForV(v); a--) {
                            int w = grid[x][a];
                            if (getXForV(w) == x && w < v) {
                                newCost += COLLISION_COST;
                                break;
                            }
                        }
                    }
                }
                if (getYForV(v) == y) {
                    if (x < getXForV(v)) {
                        for (int a = x+1; a <= getXForV(v); a++) {
                            int w = grid[x][a];
                            if (getYForV(w) == y && w > v) {
                                newCost += COLLISION_COST;
                                break;
                            }
                        }
                    } else {
                        for (int a = x-1; a >= getXForV(v); a--) {
                            int w = grid[x][a];
                            if (getYForV(w) == y && w < v) {
                                newCost += COLLISION_COST;
                                break;
                            }
                        }
                    }
                }
                newCost *= (4-getXForV(v))+(4-getYForV(v));
                cost += newCost;
            }
        }
        if (cost < minDist && Print) {
            minDist = cost;
            //System.out.println("minimal linear colision distance of " + cost + " after traversing " + visited.size() + " Nodes");
            System.out.println(toString(grid));
        }
        return cost;
    }

    public static int manhattanDistance(int[][] grid) {
        int cost = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int v = grid[x][y];
                if (v != 0) {
                    cost += Math.abs(x - getXForV(v)) + Math.abs(y - getYForV(v));
                } else {
                    cost += Math.abs(3 - x) + Math.abs(3 - y);
                }
            }
        }
        if (cost < minDist && Print) {
            minDist = cost;
            //System.out.println("minimal Manhattan distance of " + cost + " after traversing " + visited.size() + " Nodes");
            System.out.println(toString(grid));
        }
        return cost;
    }

    public void calculateNeigbors() {
        childs.clear();
        int[] pNull = curNode.pNull;
        Direction lastMove = curNode.move;
        if (pNull[0] > 0 && lastMove != Direction.RIGHT) {//LEFT
            childs.add(new Node(
                new int[]{pNull[0]-1, pNull[1]},
                curNode,
                Direction.LEFT
            ));
        }
        if (pNull[0] < 3 && lastMove != Direction.LEFT) {//RIGHT
            childs.add(new Node(
                new int[]{pNull[0]+1, pNull[1]},
                curNode,
                Direction.RIGHT
            ));
        }
        if (pNull[1] > 0 && lastMove != Direction.DOWN) {//UP
            childs.add(new Node(
                new int[]{pNull[0], pNull[1]-1},
                curNode,
                Direction.UP
            ));
        }
        if (pNull[1] < 3 && lastMove != Direction.UP) {//DOWN
            childs.add(new Node(
                new int[]{pNull[0], pNull[1]+1},
                curNode,
                Direction.DOWN
            ));
        }
        childs.removeIf(c -> visited.stream().anyMatch(n -> Arrays.deepEquals(n.grid, c.grid)));
        unvisitedNodes.addAll(childs);
        childs.removeIf(c -> c.estimated >= curNode.estimated);
    }

    public void solveStraight() {
        childs = new ArrayList<>();
        do {
            calculateNeigbors();
            if (childs.isEmpty()) return;
            int min = curNode.estimated;
            Node minNode = null;
            for (Node n : childs) {
                if (n.estimated < min) {
                    min = n.estimated;
                    minNode = n;
                }
            }
            curNode = minNode;
            unvisitedNodes.remove(curNode);
            visited.add(curNode);
        } while (endNode == null);
    }

    public ArrayList<Direction> solve(int[][] grid) {
        endNode = null;
        unvisitedNodes = new ArrayList<>();
        visited = new ArrayList<>();
        curNode = new Node();
        curNode.grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            curNode.grid[i] = grid[i].clone();
        }
        curNode.estimated = linearConflict(curNode.grid);
        if (curNode.estimated == 0) {
            return new ArrayList<>();
        }
        outer: for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] == 0) {
                    curNode.pNull = new int[]{x,y};
                    break outer;
                }
            }
        }
        while (endNode == null) {
            solveStraight();
            int min = Integer.MAX_VALUE;
            Node minNode = null;
            if (unvisitedNodes.isEmpty()) {
                throw new RuntimeException("Failed to find solution");
            }
            for (Node n : unvisitedNodes) {
                if (n.estimated < min) {
                    min = n.estimated;
                    minNode = n;
                }
            }
            curNode = minNode;
            visited.add(curNode);
            unvisitedNodes.remove(curNode);
        }

        ArrayList<Direction> moves = backtraceEndNode(endNode);
        if (Print) {
            System.out.println(curNode.estimated);
            System.out.println("success!");
            System.out.println("From");
            System.out.println(toString(grid));
            System.out.println("To:");
            System.out.println(toString(endNode.grid));
            System.out.println("Within these " + moves.size() + " moves:");
            System.out.println(moves);
        }
        return moves;
    }

    private static ArrayList<Direction> backtraceEndNode(Node endNode) {
        ArrayList<Direction> movesR = new ArrayList<>();
        Node curNode = endNode;
        while (curNode.prevNode != null) {
            movesR.add(curNode.move);
            curNode = curNode.prevNode;
        }
        Collections.reverse(movesR);
        return movesR;
    }

    public static String toString(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(13)).append("\n");
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                sb.append(String.format("|%2d", grid[x][y]));
            }
            sb.append("|\n").append("-".repeat(13)).append("\n");
        }
        return sb.toString();
    }

}
