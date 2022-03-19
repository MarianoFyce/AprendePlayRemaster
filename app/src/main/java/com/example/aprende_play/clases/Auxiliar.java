package com.example.aprende_play.clases;

public class Auxiliar {

    public static String Pregunta(int N_Pregunta) {
        String cadena = "";
        switch (N_Pregunta) {
            case 1:
                cadena = "Repetir ciertas conductas o tener comportamientos\n" +
                        "inusuales.\n" +
                        "• Tener demasiado interés en ciertas cosas, como en\n" +
                        "objetos en movimiento o partes de objetos.\n" +
                        "• Tener un interés intenso y prolongado en ciertos\n" +
                        "temas, como números, detalles o datos.\n" +
                        "• Molestarse por algún cambio leve de rutina\n" +
                        "o por estar en un entorno nuevo o que los\n" +
                        "estimule demasiado.\n" +
                        "• Hacer poco contacto visual o hacerlo de\n" +
                        "manera errática.\n" +
                        "• Tender a mirar o escuchar menos a las personas a su\n" +
                        "alrededor.\n" +
                        "Rara vez intentar compartir los objetos o actividades que les gustan\n" +
                        "señalándolos o mostrándolos a otros.\n" +
                        "• Responder de forma inusual cuando otras personas muestran ira, angustia\n" +
                        "o afecto.\n" +
                        "• No responder o demorarse para responder a su nombre u otros intentos\n" +
                        "verbales para captar su atención.\n" +
                        "• Tener dificultad para seguir las conversaciones\n" +
                        "• A menudo, hablar por largo tiempo sobre un tema favorito, pero sin permitir\n" +
                        "que otros tengan la oportunidad de responder o sin darse cuenta cuando los\n" +
                        "demás reaccionan con indiferencia.\n" +
                        "• Repetir palabras o frases que escuchan, un comportamiento llamado ecolalia.\n" +
                        "• Usar palabras que parecen extrañas, fuera de lugar o que tienen un\n" +
                        "significado especial que solo entienden los que conocen la forma de\n" +
                        "comunicarse de esa persona.\n" +
                        "• Tener expresiones faciales, movimientos y gestos que no coinciden con lo\n" +
                        "que están diciendo.\n" +
                        "• Tener un tono inusual de voz que puede sonar como si estuvieran cantando\n" +
                        "o un tono monótono y similar al de un robot.\n" +
                        "• Tener problemas para comprender el punto de vista de otra persona, lo que\n" +
                        "les impide predecir o entender las acciones de otras personas.";


                ;
                break;
            case 2:
                cadena = "• Los investigadores están comenzando a identificar los genes que\n" +
                        "pueden aumentar el riesgo de los trastornos del espectro autista.\n" +
                        "• Los trastornos del espectro autista ocurren con más frecuencia en las\n" +
                        "personas con ciertas enfermedades genéticas, como el síndrome del\n" +
                        "cromosoma X frágil o la esclerosis tuberosa.\n" +
                        "• Muchos investigadores se están concentrando en cómo los genes\n" +
                        "interactúan entre sí y con factores ambientales, tales como los\n" +
                        "problemas médicos familiares, la edad de los padres y otros factores\n" +
                        "demográficos, y las complicaciones durante el parto o el embarazo.\n" +
                        "• En la actualidad, no existen estudios científicos que hayan vinculado los\n" +
                        "trastornos del espectro autista con las vacunas.";
                break;
            case 3:
                cadena = "El tratamiento temprano y la atención adecuada pueden\n" +
                        "disminuir los problemas y aumentar la capacidad de una\n" +
                        "persona para aumentar lo máximo posible sus fortalezas y\n" +
                        "aprender nuevas habilidades. Si bien no hay un solo tratamiento\n" +
                        "que sea el mejor para los trastornos del espectro autista, es\n" +
                        "importante tener una colaboración estrecha con el médico para\n" +
                        "encontrar el programa de tratamiento adecuado." +
                        "\nHay unas pocas clases de medicamentos que los médicos pueden\n" +
                        "utilizar para tratar algunos problemas frecuentes de los trastornos\n" +
                        "del espectro autista. Con los medicamentos, una persona con uno\n" +
                        "de estos trastornos puede tener menos problemas de:\n" +
                        "• Irritabilidad.\n" +
                        "• Agresión.\n" +
                        "• Comportamientos repetitivos.\n" +
                        "• Hiperactividad.\n" +
                        "• Problemas de atención.\n" +
                        "• Ansiedad y depresión.";
                break;
            default:
                cadena = "Opcion no valida";
                break;

        }
        return cadena;

    }
}
