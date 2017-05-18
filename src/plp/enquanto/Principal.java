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
//		String programa = "x:=10; y:=leia; "
//				+ "se y = x entao exiba \"igual\" senaose y >= x entao exiba \"senaose maior\" senao exiba \"senao menor\"";
//		String programa = "x:=leia; "
//				+ "escolha x "
//				+ "caso 6 : exiba \"passou\" "
//				+ "caso 2: exiba \"final\" "
//				+ "padrao exiba \"rodou\" ";
		String programa = "para num de 1 ate 5 passo 1 faca { escreva coisa }";
		
		final ParseTree tree = parse(programa);
		final ParseTreeWalker walker = new ParseTreeWalker();
		final MeuListener listener = new MeuListener();
		walker.walk(listener, tree);
		listener.getPrograma().execute();
		
//		Programa p1 = listener.getPrograma();
//		// O parser devolve um objeto 'Programa' semelhante ao programa a seguir:
//		Programa p2 = new Programa(asList(
//				new Atribuicao("x", new Inteiro(10)),                       // x := 10
//				new Atribuicao("y", leia),                                  // y := leia
//				new Atribuicao("c", new ExpSoma(new Id("x"), new Id("y"))), // c := x + y
//				new Se(new ExpMenorIgual(new Inteiro(30), new Id("c")),     // se 30 <= c entao
//						new Escreva(new Id("c")),                           // escreva c
//						new Exiba("menor"))                                 // senao exiba "menor"
//				));
////		Atribuicao x = new Atribuicao("x", new Inteiro(10));                       // x := 10
////		Atribuicao y = new Atribuicao("y", leia);                                  // y := leia
////		Se se = new Se(new ExpIgual(new Id("x"), new Id("y")),     			// se 30 <= c entao
////				new Exiba("igual"), new Exiba("menor")) ;            // senao exiba "menor"
////		se.AddSeNaoSe(new SeNaoSe(new ExpMaiorIgual(new Id("x"), new Id("y")) , new Exiba("maior")));
////		Programa p2 = new Programa(asList(x, y, se) );
//		p1.execute();
//		p2.execute();
	}
}
