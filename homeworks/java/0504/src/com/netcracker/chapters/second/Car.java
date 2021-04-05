package com.netcracker.chapters.second;

/**
 * Solution for chapter 2, exercise №8
 */
public class Car {
    /** обьем бака равен 40 литрам */
    private final static int GAS_TANK = 40;
    // уровень топлива (в процентах)
    private int levelGasTank = 0;
    // эффективность использования топлива
    private double MPG = 0;
    // пройденная дистанция
    private double distance = 0;


    Car() {
        this(100, 10);
    }

    // галлоны равны 4 литрам
    // 1 галлон равен 1 миле
    Car(double miles, int gallons) throws ArithmeticException {
        if (GAS_TANK < gallons) {
            throw new ArithmeticException("impossible");
        }

        this.MPG = (miles - this.distance) / gallons;
        this.levelGasTank += (gallons * 4 * 100 / GAS_TANK);
        this.distance += gallons;
    }

    public double getFuelEfficiency() {
        return this.MPG;
    }

    public double getDistance() {
        this.levelGasTank -= (this.distance * 100 / GAS_TANK);
        return this.distance;
    }

    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.getFuelEfficiency());

        // Ответ на вопрос, почему нельзя сделать данный класс immutable:
        // Чтобы создать класс immutable, вам необходимо выполнить следующие действия:
        // 1. Объявите класс окончательным, чтобы он не мог быть расширен.
        // Контрпример: Наш класс можно использовать как класс-рдитель для классов-потомков - конкретных марок машин,
        //              для которых формулы топлива, расстояния и тп. считаются одинаково.
        // 2. Сделайте все поля закрытыми, чтобы прямой доступ не был разрешен.
        // 3. Не предоставляйте setter методов для переменных
        // Контрпример: Пользователю при заправке машины может потребоваться, например, изменение полей уровня топлива,
        //              из-за этого методы set необходимы
        // 4. Сделайте все изменяемые поля окончательными, чтобы их значение можно было присвоить только один раз.
        // Контрпример: та же логика (см. пункт 3)
        // 5. Инициализируйте все поля с помощью конструктора, выполняющего глубокое копирование.
        // Контрпример: та же логика (см. пункт 3)
        // 6. Выполните клонирование объектов в методах getter, чтобы вернуть копию, а не фактическую ссылку на объект.
    }
}