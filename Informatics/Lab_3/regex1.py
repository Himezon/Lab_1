import re
import random
smile = ":-P"

def test_generator():
    alf = ""
    for _ in range(1000):
        alf += chr(random.randint(32, 126))
    for i in range (1, random.randint(1,10)):
        rand = random.randint(100,900)
        alf = alf[:rand] + ":-P" + alf[rand:]
    return alf

def search_answers(test):
    count = 0
    start = -1
    while True:
        start = test.find(":-P", start + 1)
        if start == -1:
            break
        count += 1
    return count

TEST_1 = test_generator()
TEST_2 = test_generator()
TEST_3 = test_generator()
TEST_4 = test_generator()
TEST_5 = test_generator()
print(10*"---------------")
print("Тестовая комбинация номер 1:\n",TEST_1,"\nОтвет полученный без использования регулярных выражений:\n", search_answers(TEST_1), "\nОтвет с использованием regex:\n", len(re.findall(r":-P", TEST_1)), "\n",10*"---------------")
print("Тестовая комбинация номер 2:\n",TEST_2,"\nОтвет полученный без использования регулярных выражений:\n", search_answers(TEST_2), "\nОтвет с использованием regex:\n", len(re.findall(r":-P", TEST_2)), "\n",10*"---------------")
print("Тестовая комбинация номер 3:\n",TEST_3,"\nОтвет полученный без использования регулярных выражений:\n", search_answers(TEST_3), "\nОтвет с использованием regex:\n", len(re.findall(r":-P", TEST_3)), "\n",10*"---------------")
print("Тестовая комбинация номер 4:\n",TEST_4,"\nОтвет полученный без использования регулярных выражений:\n", search_answers(TEST_4), "\nОтвет с использованием regex:\n", len(re.findall(r":-P", TEST_4)), "\n",10*"---------------")
print("Тестовая комбинация номер 5:\n",TEST_5,"\nОтвет полученный без использования регулярных выражений:\n", search_answers(TEST_5), "\nОтвет с использованием regex:\n", len(re.findall(r":-P", TEST_5)))
