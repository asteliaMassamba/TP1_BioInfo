#!/bin/bash



cd src
javac *.java

echo windows

java windowsAffiche 80 40 ../data/phage-lambda.fasta
echo

echo question 4

java Parti1 80 40 4 0.1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 4 0.2 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 4 0.5 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 4 1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
echo
java Parti1 80 40 8 0.1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 8 0.2 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 8 0.5 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 8 1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
echo 
java Parti1 80 40 12 0.1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 12 0.2 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 12 0.5 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 12 1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
echo
java Parti1 80 40 16 0.1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 16 0.2 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 16 0.5 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 16 1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
echo 
java Parti1 80 40 20 0.1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 20 0.2 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 20 0.5 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa
java Parti1 80 40 20 1 ../data/phage-lambda.fasta ../data/read1.fa ../data/read2.fa


echo
echo plus on augmente le ratio minimum ou la taille des kmers moins ils y à de fenettre correspondante trouvé


cd ..
$SHELL
