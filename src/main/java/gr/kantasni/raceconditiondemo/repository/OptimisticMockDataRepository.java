package gr.kantasni.raceconditiondemo.repository;

import gr.kantasni.raceconditiondemo.domain.OptimisticMockData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Repository
public interface OptimisticMockDataRepository extends CrudRepository<OptimisticMockData, Long> {

    OptimisticMockData findByNumber(Integer number);
}
