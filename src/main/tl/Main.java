package main.tl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import main.tl.parser.TLLexer;
import main.tl.parser.TLParser;
import main.tl.parser.TLTreeWalker;
import main.tl.tree.TLNode;

//import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import android.content.Context;
import android.content.res.AssetManager;

public class Main {


	public TLValue main(String file) throws Exception {

		//TLLexer lexer = new TLLexer(new ANTLRFileStream(file));
		TLLexer lexer = new TLLexer(new ANTLRStringStream(file));
		// wrap a token-stream around the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create the parser
		TLParser parser = new TLParser(tokens);

		// walk the tree
		CommonTree tree = (CommonTree) parser.parse().getTree();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);

		// pass the reference to the Map of functions to the tree walker
		TLTreeWalker walker = new TLTreeWalker(nodes, parser.functions);

		// get the returned node
		TLNode returned = walker.walk();
		//System.out.println(returned == null ? "null" : returned.evaluate());
		TLValue output = returned.evaluate();
		
		return output;
	}
}
