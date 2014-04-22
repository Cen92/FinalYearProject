package main.tl.tree.functions;

import java.io.PrintStream;

import main.tl.TLValue;
import main.tl.tree.TLNode;

public class PrintlnNode implements TLNode {

  private TLNode expression;
  private PrintStream out;

  public PrintlnNode(TLNode e) {
    this(e, System.out);
  }

  public PrintlnNode(TLNode e, PrintStream o) {
    expression = e;
    out = o;
  }

  @Override
  public TLValue evaluate() {
    TLValue value = expression.evaluate();
    out.println(value);
    return TLValue.VOID;
  }
}

