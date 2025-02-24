class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is attempting to withdraw " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrawal successful. New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds to withdraw " + amount + ". Current balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class WithdrawalTask implements Runnable {
    private final BankAccount account;
    private final double amount;

    public WithdrawalTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new WithdrawalTask(account, 200), "Thread-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
