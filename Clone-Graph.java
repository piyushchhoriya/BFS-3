## Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)

//In this question we can solvve it using both BFS and DFS also we will maintain a hashmap to keep track of nodes created so that we don't go andcreate the nodes again

DFS approach
Time Complexity : O(V+E)
Space Complexity : O(V)

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        map=new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){
        //base
        //No need of base condition as we are using for loop based recursion here
        //logic
        if(!map.containsKey(node)){
            Node currNode = new Node(node.val);
            map.put(node,currNode);
        }
        for(int i=0;i<node.neighbors.size();i++){
            if(!map.containsKey(node.neighbors.get(i))){
                dfs(node.neighbors.get(i));
                map.get(node).neighbors.add(map.get(node.neighbors.get(i)));
            }
            else{
                map.get(node).neighbors.add(map.get(node.neighbors.get(i)));
            }
        }
    }
}


//BFS
Time Complexity : O(V+E)
Space Complexity : O(V)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q =new LinkedList<>();
        q.add(node);
        Node currNode = new Node(node.val);
        map.put(node,currNode);
        while(!q.isEmpty()){
            Node polledNode = q.poll();
            for(int i=0;i<polledNode.neighbors.size();i++){
                if(!map.containsKey(polledNode.neighbors.get(i))){
                    q.add(polledNode.neighbors.get(i));
                    Node newNode = new Node(polledNode.neighbors.get(i).val);
                    map.put(polledNode.neighbors.get(i),newNode);
                    map.get(polledNode).neighbors.add(newNode);
                }
                else{
                    map.get(polledNode).neighbors.add(map.get(polledNode.neighbors.get(i)));
                }
            }
        }
        return map.get(node);
    }

}