
public class Program {

	private List<Instruction> sequence;
	private int line;
	

	public Program( List<Instruction> initialSequence, int initialLine ) {
		sequence = initialSequence;
		line = initialLine;
		
	}

	public void restart() {
		//Resetea el programa
	}

	public Instruction accessnext() {
		//Accede a la siguiente Instruccion
	}

	public bool isFinished() {
		//Nos dice si la sequencia no tiene mas instrucciones que checkear
	}

	public void printError() {
		//Imprime el error de la linea
	}

	public Instruction getLine() {
		//Se devuelve la instruccion  
	}
	
	public void newInstruction(String code, double parameter) {
		//Se crea una nueva instancia de una instruccion y se añade a la secuencia
	}
}
