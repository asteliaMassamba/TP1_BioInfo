#!/bin/bash

FILE0=../data/test0.fasta
FILE1=../data/test1.fasta
FILE2=../data/test2.fasta

cd src
javac *.java

echo print fasta sequence

java PrintFastaSequence $FILE0
echo
echo print fasta stats

java PrintFastastats $FILE0
echo
echo list kmer

java ListKmer 4 $FILE1
echo
echo common kmer

java CommonKmers 4 $FILE1 $FILE2
echo
echo ratio common kmer

java RatioCommonKmers 4 $FILE1 $FILE2
echo
echo random mutation 1er execution

java RandomMutations 2 $FILE1
echo
echo random mutation 2nd execution

java RandomMutations 2 $FILE1
echo
echo random mutation 3eme execution

java RandomMutations 2 $FILE1
echo
echo réponses aux question

cd ..
$SHELL
