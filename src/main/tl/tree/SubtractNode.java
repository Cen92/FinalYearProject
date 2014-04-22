package main.tl.tree;

import java.util.List;

import main.tl.TLValue;

public class SubtractNode implements TLNode {

  private TLNode lhs;
  private TLNode rhs;

  public SubtractNode(TLNode lhs, TLNode rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public TLValue evaluate() {

    TLValue a = lhs.evaluate();
    TLValue b = rhs.evaluate();

    // number + number
    if(a.isNumber() && b.isNumber()) {
      return new TLValue(a.asDouble() - b.asDouble());
    }

    // list + any
    if(a.isList()) {
      List<TLValue> list = a.asList();
      list.remove(b);
      return new TLValue(list);
    }

    // // string + any
    // if(a.isString()) {
    // //  return new TLValue(a.asString() + "" + b.toString());
    // }

    // // any + string
    // if(b.isString()) {
    //   return new TLValue(a.toString() + "" + b.asString());
    // }

    throw new RuntimeException("illegal expression: " + this);
  }

  @Override
  public String toString() {
    return String.format("(%s - %s)", lhs, rhs);
  }
}

