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
{
  "min": [
    {
      "producer": "Gregory Goodman",
      "interval": 1,
      "previousWin": 1980,
      "followingWin": 1981
    },
    {
      "producer": "Joel Silver",
      "interval": 1,
      "previousWin": 1990,
      "followingWin": 1991
    }
  ],
  "max": [
    {
      "producer": "Gregory Goodman",
      "interval": 44,
      "previousWin": 1981,
      "followingWin": 2025
    }
  ]
}
```
