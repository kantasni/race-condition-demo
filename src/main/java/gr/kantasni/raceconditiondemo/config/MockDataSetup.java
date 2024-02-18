package gr.kantasni.raceconditiondemo.config;

import java.util.ArrayList;
import java.util.List;

import gr.kantasni.raceconditiondemo.domain.OptimisticMockData;
import gr.kantasni.raceconditiondemo.domain.SynchronizedMockData;
import gr.kantasni.raceconditiondemo.repository.OptimisticMockDataRepository;
import gr.kantasni.raceconditiondemo.repository.SynchronizedMockDataRepository;
import gr.kantasni.raceconditiondemo.service.OptimistickMockDataService;
import gr.kantasni.raceconditiondemo.service.SynchronizedMockDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class MockDataSetup implements ApplicationListener<ApplicationStartedEvent> {

    private final OptimistickMockDataService service;

    private final OptimisticMockDataRepository optimisticMockDataRepository;

    private final SynchronizedMockDataRepository synchronizedMockDataRepository;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {

      fillOptimisticMockDataTable();
      fillSynchronizedMockDataTable();
    }

    public void fillOptimisticMockDataTable(){
        List<OptimisticMockData> list = new ArrayList<>();
        log.info("Initializing optimistic mock data...");
        for (int i = 0; i < 10; i++) {
            OptimisticMockData optimisticMockData = new OptimisticMockData();
            optimisticMockData.setName("test_" + i);
            optimisticMockData.setNumber(i);
            optimisticMockData.setSwapBoolean(false);

            list.add(optimisticMockData);
        }

        optimisticMockDataRepository.saveAll(list);
        log.info("Initialization complete!");
    }

    public void fillSynchronizedMockDataTable(){
        List<SynchronizedMockData> list = new ArrayList<>();
        log.info("Initializing synchronized mock data...");
        for (int i = 0; i < 10; i++) {
            SynchronizedMockData optimisticMockData = new SynchronizedMockData();
            optimisticMockData.setName("test_" + i);
            optimisticMockData.setNumber(i);
            optimisticMockData.setSwapBoolean(false);

            list.add(optimisticMockData);
        }

        synchronizedMockDataRepository.saveAll(list);
        log.info("Initialization complete!");
    }
}
