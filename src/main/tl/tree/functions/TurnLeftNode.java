package main.tl.tree.functions;

import java.io.PrintStream;

import com.example.antlrtest.BluetoothManager;

import main.tl.TLValue;
import main.tl.tree.TLNode;
/**
 * Instanciated when turnLeft is in code. Takes parameter and converts to NXT API syntax
 */
public class TurnLeftNode implements TLNode {

  private TLNode expression;
  private PrintStream out;

  public TurnLeftNode(TLNode e) {
    this(e, System.out);
  }

  public TurnLeftNode(TLNode e, PrintStream o) {
    expression = e;
    out = o;
  }

  @Override
  public TLValue evaluate() {
    
    TLValue value = expression.evaluate();
    BluetoothManager instance = BluetoothManager.getInstance();
	double distance = 1*value.asDouble();

    byte[] buffer = new byte[28];
	buffer[0] = 0x0c;			//length lsb
	buffer[1] = 0;						// length msb
	buffer[2] = (byte)0x00;						// direct command (with response)
	buffer[3] = 0x04;					// set output state
	buffer[4] = (byte) 0x00;			// output 1 (motor B)
	buffer[5] = (byte) 0x64;			// power
	buffer[6] = 0x07;					// motor on + brake between PWM
	buffer[7] = 0;						// regulation
	buffer[8] = 0;						// turn ratio??
	buffer[9] = 0x20;					// run state
	buffer[10] =0;
	buffer[11] =(byte)distance;
	buffer[12] =0;
	buffer[13] =0;
	buffer[14] = 0x0c;			//length lsb
	buffer[15] = 0;						// length msb
	buffer[16] = (byte)0x00;						// direct command (with response)
	buffer[17] = 0x04;					// set output state
	buffer[18] = (byte) 0x02;			// output 1 (motor B)
	buffer[19] = (byte) 0x9C;			// power
	buffer[20] = 0x07;					// motor on + brake between PWM
	buffer[21] = 0;						// regulation
	buffer[22] = 0;						// turn ratio??
	buffer[23] = 0x20;					// run state
	buffer[24] =0;
	buffer[25] =(byte)distance;
	buffer[26] =0;
	buffer[27] =0;
	instance.addToArray(buffer);
    return TLValue.VOID;
  }
}

