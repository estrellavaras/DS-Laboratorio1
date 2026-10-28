# Convenciones de Git para Java
## 1. Mensajes de commit
Un commit es como un snapshot de una máquina virtual porque guarda cómo estaba mi proyecto en un momento. El mensaje es como el nombre de ese snapshot. Sirve para que cualquiera del equipo o para mi más adelante para saber que cambió sin tener que abrir el código.

### Formato
En clase vimos que el mensaje se escribe así:

`[usuario/Kata-nombre] Descripción`

Primero va mi usuario de GitHub (`estrellavaras`), después el nombre de la rama donde estoy trabajando y al final una frase corta que dice lo que hice.

Buscando información encontré estas reglas:

- Empezar con un verbo en inglés como `Add` (agregar), `Fix` (arreglar), `Update` (actualizar) o `Remove` (quitar).
- Escribirlo como una orden: `Add` y no `Added`. Me ayudó a entender mejor que el mensaje tiene que completar la frase *"Si aplico este commit, va a..."*.
- Que sea corto. El libro oficial de Git dice que la primera línea no debería tener más de 50 letras, como el asunto de un email. Con el formato de la clase queda un poco más largo por el nombre de la rama, así que trato de que la frase del final sea corta.
- Empezar con mayúscula y no poner punto al final.
- Hacer un commit por cada cambio sin mezclar cosas. En el libro de Git dan un ejemplo que me hizo entenderlo fácil habla sobre que no está bien trabajar todo el fin de semana en varias cosas y subir todo junto en un solo commit.
- Si hace falta explicar más primero va el título, después se deja una línea vacía y abajo se cuenta que cambió y por qué.
  
### Ejemplos 
Bien:
- `[estrellavaras/Kata-reversed-strings] Add solution` (agregar la solución)
- `[estrellavaras/Kata-simple-card-game] Fix tie` (arreglar el empate)
- `[estrellavaras/Kata-simple-card-game] Update names` (actualizar los nombres)
  
Mal:
- `cambios`, porque no dice qué cambió.
- `ahora está listo fíjate`, porque no dice qué está listo y le habla a otra persona en vez de contar el cambio.
- `ahora sí funciona`, porque no dice qué se arregló.
- `arreglé el kata`, porque está en español, en pasado y no dice que se arregló.
- `subo todo`, porque mezcla muchos cambios en un solo commit.

Mientras resolvía los katas  escribí `reserved` en lugar de `reversed` en un mensaje de commit. Como todavía no había hecho `push`, lo pude corregir con `git commit --amend`que cambia el mensaje del último commit.


## 2. Nombres de ramas

Para entender mejor qué es una rama, me la imaginé como un camino con un desvío o sea la versión principal sigue igual, yo tomo el desvío para hacer mi trabajo y cuando termino, el desvío se vuelve a unir con el camino principal. Lo bueno es que puedo probar cosas sin miedo a romper nada.

Yo pensaba que una rama era una copia de todo el proyecto, pero leyendo el libro oficial de Git me di cuenta de que no. En realidad es como un señalador que marca un commit y cada vez que hago un commit nuevo, el señalador se mueve solo. Por eso crear una rama es rápido porque no se copia nada.

La rama principal se llama `master` o `main`es la que Git crea sola cuando empezás un proyecto. Antes se usaba más `master`, y ahora GitHub usa `main`, que es la que configuré yo.

Cuando uso `git log --oneline`, aparece `HEAD` que marca en qué rama y en qué commit estoy trabajando en ese momento. Es como el punto azul de Google Maps, que muestra donde estas en ese momento.
### Reglas

En clase vimos estas reglas:

- Hacer una rama por cada kata o tarea.
- Crear la rama siempre desde la rama principal.
- Usar un nombre corto que diga qué se hace en ella, con el formato `usuario/Kata-nombre`.
  
  
Investigando, encontré otras reglas que también se usan:
  
- No usar espacios en el nombre. Para separar palabras se usan guiones (`-`) y la barra (`/`).
- No usar símbolos raros como `!`, `?` o `#`, porque pueden dar problemas en Git.
- Poner el nombre de usuario al principio sirve para saber quién trabaja en cada rama. Por eso siempre usamos `usuario/`.
- En muchos equipos también ponen una palabra al principio que dice qué tipo de trabajo es. Por ejemplo, `feature/` (función nueva) se usa cuando se agrega algo, como `feature/login` para hacer un inicio de sesión, y `bugfix/` (arreglo de error) se usa cuando se corrige algo que no funciona.

Para crear una rama y entrar en ella se usa este comando:

  `git switch -c estrellavaras/Kata-reversed-strings`
  
### Ejemplos

Bien:

- `estrellavaras/Kata-reversed-strings`
- `estrellavaras/Kata-simple-card-game`
- `estrellavaras/Fix-document-format` (la usé para corregir este documento)

Mal (nombres que yo misma podría haber usado antes de aprender las reglas):

- `mi rama`, porque tiene un espacio y no dice de que es.
- `prueba`, porque no se entiende que se está probando.
- `rama1`, porque no dice para que es.

Me di cuenta de que esto es importante sobre todo cuando hay muchas ramas, porque con un buen nombre se encuentra cada trabajo rápido.
## 3. Convenciones de código Java
Las convenciones de código son reglas para que todos escribamos el código de la misma forma. Asi cuando otra persona del equipo lo lee, lo entiende como si lo hubiera escrito ella. Ya conocía las reglas y las buenas prácticas de Programación 1.

### Nombres

En clase repasamos cómo se nombra cada cosa en Java:

- **Clases:** cada palabra empieza con mayúscula. Ejemplo: `Votante`, `PadronElectoral`.
- **Métodos y variables:** la primera palabra en minúscula y las demás con mayúscula. Ejemplo: `edad`, `verificarEdad()`.
- **Constantes:** todo en mayúscula, separado con guion bajo. Ejemplo: `EDAD_MINIMA`.
- **Paquetes:** todo en minúscula. Ejemplo: `com.elecciones.votantes`.

A la forma de las clases se le dice *PascalCase* y a la de los métodos y variables *camelCase*, porque las mayúsculas del medio parecen las jorobas de un camello.

También las clases conviene que sean sustantivos porque representan cosas, por ejemplo `Votante`. En cambio los métodos conviene que empiecen con un verbo, porque hacen algo por ejemplo `verificarEdad()`.

### Formato

En clase vimos tres reglas de formato:

- **Usar siempre llaves** `{ }` en los `if`, `for` y `while`, aunque adentro haya una sola línea. Si después agrego otra línea, no se rompe nada.
- **Una instrucción por línea**, para que se lea fácil.
- **Sangría consistente.** La sangría son los espacios que se dejan al principio de la línea para mostrar qué está adentro de qué. Por ejemplo:
  
```
if (edad >= 16) {
    System.out.println("Puede votar");
}
```

Acá la línea del medio tiene espacios adelante porque está adentro del `if`. Lo importante es usar siempre la misma cantidad de espacios en todo el código.

Además, en la guía de Google encontré que las líneas no deberían pasar los 100 caracteres, para no tener que mover la pantalla hacia el costado.

### Estructura

En la guía de Oracle encontré algunas buenas prácticas para ordenar el código:

- **No escribir números sueltos en el código**, sino guardarlos en una constante con un nombre que explique qué son. Por ejemplo, en vez de escribir `16` en varios lugares, es mejor crear `EDAD_MINIMA = 16`. Así se entiende qué significa ese número y, si algún día cambia, se cambia en un solo lugar.
- **No darle el mismo valor a varias variables en una sola línea**, porque cuesta leerlo.
- **Usar paréntesis cuando hay varias operaciones juntas**, como `if ((edad >= 16) && (tieneDni))`, para que quede claro qué se hace primero.
  
  En Programación 1 también aprendí otras buenas prácticas que sirven para ordenar el código:
  
- **Dividir el programa en métodos chicos**, donde cada uno haga una sola cosa. Por ejemplo, un método `verificarEdad()` que solo revise la edad, y otro aparte que muestre el resultado.
- **No repetir código.** Si hago lo mismo en varios lugares, es mejor crear un método y llamarlo cada vez que lo necesito.
- **Escribir comentarios solo donde hacen falta**, para explicar algo que no se entiende con solo leer el código, sin llenar todo de comentarios.
  
  
Estas reglas son fundamentales ya que nos ayudan a que el código sea más fácil de leer sobre todo cuando trabamos en equipo.


## 4. Referencias
### Mensajes de commit
- [How to Write a Git Commit Message (CBEAMS)](https://cbea.ms/git-commit/)
- [Libro oficial de Git (Pro Git), 5.2 Git en entornos distribuidos - Contribuyendo a un Proyecto]( https://git-scm.com/book/es/v2/Git-en-entornos-distribuidos-Contribuyendo-a-un-Proyecto)
- Material de la clase: Desarrollo de Software 1, Semana 1

### Nombres de ramas

- [Git Branching Naming Convention: Best Practices to Follow (phoenixNAP)]([https://phoenixnap.com/kb/git-branch-name-convention])
- [Libro oficial de Git (Pro Git), 3.1 Ramificaciones en Git - ¿Qué es una rama?](https://git-scm.com/book/es/v2/Ramificaciones-en-Git-%C2%BFQu%C3%A9-es-una-rama%3F)
- Material de la clase: Desarrollo de Software 1, Semana 1

### Convenciones de código Java
- [Google Java Style Guide]( https://google.github.io/styleguide/javaguide.html)
- [Code Conventions for the Java Programming Language: 9. Naming Conventions (Oracle)]( https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
- [Code Conventions for the Java Programming Language: 10. Programming Practices (Oracle)]( https://www.oracle.com/java/technologies/javase/codeconventions-programmingpractices.html)
- Material de la clase: Desarrollo de Software I, Semana 1
  
