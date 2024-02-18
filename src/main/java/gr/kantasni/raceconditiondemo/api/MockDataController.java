package gr.kantasni.raceconditiondemo.api;

import gr.kantasni.raceconditiondemo.service.MockDataService;
import gr.kantasni.raceconditiondemo.service.OptimistickMockDataService;
import gr.kantasni.raceconditiondemo.domain.OptimisticMockData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nikos Kantas (n.kantas)
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class MockDataController {

    private final OptimistickMockDataService service;

    private final BeanFactory beanFactory;

    @GetMapping("/get")
    public MockResponse getMockData(@RequestBody GetMockDataRequest request) {

        MockData mockData = beanFactory.getBean(request.getResolveMethod().name(), MockDataService.class)
            .getMockData(request.getNumber());

        if (mockData != null) {
            SuccessResult successResult = new SuccessResult(mockData.getName(), mockData.getNumber(), mockData.isSwapBoolean());

            return new MockResponse(successResult);
        } else {
            return new MockResponse(new ErrorResult());
        }

    }
}
