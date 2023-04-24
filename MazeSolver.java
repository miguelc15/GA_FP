import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.Math;
public class MazeSolver extends FitnessFunction{
    
    public MazeSolver(){
        name = "Maze Solver Problem";
    }
    //  COMPUTE A CHROMOSOME'S RAW FITNESS *************************************
	public void doRawFitness(Chromo X){
        X.rawFitness=0;
		X.pos_x=0;
		X.pos_y=0;
		X.trace();
        X.rawFitness = Math.sqrt(Math.pow(X.size-X.pos_x, 2)+Math.pow(X.size-X.pos_y, 2));
	}

    //  PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE *********************************

	public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException{

		for (int i=0; i<Parameters.numGenes; i++){
			Hwrite.right(X.getGeneAlpha(i),11,output);
		}
		output.write("   RawFitness");
		output.write("\n        ");
		for (int i=0; i<Parameters.numGenes; i++){
			Hwrite.right(X.getPosIntGeneValue(i),11,output);
		}
		Hwrite.right((int) X.rawFitness,13,output);
		output.write("\n\n");
		return;
	}



}
