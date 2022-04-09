#!/bin/bash

rm Lab_5_NEW.jar
rm -r classes
mkdir classes

javac -d classes src/*/*.java src/main/Main.java

#Собираем jar архив с манифестом и берём скомпилированные классы из соответствующей папочки
jar -cfm Lab_5_NEW.jar manifest.mf -C classes . 

#Запускаем полученный jar архив
java -jar Lab_5_NEW.jar

