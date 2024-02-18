package gr.kantasni.raceconditiondemo.service;

import java.util.ArrayList;
import java.util.List;

import gr.kantasni.raceconditiondemo.domain.OptimisticMockData;
import gr.kantasni.raceconditiondemo.repository.OptimisticMockDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Service("OPTIMISTIC_LOCK")
@RequiredArgsConstructor
@Slf4j
public class OptimistickMockDataService implements MockDataService<OptimisticMockData> {

    private final OptimisticMockDataRepository optimisticRepository;

    public void addMockData(OptimisticMockData optimisticMockData) {
        optimisticRepository.save(optimisticMockData);
    }

    public OptimisticMockData getMockData(Integer number) {
        try {
            OptimisticMockData data = optimisticRepository.findByNumber(number);
            data.setSwapBoolean(!data.isSwapBoolean());

            return optimisticRepository.save(data);
        } catch (Exception ex) {
            return getMockData(number);
        }
    }

    @Override
    public OptimisticMockData getRandomMockData() {
        try {
            OptimisticMockData data = optimisticRepository.findRandom();
            data.setSwapBoolean(!data.isSwapBoolean());

            return optimisticRepository.save(data);
        } catch (Exception ex) {
            return getRandomMockData();
        }
    }
}
