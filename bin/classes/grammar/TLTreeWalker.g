tree grammar TLTreeWalker;

options {
  tokenVocab=TL;
  ASTLabelType=CommonTree;
}

@header {
  package tl.parser;
  import tl.*;
  import tl.tree.*;
  import tl.tree.functions.*;
  import java.util.Map;
  import java.util.HashMap;
}

@members {
  public Map<String, Function> functions = null;
  Scope currentScope = null;
  
  public TLTreeWalker(CommonTreeNodeStream nodes, Map<String, Function> fns) {
    this(nodes, null, fns);
  }
  
  public TLTreeWalker(CommonTreeNodeStream nds, Scope sc, Map<String, Function> fns) {
    super(nds);
    currentScope = sc;
    functions = fns;
  }
}

walk returns [TLNode node]
  :  block {node = $block.node;}
  ;

block returns [TLNode node]
@init {
  BlockNode bn = new BlockNode();
  node = bn;
  Scope scope = new Scope(currentScope);
  currentScope = scope;
}
@after {
  currentScope = currentScope.parent();
}
  :  ^(BLOCK 
        ^( STATEMENTS (statement  {bn.addStatement($statement.node);})* ) 
        ^( RETURN     (expression {bn.addReturn($expression.node);  })? )
      )
  ;

statement returns [TLNode node]
  :  assignment     {node = $assignment.node;}
  |  functionCall   {node = $functionCall.node;}
  |  ifStatement    {node = $ifStatement.node;}
  |  forStatement   {node = $forStatement.node;}
  |  whileStatement {node = $whileStatement.node;}
  ;

assignment returns [TLNode node]
  :  ^(ASSIGNMENT i=Identifier x=indexes? e=expression) 
     {node = new AssignmentNode($i.text, $x.e, $e.node, currentScope);}
  ;

functionCall returns [TLNode node]
  :  ^(FUNC_CALL Identifier exprList?)
  |  ^(FUNC_CALL Println expression?) {node = new PrintlnNode($expression.node);}
  |  ^(FUNC_CALL Print expression)
  |  ^(FUNC_CALL Assert expression)
  |  ^(FUNC_CALL Size expression)
  |  ^(FUNC_CALL MoveForward expression?) {node = new MoveForwardNode($expression.node);}
  |  ^(FUNC_CALL MoveBackward expression?) {node = new MoveBackwardNode($expression.node);}
  |  ^(FUNC_CALL TurnLeft expression?) {node = new TurnLeftNode($expression.node);}
  |  ^(FUNC_CALL TurnRight expression?) {node = new TurnRightNode($expression.node);}
  |  ^(FUNC_CALL Shoot expression?) {node = new ShootNode($expression.node);}

  ;

ifStatement returns [TLNode node]
@init  {
  IfNode ifNode = new IfNode();
  node = ifNode;
}
  :  ^(IF 
       (^(EXP expression b1=block) {ifNode.addChoice($expression.node, $b1.node);  })+ 
       (^(EXP b2=block)            {ifNode.addChoice(new AtomNode(true), $b2.node);})?
     )
  ;
   
forStatement returns [TLNode node]
  :  ^(For Identifier a=expression b=expression block) {node = new ForStatementNode($Identifier.text, $a.node, $b.node, $block.node, currentScope);}
  ;

whileStatement returns [TLNode node]
  :  ^(While expression block)
  ;

idList returns [java.util.List<String> i]
  :  ^(ID_LIST Identifier+)
  ;

exprList returns [java.util.List<TLNode> e]
  :  ^(EXP_LIST expression+)
  ;

expression returns [TLNode node]
  :  ^(TERNARY expression expression expression)
  |  ^(In expression expression)
  |  ^('||' expression expression)
  |  ^('&&' expression expression)
  |  ^('==' expression expression)
  |  ^('!=' expression expression)
  |  ^('>=' expression expression)
  |  ^('<=' expression expression)
  |  ^('>' a=expression b=expression) {node = new GTNode($a.node, $b.node);}
  |  ^('<' a=expression b=expression) {node = new LTNode($a.node, $b.node);}
  |  ^('+' a=expression b=expression) {node = new AddNode($a.node, $b.node);}
  |  ^('-' a=expression b=expression) {node = new SubtractNode($a.node, $b.node);}
  |  ^('*' a=expression b=expression) {node = new MultNode($a.node, $b.node);}
  |  ^('/' a=expression b=expression) {node = new DivideNode($a.node, $b.node);}
  |  ^('%' a=expression b=expression) {node = new ModNode($a.node, $b.node);}

  |  ^('^' expression expression)
  |  ^(UNARY_MIN expression)
  |  ^(NEGATE expression)
  |  Number {node = new AtomNode(Double.parseDouble($Number.text));}
  |  Bool
  |  Null
  |  lookup {node = $lookup.node;}           
  ;

lookup returns [TLNode node]
  :  ^(LOOKUP functionCall indexes?)
  |  ^(LOOKUP list indexes?)
  |  ^(LOOKUP expression indexes?) 
  |  ^(LOOKUP i=Identifier x=indexes?) 
      {
        node = ($x.e != null) ? 
          new LookupNode(new IdentifierNode($i.text, currentScope), $x.e) : 
          new IdentifierNode($i.text, currentScope);
      }
  |  ^(LOOKUP String indexes?)
  ;
  
list returns [TLNode node]
  :  ^(LIST exprList?)
  ;

indexes returns [java.util.List<TLNode> e]
@init {e = new java.util.ArrayList<TLNode>();}
  :  ^(INDEXES (expression {e.add($expression.node);})+)
  ;
  
