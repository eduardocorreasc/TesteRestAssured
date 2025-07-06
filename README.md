Teste feito com Rest Assured e JAVA.

Para executar o teste localmente você precisa de:
  Java 8 ou superior instalado na sua máquina
  IDE compatível com Java (exemplo: IntelliJ IDEA, Eclipse)

Com estes requisitos você pode pode executar o arquivo TesteRest.java e ver os resultados dos testes.

Você também pode Executar na pipeline do GitHub Actions.
Como funciona:
  A pipeline CI é configurada para rodar automaticamente os testes toda vez que um push for feito na branch principal.
  Para executar manualmente, acesse a aba Actions no seu repositório GitHub.
  Selecione a workflow chamada CI - Java com Maven.
  Clique em Run workflow para iniciar a execução.
  
O que acontece após a execução:
  Os testes serão executados na infraestrutura do GitHub.
  Ao final, um relatório detalhado será gerado e disponibilizado como Artifacts da execução.
  O relatório inclui os testes realizados, resultados (passaram ou falharam) e detalhes dos erros.

