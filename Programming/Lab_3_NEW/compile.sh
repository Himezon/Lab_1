#!/bin/bash

#Пересоздаём папку с классами и удаляем ранее собранный jar архив.
rm Lab_3_NEW.jar
rm -r classes
mkdir classes

#Компилируем с зависимостью .jar все файлы из пакета pokemons, а мэйновым берём Lab2.java
javac -d classes src/*/*.java src/Main.java

#Собираем jar архив с манифестом и берём скомпилированные классы из соответствующей папочки
jar -cfm Lab_3_NEW.jar manifest.mf -C classes . 

#Запускаем полученный jar архив
java -jar Lab_3_NEW.jar

