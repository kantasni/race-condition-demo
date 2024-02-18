package gr.kantasni.raceconditiondemo.service;

import gr.kantasni.raceconditiondemo.domain.SynchronizedMockData;
import gr.kantasni.raceconditiondemo.repository.SynchronizedMockDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Service("SYNCHRONIZED")
@RequiredArgsConstructor
@Slf4j
public class SynchronizedMockDataService implements MockDataService<SynchronizedMockData> {

    private final SynchronizedMockDataRepository repository;

    @Override
    public synchronized SynchronizedMockData getMockData(Integer number) {
        SynchronizedMockData data = repository.findByNumber(number);
        if (data != null) {
            data.setSwapBoolean(!data.isSwapBoolean());

            return repository.save(data);
        }

        return null;
    }

    @Override
    public SynchronizedMockData getRandomMockData() {
        SynchronizedMockData data = repository.findRandom();
        if (data != null) {
            data.setSwapBoolean(!data.isSwapBoolean());

            return repository.save(data);
        }

        return null;
    }
}
