#!/bin/bash

rm Lab_5_NEW.jar
rm -r classes
mkdir classes

javac -d classes src/*/*.java src/main/Main.java

#�������� jar ����� � ���������� � ���� ���������������� ������ �� ��������������� �������
jar -cfm Lab_5_NEW.jar manifest.mf -C classes . 

#��������� ���������� jar �����
java -jar Lab_5_NEW.jar

