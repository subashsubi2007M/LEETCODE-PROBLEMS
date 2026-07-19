import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    // Array of 5 locks representing the 5 forks
    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        // Determine fork indices
        int leftForkIdx = philosopher;
        int rightForkIdx = (philosopher + 1) % 5;
        
        // Enforce lock ordering: always lock the smaller index first
        int firstFork = Math.min(leftForkIdx, rightForkIdx);
        int secondFork = Math.max(leftForkIdx, rightForkIdx);
        
        // Acquire forks in order
        forks[firstFork].lock();
        forks[secondFork].lock();
        
        try {
            // Pick up forks, eat, and then put down forks
            pickLeftFork.run();
            pickRightFork.run();
            
            eat.run();
            
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Always release locks in the finally block to prevent leaks
            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }
    }
}
