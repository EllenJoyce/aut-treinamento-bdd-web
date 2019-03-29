# language: pt
Funcionalidade: Registro

  @Sprint1
  Cenario: Realizar Registro
    Dado que eu esteja  na tela de registro
    Quando faço o preenchimento das informações da tela de Register
      | First Name | Last name | Phone         | Email                     | Address       | Address Complement | City      | State Province | Postal code | Country    | User name | Password | Confirm password |
      | Ellen      | Fagundes  | 5511993305293 | ellenjsa@inmetrics.com.br | Rua Inmetrics | Barueri            | São Paulo | SP             |    02943000 | ANTARCTICA | ellenjsa  |   123456 |           123456 |
    Então sou registrado com sucesso
