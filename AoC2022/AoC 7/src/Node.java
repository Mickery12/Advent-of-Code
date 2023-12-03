import java.util.ArrayList;

public class Node {
    
    private final String name;
    private int size;
    private final ArrayList<Node> files = new ArrayList<>();
    private final ArrayList<Node> dir = new ArrayList<>();
    private final Node parent;
    
    
    public Node(String name, int size, Node parent){
        this.name = name;
        this.size = size;
        this.parent = parent;
    }
    
    public Node getNodeDir(String name){
        for(Node n: dir){
            if (n.getName().equals(name)){
                return n;
            }
        }
        return null;
    }

    public int getNodeDirSize(){
        return dir.size();
    }
    public Node getNodeDir(int i){
        return dir.get(i);
    }
    public void addToFiles(String name, int size){
        files.add(new Node(name, size, this));
    }
    
    public void addtoDir(String name){
        dir.add(new Node(name, 0, this));
    }
    
    public String getName(){
        return name;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize(){
        if(files.isEmpty() && dir.isEmpty()){
            return size;
        }
        int x = 0;
        for(Node n: files){
            x += n.getSize();
        }
        
        for(Node n : dir){
            x += n.getSize();
        }
        setSize(x);
        return x;
    }
    
}
