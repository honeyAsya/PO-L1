package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private List<Simulation> simulations;
    private List<Thread> threads;
    private final ExecutorService  fixerExecutor;


    public SimulationEngine(List<Simulation> simulations){
        this.simulations = simulations;
        fixerExecutor = Executors.newFixedThreadPool(4);
        threads = new ArrayList<>();
    }

    public void runSync(){
        simulations.forEach(Simulation::run);
    }

    public void runAsync(){
       threads =  simulations.stream().map(Thread::new).toList();
        threads.forEach(Thread::start);
        awaitSimulationsEnd();
    }

    public void awaitSimulationsEnd(){
        fixerExecutor.shutdown();
            try {
                for (Thread simulationsThread : threads) {
                    simulationsThread.join();
                }
                fixerExecutor.awaitTermination(10L , TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println("Error in async task");
            }

        System.out.println("All tasks completed");
    }
    public void runAsyncInThreadPool(){
        simulations.forEach(fixerExecutor::execute);
        awaitSimulationsEnd();
    }
}
