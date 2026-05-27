# Sistema de Gestión de Personal para Clínica Privada
# Herencia

La herencia permitió que las clases Medico y Administrativo reutilicen atributos y métodos de la clase Empleado, evitando repetir código.

# Encapsulamiento

Se usaron atributos private y métodos get y set para proteger la información de los empleados.

# Polimorfismo

Se utilizó:

ArrayList<Empleado>

para guardar médicos y administrativos en una misma lista.

# Excepciones

Se aplicó try-catch para controlar errores en:

menú,
conversiones,
ingreso de números.

Esto evita que el programa se cierre inesperadamente.

# Conversiones

Se usaron:

Integer.parseInt()
Double.parseDouble()

para convertir texto a números.

# Validaciones

Se validó:

correo,
teléfono,
edad,
campos vacíos,
cédulas repetidas,
valores negativos.
