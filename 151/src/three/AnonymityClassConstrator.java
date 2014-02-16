package three;

/**
 * 匿名内部类
 * 
 * @author Chain
 * 
 */
public class AnonymityClassConstrator {//

	public static void main(String[] args) {
		Calculator c = new Calculator(10, 20) {
			{
				setOperator(Ops.ADD);//
			}
		};

		/**
		 * 
		 * class Add extends Calculator{ { setOperator(Ops.ADD);//s }
		 * 
		 * public Add(int _i,int _j){ super(_i,_j); } }
		 * 
		 */

		System.out.println(c.getResult());
		
		Calculator c1 = new Add(10, 450);
		System.out.println(c1.getResult());
	}
}

enum Ops {
	ADD, SUB
}

class Calculator {
	private int i, j, result;

	public Calculator() {
	}

	public Calculator(int _i, int _j) {
		i = _i;
		j = _j;
	}

	void setOperator(Ops _op) {
		result = _op.equals(Ops.ADD) ? i + j : i - j;
	}

	public int getResult() {
		return result;
	}

}

class Add extends Calculator {
	{
		setOperator(Ops.ADD);// s
	}
	public Add(int _i, int _j) {  //先调用父类的构造函数 在执行自身的构造函数
		super(_i, _j);
//		setOperator(Ops.ADD);
	}
}