Do poprawnego działania aplikacji wymagane jest zainstalowanie RabbitMQ.
Instrukcję instalacji można znaleźć pod adresem: 
https://www.rabbitmq.com/download.html

Aplikacja wymaga również JDK w wersji >=14 oraz Gradle w wersji >=6.3

Przed uruchomieniem aplikacji należy zbudować aplikację poleceniem:

`gradle build`

Klientów poszczególnych aplikacji uruchomić można poleceniem:

`gradle bootRun -Pargs={nazwa_klienta}`

dla przykładu:

`gradle bootRun -Pargs=Car`

Dostępni klienci:

* Car
* Logger
* Monitor
* Driver
* Engineer
* TeamLeader
