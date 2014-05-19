package main.tl.tree;

import main.tl.Scope;
import main.tl.TLValue;

public class ForStatementNode implements TLNode {

    private String identifier;
    private TLNode startExpr;
    private TLNode stopExpr;
    private TLNode block;
    protected Scope scope;

    public ForStatementNode(String id, TLNode start, TLNode stop, TLNode bl, Scope s) {
        identifier = id;
        startExpr = start;
        stopExpr = stop;
        block = bl;
        scope = s;
    }

    @Override
    public TLValue evaluate() {

        int start = startExpr.evaluate().asDouble().intValue();
        int stop = stopExpr.evaluate().asDouble().intValue();

        for(int i = start; i <= stop; i++) {
            scope.assign(identifier, new TLValue(i));
            TLValue returnValue = block.evaluate();
            if(returnValue != TLValue.VOID) {
                return returnValue;
            }
        }

        return TLValue.VOID;
    }
}
