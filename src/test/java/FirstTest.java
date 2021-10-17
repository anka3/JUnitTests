import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;

abstract class Useless {
        public abstract void things();
}
public class FirstTest { //класс

        private ByteArrayOutputStream output = new ByteArrayOutputStream();  //конструктор

        @Before
        public void setUpStreams() {  //метод
                System.setOut(new PrintStream(output));
        }

        @Test
        public void testString() {
                Book book = new Book();
                book.doSomeLogic();
                Assert.assertEquals("Пушкин родился в 1799 году", output.toString());
        }


        @After
        public void cleanUpStreams() {
                System.setOut(null);
        }


        abstract class BookTest {  //абстрактный класс
                public abstract void test( ByteArrayOutputStream outContent) throws Exception;
        }


}

class MovieBook extends Book   //создаем подкласс от класса, который расширяем
{
        void Onegin()
        {
                System.out.print("Онегин");
        }
}

class Reverse extends MovieBook {
        @Override //переопределение метода - "свой вариант" нужного метода
        void Onegin() {
                System.out.println("Евгений!");
        }
}

interface Boom  {  //интерфейс

        public default void button(){
                System.out.println("Бум!");

        }
}

class Terr implements Boom {  //интерфейс применяем используем элементы интерфейса в этом классе

        public void button() {
                System.out.println("Бах!");
        }

        public static void main(String[] args) {

                Terr opg = new Terr();
                opg.button();
        }
}





//https://devmark.ru/article/junit-system-out-test