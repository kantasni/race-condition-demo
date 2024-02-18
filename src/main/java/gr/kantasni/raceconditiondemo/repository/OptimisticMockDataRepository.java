package gr.kantasni.raceconditiondemo.repository;

import gr.kantasni.raceconditiondemo.domain.OptimisticMockData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Repository
public interface OptimisticMockDataRepository extends CrudRepository<OptimisticMockData, Long> {

    OptimisticMockData findByNumber(Integer number);

    @Query(nativeQuery = true,value = "select * from optimistic_mock_data order by rand() limit 1")
    OptimisticMockData findRandom();
}
