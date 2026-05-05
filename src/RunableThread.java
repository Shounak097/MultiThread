public class RunableThread implements Runnable{
    int count =5;
    RunableThread(){
    }

    RunableThread(int count){
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++)
            System.out.println("Run Thread value ->" +i+" Current Thread  ->"+Thread.currentThread().getName());
    }
}
