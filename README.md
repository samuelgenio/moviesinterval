# Movies Interval
API RESTful para identificar maior e menor intervalo entre vencedores de premios

### Instruções

Para execução é necessário existir um arquivo com o nome 'movielist.csv' na raiz do projeto.

* Para testar

```
mvn test
```

* Para executar

```
mvn spring-boot:run
```

acessar url http://localhost:8080/producers

Na URL será mostrado o retorno no seguinte formato, o primeiro registro sempre mostrará o produtor que obteve mais rápido dois prêmios consecutivos, já segundo mostra o produtor que demorou mais tempo a conseguir dois prêmios.

```json
[

    {
        "id": 127,
        "year": 1,
        "producer": "Joel Silver",
        "winner": true
    },
    {
        "id": 2,
        "year": 45,
        "producer": "Gregory Goodman",
        "winner": true
    }

]
```
