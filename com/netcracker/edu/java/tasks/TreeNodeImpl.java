package com.netcracker.edu.java.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by user on 09.07.2015.
 */
public class TreeNodeImpl implements  TreeNode {
    private TreeNode parent;
    private TreeNode root;
    private ArrayList<TreeNode> children;
    private Object data;
    private boolean expand;

    public TreeNodeImpl(){

    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public boolean isExpanded() {
        return expand;
    }

    @Override
    public void setExpanded(boolean expanded) {
        expand=expanded;
        Iterator<TreeNode> iter=getChildrenIterator();
        while(iter.hasNext()){
            iter.next().setExpanded(expanded);
        }
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if(parent==null) return null;
        else return parent.getRoot();
    }

    @Override
    public boolean isLeaf() {
        return getChildCount()==0;
    }

    @Override
    public int getChildCount() {
        if (children==null) return 0;
        return children.size();
    }



    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        if (children==null) children=new ArrayList<TreeNode>();
        children.add(child);
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (children.contains(child)) {
            children.remove(child);
            child.setParent(null);
            return true;
        }
        else return false;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public TreeNode findParent(Object data) {
        TreeNode cur=this;
        while(cur!=null){
            if(cur.getData()==null) {
                if(data==null) return cur;
            }
            else if (cur.getData().equals(data)){
                return cur;
            }
            cur=cur.getParent();
        }
        return null;
    }

    @Override
    public TreeNode findChild(Object data) {
        if(children==null) return null;
        Iterator<TreeNode> iter=getChildrenIterator();

        TreeNode cur,res;
        Object data2;
        while(iter.hasNext()){
            cur=iter.next();
            data2=cur.getData();
            if(data2==null){
                if(data==null) return cur;
            }
            else if(data2.equals(data)){
                return cur;
            }
            res=cur.findChild(data);
            if(res==null) continue;
            return res;
        }

        return null;
    }

    @Override
    public String getTreePath() {
        if(getParent()==null){
            if(getData()==null) return "empty";
            return getData().toString();
        }
        else {
            String str=getParent().getTreePath()+"->";
            if(getData()==null) str+="empty";
            else str+=getData();
            return str;
        }
    }
}
