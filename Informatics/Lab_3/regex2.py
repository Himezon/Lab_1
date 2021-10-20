import re
import random
s = open("random_words").read().split()
#s = input().split() #А ты знал, что ВТ – лучшая кафедра в ИТМО?
default_string = "А ты знал, что ВТ – лучшая кафедра в ИТМО?".split()
TEST_DEFAULT = " ".join(default_string)
ru_alf = [chr(i) for i in range(ord('а'), ord('а')+32)]+[chr(i) for i in range(ord('А'), ord('А')+32)]

def test_generator(s): #Генерация тестовых комбинаций слов... из сгенерированных на стороннем сайте рандомных слов
    alf = []
    for _ in range(5,16):
        alf.append(s[random.randint(0,len(s))-1])
    position_1 = random.randint(1,len(alf)//2)
    position_2 = random.randint(len(alf)//2,len(alf))
    alf = alf[:position_1]+["ВТ"]+alf[position_1:position_2]+["ИТМО"]+alf[position_2:]
    return " ".join(alf)

def checking_for_length(test): #Проверка на количество слов между "ВТ" и "ИТМО" в тексте
    text_str = " ".join(re.findall(r"\w+", "".join(re.findall(r"ВТ.(.+).ИТМО", test))))
    if len(text_str.split()) == 0:
        return -1
    return len(text_str.split()) <= 4

#print(Checking_for_length(TEST_DEFAULT))

def without_re_check(test):
    s = test
    s = s[s.find("ВТ "):s.find(" ИТМО")+5]
    for i in s:
        if not(i in ru_alf):
            s = s.replace(i+" ", "")
    return s

def re_check(test):
    print("Предложение:\n-->" + test)
    if checking_for_length(test) == -1:
        print('Между словами "ВТ" и "ИТМО" нет слов')
    elif checking_for_length(test) == True:
        print("Полученный фрагмент текста:\n   ВТ "+" ".join(re.findall(r"\w+", "".join(re.findall(r"ВТ.(.+).ИТМО", test))))+" ИТМО")
    else:
        print('В предложении между "ВТ" и "ИТМО" более 4 слов')
    return "ВТ "+" ".join(re.findall(r"\w+", "".join(re.findall(r"ВТ.(.+).ИТМО", test))))+" ИТМО"

def comparator(test):
    boo = re_check(test) == without_re_check(test)
    if boo and len(without_re_check(test).split())-2<=4:
        print("При сопоставлении ответов, полученных разными алгоритмами, различий не выявлено")
    elif not(boo):
        print("Алгоритм дал сбой :c")

print(10*"---------------"+"\nТест из примера:")
comparator(TEST_DEFAULT)
print(10*"---------------"+"\nТест 1:")
comparator(test_generator(s))
print(10*"---------------"+"\nТест 2:")
comparator(test_generator(s))
print(10*"---------------"+"\nТест 3:")
comparator(test_generator(s))
print(10*"---------------"+"\nТест 4:")
comparator(test_generator(s))
print(10*"---------------"+"\nТест 5:")
comparator(test_generator(s))