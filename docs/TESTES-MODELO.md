# Resultados dos testes do modelo

Os testes de contrato ficam em
`src/solidexercicio10/model/ModelContractTest.java`.

Comandos executados:

```text
javac -encoding UTF-8 -d out src/solidexercicio10/model/*.java
java -cp out solidexercicio10.model.ModelContractTest
```

Resultado:

```text
model contract tests: OK
```

Regras verificadas:

- Professor vale 10, Engenheiro vale 15 e Astronauta vale 20;
- embarque retorna sucesso quando há capacidade;
- embarque retorna falha quando a nave está cheia;
- passageiro só é removido da missão após embarque bem-sucedido;
- nave respeita os limites do mapa e os comandos `w`, `a`, `s` e `d`;
- inimigo se movimenta em uma das quatro direções sem sair dos limites;
- missão detecta colisões com asteroides;
- missão identifica passageiros ainda não embarcados.

Também foi verificado que o código original em `src/exercicio10/` continua compilando
sem alterações.
