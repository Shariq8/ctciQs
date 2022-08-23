#!/bin/bash
touch "Q$@.java"
NAME="Q$@"
cat << EOF > $NAME.java
public class $NAME{
    public static void main(String[] args){
      System.out.println("Hello World"); 
    }
}
EOF