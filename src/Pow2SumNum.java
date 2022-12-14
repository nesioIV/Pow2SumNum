import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.log;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @author NesioIV
 * @version 1.0
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
/*
   реализуется задача расчета минимальной степени 2, которая равна
   или больше суммы элементов массива

   описание решения задачи приведено в файле ..\README.md
*/
class Pow2SumNum {

   // массив и поля-переменные общего доступа
   static List<Integer> numArrList = new ArrayList<>();
   static long sum;
   static int log2Log = 0;
   static int log2Bit = 0;
   static long pow2Log = 0;
   static long pow2Bit = 0;

   /*
      метод вычисления степени 2
   */
   static void CalcPow2SumNum() {
      for (int i = 1; i <= numArrList.size(); i++) {
         sum += numArrList.get(i - 1);
      }
      log2Log = getLog2Log(sum);  // логарифмирование способом 1
      pow2Log = getPow2(log2Log); // возведение 2 в спепень
      log2Bit = getLog2Bit(sum);  // логарифмирование способом 2
      pow2Bit = getPow2(log2Bit); // возведение 2 в спепень
   }

   /*
       метод целочисленного двоичного логарифмирования с ипользованием
       логарифмов из класса Math и поразрядного умножения (побитового И)
    */
   static int getLog2Log(long x) {
      if (x <= 1) {
         return 0;  // минимально возможный логарифм
      }
      else {
         if ((x & (x - 1)) == 0) {  // трюк с поразрядным умножением
            return (int) (log(x) / log(2));  // x является степенью 2
         }
         else {
            return (int) (log(x) / log(2)) + 1; // x не является степенью 2
         }
      }
   }

    /*
       метод целочисленного двоичного логарифмирования с использованием
       поразрядого сдвига влево
    */
   static int getLog2Bit(long x) {
      int i = 1;
      long y = 1;
      for (i = 1; y < x; i++) {
         if (i + 1 < 64) {  // 64 - разрядность типа данных long в Java
            y <<= 1;  // поразрядный сдвиг, если не достигут старший бит
         }
         else {
            y = x; // прервать цикл, т.к. достигнут старший бит при сдвиге
         }
      }
      return (i - 1);
   }

    /*
       метод возведения 2 в целую положительную степень
    */
   static long getPow2(int x) {
      long y = 1;
      if (x > 0) {
         for (int i = 1; i <= x; i++) {
            y *= 2;
         }
      }
      return y;
   }

   /*
      главный метод класса
      - реализует консольный интерфейс с пользователем
      - принимает ввод исходных данных, контролирует ограничения
        вводимых данных на допустимость
      - вызывает метод расчета наименьшей степени 2
      - выводит результаты работы приложения в консоль
      - использует класс java.util.Scanner
    */
   public static void main(String[] args) {

      System.out.println("\n" + "<Минимальная степень 2, равная или больше суммы элементов массива> NesioIV, 2022" + "\n");

      int flag;  // признак продолжения ввода
      int nextInt; // следующий элемент массива

      while (true) {
         flag = -1;
         while (flag < 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Текущее состояние массива: " + numArrList);
            System.out.println("\nДобавить элемент массива (1 - да / 0 - нет)?");
            try {
               flag = scan.nextInt();
               if (flag < 0 | flag > 1) {
                  System.err.println("Ввод некорректен.");
                  flag = -1;
               }
            } catch (InputMismatchException e) {
               System.err.println("Ввод некорректен.");
               flag = -1;
            }
         }
         if (flag == 1) {
            nextInt = 0;
            while (nextInt == 0) {
               Scanner scan = new Scanner(System.in);
               System.out.print("\nВведите элемент массива (целое число 0 < A <= 2147483647): \n");
               try {
                  nextInt = scan.nextInt();
                  if (nextInt <= 0) {
                     System.err.print("Ввод некорректен. \n");
                     nextInt = 0;
                  }
               } catch (InputMismatchException e) {
                  System.err.print("Ввод некорректен. \n");
                  nextInt = 0;
               }
               if (nextInt > 0) numArrList.add(nextInt);
            }
         }
         if (flag == 0) {
            break;
         }
      }
      System.out.println("\nТекущее состояние массива: " + numArrList);
      System.out.println("Выполняется расчет минимальной степени 2 для заданного массива..." + "\n");
      Instant startTime = Instant.now();
      CalcPow2SumNum();
      Instant stopTime = Instant.now();
      System.out.printf("%-30s", "Сумма элементов массива");
      System.out.printf("%n%-30d", sum);
      System.out.printf("%n%-30s %-30s", "Степень 2 (с логарифмиров.)", "Показатель степени 2 (с логарифмиров.)");
      System.out.printf("%n%-30d %-30d", pow2Log, log2Log);
      System.out.printf("%n%-30s %-30s", "Степень 2 (с поразр. сдвигом)", "Показатель степени 2 (с поразр. сдвигом)");
      System.out.printf("%n%-30d %-30d", pow2Bit, log2Bit);
      System.out.printf("%n%-30s", "Время выполнения, мс");
      System.out.printf("%n%-30d", Duration.between(startTime, stopTime).toMillis());
      System.out.println("\n");
      System.out.println("= Выполнение завершено =");
   }
}


