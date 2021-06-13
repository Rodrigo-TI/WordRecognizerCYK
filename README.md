# WordRecognizerCYK
## **Descrição :**
Este é um programa que utiliza o algoritmo CYK para fazer a verificação de palavras através de uma gramática na forma normal de Chomsky.

## **Instruções de utilização :**

#### Menu
```
1 - Ler o arquivo texto e carregar gramática
2 - Verificar palavra
3 - Mostrar gramática carregada
0 - Finalizar programa
------------------------------------------------
Opção escolhida : 
```
Esse é o único menu que o programa possui, e nele deve-se seguir a ordem :

#### 1. Ler o arquivo texto
Nessa opção, o usuário deverá criar um arquivo txt com o nome "grammar" na pasta do projeto, e no conteúdo do mesmo armazenar uma gramática na forma normal de chomsky, conforme o exemplo abaixo :
```
S => XB | AB
X => AS
A => a
B => b 
```
Em seguida, basta utilizar a opção 1 do menu, que o programa vai armazenar a gramática em memória.

#### 2. Verificar palavra
Agora que o programa já possui a gramática armazenada, basta utilizar a opção 2 do menu para informar uma palavra e o programa utilizar o algoritmo CYK para fazer a verificação sobre a possibilidade de se gerar a palavra informada através da gramática presente no arquivo "grammar.txt".

### 3. Observações
As instruções para utilização do programa estão nos tópicos 1 e 2, mas é importante ressaltar as seguintes observações :
- Caso alguma linha do arquivo "grammar.txt" esteja inválida, a gramática não será carregada
- O programa só funciona com a gramática do arquivo "grammar.txt" presente na forma normal de chomsky
