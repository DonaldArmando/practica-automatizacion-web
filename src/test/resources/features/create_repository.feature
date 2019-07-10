Feature: Crear repositorio en GitLab
    Como desarrollador deseo crear un repositorio con la plantilla de Spring para poder compartir mis proyectos con los demas desarrolladores.

    Scenario: Creacion de un repositorio
        Given Donald quiere crear un repositorio
        When Donald creo el repositorio
        Then Donald debe ver el repositorio creado
