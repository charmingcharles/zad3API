# zad3API

API to jest oparte na innym API do którego link znajduje się tutaj
[API](https://github.com/klesniewski50/zad2API)
[dokumentacja](https://github.com/klesniewski50/zad2API#readme)

Stworzone przeze mnie API przyjmuje jeden paramentr:
* text - tekst dla którego chcemy otrzymać zwracane argumenty

Stworzene przeze mnie API zwraca następujące arguemty:
* original-text - oryginalny tekst
* length - długość tekstu
* lowercase-count - zliczenie ilości wystąpień małej litery
* uppercase-count - zliczenie ilości wystąpień wielkiej litery
* special-signs-count - zliczenie ilości wystąpień znaków specjalnych
* numbers-count - zliczenie ilości wystąpień cyfr

Może to zrobić w 4 różnych formatach:
* tekst
* [XML](https://www.w3.org/XML/)
* [JSON](https://www.json.org/json-en.html)
* [CSV](https://pl.wikipedia.org/wiki/CSV_(format_pliku))

Przykładowe wywołanie jeśli chcemy otrzymać rezulatat w postaci tekstowej:
```
http://localhost:8090/textresult?text=Karol
```
Przykładowa zwracana wartość:
```
lowercase-count = 4
special-signs-count = 0
numbers-count = 0
uppercase-count = 1
length = 5
original-text = Karol
```

Przykładowe wywołanie jeśli chcemy otrzymać rezulatat w postaci XML:
```
http://localhost:8090/xmlresult?text=Karol
```
Przykładowa zwracana wartość:
```
<map>
<entry>
<string>lowercase-count</string>
<string>4</string>
</entry>
<entry>
<string>special-signs-count</string>
<string>0</string>
</entry>
<entry>
<string>numbers-count</string>
<string>0</string>
</entry>
<entry>
<string>uppercase-count</string>
<string>1</string>
</entry>
<entry>
<string>length</string>
<string>5</string>
</entry>
<entry>
<string>original-text</string>
<string>Karol</string>
</entry>
</map>
```

Przykładowe wywołanie jeśli chcemy otrzymać rezulatat w postaci JSON:
```
http://localhost:8090/jsonresult?text=Karol
```
Przykładowa zwracana wartość:
```
{"lowercase-count":"4","special-signs-count":"0","numbers-count":"0","uppercase-count":"1","length":"5","original-text":"Karol"}
```

Przykładowe wywołanie jeśli chcemy otrzymać rezulatat w postaci CSV:
```
http://localhost:8090/csvresult?text=Karol
```
Przykładowa zwracana wartość:
```
lowercase-count;4
special-signs-count;0
numbers-count;0
uppercase-count;1
length;5
original-text;Karol
```