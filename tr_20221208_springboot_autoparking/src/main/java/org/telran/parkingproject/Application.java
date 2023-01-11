package org.telran.parkingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /*
    ДЗ:

На основе последнего урока, как договаривались, сделать сервис парковка.
В котором должен быть следующий функционал:
- Получить список всех машин на парковке.
- Добавить машину на парковку
- Убрать машину с парковки.
Основываться на проекте сделанном в классе, что бы можно было сначала добавить автомобиль через сервис авто,
а потом этот автомобиль поставить или убрать с парковки.
Делаем строго по аналогии.

     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
