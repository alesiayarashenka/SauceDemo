package car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.Assert;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Car {
    public String mark;
    public String model;

    public static void main(String[] args) {
//       Car car0 = new Car("byd");
        Car car0 = Car.builder()
                .mark("byd")
                .build();
        Car car1 = new Car("byd", "1");
        Car car2 = new Car("byd", "2");

        Assert.assertEquals(car1, car2);
    }
}
