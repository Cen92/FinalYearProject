// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/grammar/TLTreeWalker.g 2014-03-11 12:52:11

  package main.tl.parser;
  import java.util.Map;
import java.util.HashMap;


import main.tl.*;
import main.tl.tree.*;
import main.tl.tree.functions.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TLTreeWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "RETURN", "STATEMENTS", "ASSIGNMENT", "FUNC_CALL", "EXP", "EXP_LIST", "ID_LIST", "IF", "TERNARY", "UNARY_MIN", "NEGATE", "FUNCTION", "INDEXES", "LIST", "LOOKUP", "Return", "Identifier", "Println", "Print", "Assert", "Size", "MoveForward", "MoveBackward", "TurnLeft", "TurnRight", "Shoot", "End", "If", "Do", "Else", "Def", "For", "To", "While", "In", "Number", "Bool", "Null", "String", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", "OBracket", "CBracket", "OParen", "CParen", "SColon", "Assign", "Comma", "QMark", "Colon", "Int", "Digit", "Comment", "Space"
    };
    public static final int FUNCTION=16;
    public static final int End=31;
    public static final int LT=53;
    public static final int OParen=63;
    public static final int Assert=24;
    public static final int TERNARY=13;
    public static final int EXP_LIST=10;
    public static final int While=38;
    public static final int MoveBackward=27;
    public static final int ID_LIST=11;
    public static final int Add=54;
    public static final int QMark=68;
    public static final int EOF=-1;
    public static final int Identifier=21;
    public static final int Int=70;
    public static final int IF=12;
    public static final int FUNC_CALL=8;
    public static final int Space=73;
    public static final int Size=25;
    public static final int MoveForward=26;
    public static final int Assign=66;
    public static final int CParen=64;
    public static final int Number=40;
    public static final int To=37;
    public static final int Comment=72;
    public static final int EXP=9;
    public static final int GTEquals=48;
    public static final int Print=23;
    public static final int CBrace=60;
    public static final int RETURN=5;
    public static final int Do=33;
    public static final int TurnRight=29;
    public static final int String=43;
    public static final int Or=44;
    public static final int Return=20;
    public static final int If=32;
    public static final int And=45;
    public static final int Null=42;
    public static final int CBracket=62;
    public static final int Println=22;
    public static final int Bool=41;
    public static final int In=39;
    public static final int NEquals=47;
    public static final int Subtract=55;
    public static final int Modulus=58;
    public static final int Multiply=56;
    public static final int OBrace=59;
    public static final int NEGATE=15;
    public static final int INDEXES=17;
    public static final int Colon=69;
    public static final int Excl=51;
    public static final int Digit=71;
    public static final int LIST=18;
    public static final int For=36;
    public static final int Divide=57;
    public static final int Shoot=30;
    public static final int Def=35;
    public static final int SColon=65;
    public static final int LOOKUP=19;
    public static final int OBracket=61;
    public static final int BLOCK=4;
    public static final int STATEMENTS=6;
    public static final int GT=52;
    public static final int UNARY_MIN=14;
    public static final int ASSIGNMENT=7;
    public static final int TurnLeft=28;
    public static final int Else=34;
    public static final int Equals=46;
    public static final int Comma=67;
    public static final int Pow=50;
    public static final int LTEquals=49;

    // delegates
    // delegators


        public TLTreeWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public TLTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TLTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "src/grammar/TLTreeWalker.g"; }


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



    // $ANTLR start "walk"
    // src/grammar/TLTreeWalker.g:32:1: walk returns [TLNode node] : block ;
    public final TLNode walk() throws RecognitionException {
        TLNode node = null;

        TLNode block1 = null;


        try {
            // src/grammar/TLTreeWalker.g:33:3: ( block )
            // src/grammar/TLTreeWalker.g:33:6: block
            {
            pushFollow(FOLLOW_block_in_walk50);
            block1=block();

            state._fsp--;

            node = block1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "walk"


    // $ANTLR start "block"
    // src/grammar/TLTreeWalker.g:36:1: block returns [TLNode node] : ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) ;
    public final TLNode block() throws RecognitionException {
        TLNode node = null;

        TLNode statement2 = null;

        TLNode expression3 = null;



          BlockNode bn = new BlockNode();
          node = bn;
          Scope scope = new Scope(currentScope);
          currentScope = scope;

        try {
            // src/grammar/TLTreeWalker.g:46:3: ( ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) )
            // src/grammar/TLTreeWalker.g:46:6: ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block81); 

            match(input, Token.DOWN, null); 
            match(input,STATEMENTS,FOLLOW_STATEMENTS_in_block94); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/grammar/TLTreeWalker.g:47:23: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=ASSIGNMENT && LA1_0<=FUNC_CALL)||LA1_0==IF||LA1_0==For||LA1_0==While) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // src/grammar/TLTreeWalker.g:47:24: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_block97);
                	    statement2=statement();

                	    state._fsp--;

                	    bn.addStatement(statement2);

                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            match(input,RETURN,FOLLOW_RETURN_in_block117); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/grammar/TLTreeWalker.g:48:23: ( expression )?
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=TERNARY && LA2_0<=NEGATE)||LA2_0==LOOKUP||(LA2_0>=In && LA2_0<=Null)||(LA2_0>=Or && LA2_0<=Pow)||(LA2_0>=GT && LA2_0<=Modulus)) ) {
                    alt2=1;
                }
                switch (alt2) {
                    case 1 :
                        // src/grammar/TLTreeWalker.g:48:24: expression
                        {
                        pushFollow(FOLLOW_expression_in_block124);
                        expression3=expression();

                        state._fsp--;

                        bn.addReturn(expression3);  

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 

            }


              currentScope = currentScope.parent();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "block"


    // $ANTLR start "statement"
    // src/grammar/TLTreeWalker.g:52:1: statement returns [TLNode node] : ( assignment | functionCall | ifStatement | forStatement | whileStatement );
    public final TLNode statement() throws RecognitionException {
        TLNode node = null;

        TLNode assignment4 = null;

        TLNode functionCall5 = null;

        TLNode ifStatement6 = null;

        TLNode forStatement7 = null;

        TLNode whileStatement8 = null;


        try {
            // src/grammar/TLTreeWalker.g:53:3: ( assignment | functionCall | ifStatement | forStatement | whileStatement )
            int alt3=5;
            switch ( input.LA(1) ) {
            case ASSIGNMENT:
                {
                alt3=1;
                }
                break;
            case FUNC_CALL:
                {
                alt3=2;
                }
                break;
            case IF:
                {
                alt3=3;
                }
                break;
            case For:
                {
                alt3=4;
                }
                break;
            case While:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // src/grammar/TLTreeWalker.g:53:6: assignment
                    {
                    pushFollow(FOLLOW_assignment_in_statement156);
                    assignment4=assignment();

                    state._fsp--;

                    node = assignment4;

                    }
                    break;
                case 2 :
                    // src/grammar/TLTreeWalker.g:54:6: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_statement169);
                    functionCall5=functionCall();

                    state._fsp--;

                    node = functionCall5;

                    }
                    break;
                case 3 :
                    // src/grammar/TLTreeWalker.g:55:6: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement180);
                    ifStatement6=ifStatement();

                    state._fsp--;

                    node = ifStatement6;

                    }
                    break;
                case 4 :
                    // src/grammar/TLTreeWalker.g:56:6: forStatement
                    {
                    pushFollow(FOLLOW_forStatement_in_statement192);
                    forStatement7=forStatement();

                    state._fsp--;

                    node = forStatement7;

                    }
                    break;
                case 5 :
                    // src/grammar/TLTreeWalker.g:57:6: whileStatement
                    {
                    pushFollow(FOLLOW_whileStatement_in_statement203);
                    whileStatement8=whileStatement();

                    state._fsp--;

                    node = whileStatement8;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "statement"


    // $ANTLR start "assignment"
    // src/grammar/TLTreeWalker.g:60:1: assignment returns [TLNode node] : ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression ) ;
    public final TLNode assignment() throws RecognitionException {
        TLNode node = null;

        CommonTree i=null;
        java.util.List<TLNode> x = null;

        TLNode e = null;


        try {
            // src/grammar/TLTreeWalker.g:61:3: ( ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression ) )
            // src/grammar/TLTreeWalker.g:61:6: ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression )
            {
            match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignment224); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_assignment228); 
            // src/grammar/TLTreeWalker.g:61:33: (x= indexes )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==INDEXES) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/grammar/TLTreeWalker.g:61:33: x= indexes
                    {
                    pushFollow(FOLLOW_indexes_in_assignment232);
                    x=indexes();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_assignment237);
            e=expression();

            state._fsp--;


            match(input, Token.UP, null); 
            node = new AssignmentNode((i!=null?i.getText():null), x, e, currentScope);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "functionCall"
    // src/grammar/TLTreeWalker.g:65:1: functionCall returns [TLNode node] : ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) | ^( FUNC_CALL MoveForward ( expression )? ) | ^( FUNC_CALL MoveBackward ( expression )? ) | ^( FUNC_CALL TurnLeft ( expression )? ) | ^( FUNC_CALL TurnRight ( expression )? ) | ^( FUNC_CALL Shoot ( expression )? ) );
    public final TLNode functionCall() throws RecognitionException {
        TLNode node = null;

        TLNode expression9 = null;

        TLNode expression10 = null;

        TLNode expression11 = null;

        TLNode expression12 = null;

        TLNode expression13 = null;

        TLNode expression14 = null;


        try {
            // src/grammar/TLTreeWalker.g:66:3: ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) | ^( FUNC_CALL MoveForward ( expression )? ) | ^( FUNC_CALL MoveBackward ( expression )? ) | ^( FUNC_CALL TurnLeft ( expression )? ) | ^( FUNC_CALL TurnRight ( expression )? ) | ^( FUNC_CALL Shoot ( expression )? ) )
            int alt12=10;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // src/grammar/TLTreeWalker.g:66:6: ^( FUNC_CALL Identifier ( exprList )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall265); 

                    match(input, Token.DOWN, null); 
                    match(input,Identifier,FOLLOW_Identifier_in_functionCall267); 
                    // src/grammar/TLTreeWalker.g:66:29: ( exprList )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==EXP_LIST) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:66:29: exprList
                            {
                            pushFollow(FOLLOW_exprList_in_functionCall269);
                            exprList();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/grammar/TLTreeWalker.g:67:6: ^( FUNC_CALL Println ( expression )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall279); 

                    match(input, Token.DOWN, null); 
                    match(input,Println,FOLLOW_Println_in_functionCall281); 
                    // src/grammar/TLTreeWalker.g:67:26: ( expression )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=TERNARY && LA6_0<=NEGATE)||LA6_0==LOOKUP||(LA6_0>=In && LA6_0<=Null)||(LA6_0>=Or && LA6_0<=Pow)||(LA6_0>=GT && LA6_0<=Modulus)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:67:26: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall283);
                            expression9=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    node = new PrintlnNode(expression9);

                    }
                    break;
                case 3 :
                    // src/grammar/TLTreeWalker.g:68:6: ^( FUNC_CALL Print expression )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall295); 

                    match(input, Token.DOWN, null); 
                    match(input,Print,FOLLOW_Print_in_functionCall297); 
                    pushFollow(FOLLOW_expression_in_functionCall299);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/grammar/TLTreeWalker.g:69:6: ^( FUNC_CALL Assert expression )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall308); 

                    match(input, Token.DOWN, null); 
                    match(input,Assert,FOLLOW_Assert_in_functionCall310); 
                    pushFollow(FOLLOW_expression_in_functionCall312);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/grammar/TLTreeWalker.g:70:6: ^( FUNC_CALL Size expression )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall321); 

                    match(input, Token.DOWN, null); 
                    match(input,Size,FOLLOW_Size_in_functionCall323); 
                    pushFollow(FOLLOW_expression_in_functionCall325);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/grammar/TLTreeWalker.g:71:6: ^( FUNC_CALL MoveForward ( expression )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall334); 

                    match(input, Token.DOWN, null); 
                    match(input,MoveForward,FOLLOW_MoveForward_in_functionCall336); 
                    // src/grammar/TLTreeWalker.g:71:30: ( expression )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=TERNARY && LA7_0<=NEGATE)||LA7_0==LOOKUP||(LA7_0>=In && LA7_0<=Null)||(LA7_0>=Or && LA7_0<=Pow)||(LA7_0>=GT && LA7_0<=Modulus)) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:71:30: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall338);
                            expression10=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    node = new MoveForwardNode(expression10);

                    }
                    break;
                case 7 :
                    // src/grammar/TLTreeWalker.g:72:6: ^( FUNC_CALL MoveBackward ( expression )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall350); 

                    match(input, Token.DOWN, null); 
                    match(input,MoveBackward,FOLLOW_MoveBackward_in_functionCall352); 
                    // src/grammar/TLTreeWalker.g:72:31: ( expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=TERNARY && LA8_0<=NEGATE)||LA8_0==LOOKUP||(LA8_0>=In && LA8_0<=Null)||(LA8_0>=Or && LA8_0<=Pow)||(LA8_0>=GT && LA8_0<=Modulus)) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:72:31: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall354);
                            expression11=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    node = new MoveBackwardNode(expression11);

                    }
                    break;
                case 8 :
                    // src/grammar/TLTreeWalker.g:73:6: ^( FUNC_CALL TurnLeft ( expression )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall366); 

                    match(input, Token.DOWN, null); 
                    match(input,TurnLeft,FOLLOW_TurnLeft_in_functionCall368); 
                    // src/grammar/TLTreeWalker.g:73:27: ( expression )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=TERNARY && LA9_0<=NEGATE)||LA9_0==LOOKUP||(LA9_0>=In && LA9_0<=Null)||(LA9_0>=Or && LA9_0<=Pow)||(LA9_0>=GT && LA9_0<=Modulus)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:73:27: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall370);
                            expression12=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    node = new TurnLeftNode(expression12);

                    }
                    break;
                case 9 :
                    // src/grammar/TLTreeWalker.g:74:6: ^( FUNC_CALL TurnRight ( expression )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall382); 

                    match(input, Token.DOWN, null); 
                    match(input,TurnRight,FOLLOW_TurnRight_in_functionCall384); 
                    // src/grammar/TLTreeWalker.g:74:28: ( expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=TERNARY && LA10_0<=NEGATE)||LA10_0==LOOKUP||(LA10_0>=In && LA10_0<=Null)||(LA10_0>=Or && LA10_0<=Pow)||(LA10_0>=GT && LA10_0<=Modulus)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:74:28: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall386);
                            expression13=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    node = new TurnRightNode(expression13);

                    }
                    break;
                case 10 :
                    // src/grammar/TLTreeWalker.g:75:6: ^( FUNC_CALL Shoot ( expression )? )
                    {
                    match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall398); 

                    match(input, Token.DOWN, null); 
                    match(input,Shoot,FOLLOW_Shoot_in_functionCall400); 
                    // src/grammar/TLTreeWalker.g:75:24: ( expression )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=TERNARY && LA11_0<=NEGATE)||LA11_0==LOOKUP||(LA11_0>=In && LA11_0<=Null)||(LA11_0>=Or && LA11_0<=Pow)||(LA11_0>=GT && LA11_0<=Modulus)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:75:24: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall402);
                            expression14=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    node = new ShootNode(expression14);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "functionCall"


    // $ANTLR start "ifStatement"
    // src/grammar/TLTreeWalker.g:79:1: ifStatement returns [TLNode node] : ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? ) ;
    public final TLNode ifStatement() throws RecognitionException {
        TLNode node = null;

        TLNode b1 = null;

        TLNode b2 = null;

        TLNode expression15 = null;



          IfNode ifNode = new IfNode();
          node = ifNode;

        try {
            // src/grammar/TLTreeWalker.g:84:3: ( ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? ) )
            // src/grammar/TLTreeWalker.g:84:6: ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? )
            {
            match(input,IF,FOLLOW_IF_in_ifStatement432); 

            match(input, Token.DOWN, null); 
            // src/grammar/TLTreeWalker.g:85:8: ( ^( EXP expression b1= block ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==EXP) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==DOWN) ) {
                        int LA13_3 = input.LA(3);

                        if ( ((LA13_3>=TERNARY && LA13_3<=NEGATE)||LA13_3==LOOKUP||(LA13_3>=In && LA13_3<=Null)||(LA13_3>=Or && LA13_3<=Pow)||(LA13_3>=GT && LA13_3<=Modulus)) ) {
                            alt13=1;
                        }


                    }


                }


                switch (alt13) {
            	case 1 :
            	    // src/grammar/TLTreeWalker.g:85:9: ^( EXP expression b1= block )
            	    {
            	    match(input,EXP,FOLLOW_EXP_in_ifStatement444); 

            	    match(input, Token.DOWN, null); 
            	    pushFollow(FOLLOW_expression_in_ifStatement446);
            	    expression15=expression();

            	    state._fsp--;

            	    pushFollow(FOLLOW_block_in_ifStatement450);
            	    b1=block();

            	    state._fsp--;


            	    match(input, Token.UP, null); 
            	    ifNode.addChoice(expression15, b1);  

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // src/grammar/TLTreeWalker.g:86:8: ( ^( EXP b2= block ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==EXP) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/grammar/TLTreeWalker.g:86:9: ^( EXP b2= block )
                    {
                    match(input,EXP,FOLLOW_EXP_in_ifStatement467); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ifStatement471);
                    b2=block();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    ifNode.addChoice(new AtomNode(true), b2);

                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "ifStatement"


    // $ANTLR start "forStatement"
    // src/grammar/TLTreeWalker.g:90:1: forStatement returns [TLNode node] : ^( For Identifier expression expression block ) ;
    public final TLNode forStatement() throws RecognitionException {
        TLNode node = null;

        try {
            // src/grammar/TLTreeWalker.g:91:3: ( ^( For Identifier expression expression block ) )
            // src/grammar/TLTreeWalker.g:91:6: ^( For Identifier expression expression block )
            {
            match(input,For,FOLLOW_For_in_forStatement516); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_forStatement518); 
            pushFollow(FOLLOW_expression_in_forStatement520);
            expression();

            state._fsp--;

            pushFollow(FOLLOW_expression_in_forStatement522);
            expression();

            state._fsp--;

            pushFollow(FOLLOW_block_in_forStatement524);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "forStatement"


    // $ANTLR start "whileStatement"
    // src/grammar/TLTreeWalker.g:94:1: whileStatement returns [TLNode node] : ^( While expression block ) ;
    public final TLNode whileStatement() throws RecognitionException {
        TLNode node = null;

        try {
            // src/grammar/TLTreeWalker.g:95:3: ( ^( While expression block ) )
            // src/grammar/TLTreeWalker.g:95:6: ^( While expression block )
            {
            match(input,While,FOLLOW_While_in_whileStatement544); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_whileStatement546);
            expression();

            state._fsp--;

            pushFollow(FOLLOW_block_in_whileStatement548);
            block();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "whileStatement"


    // $ANTLR start "idList"
    // src/grammar/TLTreeWalker.g:98:1: idList returns [java.util.List<String> i] : ^( ID_LIST ( Identifier )+ ) ;
    public final java.util.List<String> idList() throws RecognitionException {
        java.util.List<String> i = null;

        try {
            // src/grammar/TLTreeWalker.g:99:3: ( ^( ID_LIST ( Identifier )+ ) )
            // src/grammar/TLTreeWalker.g:99:6: ^( ID_LIST ( Identifier )+ )
            {
            match(input,ID_LIST,FOLLOW_ID_LIST_in_idList568); 

            match(input, Token.DOWN, null); 
            // src/grammar/TLTreeWalker.g:99:16: ( Identifier )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Identifier) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/grammar/TLTreeWalker.g:99:16: Identifier
            	    {
            	    match(input,Identifier,FOLLOW_Identifier_in_idList570); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return i;
    }
    // $ANTLR end "idList"


    // $ANTLR start "exprList"
    // src/grammar/TLTreeWalker.g:102:1: exprList returns [java.util.List<TLNode> e] : ^( EXP_LIST ( expression )+ ) ;
    public final java.util.List<TLNode> exprList() throws RecognitionException {
        java.util.List<TLNode> e = null;

        try {
            // src/grammar/TLTreeWalker.g:103:3: ( ^( EXP_LIST ( expression )+ ) )
            // src/grammar/TLTreeWalker.g:103:6: ^( EXP_LIST ( expression )+ )
            {
            match(input,EXP_LIST,FOLLOW_EXP_LIST_in_exprList591); 

            match(input, Token.DOWN, null); 
            // src/grammar/TLTreeWalker.g:103:17: ( expression )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=TERNARY && LA16_0<=NEGATE)||LA16_0==LOOKUP||(LA16_0>=In && LA16_0<=Null)||(LA16_0>=Or && LA16_0<=Pow)||(LA16_0>=GT && LA16_0<=Modulus)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/grammar/TLTreeWalker.g:103:17: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_exprList593);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "exprList"


    // $ANTLR start "expression"
    // src/grammar/TLTreeWalker.g:106:1: expression returns [TLNode node] : ( ^( TERNARY expression expression expression ) | ^( In expression expression ) | ^( '||' expression expression ) | ^( '&&' expression expression ) | ^( '==' expression expression ) | ^( '!=' expression expression ) | ^( '>=' expression expression ) | ^( '<=' expression expression ) | ^( '>' a= expression b= expression ) | ^( '<' a= expression b= expression ) | ^( '+' a= expression b= expression ) | ^( '-' a= expression b= expression ) | ^( '*' a= expression b= expression ) | ^( '/' a= expression b= expression ) | ^( '%' a= expression b= expression ) | ^( '^' expression expression ) | ^( UNARY_MIN expression ) | ^( NEGATE expression ) | Number | Bool | Null | lookup );
    public final TLNode expression() throws RecognitionException {
        TLNode node = null;

        CommonTree Number16=null;
        TLNode a = null;

        TLNode b = null;

        TLNode lookup17 = null;


        try {
            // src/grammar/TLTreeWalker.g:107:3: ( ^( TERNARY expression expression expression ) | ^( In expression expression ) | ^( '||' expression expression ) | ^( '&&' expression expression ) | ^( '==' expression expression ) | ^( '!=' expression expression ) | ^( '>=' expression expression ) | ^( '<=' expression expression ) | ^( '>' a= expression b= expression ) | ^( '<' a= expression b= expression ) | ^( '+' a= expression b= expression ) | ^( '-' a= expression b= expression ) | ^( '*' a= expression b= expression ) | ^( '/' a= expression b= expression ) | ^( '%' a= expression b= expression ) | ^( '^' expression expression ) | ^( UNARY_MIN expression ) | ^( NEGATE expression ) | Number | Bool | Null | lookup )
            int alt17=22;
            switch ( input.LA(1) ) {
            case TERNARY:
                {
                alt17=1;
                }
                break;
            case In:
                {
                alt17=2;
                }
                break;
            case Or:
                {
                alt17=3;
                }
                break;
            case And:
                {
                alt17=4;
                }
                break;
            case Equals:
                {
                alt17=5;
                }
                break;
            case NEquals:
                {
                alt17=6;
                }
                break;
            case GTEquals:
                {
                alt17=7;
                }
                break;
            case LTEquals:
                {
                alt17=8;
                }
                break;
            case GT:
                {
                alt17=9;
                }
                break;
            case LT:
                {
                alt17=10;
                }
                break;
            case Add:
                {
                alt17=11;
                }
                break;
            case Subtract:
                {
                alt17=12;
                }
                break;
            case Multiply:
                {
                alt17=13;
                }
                break;
            case Divide:
                {
                alt17=14;
                }
                break;
            case Modulus:
                {
                alt17=15;
                }
                break;
            case Pow:
                {
                alt17=16;
                }
                break;
            case UNARY_MIN:
                {
                alt17=17;
                }
                break;
            case NEGATE:
                {
                alt17=18;
                }
                break;
            case Number:
                {
                alt17=19;
                }
                break;
            case Bool:
                {
                alt17=20;
                }
                break;
            case Null:
                {
                alt17=21;
                }
                break;
            case LOOKUP:
                {
                alt17=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // src/grammar/TLTreeWalker.g:107:6: ^( TERNARY expression expression expression )
                    {
                    match(input,TERNARY,FOLLOW_TERNARY_in_expression614); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression616);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression618);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression620);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/grammar/TLTreeWalker.g:108:6: ^( In expression expression )
                    {
                    match(input,In,FOLLOW_In_in_expression629); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression631);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression633);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/grammar/TLTreeWalker.g:109:6: ^( '||' expression expression )
                    {
                    match(input,Or,FOLLOW_Or_in_expression642); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression644);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression646);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/grammar/TLTreeWalker.g:110:6: ^( '&&' expression expression )
                    {
                    match(input,And,FOLLOW_And_in_expression655); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression657);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression659);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/grammar/TLTreeWalker.g:111:6: ^( '==' expression expression )
                    {
                    match(input,Equals,FOLLOW_Equals_in_expression668); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression670);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression672);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // src/grammar/TLTreeWalker.g:112:6: ^( '!=' expression expression )
                    {
                    match(input,NEquals,FOLLOW_NEquals_in_expression681); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression683);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression685);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // src/grammar/TLTreeWalker.g:113:6: ^( '>=' expression expression )
                    {
                    match(input,GTEquals,FOLLOW_GTEquals_in_expression694); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression696);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression698);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // src/grammar/TLTreeWalker.g:114:6: ^( '<=' expression expression )
                    {
                    match(input,LTEquals,FOLLOW_LTEquals_in_expression707); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression709);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression711);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // src/grammar/TLTreeWalker.g:115:6: ^( '>' a= expression b= expression )
                    {
                    match(input,GT,FOLLOW_GT_in_expression720); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression724);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression728);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new GTNode(a, b);

                    }
                    break;
                case 10 :
                    // src/grammar/TLTreeWalker.g:116:6: ^( '<' a= expression b= expression )
                    {
                    match(input,LT,FOLLOW_LT_in_expression739); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression743);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression747);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new LTNode(a, b);

                    }
                    break;
                case 11 :
                    // src/grammar/TLTreeWalker.g:117:6: ^( '+' a= expression b= expression )
                    {
                    match(input,Add,FOLLOW_Add_in_expression758); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression762);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression766);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new AddNode(a, b);

                    }
                    break;
                case 12 :
                    // src/grammar/TLTreeWalker.g:118:6: ^( '-' a= expression b= expression )
                    {
                    match(input,Subtract,FOLLOW_Subtract_in_expression777); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression781);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression785);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new SubtractNode(a, b);

                    }
                    break;
                case 13 :
                    // src/grammar/TLTreeWalker.g:119:6: ^( '*' a= expression b= expression )
                    {
                    match(input,Multiply,FOLLOW_Multiply_in_expression796); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression800);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression804);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new MultNode(a, b);

                    }
                    break;
                case 14 :
                    // src/grammar/TLTreeWalker.g:120:6: ^( '/' a= expression b= expression )
                    {
                    match(input,Divide,FOLLOW_Divide_in_expression815); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression819);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression823);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new DivideNode(a, b);

                    }
                    break;
                case 15 :
                    // src/grammar/TLTreeWalker.g:121:6: ^( '%' a= expression b= expression )
                    {
                    match(input,Modulus,FOLLOW_Modulus_in_expression834); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression838);
                    a=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression842);
                    b=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    node = new ModNode(a, b);

                    }
                    break;
                case 16 :
                    // src/grammar/TLTreeWalker.g:123:6: ^( '^' expression expression )
                    {
                    match(input,Pow,FOLLOW_Pow_in_expression854); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression856);
                    expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression858);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/grammar/TLTreeWalker.g:124:6: ^( UNARY_MIN expression )
                    {
                    match(input,UNARY_MIN,FOLLOW_UNARY_MIN_in_expression867); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression869);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 18 :
                    // src/grammar/TLTreeWalker.g:125:6: ^( NEGATE expression )
                    {
                    match(input,NEGATE,FOLLOW_NEGATE_in_expression878); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression880);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 19 :
                    // src/grammar/TLTreeWalker.g:126:6: Number
                    {
                    Number16=(CommonTree)match(input,Number,FOLLOW_Number_in_expression888); 
                    node = new AtomNode(Double.parseDouble((Number16!=null?Number16.getText():null)));

                    }
                    break;
                case 20 :
                    // src/grammar/TLTreeWalker.g:127:6: Bool
                    {
                    match(input,Bool,FOLLOW_Bool_in_expression897); 

                    }
                    break;
                case 21 :
                    // src/grammar/TLTreeWalker.g:128:6: Null
                    {
                    match(input,Null,FOLLOW_Null_in_expression904); 

                    }
                    break;
                case 22 :
                    // src/grammar/TLTreeWalker.g:129:6: lookup
                    {
                    pushFollow(FOLLOW_lookup_in_expression911);
                    lookup17=lookup();

                    state._fsp--;

                    node = lookup17;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "expression"


    // $ANTLR start "lookup"
    // src/grammar/TLTreeWalker.g:132:1: lookup returns [TLNode node] : ( ^( LOOKUP functionCall ( indexes )? ) | ^( LOOKUP list ( indexes )? ) | ^( LOOKUP expression ( indexes )? ) | ^( LOOKUP i= Identifier (x= indexes )? ) | ^( LOOKUP String ( indexes )? ) );
    public final TLNode lookup() throws RecognitionException {
        TLNode node = null;

        CommonTree i=null;
        java.util.List<TLNode> x = null;


        try {
            // src/grammar/TLTreeWalker.g:133:3: ( ^( LOOKUP functionCall ( indexes )? ) | ^( LOOKUP list ( indexes )? ) | ^( LOOKUP expression ( indexes )? ) | ^( LOOKUP i= Identifier (x= indexes )? ) | ^( LOOKUP String ( indexes )? ) )
            int alt23=5;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LOOKUP) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case Identifier:
                        {
                        alt23=4;
                        }
                        break;
                    case String:
                        {
                        alt23=5;
                        }
                        break;
                    case FUNC_CALL:
                        {
                        alt23=1;
                        }
                        break;
                    case TERNARY:
                    case UNARY_MIN:
                    case NEGATE:
                    case LOOKUP:
                    case In:
                    case Number:
                    case Bool:
                    case Null:
                    case Or:
                    case And:
                    case Equals:
                    case NEquals:
                    case GTEquals:
                    case LTEquals:
                    case Pow:
                    case GT:
                    case LT:
                    case Add:
                    case Subtract:
                    case Multiply:
                    case Divide:
                    case Modulus:
                        {
                        alt23=3;
                        }
                        break;
                    case LIST:
                        {
                        alt23=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // src/grammar/TLTreeWalker.g:133:6: ^( LOOKUP functionCall ( indexes )? )
                    {
                    match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup943); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionCall_in_lookup945);
                    functionCall();

                    state._fsp--;

                    // src/grammar/TLTreeWalker.g:133:28: ( indexes )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==INDEXES) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:133:28: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup947);
                            indexes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/grammar/TLTreeWalker.g:134:6: ^( LOOKUP list ( indexes )? )
                    {
                    match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup957); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_list_in_lookup959);
                    list();

                    state._fsp--;

                    // src/grammar/TLTreeWalker.g:134:20: ( indexes )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==INDEXES) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:134:20: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup961);
                            indexes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/grammar/TLTreeWalker.g:135:6: ^( LOOKUP expression ( indexes )? )
                    {
                    match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup971); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_lookup973);
                    expression();

                    state._fsp--;

                    // src/grammar/TLTreeWalker.g:135:26: ( indexes )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==INDEXES) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:135:26: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup975);
                            indexes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/grammar/TLTreeWalker.g:136:6: ^( LOOKUP i= Identifier (x= indexes )? )
                    {
                    match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup986); 

                    match(input, Token.DOWN, null); 
                    i=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_lookup990); 
                    // src/grammar/TLTreeWalker.g:136:29: (x= indexes )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==INDEXES) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:136:29: x= indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup994);
                            x=indexes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                            node = (x != null) ? 
                              new LookupNode(new IdentifierNode((i!=null?i.getText():null), currentScope), x) : 
                              new IdentifierNode((i!=null?i.getText():null), currentScope);
                          

                    }
                    break;
                case 5 :
                    // src/grammar/TLTreeWalker.g:142:6: ^( LOOKUP String ( indexes )? )
                    {
                    match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1013); 

                    match(input, Token.DOWN, null); 
                    match(input,String,FOLLOW_String_in_lookup1015); 
                    // src/grammar/TLTreeWalker.g:142:22: ( indexes )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==INDEXES) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // src/grammar/TLTreeWalker.g:142:22: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup1017);
                            indexes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "lookup"


    // $ANTLR start "list"
    // src/grammar/TLTreeWalker.g:145:1: list returns [TLNode node] : ^( LIST ( exprList )? ) ;
    public final TLNode list() throws RecognitionException {
        TLNode node = null;

        try {
            // src/grammar/TLTreeWalker.g:146:3: ( ^( LIST ( exprList )? ) )
            // src/grammar/TLTreeWalker.g:146:6: ^( LIST ( exprList )? )
            {
            match(input,LIST,FOLLOW_LIST_in_list1040); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/grammar/TLTreeWalker.g:146:13: ( exprList )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==EXP_LIST) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // src/grammar/TLTreeWalker.g:146:13: exprList
                        {
                        pushFollow(FOLLOW_exprList_in_list1042);
                        exprList();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return node;
    }
    // $ANTLR end "list"


    // $ANTLR start "indexes"
    // src/grammar/TLTreeWalker.g:149:1: indexes returns [java.util.List<TLNode> e] : ^( INDEXES ( expression )+ ) ;
    public final java.util.List<TLNode> indexes() throws RecognitionException {
        java.util.List<TLNode> e = null;

        TLNode expression18 = null;


        e = new java.util.ArrayList<TLNode>();
        try {
            // src/grammar/TLTreeWalker.g:151:3: ( ^( INDEXES ( expression )+ ) )
            // src/grammar/TLTreeWalker.g:151:6: ^( INDEXES ( expression )+ )
            {
            match(input,INDEXES,FOLLOW_INDEXES_in_indexes1068); 

            match(input, Token.DOWN, null); 
            // src/grammar/TLTreeWalker.g:151:16: ( expression )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=TERNARY && LA25_0<=NEGATE)||LA25_0==LOOKUP||(LA25_0>=In && LA25_0<=Null)||(LA25_0>=Or && LA25_0<=Pow)||(LA25_0>=GT && LA25_0<=Modulus)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/grammar/TLTreeWalker.g:151:17: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_indexes1071);
            	    expression18=expression();

            	    state._fsp--;

            	    e.add(expression18);

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "indexes"

    // Delegated rules


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\15\uffff";
    static final String DFA12_eofS =
        "\15\uffff";
    static final String DFA12_minS =
        "\1\10\1\2\1\25\12\uffff";
    static final String DFA12_maxS =
        "\1\10\1\2\1\36\12\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String DFA12_specialS =
        "\15\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "65:1: functionCall returns [TLNode node] : ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) | ^( FUNC_CALL MoveForward ( expression )? ) | ^( FUNC_CALL MoveBackward ( expression )? ) | ^( FUNC_CALL TurnLeft ( expression )? ) | ^( FUNC_CALL TurnRight ( expression )? ) | ^( FUNC_CALL Shoot ( expression )? ) );";
        }
    }
 

    public static final BitSet FOLLOW_block_in_walk50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STATEMENTS_in_block94 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block97 = new BitSet(new long[]{0x0000005000001188L});
    public static final BitSet FOLLOW_RETURN_in_block117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_block124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assignment_in_statement156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_statement169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_assignment224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_assignment228 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_indexes_in_assignment232 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_assignment237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_functionCall267 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_exprList_in_functionCall269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Println_in_functionCall281 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_expression_in_functionCall283 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Print_in_functionCall297 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_functionCall299 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall308 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Assert_in_functionCall310 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_functionCall312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Size_in_functionCall323 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_functionCall325 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MoveForward_in_functionCall336 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_expression_in_functionCall338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MoveBackward_in_functionCall352 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_expression_in_functionCall354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TurnLeft_in_functionCall368 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_expression_in_functionCall370 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TurnRight_in_functionCall384 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_expression_in_functionCall386 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_CALL_in_functionCall398 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Shoot_in_functionCall400 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_expression_in_functionCall402 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifStatement432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXP_in_ifStatement444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ifStatement446 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_block_in_ifStatement450 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXP_in_ifStatement467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ifStatement471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_For_in_forStatement516 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_forStatement518 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_forStatement520 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_forStatement522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_block_in_forStatement524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_While_in_whileStatement544 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_whileStatement546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_block_in_whileStatement548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_LIST_in_idList568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_idList570 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_EXP_LIST_in_exprList591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_exprList593 = new BitSet(new long[]{0x07F7F780000AE008L});
    public static final BitSet FOLLOW_TERNARY_in_expression614 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression616 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression618 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression620 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_In_in_expression629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression631 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Or_in_expression642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression644 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression646 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_And_in_expression655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression657 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression659 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Equals_in_expression668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression670 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEquals_in_expression681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression683 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GTEquals_in_expression694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression696 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression698 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LTEquals_in_expression707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression709 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expression720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression724 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expression739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression743 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression747 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Add_in_expression758 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression762 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Subtract_in_expression777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression781 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression785 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Multiply_in_expression796 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression800 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression804 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Divide_in_expression815 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression819 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Modulus_in_expression834 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression838 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression842 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Pow_in_expression854 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression856 = new BitSet(new long[]{0x07F7F780000AE000L});
    public static final BitSet FOLLOW_expression_in_expression858 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_MIN_in_expression867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATE_in_expression878 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression880 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Number_in_expression888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_expression897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Null_in_expression904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lookup_in_expression911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup943 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionCall_in_lookup945 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_indexes_in_lookup947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup957 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_list_in_lookup959 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_indexes_in_lookup961 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_lookup973 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_indexes_in_lookup975 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup986 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_lookup990 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_indexes_in_lookup994 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup1013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_String_in_lookup1015 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_indexes_in_lookup1017 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIST_in_list1040 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_exprList_in_list1042 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDEXES_in_indexes1068 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_indexes1071 = new BitSet(new long[]{0x07F7F780000AE008L});

}