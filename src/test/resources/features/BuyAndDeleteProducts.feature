Feature: Proceso de compra en Swag Labs

    Scenario Outline: Compra exitosa con gestión del carrito
        Given Given que el usuario inicia sesión en Swag Labs con "<usuario>" y "<password>"
        When ordena los productos por "<criterio>"
        And agrega los siguientes productos al carrito:
            | Producto              |
            | <producto1>           |
            | <producto2>           |
            | <producto3>           |
        And revisa el carrito de compras
        And elimina "<producto_eliminado>" del carrito
        And verifica que en el carrito solo quedan los productos esperados
        And procede al checkout
        And ingresa los datos del usuario:
            | Nombre   | Apellido   | Código Postal   |
            | <nombre> | <apellido> | <codigo_postal> |
        And confirma el pedido
        Then el sistema debe mostrar un mensaje de "Compra realizada con éxito"
        And el total de la compra debe ser "<total>"

        Examples:
            | usuario       | password      | criterio | producto1                    | producto2              | producto3               | producto_eliminado       | nombre  | apellido | codigo_postal | total  |
            | standard_user | secret_sauce  | lohi     | Sauce Labs Onesie            | Sauce Labs Backpack    | Sauce Labs Bike Light   | Sauce Labs Bolt T-Shirt  | María   | López    | 54321         | 45.98  |
            | standard_user | secret_sauce  | za       | Sauce Labs Bolt T-Shirt      | Sauce Labs Bike Light  | Sauce Labs Backpack     | Sauce Labs Backpack      | María   | López    | 54321         | 45.98  |

