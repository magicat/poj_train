/* @author: */
import java.util.Scanner;
import java.util.Stack;

public class Poj3295 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String wff = sc.next();
			if (wff.trim().equals("0")) {
				break;
			}
			T tt = new T();
			F ff = new F();
			W[] ws = new W[5];
			for (int i = 0; i < 5; i ++) {
				ws[i] = new W();
			}
			Operator root = null;
			Stack<Operator> stack = new Stack<Operator>();
			for (int i = 0; i < wff.length(); i ++ ) {
				Operator cur = null;
				char c = wff.charAt(i);
				if (c == 'K') {
					cur = new And();
				} else if (c == 'A') {
					cur = new Or();
				} else if (c == 'N') {
					cur = new Not();
				} else if (c == 'C') {
					cur = new Imp();
				} else if (c == 'E') {
					cur = new Eq();
				} else {
					cur = ws[c - 'p'];
				}
				if (i == 0) root = cur;
				if (stack.isEmpty()) {
					stack.push(cur);
				} else {
					Operator prev = stack.pop();
					while (prev.comp()) {
						prev = stack.pop();
					}
					prev.push(cur);
					if (!prev.comp())
						stack.push(prev);
					stack.push(cur);
				}
			}
			boolean f = true;
			for (int i = 0; i < (1<<5); i ++) {
				for (int j = 0; j < 5; j ++) {
					if ((i & (1<<j)) > 0) {
						ws[j].push(tt);
					} else {
						ws[j].push(ff);
					}
				}
				boolean res = root.cal();
				if (!res) {
					f = false;
					break;
				}
			}
			if (!f) {
				System.out.println("not");
			} else 
				System.out.println("tautology");
		}
	}
}

abstract class Operator {
	abstract boolean cal();
	abstract void push(Operator op);
	abstract boolean comp();
}

abstract class DOp extends Operator {
	public Operator left;
	public Operator right;
	public boolean stat;
	
	void push(Operator op) {
		if (!stat) {
			left = op;
			stat = true;
		}
		else
			right = op;
	}
	
	boolean comp() {
		if (left != null && right != null) {
			return true;
		}
		return false;
	}
}

class W extends Operator {
	public Operator op = null;
	@Override
	boolean cal() {
		return op.cal();
	}
	
	@Override
	void push(Operator op) {
		this.op = op;
	}

	@Override
	boolean comp() {
		return true;
	}
}

class T extends Operator {
	@Override
	boolean cal() {
		return true;
	}

	@Override
	void push(Operator op) {
	}

	@Override
	boolean comp() {
		return true;
	}
}

class F extends Operator {
	@Override
	boolean cal() {
		return false;
	}

	@Override
	void push(Operator op) {
	}

	@Override
	boolean comp() {
		return true;
	}
}

class And extends DOp {
	@Override
	boolean cal() {
		return left.cal() && right.cal();
	}
}

class Or extends DOp {
	@Override
	boolean cal() {
		return left.cal() || right.cal();
	}
}

class Not extends Operator {
	public Operator one;

	@Override
	boolean cal() {
		return !one.cal();
	}

	@Override
	void push(Operator op) {
		one = op;
	}

	@Override
	boolean comp() {
		if (one != null) return true;
		return false;
	}
}

class Imp extends DOp {
	@Override
	boolean cal() {
		boolean l = left.cal();
		boolean r = right.cal();
		if (l && !r) {
			return false;
		}
		return true;
	}
}

class Eq extends DOp {
	@Override
	boolean cal() {
		return left.cal() == right.cal();
	}
}

