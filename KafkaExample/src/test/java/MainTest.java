import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author hansong.xhs
 * @version $Id: MainTest.java, v 0.1 2016-08-29 10:58 hansong.xhs Exp $
 */
public class MainTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

//        executor.execute(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("end");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

    }
}
