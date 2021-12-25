#!/bin/bash

#���������� ����� � �������� � ������� ����� ��������� jar �����.
rm Lab_3_NEW.jar
rm -r classes
mkdir classes

#����������� � ������������ .jar ��� ����� �� ������ pokemons, � �������� ���� Lab2.java
javac -d classes src/*/*.java src/Main.java

#�������� jar ����� � ���������� � ���� ���������������� ������ �� ��������������� �������
jar -cfm Lab_3_NEW.jar manifest.mf -C classes . 

#��������� ���������� jar �����
java -jar Lab_3_NEW.jar

