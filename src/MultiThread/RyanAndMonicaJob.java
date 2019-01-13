package MultiThread;

public class RyanAndMonicaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args){
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
        //两个线程都开始了
    }

    @Override
    public void run() {
        for(int x=0; x<10; x++){
            makeWithdrawal(10);

            if(account.getBalance()<0){
                System.out.println("Overdrawn"); //如果账户透支则提示Overdrawn
            }
        }
    }

    private void makeWithdrawal(int amount){
        if(account.getBalance() >= amount){ //余额足够才进行
            System.out.println(Thread.currentThread().getName() + "is about to withdraw");
            try{
                System.out.println(Thread.currentThread().getName() + "is going to sleep"); //取款前先睡觉
                Thread.sleep(500);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + "Completes the withdrawal");
        }else{
            System.out.println("Sorry, balance is not engouh for "+ Thread.currentThread().getName());
        }
    }

    /*
    解决线程问题,需要对账户设置一道锁
    工作流程:
    1. 锁于交易相关(查询余额和提款),只有一把钥匙
    2. A想要取款的时候,会给账户上锁并收起钥匙,现在没有别人能动账户了
	    1. A会持有钥匙一直到交易结束,此时别人无法交易.
        2. 就算A检查完账户后去睡觉,因为别人没有钥匙,账户还是会保持原样.
     */
}
