Feature: Proceso de compra en Swag Labs

    Scenario Outline: Compra exitosa con gestión del carrito
        Given Given que el usuario inicia sesión en Swag Labs
        When ordena los productos por "<criterio>"
        And agrega los siguientes productos al carrito:
            | Producto              |
            | <producto1>           |
            | <producto2>           |
            | <producto3>           |
        And revisa el carrito de compras
        And elimina "<producto_eliminado>" del carrito
        And procede al checkout
        And ingresa los datos del usuario:
            | Nombre   | Apellido   | Código Postal   |
            | <nombre> | <apellido> | <código_postal> |
        And confirma el pedido
        Then el sistema debe mostrar un mensaje de pedido confirmando

        Examples:
            | criterio | producto1                    | producto2              | producto3               | producto_eliminado       | nombre  | apellido | código_postal |
            | lohi     | Sauce Labs Onesie            | Sauce Labs Backpack    | Sauce Labs Bike Light   | Sauce Labs Onesie        | María   | López    | 54321         |
            | za       | Sauce Labs Bolt T-Shirt      | Sauce Labs Bike Light  | Sauce Labs Backpack     | Sauce Labs Backpack      | María   | López    | 54321         |

