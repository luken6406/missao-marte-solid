# Missão Marte Unifor — refatoração SOLID

Base da atividade: [solid-tutorial](https://github.com/marcelobezerra-dotcom/solid-tutorial).

`src/exercicio10/` é a versão original preservada para comparação. A equipe implementará a nova versão em `src/solidexercicio10/`. O [contrato de integração](docs/CONTRATOS.md) define as assinaturas combinadas entre as três partes.

## Executar o original (JDK 17 ou superior)

Na raiz do repositório:

```bash
javac -encoding UTF-8 -d out src/exercicio10/*.java
java -cp out exercicio10.Main
```

O jogo grava o ranking em `ranking.json` na pasta de onde é executado.

## Executar a refatoração (após a integração)

```bash
javac -encoding UTF-8 -d out $(find src/solidexercicio10 -name '*.java')
java -cp out solidexercicio10.Main
```

No PowerShell, compile a versão refatorada com:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse -Filter *.java src/solidexercicio10 | ForEach-Object FullName)
```

Os comandos da versão refatorada só funcionarão após os três componentes serem integrados.

## Entrega em andamento

- [x] Original preservado e contratos combinados.
- [ ] Refatoração completa e testada.
- [ ] `docs/uml/` com diagramas de classes e pacotes (fonte e imagem).
- [ ] `REVISAO-SOLID.md` com observações, testes e prioridades.
- [ ] README final com integrantes, decisões, limitações e instruções conferidas.
