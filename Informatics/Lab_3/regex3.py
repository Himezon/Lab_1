#НЕТ! НЕТ БЛИН! Я НЕ БУДУ ПИСАТЬ ГЕНЕРАТОР ПОД ЭТО ЗАДАНИЕ!!!!!
#И нет, названия нормальные мне было местами просто влом придумывать
import re

def reading_file(name):
    file = open(name).read().split("\n")
    num_group = file[0].split()[1]
    file.pop(0)
    file.pop(-1)
    return file, num_group
#print(reading_file("list_of_names")[0])

def without_re_check(name):
    list_after_joke = []
    for i in name[0]:
        st = i.split()
        if st[1][0] != st[1][2] or st[-1] != name[1]:
            list_after_joke.append(i)
    return list_after_joke

def re_check(name):
    list_after_joke = []
    for i in name[0]:
        st = re.findall(r"[А-Я]", i)
        if st[1]!=st[2] or "".join(re.findall(r"[A-Z]\d*",i))!=name[1]:
            list_after_joke.append(i)
    return list_after_joke

def output(name):
    print("Номер группы: " + name[1])
    print("Список группы:")
    for i in name[0]:
        print(" - "+i)
    if len(re_check(name))==0:
        print("Результат:\n   Шутник стёр всех! (」°ロ°)」")
    elif re_check(name) == without_re_check(name):
        print("При сопоставлении ответов, полученных разными алгоритмами, различий не выявлено")
        print("Результат: \n - "+"\n - ".join(re_check(name)))
    else:
        print("Где-то ошибочка")

print(10*"---------------"+"\nТест из примера:")
output(reading_file("list_of_names"))
print(10*"---------------"+"\nТест 1:")
output(reading_file("list_of_names1"))
print(10*"---------------"+"\nТест 2:")
output(reading_file("list_of_names2"))
print(10*"---------------"+"\nТест 3:")
output(reading_file("list_of_names3"))
print(10*"---------------"+"\nТест 4:")
output(reading_file("list_of_names4"))
print(10*"---------------"+"\nТест 5:")
output(reading_file("list_of_names5"))
#print(without_re_check(file))