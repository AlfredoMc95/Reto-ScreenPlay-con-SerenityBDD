Feature: Proceso de compra en Swag Labs

    Scenario Outline: Compra exitosa con gestión del carrito
        Given Given que el usuario inicia sesión en Swag Labs con "<usuario>" y "<password>"
        When ordena los productos por "<criterio>"
        And agrega los siguientes productos al carrito:
            | Producto              | Precio    |
            | <producto1>           | <precio1> |
            | <producto2>           | <precio2> |
            | <producto3>           | <precio3> |
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
            | usuario       | password      | criterio | producto1               | precio1 | producto2             | precio2 | producto3         | precio3 | producto_eliminado     | nombre  | apellido | codigo_postal | total  |
            | standard_user | secret_sauce  | lohi     | Sauce Labs Onesie       | 7.99    | Sauce Labs Bike Light | 9.99    | Sauce Labs T-Shirt | 15.99   | Sauce Labs Onesie      | Juan    | Pérez    | 12345         | 25.98  |
            | standard_user | secret_sauce  | za       | Sauce Labs Backpack     | 29.99   | Sauce Labs Bike Light | 9.99    | Sauce Labs T-Shirt | 15.99   | Sauce Labs Bike Light  | María   | López    | 54321         | 45.98  |

