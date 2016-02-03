#!/bin/bash

FILE0=../data/test0.fasta
FILE1=../data/test1.fasta
FILE2=../data/test2.fasta

cd src
javac *.java

java PrintFastaSequence $FILE0
java PrintFastastats $FILE0
java ListKmer 4 $FILE1
java CommonKmers 4 $FILE1 $FILE2
java RatioCommonKmers 4 $FILE1 $FILE2
java RandomMutation 2 $FILE1

$SHELL