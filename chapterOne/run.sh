#!/bin/bash
# args=("$@")
# ELEMENT = ${#args[@]}
javac "Q$@.java"
java "Q$@"