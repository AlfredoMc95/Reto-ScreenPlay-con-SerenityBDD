
Feature: Intento de compra con usuario bloqueado

    Scenario: Ingreso bloqueado
        Given que el usuario se encuentra en la página de ingreso
        When ingresa con usuario bloqueado
        Then el sistema debe mostrar un mensaje de Usuario bloqueado y no permitir el acceso
