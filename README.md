# sales-report
Ilegra challenge project.

## Descrição:
Criar um sistema de análise de dados de venda que irá importar lotes de arquivos
e produzir um relatório baseado em informações presentes no mesmo.
Existem 3 tipos de dados dentro dos arquivos e eles podem ser distinguidos
pelo seu identificador que estará presente na primeira coluna de cada linha,
onde o separador de colunas é o caractere “ç”.
- Dados do vendedor:
    - Os dados do vendedor possuem o identificador 001 e seguem o seguinte formato: 001çCPFçNameçSalary
- Dados do cliente
  - Os dados do cliente possuem o identificador 002 e seguem o seguinte formato: 002çCNPJçNameçBusiness Area
- Dados de venda
  - Os dados de venda possuem o identificador 003 e seguem o seguinte formato: 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

O sistema deverá ler continuamente todos os arquivos dentro do diretório padrão HOMEPATH/data/in e colocar o arquivo de saída em HOMEPATH/data/out.
No arquivo de saída o sistema deverá possuir os seguintes dados:
- Quantidade de clientes no arquivo de entrada
- Quantidade de vendedores no arquivo de entrada
- ID da venda mais cara
- O pior vendedor (Alterei livremente para melhor vendedor :))

## Requisitos Técnicos:
- O sistema deve rodar continuamente e capturar novos arquivos assim que
eles sejam inseridos no diretório padrão.
- Você tem total liberdade para escolher qualquer biblioteca externa
se achar necessário.

As pastas de entrada de dados e saída de dados podem ser configuradas no application.properties, assim com outras variáveis como segue (name:default value):
- data.folder.in
- data.folder.out
- field.separator: ç
- field.item.separator: ,
- field.item.field.separator: -
- field.type.salesperson: 001
- field.type.client: 002
- field.type.sale: 003
- data.report.filename: salesreport

## Execução
Para executar a aplicação basta rodar no terminal:
```
./gradlew bootRun
```
