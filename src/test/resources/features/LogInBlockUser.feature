
Feature: Intento de compra con usuario bloqueado


    Scenario Outline: Ingreso bloqueado
        Given que el usuario se encuentra en la página de ingreso de Swag Labs
        When ingresa con "<User>" y "<Password>" a la pagina
        Then el sistema debe mostrar un mensaje de Usuario bloqueado y no permitir el acceso

        Examples:
            | User             | Password       |
            | locked_out_user  | secret_sauce   |