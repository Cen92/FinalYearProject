// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/grammar/TL.g 2014-03-11 12:52:10

  package main.tl.parser;
  import java.util.Map;
import java.util.HashMap;


import main.tl.*;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "RETURN", "STATEMENTS", "ASSIGNMENT", "FUNC_CALL", "EXP", "EXP_LIST", "ID_LIST", "IF", "TERNARY", "UNARY_MIN", "NEGATE", "FUNCTION", "INDEXES", "LIST", "LOOKUP", "Return", "Identifier", "Println", "Print", "Assert", "Size", "MoveForward", "MoveBackward", "TurnLeft", "TurnRight", "Shoot", "End", "If", "Do", "Else", "Def", "For", "To", "While", "In", "Number", "Bool", "Null", "String", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", "OBracket", "CBracket", "OParen", "CParen", "SColon", "Assign", "Comma", "QMark", "Colon", "Int", "Digit", "Comment", "Space"
    };
    public static final int FUNCTION=16;
    public static final int End=31;
    public static final int OParen=63;
    public static final int LT=53;
    public static final int Assert=24;
    public static final int TERNARY=13;
    public static final int EXP_LIST=10;
    public static final int MoveBackward=27;
    public static final int While=38;
    public static final int ID_LIST=11;
    public static final int QMark=68;
    public static final int Add=54;
    public static final int EOF=-1;
    public static final int Int=70;
    public static final int Identifier=21;
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
    public static final int In=39;
    public static final int Bool=41;
    public static final int NEquals=47;
    public static final int Subtract=55;
    public static final int Modulus=58;
    public static final int Multiply=56;
    public static final int OBrace=59;
    public static final int INDEXES=17;
    public static final int NEGATE=15;
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
    public static final int GT=52;
    public static final int STATEMENTS=6;
    public static final int UNARY_MIN=14;
    public static final int ASSIGNMENT=7;
    public static final int TurnLeft=28;
    public static final int Else=34;
    public static final int Comma=67;
    public static final int Equals=46;
    public static final int Pow=50;
    public static final int LTEquals=49;

    // delegates
    // delegators


        public TLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return TLParser.tokenNames; }
    public String getGrammarFileName() { return "src/grammar/TL.g"; }


      public Map<String, Function> functions = new HashMap<String, Function>();
      
      private void defineFunction(String id, Object idList, Object block) {

        // `idList` is possibly null! Create an empty tree in that case. 
        CommonTree idListTree = idList == null ? new CommonTree() : (CommonTree)idList;

        // `block` is never null.
        CommonTree blockTree = (CommonTree)block;

        // The function name with the number of parameters after it the unique key
        String key = id + idListTree.getChildCount();
        functions.put(key, new Function(id, idListTree, blockTree));
      }


    public static class parse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parse"
    // src/grammar/TL.g:55:1: parse : block EOF -> block ;
    public final TLParser.parse_return parse() throws RecognitionException {
        TLParser.parse_return retval = new TLParser.parse_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF2=null;
        TLParser.block_return block1 = null;


        Object EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/grammar/TL.g:56:3: ( block EOF -> block )
            // src/grammar/TL.g:56:6: block EOF
            {
            pushFollow(FOLLOW_block_in_parse138);
            block1=block();

            state._fsp--;

            stream_block.add(block1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse140);  
            stream_EOF.add(EOF2);



            // AST REWRITE
            // elements: block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 56:16: -> block
            {
                adaptor.addChild(root_0, stream_block.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parse"

    public static class block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // src/grammar/TL.g:59:1: block : ( statement | functionDecl )* ( Return expression ';' )? -> ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) ;
    public final TLParser.block_return block() throws RecognitionException {
        TLParser.block_return retval = new TLParser.block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Return5=null;
        Token char_literal7=null;
        TLParser.statement_return statement3 = null;

        TLParser.functionDecl_return functionDecl4 = null;

        TLParser.expression_return expression6 = null;


        Object Return5_tree=null;
        Object char_literal7_tree=null;
        RewriteRuleTokenStream stream_Return=new RewriteRuleTokenStream(adaptor,"token Return");
        RewriteRuleTokenStream stream_SColon=new RewriteRuleTokenStream(adaptor,"token SColon");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_functionDecl=new RewriteRuleSubtreeStream(adaptor,"rule functionDecl");
        try {
            // src/grammar/TL.g:60:3: ( ( statement | functionDecl )* ( Return expression ';' )? -> ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) )
            // src/grammar/TL.g:60:6: ( statement | functionDecl )* ( Return expression ';' )?
            {
            // src/grammar/TL.g:60:6: ( statement | functionDecl )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Identifier && LA1_0<=Shoot)||LA1_0==If||LA1_0==For||LA1_0==While) ) {
                    alt1=1;
                }
                else if ( (LA1_0==Def) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // src/grammar/TL.g:60:7: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block159);
            	    statement3=statement();

            	    state._fsp--;

            	    stream_statement.add(statement3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // src/grammar/TL.g:60:19: functionDecl
            	    {
            	    pushFollow(FOLLOW_functionDecl_in_block163);
            	    functionDecl4=functionDecl();

            	    state._fsp--;

            	    stream_functionDecl.add(functionDecl4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // src/grammar/TL.g:60:34: ( Return expression ';' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Return) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/grammar/TL.g:60:35: Return expression ';'
                    {
                    Return5=(Token)match(input,Return,FOLLOW_Return_in_block168);  
                    stream_Return.add(Return5);

                    pushFollow(FOLLOW_expression_in_block170);
                    expression6=expression();

                    state._fsp--;

                    stream_expression.add(expression6.getTree());
                    char_literal7=(Token)match(input,SColon,FOLLOW_SColon_in_block172);  
                    stream_SColon.add(char_literal7);


                    }
                    break;

            }



            // AST REWRITE
            // elements: expression, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 61:6: -> ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
            {
                // src/grammar/TL.g:61:9: ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);

                // src/grammar/TL.g:61:17: ^( STATEMENTS ( statement )* )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_2);

                // src/grammar/TL.g:61:30: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_2, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/grammar/TL.g:61:42: ^( RETURN ( expression )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN, "RETURN"), root_2);

                // src/grammar/TL.g:61:51: ( expression )?
                if ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_2, stream_expression.nextTree());

                }
                stream_expression.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // src/grammar/TL.g:64:1: statement : ( assignment ';' -> assignment | functionCall ';' -> functionCall | ifStatement | forStatement | whileStatement );
    public final TLParser.statement_return statement() throws RecognitionException {
        TLParser.statement_return retval = new TLParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal11=null;
        TLParser.assignment_return assignment8 = null;

        TLParser.functionCall_return functionCall10 = null;

        TLParser.ifStatement_return ifStatement12 = null;

        TLParser.forStatement_return forStatement13 = null;

        TLParser.whileStatement_return whileStatement14 = null;


        Object char_literal9_tree=null;
        Object char_literal11_tree=null;
        RewriteRuleTokenStream stream_SColon=new RewriteRuleTokenStream(adaptor,"token SColon");
        RewriteRuleSubtreeStream stream_functionCall=new RewriteRuleSubtreeStream(adaptor,"rule functionCall");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        try {
            // src/grammar/TL.g:65:3: ( assignment ';' -> assignment | functionCall ';' -> functionCall | ifStatement | forStatement | whileStatement )
            int alt3=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==OParen) ) {
                    alt3=2;
                }
                else if ( (LA3_1==OBracket||LA3_1==Assign) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case Println:
            case Print:
            case Assert:
            case Size:
            case MoveForward:
            case MoveBackward:
            case TurnLeft:
            case TurnRight:
            case Shoot:
                {
                alt3=2;
                }
                break;
            case If:
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
                    // src/grammar/TL.g:65:6: assignment ';'
                    {
                    pushFollow(FOLLOW_assignment_in_statement214);
                    assignment8=assignment();

                    state._fsp--;

                    stream_assignment.add(assignment8.getTree());
                    char_literal9=(Token)match(input,SColon,FOLLOW_SColon_in_statement216);  
                    stream_SColon.add(char_literal9);



                    // AST REWRITE
                    // elements: assignment
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 65:23: -> assignment
                    {
                        adaptor.addChild(root_0, stream_assignment.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/grammar/TL.g:66:6: functionCall ';'
                    {
                    pushFollow(FOLLOW_functionCall_in_statement229);
                    functionCall10=functionCall();

                    state._fsp--;

                    stream_functionCall.add(functionCall10.getTree());
                    char_literal11=(Token)match(input,SColon,FOLLOW_SColon_in_statement231);  
                    stream_SColon.add(char_literal11);



                    // AST REWRITE
                    // elements: functionCall
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 66:23: -> functionCall
                    {
                        adaptor.addChild(root_0, stream_functionCall.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/grammar/TL.g:67:6: ifStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statement242);
                    ifStatement12=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement12.getTree());

                    }
                    break;
                case 4 :
                    // src/grammar/TL.g:68:6: forStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_statement249);
                    forStatement13=forStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, forStatement13.getTree());

                    }
                    break;
                case 5 :
                    // src/grammar/TL.g:69:6: whileStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_statement256);
                    whileStatement14=whileStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, whileStatement14.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // src/grammar/TL.g:72:1: assignment : Identifier ( indexes )? '=' expression -> ^( ASSIGNMENT Identifier ( indexes )? expression ) ;
    public final TLParser.assignment_return assignment() throws RecognitionException {
        TLParser.assignment_return retval = new TLParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier15=null;
        Token char_literal17=null;
        TLParser.indexes_return indexes16 = null;

        TLParser.expression_return expression18 = null;


        Object Identifier15_tree=null;
        Object char_literal17_tree=null;
        RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");
        try {
            // src/grammar/TL.g:73:3: ( Identifier ( indexes )? '=' expression -> ^( ASSIGNMENT Identifier ( indexes )? expression ) )
            // src/grammar/TL.g:73:6: Identifier ( indexes )? '=' expression
            {
            Identifier15=(Token)match(input,Identifier,FOLLOW_Identifier_in_assignment270);  
            stream_Identifier.add(Identifier15);

            // src/grammar/TL.g:73:17: ( indexes )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==OBracket) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/grammar/TL.g:73:17: indexes
                    {
                    pushFollow(FOLLOW_indexes_in_assignment272);
                    indexes16=indexes();

                    state._fsp--;

                    stream_indexes.add(indexes16.getTree());

                    }
                    break;

            }

            char_literal17=(Token)match(input,Assign,FOLLOW_Assign_in_assignment275);  
            stream_Assign.add(char_literal17);

            pushFollow(FOLLOW_expression_in_assignment277);
            expression18=expression();

            state._fsp--;

            stream_expression.add(expression18.getTree());


            // AST REWRITE
            // elements: expression, Identifier, indexes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 74:6: -> ^( ASSIGNMENT Identifier ( indexes )? expression )
            {
                // src/grammar/TL.g:74:9: ^( ASSIGNMENT Identifier ( indexes )? expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);

                adaptor.addChild(root_1, stream_Identifier.nextNode());
                // src/grammar/TL.g:74:33: ( indexes )?
                if ( stream_indexes.hasNext() ) {
                    adaptor.addChild(root_1, stream_indexes.nextTree());

                }
                stream_indexes.reset();
                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class functionCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // src/grammar/TL.g:77:1: functionCall : ( Identifier '(' ( exprList )? ')' -> ^( FUNC_CALL Identifier ( exprList )? ) | Println '(' ( expression )? ')' -> ^( FUNC_CALL Println ( expression )? ) | Print '(' expression ')' -> ^( FUNC_CALL Print expression ) | Assert '(' expression ')' -> ^( FUNC_CALL Assert expression ) | Size '(' expression ')' -> ^( FUNC_CALL Size expression ) | MoveForward '(' ( expression )? ')' -> ^( FUNC_CALL MoveForward ( expression )? ) | MoveBackward '(' ( expression )? ')' -> ^( FUNC_CALL MoveBackward ( expression )? ) | TurnLeft '(' ( expression )? ')' -> ^( FUNC_CALL TurnLeft ( expression )? ) | TurnRight '(' ( expression )? ')' -> ^( FUNC_CALL TurnRight ( expression )? ) | Shoot '(' ( expression )? ')' -> ^( FUNC_CALL Shoot ( expression )? ) );
    public final TLParser.functionCall_return functionCall() throws RecognitionException {
        TLParser.functionCall_return retval = new TLParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier19=null;
        Token char_literal20=null;
        Token char_literal22=null;
        Token Println23=null;
        Token char_literal24=null;
        Token char_literal26=null;
        Token Print27=null;
        Token char_literal28=null;
        Token char_literal30=null;
        Token Assert31=null;
        Token char_literal32=null;
        Token char_literal34=null;
        Token Size35=null;
        Token char_literal36=null;
        Token char_literal38=null;
        Token MoveForward39=null;
        Token char_literal40=null;
        Token char_literal42=null;
        Token MoveBackward43=null;
        Token char_literal44=null;
        Token char_literal46=null;
        Token TurnLeft47=null;
        Token char_literal48=null;
        Token char_literal50=null;
        Token TurnRight51=null;
        Token char_literal52=null;
        Token char_literal54=null;
        Token Shoot55=null;
        Token char_literal56=null;
        Token char_literal58=null;
        TLParser.exprList_return exprList21 = null;

        TLParser.expression_return expression25 = null;

        TLParser.expression_return expression29 = null;

        TLParser.expression_return expression33 = null;

        TLParser.expression_return expression37 = null;

        TLParser.expression_return expression41 = null;

        TLParser.expression_return expression45 = null;

        TLParser.expression_return expression49 = null;

        TLParser.expression_return expression53 = null;

        TLParser.expression_return expression57 = null;


        Object Identifier19_tree=null;
        Object char_literal20_tree=null;
        Object char_literal22_tree=null;
        Object Println23_tree=null;
        Object char_literal24_tree=null;
        Object char_literal26_tree=null;
        Object Print27_tree=null;
        Object char_literal28_tree=null;
        Object char_literal30_tree=null;
        Object Assert31_tree=null;
        Object char_literal32_tree=null;
        Object char_literal34_tree=null;
        Object Size35_tree=null;
        Object char_literal36_tree=null;
        Object char_literal38_tree=null;
        Object MoveForward39_tree=null;
        Object char_literal40_tree=null;
        Object char_literal42_tree=null;
        Object MoveBackward43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal46_tree=null;
        Object TurnLeft47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal50_tree=null;
        Object TurnRight51_tree=null;
        Object char_literal52_tree=null;
        Object char_literal54_tree=null;
        Object Shoot55_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;
        RewriteRuleTokenStream stream_MoveForward=new RewriteRuleTokenStream(adaptor,"token MoveForward");
        RewriteRuleTokenStream stream_Println=new RewriteRuleTokenStream(adaptor,"token Println");
        RewriteRuleTokenStream stream_OParen=new RewriteRuleTokenStream(adaptor,"token OParen");
        RewriteRuleTokenStream stream_TurnRight=new RewriteRuleTokenStream(adaptor,"token TurnRight");
        RewriteRuleTokenStream stream_MoveBackward=new RewriteRuleTokenStream(adaptor,"token MoveBackward");
        RewriteRuleTokenStream stream_CParen=new RewriteRuleTokenStream(adaptor,"token CParen");
        RewriteRuleTokenStream stream_TurnLeft=new RewriteRuleTokenStream(adaptor,"token TurnLeft");
        RewriteRuleTokenStream stream_Shoot=new RewriteRuleTokenStream(adaptor,"token Shoot");
        RewriteRuleTokenStream stream_Assert=new RewriteRuleTokenStream(adaptor,"token Assert");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_Print=new RewriteRuleTokenStream(adaptor,"token Print");
        RewriteRuleTokenStream stream_Size=new RewriteRuleTokenStream(adaptor,"token Size");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_exprList=new RewriteRuleSubtreeStream(adaptor,"rule exprList");
        try {
            // src/grammar/TL.g:78:3: ( Identifier '(' ( exprList )? ')' -> ^( FUNC_CALL Identifier ( exprList )? ) | Println '(' ( expression )? ')' -> ^( FUNC_CALL Println ( expression )? ) | Print '(' expression ')' -> ^( FUNC_CALL Print expression ) | Assert '(' expression ')' -> ^( FUNC_CALL Assert expression ) | Size '(' expression ')' -> ^( FUNC_CALL Size expression ) | MoveForward '(' ( expression )? ')' -> ^( FUNC_CALL MoveForward ( expression )? ) | MoveBackward '(' ( expression )? ')' -> ^( FUNC_CALL MoveBackward ( expression )? ) | TurnLeft '(' ( expression )? ')' -> ^( FUNC_CALL TurnLeft ( expression )? ) | TurnRight '(' ( expression )? ')' -> ^( FUNC_CALL TurnRight ( expression )? ) | Shoot '(' ( expression )? ')' -> ^( FUNC_CALL Shoot ( expression )? ) )
            int alt12=10;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt12=1;
                }
                break;
            case Println:
                {
                alt12=2;
                }
                break;
            case Print:
                {
                alt12=3;
                }
                break;
            case Assert:
                {
                alt12=4;
                }
                break;
            case Size:
                {
                alt12=5;
                }
                break;
            case MoveForward:
                {
                alt12=6;
                }
                break;
            case MoveBackward:
                {
                alt12=7;
                }
                break;
            case TurnLeft:
                {
                alt12=8;
                }
                break;
            case TurnRight:
                {
                alt12=9;
                }
                break;
            case Shoot:
                {
                alt12=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // src/grammar/TL.g:78:6: Identifier '(' ( exprList )? ')'
                    {
                    Identifier19=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionCall310);  
                    stream_Identifier.add(Identifier19);

                    char_literal20=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall312);  
                    stream_OParen.add(char_literal20);

                    // src/grammar/TL.g:78:21: ( exprList )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Identifier && LA5_0<=Shoot)||(LA5_0>=Number && LA5_0<=String)||LA5_0==Excl||LA5_0==Subtract||LA5_0==OBracket||LA5_0==OParen) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/grammar/TL.g:78:21: exprList
                            {
                            pushFollow(FOLLOW_exprList_in_functionCall314);
                            exprList21=exprList();

                            state._fsp--;

                            stream_exprList.add(exprList21.getTree());

                            }
                            break;

                    }

                    char_literal22=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall317);  
                    stream_CParen.add(char_literal22);



                    // AST REWRITE
                    // elements: exprList, Identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 78:35: -> ^( FUNC_CALL Identifier ( exprList )? )
                    {
                        // src/grammar/TL.g:78:38: ^( FUNC_CALL Identifier ( exprList )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_Identifier.nextNode());
                        // src/grammar/TL.g:78:61: ( exprList )?
                        if ( stream_exprList.hasNext() ) {
                            adaptor.addChild(root_1, stream_exprList.nextTree());

                        }
                        stream_exprList.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/grammar/TL.g:79:6: Println '(' ( expression )? ')'
                    {
                    Println23=(Token)match(input,Println,FOLLOW_Println_in_functionCall335);  
                    stream_Println.add(Println23);

                    char_literal24=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall337);  
                    stream_OParen.add(char_literal24);

                    // src/grammar/TL.g:79:18: ( expression )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=Identifier && LA6_0<=Shoot)||(LA6_0>=Number && LA6_0<=String)||LA6_0==Excl||LA6_0==Subtract||LA6_0==OBracket||LA6_0==OParen) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // src/grammar/TL.g:79:18: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall339);
                            expression25=expression();

                            state._fsp--;

                            stream_expression.add(expression25.getTree());

                            }
                            break;

                    }

                    char_literal26=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall342);  
                    stream_CParen.add(char_literal26);



                    // AST REWRITE
                    // elements: expression, Println
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 79:35: -> ^( FUNC_CALL Println ( expression )? )
                    {
                        // src/grammar/TL.g:79:38: ^( FUNC_CALL Println ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_Println.nextNode());
                        // src/grammar/TL.g:79:58: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/grammar/TL.g:80:6: Print '(' expression ')'
                    {
                    Print27=(Token)match(input,Print,FOLLOW_Print_in_functionCall361);  
                    stream_Print.add(Print27);

                    char_literal28=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall363);  
                    stream_OParen.add(char_literal28);

                    pushFollow(FOLLOW_expression_in_functionCall365);
                    expression29=expression();

                    state._fsp--;

                    stream_expression.add(expression29.getTree());
                    char_literal30=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall367);  
                    stream_CParen.add(char_literal30);



                    // AST REWRITE
                    // elements: expression, Print
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:35: -> ^( FUNC_CALL Print expression )
                    {
                        // src/grammar/TL.g:80:38: ^( FUNC_CALL Print expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_Print.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // src/grammar/TL.g:81:6: Assert '(' expression ')'
                    {
                    Assert31=(Token)match(input,Assert,FOLLOW_Assert_in_functionCall388);  
                    stream_Assert.add(Assert31);

                    char_literal32=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall390);  
                    stream_OParen.add(char_literal32);

                    pushFollow(FOLLOW_expression_in_functionCall392);
                    expression33=expression();

                    state._fsp--;

                    stream_expression.add(expression33.getTree());
                    char_literal34=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall394);  
                    stream_CParen.add(char_literal34);



                    // AST REWRITE
                    // elements: Assert, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 81:35: -> ^( FUNC_CALL Assert expression )
                    {
                        // src/grammar/TL.g:81:38: ^( FUNC_CALL Assert expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_Assert.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // src/grammar/TL.g:82:6: Size '(' expression ')'
                    {
                    Size35=(Token)match(input,Size,FOLLOW_Size_in_functionCall414);  
                    stream_Size.add(Size35);

                    char_literal36=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall416);  
                    stream_OParen.add(char_literal36);

                    pushFollow(FOLLOW_expression_in_functionCall418);
                    expression37=expression();

                    state._fsp--;

                    stream_expression.add(expression37.getTree());
                    char_literal38=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall420);  
                    stream_CParen.add(char_literal38);



                    // AST REWRITE
                    // elements: expression, Size
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 82:35: -> ^( FUNC_CALL Size expression )
                    {
                        // src/grammar/TL.g:82:38: ^( FUNC_CALL Size expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_Size.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // src/grammar/TL.g:83:6: MoveForward '(' ( expression )? ')'
                    {
                    MoveForward39=(Token)match(input,MoveForward,FOLLOW_MoveForward_in_functionCall442);  
                    stream_MoveForward.add(MoveForward39);

                    char_literal40=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall444);  
                    stream_OParen.add(char_literal40);

                    // src/grammar/TL.g:83:22: ( expression )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=Identifier && LA7_0<=Shoot)||(LA7_0>=Number && LA7_0<=String)||LA7_0==Excl||LA7_0==Subtract||LA7_0==OBracket||LA7_0==OParen) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // src/grammar/TL.g:83:22: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall446);
                            expression41=expression();

                            state._fsp--;

                            stream_expression.add(expression41.getTree());

                            }
                            break;

                    }

                    char_literal42=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall449);  
                    stream_CParen.add(char_literal42);



                    // AST REWRITE
                    // elements: MoveForward, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:42: -> ^( FUNC_CALL MoveForward ( expression )? )
                    {
                        // src/grammar/TL.g:83:45: ^( FUNC_CALL MoveForward ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_MoveForward.nextNode());
                        // src/grammar/TL.g:83:69: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // src/grammar/TL.g:84:6: MoveBackward '(' ( expression )? ')'
                    {
                    MoveBackward43=(Token)match(input,MoveBackward,FOLLOW_MoveBackward_in_functionCall472);  
                    stream_MoveBackward.add(MoveBackward43);

                    char_literal44=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall474);  
                    stream_OParen.add(char_literal44);

                    // src/grammar/TL.g:84:23: ( expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=Identifier && LA8_0<=Shoot)||(LA8_0>=Number && LA8_0<=String)||LA8_0==Excl||LA8_0==Subtract||LA8_0==OBracket||LA8_0==OParen) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // src/grammar/TL.g:84:23: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall476);
                            expression45=expression();

                            state._fsp--;

                            stream_expression.add(expression45.getTree());

                            }
                            break;

                    }

                    char_literal46=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall479);  
                    stream_CParen.add(char_literal46);



                    // AST REWRITE
                    // elements: expression, MoveBackward
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:43: -> ^( FUNC_CALL MoveBackward ( expression )? )
                    {
                        // src/grammar/TL.g:84:46: ^( FUNC_CALL MoveBackward ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_MoveBackward.nextNode());
                        // src/grammar/TL.g:84:71: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 8 :
                    // src/grammar/TL.g:85:6: TurnLeft '(' ( expression )? ')'
                    {
                    TurnLeft47=(Token)match(input,TurnLeft,FOLLOW_TurnLeft_in_functionCall502);  
                    stream_TurnLeft.add(TurnLeft47);

                    char_literal48=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall504);  
                    stream_OParen.add(char_literal48);

                    // src/grammar/TL.g:85:19: ( expression )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=Identifier && LA9_0<=Shoot)||(LA9_0>=Number && LA9_0<=String)||LA9_0==Excl||LA9_0==Subtract||LA9_0==OBracket||LA9_0==OParen) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/grammar/TL.g:85:19: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall506);
                            expression49=expression();

                            state._fsp--;

                            stream_expression.add(expression49.getTree());

                            }
                            break;

                    }

                    char_literal50=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall509);  
                    stream_CParen.add(char_literal50);



                    // AST REWRITE
                    // elements: expression, TurnLeft
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:39: -> ^( FUNC_CALL TurnLeft ( expression )? )
                    {
                        // src/grammar/TL.g:85:42: ^( FUNC_CALL TurnLeft ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_TurnLeft.nextNode());
                        // src/grammar/TL.g:85:63: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 9 :
                    // src/grammar/TL.g:86:6: TurnRight '(' ( expression )? ')'
                    {
                    TurnRight51=(Token)match(input,TurnRight,FOLLOW_TurnRight_in_functionCall532);  
                    stream_TurnRight.add(TurnRight51);

                    char_literal52=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall534);  
                    stream_OParen.add(char_literal52);

                    // src/grammar/TL.g:86:20: ( expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=Identifier && LA10_0<=Shoot)||(LA10_0>=Number && LA10_0<=String)||LA10_0==Excl||LA10_0==Subtract||LA10_0==OBracket||LA10_0==OParen) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // src/grammar/TL.g:86:20: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall536);
                            expression53=expression();

                            state._fsp--;

                            stream_expression.add(expression53.getTree());

                            }
                            break;

                    }

                    char_literal54=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall539);  
                    stream_CParen.add(char_literal54);



                    // AST REWRITE
                    // elements: TurnRight, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 86:40: -> ^( FUNC_CALL TurnRight ( expression )? )
                    {
                        // src/grammar/TL.g:86:43: ^( FUNC_CALL TurnRight ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_TurnRight.nextNode());
                        // src/grammar/TL.g:86:65: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 10 :
                    // src/grammar/TL.g:87:6: Shoot '(' ( expression )? ')'
                    {
                    Shoot55=(Token)match(input,Shoot,FOLLOW_Shoot_in_functionCall562);  
                    stream_Shoot.add(Shoot55);

                    char_literal56=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall564);  
                    stream_OParen.add(char_literal56);

                    // src/grammar/TL.g:87:16: ( expression )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=Identifier && LA11_0<=Shoot)||(LA11_0>=Number && LA11_0<=String)||LA11_0==Excl||LA11_0==Subtract||LA11_0==OBracket||LA11_0==OParen) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/grammar/TL.g:87:16: expression
                            {
                            pushFollow(FOLLOW_expression_in_functionCall566);
                            expression57=expression();

                            state._fsp--;

                            stream_expression.add(expression57.getTree());

                            }
                            break;

                    }

                    char_literal58=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall569);  
                    stream_CParen.add(char_literal58);



                    // AST REWRITE
                    // elements: expression, Shoot
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 87:36: -> ^( FUNC_CALL Shoot ( expression )? )
                    {
                        // src/grammar/TL.g:87:39: ^( FUNC_CALL Shoot ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_Shoot.nextNode());
                        // src/grammar/TL.g:87:57: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // src/grammar/TL.g:93:1: ifStatement : ifStat ( elseIfStat )* ( elseStat )? End -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) ;
    public final TLParser.ifStatement_return ifStatement() throws RecognitionException {
        TLParser.ifStatement_return retval = new TLParser.ifStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token End62=null;
        TLParser.ifStat_return ifStat59 = null;

        TLParser.elseIfStat_return elseIfStat60 = null;

        TLParser.elseStat_return elseStat61 = null;


        Object End62_tree=null;
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleSubtreeStream stream_elseIfStat=new RewriteRuleSubtreeStream(adaptor,"rule elseIfStat");
        RewriteRuleSubtreeStream stream_ifStat=new RewriteRuleSubtreeStream(adaptor,"rule ifStat");
        RewriteRuleSubtreeStream stream_elseStat=new RewriteRuleSubtreeStream(adaptor,"rule elseStat");
        try {
            // src/grammar/TL.g:94:3: ( ifStat ( elseIfStat )* ( elseStat )? End -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) )
            // src/grammar/TL.g:94:6: ifStat ( elseIfStat )* ( elseStat )? End
            {
            pushFollow(FOLLOW_ifStat_in_ifStatement602);
            ifStat59=ifStat();

            state._fsp--;

            stream_ifStat.add(ifStat59.getTree());
            // src/grammar/TL.g:94:13: ( elseIfStat )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Else) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==If) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // src/grammar/TL.g:94:13: elseIfStat
            	    {
            	    pushFollow(FOLLOW_elseIfStat_in_ifStatement604);
            	    elseIfStat60=elseIfStat();

            	    state._fsp--;

            	    stream_elseIfStat.add(elseIfStat60.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // src/grammar/TL.g:94:25: ( elseStat )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Else) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/grammar/TL.g:94:25: elseStat
                    {
                    pushFollow(FOLLOW_elseStat_in_ifStatement607);
                    elseStat61=elseStat();

                    state._fsp--;

                    stream_elseStat.add(elseStat61.getTree());

                    }
                    break;

            }

            End62=(Token)match(input,End,FOLLOW_End_in_ifStatement610);  
            stream_End.add(End62);



            // AST REWRITE
            // elements: elseIfStat, elseStat, ifStat
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 94:39: -> ^( IF ifStat ( elseIfStat )* ( elseStat )? )
            {
                // src/grammar/TL.g:94:42: ^( IF ifStat ( elseIfStat )* ( elseStat )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_ifStat.nextTree());
                // src/grammar/TL.g:94:54: ( elseIfStat )*
                while ( stream_elseIfStat.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfStat.nextTree());

                }
                stream_elseIfStat.reset();
                // src/grammar/TL.g:94:66: ( elseStat )?
                if ( stream_elseStat.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseStat.nextTree());

                }
                stream_elseStat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStatement"

    public static class ifStat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStat"
    // src/grammar/TL.g:97:1: ifStat : If expression Do block -> ^( EXP expression block ) ;
    public final TLParser.ifStat_return ifStat() throws RecognitionException {
        TLParser.ifStat_return retval = new TLParser.ifStat_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token If63=null;
        Token Do65=null;
        TLParser.expression_return expression64 = null;

        TLParser.block_return block66 = null;


        Object If63_tree=null;
        Object Do65_tree=null;
        RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
        RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/grammar/TL.g:98:3: ( If expression Do block -> ^( EXP expression block ) )
            // src/grammar/TL.g:98:6: If expression Do block
            {
            If63=(Token)match(input,If,FOLLOW_If_in_ifStat638);  
            stream_If.add(If63);

            pushFollow(FOLLOW_expression_in_ifStat640);
            expression64=expression();

            state._fsp--;

            stream_expression.add(expression64.getTree());
            Do65=(Token)match(input,Do,FOLLOW_Do_in_ifStat642);  
            stream_Do.add(Do65);

            pushFollow(FOLLOW_block_in_ifStat644);
            block66=block();

            state._fsp--;

            stream_block.add(block66.getTree());


            // AST REWRITE
            // elements: block, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 98:29: -> ^( EXP expression block )
            {
                // src/grammar/TL.g:98:32: ^( EXP expression block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP, "EXP"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStat"

    public static class elseIfStat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseIfStat"
    // src/grammar/TL.g:101:1: elseIfStat : Else If expression Do block -> ^( EXP expression block ) ;
    public final TLParser.elseIfStat_return elseIfStat() throws RecognitionException {
        TLParser.elseIfStat_return retval = new TLParser.elseIfStat_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Else67=null;
        Token If68=null;
        Token Do70=null;
        TLParser.expression_return expression69 = null;

        TLParser.block_return block71 = null;


        Object Else67_tree=null;
        Object If68_tree=null;
        Object Do70_tree=null;
        RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
        RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
        RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/grammar/TL.g:102:3: ( Else If expression Do block -> ^( EXP expression block ) )
            // src/grammar/TL.g:102:6: Else If expression Do block
            {
            Else67=(Token)match(input,Else,FOLLOW_Else_in_elseIfStat668);  
            stream_Else.add(Else67);

            If68=(Token)match(input,If,FOLLOW_If_in_elseIfStat670);  
            stream_If.add(If68);

            pushFollow(FOLLOW_expression_in_elseIfStat672);
            expression69=expression();

            state._fsp--;

            stream_expression.add(expression69.getTree());
            Do70=(Token)match(input,Do,FOLLOW_Do_in_elseIfStat674);  
            stream_Do.add(Do70);

            pushFollow(FOLLOW_block_in_elseIfStat676);
            block71=block();

            state._fsp--;

            stream_block.add(block71.getTree());


            // AST REWRITE
            // elements: block, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 102:34: -> ^( EXP expression block )
            {
                // src/grammar/TL.g:102:37: ^( EXP expression block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP, "EXP"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elseIfStat"

    public static class elseStat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseStat"
    // src/grammar/TL.g:105:1: elseStat : Else Do block -> ^( EXP block ) ;
    public final TLParser.elseStat_return elseStat() throws RecognitionException {
        TLParser.elseStat_return retval = new TLParser.elseStat_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Else72=null;
        Token Do73=null;
        TLParser.block_return block74 = null;


        Object Else72_tree=null;
        Object Do73_tree=null;
        RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
        RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/grammar/TL.g:106:3: ( Else Do block -> ^( EXP block ) )
            // src/grammar/TL.g:106:6: Else Do block
            {
            Else72=(Token)match(input,Else,FOLLOW_Else_in_elseStat700);  
            stream_Else.add(Else72);

            Do73=(Token)match(input,Do,FOLLOW_Do_in_elseStat702);  
            stream_Do.add(Do73);

            pushFollow(FOLLOW_block_in_elseStat704);
            block74=block();

            state._fsp--;

            stream_block.add(block74.getTree());


            // AST REWRITE
            // elements: block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 106:20: -> ^( EXP block )
            {
                // src/grammar/TL.g:106:23: ^( EXP block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP, "EXP"), root_1);

                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elseStat"

    public static class functionDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionDecl"
    // src/grammar/TL.g:109:1: functionDecl : Def Identifier '(' ( idList )? ')' block End ;
    public final TLParser.functionDecl_return functionDecl() throws RecognitionException {
        TLParser.functionDecl_return retval = new TLParser.functionDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Def75=null;
        Token Identifier76=null;
        Token char_literal77=null;
        Token char_literal79=null;
        Token End81=null;
        TLParser.idList_return idList78 = null;

        TLParser.block_return block80 = null;


        Object Def75_tree=null;
        Object Identifier76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal79_tree=null;
        Object End81_tree=null;

        try {
            // src/grammar/TL.g:110:3: ( Def Identifier '(' ( idList )? ')' block End )
            // src/grammar/TL.g:110:6: Def Identifier '(' ( idList )? ')' block End
            {
            root_0 = (Object)adaptor.nil();

            Def75=(Token)match(input,Def,FOLLOW_Def_in_functionDecl726); 
            Def75_tree = (Object)adaptor.create(Def75);
            adaptor.addChild(root_0, Def75_tree);

            Identifier76=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionDecl728); 
            Identifier76_tree = (Object)adaptor.create(Identifier76);
            adaptor.addChild(root_0, Identifier76_tree);

            char_literal77=(Token)match(input,OParen,FOLLOW_OParen_in_functionDecl730); 
            char_literal77_tree = (Object)adaptor.create(char_literal77);
            adaptor.addChild(root_0, char_literal77_tree);

            // src/grammar/TL.g:110:25: ( idList )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Identifier) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/grammar/TL.g:110:25: idList
                    {
                    pushFollow(FOLLOW_idList_in_functionDecl732);
                    idList78=idList();

                    state._fsp--;

                    adaptor.addChild(root_0, idList78.getTree());

                    }
                    break;

            }

            char_literal79=(Token)match(input,CParen,FOLLOW_CParen_in_functionDecl735); 
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);

            pushFollow(FOLLOW_block_in_functionDecl737);
            block80=block();

            state._fsp--;

            adaptor.addChild(root_0, block80.getTree());
            End81=(Token)match(input,End,FOLLOW_End_in_functionDecl739); 
            End81_tree = (Object)adaptor.create(End81);
            adaptor.addChild(root_0, End81_tree);

            defineFunction((Identifier76!=null?Identifier76.getText():null), (idList78!=null?((Object)idList78.tree):null), (block80!=null?((Object)block80.tree):null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionDecl"

    public static class forStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStatement"
    // src/grammar/TL.g:114:1: forStatement : For Identifier '=' expression To expression Do block End -> ^( For Identifier expression expression block ) ;
    public final TLParser.forStatement_return forStatement() throws RecognitionException {
        TLParser.forStatement_return retval = new TLParser.forStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token For82=null;
        Token Identifier83=null;
        Token char_literal84=null;
        Token To86=null;
        Token Do88=null;
        Token End90=null;
        TLParser.expression_return expression85 = null;

        TLParser.expression_return expression87 = null;

        TLParser.block_return block89 = null;


        Object For82_tree=null;
        Object Identifier83_tree=null;
        Object char_literal84_tree=null;
        Object To86_tree=null;
        Object Do88_tree=null;
        Object End90_tree=null;
        RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
        RewriteRuleTokenStream stream_To=new RewriteRuleTokenStream(adaptor,"token To");
        RewriteRuleTokenStream stream_For=new RewriteRuleTokenStream(adaptor,"token For");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/grammar/TL.g:115:3: ( For Identifier '=' expression To expression Do block End -> ^( For Identifier expression expression block ) )
            // src/grammar/TL.g:115:6: For Identifier '=' expression To expression Do block End
            {
            For82=(Token)match(input,For,FOLLOW_For_in_forStatement761);  
            stream_For.add(For82);

            Identifier83=(Token)match(input,Identifier,FOLLOW_Identifier_in_forStatement763);  
            stream_Identifier.add(Identifier83);

            char_literal84=(Token)match(input,Assign,FOLLOW_Assign_in_forStatement765);  
            stream_Assign.add(char_literal84);

            pushFollow(FOLLOW_expression_in_forStatement767);
            expression85=expression();

            state._fsp--;

            stream_expression.add(expression85.getTree());
            To86=(Token)match(input,To,FOLLOW_To_in_forStatement769);  
            stream_To.add(To86);

            pushFollow(FOLLOW_expression_in_forStatement771);
            expression87=expression();

            state._fsp--;

            stream_expression.add(expression87.getTree());
            Do88=(Token)match(input,Do,FOLLOW_Do_in_forStatement773);  
            stream_Do.add(Do88);

            pushFollow(FOLLOW_block_in_forStatement775);
            block89=block();

            state._fsp--;

            stream_block.add(block89.getTree());
            End90=(Token)match(input,End,FOLLOW_End_in_forStatement777);  
            stream_End.add(End90);



            // AST REWRITE
            // elements: expression, expression, Identifier, block, For
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 116:6: -> ^( For Identifier expression expression block )
            {
                // src/grammar/TL.g:116:9: ^( For Identifier expression expression block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_For.nextNode(), root_1);

                adaptor.addChild(root_1, stream_Identifier.nextNode());
                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forStatement"

    public static class whileStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStatement"
    // src/grammar/TL.g:119:1: whileStatement : While expression Do block End -> ^( While expression block ) ;
    public final TLParser.whileStatement_return whileStatement() throws RecognitionException {
        TLParser.whileStatement_return retval = new TLParser.whileStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token While91=null;
        Token Do93=null;
        Token End95=null;
        TLParser.expression_return expression92 = null;

        TLParser.block_return block94 = null;


        Object While91_tree=null;
        Object Do93_tree=null;
        Object End95_tree=null;
        RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
        RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
        RewriteRuleTokenStream stream_While=new RewriteRuleTokenStream(adaptor,"token While");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // src/grammar/TL.g:120:3: ( While expression Do block End -> ^( While expression block ) )
            // src/grammar/TL.g:120:6: While expression Do block End
            {
            While91=(Token)match(input,While,FOLLOW_While_in_whileStatement811);  
            stream_While.add(While91);

            pushFollow(FOLLOW_expression_in_whileStatement813);
            expression92=expression();

            state._fsp--;

            stream_expression.add(expression92.getTree());
            Do93=(Token)match(input,Do,FOLLOW_Do_in_whileStatement815);  
            stream_Do.add(Do93);

            pushFollow(FOLLOW_block_in_whileStatement817);
            block94=block();

            state._fsp--;

            stream_block.add(block94.getTree());
            End95=(Token)match(input,End,FOLLOW_End_in_whileStatement819);  
            stream_End.add(End95);



            // AST REWRITE
            // elements: While, expression, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 120:36: -> ^( While expression block )
            {
                // src/grammar/TL.g:120:39: ^( While expression block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_While.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whileStatement"

    public static class idList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idList"
    // src/grammar/TL.g:123:1: idList : Identifier ( ',' Identifier )* -> ^( ID_LIST ( Identifier )+ ) ;
    public final TLParser.idList_return idList() throws RecognitionException {
        TLParser.idList_return retval = new TLParser.idList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier96=null;
        Token char_literal97=null;
        Token Identifier98=null;

        Object Identifier96_tree=null;
        Object char_literal97_tree=null;
        Object Identifier98_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // src/grammar/TL.g:124:3: ( Identifier ( ',' Identifier )* -> ^( ID_LIST ( Identifier )+ ) )
            // src/grammar/TL.g:124:6: Identifier ( ',' Identifier )*
            {
            Identifier96=(Token)match(input,Identifier,FOLLOW_Identifier_in_idList843);  
            stream_Identifier.add(Identifier96);

            // src/grammar/TL.g:124:17: ( ',' Identifier )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Comma) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/grammar/TL.g:124:18: ',' Identifier
            	    {
            	    char_literal97=(Token)match(input,Comma,FOLLOW_Comma_in_idList846);  
            	    stream_Comma.add(char_literal97);

            	    Identifier98=(Token)match(input,Identifier,FOLLOW_Identifier_in_idList848);  
            	    stream_Identifier.add(Identifier98);


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);



            // AST REWRITE
            // elements: Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 124:35: -> ^( ID_LIST ( Identifier )+ )
            {
                // src/grammar/TL.g:124:38: ^( ID_LIST ( Identifier )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ID_LIST, "ID_LIST"), root_1);

                if ( !(stream_Identifier.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_Identifier.nextNode());

                }
                stream_Identifier.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "idList"

    public static class exprList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprList"
    // src/grammar/TL.g:127:1: exprList : expression ( ',' expression )* -> ^( EXP_LIST ( expression )+ ) ;
    public final TLParser.exprList_return exprList() throws RecognitionException {
        TLParser.exprList_return retval = new TLParser.exprList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal100=null;
        TLParser.expression_return expression99 = null;

        TLParser.expression_return expression101 = null;


        Object char_literal100_tree=null;
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // src/grammar/TL.g:128:3: ( expression ( ',' expression )* -> ^( EXP_LIST ( expression )+ ) )
            // src/grammar/TL.g:128:6: expression ( ',' expression )*
            {
            pushFollow(FOLLOW_expression_in_exprList873);
            expression99=expression();

            state._fsp--;

            stream_expression.add(expression99.getTree());
            // src/grammar/TL.g:128:17: ( ',' expression )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Comma) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/grammar/TL.g:128:18: ',' expression
            	    {
            	    char_literal100=(Token)match(input,Comma,FOLLOW_Comma_in_exprList876);  
            	    stream_Comma.add(char_literal100);

            	    pushFollow(FOLLOW_expression_in_exprList878);
            	    expression101=expression();

            	    state._fsp--;

            	    stream_expression.add(expression101.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 128:35: -> ^( EXP_LIST ( expression )+ )
            {
                // src/grammar/TL.g:128:38: ^( EXP_LIST ( expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP_LIST, "EXP_LIST"), root_1);

                if ( !(stream_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exprList"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/grammar/TL.g:131:1: expression : condExpr ;
    public final TLParser.expression_return expression() throws RecognitionException {
        TLParser.expression_return retval = new TLParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TLParser.condExpr_return condExpr102 = null;



        try {
            // src/grammar/TL.g:132:3: ( condExpr )
            // src/grammar/TL.g:132:6: condExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_condExpr_in_expression903);
            condExpr102=condExpr();

            state._fsp--;

            adaptor.addChild(root_0, condExpr102.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class condExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condExpr"
    // src/grammar/TL.g:135:1: condExpr : ( orExpr -> orExpr ) ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )? ;
    public final TLParser.condExpr_return condExpr() throws RecognitionException {
        TLParser.condExpr_return retval = new TLParser.condExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal104=null;
        Token char_literal105=null;
        Token In106=null;
        TLParser.expression_return a = null;

        TLParser.expression_return b = null;

        TLParser.orExpr_return orExpr103 = null;

        TLParser.expression_return expression107 = null;


        Object char_literal104_tree=null;
        Object char_literal105_tree=null;
        Object In106_tree=null;
        RewriteRuleTokenStream stream_In=new RewriteRuleTokenStream(adaptor,"token In");
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleTokenStream stream_QMark=new RewriteRuleTokenStream(adaptor,"token QMark");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");
        try {
            // src/grammar/TL.g:136:3: ( ( orExpr -> orExpr ) ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )? )
            // src/grammar/TL.g:136:6: ( orExpr -> orExpr ) ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )?
            {
            // src/grammar/TL.g:136:6: ( orExpr -> orExpr )
            // src/grammar/TL.g:136:7: orExpr
            {
            pushFollow(FOLLOW_orExpr_in_condExpr918);
            orExpr103=orExpr();

            state._fsp--;

            stream_orExpr.add(orExpr103.getTree());


            // AST REWRITE
            // elements: orExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 136:14: -> orExpr
            {
                adaptor.addChild(root_0, stream_orExpr.nextTree());

            }

            retval.tree = root_0;
            }

            // src/grammar/TL.g:137:6: ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==QMark) ) {
                alt18=1;
            }
            else if ( (LA18_0==In) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // src/grammar/TL.g:137:8: '?' a= expression ':' b= expression
                    {
                    char_literal104=(Token)match(input,QMark,FOLLOW_QMark_in_condExpr933);  
                    stream_QMark.add(char_literal104);

                    pushFollow(FOLLOW_expression_in_condExpr937);
                    a=expression();

                    state._fsp--;

                    stream_expression.add(a.getTree());
                    char_literal105=(Token)match(input,Colon,FOLLOW_Colon_in_condExpr939);  
                    stream_Colon.add(char_literal105);

                    pushFollow(FOLLOW_expression_in_condExpr943);
                    b=expression();

                    state._fsp--;

                    stream_expression.add(b.getTree());


                    // AST REWRITE
                    // elements: orExpr, a, b
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 137:42: -> ^( TERNARY orExpr $a $b)
                    {
                        // src/grammar/TL.g:137:45: ^( TERNARY orExpr $a $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TERNARY, "TERNARY"), root_1);

                        adaptor.addChild(root_1, stream_orExpr.nextTree());
                        adaptor.addChild(root_1, stream_a.nextTree());
                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/grammar/TL.g:138:8: In expression
                    {
                    In106=(Token)match(input,In,FOLLOW_In_in_condExpr966);  
                    stream_In.add(In106);

                    pushFollow(FOLLOW_expression_in_condExpr968);
                    expression107=expression();

                    state._fsp--;

                    stream_expression.add(expression107.getTree());


                    // AST REWRITE
                    // elements: In, orExpr, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 138:42: -> ^( In orExpr expression )
                    {
                        // src/grammar/TL.g:138:45: ^( In orExpr expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_In.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_orExpr.nextTree());
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "condExpr"

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orExpr"
    // src/grammar/TL.g:142:1: orExpr : andExpr ( '||' andExpr )* ;
    public final TLParser.orExpr_return orExpr() throws RecognitionException {
        TLParser.orExpr_return retval = new TLParser.orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal109=null;
        TLParser.andExpr_return andExpr108 = null;

        TLParser.andExpr_return andExpr110 = null;


        Object string_literal109_tree=null;

        try {
            // src/grammar/TL.g:143:3: ( andExpr ( '||' andExpr )* )
            // src/grammar/TL.g:143:6: andExpr ( '||' andExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr1020);
            andExpr108=andExpr();

            state._fsp--;

            adaptor.addChild(root_0, andExpr108.getTree());
            // src/grammar/TL.g:143:14: ( '||' andExpr )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Or) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // src/grammar/TL.g:143:15: '||' andExpr
            	    {
            	    string_literal109=(Token)match(input,Or,FOLLOW_Or_in_orExpr1023); 
            	    string_literal109_tree = (Object)adaptor.create(string_literal109);
            	    root_0 = (Object)adaptor.becomeRoot(string_literal109_tree, root_0);

            	    pushFollow(FOLLOW_andExpr_in_orExpr1026);
            	    andExpr110=andExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, andExpr110.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // src/grammar/TL.g:146:1: andExpr : equExpr ( '&&' equExpr )* ;
    public final TLParser.andExpr_return andExpr() throws RecognitionException {
        TLParser.andExpr_return retval = new TLParser.andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal112=null;
        TLParser.equExpr_return equExpr111 = null;

        TLParser.equExpr_return equExpr113 = null;


        Object string_literal112_tree=null;

        try {
            // src/grammar/TL.g:147:3: ( equExpr ( '&&' equExpr )* )
            // src/grammar/TL.g:147:6: equExpr ( '&&' equExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equExpr_in_andExpr1042);
            equExpr111=equExpr();

            state._fsp--;

            adaptor.addChild(root_0, equExpr111.getTree());
            // src/grammar/TL.g:147:14: ( '&&' equExpr )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==And) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/grammar/TL.g:147:15: '&&' equExpr
            	    {
            	    string_literal112=(Token)match(input,And,FOLLOW_And_in_andExpr1045); 
            	    string_literal112_tree = (Object)adaptor.create(string_literal112);
            	    root_0 = (Object)adaptor.becomeRoot(string_literal112_tree, root_0);

            	    pushFollow(FOLLOW_equExpr_in_andExpr1048);
            	    equExpr113=equExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, equExpr113.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class equExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equExpr"
    // src/grammar/TL.g:150:1: equExpr : relExpr ( ( '==' | '!=' ) relExpr )* ;
    public final TLParser.equExpr_return equExpr() throws RecognitionException {
        TLParser.equExpr_return retval = new TLParser.equExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set115=null;
        TLParser.relExpr_return relExpr114 = null;

        TLParser.relExpr_return relExpr116 = null;


        Object set115_tree=null;

        try {
            // src/grammar/TL.g:151:3: ( relExpr ( ( '==' | '!=' ) relExpr )* )
            // src/grammar/TL.g:151:6: relExpr ( ( '==' | '!=' ) relExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relExpr_in_equExpr1064);
            relExpr114=relExpr();

            state._fsp--;

            adaptor.addChild(root_0, relExpr114.getTree());
            // src/grammar/TL.g:151:14: ( ( '==' | '!=' ) relExpr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=Equals && LA21_0<=NEquals)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/grammar/TL.g:151:15: ( '==' | '!=' ) relExpr
            	    {
            	    set115=(Token)input.LT(1);
            	    set115=(Token)input.LT(1);
            	    if ( (input.LA(1)>=Equals && input.LA(1)<=NEquals) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set115), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relExpr_in_equExpr1076);
            	    relExpr116=relExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, relExpr116.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equExpr"

    public static class relExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relExpr"
    // src/grammar/TL.g:154:1: relExpr : addExpr ( ( '>=' | '<=' | '>' | '<' ) addExpr )* ;
    public final TLParser.relExpr_return relExpr() throws RecognitionException {
        TLParser.relExpr_return retval = new TLParser.relExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set118=null;
        TLParser.addExpr_return addExpr117 = null;

        TLParser.addExpr_return addExpr119 = null;


        Object set118_tree=null;

        try {
            // src/grammar/TL.g:155:3: ( addExpr ( ( '>=' | '<=' | '>' | '<' ) addExpr )* )
            // src/grammar/TL.g:155:6: addExpr ( ( '>=' | '<=' | '>' | '<' ) addExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_relExpr1092);
            addExpr117=addExpr();

            state._fsp--;

            adaptor.addChild(root_0, addExpr117.getTree());
            // src/grammar/TL.g:155:14: ( ( '>=' | '<=' | '>' | '<' ) addExpr )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=GTEquals && LA22_0<=LTEquals)||(LA22_0>=GT && LA22_0<=LT)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/grammar/TL.g:155:15: ( '>=' | '<=' | '>' | '<' ) addExpr
            	    {
            	    set118=(Token)input.LT(1);
            	    set118=(Token)input.LT(1);
            	    if ( (input.LA(1)>=GTEquals && input.LA(1)<=LTEquals)||(input.LA(1)>=GT && input.LA(1)<=LT) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set118), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr1112);
            	    addExpr119=addExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, addExpr119.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relExpr"

    public static class addExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addExpr"
    // src/grammar/TL.g:158:1: addExpr : mulExpr ( ( '+' | '-' ) mulExpr )* ;
    public final TLParser.addExpr_return addExpr() throws RecognitionException {
        TLParser.addExpr_return retval = new TLParser.addExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set121=null;
        TLParser.mulExpr_return mulExpr120 = null;

        TLParser.mulExpr_return mulExpr122 = null;


        Object set121_tree=null;

        try {
            // src/grammar/TL.g:159:3: ( mulExpr ( ( '+' | '-' ) mulExpr )* )
            // src/grammar/TL.g:159:6: mulExpr ( ( '+' | '-' ) mulExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mulExpr_in_addExpr1128);
            mulExpr120=mulExpr();

            state._fsp--;

            adaptor.addChild(root_0, mulExpr120.getTree());
            // src/grammar/TL.g:159:14: ( ( '+' | '-' ) mulExpr )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=Add && LA23_0<=Subtract)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/grammar/TL.g:159:15: ( '+' | '-' ) mulExpr
            	    {
            	    set121=(Token)input.LT(1);
            	    set121=(Token)input.LT(1);
            	    if ( (input.LA(1)>=Add && input.LA(1)<=Subtract) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set121), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr1140);
            	    mulExpr122=mulExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mulExpr122.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addExpr"

    public static class mulExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mulExpr"
    // src/grammar/TL.g:162:1: mulExpr : powExpr ( ( '*' | '/' | '%' ) powExpr )* ;
    public final TLParser.mulExpr_return mulExpr() throws RecognitionException {
        TLParser.mulExpr_return retval = new TLParser.mulExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set124=null;
        TLParser.powExpr_return powExpr123 = null;

        TLParser.powExpr_return powExpr125 = null;


        Object set124_tree=null;

        try {
            // src/grammar/TL.g:163:3: ( powExpr ( ( '*' | '/' | '%' ) powExpr )* )
            // src/grammar/TL.g:163:6: powExpr ( ( '*' | '/' | '%' ) powExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_powExpr_in_mulExpr1156);
            powExpr123=powExpr();

            state._fsp--;

            adaptor.addChild(root_0, powExpr123.getTree());
            // src/grammar/TL.g:163:14: ( ( '*' | '/' | '%' ) powExpr )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=Multiply && LA24_0<=Modulus)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/grammar/TL.g:163:15: ( '*' | '/' | '%' ) powExpr
            	    {
            	    set124=(Token)input.LT(1);
            	    set124=(Token)input.LT(1);
            	    if ( (input.LA(1)>=Multiply && input.LA(1)<=Modulus) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set124), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_powExpr_in_mulExpr1172);
            	    powExpr125=powExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, powExpr125.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mulExpr"

    public static class powExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "powExpr"
    // src/grammar/TL.g:166:1: powExpr : unaryExpr ( '^' unaryExpr )* ;
    public final TLParser.powExpr_return powExpr() throws RecognitionException {
        TLParser.powExpr_return retval = new TLParser.powExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal127=null;
        TLParser.unaryExpr_return unaryExpr126 = null;

        TLParser.unaryExpr_return unaryExpr128 = null;


        Object char_literal127_tree=null;

        try {
            // src/grammar/TL.g:167:3: ( unaryExpr ( '^' unaryExpr )* )
            // src/grammar/TL.g:167:6: unaryExpr ( '^' unaryExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_powExpr1188);
            unaryExpr126=unaryExpr();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpr126.getTree());
            // src/grammar/TL.g:167:16: ( '^' unaryExpr )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==Pow) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/grammar/TL.g:167:17: '^' unaryExpr
            	    {
            	    char_literal127=(Token)match(input,Pow,FOLLOW_Pow_in_powExpr1191); 
            	    char_literal127_tree = (Object)adaptor.create(char_literal127);
            	    root_0 = (Object)adaptor.becomeRoot(char_literal127_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_powExpr1194);
            	    unaryExpr128=unaryExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpr128.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "powExpr"

    public static class unaryExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpr"
    // src/grammar/TL.g:170:1: unaryExpr : ( '-' atom -> ^( UNARY_MIN atom ) | '!' atom -> ^( NEGATE atom ) | atom );
    public final TLParser.unaryExpr_return unaryExpr() throws RecognitionException {
        TLParser.unaryExpr_return retval = new TLParser.unaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal129=null;
        Token char_literal131=null;
        TLParser.atom_return atom130 = null;

        TLParser.atom_return atom132 = null;

        TLParser.atom_return atom133 = null;


        Object char_literal129_tree=null;
        Object char_literal131_tree=null;
        RewriteRuleTokenStream stream_Excl=new RewriteRuleTokenStream(adaptor,"token Excl");
        RewriteRuleTokenStream stream_Subtract=new RewriteRuleTokenStream(adaptor,"token Subtract");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // src/grammar/TL.g:171:3: ( '-' atom -> ^( UNARY_MIN atom ) | '!' atom -> ^( NEGATE atom ) | atom )
            int alt26=3;
            switch ( input.LA(1) ) {
            case Subtract:
                {
                alt26=1;
                }
                break;
            case Excl:
                {
                alt26=2;
                }
                break;
            case Identifier:
            case Println:
            case Print:
            case Assert:
            case Size:
            case MoveForward:
            case MoveBackward:
            case TurnLeft:
            case TurnRight:
            case Shoot:
            case Number:
            case Bool:
            case Null:
            case String:
            case OBracket:
            case OParen:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // src/grammar/TL.g:171:6: '-' atom
                    {
                    char_literal129=(Token)match(input,Subtract,FOLLOW_Subtract_in_unaryExpr1212);  
                    stream_Subtract.add(char_literal129);

                    pushFollow(FOLLOW_atom_in_unaryExpr1214);
                    atom130=atom();

                    state._fsp--;

                    stream_atom.add(atom130.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 171:15: -> ^( UNARY_MIN atom )
                    {
                        // src/grammar/TL.g:171:18: ^( UNARY_MIN atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MIN, "UNARY_MIN"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/grammar/TL.g:172:6: '!' atom
                    {
                    char_literal131=(Token)match(input,Excl,FOLLOW_Excl_in_unaryExpr1229);  
                    stream_Excl.add(char_literal131);

                    pushFollow(FOLLOW_atom_in_unaryExpr1231);
                    atom132=atom();

                    state._fsp--;

                    stream_atom.add(atom132.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 172:15: -> ^( NEGATE atom )
                    {
                        // src/grammar/TL.g:172:18: ^( NEGATE atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEGATE, "NEGATE"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/grammar/TL.g:173:6: atom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_unaryExpr1246);
                    atom133=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom133.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpr"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/grammar/TL.g:176:1: atom : ( Number | Bool | Null | lookup );
    public final TLParser.atom_return atom() throws RecognitionException {
        TLParser.atom_return retval = new TLParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Number134=null;
        Token Bool135=null;
        Token Null136=null;
        TLParser.lookup_return lookup137 = null;


        Object Number134_tree=null;
        Object Bool135_tree=null;
        Object Null136_tree=null;

        try {
            // src/grammar/TL.g:177:3: ( Number | Bool | Null | lookup )
            int alt27=4;
            switch ( input.LA(1) ) {
            case Number:
                {
                alt27=1;
                }
                break;
            case Bool:
                {
                alt27=2;
                }
                break;
            case Null:
                {
                alt27=3;
                }
                break;
            case Identifier:
            case Println:
            case Print:
            case Assert:
            case Size:
            case MoveForward:
            case MoveBackward:
            case TurnLeft:
            case TurnRight:
            case Shoot:
            case String:
            case OBracket:
            case OParen:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // src/grammar/TL.g:177:6: Number
                    {
                    root_0 = (Object)adaptor.nil();

                    Number134=(Token)match(input,Number,FOLLOW_Number_in_atom1260); 
                    Number134_tree = (Object)adaptor.create(Number134);
                    adaptor.addChild(root_0, Number134_tree);


                    }
                    break;
                case 2 :
                    // src/grammar/TL.g:178:6: Bool
                    {
                    root_0 = (Object)adaptor.nil();

                    Bool135=(Token)match(input,Bool,FOLLOW_Bool_in_atom1267); 
                    Bool135_tree = (Object)adaptor.create(Bool135);
                    adaptor.addChild(root_0, Bool135_tree);


                    }
                    break;
                case 3 :
                    // src/grammar/TL.g:179:6: Null
                    {
                    root_0 = (Object)adaptor.nil();

                    Null136=(Token)match(input,Null,FOLLOW_Null_in_atom1274); 
                    Null136_tree = (Object)adaptor.create(Null136);
                    adaptor.addChild(root_0, Null136_tree);


                    }
                    break;
                case 4 :
                    // src/grammar/TL.g:180:6: lookup
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_lookup_in_atom1281);
                    lookup137=lookup();

                    state._fsp--;

                    adaptor.addChild(root_0, lookup137.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list"
    // src/grammar/TL.g:183:1: list : '[' ( exprList )? ']' -> ^( LIST ( exprList )? ) ;
    public final TLParser.list_return list() throws RecognitionException {
        TLParser.list_return retval = new TLParser.list_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal138=null;
        Token char_literal140=null;
        TLParser.exprList_return exprList139 = null;


        Object char_literal138_tree=null;
        Object char_literal140_tree=null;
        RewriteRuleTokenStream stream_CBracket=new RewriteRuleTokenStream(adaptor,"token CBracket");
        RewriteRuleTokenStream stream_OBracket=new RewriteRuleTokenStream(adaptor,"token OBracket");
        RewriteRuleSubtreeStream stream_exprList=new RewriteRuleSubtreeStream(adaptor,"rule exprList");
        try {
            // src/grammar/TL.g:184:3: ( '[' ( exprList )? ']' -> ^( LIST ( exprList )? ) )
            // src/grammar/TL.g:184:6: '[' ( exprList )? ']'
            {
            char_literal138=(Token)match(input,OBracket,FOLLOW_OBracket_in_list1295);  
            stream_OBracket.add(char_literal138);

            // src/grammar/TL.g:184:10: ( exprList )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=Identifier && LA28_0<=Shoot)||(LA28_0>=Number && LA28_0<=String)||LA28_0==Excl||LA28_0==Subtract||LA28_0==OBracket||LA28_0==OParen) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // src/grammar/TL.g:184:10: exprList
                    {
                    pushFollow(FOLLOW_exprList_in_list1297);
                    exprList139=exprList();

                    state._fsp--;

                    stream_exprList.add(exprList139.getTree());

                    }
                    break;

            }

            char_literal140=(Token)match(input,CBracket,FOLLOW_CBracket_in_list1300);  
            stream_CBracket.add(char_literal140);



            // AST REWRITE
            // elements: exprList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 184:24: -> ^( LIST ( exprList )? )
            {
                // src/grammar/TL.g:184:27: ^( LIST ( exprList )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);

                // src/grammar/TL.g:184:34: ( exprList )?
                if ( stream_exprList.hasNext() ) {
                    adaptor.addChild(root_1, stream_exprList.nextTree());

                }
                stream_exprList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list"

    public static class lookup_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lookup"
    // src/grammar/TL.g:187:1: lookup : ( functionCall ( indexes )? -> ^( LOOKUP functionCall ( indexes )? ) | list ( indexes )? -> ^( LOOKUP list ( indexes )? ) | Identifier ( indexes )? -> ^( LOOKUP Identifier ( indexes )? ) | String ( indexes )? -> ^( LOOKUP String ( indexes )? ) | '(' expression ')' ( indexes )? -> ^( LOOKUP expression ( indexes )? ) );
    public final TLParser.lookup_return lookup() throws RecognitionException {
        TLParser.lookup_return retval = new TLParser.lookup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier145=null;
        Token String147=null;
        Token char_literal149=null;
        Token char_literal151=null;
        TLParser.functionCall_return functionCall141 = null;

        TLParser.indexes_return indexes142 = null;

        TLParser.list_return list143 = null;

        TLParser.indexes_return indexes144 = null;

        TLParser.indexes_return indexes146 = null;

        TLParser.indexes_return indexes148 = null;

        TLParser.expression_return expression150 = null;

        TLParser.indexes_return indexes152 = null;


        Object Identifier145_tree=null;
        Object String147_tree=null;
        Object char_literal149_tree=null;
        Object char_literal151_tree=null;
        RewriteRuleTokenStream stream_OParen=new RewriteRuleTokenStream(adaptor,"token OParen");
        RewriteRuleTokenStream stream_CParen=new RewriteRuleTokenStream(adaptor,"token CParen");
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_functionCall=new RewriteRuleSubtreeStream(adaptor,"rule functionCall");
        RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");
        RewriteRuleSubtreeStream stream_list=new RewriteRuleSubtreeStream(adaptor,"rule list");
        try {
            // src/grammar/TL.g:188:3: ( functionCall ( indexes )? -> ^( LOOKUP functionCall ( indexes )? ) | list ( indexes )? -> ^( LOOKUP list ( indexes )? ) | Identifier ( indexes )? -> ^( LOOKUP Identifier ( indexes )? ) | String ( indexes )? -> ^( LOOKUP String ( indexes )? ) | '(' expression ')' ( indexes )? -> ^( LOOKUP expression ( indexes )? ) )
            int alt34=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==OParen) ) {
                    alt34=1;
                }
                else if ( (LA34_1==Do||LA34_1==To||LA34_1==In||(LA34_1>=Or && LA34_1<=Pow)||(LA34_1>=GT && LA34_1<=Modulus)||(LA34_1>=OBracket && LA34_1<=CBracket)||(LA34_1>=CParen && LA34_1<=SColon)||(LA34_1>=Comma && LA34_1<=Colon)) ) {
                    alt34=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
                }
                break;
            case Println:
            case Print:
            case Assert:
            case Size:
            case MoveForward:
            case MoveBackward:
            case TurnLeft:
            case TurnRight:
            case Shoot:
                {
                alt34=1;
                }
                break;
            case OBracket:
                {
                alt34=2;
                }
                break;
            case String:
                {
                alt34=4;
                }
                break;
            case OParen:
                {
                alt34=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // src/grammar/TL.g:188:6: functionCall ( indexes )?
                    {
                    pushFollow(FOLLOW_functionCall_in_lookup1323);
                    functionCall141=functionCall();

                    state._fsp--;

                    stream_functionCall.add(functionCall141.getTree());
                    // src/grammar/TL.g:188:19: ( indexes )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==OBracket) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // src/grammar/TL.g:188:19: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup1325);
                            indexes142=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes142.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: functionCall, indexes
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 188:34: -> ^( LOOKUP functionCall ( indexes )? )
                    {
                        // src/grammar/TL.g:188:37: ^( LOOKUP functionCall ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOOKUP, "LOOKUP"), root_1);

                        adaptor.addChild(root_1, stream_functionCall.nextTree());
                        // src/grammar/TL.g:188:59: ( indexes )?
                        if ( stream_indexes.hasNext() ) {
                            adaptor.addChild(root_1, stream_indexes.nextTree());

                        }
                        stream_indexes.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/grammar/TL.g:189:6: list ( indexes )?
                    {
                    pushFollow(FOLLOW_list_in_lookup1350);
                    list143=list();

                    state._fsp--;

                    stream_list.add(list143.getTree());
                    // src/grammar/TL.g:189:11: ( indexes )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==OBracket) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // src/grammar/TL.g:189:11: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup1352);
                            indexes144=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes144.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: indexes, list
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 189:34: -> ^( LOOKUP list ( indexes )? )
                    {
                        // src/grammar/TL.g:189:37: ^( LOOKUP list ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOOKUP, "LOOKUP"), root_1);

                        adaptor.addChild(root_1, stream_list.nextTree());
                        // src/grammar/TL.g:189:51: ( indexes )?
                        if ( stream_indexes.hasNext() ) {
                            adaptor.addChild(root_1, stream_indexes.nextTree());

                        }
                        stream_indexes.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/grammar/TL.g:190:6: Identifier ( indexes )?
                    {
                    Identifier145=(Token)match(input,Identifier,FOLLOW_Identifier_in_lookup1385);  
                    stream_Identifier.add(Identifier145);

                    // src/grammar/TL.g:190:17: ( indexes )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==OBracket) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // src/grammar/TL.g:190:17: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup1387);
                            indexes146=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes146.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: Identifier, indexes
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 190:34: -> ^( LOOKUP Identifier ( indexes )? )
                    {
                        // src/grammar/TL.g:190:37: ^( LOOKUP Identifier ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOOKUP, "LOOKUP"), root_1);

                        adaptor.addChild(root_1, stream_Identifier.nextNode());
                        // src/grammar/TL.g:190:57: ( indexes )?
                        if ( stream_indexes.hasNext() ) {
                            adaptor.addChild(root_1, stream_indexes.nextTree());

                        }
                        stream_indexes.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // src/grammar/TL.g:191:6: String ( indexes )?
                    {
                    String147=(Token)match(input,String,FOLLOW_String_in_lookup1414);  
                    stream_String.add(String147);

                    // src/grammar/TL.g:191:13: ( indexes )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==OBracket) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // src/grammar/TL.g:191:13: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup1416);
                            indexes148=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes148.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: String, indexes
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 191:34: -> ^( LOOKUP String ( indexes )? )
                    {
                        // src/grammar/TL.g:191:37: ^( LOOKUP String ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOOKUP, "LOOKUP"), root_1);

                        adaptor.addChild(root_1, stream_String.nextNode());
                        // src/grammar/TL.g:191:53: ( indexes )?
                        if ( stream_indexes.hasNext() ) {
                            adaptor.addChild(root_1, stream_indexes.nextTree());

                        }
                        stream_indexes.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // src/grammar/TL.g:192:6: '(' expression ')' ( indexes )?
                    {
                    char_literal149=(Token)match(input,OParen,FOLLOW_OParen_in_lookup1447);  
                    stream_OParen.add(char_literal149);

                    pushFollow(FOLLOW_expression_in_lookup1449);
                    expression150=expression();

                    state._fsp--;

                    stream_expression.add(expression150.getTree());
                    char_literal151=(Token)match(input,CParen,FOLLOW_CParen_in_lookup1451);  
                    stream_CParen.add(char_literal151);

                    // src/grammar/TL.g:192:25: ( indexes )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==OBracket) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // src/grammar/TL.g:192:25: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_lookup1453);
                            indexes152=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes152.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: expression, indexes
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 192:34: -> ^( LOOKUP expression ( indexes )? )
                    {
                        // src/grammar/TL.g:192:37: ^( LOOKUP expression ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOOKUP, "LOOKUP"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        // src/grammar/TL.g:192:57: ( indexes )?
                        if ( stream_indexes.hasNext() ) {
                            adaptor.addChild(root_1, stream_indexes.nextTree());

                        }
                        stream_indexes.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lookup"

    public static class indexes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexes"
    // src/grammar/TL.g:195:1: indexes : ( '[' expression ']' )+ -> ^( INDEXES ( expression )+ ) ;
    public final TLParser.indexes_return indexes() throws RecognitionException {
        TLParser.indexes_return retval = new TLParser.indexes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal153=null;
        Token char_literal155=null;
        TLParser.expression_return expression154 = null;


        Object char_literal153_tree=null;
        Object char_literal155_tree=null;
        RewriteRuleTokenStream stream_CBracket=new RewriteRuleTokenStream(adaptor,"token CBracket");
        RewriteRuleTokenStream stream_OBracket=new RewriteRuleTokenStream(adaptor,"token OBracket");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // src/grammar/TL.g:196:3: ( ( '[' expression ']' )+ -> ^( INDEXES ( expression )+ ) )
            // src/grammar/TL.g:196:6: ( '[' expression ']' )+
            {
            // src/grammar/TL.g:196:6: ( '[' expression ']' )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==OBracket) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // src/grammar/TL.g:196:7: '[' expression ']'
            	    {
            	    char_literal153=(Token)match(input,OBracket,FOLLOW_OBracket_in_indexes1480);  
            	    stream_OBracket.add(char_literal153);

            	    pushFollow(FOLLOW_expression_in_indexes1482);
            	    expression154=expression();

            	    state._fsp--;

            	    stream_expression.add(expression154.getTree());
            	    char_literal155=(Token)match(input,CBracket,FOLLOW_CBracket_in_indexes1484);  
            	    stream_CBracket.add(char_literal155);


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 196:28: -> ^( INDEXES ( expression )+ )
            {
                // src/grammar/TL.g:196:31: ^( INDEXES ( expression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INDEXES, "INDEXES"), root_1);

                if ( !(stream_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "indexes"

    // Delegated rules


 

    public static final BitSet FOLLOW_block_in_parse138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block159 = new BitSet(new long[]{0x000000597FF00002L});
    public static final BitSet FOLLOW_functionDecl_in_block163 = new BitSet(new long[]{0x000000597FF00002L});
    public static final BitSet FOLLOW_Return_in_block168 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_block170 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_SColon_in_block172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_SColon_in_statement216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_statement229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_SColon_in_statement231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statement256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignment270 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_indexes_in_assignment272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_Assign_in_assignment275 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_assignment277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_functionCall310 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall312 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_exprList_in_functionCall314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Println_in_functionCall335 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall337 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_functionCall339 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Print_in_functionCall361 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall363 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_functionCall365 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Assert_in_functionCall388 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall390 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_functionCall392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Size_in_functionCall414 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall416 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_functionCall418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MoveForward_in_functionCall442 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall444 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_functionCall446 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MoveBackward_in_functionCall472 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall474 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_functionCall476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TurnLeft_in_functionCall502 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall504 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_functionCall506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TurnRight_in_functionCall532 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall534 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_functionCall536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Shoot_in_functionCall562 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionCall564 = new BitSet(new long[]{0xA0880F007FE00000L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_functionCall566 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionCall569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_ifStatement602 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_elseIfStat_in_ifStatement604 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_elseStat_in_ifStatement607 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_End_in_ifStatement610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_If_in_ifStat638 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_ifStat640 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Do_in_ifStat642 = new BitSet(new long[]{0x000000597FF00000L});
    public static final BitSet FOLLOW_block_in_ifStat644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_elseIfStat668 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_If_in_elseIfStat670 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_elseIfStat672 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Do_in_elseIfStat674 = new BitSet(new long[]{0x000000597FF00000L});
    public static final BitSet FOLLOW_block_in_elseIfStat676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_elseStat700 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Do_in_elseStat702 = new BitSet(new long[]{0x000000597FF00000L});
    public static final BitSet FOLLOW_block_in_elseStat704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Def_in_functionDecl726 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Identifier_in_functionDecl728 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_OParen_in_functionDecl730 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000001L});
    public static final BitSet FOLLOW_idList_in_functionDecl732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_functionDecl735 = new BitSet(new long[]{0x000000597FF00000L});
    public static final BitSet FOLLOW_block_in_functionDecl737 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_End_in_functionDecl739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_For_in_forStatement761 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Identifier_in_forStatement763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_Assign_in_forStatement765 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_forStatement767 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_To_in_forStatement769 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_forStatement771 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Do_in_forStatement773 = new BitSet(new long[]{0x000000597FF00000L});
    public static final BitSet FOLLOW_block_in_forStatement775 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_End_in_forStatement777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_While_in_whileStatement811 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_whileStatement813 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Do_in_whileStatement815 = new BitSet(new long[]{0x000000597FF00000L});
    public static final BitSet FOLLOW_block_in_whileStatement817 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_End_in_whileStatement819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_idList843 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_Comma_in_idList846 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Identifier_in_idList848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_exprList873 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_Comma_in_exprList876 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_exprList878 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_condExpr_in_expression903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_condExpr918 = new BitSet(new long[]{0x0000008000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_QMark_in_condExpr933 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_condExpr937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_Colon_in_condExpr939 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_condExpr943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_In_in_condExpr966 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_condExpr968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1020 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_Or_in_orExpr1023 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1026 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_equExpr_in_andExpr1042 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_And_in_andExpr1045 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_equExpr_in_andExpr1048 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_relExpr_in_equExpr1064 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_set_in_equExpr1067 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_relExpr_in_equExpr1076 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr1092 = new BitSet(new long[]{0x0033000000000002L});
    public static final BitSet FOLLOW_set_in_relExpr1095 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_addExpr_in_relExpr1112 = new BitSet(new long[]{0x0033000000000002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr1128 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_set_in_addExpr1131 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr1140 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_powExpr_in_mulExpr1156 = new BitSet(new long[]{0x0700000000000002L});
    public static final BitSet FOLLOW_set_in_mulExpr1159 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_powExpr_in_mulExpr1172 = new BitSet(new long[]{0x0700000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1188 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Pow_in_powExpr1191 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr1194 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Subtract_in_unaryExpr1212 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Excl_in_unaryExpr1229 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_atom1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_atom1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Null_in_atom1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lookup_in_atom1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OBracket_in_list1295 = new BitSet(new long[]{0xE0880F007FE00000L});
    public static final BitSet FOLLOW_exprList_in_list1297 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_CBracket_in_list1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_lookup1323 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_indexes_in_lookup1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_lookup1350 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_indexes_in_lookup1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_lookup1385 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_indexes_in_lookup1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_lookup1414 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_indexes_in_lookup1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_lookup1447 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_lookup1449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_CParen_in_lookup1451 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_indexes_in_lookup1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OBracket_in_indexes1480 = new BitSet(new long[]{0xA0880F007FE00000L});
    public static final BitSet FOLLOW_expression_in_indexes1482 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_CBracket_in_indexes1484 = new BitSet(new long[]{0x2000000000000002L});

}