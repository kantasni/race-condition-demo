package gr.kantasni.raceconditiondemo.repository;

import gr.kantasni.raceconditiondemo.domain.SynchronizedMockData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Nikos Kantas (n.kantas)
 */
public interface SynchronizedMockDataRepository extends CrudRepository<SynchronizedMockData, Long> {

    SynchronizedMockData findByNumber(Integer number);

    @Query(nativeQuery = true, value = "select * from synchronized_mock_data order by rand() limit 1")
    SynchronizedMockData findRandom();
}
