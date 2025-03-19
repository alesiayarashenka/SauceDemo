package tests;

import car.Car;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class CarTest {

    @Test
    public void carCompere(){
        Car car0 = Car.builder()
                .mark("byd")
                .build();
        Car car1 = new Car("byd", "1");
        Car car2 = new Car("byd", "2");

        Assert.assertEquals(car1, car2);
    }

    @Test
    public void loggerTest(){
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }
}
