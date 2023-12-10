find * -name "*.java" > sources.txt
javac @sources.txt
java -cp src com.avaj.simulator.Simulator