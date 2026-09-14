import ru.netology.javaqa.Radio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RadioTest {

    /*Ожидаемый результат: текущая станция равна 6 */
    @Test
    public void test() {
        Radio radio = new Radio();

        radio.setCurrentStation(6);

        int expected = 6;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: переключение на следующую станцию (с 5 на 6)*/
    @Test
    public void testNext() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);
        radio.next();

        int expected = 6;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /* Проверка: переход с последней станции (9) на первую (0)*/
    @Test
    public void testNextFromNineToZero() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: переключение на предыдущую станцию (с 5 на 4)*/
    @Test
    public void testPrev() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);
        radio.prev();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: переход с первой станции (0) на последнюю (9)*/
    @Test
    public void testPrevFromZeroToNine() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: попытка установить станцию ниже минимума (-1)*/
    @Test
    public void testSetInvalidStationBelowZero() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: попытка установить станцию выше максимума (10)*/
    @Test
    public void testSetInvalidStationAboveNine() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);
        radio.setCurrentStation(10);

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: увеличение громкости на 1 (три раза подряд)*/
    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();
        radio.increaseVolume();
        radio.increaseVolume();

        int expected = 3;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: попытка увеличить громкость выше максимума (100)*/
    @Test
    public void testIncreaseVolumeMax() {
        Radio radio = new Radio();

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }


    /* Проверка: попытка уменьшить громкость ниже минимума (0)*/
    @Test
    public void testDecreaseVolumeMin() {
        Radio radio = new Radio();

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    /* Проверка: начальное значение текущей станции*/
    @Test
    public void testInitialStation() {
        Radio radio = new Radio();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /* Проверка: начальное значение громкости*/
    @Test
    public void testInitialVolume() {
        Radio radio = new Radio();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    /*Проверка: установка минимально допустимой станции (0)*/
    @Test
    public void testSetValidStationZero() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    /* Проверка: установка максимально допустимой станции (9)*/
    @Test
    public void testSetValidStationNine() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    // новые
    /* Проверка: setCurrentStation с очень отрицательным значением (обе части условия false) */
    @Test
    public void testSetInvalidStationVeryNegative() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-100);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    /* Проверка: уменьшение громкости когда она больше 0 (ветка true в decreaseVolume) */
    @Test
    public void testDecreaseVolumeNormal() {
        Radio radio = new Radio();
        radio.increaseVolume(); // громкость = 1
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    /* Проверка: setCurrentVolume с валидным значением (true && true) */
    @Test
    public void testSetCurrentVolumeValid() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }

    /* Проверка: setCurrentVolume с отрицательным значением (false && true) */
    @Test
    public void testSetCurrentVolumeNegative() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(-1); // -1 < 0, но -1 <= 100
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }

    /* Проверка: setCurrentVolume со значением больше 100 (true && false) */
    @Test
    public void testSetCurrentVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(150);
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }

    /* Проверка: setCurrentVolume с очень отрицательным значением (false && false) */
    @Test
    public void testSetCurrentVolumeVeryNegative() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(-100);
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }
}