  package main.tl.tree.functions;

import java.io.PrintStream;

import com.example.antlrtest.BluetoothManager;

import main.tl.TLValue;
import main.tl.tree.TLNode;
/**
 * Instanciated when shoot is in code. Takes parameter and converts to NXT API syntax
 */
public class ShootNode implements TLNode {

  private TLNode expression;
  private PrintStream out;

  public ShootNode(TLNode e) {
    this(e, System.out);
  }

  public ShootNode(TLNode e, PrintStream o) {
    expression = e;
    out = o;
  }

  @Override
  public TLValue evaluate() {
    
    TLValue value = expression.evaluate();
    BluetoothManager instance = BluetoothManager.getInstance();
    byte[] buffer = new byte[42];
	double distance = 1*value.asDouble();

	buffer[0] = 0x0c;			//length lsb
	buffer[1] = 0;						// length msb
	buffer[2] = (byte)0x00;						// direct command (with response)
	buffer[3] = 0x04;					// set output state
	buffer[4] = (byte) 0x01;			// output 1 (motor B)
	buffer[5] = (byte) 0x64;			// power
	buffer[6] = 0x07;					// motor on + brake between PWM
	buffer[7] = 0;						// regulation
	buffer[8] = 0;						// turn ratio??
	buffer[9] = 0x20;					// run state
	buffer[10] =0;
	buffer[11] =(byte)distance;
	buffer[12] =0;
	buffer[13] =0;

	instance.addToArray(buffer);

    return TLValue.VOID;
  }
}
