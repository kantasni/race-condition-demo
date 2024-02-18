package gr.kantasni.raceconditiondemo.service;

import gr.kantasni.raceconditiondemo.api.MockData;

/**
 * @author Nikos Kantas (n.kantas)
 */
public interface MockDataService<T extends MockData> {

    T getMockData(Integer number);
}
