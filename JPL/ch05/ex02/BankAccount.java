package ch05.ex02;

public class BankAccount {
	private long number; //口座番号
	private long balance; //現在の残高（単位は、セント）
	private Action lastAct; //最後に行われた処理
	private History history = new History();
	
	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}
		
		public String toString() {
			// identify our enclosing account
			return number + ": " + act + " " + amount;
		}
	}
	
	public class History {
		private final int MAX_COUNT = 10; //記録するBankAccountの数
		private Action[] actions = new Action[MAX_COUNT]; //BankAccountを格納する配列
		private int currentIndex = 0; //現在指しているBankAccountを示すindex
		
		/** 次のBankAccountを取得する。順番は記録順。 */
		public Action next() {
			if (currentIndex == actions.length)
				return null;
			return actions[currentIndex ++];
		}
		
		/** BankAccountを記録する。既に10個記録されている場合は最も古く記録されたBankAccountを削除し、新しいBankAccountを記録する*/
		public void add(Action act) {
			for (int i = 0; i < MAX_COUNT; i++) {
				if (actions[i] == null) {
					actions[i] = act;
					return;
				}
			}
			for (int i = 0; i < MAX_COUNT; i++) {
				if (i == MAX_COUNT - 1) {
					actions[i] = act;
					decreaseCurrentIndex();
					return;
				}
				actions[i] = actions[i+1];
			}
		}
		
		/** currentIndexを1減らす。 */
		private void decreaseCurrentIndex() {
			if (currentIndex > 0)
				currentIndex --;
		}
	}
	
	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.add(lastAct);
	}
	
	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		history.add(lastAct);
	}
	
	public void transfer(BankAccount other, long amount) {
		other.withdraw(amount);
		deposit(amount);
		lastAct = this.new Action("transfer", amount);
		other.lastAct = other.new Action("transfer", amount);
		history.add(lastAct);
	}
	
	public History history() {
		return history;
	}
	
	public static void main(String[] args) {
		BankAccount bank = new BankAccount();
		bank.deposit(200);
		bank.deposit(100);
		bank.deposit(1200);
		bank.deposit(2000);
		bank.withdraw(300);
		bank.deposit(200);
		bank.withdraw(1000);
		bank.withdraw(100);
		bank.deposit(1500);
		bank.deposit(2000);
		bank.deposit(1200);
		bank.deposit(2000);
		
		for (int i = 0; i < 20; i++) {
			System.out.println(bank.history().next());
		}
	}
}
