package plp.enquanto;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import plp.enquanto.parser.EnquantoLexer;
import plp.enquanto.parser.EnquantoParser;
import plp.enquanto.parser.MeuListener;
import static plp.enquanto.linguagem.Linguagem.*;
import static java.util.Arrays.*;

public class Principal {

	private static ParseTree parse(String programa) {
		final ANTLRInputStream input = new ANTLRInputStream(programa);
		final EnquantoLexer lexer = new EnquantoLexer(input);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final EnquantoParser parser = new EnquantoParser(tokens);
		return parser.programa();
	}

	public static void main(String... args) throws IOException {
		/* Programa para testar senaose */
//		String programa = "x:=10; y:=leia; "
//				+ "se y = x entao exiba \"igual\" senaose y >= x entao exiba \"senaose maior\" senao exiba \"senao menor\"";
		
		/* Programa para testar escolha */
//		String programa = "x:=leia; "
//				+ "escolha x "
//				+ "caso 6 : exiba \"passou\" "
//				+ "caso 2: exiba \"final\" "
//				+ "padrao exiba \"rodou\" ";
		
		/* Programa para testar para */
		String programa = "para num de 1 ate 5 passo 1 faca { escreva num }";
		
		
		final ParseTree tree = parse(programa);
		final ParseTreeWalker walker = new ParseTreeWalker();
		final MeuListener listener = new MeuListener();
		walker.walk(listener, tree);
		listener.getPrograma().execute();
		
	}
}
