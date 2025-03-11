## Problem1 Remove Invalid Parentheses(https://leetcode.com/problems/remove-invalid-parentheses/)

In this question we have to remove all the invalid parenthesis and return all the unique combinations of it
For this we will use BFS search maintain a queue and a Hashset such that we dont again traverse the same element
The size variable is not required here
As in this we are exploring all possible combinations so 
Time Complexity = Exponential
Space Complexity = Exponential as we are using a hashmap

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s.length()==0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean valid=false;
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isValid(curr)){
                valid=true;
                result.add(curr);  
            }
            else if(valid==false){
                for(int i=0;i<curr.length();i++){
                    String str = curr.substring(0,i) + curr.substring(i+1);
                    if(!set.contains(str)){
                        q.add(str);
                        set.add(str);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String str){
        if(str == null){
            return true;
        }
        int count=0;
        
        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            if(s >= 'a' && s <= 'z'){
                continue;
            }
            else if(s=='('){
                count++;
            }
            else if(s==')'){
                if(count <= 0){
                    return false;
                }
                count--;
            }
        }
        if(count==0){
                return true;
            }
            return false;
    }
}


//With Size variable

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s.length()==0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean valid=false;
        int size=0;
        while(!valid && !q.isEmpty()){
            size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
            if(isValid(curr)){
                valid=true;
                result.add(curr);  
            }
            else if(valid==false){
                for(int j=0;j<curr.length();j++){
                    String str = curr.substring(0,j) + curr.substring(j+1);
                    if(!set.contains(str)){
                        q.add(str);
                        set.add(str);
                    }
                }
            }
            }  
        }
        return result;
    }
    
    private boolean isValid(String str){
        if(str == null){
            return true;
        }
        int count=0;
        
        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            if(s >= 'a' && s <= 'z'){
                continue;
            }
            else if(s=='('){
                count++;
            }
            else if(s==')'){
                if(count <= 0){
                    return false;
                }
                count--;
            }
        }
        if(count==0){
                return true;
            }
            return false;
    }
}

//This problem can also be solved by DFS but it will not be efficient as our answer will lie near the root so BFS would be efficient here
// Time Complexity = exponential
// Space Complexity = exponential

class Solution {
    List<String> result;
    HashSet<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        if(s.length()==0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        set = new HashSet<>();
        max=0;
        dfs(s);
        return result;
    }

    private void dfs(String s){
        //base
        if(isValid(s)){
            if(s.length() > max){
                result=new ArrayList<>();
                max=Math.max(max,s.length());
                result.add(s);
                return;
            }
            else if(s.length() == max){
                 result.add(s);
                 return;
            }
            else{
                return;
            }

        }
        //logic
        set.add(s);
        for(int i=0;i<s.length();i++){
            String str=s.substring(0,i) + s.substring(i+1);
            if(!set.contains(str)){
                set.add(str);
                dfs(str);
            }
        }
    }


    
    private boolean isValid(String str){
        if(str == null){
            return true;
        }
        int count=0;
        
        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            if(s >= 'a' && s <= 'z'){
                continue;
            }
            else if(s=='('){
                count++;
            }
            else if(s==')'){
                if(count <= 0){
                    return false;
                }
                count--;
            }
        }
        if(count==0){
                return true;
            }
            return false;
    }
}