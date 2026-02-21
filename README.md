## Visão geral

Este documento consolida os aprendizados práticos do curso a partir dos projetos presentes no repositório, com foco especial em:

- **Engenharia de Software** (organização de código, modelagem, regras de negócio, legibilidade e evolução).
- **Complexidade de algoritmos (Big O)** para tomadas de decisão de estrutura de dados.
- **Estruturas de dados e Collections** em Java (`Array`, `List`, `HashMap`, `Stream`).

Projetos analisados:

1. `CursoJava10x` (Banco Konoha)
2. `J10x` (Streams API com ninjas)
3. `JavaNinja` (cadastro com `Array`)
4. `UEC` (simulação de luta com POO)

---

## 1) Engenharia de Software aplicada nos projetos

### 1.1 Modelagem orientada a objetos (POO)

O repositório exercita muito bem os pilares da POO:

- **Abstração + contrato**: `Conta` define operações essenciais (`depositar`, `consultarSaldo`) para qualquer tipo de conta.
- **Herança**: `ContaBancaria` centraliza estado e comportamento comum; subclasses especializam regra de depósito.
- **Polimorfismo**: `ContaCorrente` e `ContaPoupanca` implementam `depositar` de forma diferente (com e sem taxa).
- **Encapsulamento**: atributos privados e controle por getters/setters, inclusive com regra derivada (`categoria` por peso em `Lutador`).

**Lição de engenharia**: quando o domínio muda (ex.: nova `ContaSalario`), a arquitetura favorece extensão sem quebrar o restante do sistema.

### 1.2 Separação de responsabilidades

No módulo bancário existe uma separação clara:

- Classes de **domínio**: `ContaBancaria`, `ContaCorrente`, `ContaPoupanca`, `TipoConta`, `Ninja`.
- Classe de **serviço/gestão**: `BancoKonoha` (adicionar, buscar, filtrar e transferir contas).
- Classe de **interface de uso (console)**: `Main`.

**Lição de engenharia**: separar UI de regra de negócio reduz acoplamento e facilita testes futuros.

### 1.3 Validação de regras de negócio

Exemplos de regras importantes já aplicadas:

- Nome não vazio no cadastro de conta.
- Impedimento de transferência para a mesma conta.
- Valor positivo para depósito/transferência.
- Verificação de saldo antes de transferir.

**Lição de engenharia**: regra de negócio deve ser explícita e próxima do fluxo onde o erro pode ocorrer para evitar estados inválidos.

### 1.4 Evolução incremental do código

Os projetos mostram uma trilha natural de maturidade:

1. Começa com estruturas básicas (`Array` fixo em `JavaNinja`).
2. Evolui para `List` e `Stream` (`J10x`).
3. Avança para arquitetura de domínio com múltiplas classes e repositório em memória (`CursoJava10x`).
4. Pratica composição/agregação e simulação de estados (`UEC`).

**Lição de engenharia**: evolução de software é gradual — primeiro resolve, depois estrutura, depois otimiza e mantém.

---

## 2) Big O na prática do repositório

> Big O aqui é usado como ferramenta de decisão de design, especialmente para busca e iteração.

### 2.1 `Array` (JavaNinja)

- Inserção em posição controlada: **O(1)** (quando há índice livre já conhecido).
- Busca por nome sem índice: **O(n)**.
- Listagem completa: **O(n)**.

**Impacto**: funciona para volume pequeno e fixo, mas perde escalabilidade e flexibilidade.

### 2.2 `ArrayList` (CursoJava10x / J10x)

- Inserção no final: **O(1) amortizado**.
- Acesso por índice: **O(1)**.
- Busca por varredura (`for`, `stream().filter()`): **O(n)**.
- Ordenação (`sorted`): **O(n log n)**.

**Impacto**: ótima estrutura padrão para coleções dinâmicas quando busca por chave não é o principal gargalo.

### 2.3 `HashMap` (CursoJava10x)

- Inserção por chave: **O(1) médio**.
- Busca por chave (`get(id)`): **O(1) médio**.
- Pior caso teórico: **O(n)** (colisões extremas), mas incomum em uso normal.

**Impacto**: escolha correta para lookup de conta por número/ID, reduzindo custo de busca comparado a varredura em lista.

### 2.4 Streams API (J10x)

- `filter`, `map`, `forEach`: tipicamente **O(n)**.
- `max`: **O(n)**.
- `sorted`: **O(n log n)**.

**Impacto**: melhora expressividade e legibilidade em processamento de coleções, mantendo custo algorítmico esperado.

---

## 3) Estruturas de dados e Collections estudadas

### 3.1 `Array`

Usado no desafio inicial para reforçar:

- limite fixo de capacidade,
- controle manual de índice,
- noção de memória contígua e estrutura linear.

### 3.2 `List` / `ArrayList`

Usado para:

- armazenar entidades de forma dinâmica,
- iterar, ordenar e filtrar,
- base para pipelines de transformação com Stream.

### 3.3 `HashMap`

Usado no Banco Konoha para mapear:

- `numeroDaConta -> ContaBancaria`.

Combina bem com `List`: uma para iteração global, outra para acesso rápido por chave.

### 3.4 Streams + Lambda + Method Reference

Aplicado no módulo `J10x` com:

- `filter` por aldeia,
- `sorted` por idade/nome,
- `map` para projeção (`Ninjas::getNome`),
- `max` para extremo (ninja mais velho).

**Lição central**: separar *o que fazer* do *como iterar* torna o código mais declarativo.

---

## 4) Aprendizados por projeto

### 4.1 CursoJava10x (Banco Konoha)

**Aprendizados técnicos**

- Modelagem de domínio bancário com especialização de conta.
- Aplicação de interface + classe abstrata para reduzir duplicação.
- Uso combinado de `List` e `HashMap` para diferentes padrões de acesso.
- Implementação de operações de negócio: depósito, saldo, transferência.

**Aprendizados de engenharia**

- Importância de validações de entrada.
- Benefício de centralizar regras no serviço (`BancoKonoha`).
- Potencial para refatoração contínua (nomes, regras de duplicidade, fluxo de menu).

### 4.2 J10x (Streams)

**Aprendizados técnicos**

- Prática de operações funcionais em coleção.
- Comparadores customizados para ordenação.
- Transformação de objeto para atributo (`map`).

**Aprendizados de engenharia**

- Código mais legível para consultas e relatórios em memória.
- Boa preparação para APIs, dados tabulares e processamento de listas maiores.

### 4.3 JavaNinja (Array + controle de fluxo)

**Aprendizados técnicos**

- Fundamentos de `Scanner`, laços e `switch`.
- Gerenciamento simples de estado (`listadeninjas`).

**Aprendizados de engenharia**

- Entendimento da base antes de introduzir abstrações mais avançadas.
- Clareza de fluxo interativo de console.

### 4.4 UEC (Simulação de luta)

**Aprendizados técnicos**

- Encapsulamento e regra derivada automática (`setPeso` define `categoria`).
- Colaboração entre objetos (`Luta` coordena `Lutador`).
- Simulação de eventos com aleatoriedade.

**Aprendizados de engenharia**

- Estado da aplicação evolui por transições explícitas (ganhar/perder/empatar).
- Separar entidade (`Lutador`) de orquestração (`Luta`) é um padrão reutilizável.

---

## 5) Boas práticas de engenharia reforçadas no curso

- **Modelar com intenção de domínio**, não apenas “fazer funcionar”.
- **Escolher estrutura de dados conforme padrão de acesso** (iterar vs buscar por chave).
- **Pensar em complexidade** cedo para evitar gargalos no futuro.
- **Escrever código evolutivo**: primeiro simples, depois refatorado.
- **Manter responsabilidades separadas** para facilitar manutenção e testes.
