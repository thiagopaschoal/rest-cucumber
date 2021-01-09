# language: pt

@AvengerController
Funcionalidade: Validar Funcionamentos da API dos Vingadores

  @AllAvengers
  Cenario: return all avengers
    Entao should return all avengers

  @OneAvenger
  Cenario: return one avengers
    Entao should return one avenger name "captain america"
