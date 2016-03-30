package views;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class SimpleTree extends JPanel {
  JTree tree;
  DefaultMutableTreeNode root;
  public SimpleTree() {
    root = new DefaultMutableTreeNode("root", true);
    getList(root, new File(System.getProperty("user.dir")));
    setLayout(new BorderLayout());
    tree = new JTree(root);
    tree.setRootVisible(false);
    add(new JScrollPane((JTree)tree),"Center");
    }
  
  public Dimension getPreferredSize(){
    return new Dimension(200, 120);
    }
  
  public void getList(DefaultMutableTreeNode node, File f) {
     if(!f.isDirectory()) {
         // We keep only JAVA source file for display in this HowTo
         if (f.getName().endsWith("java")) {
            System.out.println("FILE  -  " + f.getName());
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
            node.add(child);
            }
         }
     else {
         System.out.println("DIRECTORY  -  " + f.getName());
         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
         node.add(child);
         File fList[] = f.listFiles();
         for(int i = 0; i  < fList.length; i++)
             getList(child, fList[i]);
         }
    }
  }