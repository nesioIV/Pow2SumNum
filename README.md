Pow2SumNum

# Решение задачи программирования на тему "Минимальная степень 2, равная или больше суммы массива" на языке Java

**ФОРМУЛИРОВКА ЗАДАЧИ:**

Найти наименьшую степень 2, равную или больше суммы чисел в заданном массиве.

**ПРОГРАММНЫЙ КОД:**

Исходный программный код содержится в файле с именем *Pow2SumNum.java*.

**НАЗНАЧЕНИЕ:**

Класс Pow2SumNum реализует:
- метод CalcPow2SumNum, который управляет расчетом наименьшей степени 2, равной или большей суммы чисел в заданном массиве;
- метод целочисленного двоичного логарифмирования getLog2Log с использованием логарифмов из класса Math и поразрядного умножения (побитового "И");
- метод getLog2Log целочисленного двоичного логарифмирования с использованием поразрядого сдвига влево;
- метод возведения 2 в целую положительную степень;
- метод main, обеспечивающий консольный интерфейс взаимодействия с пользователем.

**АЛГОРИТМ:**

Вычисляется сумма (Sum) значений заданного массива. Затем вычисляется двумя способами такой целочисленный двоичный логарифм (Log2(Sum)) этой суммы, что 2^(Log2(Sum)) >= Sum.  
_1-й способ_:  
Сначала для проверки суммы на степень 2 используется поразрядное умножение (побитовое "И") вида Sum"И"(Sum-1), результат которого должен быть равным 0. Если проверка не удовлетворительна, то далее для двоичного логарифмирования в этом способе используется стандартный метод вычисления натурального логарифма Ln из библиотеки Math и выполняется переход к основанию 2 логарифма по формуле Log2(Sum) = Ln(Sum) / Ln(2).  
_2-й способ_:  
В этом способе для двоичного логарифимирования используются битовые операци поразрядого сдвига 1 влево, пока результат сдвига меньше Sum. Искомый логарифм равен величине (к - 1), де к - количество сдвигов. При этом следует контролировать условие, когда сдвигаемая 1 достигнет старшего битового разряда MSB (most significant bit) того целочисленного типа данных, в котором хранится данная сдвигаемая 1 (например, integer или long), поскольку этот разряд предназначен для хранения знака целого числа. В этом граничном случае следует остановить вычисления и принять, что Log2(Sum) = MSB.  
_Результат:_  
Искомая минимальная степень 2 вычисляется возведением в степень, которая равна значению целочисленного двоичного логарифма, найденного способами 1 и 2.  
_Примечание:_  
Алгоритмы целочисленного двоичного логарифмирования способом 1 и способом 2 при необходимости легко трансформируются в алгоритмы вычисления искомой степени 2 без обособления функциональности двоичного логарифмирования в отдельные методы.

**СЛОЖНОСТЬ:**

В приложении реализован алгоритм с линейной временной сложностью O(n), определяемой размером n входного массива данных.

**РЕАЛИЗАЦИЯ:**

Java version "11.0.1", использованы стандартные возможности JDK.

**ОГРАНИЧЕНИЯ:**

Приложение допускает ввод и обработку только целых положительных чисел типа Integer, которые могут быть заданы во входном массиве.

**ТЕСТИРОВАНИЕ:**

Тестирование корректности получаемых результатов работы приложения обеспечивается двумя разными способами их расчета.

**КОНТРОЛЬНЫЙ ПРИМЕР выполнения приложения**:

<МИНИМАЛЬНАЯ СТЕПЕНЬ 2, РАВНАЯ ИЛИ БОЛЬШЕ СУММЫ МАССИВА>, NesioIV, 2022

Текущее состояние массива: [ ]  
Добавить элемент массива (1 - да / 0 - нет)?  1  
Введите элемент массива (целое число 0 < A <= 2147483647):  10  
Текущее состояние массива: [10]  
Добавить элемент массива (1 - да / 0 - нет)?  1  
Введите элемент массива (целое число 0 < A <= 2147483647):  20  
Текущее состояние массива: [10, 20]  
Добавить элемент массива (1 - да / 0 - нет)?  1
Введите элемент массива (целое число 0 < A <= 2147483647):  30  
Текущее состояние массива: [10, 20, 30]  
Добавить элемент массива (1 - да / 0 - нет)?  0  

Текущее состояние массива: [10, 20, 30]
Выполняется расчет минимальной степени 2 для заданного массива...

Сумма элементов массива       
60                          

Степень 2 (с логарифмиров.)  
64                             
Показатель степени 2 (с логарифмиров.)  
6                             

Степень 2 (с поразр. сдвигом)  
64                             
Показатель степени 2 (с поразр. сдвигом)  
6                             

Время выполнения, мс          
0                             

= Выполнение завершено =

Process finished with exit code 0