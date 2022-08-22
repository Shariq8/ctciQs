#!/bin/bash
NAME = "Q$@"
git add .
git commit -m "$NAME"
git push -u origin