package ch05.ex02;

public class BankAccount {
	private long number; //�����ԍ�
	private long balance; //���݂̎c���i�P�ʂ́A�Z���g�j
	private Action lastAct; //�Ō�ɍs��ꂽ����
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
		private final int MAX_COUNT = 10; //�L�^����BankAccount�̐�
		private Action[] actions = new Action[MAX_COUNT]; //BankAccount���i�[����z��
		private int currentIndex = 0; //���ݎw���Ă���BankAccount������index
		
		/** ����BankAccount���擾����B���Ԃ͋L�^���B */
		public Action next() {
			if (currentIndex == actions.length)
				return null;
			return actions[currentIndex ++];
		}
		
		/** BankAccount���L�^����B����10�L�^����Ă���ꍇ�͍ł��Â��L�^���ꂽBankAccount���폜���A�V����BankAccount���L�^����*/
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
		
		/** currentIndex��1���炷�B */
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
